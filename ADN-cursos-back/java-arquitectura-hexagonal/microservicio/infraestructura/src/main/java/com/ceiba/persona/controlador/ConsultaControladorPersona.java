package com.ceiba.persona.controlador;

import com.ceiba.persona.consulta.ManejadorListarPersonas;
import com.ceiba.persona.modelo.dto.DtoPersona;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
@Api(tags = {"Controlador consulta persona"})
@CrossOrigin(value = "http://localhost:4200")
public class ConsultaControladorPersona {

    private final ManejadorListarPersonas manejadorListarPersonas;

    public ConsultaControladorPersona(ManejadorListarPersonas manejadorListarPersonas) {
        this.manejadorListarPersonas = manejadorListarPersonas;
    }

    @GetMapping
    @ApiOperation("Listar personas")
    public List<DtoPersona> listar(){ return this.manejadorListarPersonas.listar(); }

    @GetMapping(value = "/alumnos")
    @ApiOperation("Listar alumnos")
    public List<DtoPersona> listarAlumnos(){ return this.manejadorListarPersonas.listarAlumnos(); }

    @GetMapping(value = "/docentes")
    @ApiOperation("Listar docentes")
    public List<DtoPersona> listarDocentes(){ return this.manejadorListarPersonas.listarDocentes(); }

    @GetMapping(value = "/docentes/{id}")
    @ApiOperation("Obtener docente")
    public DtoPersona obtenerDocentePorId(@PathVariable Long id){ return this.manejadorListarPersonas.obtenerDocentePorId(id); }
}
