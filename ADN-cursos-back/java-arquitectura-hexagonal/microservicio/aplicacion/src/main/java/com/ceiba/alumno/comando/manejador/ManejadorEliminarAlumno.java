package com.ceiba.alumno.comando.manejador;

import com.ceiba.alumno.servicio.ServicioEliminarAlumno;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarAlumno implements ManejadorComando<Long> {

    private final ServicioEliminarAlumno servicioEliminarAlumno;

    public ManejadorEliminarAlumno(ServicioEliminarAlumno servicioEliminarAlumno) {
        this.servicioEliminarAlumno = servicioEliminarAlumno;
    }

    @Override
    public void ejecutar(Long idAlumno) {
        this.servicioEliminarAlumno.ejecutar(idAlumno);
    }
}
