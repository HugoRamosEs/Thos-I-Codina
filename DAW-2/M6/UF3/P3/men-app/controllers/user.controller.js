import { request } from 'express';
import '../db/connection.js';
import User from '../db/models/user.schema.js';
import bcrypt from 'bcrypt';
import jsonwebtoken from 'jsonwebtoken';

function createToken(user) {
  const payload = {
    id: user._id,
    email: user.email
  };
  return jsonwebtoken.sign(payload, process.env.JWT_SECRET);
}

// Crear l'objecte
const userManagement = {};

// Mètodes per a la resta de peticions
userManagement.loginUser = async (req, res) => {
  try {
    const userData = req.body;
    const user = await User.findOne({ email: userData.email });
    if (!user) {
      throw new Error("User not found");
    } else {
      const isPasswordValid = await bcrypt.compare(userData.password, user.password);
      if (!isPasswordValid) {
        throw new Error("Incorrect password");
      }

      const payload = {
        id: user._id,
        name: user.name,
        surname: user.surname,
        email: user.email,
      };
      const token = createToken(user);
      res.cookie('token', token, { httpOnly: true });
      res.send(payload);
    }
  } catch (err) {
    res.status(400).json({
      error: err.message || "Error logging in"
    });
  }
};

userManagement.logoutUser = async (req, res) => {
  try {
    res.clearCookie('token');
    res.send("User logged out successfully");
  } catch (err) {
    res.status(400).json({
      error: err.message || "Error logging out"
    });
  }
}

userManagement.registerUser = async (req, res) => {
  try {
    const userData = req.body;
    const validPassword = userData.password.length >= 8 && /[A-Z]/.test(userData.password) && /[!@#$%^&*(),.?":{}|<>]/.test(userData.password);
    const validEmail = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/.test(userData.email);
    if (!validEmail) {
      throw new Error("Invalid email format");
    }
    if (!validPassword) {
      throw new Error("Invalid password format");
    }
    
    const user = new User(userData);
    if (await User.findOne({ email: userData.email })) {
      throw new Error("User already exists");
    } else {
      const salt = await bcrypt.genSalt(10);
      const hashedPassword = await bcrypt.hash(user.password, salt);
      user.password = hashedPassword;
      await user.save();
      res.send("User registered successfully");
    }
  } catch (err) {
    res.status(400).json({
      error: err.message || "Error registering user"
    });
  }
}

// Exportar l'objecte
export default userManagement;