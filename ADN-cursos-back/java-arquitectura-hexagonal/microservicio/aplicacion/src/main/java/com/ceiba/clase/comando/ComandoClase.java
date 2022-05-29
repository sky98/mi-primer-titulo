package com.ceiba.clase.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoClase {
    private Long id;
    private String nombre;
    private Long docente;
    private Long curso;
}
