package com.ceiba.clase.consulta;

import com.ceiba.clase.modelo.dto.DtoClase;
import com.ceiba.clase.puerto.dao.DaoClase;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarClases {

    private final DaoClase daoClase;

    public ManejadorListarClases(DaoClase daoClase) {
        this.daoClase = daoClase;
    }

    public List<DtoClase> listar(){
        return this.daoClase.listar();
    }
}
