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
    private static String sqlCrear;
    @SqlStatement(namespace="clase", value="actualizar")
    private static String sqlActualizar;
    @SqlStatement(namespace="clase", value="eliminar")
    private static String sqlEliminar;
    @SqlStatement(namespace="clase", value="existePorId")
    private static String sqlExistePorId;
    @SqlStatement(namespace="docente", value="existePorId")
    private static String sqlExisteDocente;
    @SqlStatement(namespace="curso", value="existePorId")
    private static String sqlExisteCurso;
    @SqlStatement(namespace="clase", value="horas")
    private static String sqlHorasDocente;

    public RepositorioClaseMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Clase clase) {
        return this.customNamedParameterJdbcTemplate.crear(clase, sqlCrear);
    }

    @Override
    public void actualizar(Clase clase) {
        this.customNamedParameterJdbcTemplate.actualizar(clase, sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);
    }

    @Override
    public boolean existeCurso(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteCurso,paramSource, Boolean.class);
    }

    @Override
    public boolean existeDocente(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteDocente,paramSource, Boolean.class);
    }

    @Override
    public Integer validaHorasDocente(Long docente, Long curso) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("docente", docente);
        paramSource.addValue("curso", curso);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlHorasDocente, paramSource, Integer.class);
    }
}
