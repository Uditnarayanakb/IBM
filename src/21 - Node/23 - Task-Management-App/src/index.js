// src/index.js - Main Entry Point
const app = require('./app');

const PORT = process.env.PORT || 3001;

// Start server
app.listen(PORT, () => {
  console.log(`✅ Server running on port ${PORT}`);
  console.log(`📝 Task Management API ready at http://localhost:${PORT}`);
});

module.exports = app;
