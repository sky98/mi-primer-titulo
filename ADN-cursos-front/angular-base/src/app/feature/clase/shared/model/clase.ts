export class Clase {
    id?                 : number;
    nombre              : string;
    docente             : number;
    curso               : number;
    nombreDocente?      : string;
    nombreCurso?        : string;
    
    constructor(id: number, nombre: string, docente: number, curso: number){
        this.id         = id;
        this.nombre     = nombre;
        this.docente    = docente;
        this.curso      = curso;
    }
}