package com.ceiba.persona.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.puerto.repositorio.RepositorioPersona;
import com.ceiba.persona.servicio.ServicioActualizarPersona;
import com.ceiba.persona.servicio.testdatabuilder.PersonaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarPersonaTest {

    private static Persona persona;
    private static RepositorioPersona repositorioPersona;
    private static  ServicioActualizarPersona servicioActualizarPersona;

    @BeforeAll
    public static void iniciandoObjetos(){
        persona = new PersonaTestDataBuilder().conId(1L).build();
        repositorioPersona = Mockito.mock(RepositorioPersona.class);
    }

    @Test
    @DisplayName("Debería validar la existencia previa de la persona")
    void deberiaValidarLaExistenciaPreviaDeLaPersona() {
        // arrange
        Mockito.when(repositorioPersona.existePorId(Mockito.anyLong())).thenReturn(false);
        // act
        servicioActualizarPersona = new ServicioActualizarPersona(repositorioPersona);
        // assert
        BasePrueba.assertThrows(() -> servicioActualizarPersona.ejecutar(persona), ExcepcionDuplicidad.class,"La persona no existe en el sistema");
    }

    @Test
    @DisplayName("Debería actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Mockito.when(repositorioPersona.existePorId(Mockito.anyLong())).thenReturn(true);
        // act
        servicioActualizarPersona = new ServicioActualizarPersona(repositorioPersona);
        servicioActualizarPersona.ejecutar(persona);
        //assert
        Mockito.verify(repositorioPersona,Mockito.times(1)).actualizar(persona);
    }
}
