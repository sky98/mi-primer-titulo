package com.ceiba.docente.adaptador.repositorio;

import com.ceiba.docente.modelo.entidad.Docente;
import com.ceiba.docente.puerto.repositorio.RepositorioDocente;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioDocenteMysql implements RepositorioDocente {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="docente", value="crear")
    private static String sqlCrear;

    public RepositorioDocenteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Docente docente) {
        return this.customNamedParameterJdbcTemplate.crear(docente, sqlCrear);
    }

    @Override
    public void actualizar(Docente docente) {

    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public boolean existe(String nombre) {
        return false;
    }

    @Override
    public boolean existePorIdentificacion(String identificacion) {
        return false;
    }

    @Override
    public boolean existePorId(Long id) {
        return false;
    }
}
