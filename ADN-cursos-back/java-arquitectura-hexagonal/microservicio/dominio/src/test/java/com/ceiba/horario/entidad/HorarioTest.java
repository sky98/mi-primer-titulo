package com.ceiba.horario.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.horario.servicio.testdatabuilder.HorarioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HorarioTest {

    @Test
    @DisplayName("Debería crear correctamente el horario")
    void deberiaCrearCorrectamenteElHorario() {
        // arrange
        //LocalDateTime fechaCreacion = LocalDateTime.now();
        //act
        Horario horario = new HorarioTestDataBuilder().build();
        //assert
        assertEquals(1, horario.getId());
        assertEquals(1, horario.getClase());
        assertEquals(1, horario.getDia());
        assertEquals(8, horario.getHoraInicio());
        assertEquals(2, horario.getCantidadHoras());
    }

    @Test
    void deberiaFallarSinClaseDeHorario() {

        //Arrange
        HorarioTestDataBuilder horarioTestDataBuilder = new HorarioTestDataBuilder().conClase(null);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    horarioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la clase");
    }

    @Test
    void deberiaFallarSinDia() {
        //Arrange
        HorarioTestDataBuilder horarioTestDataBuilder = new HorarioTestDataBuilder().conDia(null);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    horarioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el día");
    }

    @Test
    void deberiaFallarDiaFinDeSemana() {
        //Arrange
        HorarioTestDataBuilder horarioTestDataBuilder = new HorarioTestDataBuilder().conDia(6);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    horarioTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "Día de la clase fuera del rango permitido");
    }

    @Test
    void deberiaFallarSinHorarioInicio() {
        //Arrange
        HorarioTestDataBuilder horarioTestDataBuilder = new HorarioTestDataBuilder().conHoraInicio(null);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    horarioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la hora de inicio de la clase");
    }

    @Test
    void deberiaFallarSinCantidadDeHoras() {
        //Arrange
        HorarioTestDataBuilder horarioTestDataBuilder = new HorarioTestDataBuilder().conCantidadHoras(null);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    horarioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la cantidad de horas de la clase");
    }
    @Test
    void deberiaFallarCantidadDeHorasMenorAUno() {
        //Arrange
        HorarioTestDataBuilder horarioTestDataBuilder = new HorarioTestDataBuilder().conCantidadHoras(0);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    horarioTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "La cantidad de horas debe ser mayor a cero");
    }
    @Test
    void deberiaFallarCantidadDeHorasMayorACuatro() {
        //Arrange
        HorarioTestDataBuilder horarioTestDataBuilder = new HorarioTestDataBuilder().conCantidadHoras(6);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    horarioTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "La cantidad de horas debe tener una valor menor o igual a 4");
    }
    @Test
    void deberiaFallarHoraDeInicioFueraDelRango() {
        //Arrange
        HorarioTestDataBuilder horarioTestDataBuilder = new HorarioTestDataBuilder().conHoraInicio(6);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    horarioTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "Hora inicio fuera del rango permitido");
    }
}
