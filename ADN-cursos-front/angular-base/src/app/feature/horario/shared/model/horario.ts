export class Horario {
    id?           : string;
    clase         : number;
    dia           : number;
    horaInicio    : number;
    cantidadHoras : number;

    constructor(id: string, clase: number, dia: number, horaInicio: number, cantidadHoras: number) {
        this.id             = id;
        this.clase          = clase;
        this.dia            = dia;
        this.horaInicio     = horaInicio;
        this.cantidadHoras  = cantidadHoras;
    }
}
