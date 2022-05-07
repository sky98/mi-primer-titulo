package com.ceiba.docente.servicio;

import com.ceiba.docente.puerto.repositorio.RepositorioDocente;

public class ServicioEliminarDocente {

    private final RepositorioDocente repositorioDocente;

    public ServicioEliminarDocente(RepositorioDocente repositorioDocente) {
        this.repositorioDocente = repositorioDocente;
    }

    public void ejecutar(Long id){
        this.repositorioDocente.eliminar(id);
    }
}
