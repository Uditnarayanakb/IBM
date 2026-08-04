import express from "express";
import accountRoutes
from "./routes/accountRoutes";


const app = express();
app.use(express.json());
app.use("/account", accountRoutes);
app.listen(8080, () => {
    console.log("Server Started");
});