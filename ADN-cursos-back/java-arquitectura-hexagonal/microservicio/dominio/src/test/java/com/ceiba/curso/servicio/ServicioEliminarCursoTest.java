package com.ceiba.curso.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.curso.puerto.repositorio.RepositorioCurso;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarCursoTest {

    private static RepositorioCurso repositorioCurso;
    private static ServicioEliminarCurso servicioEliminarCurso;

    @BeforeAll
    public static void iniciandoObjetos(){
        repositorioCurso = Mockito.mock(RepositorioCurso.class);
    }

    @Test
    @DisplayName("Debería eliminar el curso llamando al repositorio")
    void deberiaEliminarElAlumnoLlamandoAlRepositorio() {
        // arrange
        Mockito.when(repositorioCurso.existePorId(Mockito.anyLong())).thenReturn(true);
        servicioEliminarCurso = new ServicioEliminarCurso(repositorioCurso);
        // act
        servicioEliminarCurso.ejecutar(1l);
        // assert
        Mockito.verify(repositorioCurso, Mockito.times(1)).eliminar(1l);
    }

    @Test
    @DisplayName("Debería validar la existencia previa del curso")
    void deberiaValidarLaExistenciaPreviaDelCurso() {
        // arrange
        Mockito.when(repositorioCurso.existePorId(Mockito.anyLong())).thenReturn(false);
        servicioEliminarCurso = new ServicioEliminarCurso(repositorioCurso);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarCurso.ejecutar(1L), ExcepcionDuplicidad.class,"El curso no existe en el sistema");
    }
}
