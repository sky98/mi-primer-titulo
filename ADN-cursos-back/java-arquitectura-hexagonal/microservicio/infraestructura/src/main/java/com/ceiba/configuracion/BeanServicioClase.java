package com.ceiba.configuracion;

import com.ceiba.clase.puerto.repositorio.RepositorioClase;
import com.ceiba.clase.servicio.ServicioActualizarClase;
import com.ceiba.clase.servicio.ServicioCrearClase;
import com.ceiba.clase.servicio.ServicioEliminarClase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioClase {
    @Bean
    public ServicioCrearClase servicioCrearClase(RepositorioClase repositorioClase){
        return new ServicioCrearClase(repositorioClase);
    }
    @Bean
    public ServicioActualizarClase servicioActualizarClase(RepositorioClase repositorioClase){
        return new ServicioActualizarClase(repositorioClase);
    }
    @Bean
    public ServicioEliminarClase servicioEliminarClase(RepositorioClase repositorioClase){
        return new ServicioEliminarClase(repositorioClase);
    }
}
