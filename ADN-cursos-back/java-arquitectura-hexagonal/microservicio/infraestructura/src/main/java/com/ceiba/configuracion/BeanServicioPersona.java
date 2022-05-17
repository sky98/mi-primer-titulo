package com.ceiba.configuracion;

import com.ceiba.persona.puerto.repositorio.RepositorioPersona;
import com.ceiba.persona.servicio.ServicioActualizarPersona;
import com.ceiba.persona.servicio.ServicioCrearPersona;
import com.ceiba.persona.servicio.ServicioEliminarPersona;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioPersona {
    @Bean
    public ServicioCrearPersona servicioCrearPersona(RepositorioPersona repositorioPersona){
        return new ServicioCrearPersona(repositorioPersona);
    }
    @Bean
    public ServicioActualizarPersona servicioActualizarPersona(RepositorioPersona repositorioPersona){
        return new ServicioActualizarPersona(repositorioPersona);
    }
    @Bean
    public ServicioEliminarPersona servicioEliminarPersona(RepositorioPersona repositorioPersona){
        return new ServicioEliminarPersona(repositorioPersona);
    }
}
