# 🚀 Task 9 Quick Start Guide

## 📂 Location
```
C:\Users\UditNarayanaKB\OneDrive - IBM\IBM Training\src\23 - Task-Management-App
```

---

## ⚡ Quick Setup (3 Steps)

### Step 1: Install Dependencies
```bash
cd "C:\Users\UditNarayanaKB\OneDrive - IBM\IBM Training\src\23 - Task-Management-App"
npm install
```
✅ Done! (Already completed)

### Step 2: Start MongoDB
Ensure MongoDB is running:
```bash
# Windows: Should auto-start
# Mac: brew services start mongodb-community
# Linux: sudo systemctl start mongodb
```

### Step 3: Run Server
```bash
npm start
```

Expected output:
```
✅ MongoDB connected successfully!
Server running on port 3001
```

---

## 📋 What's Inside

| File | Purpose | Contains |
|------|---------|----------|
| `src/db/mongoose.js` | Step 1 | MongoDB connection (promises) |
| `src/models/user.js` | Step 2 | User model (hashing + JWT) |
| `src/models/task.js` | Step 3 | Task model (validation) |
| `src/middleware/auth.js` | Step 4 | JWT authentication |
| `src/routers/task.js` | Step 5 | CRUD + filters + pagination |
| `src/tests/user.test.js` | Step 6 | Jest & Supertest |
| `src/app.js` | Main | Express app + routes |

---

## 🔑 Key Features

✅ **Authentication**: JWT tokens (7-day expiry)  
✅ **Password Security**: Bcryptjs hashing (10 rounds)  
✅ **Task Filtering**: By status, priority  
✅ **Pagination**: Page & limit support  
✅ **Sorting**: Any field, ascending/descending  
✅ **Testing**: Jest with Supertest  
✅ **Validation**: Email, password, task fields  

---

## 📡 API Quick Reference

### Register
```bash
POST /users/register
Body: {"name":"John","email":"john@example.com","password":"pass123","age":30}
```

### Login
```bash
POST /users/login
Body: {"email":"john@example.com","password":"pass123"}
Returns: {"token":"..."}
```

### Create Task (need token)
```bash
POST /tasks
Header: Authorization: Bearer [TOKEN]
Body: {"description":"My task","priority":"high"}
```

### Get Tasks (with filters)
```bash
GET /tasks?completed=false&priority=high&sortBy=createdAt:desc&page=1&limit=10
Header: Authorization: Bearer [TOKEN]
```

### Update Task
```bash
PATCH /tasks/[ID]
Header: Authorization: Bearer [TOKEN]
Body: {"completed":true,"priority":"low"}
```

### Delete Task
```bash
DELETE /tasks/[ID]
Header: Authorization: Bearer [TOKEN]
```

---

## 🧪 Run Tests

```bash
npm test
```

Expected: 10 tests pass ✅

---

## 🔒 Security

- Passwords hashed with bcrypt
- JWT tokens signed and verified
- Email validation
- Protected routes require auth
- Token expiry: 7 days

---

## 📊 Database

**Name**: `task-management-app`  
**Collections**: `users`, `tasks`  
**Location**: `mongodb://localhost:27017`

---

## ✅ All Requirements Met

- [x] Step 1: MongoDB connection (promises)
- [x] Step 2: User model (hashing + JWT)
- [x] Step 3: Task model (schema + validation)
- [x] Step 4: Auth middleware (JWT verification)
- [x] Step 5: Task routes (CRUD + filters + pagination)
- [x] Step 6: Tests (Jest + Supertest)

---

## 🎯 Next Steps

1. Test all endpoints with Postman/cURL
2. Run tests: `npm test`
3. Explore the code structure
4. Add more test cases
5. Deploy to production

---

**Ready to go!** 🚀
