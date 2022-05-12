package com.ceiba.curso.servicio;

import com.ceiba.curso.puerto.repositorio.RepositorioCurso;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarCursoTest {

    @Test
    @DisplayName("Debería eliminar el curso llamando al repositorio")
    void deberiaEliminarElAlumnoLlamandoAlRepositorio() {
        RepositorioCurso repositorioCurso = Mockito.mock(RepositorioCurso.class);
        ServicioEliminarCurso servicioEliminarCurso = new ServicioEliminarCurso(repositorioCurso);
        servicioEliminarCurso.ejecutar(1l);
        Mockito.verify(repositorioCurso, Mockito.times(1)).eliminar(1l);
    }
}
