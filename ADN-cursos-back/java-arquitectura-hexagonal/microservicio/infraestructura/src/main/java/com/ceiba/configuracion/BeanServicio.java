package com.ceiba.configuracion;

import com.ceiba.alumno.puerto.repositorio.RepositorioAlumno;
import com.ceiba.alumno.servicio.ServicioActualizarAlumno;
import com.ceiba.alumno.servicio.ServicioCrearAlumno;
import com.ceiba.alumno.servicio.ServicioEliminarAlumno;
import com.ceiba.curso.puerto.repositorio.RepositorioCurso;
import com.ceiba.curso.servicio.ServicioActualizarCurso;
import com.ceiba.curso.servicio.ServicioCrearCurso;
import com.ceiba.curso.servicio.ServicioEliminarCurso;
import com.ceiba.docente.puerto.repositorio.RepositorioDocente;
import com.ceiba.docente.servicio.ServicioActualizarDocente;
import com.ceiba.docente.servicio.ServicioCrearDocente;
import com.ceiba.docente.servicio.ServicioEliminarDocente;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }
    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }
    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }
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
