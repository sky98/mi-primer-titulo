package com.ceiba.persona.comando.manejador;

import com.ceiba.persona.servicio.ServicioEliminarPersona;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarPersona implements ManejadorComando<Long> {

    private final ServicioEliminarPersona servicioEliminarPersona;

    public ManejadorEliminarPersona(ServicioEliminarPersona servicioEliminarPersona) {
        this.servicioEliminarPersona = servicioEliminarPersona;
    }

    @Override
    public void ejecutar(Long idPersona) {
        this.servicioEliminarPersona.ejecutar(idPersona);
    }
}
