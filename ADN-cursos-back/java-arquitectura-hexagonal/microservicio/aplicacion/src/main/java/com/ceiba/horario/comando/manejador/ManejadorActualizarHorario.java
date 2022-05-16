package com.ceiba.horario.comando.manejador;

import com.ceiba.horario.comando.ComandoHorario;
import com.ceiba.horario.comando.fabrica.FabricaHorario;
import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.horario.servicio.ServicioActualizarHorario;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarHorario implements ManejadorComando<ComandoHorario> {

    private final FabricaHorario fabricaHorario;
    private final ServicioActualizarHorario servicioActualizarHorario;

    public ManejadorActualizarHorario(FabricaHorario fabricaHorario, ServicioActualizarHorario servicioActualizarHorario) {
        this.fabricaHorario = fabricaHorario;
        this.servicioActualizarHorario = servicioActualizarHorario;
    }

    @Override
    public void ejecutar(ComandoHorario comandoHorario) {
        Horario horario = this.fabricaHorario.crear(comandoHorario);
        this.servicioActualizarHorario.ejecutar(horario);
    }
}
