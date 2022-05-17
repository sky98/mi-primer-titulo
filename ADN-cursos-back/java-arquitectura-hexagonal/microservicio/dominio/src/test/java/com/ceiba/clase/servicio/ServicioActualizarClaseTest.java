package com.ceiba.clase.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.clase.modelo.entidad.Clase;
import com.ceiba.clase.puerto.repositorio.RepositorioClase;
import com.ceiba.clase.servicio.testdatabuilder.ClaseTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarClaseTest {
    private static Clase clase;
    private static RepositorioClase repositorioClase;
    @BeforeAll
    public static void iniciandoObjetos(){
        clase = new ClaseTestDataBuilder().conId(1L).build();
        repositorioClase = Mockito.mock(RepositorioClase.class);
    }
    @Test
    @DisplayName("Debería validar la existencia previa de la clase")
    void deberiaValidarLaExistenciaPreviaDeLaClase() {
        // arrange
        Mockito.when(repositorioClase.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarClase servicioActualizarClase = new ServicioActualizarClase(repositorioClase);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarClase.ejecutar(clase), ExcepcionDuplicidad.class,"La clase no existe en el sistema");
    }
    @Test
    @DisplayName("Debería actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Mockito.when(repositorioClase.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarClase servicioActualizarClase = new ServicioActualizarClase(repositorioClase);
        // act
        servicioActualizarClase.ejecutar(clase);
        //assert
        Mockito.verify(repositorioClase,Mockito.times(1)).actualizar(clase);
    }
}
