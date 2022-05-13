package com.ceiba.curso.adaptador.dao;

import com.ceiba.curso.modelo.dto.DtoCurso;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MapeoCurso implements RowMapper<DtoCurso>, MapperResult {

    @Override
    public DtoCurso mapRow(ResultSet rs, int rowNum) throws SQLException {

        Long id = rs.getLong("id");
        String identificacion = rs.getString("identificacion");
        String nombre = rs.getString("nombre");
        String descripcion = rs.getString("descripcion");
        Integer horas = rs.getInt("horas");
        Long docente = rs.getLong("docente");

        return new DtoCurso(id, identificacion, nombre, descripcion, horas, docente);
    }
}
