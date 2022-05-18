package com.ceiba.persona.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.puerto.repositorio.RepositorioPersona;
import com.ceiba.persona.servicio.testdatabuilder.PersonaTestDataBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioCrearPersonaTest {

    private static Persona persona;
    private static RepositorioPersona repositorioPersona;
    private static ServicioCrearPersona servicioCrearPersona;

    @BeforeAll
    public static void iniciandoObjetos(){
        persona = new PersonaTestDataBuilder().conId(1L).build();
        repositorioPersona = Mockito.mock(RepositorioPersona.class);
    }

    @Test
    @DisplayName("Debería crear correctamente en el repositorio")
    void deberiaCrearCorrectamenteEnElRepositorio() {
        // arrange
        Mockito.when(repositorioPersona.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioPersona.existePorIdentificacion(Mockito.anyString())).thenReturn(false);
        servicioCrearPersona = new ServicioCrearPersona(repositorioPersona);
        //act
        servicioCrearPersona.ejecutar(persona);
        // assert
        Mockito.verify(repositorioPersona,Mockito.times(1)).crear(persona);
    }

    @Test
    @DisplayName("Debería lanzar una excepción cuando se valide la existencia de la persona")
    void deberiaLanzarUnaExcepcionCuandoSeValideLaExistenciaDeLaPersona() {
        // arrange
        Mockito.when(repositorioPersona.existePorId(Mockito.anyLong())).thenReturn(true);
        servicioCrearPersona = new ServicioCrearPersona(repositorioPersona);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearPersona.ejecutar(persona), ExcepcionDuplicidad.class,"La persona ya existe en el sistema");
    }

    @Test
    @DisplayName("Debería lanzar una excepción cuando se valide la existencia de la persona por su identificación")
    void deberiaLanzarUnaExcepcionCuandoSeValideLaExistenciaDeLaPersonaPorSuIdentificacion() {
        // arrange
        Mockito.when(repositorioPersona.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioPersona.existePorIdentificacion(Mockito.anyString())).thenReturn(true);
        servicioCrearPersona = new ServicioCrearPersona(repositorioPersona);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearPersona.ejecutar(persona), ExcepcionDuplicidad.class,"Numero de identificación ya se encuentra en el sistema");
    }
}
