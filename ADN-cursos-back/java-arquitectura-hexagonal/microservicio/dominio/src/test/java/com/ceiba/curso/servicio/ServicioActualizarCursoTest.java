package com.ceiba.curso.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.curso.modelo.entidad.Curso;
import com.ceiba.curso.puerto.repositorio.RepositorioCurso;
import com.ceiba.curso.servicio.testdatabuilder.CursoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarCursoTest {

    private static Curso curso;
    private static RepositorioCurso repositorioCurso;

    @BeforeAll
    public static void iniciandoObjetos(){
        curso = new CursoTestDataBuilder().conId(1L).build();
        repositorioCurso = Mockito.mock(RepositorioCurso.class);
    }

    @Test
    @DisplayName("Debería validar la existencia previa del curso")
    void deberiaValidarLaExistenciaPreviaDelCurso() {
        // arrange
        Mockito.when(repositorioCurso.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarCurso servicioActualizarCurso = new ServicioActualizarCurso(repositorioCurso);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarCurso.ejecutar(curso), ExcepcionDuplicidad.class,"El curso no existe en el sistema");
    }

    @Test
    @DisplayName("Debería actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Mockito.when(repositorioCurso.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarCurso servicioActualizarCurso = new ServicioActualizarCurso(repositorioCurso);
        // act
        servicioActualizarCurso.ejecutar(curso);
        //assert
        Mockito.verify(repositorioCurso,Mockito.times(1)).actualizar(curso);
    }
}
