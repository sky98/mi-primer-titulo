package com.ceiba.alumno.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.alumno.modelo.entidad.Alumno;
import com.ceiba.alumno.servicio.testdatabuilder.AlumnoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlumnoTest {

    @Test
    @DisplayName("Deberia crear correctamente el alumno")
    void deberiaCrearCorrectamenteElAlumno() {
        // arrange
        //LocalDateTime fechaCreacion = LocalDateTime.now();
        //act
        Alumno alumno = new AlumnoTestDataBuilder().conId(1L).build();
        //assert
        assertEquals(1, alumno.getId());
        assertEquals("12345", alumno.getNombre());
        assertEquals("12345", alumno.getApellido());
        assertEquals("12345", alumno.getDireccion());
        assertEquals("12345", alumno.getTelefono());
        assertEquals("12345", alumno.getCorreoElectronico());
    }

    @Test
    void deberiaFallarSinNombreDeAlumno() {

        //Arrange
        AlumnoTestDataBuilder alumno = new AlumnoTestDataBuilder().conNombre(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    alumno.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre del alumno");
    }

    @Test
    void deberiaFallarSinApellidoDeAlumno() {

        //Arrange
        AlumnoTestDataBuilder alumnoTestDataBuilder = new AlumnoTestDataBuilder().conApellido(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    alumnoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el apellido del alumno");
    }

    @Test
    void deberiaFallarSinDireccionDeAlumno() {

        //Arrange
        AlumnoTestDataBuilder alumnoTestDataBuilder = new AlumnoTestDataBuilder().conDireccion(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    alumnoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la dirección del alumno");
    }

    @Test
    void deberiaFallarSinTelefonoDeAlumno() {

        //Arrange
        AlumnoTestDataBuilder alumnoTestDataBuilder = new AlumnoTestDataBuilder().conTelefono(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    alumnoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el telefono del alumno");
    }

    @Test
    void deberiaFallarSinCorreoElectronicoDeAlumno() {

        //Arrange
        AlumnoTestDataBuilder alumnoTestDataBuilder = new AlumnoTestDataBuilder().conCorreoElectronico(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    alumnoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el correo electronico del alumno");
    }

    @Test
    void deberiaFallarSinTamanioIdentificacionDeAlumno() {
        //Arrange
        AlumnoTestDataBuilder alumnoTestDataBuilder = new AlumnoTestDataBuilder().conIdentificacion("123").conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    alumnoTestDataBuilder.build();
                },
                ExcepcionLongitudValor.class, "La identificación debe tener una longitud mayor o igual a 4");
    }
}
