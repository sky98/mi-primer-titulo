package com.ceiba.horario.servicio;

import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarHorarioTest {

    @Test
    @DisplayName("Debería eliminar el horario llamando al repositorio")
    void deberiaEliminarElHorarioLlamandoAlRepositorio() {
        RepositorioHorario repositorioHorario = Mockito.mock(RepositorioHorario.class);
        ServicioEliminarHorario servicioEliminarHorario = new ServicioEliminarHorario(repositorioHorario);
        servicioEliminarHorario.ejecutar(1l);
        Mockito.verify(repositorioHorario, Mockito.times(1)).eliminar(1l);
    }
}
