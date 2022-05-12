package com.ceiba.alumno.comando.manejador;

import com.ceiba.alumno.comando.ComandoAlumno;
import com.ceiba.alumno.comando.fabrica.FabricaAlumno;
import com.ceiba.alumno.modelo.entidad.Alumno;
import com.ceiba.alumno.servicio.ServicioActualizarAlumno;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarAlumno implements ManejadorComando<ComandoAlumno> {

    private final FabricaAlumno fabricaAlumno;
    private final ServicioActualizarAlumno servicioActualizarAlumno;

    public ManejadorActualizarAlumno(FabricaAlumno fabricaAlumno, ServicioActualizarAlumno servicioActualizarAlumno) {
        this.fabricaAlumno = fabricaAlumno;
        this.servicioActualizarAlumno = servicioActualizarAlumno;
    }

    @Override
    public void ejecutar(ComandoAlumno comandoAlumno) {
        Alumno alumno = this.fabricaAlumno.crear(comandoAlumno);
        this.servicioActualizarAlumno.ejecutar(alumno);
    }
}
