package com.ceiba.salon.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.salon.modelo.entidad.Salon;
import com.ceiba.salon.servicio.testdatabuilder.SalonTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalonTest {

    @Test
    @DisplayName("Debería crear correctamente el salon")
    void deberiaCrearCorrectamenteElSalon() {
        // arrange
        //act
        Salon salon = new SalonTestDataBuilder().build();
        //assert
        assertEquals(1, salon.getId());
        assertEquals(1, salon.getAlumno());
        assertEquals(1, salon.getCurso());
    }

    @Test
    void deberiaFallarSinAlumno() {
        //Arrange
        SalonTestDataBuilder salonTestDataBuilder = new SalonTestDataBuilder().conAlumno(null);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    salonTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el alumno");
    }

    @Test
    void deberiaFallarSinCurso() {
        //Arrange
        SalonTestDataBuilder salonTestDataBuilder = new SalonTestDataBuilder().conCurso(null);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    salonTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el curso");
    }
}
