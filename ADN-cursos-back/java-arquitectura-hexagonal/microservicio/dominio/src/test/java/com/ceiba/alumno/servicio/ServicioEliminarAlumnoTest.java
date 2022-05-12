package com.ceiba.alumno.servicio;

import com.ceiba.alumno.puerto.repositorio.RepositorioAlumno;
import com.ceiba.docente.puerto.repositorio.RepositorioDocente;
import com.ceiba.docente.servicio.ServicioEliminarDocente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarAlumnoTest {

    @Test
    @DisplayName("Deberia eliminar el alumno llamando al repositorio")
    void deberiaEliminarElAlumnoLlamandoAlRepositorio() {
        RepositorioAlumno repositorioAlumno = Mockito.mock(RepositorioAlumno.class);
        ServicioEliminarAlumno servicioEliminarAlumno = new ServicioEliminarAlumno(repositorioAlumno);

        servicioEliminarAlumno.ejecutar(1l);

        Mockito.verify(repositorioAlumno, Mockito.times(1)).eliminar(1l);

    }
}
