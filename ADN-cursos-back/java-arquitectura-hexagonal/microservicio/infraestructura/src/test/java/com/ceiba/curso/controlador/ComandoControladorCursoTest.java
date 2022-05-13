package com.ceiba.curso.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.curso.comando.ComandoCurso;
import com.ceiba.curso.servicio.testdatabuilder.ComandoCursoTestDataBuilder;
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
@WebMvcTest(ComandoControladorCurso.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorCursoTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Debería crear un curso sin docente")
    void deberiaCrearUnCursoSinDocente() throws Exception{
        // arrange
        ComandoCurso curso = new ComandoCursoTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/cursos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(curso)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }
    @Test
    @DisplayName("Debería crear un curso con docente")
    void deberiaCrearUnCursoConDocente() throws Exception{
        // arrange
        ComandoCurso curso = new ComandoCursoTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/cursos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(curso)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }
    @Test
    @DisplayName("Debería actualizar un curso")
    void deberiaActualizarUnCurso() throws Exception{
        // arrange
        Long id = 1L;
        ComandoCurso curso = new ComandoCursoTestDataBuilder().build();
        // act - assert
        mocMvc.perform(put("/cursos/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(curso)))
                .andExpect(status().isOk());
    }
    @Test
    @DisplayName("Debería eliminar un curso")
    void deberiaEliminarUnCurso() throws Exception {
        // arrange
        Long id = 1L;
        // act - assert
        mocMvc.perform(delete("/cursos/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mocMvc.perform(get("/cursos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }
}
