package com.ceiba.horario.adaptador.repositorio;

import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioHorarioMysql implements RepositorioHorario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="horario", value="crear")
    private static String sqlCrearHorario;

    @SqlStatement(namespace="horario", value="actualizar")
    private static String sqlActualizarHorario;

    @SqlStatement(namespace="horario", value="eliminar")
    private static String sqlEliminarHorario;

    @SqlStatement(namespace="horario", value="existePorId")
    private static String sqlExistePorIdHorario;

    @SqlStatement(namespace="clase", value="existePorId")
    private static String sqlExisteClasePorId;

    public RepositorioHorarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Horario horario) {
        return this.customNamedParameterJdbcTemplate.crear(horario, sqlCrearHorario);
    }

    @Override
    public void actualizar(Horario horario) {
        this.customNamedParameterJdbcTemplate.actualizar(horario, sqlActualizarHorario);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarHorario, paramSource);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorIdHorario,paramSource, Boolean.class);
    }

    @Override
    public boolean existeClasePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteClasePorId,paramSource, Boolean.class);
    }
}
