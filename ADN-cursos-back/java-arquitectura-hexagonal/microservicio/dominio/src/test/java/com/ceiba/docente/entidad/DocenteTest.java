package com.ceiba.docente.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.docente.modelo.entidad.Docente;
import com.ceiba.docente.servicio.testdatabuilder.DocenteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DocenteTest {

    @Test
    @DisplayName("Deberia crear correctamente el docente")
    void deberiaCrearCorrectamenteElDocente() {
        // arrange
        //LocalDateTime fechaCreacion = LocalDateTime.now();
        //act
        Docente docente = new DocenteTestDataBuilder().conId(1L).build();
        //assert
        assertEquals(1, docente.getId());
        assertEquals("12345", docente.getNombre());
        assertEquals("12345", docente.getApellido());
        assertEquals("12345", docente.getDireccion());
        assertEquals("12345", docente.getTelefono());
        assertEquals("12345", docente.getCorreoElectronico());
    }

    @Test
    void deberiaFallarSinNombreDeDocente() {

        //Arrange
        DocenteTestDataBuilder docenteTestDataBuilder = new DocenteTestDataBuilder().conNombre(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    docenteTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre del docente");
    }

    @Test
    void deberiaFallarSinApellidoDeDocente() {

        //Arrange
        DocenteTestDataBuilder docenteTestDataBuilder = new DocenteTestDataBuilder().conApellido(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    docenteTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el apellido del docente");
    }

    @Test
    void deberiaFallarSinDireccionDeDocente() {

        //Arrange
        DocenteTestDataBuilder docenteTestDataBuilder = new DocenteTestDataBuilder().conDireccion(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    docenteTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la dirección del docente");
    }

    @Test
    void deberiaFallarSinTelefonoDeDocente() {

        //Arrange
        DocenteTestDataBuilder docenteTestDataBuilder = new DocenteTestDataBuilder().conTelefono(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    docenteTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el telefono del docente");
    }

    @Test
    void deberiaFallarSinCorreoElectronicoDeDocente() {

        //Arrange
        DocenteTestDataBuilder docenteTestDataBuilder = new DocenteTestDataBuilder().conCorreoElectronico(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    docenteTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el correo electronico del docente");
    }

    @Test
    void deberiaFallarSinTamanioIdentificacionDeDocente() {

        //Arrange
        DocenteTestDataBuilder docenteTestDataBuilder = new DocenteTestDataBuilder().conIdentificacion("123").conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    docenteTestDataBuilder.build();
                },
                ExcepcionLongitudValor.class, "La identificación debe tener una longitud mayor o igual a 4");
    }
}
