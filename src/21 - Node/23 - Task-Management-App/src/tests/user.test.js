// Step 6: Jest Tests with Supertest for User Routes
const request = require('supertest');
const mongoose = require('mongoose');
const User = require('../models/user');
const app = require('../index');

// Database URL for testing
const TEST_DB_URL = 'mongodb://localhost:27017/task-management-app-test';

describe('User Registration and Login Tests', () => {
  // Setup: Connect to test database
  beforeAll(async () => {
    // Disconnect from main app connection if exists
    if (mongoose.connection.readyState !== 0) {
      await mongoose.disconnect();
    }
    
    // Connect to test database
    await mongoose.connect(TEST_DB_URL, {
      useNewUrlParser: true,
      useUnifiedTopology: true
    });
  });

  // Cleanup: Clear database and close connection after tests
  afterAll(async () => {
    await User.deleteMany({});
    await mongoose.disconnect();
  }, 15000); // Increase timeout to 15 seconds

  describe('POST /users/register', () => {
    test('Should register a new user successfully', async () => {
      const res = await request(app)
        .post('/users/register')
        .send({
          name: 'John Doe',
          email: 'john@example.com',
          password: 'password123',
          age: 30
        });

      expect(res.statusCode).toBe(201);
      expect(res.body.success).toBe(true);
      expect(res.body.user).toHaveProperty('_id');
      expect(res.body.user.email).toBe('john@example.com');
      expect(res.body).toHaveProperty('token');
      expect(res.body.token).toBeTruthy();
    });

    test('Should not register with invalid email', async () => {
      const res = await request(app)
        .post('/users/register')
        .send({
          name: 'Jane Doe',
          email: 'invalid-email',
          password: 'password123',
          age: 25
        });

      expect(res.statusCode).toBe(400);
      expect(res.body.error).toBeTruthy();
    });

    test('Should not register with duplicate email', async () => {
      const res = await request(app)
        .post('/users/register')
        .send({
          name: 'John Duplicate',
          email: 'john@example.com',
          password: 'password123',
          age: 30
        });

      expect(res.statusCode).toBe(400);
      expect(res.body.error).toBe('Email already registered');
    });

    test('Should not register with short password', async () => {
      const res = await request(app)
        .post('/users/register')
        .send({
          name: 'Test User',
          email: 'test@example.com',
          password: '123',
          age: 25
        });

      expect(res.statusCode).toBe(400);
      expect(res.body.error).toBeTruthy();
    });

    test('Should hash password before saving', async () => {
      await request(app)
        .post('/users/register')
        .send({
          name: 'Hash Test',
          email: 'hash@example.com',
          password: 'password123',
          age: 28
        });

      const user = await User.findOne({ email: 'hash@example.com' }).select('+password');
      expect(user.password).not.toBe('password123'); // Password should be hashed
      expect(user.password.length).toBeGreaterThan(20); // Bcrypt hashes are longer
    });
  });

  describe('POST /users/login', () => {
    test('Should login with correct credentials', async () => {
      const res = await request(app)
        .post('/users/login')
        .send({
          email: 'john@example.com',
          password: 'password123'
        });

      expect(res.statusCode).toBe(200);
      expect(res.body.success).toBe(true);
      expect(res.body).toHaveProperty('token');
      expect(res.body.user.email).toBe('john@example.com');
    });

    test('Should not login with wrong password', async () => {
      const res = await request(app)
        .post('/users/login')
        .send({
          email: 'john@example.com',
          password: 'wrongpassword'
        });

      expect(res.statusCode).toBe(401);
      expect(res.body.error).toBe('Invalid email or password');
    });

    test('Should not login with non-existent email', async () => {
      const res = await request(app)
        .post('/users/login')
        .send({
          email: 'nonexistent@example.com',
          password: 'password123'
        });

      expect(res.statusCode).toBe(401);
      expect(res.body.error).toBe('Invalid email or password');
    });

    test('Should not login without email or password', async () => {
      const res = await request(app)
        .post('/users/login')
        .send({
          email: 'john@example.com'
        });

      expect(res.statusCode).toBe(400);
      expect(res.body.error).toBeTruthy();
    });

    test('Should return a valid JWT token on login', async () => {
      const res = await request(app)
        .post('/users/login')
        .send({
          email: 'john@example.com',
          password: 'password123'
        });

      const token = res.body.token;
      expect(token).toBeTruthy();
      expect(token.split('.').length).toBe(3); // JWT has 3 parts
    });
  });
});

  describe('POST /users/register', () => {
    test('Should register a new user successfully', async () => {
      const res = await request(app)
        .post('/users/register')
        .send({
          name: 'John Doe',
          email: 'john@example.com',
          password: 'password123',
          age: 30
        });

      expect(res.statusCode).toBe(201);
      expect(res.body.success).toBe(true);
      expect(res.body.user).toHaveProperty('_id');
      expect(res.body.user.email).toBe('john@example.com');
      expect(res.body).toHaveProperty('token');
      expect(res.body.token).toBeTruthy();
    });

    test('Should not register with invalid email', async () => {
      const res = await request(app)
        .post('/users/register')
        .send({
          name: 'Jane Doe',
          email: 'invalid-email',
          password: 'password123',
          age: 25
        });

      expect(res.statusCode).toBe(400);
      expect(res.body.error).toBeTruthy();
    });

    test('Should not register with duplicate email', async () => {
      const res = await request(app)
        .post('/users/register')
        .send({
          name: 'John Duplicate',
          email: 'john@example.com',
          password: 'password123',
          age: 30
        });

      expect(res.statusCode).toBe(400);
      expect(res.body.error).toBe('Email already registered');
    });

    test('Should not register with short password', async () => {
      const res = await request(app)
        .post('/users/register')
        .send({
          name: 'Test User',
          email: 'test@example.com',
          password: '123',
          age: 25
        });

      expect(res.statusCode).toBe(400);
      expect(res.body.error).toBeTruthy();
    });

    test('Should hash password before saving', async () => {
      await request(app)
        .post('/users/register')
        .send({
          name: 'Hash Test',
          email: 'hash@example.com',
          password: 'password123',
          age: 28
        });

      const user = await User.findOne({ email: 'hash@example.com' }).select('+password');
      expect(user.password).not.toBe('password123'); // Password should be hashed
      expect(user.password.length).toBeGreaterThan(20); // Bcrypt hashes are longer
    });
  });

  describe('POST /users/login', () => {
    test('Should login with correct credentials', async () => {
      const res = await request(app)
        .post('/users/login')
        .send({
          email: 'john@example.com',
          password: 'password123'
        });

      expect(res.statusCode).toBe(200);
      expect(res.body.success).toBe(true);
      expect(res.body).toHaveProperty('token');
      expect(res.body.user.email).toBe('john@example.com');
    });

    test('Should not login with wrong password', async () => {
      const res = await request(app)
        .post('/users/login')
        .send({
          email: 'john@example.com',
          password: 'wrongpassword'
        });

      expect(res.statusCode).toBe(401);
      expect(res.body.error).toBe('Invalid email or password');
    });

    test('Should not login with non-existent email', async () => {
      const res = await request(app)
        .post('/users/login')
        .send({
          email: 'nonexistent@example.com',
          password: 'password123'
        });

      expect(res.statusCode).toBe(401);
      expect(res.body.error).toBe('Invalid email or password');
    });

    test('Should not login without email or password', async () => {
      const res = await request(app)
        .post('/users/login')
        .send({
          email: 'john@example.com'
        });

      expect(res.statusCode).toBe(400);
      expect(res.body.error).toBeTruthy();
    });

    test('Should return a valid JWT token on login', async () => {
      const res = await request(app)
        .post('/users/login')
        .send({
          email: 'john@example.com',
          password: 'password123'
        });

      const token = res.body.token;
      expect(token).toBeTruthy();
      expect(token.split('.').length).toBe(3); // JWT has 3 parts
    });
  });
});
