package com.ceiba.alumno.controlador;

import com.ceiba.ApplicationMock;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ConsultaControladorAlumno.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ConsultaControladorAlumnoTest {

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia listar los alumnos")
    void deberiaListarAlumnos() throws Exception {
        // arrange
        // act - assert
        mocMvc.perform(get("/alumnos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].identificacion", is("1234")))
                .andExpect(jsonPath("$[0].nombre", is("1234")))
                .andExpect(jsonPath("$[0].apellido", is("1234")))
                .andExpect(jsonPath("$[0].direccion", is("1234")))
                .andExpect(jsonPath("$[0].telefono", is("1234")))
                .andExpect(jsonPath("$[0].correoElectronico", is("1234")))
                .andExpect(jsonPath("$[0].id", is(1)));

    }
}
