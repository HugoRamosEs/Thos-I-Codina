import express from "express";
import cors from "cors";
import userController from "./controllers/user.controller.js";
import noteController from "./controllers/note.controller.js";
import privateRoute from "./middleware/privateRoute.js";
import cookieParser from "cookie-parser";

const app = express();

const corsOptions = {
  origin: "http://localhost:5173",
  credentials: true,
};

app.use(cors(corsOptions));
app.use(express.json());
app.use(cookieParser());

// app.get("/", (req, res) => {
//   res.send("GET Request");
// });
// app.post("/users/login", (req, res) => {
//   res.send("POST Request for Login");
// });

// USER
app.post("/users/login", userController.loginUser);
app.get("/users/logout", userController.logoutUser);
app.post("/users/register", userController.registerUser);

// NOTE
app.post("/notes/create", privateRoute, noteController.createNote);
app.get("/notes/read", privateRoute, noteController.readNotes);
app.put("/notes/update/:id", privateRoute, noteController.updateNote);
app.delete("/notes/delete/:id", privateRoute, noteController.deleteNote);
app.get("/notes/readById/:id", privateRoute, noteController.readById);

app.listen(8080, () => {
  console.log("Server is running on port 8080");
});