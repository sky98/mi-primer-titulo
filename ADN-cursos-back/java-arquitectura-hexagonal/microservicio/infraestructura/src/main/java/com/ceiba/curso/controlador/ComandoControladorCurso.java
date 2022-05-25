package com.ceiba.curso.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.curso.comando.ComandoCurso;
import com.ceiba.curso.comando.manejador.ManejadorActualizarCurso;
import com.ceiba.curso.comando.manejador.ManejadorCrearCurso;
import com.ceiba.curso.comando.manejador.ManejadorEliminarCurso;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cursos")
@Api(tags = "Controlador comando curso")
@CrossOrigin(value = "*")
public class ComandoControladorCurso {

    private final ManejadorCrearCurso manejadorCrearCurso;
    private final ManejadorActualizarCurso manejadorActualizarCurso;
    private final ManejadorEliminarCurso manejadorEliminarCurso;

    @Autowired
    public ComandoControladorCurso(ManejadorCrearCurso manejadorCrearCurso, ManejadorActualizarCurso manejadorActualizarCurso, ManejadorEliminarCurso manejadorEliminarCurso) {
        this.manejadorCrearCurso = manejadorCrearCurso;
        this.manejadorActualizarCurso = manejadorActualizarCurso;
        this.manejadorEliminarCurso = manejadorEliminarCurso;
    }

    @PostMapping
    @ApiOperation("Crear curso")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoCurso comandoCurso){
        comandoCurso.setIdentificacion(UUID.randomUUID().toString());
        return manejadorCrearCurso.ejecutar(comandoCurso);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar curso")
    public void actualizar(@RequestBody ComandoCurso comandoCurso, @PathVariable Long id){
        comandoCurso.setId(id);
        this.manejadorActualizarCurso.ejecutar(comandoCurso);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar curso")
    public void eliminar(@PathVariable Long id){
        this.manejadorEliminarCurso.ejecutar(id);
    }
}
