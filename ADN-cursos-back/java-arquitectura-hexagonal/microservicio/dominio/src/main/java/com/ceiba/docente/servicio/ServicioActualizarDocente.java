package com.ceiba.docente.servicio;

import com.ceiba.docente.modelo.entidad.Docente;
import com.ceiba.docente.puerto.repositorio.RepositorioDocente;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarDocente {

    private static final String EL_DOCENTE_NO_EXISTE_EN_EL_SISTEMA = "El docente no existe en el sistema";

    private final RepositorioDocente repositorioDocente;

    public ServicioActualizarDocente(RepositorioDocente repositorioDocente) {
        this.repositorioDocente = repositorioDocente;
    }

    public void ejecutar(Docente docente){
        validarExistenciaPrevia(docente);
        this.repositorioDocente.actualizar(docente);
    }

    private void validarExistenciaPrevia(Docente docente){
        boolean existe = repositorioDocente.existePorId(docente.getId());
        if(!existe){
            throw new ExcepcionDuplicidad(EL_DOCENTE_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
