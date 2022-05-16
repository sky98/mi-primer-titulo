package com.ceiba.salon.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.salon.comando.ComandoSalon;
import com.ceiba.salon.comando.fabrica.FabricaSalon;
import com.ceiba.salon.modelo.entidad.Salon;
import com.ceiba.salon.servicio.ServicioCrearSalon;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearSalon implements ManejadorComandoRespuesta<ComandoSalon, ComandoRespuesta<Long>> {

    private final FabricaSalon fabricaSalon;
    private final ServicioCrearSalon servicioCrearSalon;

    public ManejadorCrearSalon(FabricaSalon fabricaSalon, ServicioCrearSalon servicioCrearSalon) {
        this.fabricaSalon = fabricaSalon;
        this.servicioCrearSalon = servicioCrearSalon;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSalon comandoSalon) {
        Salon salon = this.fabricaSalon.crear(comandoSalon);
        return new ComandoRespuesta<>(this.servicioCrearSalon.ejecutar(salon));
    }
}
