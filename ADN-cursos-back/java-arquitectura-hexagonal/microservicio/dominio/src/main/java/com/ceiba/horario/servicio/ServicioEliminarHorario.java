package com.ceiba.horario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;

public class ServicioEliminarHorario {

    private static final String EL_HORARIO_NO_EXISTE_EN_EL_SISTEMA = "El horario no existe en el sistema";

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
            throw new ExcepcionDuplicidad(EL_HORARIO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
