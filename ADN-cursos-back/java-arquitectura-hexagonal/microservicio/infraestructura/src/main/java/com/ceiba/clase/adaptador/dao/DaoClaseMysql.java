package com.ceiba.clase.adaptador.dao;

import com.ceiba.clase.modelo.dto.DtoClase;
import com.ceiba.clase.puerto.dao.DaoClase;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoClaseMysql implements DaoClase {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="clase", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="clase", value="detalles")
    private static String sqlDetallesClase;

    public DaoClaseMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoClase> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoClase());
    }

    @Override
    public DtoClase detallesClase(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlDetallesClase,paramSource, new MapeoClase());
    }
}
