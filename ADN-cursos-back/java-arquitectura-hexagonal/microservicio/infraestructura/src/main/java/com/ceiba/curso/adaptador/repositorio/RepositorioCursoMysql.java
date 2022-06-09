package com.ceiba.curso.adaptador.repositorio;

import com.ceiba.curso.modelo.entidad.Curso;
import com.ceiba.curso.puerto.repositorio.RepositorioCurso;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCursoMysql implements RepositorioCurso {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="curso", value="crear")
    private static String sqlCrearCurso;

    @SqlStatement(namespace="curso", value="actualizar")
    private static String sqlActualizarCurso;

    @SqlStatement(namespace="curso", value="eliminar")
    private static String sqlEliminarCurso;

    @SqlStatement(namespace="curso", value="existePorId")
    private static String sqlExistePorIdCurso;

    @SqlStatement(namespace="curso", value="existePorIdentificacion")
    private static String sqlExistePorIdentificacionCurso;

    public RepositorioCursoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Curso curso) {
        return this.customNamedParameterJdbcTemplate.crear(curso, sqlCrearCurso);
    }

    @Override
    public void actualizar(Curso curso) {
        this.customNamedParameterJdbcTemplate.actualizar(curso, sqlActualizarCurso);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarCurso, paramSource);
    }

    @Override
    public boolean existePorIdentificacion(String identificacion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("identificacion", identificacion);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorIdentificacionCurso,paramSource, Boolean.class);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorIdCurso,paramSource, Boolean.class);
    }
}
