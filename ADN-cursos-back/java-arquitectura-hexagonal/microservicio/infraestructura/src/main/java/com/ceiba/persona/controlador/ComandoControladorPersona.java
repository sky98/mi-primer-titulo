package com.ceiba.persona.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.persona.comando.ComandoPersona;
import com.ceiba.persona.comando.manejador.ManejadorActualizarPersona;
import com.ceiba.persona.comando.manejador.ManejadorCrearPersona;
import com.ceiba.persona.comando.manejador.ManejadorEliminarPersona;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personas")
@Api(tags = "Controlador comando persona")
@CrossOrigin(value = "*")
public class ComandoControladorPersona {

    private final ManejadorCrearPersona manejadorCrearPersona;
    private final ManejadorActualizarPersona manejadorActualizarPersona;
    private final ManejadorEliminarPersona manejadorEliminarPersona;

    @Autowired
    public ComandoControladorPersona(ManejadorCrearPersona manejadorCrearPersona, ManejadorActualizarPersona manejadorActualizarPersona, ManejadorEliminarPersona manejadorEliminarPersona) {
        this.manejadorCrearPersona = manejadorCrearPersona;
        this.manejadorActualizarPersona = manejadorActualizarPersona;
        this.manejadorEliminarPersona = manejadorEliminarPersona;
    }

    @PostMapping
    @ApiOperation("Crear persona")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoPersona comandoPersona){
        return manejadorCrearPersona.ejecutar(comandoPersona);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar persona")
    public void actualizar(@RequestBody ComandoPersona comandoPersona, @PathVariable Long id){
        comandoPersona.setId(id);
        this.manejadorActualizarPersona.ejecutar(comandoPersona);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar persona")
    public void eliminar(@PathVariable Long id){
        this.manejadorEliminarPersona.ejecutar(id);
    }
}
