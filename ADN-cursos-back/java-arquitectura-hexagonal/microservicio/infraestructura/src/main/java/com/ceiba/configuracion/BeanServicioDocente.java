package com.ceiba.configuracion;

import com.ceiba.docente.puerto.repositorio.RepositorioDocente;
import com.ceiba.docente.servicio.ServicioActualizarDocente;
import com.ceiba.docente.servicio.ServicioCrearDocente;
import com.ceiba.docente.servicio.ServicioEliminarDocente;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioDocente {
    @Bean
    public ServicioCrearDocente servicioCrearDocente(RepositorioDocente repositorioDocente){
        return new ServicioCrearDocente(repositorioDocente);
    }
    @Bean
    public ServicioActualizarDocente servicioActualizarDocente(RepositorioDocente repositorioDocente){
        return new ServicioActualizarDocente(repositorioDocente);
    }
    @Bean
    public ServicioEliminarDocente servicioEliminarDocente(RepositorioDocente repositorioDocente){
        return new ServicioEliminarDocente(repositorioDocente);
    }
}
