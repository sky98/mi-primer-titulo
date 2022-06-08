package com.ceiba.persona.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.base.TipoUsuario;
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
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ConsultaControladorPersona.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ConsultaControladorPersonaTest {

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Debería listar las personas")
    void deberiaListarPersonas() throws Exception {
        // arrange
        // act - assert
        mocMvc.perform(get("/personas")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].identificacion", is("1234")))
                .andExpect(jsonPath("$[0].nombre", is("1234")))
                .andExpect(jsonPath("$[0].apellido", is("1234")))
                .andExpect(jsonPath("$[0].direccion", is("1234")))
                .andExpect(jsonPath("$[0].telefono", is("1234")))
                .andExpect(jsonPath("$[0].correoElectronico", is("1234")))
                .andExpect(jsonPath("$[0].tipo", is(1)))
                .andExpect(jsonPath("$[0].id", is(1)));

    }

    @Test
    @DisplayName("Debería listar los alumnos")
    void deberiaListarAlumnos() throws Exception {
        // arrange
        // act - assert
        mocMvc.perform(get("/personas/alumnos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].identificacion", is("1234")))
                .andExpect(jsonPath("$[0].nombre", is("1234")))
                .andExpect(jsonPath("$[0].apellido", is("1234")))
                .andExpect(jsonPath("$[0].direccion", is("1234")))
                .andExpect(jsonPath("$[0].telefono", is("1234")))
                .andExpect(jsonPath("$[0].correoElectronico", is("1234")))
                .andExpect(jsonPath("$[0].tipo", is(TipoUsuario.ESTUDIANTE.getCode())))
                .andExpect(jsonPath("$[0].id", is(1)));

    }

    @Test
    @DisplayName("Debería listar los docentes")
    void deberiaListarDocentes() throws Exception {
        // arrange
        // act - assert
        mocMvc.perform(get("/personas/docentes")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].identificacion", is("12345")))
                .andExpect(jsonPath("$[0].nombre", is("12345")))
                .andExpect(jsonPath("$[0].apellido", is("12345")))
                .andExpect(jsonPath("$[0].direccion", is("12345")))
                .andExpect(jsonPath("$[0].telefono", is("12345")))
                .andExpect(jsonPath("$[0].correoElectronico", is("12345")))
                .andExpect(jsonPath("$[0].tipo", is(TipoUsuario.DOCENTE.getCode())))
                .andExpect(jsonPath("$[0].id", is(2)));

    }

    @Test
    @DisplayName("Debería obtener docente por el id")
    void deberiaObtenerDocente() throws Exception {
        // arrange
        Long id = 2L;
        // act - assert
        mocMvc.perform(get("/personas/docentes/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}
