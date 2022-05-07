package com.ceiba.docente.comando.manejador;

import com.ceiba.docente.servicio.ServicioEliminarDocente;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarDocente implements ManejadorComando<Long> {

    private final ServicioEliminarDocente servicioEliminarDocente;

    public ManejadorEliminarDocente(ServicioEliminarDocente servicioEliminarDocente) {
        this.servicioEliminarDocente = servicioEliminarDocente;
    }

    @Override
    public void ejecutar(Long idDocente) {
        this.servicioEliminarDocente.ejecutar(idDocente);
    }
}
