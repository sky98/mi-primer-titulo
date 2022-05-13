package com.ceiba.clase.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.clase.comando.ComandoClase;
import com.ceiba.clase.comando.fabrica.FabricaClase;
import com.ceiba.clase.modelo.entidad.Clase;
import com.ceiba.clase.servicio.ServicioCrearClase;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearClase implements ManejadorComandoRespuesta<ComandoClase, ComandoRespuesta<Long>> {

    private final FabricaClase fabricaClase;
    private final ServicioCrearClase servicioCrearClase;

    public ManejadorCrearClase(FabricaClase fabricaClase, ServicioCrearClase servicioCrearClase) {
        this.fabricaClase = fabricaClase;
        this.servicioCrearClase = servicioCrearClase;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoClase comandoClase) {
        Clase clase = this.fabricaClase.crear(comandoClase);
        return new ComandoRespuesta<>(this.servicioCrearClase.ejecutar(clase));
    }
}
