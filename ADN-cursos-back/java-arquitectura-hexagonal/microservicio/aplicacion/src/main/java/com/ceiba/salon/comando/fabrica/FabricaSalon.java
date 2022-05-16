package com.ceiba.salon.comando.fabrica;

import com.ceiba.salon.comando.ComandoSalon;
import com.ceiba.salon.modelo.entidad.Salon;
import org.springframework.stereotype.Component;

@Component
public class FabricaSalon {
    public Salon crear(ComandoSalon comandoSalon){
        return new Salon(comandoSalon.getId(),
                comandoSalon.getAlumno(),
                comandoSalon.getCurso());
    }
}
