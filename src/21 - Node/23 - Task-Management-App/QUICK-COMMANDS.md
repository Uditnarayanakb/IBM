# ⚡ QUICK COMMANDS REFERENCE

## 🚀 Start MongoDB with Docker

```powershell
docker-compose up -d
```

✅ MongoDB running on localhost:27017

---

## ▶️ Start Application

```powershell
npm start
```

✅ Server running on http://localhost:3001

---

## 🧪 Run Tests

```powershell
npm test
```

✅ 10 tests pass

---

## 📡 API ENDPOINTS

### Register User
```powershell
POST http://localhost:3001/users/register
```

Body:
```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "password123",
  "age": 30
}
```

---

### Login
```powershell
POST http://localhost:3001/users/login
```

Body:
```json
{
  "email": "john@example.com",
  "password": "password123"
}
```

Returns: `token` (use in Authorization header)

---

### Create Task
```powershell
POST http://localhost:3001/tasks
Header: Authorization: Bearer [TOKEN]
```

Body:
```json
{
  "description": "My task",
  "priority": "high"
}
```

---

### Get All Tasks
```powershell
GET http://localhost:3001/tasks
Header: Authorization: Bearer [TOKEN]
```

**With Filters**:
```
?completed=true
?priority=high
?sortBy=createdAt:desc
?page=1&limit=10
```

---

### Get Single Task
```powershell
GET http://localhost:3001/tasks/[TASK_ID]
Header: Authorization: Bearer [TOKEN]
```

---

### Update Task
```powershell
PATCH http://localhost:3001/tasks/[TASK_ID]
Header: Authorization: Bearer [TOKEN]
```

Body:
```json
{
  "completed": true,
  "priority": "low"
}
```

---

### Delete Task
```powershell
DELETE http://localhost:3001/tasks/[TASK_ID]
Header: Authorization: Bearer [TOKEN]
```

---

## 🐳 Docker Commands

### Check if running
```powershell
docker ps
```

### Stop MongoDB
```powershell
docker-compose down
```

### View logs
```powershell
docker logs task-management-mongodb
```

### Restart
```powershell
docker-compose restart
```

---

## 📂 Project Structure

```
src/
├── app.js                    # Main Express app
├── db/mongoose.js            # MongoDB connection
├── models/
│   ├── user.js              # User model (password hashing + JWT)
│   └── task.js              # Task model (validation)
├── middleware/
│   └── auth.js              # JWT authentication
├── routers/
│   └── task.js              # Task CRUD routes
└── tests/
    └── user.test.js         # Jest tests
```

---

## ✅ All 6 Steps Completed

- [x] Step 1: MongoDB connection (promises)
- [x] Step 2: User model (hashing + JWT)
- [x] Step 3: Task model (schema + validation)
- [x] Step 4: Auth middleware (JWT verification)
- [x] Step 5: Task routes (CRUD + filters)
- [x] Step 6: Testing (Jest + Supertest)

---

## 🎯 Next Steps

1. Start MongoDB: `docker-compose up -d`
2. Install: `npm install`
3. Run: `npm start`
4. Test: `npm test`
5. Use API with Postman/cURL
6. Explore the code
7. Deploy!

---

**Ready to go!** 🚀
