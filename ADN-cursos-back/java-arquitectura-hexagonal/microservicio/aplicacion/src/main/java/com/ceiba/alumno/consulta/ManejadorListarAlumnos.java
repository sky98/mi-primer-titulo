package com.ceiba.alumno.consulta;

import com.ceiba.alumno.modelo.dto.DtoAlumno;
import com.ceiba.alumno.puerto.dao.DaoAlumno;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarAlumnos {

    private final DaoAlumno daoAlumno;

    public ManejadorListarAlumnos(DaoAlumno daoAlumno) {
        this.daoAlumno = daoAlumno;
    }

    public List<DtoAlumno> listar(){
        return this.daoAlumno.listar();
    }
}
