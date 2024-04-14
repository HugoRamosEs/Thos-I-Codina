import "../db/connection.js";
import Note from "../db/models/note.schema.js";
import User from "../db/models/user.schema.js";

const noteManagement = {};

noteManagement.createNote = async (req, res) => {
  try {
    const noteData = req.body;
    const user = await User.findById(noteData.author);
    if (!user) {
      throw new Error("User not found");
    }

    noteData.author = user._id;
    const note = new Note(noteData);
    await note.save();
    res.send("Note added successfully");
  } catch (err) {
    res.status(400).json({
      error: err.message
    });
  }
};

noteManagement.readNotes = async (req, res) => {
  try {
    const authorId = req.userId;
    const notes = await Note.find({ author: authorId });
    if (!notes) {
      throw new Error("Notes not found");
    }

    res.send(notes);
  } catch (err) {
    res.status(400).json({
      error: err.message || "Error reading notes"
    });
  }
};

noteManagement.updateNote = async (req, res) => {
  try {
    const noteId = req.params.id.replace(":", "");
    const noteData = req.body;
    const note = await Note.findById(noteId);
    if (!note) {
      throw new Error("Note not found");
    }

    await note.updateOne(noteData);
    res.send("Note updated successfully");
  } catch (err) {
    res.status(400).json({
      error: err.message || "Error updating note",
    });
  }
}

noteManagement.deleteNote = async (req, res) => {
  try {
    const noteId = req.params.id.replace(":", "");
    const note = await Note.findById(noteId);
    if (!note) {
      throw new Error("Note not found");
    }

    // await note.remove();
    await note.deleteOne();
    res.send("Note deleted successfully");
  } catch (err) {
    res.status(400).json({
      error: err.message || "Error deleting note",
    });
  }
}

noteManagement.readById = async (req, res) => {
  try {
    const noteId = req.params.id.replace(":", "");
    const note = await Note.findById(noteId);
    if (!note) {
      throw new Error("Note not found");
    }
    
    res.send(note);
  } catch (err) {
    res.status(400).json({
      error: err.message || "Error reading note",
    });
  }
}

export default noteManagement;
