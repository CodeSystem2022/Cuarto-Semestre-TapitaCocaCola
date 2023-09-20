import { Router } from "express";
import { actualizarTarea, crearTarea, eliminarTarea, listarTare, listarTareas } from "../controllers/tareas.controller.js";

const router = Router();

router.get('/tareas',listarTareas );

router.get('/tareas/:id', listarTare);

router.post('/tareas', crearTarea);

router.put('/tareas/:id', actualizarTarea);

router.delete('/tareas/:id', eliminarTarea);

export default router;
