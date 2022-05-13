package com.ceiba.docente.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.docente.modelo.entidad.Docente;
import com.ceiba.docente.puerto.repositorio.RepositorioDocente;
import com.ceiba.docente.servicio.testdatabuilder.DocenteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioCrearDocenteTest {

    @Test
    @DisplayName("Debería lanzar una excepción cuando la longitud de la identificación sea menor a 4")
    void deberiaLanzarUnaExepcionCuandoLaLongitudDeLaIdentificacionSeaMenorACuatro() {
        // arrange
        DocenteTestDataBuilder docenteTestDataBuilder = new DocenteTestDataBuilder().conIdentificacion("124");
        // act - assert
        BasePrueba.assertThrows(docenteTestDataBuilder::build, ExcepcionLongitudValor.class, "La identificación debe tener una longitud mayor o igual a 4");
    }

    @Test
    @DisplayName("Debería lanzar una excepción cuando se valide la existencia del Docente")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelDocente() {
        // arrange
        Docente docente = new DocenteTestDataBuilder().conId(1L).build();
        RepositorioDocente repositorioDocente = Mockito.mock(RepositorioDocente.class);
        Mockito.when(repositorioDocente.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioCrearDocente servicioCrearDocente = new ServicioCrearDocente(repositorioDocente);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearDocente.ejecutar(docente), ExcepcionDuplicidad.class,"El docente ya existe en el sistema");
    }
}
