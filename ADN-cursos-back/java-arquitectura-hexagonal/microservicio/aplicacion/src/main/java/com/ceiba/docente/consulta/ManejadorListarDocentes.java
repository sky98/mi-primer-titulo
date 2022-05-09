package com.ceiba.docente.consulta;

import com.ceiba.docente.modelo.dto.DtoDocente;
import com.ceiba.docente.puerto.dao.DaoDocente;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarDocentes {

    private final DaoDocente daoDocente;

    public ManejadorListarDocentes(DaoDocente daoDocente) {
        this.daoDocente = daoDocente;
    }

    public List<DtoDocente> listar(){
        return this.daoDocente.listar();
    }
}
