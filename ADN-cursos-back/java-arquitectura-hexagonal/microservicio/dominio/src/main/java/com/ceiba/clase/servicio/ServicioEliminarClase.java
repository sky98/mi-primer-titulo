package com.ceiba.clase.servicio;

import com.ceiba.clase.puerto.repositorio.RepositorioClase;

public class ServicioEliminarClase {
    private final RepositorioClase repositorioClase;

    public ServicioEliminarClase(RepositorioClase repositorioClase) {
        this.repositorioClase = repositorioClase;
    }

    public void ejecutar(Long id){
        this.repositorioClase.eliminar(id);
    }
}
