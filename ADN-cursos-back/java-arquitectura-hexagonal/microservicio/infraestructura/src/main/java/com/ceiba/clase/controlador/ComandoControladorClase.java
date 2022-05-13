package com.ceiba.clase.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.clase.comando.ComandoClase;
import com.ceiba.clase.comando.manejador.ManejadorActualizarClase;
import com.ceiba.clase.comando.manejador.ManejadorCrearClase;
import com.ceiba.clase.comando.manejador.ManejadorEliminarClase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clases")
@Api(tags = "Controlador comando clase")
public class ComandoControladorClase {

    private final ManejadorCrearClase manejadorCrearClase;
    private final ManejadorActualizarClase manejadorActualizarClase;
    private final ManejadorEliminarClase manejadorEliminarClase;

    @Autowired
    public ComandoControladorClase(ManejadorCrearClase manejadorCrearClase, ManejadorActualizarClase manejadorActualizarClase, ManejadorEliminarClase manejadorEliminarClase) {
        this.manejadorCrearClase = manejadorCrearClase;
        this.manejadorActualizarClase = manejadorActualizarClase;
        this.manejadorEliminarClase = manejadorEliminarClase;
    }

    @PostMapping
    @ApiOperation("Crear clase")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoClase comandoClase){
        return manejadorCrearClase.ejecutar(comandoClase);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar clase")
    public void actualizar(@RequestBody ComandoClase comandoClase, @PathVariable Long id){
        comandoClase.setId(id);
        this.manejadorActualizarClase.ejecutar(comandoClase);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar clase")
    public void eliminar(@PathVariable Long id){
        this.manejadorEliminarClase.ejecutar(id);
    }
}
