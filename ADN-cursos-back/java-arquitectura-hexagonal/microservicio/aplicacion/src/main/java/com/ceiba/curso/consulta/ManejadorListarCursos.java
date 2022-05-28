package com.ceiba.curso.consulta;

import com.ceiba.curso.modelo.dto.DtoCurso;
import com.ceiba.curso.puerto.dao.DaoCurso;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarCursos {

    private final DaoCurso daoCurso;

    public ManejadorListarCursos(DaoCurso daoCurso) {
        this.daoCurso = daoCurso;
    }

    public List<DtoCurso> listar(){
        return this.daoCurso.listar();
    }

    public DtoCurso obtenerCursoPorId(Long id){
        return this.daoCurso.obtenerCursoPorId(id);
    }
}
