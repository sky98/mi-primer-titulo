package com.ceiba.persona.adaptador.dao;

import com.ceiba.persona.modelo.dto.DtoPersona;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MapeoPersona implements RowMapper<DtoPersona>, MapperResult {

    @Override
    public DtoPersona mapRow(ResultSet rs, int rowNum) throws SQLException {

        Long id = rs.getLong("id");
        String identificacion = rs.getString("identificacion");
        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido");
        String direccion = rs.getString("direccion");
        String telefono = rs.getString("telefono");
        String correoElectronico = rs.getString("correo_electronico");
        int tipo = rs.getInt("tipo");

        return new DtoPersona(id, identificacion, nombre, apellido, direccion, telefono, correoElectronico, tipo);
    }
}
