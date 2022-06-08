package com.ceiba.base;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum TipoUsuario {

    ESTUDIANTE(1),
    DOCENTE(2);

    private int code;
    
    private TipoUsuario(int code) { this.code = code; }

    @JsonCreator
    public static TipoUsuario decode(final int name){
        return Stream.of(TipoUsuario.values()).filter(x -> x.code == name).findFirst().orElse(null);
    }

    @JsonValue
    public int getCode(){
        return code;
    }

}
