package com.ceiba.docente.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.docente.modelo.entidad.Docente;
import com.ceiba.docente.puerto.repositorio.RepositorioDocente;
import com.ceiba.docente.servicio.testdatabuilder.DocenteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarDocenteTest {

    @Test
    @DisplayName("Deberia validar la existencia previa del docente")
    void deberiaValidarLaExistenciaPreviaDelDocente() {
        // arrange
        Docente docente = new DocenteTestDataBuilder().conId(1L).build();
        RepositorioDocente repositorioDocente = Mockito.mock(RepositorioDocente.class);
        Mockito.when(repositorioDocente.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarDocente servicioActualizarDocente = new ServicioActualizarDocente(repositorioDocente);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarDocente.ejecutar(docente), ExcepcionDuplicidad.class,"El docente no existe en el sistema");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Docente docente = new DocenteTestDataBuilder().conId(1L).build();
        RepositorioDocente repositorioDocente = Mockito.mock(RepositorioDocente.class);
        Mockito.when(repositorioDocente.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarDocente servicioActualizarDocente = new ServicioActualizarDocente(repositorioDocente);
        // act
        servicioActualizarDocente.ejecutar(docente);
        //assert
        Mockito.verify(repositorioDocente,Mockito.times(1)).actualizar(docente);
    }
}
