package com.ceiba.base;

import com.ceiba.clase.modelo.entidad.Clase;
import com.ceiba.clase.servicio.testdatabuilder.ClaseTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TipoUsuarioTest {

    @Test
    @DisplayName("Debería devolver tipo de usuario")
    void deberiaDevolverTipoUsuario() {
        // arrange - act - assert
        assertEquals(TipoUsuario.ESTUDIANTE, TipoUsuario.decode(1));
    }

    @Test
    @DisplayName("Debería retornar null")
    void deberiaRetornarNull() {
        // arrange - act - assert
        assertEquals(null, TipoUsuario.decode(3));
    }
}
