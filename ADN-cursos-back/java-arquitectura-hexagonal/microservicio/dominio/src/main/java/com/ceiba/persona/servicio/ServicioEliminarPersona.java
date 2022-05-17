package com.ceiba.persona.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.persona.puerto.repositorio.RepositorioPersona;

public class ServicioEliminarPersona {

    private static final String LA_PERSONA_NO_EXISTE_EN_EL_SISTEMA = "La persona no existe en el sistema";

    private final RepositorioPersona repositorioPersona;

    public ServicioEliminarPersona(RepositorioPersona repositorioPersona) {
        this.repositorioPersona = repositorioPersona;
    }

    public void ejecutar(Long id){
        validarExistenciaPrevia(id);
        this.repositorioPersona.eliminar(id);
    }
    private void validarExistenciaPrevia(Long persona) {
        boolean existe = this.repositorioPersona.existePorId(persona);
        if(!existe) {
            throw new ExcepcionDuplicidad(LA_PERSONA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
