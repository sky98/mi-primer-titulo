import { by, element } from 'protractor';

export class ClasePage {

    private linkCrearClase = element(by.id('linkCrearClase'));
    private linkListarClases = element(by.id('linkListarClase'));
    private listaClases = element.all(by.css('table.clases td'));

    private inputNombreClase = element(by.id('nombreClase'));
    private selectCursoClase = element(by.id('cursoClase'));
    private selectDocenteClase = element(by.id('docenteClase'));

    private buttonGuardarClase = element(by.id('btnGuardarClase'));

    async clickBotonCrearClases() {
        await this.linkCrearClase.click();
    }

    async clickBotonListarClases() {
        await this.linkListarClases.click();
    }

    async clickBotonGuardarClase() {
        await this.buttonGuardarClase.click();
    }

    async ingresarNombre(idClase) {
        await this.inputNombreClase.sendKeys(idClase);
    }

    async ingresarCurso(cursoClase) {
        await this.selectCursoClase.sendKeys(cursoClase);
    }

    async ingresarDocente(docenteClase) {
        await this.selectDocenteClase.sendKeys(docenteClase);
    }

    async contarClases() {
        return this.listaClases.count();
    }
}
