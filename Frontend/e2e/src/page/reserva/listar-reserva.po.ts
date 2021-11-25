import { by, element} from 'protractor';

export class listarReservaPage{

    linkListarReservas = element(by.xpath('/html/body/app-root/div/app-toolbar/mat-toolbar/div/nav/a[2]'));

    async clickBotonListarReservas(){
        await this.linkListarReservas.click();
    }
}