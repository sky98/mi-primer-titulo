package com.ceiba.docente.controlador;

import com.ceiba.docente.consulta.ManejadorListarDocentes;
import com.ceiba.docente.modelo.dto.DtoDocente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/docentes")
@Api(tags = {"Controlador consulta docente"})
public class ConsultaControladorDocente {

    private final ManejadorListarDocentes manejadorListarDocentes;

    public ConsultaControladorDocente(ManejadorListarDocentes manejadorListarDocentes) {
        this.manejadorListarDocentes = manejadorListarDocentes;
    }

    @GetMapping
    @ApiOperation("Listar docentes")
    public List<DtoDocente> listar(){ return this.manejadorListarDocentes.listar(); }
}
