package com.ceiba.alumno.adaptador.dao;

import com.ceiba.alumno.adaptador.dao.MapeoAlumno;
import com.ceiba.alumno.modelo.dto.DtoAlumno;
import com.ceiba.alumno.puerto.dao.DaoAlumno;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoAlumnoMysql implements DaoAlumno {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="alumno", value="listar")
    private static String sqlListar;

    public DaoAlumnoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoAlumno> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoAlumno());
    }
}
