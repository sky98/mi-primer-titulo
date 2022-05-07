package com.ceiba.docente.servicio;

import com.ceiba.docente.puerto.repositorio.RepositorioDocente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarDocenteTest {

    @Test
    @DisplayName("Deberia eliminar el docente llamando al repositorio")
    void deberiaEliminarElUsuarioLlamandoAlRepositorio() {
        RepositorioDocente repositorioDocente = Mockito.mock(RepositorioDocente.class);
        ServicioEliminarDocente servicioEliminarDocente = new ServicioEliminarDocente(repositorioDocente);

        servicioEliminarDocente.ejecutar(1l);

        Mockito.verify(repositorioDocente, Mockito.times(1)).eliminar(1l);

    }
}
