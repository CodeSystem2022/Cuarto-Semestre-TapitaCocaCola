package utn.estudiantes.servicio;

import utn.estudiantes.modelo.Estudiantes2022;
import utn.estudiantes.modelo.Estudiantes2022;

import java.util.List;

public interface iEstudianteServicio {
    public List<Estudiantes2022>ListarEstudiante();
    public Estudiantes2022 BuscarEstudiantePorId(Integer idestudiante2022);
    public void guardarEstudiante(Estudiantes2022 estudiante);
    public void eliminarEstudiante(Estudiantes2022 estudiante);
}
