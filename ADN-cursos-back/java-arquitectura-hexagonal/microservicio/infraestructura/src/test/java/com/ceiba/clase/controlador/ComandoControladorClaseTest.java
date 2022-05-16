package com.ceiba.clase.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.clase.comando.ComandoClase;
import com.ceiba.clase.servicio.testdatabuilder.ComandoClaseTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorClase.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorClaseTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    /*@Test
    @DisplayName("Debería crear una clase")
    void deberiaCrearUnaClase() throws Exception{
        // arrange
        ComandoClase clase = new ComandoClaseTestDataBuilder().conDocente(1L).conCurso(2L).build();
        // act - assert
        mocMvc.perform(post("/clases")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clase)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }*/
    @Test
    @DisplayName("Debería actualizar un clase")
    void deberiaActualizarUnaClase() throws Exception{
        // arrange
        Long id = 1L;
        ComandoClase clase = new ComandoClaseTestDataBuilder().build();
        // act - assert
        mocMvc.perform(put("/clases/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clase)))
                .andExpect(status().isOk());
    }
    @Test
    @DisplayName("Debería eliminar un clase")
    void deberiaEliminarUnaClase() throws Exception {
        // arrange
        Long id = 1L;
        // act - assert
        mocMvc.perform(delete("/clases/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mocMvc.perform(get("/clases")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }
}
