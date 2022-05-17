package com.ceiba.clase.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.clase.modelo.entidad.Clase;
import com.ceiba.clase.puerto.repositorio.RepositorioClase;
import com.ceiba.clase.servicio.ServicioEliminarClase;
import com.ceiba.clase.servicio.testdatabuilder.ClaseTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarClaseTest {
    private static RepositorioClase repositorioClase;
    private static ServicioEliminarClase servicioEliminarClase;
    @BeforeAll
    public static void iniciandoObjetos(){
        repositorioClase = Mockito.mock(RepositorioClase.class);
    }
    @Test
    @DisplayName("Debería eliminar la clase llamando al repositorio")
    void deberiaEliminarLaClaseLlamandoAlRepositorio() {
        // arrange
        Mockito.when(repositorioClase.existePorId(Mockito.anyLong())).thenReturn(true);
        servicioEliminarClase = new ServicioEliminarClase(repositorioClase);
        // act
        servicioEliminarClase.ejecutar(1l);
        // assert
        Mockito.verify(repositorioClase, Mockito.times(1)).eliminar(1l);

    }
    @Test
    @DisplayName("Debería validar la existencia previa de la clase")
    void deberiaValidarLaExistenciaPreviaDeLaClase() {
        // arrange
        Mockito.when(repositorioClase.existePorId(Mockito.anyLong())).thenReturn(false);
        servicioEliminarClase = new ServicioEliminarClase(repositorioClase);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarClase.ejecutar(1l), ExcepcionDuplicidad.class,"La clase no existe en el sistema");
    }
}
