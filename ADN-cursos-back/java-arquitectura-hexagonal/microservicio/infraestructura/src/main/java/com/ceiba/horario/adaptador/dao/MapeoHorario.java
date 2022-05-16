package com.ceiba.horario.adaptador.dao;

import com.ceiba.horario.modelo.dto.DtoHorario;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MapeoHorario implements RowMapper<DtoHorario>, MapperResult {

    @Override
    public DtoHorario mapRow(ResultSet rs, int rowNum) throws SQLException {

        Long id = rs.getLong("id");
        Long clase = rs.getLong("clase");
        int dia = rs.getInt("dia");
        int horaInicio = rs.getInt("hora_inicio");
        int cantidadHoras = rs.getInt("cantidad_horas");

        return new DtoHorario(id, clase, dia, horaInicio, cantidadHoras);
    }
}
