import mongoose from "mongoose";
mongoose.set("sanitizeFilter", true);

// Importar les variables d'entorn
const { DB_USER, DB_PASSWORD, DB_HOST, DB_PORT, DB_NAME } = process.env;

// Crear la url de connexió
// const url = `mongodb://${DB_USER}:${DB_PASSWORD}@${DB_HOST}:${DB_PORT}/${DB_NAME}?
// authSource=admin`;
const url =`mongodb://${DB_USER}:P%2540ssw0rd@${DB_HOST}:${DB_PORT}/${DB_NAME}?authSource=admin`;

// Connexió a MongoDB
mongoose.connect(url);
const connection = mongoose.connection;
connection.once("open", () => {
  console.log("Database is connected");
});
