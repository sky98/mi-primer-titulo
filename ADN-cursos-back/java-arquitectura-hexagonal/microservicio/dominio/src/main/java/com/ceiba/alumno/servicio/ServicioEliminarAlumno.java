package com.ceiba.alumno.servicio;

import com.ceiba.alumno.puerto.repositorio.RepositorioAlumno;

public class ServicioEliminarAlumno {

    private final RepositorioAlumno repositorioAlumno;

    public ServicioEliminarAlumno(RepositorioAlumno repositorioAlumno) {
        this.repositorioAlumno = repositorioAlumno;
    }

    public void ejecutar(Long id){
        this.repositorioAlumno.eliminar(id);
    }
}
