package com.ceiba.persona.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.persona.modelo.dto.DtoPersona;
import com.ceiba.persona.puerto.dao.DaoPersona;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoPersonaMysql implements DaoPersona {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="persona", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="persona", value="listarAlumnos")
    private static String sqlListarAlumnos;

    @SqlStatement(namespace="persona", value="listarDocentes")
    private static String sqlListarDocentes;

    public DaoPersonaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoPersona> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoPersona());
    }

    @Override
    public List<DtoPersona> listarAlumnos() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarAlumnos, new MapeoPersona());
    }

    @Override
    public List<DtoPersona> listarDocentes() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarDocentes, new MapeoPersona());
    }
}
