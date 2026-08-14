// Main Express Application
const express = require('express');
const connectDB = require('./db/mongoose');
const taskRouter = require('./routers/task');
const User = require('./models/user');

const app = express();
const PORT = process.env.PORT || 3001;

// Middleware
app.use(express.json());

// Connect to MongoDB with error handling
let isConnected = false;

connectDB().then(() => {
  isConnected = true;
  console.log('Database connected');
}).catch(err => {
  console.warn('⚠️  MongoDB not available yet. Running in limited mode.');
  console.warn('To fix: Run Docker MongoDB or ensure MongoDB is running on localhost:27017');
});

// User authentication routes
app.post('/users/register', async (req, res) => {
  try {
    const { name, email, password, age } = req.body;

    // Check if user exists
    const existingUser = await User.findOne({ email });
    if (existingUser) {
      return res.status(400).json({ error: 'Email already registered' });
    }

    // Create new user
    const user = new User({ name, email, password, age });
    await user.save();

    // Generate token
    const token = user.generateToken();

    res.status(201).json({
      success: true,
      message: 'User registered successfully',
      user: { _id: user._id, name: user.name, email: user.email },
      token
    });
  } catch (err) {
    res.status(400).json({ error: err.message });
  }
});

app.post('/users/login', async (req, res) => {
  try {
    const { email, password } = req.body;

    if (!email || !password) {
      return res.status(400).json({ error: 'Email and password required' });
    }

    // Find user and select password field
    const user = await User.findOne({ email }).select('+password');

    if (!user) {
      return res.status(401).json({ error: 'Invalid email or password' });
    }

    // Check password
    const isMatch = await user.matchPassword(password);
    if (!isMatch) {
      return res.status(401).json({ error: 'Invalid email or password' });
    }

    // Generate token
    const token = user.generateToken();

    res.json({
      success: true,
      message: 'Login successful',
      user: { _id: user._id, name: user.name, email: user.email },
      token
    });
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// Task routes
app.use('/', taskRouter);

// Health check
app.get('/', (req, res) => {
  res.json({
    message: 'Task Management API',
    endpoints: {
      register: 'POST /users/register',
      login: 'POST /users/login',
      createTask: 'POST /tasks',
      getTasks: 'GET /tasks',
      getTask: 'GET /tasks/:id',
      updateTask: 'PATCH /tasks/:id',
      deleteTask: 'DELETE /tasks/:id'
    }
  });
});

module.exports = app;
