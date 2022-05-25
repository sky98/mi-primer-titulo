import { Persona } from "src/app/feature/shared/model/persona";

export class Alumno extends Persona{

    constructor(id: number, identificacion: string, nombre: string, apellido: string,
                direccion: string, telefono: string, correoElectronico: string, tipo: number) {
       super(id, identificacion,nombre,apellido, direccion, telefono, correoElectronico, tipo);
    }
}