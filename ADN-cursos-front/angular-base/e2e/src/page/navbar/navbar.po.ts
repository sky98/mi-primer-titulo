import { by, element } from 'protractor';

export class NavbarPage {
    //linkHome = element(by.xpath('/html/body/app-root/app-navbar/nav/a[1]'));
    //linkProducto = element(by.xpath('/html/body/app-root/app-navbar/nav/a[2]'));
    linkAlumno = element(by.xpath('/html/body/app-root/app-navbar/nav/a[1]'));
    linkDocente = element(by.xpath('/html/body/app-root/app-navbar/nav/a[2]'));
    linkCurso = element(by.xpath('/html/body/app-root/app-navbar/nav/a[3]'));
    linkClase = element(by.xpath('/html/body/app-root/app-navbar/nav/a[4]'));
    linkHorario = element(by.xpath('/html/body/app-root/app-navbar/nav/a[5]'));
    linkSalon = element(by.xpath('/html/body/app-root/app-navbar/nav/a[6]'));

    async clickBotonAlumnos() {
        await this.linkAlumno.click();
    }
    async clickBotonDocentes() {
        await this.linkDocente.click();
    }
    async clickBotonCursos() {
        await this.linkCurso.click();
    }
    async clickBotonClases() {
        await this.linkClase.click();
    }
    async clickBotonHorarios() {
        await this.linkHorario.click();
    }
    async clickBotonSalones() {
        await this.linkSalon.click();
    }
}
