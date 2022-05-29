package com.ceiba.horario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import com.ceiba.horario.servicio.testdatabuilder.HorarioTestDataBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioCrearHorarioTest {

    private static Horario horario;
    private static RepositorioHorario repositorioHorario;
    private static ServicioCrearHorario servicioCrearHorario;

    @BeforeAll
    public static void iniciandoObjetos(){
        horario = new HorarioTestDataBuilder().build();
        repositorioHorario = Mockito.mock(RepositorioHorario.class);
    }

    @Test
    @DisplayName("Debería actualizar correctamente en el repositorio")
    void deberiaCrearCorrectamenteEnElRepositorio() {
        // arrange
        Mockito.when(repositorioHorario.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioHorario.existeClasePorId(Mockito.anyLong())).thenReturn(true);
        servicioCrearHorario = new ServicioCrearHorario(repositorioHorario);
        // act
        servicioCrearHorario.ejecutar(horario);
        //assert
        Mockito.verify(repositorioHorario,Mockito.times(1)).crear(horario);
    }
    @Test
    @DisplayName("Debería lanzar una excepción cuando el horario ya existe en el sistema")
    void deberiaLanzarUnaExcepcionCuandoSeValideLaExistenciaDelHorario() {
        // arrange
        Mockito.when(repositorioHorario.existePorId(Mockito.anyLong())).thenReturn(true);
        servicioCrearHorario = new ServicioCrearHorario(repositorioHorario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearHorario.ejecutar(horario), ExcepcionDuplicidad.class,"El horario ya existe en el sistema");
    }
    @Test
    @DisplayName("Debería lanzar una excepción cuando la clase no existe en el sistema")
    void deberiaLanzarUnaExcepcionCuandoSeValideLaExistenciaDeLaClase() {
        // arrange
        Mockito.when(repositorioHorario.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioHorario.existeClasePorId(Mockito.anyLong())).thenReturn(false);
        servicioCrearHorario = new ServicioCrearHorario(repositorioHorario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearHorario.ejecutar(horario), ExcepcionDuplicidad.class,"La clase no existe en el sistema");
    }
}
