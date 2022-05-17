package com.ceiba.persona.servicio;

import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.puerto.repositorio.RepositorioPersona;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarPersona {

    private static final String LA_PERSONA_NO_EXISTE_EN_EL_SISTEMA = "La persona no existe en el sistema";
    private static final String NUMERO_DE_IDENTIFICACION_YA_SE_ENCUENTRA_REGISTRADO_EN_EL_SISTEMA = "Numero de identificación ya se encuentra en el sistema";
    private final RepositorioPersona repositorioPersona;

    public ServicioActualizarPersona(RepositorioPersona repositorioPersona) {
        this.repositorioPersona = repositorioPersona;
    }

    public void ejecutar(Persona persona) {
        validarExistenciaPrevia(persona);
        validarExistenciaPreviaPorIdentificacion(persona);
        this.repositorioPersona.actualizar(persona);
    }
    private void validarExistenciaPrevia(Persona persona) {
        boolean existe = this.repositorioPersona.existePorId(persona.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(LA_PERSONA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
    private void validarExistenciaPreviaPorIdentificacion(Persona persona){
        boolean existe = repositorioPersona.existePorIdentificacion(persona.getIdentificacion());
        if(existe){
            throw new ExcepcionDuplicidad(NUMERO_DE_IDENTIFICACION_YA_SE_ENCUENTRA_REGISTRADO_EN_EL_SISTEMA);
        }
    }
}
