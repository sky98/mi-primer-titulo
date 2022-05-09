package com.ceiba.docente.adaptador.dao;

import com.ceiba.docente.modelo.dto.DtoDocente;
import com.ceiba.docente.puerto.dao.DaoDocente;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoDocenteMysql implements DaoDocente {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="docente", value="listar")
    private static String sqlListar;

    public DaoDocenteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoDocente> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoDocente());
    }
}
