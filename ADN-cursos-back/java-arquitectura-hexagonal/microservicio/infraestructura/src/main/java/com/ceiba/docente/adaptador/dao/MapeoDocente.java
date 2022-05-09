package com.ceiba.docente.adaptador.dao;

import com.ceiba.docente.modelo.dto.DtoDocente;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MapeoDocente implements RowMapper<DtoDocente>, MapperResult {

    @Override
    public DtoDocente mapRow(ResultSet rs, int rowNum) throws SQLException {

        Long id = rs.getLong("id");
        String identificacion = rs.getString("identificacion");
        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido");
        String direccion = rs.getString("direccion");
        String telefono = rs.getString("telefono");
        String correoElectronico = rs.getString("correo_electronico");

        return new DtoDocente(id, identificacion, nombre, apellido, direccion, telefono, correoElectronico);
    }
}
