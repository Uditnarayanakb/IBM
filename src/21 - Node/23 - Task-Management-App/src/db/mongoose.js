// Step 1: MongoDB Connection with Promises
const mongoose = require('mongoose');

const connectDB = () => {
  return new Promise((resolve, reject) => {
    mongoose.connect('mongodb://admin:password@localhost:27017/task-management-app?authSource=admin', {
      useNewUrlParser: true,
      useUnifiedTopology: true
    })
    .then(() => {
      console.log('✅ MongoDB connected successfully!');
      resolve();
    })
    .catch(err => {
      console.error('❌ MongoDB connection failed:', err.message);
      reject(err);
    });
  });
};

module.exports = connectDB;
