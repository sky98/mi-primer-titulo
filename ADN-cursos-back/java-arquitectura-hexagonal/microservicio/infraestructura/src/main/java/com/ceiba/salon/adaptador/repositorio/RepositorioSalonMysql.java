package com.ceiba.salon.adaptador.repositorio;

import com.ceiba.salon.modelo.entidad.Salon;
import com.ceiba.salon.puerto.repositorio.RepositorioSalon;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioSalonMysql implements RepositorioSalon {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="salon", value="crear")
    private static String sqlCrearSalon;

    @SqlStatement(namespace="salon", value="actualizar")
    private static String sqlActualizarSalon;

    @SqlStatement(namespace="salon", value="eliminar")
    private static String sqlEliminarSalon;

    @SqlStatement(namespace="salon", value="existePorId")
    private static String sqlExistePorIdSalon;

    @SqlStatement(namespace="curso", value="existePorId")
    private static String sqlExisteCurso;

    @SqlStatement(namespace="persona", value="existeAlumno")
    private static String sqlExisteAlumno;

    @SqlStatement(namespace="salon", value="cantidadAlumnos")
    private static String sqlCantidadAlumnos;

    @SqlStatement(namespace="salon", value="contarHorasAlumno")
    private static String sqlContarHorasAlumno;

    @SqlStatement(namespace="curso", value="obtenerHoras")
    private static String sqlObtenerHorasCurso;

    public RepositorioSalonMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Salon salon) {
        return this.customNamedParameterJdbcTemplate.crear(salon, sqlCrearSalon);
    }

    @Override
    public void actualizar(Salon salon) {
        this.customNamedParameterJdbcTemplate.actualizar(salon, sqlActualizarSalon);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarSalon, paramSource);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorIdSalon,paramSource, Boolean.class);
    }

    @Override
    public boolean existeCurso(Long curso) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", curso);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteCurso,paramSource, Boolean.class);
    }

    @Override
    public boolean existeAlumno(Long alumno) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", alumno);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteAlumno,paramSource, Boolean.class);
    }

    @Override
    public Integer contadorHorasAlumno(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("alumno", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlContarHorasAlumno,paramSource, Integer.class);
    }

    @Override
    public Integer obtenerHorasCurso(Long curso) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", curso);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerHorasCurso,paramSource, Integer.class);
    }

    @Override
    public Integer obtenerCantidadAlumnos(Long curso) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("curso", curso);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlCantidadAlumnos,paramSource, Integer.class);
    }
}
