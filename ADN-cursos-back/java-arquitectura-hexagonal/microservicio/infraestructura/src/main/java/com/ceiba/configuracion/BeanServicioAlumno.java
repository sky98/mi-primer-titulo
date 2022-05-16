package com.ceiba.configuracion;

import com.ceiba.alumno.puerto.repositorio.RepositorioAlumno;
import com.ceiba.alumno.servicio.ServicioActualizarAlumno;
import com.ceiba.alumno.servicio.ServicioCrearAlumno;
import com.ceiba.alumno.servicio.ServicioEliminarAlumno;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioAlumno {
    @Bean
    public ServicioCrearAlumno servicioCrearAlumno(RepositorioAlumno repositorioAlumno){
        return new ServicioCrearAlumno(repositorioAlumno);
    }
    @Bean
    public ServicioActualizarAlumno servicioActualizarAlumno(RepositorioAlumno repositorioAlumno){
        return new ServicioActualizarAlumno(repositorioAlumno);
    }
    @Bean
    public ServicioEliminarAlumno servicioEliminarAlumno(RepositorioAlumno repositorioAlumno){
        return new ServicioEliminarAlumno(repositorioAlumno);
    }
}
