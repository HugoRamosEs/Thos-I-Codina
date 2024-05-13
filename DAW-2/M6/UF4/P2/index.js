const express = require("express");
const cors = require("cors");

const app = express();
app.use(cors());
app.use(express.json());

const server = app.listen(3002, () => {
  console.log("Server is running on port 3002.");
});

const io = require("socket.io")(server, {
  cors: {
    origin: "*",
  },
});

io.on("connection", (socket) => {
  console.log("Socket connection established.");

  socket.on("stream", (image) => {
    socket.broadcast.emit("stream", image);
  });
});
