import { by, element } from 'protractor';

export class CursoPage {
    
    private linkCrearCurso = element(by.id('linkCrearCurso'));
    private linkListarCursos = element(by.id('linkListarCursos'));
    private listaCursos = element.all(by.css('table.cursos td'));

    private inputNombreCurso = element(by.id('nombreCurso'));
    private inputDescripcionCurso = element(by.id('descripcionCurso'));
    private inputHorasCurso = element(by.id('horasCurso'));

    private buttonGuardarCurso = element(by.id('btnGuardarCurso'));

    async clickBotonCrearCursos() {
        await this.linkCrearCurso.click();
    }

    async clickBotonListarCursos() {
        await this.linkListarCursos.click();
    }

    async clickBotonGuardarCurso() {
        await this.buttonGuardarCurso.click();
    }

    async ingresarNombre(nombreCurso) {
        await this.inputNombreCurso.sendKeys(nombreCurso);
    }

    async ingresarDescripcion(descripcionCurso) {
        await this.inputDescripcionCurso.sendKeys(descripcionCurso);
    }
    
    async ingresarHoras(horasCurso) {
        await this.inputHorasCurso.sendKeys(horasCurso);
    }

    async contarCursos() {
        return this.listaCursos.count();
    }
}
