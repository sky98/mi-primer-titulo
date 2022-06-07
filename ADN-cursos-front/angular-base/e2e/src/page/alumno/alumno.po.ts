import { by, element } from 'protractor';

export class AlumnoPage {
    
    private linkCrearAlumno = element(by.id('linkCrearAlumno'));
    private linkListarAlumnos = element(by.id('linkListarAlumnos'));
    private listaAlumnos = element.all(by.css('.alumnos .element'));

    private inputIdentificacionAlumno = element(by.id('identificacionAlumno'));
    private inputNombreAlumno = element(by.id('nombreAlumno'));
    private inputApellidoAlumno = element(by.id('apellidoAlumno'));
    private inputDireccionAlumno = element(by.id('direccionAlumno'));
    private inputTelefonoAlumno = element(by.id('telefonoAlumno'));
    private inputCorreoElectronicoAlumno = element(by.id('correoElectronicoAlumno'));

    private buttonGuardarAlumno = element(by.id('btnGuardarAlumno'));

    async clickBotonCrearAlumnos() {
        await this.linkCrearAlumno.click();
    }

    async clickBotonListarAlumnos() {
        await this.linkListarAlumnos.click();
    }

    async clickBotonGuardarAlumno() {
        await this.buttonGuardarAlumno.click();
    }

    async ingresarIdentificacion(identificacionAlumno) {
        await this.inputIdentificacionAlumno.sendKeys(identificacionAlumno);
    }

    async ingresarNombre(nombreAlumno) {
        await this.inputNombreAlumno.sendKeys(nombreAlumno);
    }

    async ingresarApellido(apellidoAlumno) {
        await this.inputApellidoAlumno.sendKeys(apellidoAlumno);
    }
    
    async ingresarDireccion(direccionAlumno) {
        await this.inputDireccionAlumno.sendKeys(direccionAlumno);
    }

    async ingresarTelefono(telefonoAlumno) {
        await this.inputTelefonoAlumno.sendKeys(telefonoAlumno);
    }

    async ingresarCorreoElectronico(correoElectronicoAlumno) {
        await this.inputCorreoElectronicoAlumno.sendKeys(correoElectronicoAlumno);
    }

    async contarAlumnos() {
        return this.listaAlumnos.count();
    }
}
