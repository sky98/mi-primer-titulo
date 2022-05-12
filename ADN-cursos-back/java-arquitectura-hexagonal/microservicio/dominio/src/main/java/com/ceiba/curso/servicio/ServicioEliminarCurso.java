package com.ceiba.curso.servicio;

import com.ceiba.curso.puerto.repositorio.RepositorioCurso;

public class ServicioEliminarCurso {

    private final RepositorioCurso repositorioCurso;

    public ServicioEliminarCurso(RepositorioCurso repositorioCurso) {
        this.repositorioCurso = repositorioCurso;
    }

    public void ejecutar(Long id){
        this.repositorioCurso.eliminar(id);
    }
}
