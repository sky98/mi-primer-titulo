package com.ceiba.alumno.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.alumno.comando.ComandoAlumno;
import com.ceiba.alumno.comando.fabrica.FabricaAlumno;
import com.ceiba.alumno.modelo.entidad.Alumno;
import com.ceiba.alumno.servicio.ServicioCrearAlumno;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearAlumno implements ManejadorComandoRespuesta<ComandoAlumno, ComandoRespuesta<Long>> {

    private final FabricaAlumno fabricaAlumno;
    private final ServicioCrearAlumno servicioCrearAlumno;

    public ManejadorCrearAlumno(FabricaAlumno fabricaAlumno, ServicioCrearAlumno servicioCrearAlumno) {
        this.fabricaAlumno = fabricaAlumno;
        this.servicioCrearAlumno = servicioCrearAlumno;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoAlumno comandoAlumno) {
        Alumno alumno = this.fabricaAlumno.crear(comandoAlumno);
        return new ComandoRespuesta<>(this.servicioCrearAlumno.ejecutar(alumno));
    }
}
