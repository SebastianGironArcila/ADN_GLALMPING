import { by, element } from 'protractor';

export class ToolBarPage {
    linkHome = element(by.xpath('/html/body/app-root/div/app-toolbar/mat-toolbar/div/nav/a[1]'));
    linkReserva = element(by.xpath('/html/body/app-root/div/app-toolbar/mat-toolbar/div/nav/a[2]'));
    linkBotonCrearReserva = element(by.id('crearOrden'));


    async clickBotonHome() {
        await this.linkHome.click();
    }

    async clickBotonReserva() {
        await this.linkReserva.click();
    }

    async clickBotonCrearReserva(){
        await this.linkBotonCrearReserva.click();
    }
}