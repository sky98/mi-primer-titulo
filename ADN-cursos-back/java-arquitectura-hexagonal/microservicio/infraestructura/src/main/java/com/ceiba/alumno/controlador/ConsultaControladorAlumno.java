package com.ceiba.alumno.controlador;

import com.ceiba.alumno.consulta.ManejadorListarAlumnos;
import com.ceiba.alumno.modelo.dto.DtoAlumno;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
@Api(tags = {"Controlador consulta alumno"})
public class ConsultaControladorAlumno {

    private final ManejadorListarAlumnos manejadorListarAlumnos;

    public ConsultaControladorAlumno(ManejadorListarAlumnos manejadorListarAlumnos) {
        this.manejadorListarAlumnos = manejadorListarAlumnos;
    }

    @GetMapping
    @ApiOperation("Listar alumnos")
    public List<DtoAlumno> listar(){ return this.manejadorListarAlumnos.listar(); }
}
