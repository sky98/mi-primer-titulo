package com.ceiba.clase.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.clase.modelo.entidad.Clase;
import com.ceiba.clase.servicio.testdatabuilder.ClaseTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClaseTest {

    @Test
    @DisplayName("Debería crear correctamente la clase")
    void deberiaCrearCorrectamenteLaClase() {
        // arrange
        //act
        Clase clase = new ClaseTestDataBuilder().conId(1L).build();
        //assert
        assertEquals(1, clase.getId());
        assertEquals(1, clase.getCurso());
        assertEquals(1, clase.getDocente());
    }

    @Test
    void deberiaFallarSinDocenteDeClase() {
        //Arrange
        ClaseTestDataBuilder claseTestDataBuilder = new ClaseTestDataBuilder().conDocente(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    claseTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el docente");
    }

    @Test
    void deberiaFallarSinCursoDeClase() {

        //Arrange
        ClaseTestDataBuilder claseTestDataBuilder = new ClaseTestDataBuilder().conCurso(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    claseTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el curso");
    }
}
