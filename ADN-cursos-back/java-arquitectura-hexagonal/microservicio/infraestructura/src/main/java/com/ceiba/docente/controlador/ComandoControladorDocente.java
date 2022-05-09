package com.ceiba.docente.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.docente.comando.ComandoDocente;
import com.ceiba.docente.comando.manejador.ManejadorActualizarDocente;
import com.ceiba.docente.comando.manejador.ManejadorCrearDocente;
import com.ceiba.docente.comando.manejador.ManejadorEliminarDocente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/docentes")
@Api(tags = "Controlador comando docente")
public class ComandoControladorDocente {

    private final ManejadorCrearDocente manejadorCrearDocente;
    private final ManejadorActualizarDocente manejadorActualizarDocente;
    private final ManejadorEliminarDocente manejadorEliminarDocente;

    @Autowired
    public ComandoControladorDocente(ManejadorCrearDocente manejadorCrearDocente, ManejadorActualizarDocente manejadorActualizarDocente, ManejadorEliminarDocente manejadorEliminarDocente) {
        this.manejadorCrearDocente = manejadorCrearDocente;
        this.manejadorActualizarDocente = manejadorActualizarDocente;
        this.manejadorEliminarDocente = manejadorEliminarDocente;
    }

    @PostMapping
    @ApiOperation("Crear usuario")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoDocente comandoDocente){
        return manejadorCrearDocente.ejecutar(comandoDocente);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar docente")
    public void actualizar(@RequestBody ComandoDocente comandoDocente, @PathVariable Long id){
        comandoDocente.setId(id);
        this.manejadorActualizarDocente.ejecutar(comandoDocente);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar docente")
    public void eliminar(@PathVariable Long id){
        this.manejadorEliminarDocente.ejecutar(id);
    }
}
