package com.ceiba.configuracion;

import com.ceiba.curso.puerto.repositorio.RepositorioCurso;
import com.ceiba.curso.servicio.ServicioActualizarCurso;
import com.ceiba.curso.servicio.ServicioCrearCurso;
import com.ceiba.curso.servicio.ServicioEliminarCurso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioCurso {
    @Bean
    public ServicioCrearCurso servicioCrearCurso(RepositorioCurso repositorioCurso){
        return new ServicioCrearCurso(repositorioCurso);
    }
    @Bean
    public ServicioActualizarCurso servicioActualizarCurso(RepositorioCurso repositorioCurso){
        return new ServicioActualizarCurso(repositorioCurso);
    }
    @Bean
    public ServicioEliminarCurso servicioEliminarCurso(RepositorioCurso repositorioCurso){
        return new ServicioEliminarCurso(repositorioCurso);
    }
}
