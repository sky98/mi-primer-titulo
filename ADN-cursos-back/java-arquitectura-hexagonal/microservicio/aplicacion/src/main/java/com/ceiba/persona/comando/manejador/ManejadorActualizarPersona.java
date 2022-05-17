package com.ceiba.persona.comando.manejador;

import com.ceiba.persona.comando.ComandoPersona;
import com.ceiba.persona.comando.fabrica.FabricaPersona;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.servicio.ServicioActualizarPersona;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarPersona implements ManejadorComando<ComandoPersona> {

    private final FabricaPersona fabricaPersona;
    private final ServicioActualizarPersona servicioActualizarPersona;

    public ManejadorActualizarPersona(FabricaPersona fabricaPersona, ServicioActualizarPersona servicioActualizarPersona) {
        this.fabricaPersona = fabricaPersona;
        this.servicioActualizarPersona = servicioActualizarPersona;
    }

    @Override
    public void ejecutar(ComandoPersona comandoPersona) {
        Persona persona = this.fabricaPersona.crear(comandoPersona);
        this.servicioActualizarPersona.ejecutar(persona);
    }
}
