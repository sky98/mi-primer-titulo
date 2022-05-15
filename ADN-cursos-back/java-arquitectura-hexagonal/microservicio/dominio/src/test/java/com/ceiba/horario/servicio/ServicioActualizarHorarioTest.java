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

public class ServicioActualizarHorarioTest {

    private static Horario horario;
    private static RepositorioHorario repositorioHorario;

    @BeforeAll
    public static void iniciandoObjetos(){
        horario = new HorarioTestDataBuilder().build();
        repositorioHorario = Mockito.mock(RepositorioHorario.class);
    }

    @Test
    @DisplayName("Debería validar la existencia previa del horario")
    void deberiaValidarLaExistenciaPreviaDelHorario() {
        // arrange
        Mockito.when(repositorioHorario.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarHorario servicioActualizarHorario = new ServicioActualizarHorario(repositorioHorario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarHorario.ejecutar(horario), ExcepcionDuplicidad.class,"El horario no existe en el sistema");
    }

    @Test
    @DisplayName("Debería actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Mockito.when(repositorioHorario.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarHorario servicioActualizarHorario = new ServicioActualizarHorario(repositorioHorario);
        // act
        servicioActualizarHorario.ejecutar(horario);
        //assert
        Mockito.verify(repositorioHorario,Mockito.times(1)).actualizar(horario);
    }
}
