package com.ceiba.horario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;

public class ServicioEliminarHorario {

    private static final String NO_SE_ENCUENTRA_REGISTRO_EN_EL_SISTEMA = "No se encuentra registro en el sistema";

    private final RepositorioHorario repositorioHorario;

    public ServicioEliminarHorario(RepositorioHorario repositorioHorario) {
        this.repositorioHorario = repositorioHorario;
    }

    public void ejecutar(Long id) {
        validarExistenciaPrevia(id);
        this.repositorioHorario.eliminar(id);
    }

    private void validarExistenciaPrevia(Long horario) {
        boolean existe = this.repositorioHorario.existePorId(horario);
        if(!existe) {
            throw new ExcepcionDuplicidad(NO_SE_ENCUENTRA_REGISTRO_EN_EL_SISTEMA);
        }
    }
}
