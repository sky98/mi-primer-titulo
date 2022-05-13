package com.ceiba.clase.comando.manejador;

import com.ceiba.clase.comando.ComandoClase;
import com.ceiba.clase.comando.fabrica.FabricaClase;
import com.ceiba.clase.modelo.entidad.Clase;
import com.ceiba.clase.servicio.ServicioActualizarClase;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarClase implements ManejadorComando<ComandoClase> {
    private final FabricaClase fabricaClase;
    private final ServicioActualizarClase servicioActualizarClase;

    public ManejadorActualizarClase(FabricaClase fabricaClase, ServicioActualizarClase servicioActualizarClase) {
        this.fabricaClase = fabricaClase;
        this.servicioActualizarClase = servicioActualizarClase;
    }

    @Override
    public void ejecutar(ComandoClase comandoClase) {
        Clase clase = this.fabricaClase.crear(comandoClase);
        this.servicioActualizarClase.ejecutar(clase);
    }
}
