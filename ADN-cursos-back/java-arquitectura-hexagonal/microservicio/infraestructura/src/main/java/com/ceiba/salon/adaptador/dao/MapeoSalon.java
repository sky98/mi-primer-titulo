package com.ceiba.salon.adaptador.dao;

import com.ceiba.salon.modelo.dto.DtoSalon;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MapeoSalon implements RowMapper<DtoSalon>, MapperResult {

    @Override
    public DtoSalon mapRow(ResultSet rs, int rowNum) throws SQLException {

        Long id = rs.getLong("id");
        Long alumno = rs.getLong("alumno");
        Long curso = rs.getLong("curso");

        return new DtoSalon(id, alumno, curso);
    }
}
