export class Persona {
    id?:               number;
    identificacion:    string;
    nombre:            string;
    apellido:          string;
    direccion:         string;
    telefono:          string;
    correoElectronico: string;
    tipo:              number;

    constructor(id: number, identificacion: string, nombre: string, apellido: string,
                direccion: string, telefono: string, correoElectronico: string, tipo: number) {
        this.id                 = id;
        this.identificacion     = identificacion;
        this.nombre             = nombre;
        this.apellido           = apellido;
        this.direccion          = direccion;
        this.telefono           = telefono;
        this.correoElectronico  = correoElectronico;
        this.tipo               = tipo;
    }
}