export class Clase {
    id?:     number;
    docente: number;
    curso:   number;
    
    constructor(id: number, docente: number, curso: number){
        this.id = id;
        this.docente = docente;
        this.curso = curso;
    }
}