package com.ceiba.persona.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.persona.puerto.repositorio.RepositorioPersona;
import com.ceiba.persona.servicio.ServicioEliminarPersona;
import com.ceiba.persona.servicio.testdatabuilder.PersonaTestDataBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarPersonaTest {
    private static RepositorioPersona repositorioPersona;
    private static ServicioEliminarPersona servicioEliminarPersona;

    @BeforeAll
    public static void iniciandoObjetos(){
        repositorioPersona = Mockito.mock(RepositorioPersona.class);
    }
    @Test
    @DisplayName("Debería eliminar la persona llamando al repositorio")
    void deberiaEliminarLaPersonaLlamandoAlRepositorio() {
        // arrange
        Mockito.when(repositorioPersona.existePorId(Mockito.anyLong())).thenReturn(true);
        servicioEliminarPersona = new ServicioEliminarPersona(repositorioPersona);
        // act
        servicioEliminarPersona.ejecutar(1L);
        // assert
        Mockito.verify(repositorioPersona, Mockito.times(1)).eliminar(1l);
    }
    @Test
    @DisplayName("Debería lanzar una excepción cuando se valide la existencia de la persona")
    void deberiaLanzarUnaExcepcionCuandoSeValideLaExistenciaDeLaPersona() {
        // arrange
        Mockito.when(repositorioPersona.existePorId(Mockito.anyLong())).thenReturn(false);
        servicioEliminarPersona = new ServicioEliminarPersona(repositorioPersona);
        // act -- assert
        BasePrueba.assertThrows(() -> servicioEliminarPersona.ejecutar(2L), ExcepcionDuplicidad.class,"La persona no existe en el sistema");
    }
}
