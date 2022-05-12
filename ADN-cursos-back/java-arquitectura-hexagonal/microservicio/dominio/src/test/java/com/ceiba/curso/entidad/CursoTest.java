package com.ceiba.curso.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.curso.modelo.entidad.Curso;
import com.ceiba.curso.servicio.testdatabuilder.CursoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CursoTest {

    @Test
    @DisplayName("Deberia crear correctamente el curso")
    void deberiaCrearCorrectamenteElCurso() {
        // arrange
        //LocalDateTime fechaCreacion = LocalDateTime.now();
        //act
        Curso curso = new CursoTestDataBuilder().conId(1L).build();
        //assert
        assertEquals(1, curso.getId());
        assertEquals("12345", curso.getIdentificacion());
        assertEquals("12345", curso.getNombre());
        assertEquals("12345", curso.getDescripcion());
        assertEquals(2, curso.getHoras());
    }

    @Test
    void deberiaFallarSinIdentificacionDelCurso() {
        //Arrange
        CursoTestDataBuilder cursoTestDataBuilder = new CursoTestDataBuilder().conIdentificacion(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    cursoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la identificación del curso");
    }

    @Test
    void deberiaFallarSinNombreDelCurso() {

        //Arrange
        CursoTestDataBuilder cursoTestDataBuilder = new CursoTestDataBuilder().conNombre(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    cursoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre del curso");
    }

    @Test
    void deberiaFallarSinDescripcionDelCurso() {
        //Arrange
        CursoTestDataBuilder cursoTestDataBuilder = new CursoTestDataBuilder().conDescripcion(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    cursoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la descripción del curso");
    }

    @Test
    void deberiaFallarSinHorasDeCurso() {

        //Arrange
        CursoTestDataBuilder cursoTestDataBuilder = new CursoTestDataBuilder().conHoras(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    cursoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar las horas del curso");
    }

    @Test
    void deberiaFallarTamanioMinimoDeHorasDelCurso() {
        //Arrange
        CursoTestDataBuilder cursoTestDataBuilder = new CursoTestDataBuilder().conHoras(0).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    cursoTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "El valor mínimo de horas es 1");
    }

    @Test
    void deberiaFallarTamanioMaximoDeHorasDelCurso() {
        //Arrange
        CursoTestDataBuilder cursoTestDataBuilder = new CursoTestDataBuilder().conHoras(5).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    cursoTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "El valor máximo de horas es 4");
    }
}
