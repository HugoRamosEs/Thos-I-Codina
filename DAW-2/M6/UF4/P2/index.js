const express = require('express');
const app = express();
const cors = require('cors');

app.use(cors());
app.use(express.json());

const server = app.listen(3002, () => {
  console.log('Server is running on port 3002.');
});
