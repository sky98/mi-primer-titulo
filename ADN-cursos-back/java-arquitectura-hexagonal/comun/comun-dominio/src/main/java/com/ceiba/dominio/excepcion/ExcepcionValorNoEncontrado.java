package com.ceiba.dominio.excepcion;

public class ExcepcionValorNoEncontrado extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public ExcepcionValorNoEncontrado(String message){ super(message);}
}
