package com.ceiba.docente.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.docente.comando.ComandoDocente;
import com.ceiba.docente.comando.fabrica.FabricaDocente;
import com.ceiba.docente.modelo.entidad.Docente;
import com.ceiba.docente.servicio.ServicioCrearDocente;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearDocente implements ManejadorComandoRespuesta<ComandoDocente, ComandoRespuesta<Long>> {

    private final FabricaDocente fabricaDocente;
    private final ServicioCrearDocente servicioCrearDocente;

    public ManejadorCrearDocente(FabricaDocente fabricaDocente, ServicioCrearDocente servicioCrearDocente) {
        this.fabricaDocente = fabricaDocente;
        this.servicioCrearDocente = servicioCrearDocente;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoDocente comandoDocente) {
        Docente docente = this.fabricaDocente.crear(comandoDocente);
        return new ComandoRespuesta<>(this.servicioCrearDocente.ejecutar(docente));
    }
}
