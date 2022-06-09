package com.ceiba.clase.adaptador.repositorio;

import com.ceiba.clase.modelo.entidad.Clase;
import com.ceiba.clase.puerto.repositorio.RepositorioClase;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioClaseMysql implements RepositorioClase {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="clase", value="crear")
    private static String sqlCrearClase;

    @SqlStatement(namespace="clase", value="actualizar")
    private static String sqlActualizarClase;

    @SqlStatement(namespace="clase", value="eliminar")
    private static String sqlEliminarClase;

    @SqlStatement(namespace="clase", value="existePorId")
    private static String sqlExistePorIdClase;

    @SqlStatement(namespace="clase", value="existeCurso")
    private static String sqlAsignacionCurso;

    @SqlStatement(namespace="clase", value="horasInscritas")
    private static String sqlHorasInscritasDocente;

    @SqlStatement(namespace="curso", value="obtenerHoras")
    private static String sqlObtenerHorasCurso;

    @SqlStatement(namespace="curso", value="existePorId")
    private static String sqlExisteCurso;

    public RepositorioClaseMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Clase clase) {
        return this.customNamedParameterJdbcTemplate.crear(clase, sqlCrearClase);
    }

    @Override
    public void actualizar(Clase clase) {
        this.customNamedParameterJdbcTemplate.actualizar(clase, sqlActualizarClase);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarClase, paramSource);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorIdClase,paramSource, Boolean.class);
    }

    @Override
    public boolean existeAsignacionCurso(Long curso) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("curso", curso);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlAsignacionCurso,paramSource, Boolean.class);
    }

    @Override
    public boolean existeCurso(Long curso) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", curso);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteCurso,paramSource, Boolean.class);
    }

    @Override
    public Integer validaHorasInscritasDocente(Long docente) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("docente", docente);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlHorasInscritasDocente, paramSource, Integer.class);
    }

    @Override
    public Integer obtenerHorasCurso(Long curso) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", curso);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerHorasCurso, paramSource, Integer.class);
    }
}
