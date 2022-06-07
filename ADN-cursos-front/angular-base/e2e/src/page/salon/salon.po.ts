import { by, element } from 'protractor';

export class SalonPage {
    private linkCrearSalon = element(by.id('linkCrearSalon'));
    private linkListarSalones = element(by.id('linkListarSalones'));

    private selectAlumnoSalon = element(by.id('alumnoSalon'));
    private selectCursoSalon = element(by.id('cursoSalon'));

    private buttonGuardarSalon = element(by.id('btnGuardarSalon'));

    async clickBotonCrearSalones() {
        await this.linkCrearSalon.click();
    }

    async clickBotonListarSalones() {
        await this.linkListarSalones.click();
    }

    async clickBotonGuardarSalon() {
        await this.buttonGuardarSalon.click();
    }

    async ingresarAlumno(alumno) {
        await this.selectAlumnoSalon.sendKeys(alumno);
    }

    async ingresarCurso(curso) {
        await this.selectCursoSalon.sendKeys(curso);
    }
}
