package com.ceiba.clase.servicio;

import com.ceiba.clase.puerto.repositorio.RepositorioClase;
import com.ceiba.clase.servicio.ServicioEliminarClase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarClaseTest {
    @Test
    @DisplayName("Debería eliminar la clase llamando al repositorio")
    void deberiaEliminarLaClaseLlamandoAlRepositorio() {
        RepositorioClase repositorioClase = Mockito.mock(RepositorioClase.class);
        ServicioEliminarClase servicioEliminarClase = new ServicioEliminarClase(repositorioClase);

        servicioEliminarClase.ejecutar(1l);

        Mockito.verify(repositorioClase, Mockito.times(1)).eliminar(1l);

    }
}
