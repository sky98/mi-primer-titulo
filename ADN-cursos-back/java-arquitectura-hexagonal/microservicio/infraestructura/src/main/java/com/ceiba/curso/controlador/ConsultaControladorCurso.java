package com.ceiba.curso.controlador;

import com.ceiba.curso.consulta.ManejadorListarCursos;
import com.ceiba.curso.modelo.dto.DtoCurso;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
@Api(tags = {"Controlador consulta curso"})
@CrossOrigin(value = "*")
public class ConsultaControladorCurso {

    private final ManejadorListarCursos manejadorListarCursos;

    public ConsultaControladorCurso(ManejadorListarCursos manejadorListarCursos) {
        this.manejadorListarCursos = manejadorListarCursos;
    }

    @GetMapping
    @ApiOperation("Listar cursos")
    public List<DtoCurso> listar(){ return this.manejadorListarCursos.listar(); }

    @GetMapping(value = "/{id}")
    @ApiOperation("Obtener curso por id")
    public DtoCurso obtenerCursoPorId(@PathVariable Long id){ return this.manejadorListarCursos.obtenerCursoPorId(id); }
}
