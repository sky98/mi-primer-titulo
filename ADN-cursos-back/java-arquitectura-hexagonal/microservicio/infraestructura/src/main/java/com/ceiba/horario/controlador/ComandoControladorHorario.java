package com.ceiba.horario.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.horario.comando.ComandoHorario;
import com.ceiba.horario.comando.manejador.ManejadorActualizarHorario;
import com.ceiba.horario.comando.manejador.ManejadorCrearHorario;
import com.ceiba.horario.comando.manejador.ManejadorEliminarHorario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/horarios")
@Api(tags = "Controlador comando horario")
public class ComandoControladorHorario {

    private final ManejadorCrearHorario manejadorCrearHorario;
    private final ManejadorActualizarHorario manejadorActualizarHorario;
    private final ManejadorEliminarHorario manejadorEliminarHorario;

    @Autowired
    public ComandoControladorHorario(ManejadorCrearHorario manejadorCrearHorario, ManejadorActualizarHorario manejadorActualizarHorario, ManejadorEliminarHorario manejadorEliminarHorario) {
        this.manejadorCrearHorario = manejadorCrearHorario;
        this.manejadorActualizarHorario = manejadorActualizarHorario;
        this.manejadorEliminarHorario = manejadorEliminarHorario;
    }

    @PostMapping
    @ApiOperation("Crear horario")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoHorario comandoHorario){
        return manejadorCrearHorario.ejecutar(comandoHorario);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar horario")
    public void actualizar(@RequestBody ComandoHorario comandoHorario, @PathVariable Long id){
        comandoHorario.setId(id);
        this.manejadorActualizarHorario.ejecutar(comandoHorario);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar horario")
    public void eliminar(@PathVariable Long id){
        this.manejadorEliminarHorario.ejecutar(id);
    }
}
