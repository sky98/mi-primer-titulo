package com.ceiba.docente.servicio;

import com.ceiba.docente.modelo.entidad.Docente;
import com.ceiba.docente.puerto.repositorio.RepositorioDocente;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearDocente {

    private static final String EL_DOCENTE_YA_EXISTE_EN_EL_SISTEMA = "El docente ya existe en el sistema";

    private final RepositorioDocente repositorioDocente;

    public ServicioCrearDocente(RepositorioDocente repositorioDocente) {
        this.repositorioDocente = repositorioDocente;
    }

    public Long ejecutar(Docente docente){
        validarExistenciaPrevia(docente);
        return this.repositorioDocente.crear(docente);
    }

    private void validarExistenciaPrevia(Docente docente){
        boolean existe = repositorioDocente.existePorId(docente.getId());
        if(existe){
            throw new ExcepcionDuplicidad(EL_DOCENTE_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
