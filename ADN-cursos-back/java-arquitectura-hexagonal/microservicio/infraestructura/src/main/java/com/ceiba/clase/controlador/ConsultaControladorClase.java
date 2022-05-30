package com.ceiba.clase.controlador;

import com.ceiba.clase.consulta.ManejadorListarClases;
import com.ceiba.clase.modelo.dto.DtoClase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clases")
@Api(tags = {"Controlador consulta clase"})
@CrossOrigin(value = "*")
public class ConsultaControladorClase {

    private final ManejadorListarClases manejadorListarClases;

    public ConsultaControladorClase(ManejadorListarClases manejadorListarClases) {
        this.manejadorListarClases = manejadorListarClases;
    }

    @GetMapping
    @ApiOperation("Listar clases")
    public List<DtoClase> listar(){ return this.manejadorListarClases.listar(); }

    @GetMapping(value = "/{id}")
    @ApiOperation("Detalles clase")
    public DtoClase detallesClase(@PathVariable Long id){ return this.manejadorListarClases.detallesClase(id); }
}
