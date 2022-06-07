import { by, element } from 'protractor';

export class HorarioPage {

    private linkCrearHorario = element(by.id('linkCrearHorario'));
    private linkListarHorarios = element(by.id('linkListarHorario'));
    private listaHorarios = element.all(by.css('ul.horarios li'));

    private selectNombreClaseHorario = element(by.id('nombreClaseHorario'));
    private selectDiaHorario = element(by.id('diaHorario'));
    private selectHoraHorario = element(by.id('horaHorario'));
    private selectCantidadHorasHorario = element(by.id('cantidadHorasHorario'));

    private buttonGuardarHorario = element(by.id('btnGuardarHorario'));

    async clickBotonCrearHorarios() {
        await this.linkCrearHorario.click();
    }

    async clickBotonListarHorarios() {
        await this.linkListarHorarios.click();
    }

    async clickBotonGuardarHorario() {
        await this.buttonGuardarHorario.click();
    }

    async ingresarNombreClase(nombreClase) {
        await this.selectNombreClaseHorario.sendKeys(nombreClase);
    }

    async ingresarDiaHorario(diaHorario) {
        await this.selectDiaHorario.sendKeys(diaHorario);
    }

    async ingresarHoraHorario(horaHorario) {
        await this.selectHoraHorario.sendKeys(horaHorario);
    }
    async ingresarCantidadHorasHorario(cantidadHorasHorario) {
        await this.selectCantidadHorasHorario.sendKeys(cantidadHorasHorario);
    }

    async contarHorarios() {
        return this.listaHorarios.count();
    }
}
