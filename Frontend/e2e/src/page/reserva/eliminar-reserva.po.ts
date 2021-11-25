import { by, element} from 'protractor';


export class EliminarReservaPage{

    private linkBotonEliminarReserva = element(by.id('botonEliminarReserva'));
    private swal = element(by.className('swal2-title'));

    async clickBotonEliminarReserva(){
        await this.linkBotonEliminarReserva.click();
    }

    async getTextoSwal(): Promise<string> {
        return await this.swal.getText();
    }
}