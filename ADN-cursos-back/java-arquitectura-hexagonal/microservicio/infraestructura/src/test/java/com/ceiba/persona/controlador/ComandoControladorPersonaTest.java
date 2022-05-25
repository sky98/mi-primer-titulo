package com.ceiba.persona.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.persona.comando.ComandoPersona;
import com.ceiba.persona.controlador.ComandoControladorPersona;
import com.ceiba.persona.servicio.testdatabuilder.ComandoPersonaTestDataBuilder;
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
@WebMvcTest(ComandoControladorPersona.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorPersonaTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Debería crear un persona")
    void deberiaCrearUnPersona() throws Exception{
        // arrange
        ComandoPersona persona = new ComandoPersonaTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/personas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(persona)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    @Test
    @DisplayName("Debería actualizar un persona")
    void deberiaActualizarUnPersona() throws Exception{
        // arrange
        Long id = 1L;
        ComandoPersona persona = new ComandoPersonaTestDataBuilder().build();
        // act - assert
        mocMvc.perform(put("/personas/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(persona)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Debería eliminar una persona")
    void deberiaEliminarUnaPersona() throws Exception {
        // arrange
        Long id = 1L;
        // act - assert
        mocMvc.perform(delete("/personas/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mocMvc.perform(get("/personas")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }
}
