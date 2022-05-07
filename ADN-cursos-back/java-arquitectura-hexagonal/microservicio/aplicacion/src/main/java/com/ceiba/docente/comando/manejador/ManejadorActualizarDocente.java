package com.ceiba.docente.comando.manejador;

import com.ceiba.docente.comando.ComandoDocente;
import com.ceiba.docente.comando.fabrica.FabricaDocente;
import com.ceiba.docente.modelo.entidad.Docente;
import com.ceiba.docente.servicio.ServicioActualizarDocente;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarDocente implements ManejadorComando<ComandoDocente> {

    private final FabricaDocente fabricaDocente;
    private final ServicioActualizarDocente servicioActualizarDocente;

    public ManejadorActualizarDocente(FabricaDocente fabricaDocente, ServicioActualizarDocente servicioActualizarDocente) {
        this.fabricaDocente = fabricaDocente;
        this.servicioActualizarDocente = servicioActualizarDocente;
    }

    @Override
    public void ejecutar(ComandoDocente comandoDocente) {
        Docente docente = this.fabricaDocente.crear(comandoDocente);
        this.servicioActualizarDocente.ejecutar(docente);
    }
}
