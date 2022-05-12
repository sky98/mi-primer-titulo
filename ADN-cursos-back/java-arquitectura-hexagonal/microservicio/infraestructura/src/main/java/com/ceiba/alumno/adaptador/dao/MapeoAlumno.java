package com.ceiba.alumno.adaptador.dao;

import com.ceiba.alumno.modelo.dto.DtoAlumno;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MapeoAlumno implements RowMapper<DtoAlumno>, MapperResult {

    @Override
    public DtoAlumno mapRow(ResultSet rs, int rowNum) throws SQLException {

        Long id = rs.getLong("id");
        String identificacion = rs.getString("identificacion");
        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido");
        String direccion = rs.getString("direccion");
        String telefono = rs.getString("telefono");
        String correoElectronico = rs.getString("correo_electronico");

        return new DtoAlumno(id, identificacion, nombre, apellido, direccion, telefono, correoElectronico);
    }
}
