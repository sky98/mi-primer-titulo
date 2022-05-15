package com.ceiba.horario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import com.ceiba.horario.servicio.testdatabuilder.HorarioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioCrearHorarioTest {

    @Test
    @DisplayName("Debería lanzar una excepción cuando el horario ya existe en el sistema")
    void deberiaLanzarUnaExcepcionCuandoSeValideLaExistenciaDelHorario() {
        // arrange
        Horario horario = new HorarioTestDataBuilder().build();
        RepositorioHorario repositorioHorario = Mockito.mock(RepositorioHorario.class);
        Mockito.when(repositorioHorario.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioCrearHorario servicioCrearHorario = new ServicioCrearHorario(repositorioHorario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearHorario.ejecutar(horario), ExcepcionDuplicidad.class,"El horario ya existe en el sistema");
    }
}
