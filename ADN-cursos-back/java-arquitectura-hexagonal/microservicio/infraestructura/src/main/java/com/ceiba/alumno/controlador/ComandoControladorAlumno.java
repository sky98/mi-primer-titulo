package com.ceiba.alumno.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.alumno.comando.ComandoAlumno;
import com.ceiba.alumno.comando.manejador.ManejadorActualizarAlumno;
import com.ceiba.alumno.comando.manejador.ManejadorCrearAlumno;
import com.ceiba.alumno.comando.manejador.ManejadorEliminarAlumno;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alumnos")
@Api(tags = "Controlador comando alumno")
public class ComandoControladorAlumno {

    private final ManejadorCrearAlumno manejadorCrearAlumno;
    private final ManejadorActualizarAlumno manejadorActualizarAlumno;
    private final ManejadorEliminarAlumno manejadorEliminarAlumno;

    @Autowired
    public ComandoControladorAlumno(ManejadorCrearAlumno manejadorCrearAlumno, ManejadorActualizarAlumno manejadorActualizarAlumno, ManejadorEliminarAlumno manejadorEliminarAlumno) {
        this.manejadorCrearAlumno = manejadorCrearAlumno;
        this.manejadorActualizarAlumno = manejadorActualizarAlumno;
        this.manejadorEliminarAlumno = manejadorEliminarAlumno;
    }

    @PostMapping
    @ApiOperation("Crear alumno")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoAlumno comandoAlumno){
        return manejadorCrearAlumno.ejecutar(comandoAlumno);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar alumno")
    public void actualizar(@RequestBody ComandoAlumno comandoAlumno, @PathVariable Long id){
        comandoAlumno.setId(id);
        this.manejadorActualizarAlumno.ejecutar(comandoAlumno);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar alumno")
    public void eliminar(@PathVariable Long id){
        this.manejadorEliminarAlumno.ejecutar(id);
    }
}
