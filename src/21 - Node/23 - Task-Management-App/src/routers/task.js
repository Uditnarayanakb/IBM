// Step 5: Task Routes with CRUD, Filtering, Pagination, and Sorting
const express = require('express');
const Task = require('../models/task');
const auth = require('../middleware/auth');

const router = express.Router();

// Create a new task
router.post('/tasks', auth, async (req, res) => {
  try {
    const { description, priority, dueDate } = req.body;

    const task = new Task({
      description,
      priority,
      dueDate,
      userId: req.user._id
    });

    await task.save();
    res.status(201).json({
      success: true,
      message: 'Task created successfully',
      task
    });
  } catch (err) {
    res.status(400).json({ error: err.message });
  }
});

// Get all tasks with filtering, pagination, and sorting
router.get('/tasks', auth, async (req, res) => {
  try {
    const { completed, priority, sortBy, page = 1, limit = 10 } = req.query;

    // Build filter object
    const filter = { userId: req.user._id };

    if (completed !== undefined) {
      filter.completed = completed === 'true';
    }

    if (priority) {
      filter.priority = priority;
    }

    // Determine sort order
    let sortOrder = {};
    if (sortBy) {
      const [field, order] = sortBy.split(':');
      sortOrder[field] = order === 'desc' ? -1 : 1;
    } else {
      sortOrder.createdAt = -1; // Default: newest first
    }

    // Calculate pagination
    const pageNum = parseInt(page);
    const limitNum = parseInt(limit);
    const skip = (pageNum - 1) * limitNum;

    // Get total count
    const total = await Task.countDocuments(filter);

    // Fetch tasks
    const tasks = await Task.find(filter)
      .sort(sortOrder)
      .limit(limitNum)
      .skip(skip);

    res.json({
      success: true,
      tasks,
      pagination: {
        total,
        page: pageNum,
        limit: limitNum,
        pages: Math.ceil(total / limitNum)
      }
    });
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// Get single task by ID
router.get('/tasks/:id', auth, async (req, res) => {
  try {
    const task = await Task.findOne({
      _id: req.params.id,
      userId: req.user._id
    });

    if (!task) {
      return res.status(404).json({ error: 'Task not found' });
    }

    res.json({
      success: true,
      task
    });
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// Update task
router.patch('/tasks/:id', auth, async (req, res) => {
  try {
    const allowedUpdates = ['description', 'completed', 'priority', 'dueDate'];
    const updates = Object.keys(req.body);
    const isValidUpdate = updates.every(update => allowedUpdates.includes(update));

    if (!isValidUpdate) {
      return res.status(400).json({ error: 'Invalid update fields' });
    }

    const task = await Task.findOne({
      _id: req.params.id,
      userId: req.user._id
    });

    if (!task) {
      return res.status(404).json({ error: 'Task not found' });
    }

    updates.forEach(update => task[update] = req.body[update]);
    await task.save();

    res.json({
      success: true,
      message: 'Task updated successfully',
      task
    });
  } catch (err) {
    res.status(400).json({ error: err.message });
  }
});

// Delete task
router.delete('/tasks/:id', auth, async (req, res) => {
  try {
    const task = await Task.findOneAndDelete({
      _id: req.params.id,
      userId: req.user._id
    });

    if (!task) {
      return res.status(404).json({ error: 'Task not found' });
    }

    res.json({
      success: true,
      message: 'Task deleted successfully',
      task
    });
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

module.exports = router;
