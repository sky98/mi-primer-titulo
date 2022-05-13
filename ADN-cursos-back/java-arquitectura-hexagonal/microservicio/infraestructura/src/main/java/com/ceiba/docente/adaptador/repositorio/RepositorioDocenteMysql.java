package com.ceiba.docente.adaptador.repositorio;

import com.ceiba.docente.modelo.entidad.Docente;
import com.ceiba.docente.puerto.repositorio.RepositorioDocente;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioDocenteMysql implements RepositorioDocente {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="docente", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="docente", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="docente", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="docente", value="existePorId")
    private static String sqlExistePorId;

    @SqlStatement(namespace="docente", value="existePorIdentificacion")
    private static String sqlExistePorIdentificacion;

    public RepositorioDocenteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Docente docente) {
        return this.customNamedParameterJdbcTemplate.crear(docente, sqlCrear);
    }

    @Override
    public void actualizar(Docente docente) {
        this.customNamedParameterJdbcTemplate.actualizar(docente, sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }
    @Override
    public boolean existePorIdentificacion(String identificacion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("identificacion", identificacion);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorIdentificacion,paramSource, Boolean.class);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);
    }
}
