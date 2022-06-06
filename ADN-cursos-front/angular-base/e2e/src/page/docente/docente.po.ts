import { by, element } from 'protractor';

export class DocentePage {

    private linkCrearDocente = element(by.id('linkCrearDocente'));
    private linkListarDocentes = element(by.id('linkListarDocentes'));
    private listaDocentes = element.all(by.css('table.docentes td'));

    private inputIdentificacionDocente = element(by.id('identificacionDocente'));
    private inputNombreDocente = element(by.id('nombreDocente'));
    private inputApellidoDocente = element(by.id('apellidoDocente'));
    private inputDireccionDocente = element(by.id('direccionDocente'));
    private inputTelefonoDocente = element(by.id('telefonoDocente'));
    private inputCorreoElectronicoDocente = element(by.id('correoElectronicoDocente'));

    private buttonGuardarDocente = element(by.id('btnGuardarDocente'));

    async clickBotonCrearDocentes() {
        await this.linkCrearDocente.click();
    }

    async clickBotonListarDocentes() {
        await this.linkListarDocentes.click();
    }

    async clickBotonGuardarDocente() {
        await this.buttonGuardarDocente.click();
    }

    async ingresarIdentificacion(identificacionDocente) {
        await this.inputIdentificacionDocente.sendKeys(identificacionDocente);
    }

    async ingresarNombre(nombreDocente) {
        await this.inputNombreDocente.sendKeys(nombreDocente);
    }

    async ingresarApellido(apellidoDocente) {
        await this.inputApellidoDocente.sendKeys(apellidoDocente);
    }
    
    async ingresarDireccion(direccionDocente) {
        await this.inputDireccionDocente.sendKeys(direccionDocente);
    }

    async ingresarTelefono(telefonoDocente) {
        await this.inputTelefonoDocente.sendKeys(telefonoDocente);
    }

    async ingresarCorreoElectronico(correoElectronicoDocente) {
        await this.inputCorreoElectronicoDocente.sendKeys(correoElectronicoDocente);
    }

    async contarDocentes() {
        return this.listaDocentes.count();
    }
}
