# Task Management Application - Task 9

## 📋 Project Overview

A complete **Task Management Application** built with:
- **Node.js + Express** - REST API
- **MongoDB + Mongoose** - Database
- **JWT Authentication** - Secure endpoints
- **Bcrypt** - Password hashing
- **Jest + Supertest** - Testing
- **Pagination & Sorting** - Task filtering

---

## 📁 Project Structure

```
23 - Task-Management-App/
├── src/
│   ├── app.js                    # Main Express app
│   ├── db/
│   │   └── mongoose.js           # Step 1: MongoDB connection
│   ├── models/
│   │   ├── user.js               # Step 2: User model with hashing & JWT
│   │   └── task.js               # Step 3: Task model
│   ├── middleware/
│   │   └── auth.js               # Step 4: JWT Authentication
│   ├── routers/
│   │   └── task.js               # Step 5: Task routes (CRUD + filters)
│   └── tests/
│       └── user.test.js          # Step 6: Jest & Supertest
├── package.json                   # Dependencies
└── README.md                       # Documentation
```

---

## ✅ Implementation Steps

### **Step 1: MongoDB Connection** (`src/db/mongoose.js`)
- Creates connection with promises (success/failed)
- Handles connection errors gracefully
- Returns promise-based connection

### **Step 2: User Model** (`src/models/user.js`)
- Schema with validation (name, email, password, age)
- **Password Hashing**: Uses bcryptjs (salt rounds: 10)
- **JWT Token Generation**: Creates signed token with 7-day expiry
- Methods: `matchPassword()`, `generateToken()`

### **Step 3: Task Model** (`src/models/task.js`)
- Schema definition (description, completed, priority, dueDate)
- **Validation Rules**: Min/max length, enum values
- **Middleware Hooks**: Auto-update timestamps
- **Indexing**: For performance optimization
- References User model for ownership

### **Step 4: Auth Middleware** (`src/middleware/auth.js`)
- Extracts JWT from Authorization header
- Verifies token signature and expiry
- Attaches user to request object
- Handles token errors (expired, invalid)

### **Step 5: Task Routes** (`src/routers/task.js`)
- **Create**: POST /tasks
- **Read**: GET /tasks (with filters & pagination)
- **Update**: PATCH /tasks/:id
- **Delete**: DELETE /tasks/:id
- **Filtering**: By completed status, priority
- **Sorting**: By any field (ascending/descending)
- **Pagination**: Page number and limit

### **Step 6: Tests** (`src/tests/user.test.js`)
- Jest configuration with Supertest
- Tests for user registration (valid/invalid)
- Tests for user login (success/failure)
- Password hashing verification
- JWT token validation

---

## 🚀 Installation & Setup

### 1. Install Dependencies
```bash
cd "C:\Users\UditNarayanaKB\OneDrive - IBM\IBM Training\src\23 - Task-Management-App"
npm install
```

### 2. Ensure MongoDB is Running
```bash
# MongoDB should be running on localhost:27017
# Windows: Should auto-start as service
# Mac: brew services start mongodb-community
# Linux: sudo systemctl start mongodb
```

### 3. Start the Server
```bash
npm start
```

Output:
```
✅ MongoDB connected successfully!
Server running on port 3001
```

---

## 📡 API Endpoints

### **Authentication**

#### Register User
```bash
POST /users/register
Content-Type: application/json

{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "password123",
  "age": 30
}
```

**Response:**
```json
{
  "success": true,
  "user": {
    "_id": "...",
    "name": "John Doe",
    "email": "john@example.com"
  },
  "token": "eyJhbGc..."
}
```

#### Login User
```bash
POST /users/login
Content-Type: application/json

{
  "email": "john@example.com",
  "password": "password123"
}
```

---

### **Task Management** (Requires authentication with `Authorization: Bearer TOKEN`)

#### Create Task
```bash
POST /tasks
Authorization: Bearer eyJhbGc...
Content-Type: application/json

{
  "description": "Complete project",
  "priority": "high",
  "dueDate": "2026-08-20"
}
```

#### Get All Tasks (with filters & pagination)
```bash
GET /tasks?completed=false&priority=high&sortBy=createdAt:desc&page=1&limit=10
Authorization: Bearer eyJhbGc...
```

**Query Parameters:**
- `completed`: true/false
- `priority`: low, medium, high
- `sortBy`: field:order (e.g., createdAt:desc)
- `page`: Page number (default: 1)
- `limit`: Items per page (default: 10)

#### Get Single Task
```bash
GET /tasks/:id
Authorization: Bearer eyJhbGc...
```

#### Update Task
```bash
PATCH /tasks/:id
Authorization: Bearer eyJhbGc...
Content-Type: application/json

{
  "completed": true,
  "priority": "low"
}
```

#### Delete Task
```bash
DELETE /tasks/:id
Authorization: Bearer eyJhbGc...
```

---

## 🧪 Running Tests

### Run All Tests
```bash
npm test
```

### Watch Mode (auto-rerun on changes)
```bash
npm run test:watch
```

### Test Output
```
PASS  src/tests/user.test.js
  User Registration and Login Tests
    POST /users/register
      ✓ Should register a new user successfully
      ✓ Should not register with invalid email
      ✓ Should not register with duplicate email
      ✓ Should not register with short password
      ✓ Should hash password before saving
    POST /users/login
      ✓ Should login with correct credentials
      ✓ Should not login with wrong password
      ✓ Should not login with non-existent email
      ✓ Should not login without email or password
      ✓ Should return a valid JWT token on login

Tests:       10 passed, 10 total
```

---

## 🔒 Security Features

✅ **Password Hashing**: Bcryptjs with 10 salt rounds  
✅ **JWT Authentication**: 7-day expiry  
✅ **Email Validation**: Validator library  
✅ **Password Minimum Length**: 6 characters  
✅ **Token Verification**: On every protected route  
✅ **Select Fields**: Password not returned by default  

---

## 📊 Database Schema

### Users Collection
```
{
  _id: ObjectId,
  name: String,
  email: String (unique),
  password: String (hashed),
  age: Number,
  createdAt: Date
}
```

### Tasks Collection
```
{
  _id: ObjectId,
  description: String,
  completed: Boolean,
  userId: ObjectId (ref User),
  priority: String (low/medium/high),
  dueDate: Date,
  createdAt: Date,
  updatedAt: Date
}
```

---

## 🧪 Example Workflow

### 1. Register User
```bash
curl -X POST http://localhost:3001/users/register \
  -H "Content-Type: application/json" \
  -d '{"name":"Alice","email":"alice@example.com","password":"secure123","age":28}'
```

Response includes `token`. Save it!

### 2. Create Task
```bash
curl -X POST http://localhost:3001/tasks \
  -H "Authorization: Bearer [TOKEN]" \
  -H "Content-Type: application/json" \
  -d '{"description":"Learn MongoDB","priority":"high"}'
```

### 3. Get Tasks with Filters
```bash
curl "http://localhost:3001/tasks?priority=high&sortBy=createdAt:desc&page=1&limit=5" \
  -H "Authorization: Bearer [TOKEN]"
```

### 4. Update Task
```bash
curl -X PATCH http://localhost:3001/tasks/[TASK_ID] \
  -H "Authorization: Bearer [TOKEN]" \
  -H "Content-Type: application/json" \
  -d '{"completed":true}'
```

### 5. Delete Task
```bash
curl -X DELETE http://localhost:3001/tasks/[TASK_ID] \
  -H "Authorization: Bearer [TOKEN]"
```

---

## ✨ Features Implemented

✅ **MongoDB Connection**: Promise-based with error handling  
✅ **User Model**: With password hashing & JWT generation  
✅ **Task Model**: With schema validation & timestamps  
✅ **Auth Middleware**: JWT verification & user extraction  
✅ **Task Routes**: CRUD operations  
✅ **Filtering**: By status, priority  
✅ **Pagination**: Page & limit support  
✅ **Sorting**: Ascending/descending order  
✅ **Jest Tests**: User registration & login tests  
✅ **Password Hashing**: Bcryptjs implementation  
✅ **JWT Tokens**: Signed tokens with expiry  

---

## 🔧 Environment Variables

Create `.env` file (optional):
```
JWT_SECRET=your-secret-key
MONGODB_URL=mongodb://localhost:27017/task-management-app
PORT=3001
NODE_ENV=development
```

---

## 🐛 Troubleshooting

### MongoDB Connection Failed
- Ensure MongoDB is running on localhost:27017
- Check MongoDB service status

### Tests Failing
- Clear test database: `db.dropDatabase()`
- Ensure MongoDB is running
- Check database permissions

### JWT Token Errors
- Token expired: Re-login to get new token
- Invalid token: Check Authorization header format
- Format: `Authorization: Bearer [TOKEN]`

---

## 📚 Technologies Used

| Technology | Purpose |
|-----------|---------|
| Express.js | REST API Framework |
| MongoDB | NoSQL Database |
| Mongoose | ODM for MongoDB |
| Bcryptjs | Password Hashing |
| JWT | Authentication Tokens |
| Jest | Unit Testing |
| Supertest | HTTP Testing |
| Validator | Email Validation |

---

## 🎯 Next Enhancements

- Add role-based access control (admin, user)
- Implement email verification
- Add password reset functionality
- Create task sharing between users
- Add file attachments to tasks
- Implement real-time notifications
- Add GraphQL API
- Deploy to cloud (Heroku, AWS, etc.)

---

**Status**: ✅ **COMPLETE**  
**Date**: August 13, 2026  
**Version**: 1.0.0
