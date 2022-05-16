package com.ceiba.configuracion;

import com.ceiba.alumno.puerto.repositorio.RepositorioAlumno;
import com.ceiba.alumno.servicio.ServicioActualizarAlumno;
import com.ceiba.alumno.servicio.ServicioCrearAlumno;
import com.ceiba.alumno.servicio.ServicioEliminarAlumno;
import com.ceiba.clase.puerto.repositorio.RepositorioClase;
import com.ceiba.clase.servicio.ServicioActualizarClase;
import com.ceiba.clase.servicio.ServicioCrearClase;
import com.ceiba.clase.servicio.ServicioEliminarClase;
import com.ceiba.curso.puerto.repositorio.RepositorioCurso;
import com.ceiba.curso.servicio.ServicioActualizarCurso;
import com.ceiba.curso.servicio.ServicioCrearCurso;
import com.ceiba.curso.servicio.ServicioEliminarCurso;
import com.ceiba.docente.puerto.repositorio.RepositorioDocente;
import com.ceiba.docente.servicio.ServicioActualizarDocente;
import com.ceiba.docente.servicio.ServicioCrearDocente;
import com.ceiba.docente.servicio.ServicioEliminarDocente;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import com.ceiba.horario.servicio.ServicioActualizarHorario;
import com.ceiba.horario.servicio.ServicioCrearHorario;
import com.ceiba.horario.servicio.ServicioEliminarHorario;
import com.ceiba.salon.puerto.repositorio.RepositorioSalon;
import com.ceiba.salon.servicio.ServicioCrearSalon;
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
}
