package com.ceiba.horario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;

public class ServicioActualizarHorario {

    private static final String EL_HORARIO_NO_EXISTE_EN_EL_SISTEMA = "El horario no existe en el sistema";

    private final RepositorioHorario repositorioHorario;

    public ServicioActualizarHorario(RepositorioHorario repositorioHorario) {
        this.repositorioHorario = repositorioHorario;
    }

    public void ejecutar(Horario horario) {
        validarExistenciaPrevia(horario);
        this.repositorioHorario.actualizar(horario);
    }

    private void validarExistenciaPrevia(Horario horario) {
        boolean existe = this.repositorioHorario.existePorId(horario.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_HORARIO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
