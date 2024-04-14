import mongoose from 'mongoose';
const { Schema, model } = mongoose;

const noteSchema = new Schema({
    title: { 
        type: String,
        required: [true, 'Title is required']
    },
    content: {
        type: String,
        required: [true, 'Content is required']
    },
    status: {
        type: String,
        enum: ['Draft', 'Published'],
        required: [true, 'Status is required']
    },
    author: {
        type: Schema.Types.ObjectId,
        ref: 'User'
    }
});

export default model ('Note', noteSchema, 'note');