# 🚀 COMPLETE SETUP GUIDE WITH DOCKER

## 📋 Step-by-Step Installation & Demo

This guide will walk you through running the Task Management Application with MongoDB using Docker.

---

## **PHASE 1: Installation (One Time)**

### Step 1️⃣: Install Docker
Docker is a containerization tool that runs MongoDB in an isolated environment.

**Download Docker**:
- Go to: https://www.docker.com/products/docker-desktop
- Download for Windows
- Install and restart your computer

**Verify Installation**:
```powershell
docker --version
docker run hello-world
```

---

## **PHASE 2: Start MongoDB with Docker**

### Step 2️⃣: Navigate to Project Folder
```powershell
cd "C:\Users\UditNarayanaKB\OneDrive - IBM\IBM Training\src\23 - Task-Management-App"
```

### Step 3️⃣: Start MongoDB Container
```powershell
docker-compose up -d
```

**What this does**:
- Downloads MongoDB Docker image
- Creates a container named `task-management-mongodb`
- Runs it on port 27017 (local)
- Creates a volume for data persistence

**Verify MongoDB is Running**:
```powershell
docker ps
```

You should see:
```
CONTAINER ID   IMAGE           NAMES
abc123...      mongo:latest    task-management-mongodb
```

---

## **PHASE 3: Run the Application**

### Step 4️⃣: Install Dependencies
```powershell
npm install
```

### Step 5️⃣: Start the Server
```powershell
npm start
```

**Expected Output**:
```
✅ MongoDB connected successfully!
Server running on port 3001
```

Server is ready at: **http://localhost:3001**

---

## **PHASE 4: Run Tests**

### Step 6️⃣: Run Jest Tests
```powershell
npm test
```

**Expected Output**:
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

Tests: 10 passed, 10 total
```

---

## 🧪 DEMONSTRATION: Complete API Workflow

### **Scenario**: Create a task management system for yourself

#### **1. Register User (Sign Up)**

```powershell
$body = @{
    name = "Alice Johnson"
    email = "alice@example.com"
    password = "SecurePass123"
    age = 28
} | ConvertTo-Json

Invoke-WebRequest -Uri "http://localhost:3001/users/register" `
  -Method POST `
  -Headers @{"Content-Type"="application/json"} `
  -Body $body
```

**Response**:
```json
{
  "success": true,
  "user": {
    "_id": "64b7f3c8a1b2c3d4e5f6g7h8",
    "name": "Alice Johnson",
    "email": "alice@example.com"
  },
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

💾 **Save the token**: `eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...`

---

#### **2. Login (Get Token)**

```powershell
$body = @{
    email = "alice@example.com"
    password = "SecurePass123"
} | ConvertTo-Json

Invoke-WebRequest -Uri "http://localhost:3001/users/login" `
  -Method POST `
  -Headers @{"Content-Type"="application/json"} `
  -Body $body
```

**Response**:
```json
{
  "success": true,
  "user": {
    "_id": "64b7f3c8a1b2c3d4e5f6g7h8",
    "name": "Alice Johnson",
    "email": "alice@example.com"
  },
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

✅ **You're authenticated now!**

---

#### **3. Create First Task**

```powershell
$token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..." # Use your token

$body = @{
    description = "Complete MongoDB project"
    priority = "high"
    dueDate = "2026-08-31"
} | ConvertTo-Json

Invoke-WebRequest -Uri "http://localhost:3001/tasks" `
  -Method POST `
  -Headers @{
    "Content-Type" = "application/json"
    "Authorization" = "Bearer $token"
  } `
  -Body $body
```

**Response**:
```json
{
  "success": true,
  "message": "Task created successfully",
  "task": {
    "_id": "64b7f3c9a2b3c4d5e6f7g8h9",
    "description": "Complete MongoDB project",
    "priority": "high",
    "completed": false,
    "dueDate": "2026-08-31",
    "userId": "64b7f3c8a1b2c3d4e5f6g7h8",
    "createdAt": "2026-08-13T10:30:00.000Z"
  }
}
```

📝 **First task created!**

---

#### **4. Create More Tasks**

```powershell
$token = "..." # Your token

# Task 2
$body = @{
    description = "Learn JWT authentication"
    priority = "high"
} | ConvertTo-Json

Invoke-WebRequest -Uri "http://localhost:3001/tasks" `
  -Method POST `
  -Headers @{
    "Content-Type" = "application/json"
    "Authorization" = "Bearer $token"
  } `
  -Body $body

# Task 3
$body = @{
    description = "Write test cases"
    priority = "medium"
} | ConvertTo-Json

Invoke-WebRequest -Uri "http://localhost:3001/tasks" `
  -Method POST `
  -Headers @{
    "Content-Type" = "application/json"
    "Authorization" = "Bearer $token"
  } `
  -Body $body

# Task 4
$body = @{
    description = "Deploy to production"
    priority = "low"
} | ConvertTo-Json

Invoke-WebRequest -Uri "http://localhost:3001/tasks" `
  -Method POST `
  -Headers @{
    "Content-Type" = "application/json"
    "Authorization" = "Bearer $token"
  } `
  -Body $body
```

✅ **4 tasks created in database!**

---

#### **5. Get All Tasks (No Filters)**

```powershell
$token = "..." # Your token

Invoke-WebRequest -Uri "http://localhost:3001/tasks" `
  -Headers @{"Authorization" = "Bearer $token"} | ConvertFrom-Json | ConvertTo-Json
```

**Response**:
```json
{
  "success": true,
  "tasks": [
    {
      "_id": "64b7f3c9a2b3c4d5e6f7g8h9",
      "description": "Complete MongoDB project",
      "priority": "high",
      "completed": false
    },
    {
      "_id": "64b7f3ca...",
      "description": "Learn JWT authentication",
      "priority": "high",
      "completed": false
    },
    // ... more tasks
  ],
  "pagination": {
    "total": 4,
    "page": 1,
    "limit": 10,
    "pages": 1
  }
}
```

✅ **All 4 tasks retrieved!**

---

#### **6. Filter by Priority (High Priority Only)**

```powershell
$token = "..." # Your token

Invoke-WebRequest -Uri "http://localhost:3001/tasks?priority=high" `
  -Headers @{"Authorization" = "Bearer $token"} | ConvertFrom-Json | ConvertTo-Json
```

**Response** (only high priority tasks):
```json
{
  "success": true,
  "tasks": [
    {
      "description": "Complete MongoDB project",
      "priority": "high"
    },
    {
      "description": "Learn JWT authentication",
      "priority": "high"
    }
  ],
  "pagination": {
    "total": 2,
    "page": 1,
    "limit": 10,
    "pages": 1
  }
}
```

🔍 **Filtered to 2 high-priority tasks!**

---

#### **7. Sort Tasks by Date (Newest First)**

```powershell
$token = "..." # Your token

Invoke-WebRequest -Uri "http://localhost:3001/tasks?sortBy=createdAt:desc" `
  -Headers @{"Authorization" = "Bearer $token"} | ConvertFrom-Json | ConvertTo-Json
```

📊 **Tasks sorted newest first!**

---

#### **8. Pagination (2 items per page)**

```powershell
$token = "..." # Your token

# Page 1
Invoke-WebRequest -Uri "http://localhost:3001/tasks?page=1&limit=2" `
  -Headers @{"Authorization" = "Bearer $token"}

# Page 2
Invoke-WebRequest -Uri "http://localhost:3001/tasks?page=2&limit=2" `
  -Headers @{"Authorization" = "Bearer $token"}
```

📄 **Pagination working!**

---

#### **9. Mark Task as Complete**

```powershell
$token = "..." # Your token
$taskId = "64b7f3c9a2b3c4d5e6f7g8h9" # Use your task ID

$body = @{
    completed = $true
} | ConvertTo-Json

Invoke-WebRequest -Uri "http://localhost:3001/tasks/$taskId" `
  -Method PATCH `
  -Headers @{
    "Content-Type" = "application/json"
    "Authorization" = "Bearer $token"
  } `
  -Body $body
```

✅ **Task marked complete!**

---

#### **10. Delete a Task**

```powershell
$token = "..." # Your token
$taskId = "64b7f3ca..." # Use task ID you want to delete

Invoke-WebRequest -Uri "http://localhost:3001/tasks/$taskId" `
  -Method DELETE `
  -Headers @{"Authorization" = "Bearer $token"}
```

🗑️ **Task deleted!**

---

#### **11. Complex Query (High Priority, Not Complete, Newest First, Page 1)**

```powershell
$token = "..." # Your token

Invoke-WebRequest -Uri "http://localhost:3001/tasks?priority=high&completed=false&sortBy=createdAt:desc&page=1&limit=5" `
  -Headers @{"Authorization" = "Bearer $token"}
```

🎯 **Advanced filtering works!**

---

## 📊 What Happened Behind the Scenes

### **Step 1: Registration**
1. Server received email & password
2. **Password hashed** with bcryptjs (10 rounds)
3. User saved to MongoDB `users` collection
4. **JWT token generated** (7-day expiry)

### **Step 2: Authentication**
1. Token sent in `Authorization: Bearer TOKEN` header
2. **Middleware verified** token signature
3. Retrieved user from database
4. Attached user to request object

### **Step 3: Task Creation**
1. Received task description & priority
2. Validated data
3. Saved to MongoDB `tasks` collection
4. Linked to user ID (ownership)
5. Added timestamps (createdAt, updatedAt)

### **Step 4: Filtering & Sorting**
1. Built query filter: `{priority: "high"}`
2. Applied sort: `{createdAt: -1}`
3. Pagination: `skip(0)`, `limit(10)`
4. Executed query in MongoDB
5. Returned paginated results

### **Step 5: Update Task**
1. Found task by ID
2. Verified user ownership
3. Updated fields
4. Auto-updated timestamp
5. Saved to database

---

## 🛠️ Docker Management Commands

### Check if MongoDB is running
```powershell
docker ps
```

### View MongoDB logs
```powershell
docker logs task-management-mongodb
```

### Stop MongoDB
```powershell
docker-compose down
```

### Restart MongoDB
```powershell
docker-compose down
docker-compose up -d
```

### Delete all data
```powershell
docker-compose down -v
docker-compose up -d
```

---

## 🔒 Security Highlights

✅ **Passwords**: Hashed with bcryptjs (cannot be reversed)  
✅ **JWT Tokens**: Signed and verified (cannot be forged)  
✅ **Token Expiry**: 7 days (forces re-authentication)  
✅ **User Ownership**: Only can access own tasks  
✅ **Email Validation**: Must be valid format  
✅ **Password Minimum**: 6 characters required  

---

## 📝 Testing Output Explained

```
✓ Should register a new user successfully
  → User created, password hashed, token generated

✓ Should not register with invalid email
  → Email validation prevents bad emails

✓ Should not register with duplicate email
  → Database prevents duplicate accounts

✓ Should hash password before saving
  → Bcryptjs hashing verified (not plain text)

✓ Should login with correct credentials
  → Password comparison works, token issued

✓ Should return a valid JWT token on login
  → Token has 3 parts (header.payload.signature)
```

---

## ✅ Verification Checklist

- [ ] Docker installed and running
- [ ] MongoDB container started (`docker ps` shows it)
- [ ] Dependencies installed (`npm install` done)
- [ ] Server started (`npm start` shows "connected")
- [ ] Tests passed (`npm test` shows 10/10 ✓)
- [ ] User registered successfully
- [ ] Login returns token
- [ ] Can create tasks with token
- [ ] Can filter and sort tasks
- [ ] Can update and delete tasks

---

## 🚨 Troubleshooting

### MongoDB Connection Failed
```
Error: connect ECONNREFUSED
```
**Fix**: Run `docker-compose up -d`

### Port Already in Use
```
Error: EADDRINUSE :::27017
```
**Fix**: 
```powershell
docker-compose down
docker-compose up -d
```

### Tests Failing
```
MongooseError: Can't call openUri()
```
**Fix**: Ensure MongoDB is running before tests

### Docker Not Found
```
docker: command not found
```
**Fix**: Install Docker Desktop from docker.com

---

## 🎓 What You Learned

1. ✅ MongoDB connection with Mongoose
2. ✅ User authentication with JWT & bcrypt
3. ✅ CRUD operations on tasks
4. ✅ Filtering and sorting queries
5. ✅ Pagination implementation
6. ✅ Testing with Jest & Supertest
7. ✅ Docker containerization
8. ✅ Security best practices
9. ✅ Error handling
10. ✅ RESTful API design

---

**You've built a production-ready application!** 🎉

Now go deploy it! 🚀
