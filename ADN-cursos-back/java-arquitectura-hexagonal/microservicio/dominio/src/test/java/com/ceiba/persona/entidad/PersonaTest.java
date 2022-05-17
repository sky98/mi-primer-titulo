package com.ceiba.persona.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.servicio.testdatabuilder.PersonaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonaTest {

    @Test
    @DisplayName("Debería crear correctamente el persona")
    void deberiaCrearCorrectamenteLaPersona() {
        // arrange
        //act
        Persona persona = new PersonaTestDataBuilder().conId(1L).build();
        //assert
        assertEquals(1, persona.getId());
        assertEquals("12345", persona.getNombre());
        assertEquals("12345", persona.getApellido());
        assertEquals("12345", persona.getDireccion());
        assertEquals("12345", persona.getTelefono());
        assertEquals("12345", persona.getCorreoElectronico());
        assertEquals(1, persona.getTipo());
    }

    @Test
    void deberiaFallarSinNombreDePersona() {

        //Arrange
        PersonaTestDataBuilder personaTestDataBuilder = new PersonaTestDataBuilder().conNombre(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    personaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre");
    }

    @Test
    void deberiaFallarSinApellidoDePersona() {
        //Arrange
        PersonaTestDataBuilder personaTestDataBuilder = new PersonaTestDataBuilder().conApellido(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    personaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el apellido");
    }

    @Test
    void deberiaFallarSinDireccionDePersona() {
        //Arrange
        PersonaTestDataBuilder personaTestDataBuilder = new PersonaTestDataBuilder().conDireccion(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    personaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la dirección");
    }

    @Test
    void deberiaFallarSinTelefonoDePersona() {
        //Arrange
        PersonaTestDataBuilder personaTestDataBuilder = new PersonaTestDataBuilder().conTelefono(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    personaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el teléfono");
    }

    @Test
    void deberiaFallarSinCorreoElectronicoDePersona() {
        //Arrange
        PersonaTestDataBuilder personaTestDataBuilder = new PersonaTestDataBuilder().conCorreoElectronico(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    personaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el correo electrónico");
    }

    @Test
    void deberiaFallarSinTamanioIdentificacionDePersona() {
        //Arrange
        PersonaTestDataBuilder personaTestDataBuilder = new PersonaTestDataBuilder().conIdentificacion("123").conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    personaTestDataBuilder.build();
                },
                ExcepcionLongitudValor.class, "La identificación debe tener una longitud mayor o igual a 4");
    }
}
