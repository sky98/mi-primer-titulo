package com.ceiba.horario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarHorarioTest {

    private static RepositorioHorario repositorioHorario;
    private static ServicioEliminarHorario servicioEliminarHorario;

    @BeforeAll
    public static void iniciandoObjetos(){
        repositorioHorario = Mockito.mock(RepositorioHorario.class);
    }

    @Test
    @DisplayName("Debería eliminar el horario llamando al repositorio")
    void deberiaEliminarElHorarioLlamandoAlRepositorio() {
        // arrange
        Mockito.when(repositorioHorario.existePorId(Mockito.anyLong())).thenReturn(true);
        servicioEliminarHorario = new ServicioEliminarHorario(repositorioHorario);
        // act
        servicioEliminarHorario.ejecutar(1l);
        // assert
        Mockito.verify(repositorioHorario, Mockito.times(1)).eliminar(1l);
    }

    @Test
    @DisplayName("Debería validar la existencia previa del horario")
    void deberiaValidarLaExistenciaPreviaDelhorario() {
        // arrange
        Mockito.when(repositorioHorario.existePorId(Mockito.anyLong())).thenReturn(false);
        servicioEliminarHorario = new ServicioEliminarHorario(repositorioHorario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarHorario.ejecutar(1L), ExcepcionDuplicidad.class,"No se encuentra registro en el sistema");
    }
}
