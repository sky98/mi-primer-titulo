export class Horario {
    id?                     : string;
    clase                   : number;
    nombreClase?            : string;
    dia                     : number;
    nombreDia?              : string;
    horaInicio              : number;
    horaInicioConTiempo?    : string;
    cantidadHoras           : number;

    constructor(id: string, clase: number, dia: number, horaInicio: number, cantidadHoras: number) {
        this.id             = id;
        this.clase          = clase;
        this.dia            = dia;
        this.horaInicio     = horaInicio;
        this.cantidadHoras  = cantidadHoras;
    }
}

export interface Dias {
    id      : number;
    nombre  : string;    
}
