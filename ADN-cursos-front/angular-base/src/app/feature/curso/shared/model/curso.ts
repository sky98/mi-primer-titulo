export class Curso {
    id?:            number;
    identificacion: string;
    nombre:         string;
    descripcion:    string;
    horas:          number;

    constructor(id: number, identificacion: string, nombre: string, descripcion: string, horas: number){
        this.id             = id;
        this.identificacion = identificacion;
        this.nombre         = nombre;
        this.descripcion    = descripcion;
        this.horas          = horas;
    }

}
