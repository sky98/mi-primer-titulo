package com.ceiba.alumno.comando.fabrica;

import com.ceiba.alumno.comando.ComandoAlumno;
import com.ceiba.alumno.modelo.entidad.Alumno;
import org.springframework.stereotype.Component;

@Component
public class FabricaAlumno {

    public Alumno crear(ComandoAlumno comandoAlumno){
        return new Alumno(comandoAlumno.getId(),
                comandoAlumno.getIdentificacion(),
                comandoAlumno.getNombre(),
                comandoAlumno.getApellido(),
                comandoAlumno.getDireccion(),
                comandoAlumno.getTelefono(),
                comandoAlumno.getCorreo());
    }
}
