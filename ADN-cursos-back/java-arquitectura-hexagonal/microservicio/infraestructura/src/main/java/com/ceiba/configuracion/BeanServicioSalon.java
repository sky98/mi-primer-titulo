package com.ceiba.configuracion;

import com.ceiba.salon.puerto.repositorio.RepositorioSalon;
import com.ceiba.salon.servicio.ServicioCrearSalon;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioSalon {
    @Bean
    public ServicioCrearSalon servicioCrearSalon(RepositorioSalon repositorioSalon){
        return new ServicioCrearSalon(repositorioSalon);
    }
}
