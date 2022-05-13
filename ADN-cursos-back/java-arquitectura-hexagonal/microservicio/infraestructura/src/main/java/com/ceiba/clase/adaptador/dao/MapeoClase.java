package com.ceiba.clase.adaptador.dao;

import com.ceiba.clase.modelo.dto.DtoClase;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MapeoClase implements RowMapper<DtoClase>, MapperResult {

    @Override
    public DtoClase mapRow(ResultSet rs, int rowNum) throws SQLException {

        Long id = rs.getLong("id");
        Long docente = rs.getLong("docente");
        Long curso = rs.getLong("curso");

        return new DtoClase(id, docente, curso);
    }
}
