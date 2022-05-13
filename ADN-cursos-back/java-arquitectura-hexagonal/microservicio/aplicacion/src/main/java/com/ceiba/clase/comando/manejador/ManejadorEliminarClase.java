package com.ceiba.clase.comando.manejador;

import com.ceiba.clase.servicio.ServicioEliminarClase;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarClase implements ManejadorComando<Long> {

    private final ServicioEliminarClase servicioEliminarClase;

    public ManejadorEliminarClase(ServicioEliminarClase servicioEliminarClase) {
        this.servicioEliminarClase = servicioEliminarClase;
    }

    @Override
    public void ejecutar(Long idClase) {
        this.servicioEliminarClase.ejecutar(idClase);
    }
}
