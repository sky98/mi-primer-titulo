package com.ceiba.clase.comando.fabrica;

import com.ceiba.clase.comando.ComandoClase;
import com.ceiba.clase.modelo.entidad.Clase;
import org.springframework.stereotype.Component;

@Component
public class FabricaClase {
    public Clase crear(ComandoClase comandoClase){
        return new Clase(comandoClase.getId(),
                comandoClase.getDocente(),
                comandoClase.getCurso());
    }
}
