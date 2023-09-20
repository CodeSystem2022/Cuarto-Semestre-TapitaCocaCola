import express from "express";
import morgan from "morgan";
import tareasRouter from "./router/tareas.router.js";
import authRoutes from "./router/auth.routes.js";

const app = express();

app.use(morgan("dev"));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));

app.get("/", (req, res) => res.json({ message: "Bienvenido a mi proyecto" }));
app.use('/api',tareasRouter);
app.use('api',authRoutes);

app.get("/test", (req, res, next) => {
  try {
    throw new Error('Error generado por el usuario');
  } catch (error) {
    next(error);
  }
});

app.use((err, req, res, next) => {
  res.status(500).json({
    message: err.message,
  });
});

export default app;
