export class Salon {
    id?     : number;
    alumno  : number;
    curso   : number;

    constructor(id: number, alumno: number, curso: number){
        this.id     = id;
        this.alumno = alumno;
        this.curso  = curso;
    }

}
