package com.ceiba.persona.adaptador.repositorio;

import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.puerto.repositorio.RepositorioPersona;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPersonaMysql implements RepositorioPersona {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="persona", value="crear")
    private static String sqlCrearPersona;

    @SqlStatement(namespace="persona", value="actualizar")
    private static String sqlActualizarPersona;

    @SqlStatement(namespace="persona", value="eliminar")
    private static String sqlEliminarPersona;

    @SqlStatement(namespace="persona", value="existePorId")
    private static String sqlExistePorIdPersona;

    @SqlStatement(namespace="persona", value="existePorIdentificacion")
    private static String sqlExistePorIdentificacionPersona;

    public RepositorioPersonaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Persona persona) {
        return this.customNamedParameterJdbcTemplate.crear(persona, sqlCrearPersona);
    }

    @Override
    public void actualizar(Persona persona) {
        this.customNamedParameterJdbcTemplate.actualizar(persona, sqlActualizarPersona);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarPersona, paramSource);
    }

    @Override
    public boolean existePorIdentificacion(String identificacion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("identificacion", identificacion);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorIdentificacionPersona,paramSource, Boolean.class);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorIdPersona,paramSource, Boolean.class);
    }
}
