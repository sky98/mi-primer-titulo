package com.ceiba.docente.comando.fabrica;

import com.ceiba.docente.comando.ComandoDocente;
import com.ceiba.docente.modelo.entidad.Docente;
import org.springframework.stereotype.Component;

@Component
public class FabricaDocente {

    public Docente crear(ComandoDocente comandoDocente){
        return new Docente(comandoDocente.getId(),
                comandoDocente.getIdentificacion(),
                comandoDocente.getNombre(),
                comandoDocente.getApellido(),
                comandoDocente.getDireccion(),
                comandoDocente.getTelefono(),
                comandoDocente.getCorreo());
    }
}
