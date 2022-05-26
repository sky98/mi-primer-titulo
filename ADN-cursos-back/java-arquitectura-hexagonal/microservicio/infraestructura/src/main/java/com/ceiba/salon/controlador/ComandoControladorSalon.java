package com.ceiba.salon.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.salon.comando.ComandoSalon;
import com.ceiba.salon.comando.manejador.ManejadorCrearSalon;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/salones")
@Api(tags = "Controlador comando salon")
@CrossOrigin(value = "*")
public class ComandoControladorSalon {

    private final ManejadorCrearSalon manejadorCrearSalon;

    @Autowired
    public ComandoControladorSalon(ManejadorCrearSalon manejadorCrearSalon) {
        this.manejadorCrearSalon = manejadorCrearSalon;
    }

    @PostMapping
    @ApiOperation("Crear salon")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoSalon comandoSalon){
        return manejadorCrearSalon.ejecutar(comandoSalon);
    }
}
