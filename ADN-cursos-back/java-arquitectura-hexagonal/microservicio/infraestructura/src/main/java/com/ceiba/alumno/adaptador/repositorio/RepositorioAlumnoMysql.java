package com.ceiba.alumno.adaptador.repositorio;

import com.ceiba.alumno.modelo.entidad.Alumno;
import com.ceiba.alumno.puerto.repositorio.RepositorioAlumno;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioAlumnoMysql implements RepositorioAlumno {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="alumno", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="alumno", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="alumno", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="alumno", value="existePorId")
    private static String sqlExistePorId;

    public RepositorioAlumnoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Alumno alumno) {
        return this.customNamedParameterJdbcTemplate.crear(alumno, sqlCrear);
    }

    @Override
    public void actualizar(Alumno alumno) {
        this.customNamedParameterJdbcTemplate.actualizar(alumno, sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existePorIdentificacion(String identificacion) {
        return false;
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);
    }
}
