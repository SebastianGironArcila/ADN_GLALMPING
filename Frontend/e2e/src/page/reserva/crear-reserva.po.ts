import { by, element} from 'protractor';

export class CrearReserva {

    private inputNombre = element(by.id("nombre"));
    private inputCedula = element(by.id("cedula"));
    private inputGlamping = element(by.id("idGlamping"));
    private inputFechaEntrada = element(by.id("fechaEntrada"));
    private inputFechaSalida = element(by.id("fechaSalida"));
    private inputCantPersonas = element(by.id("cantPersonas"));
    private inputTelefono = element(by.id("telefono"));
    private botonCrearReserva = element(by.id('crearOrden'));
    private botonGuardarReserva = element(by.id('guardarOrden'));
    private seleccionGlamping = element.all(by.id('opcionesGlamping'));
    private swal = element(by.className('swal2-title'));
    
    //fechaEntrada
    private pickerFechaEntrada = element(by.id('pickerFechaEntrada'));
    private aniosPickerFechaEntrada = element(by.xpath('html/body/div/div/div/mat-datepicker-content/div[2]/mat-calendar/mat-calendar-header/div/div/button[1]'));
    private botonAdelanteAniosPickerFechaEntrada  = element(by.xpath('html/body/div/div/div/mat-datepicker-content/div[2]/mat-calendar/mat-calendar-header/div/div/button[3]'));
    private botonAnioPickerFechaEntrada  = element(by.xpath('html/body/div/div/div/mat-datepicker-content/div[2]/mat-calendar/div/mat-multi-year-view/table/tbody/tr[3]/td[2]'));
    private botonMesPickerFechaEntrada  = element(by.xpath('html/body/div/div/div/mat-datepicker-content/div[2]/mat-calendar/div/mat-year-view/table/tbody/tr[3]/td[2]'));
    private botonDiaPickerFechaEntrada  = element(by.xpath('html/body/div/div/div/mat-datepicker-content/div[2]/mat-calendar/div/mat-month-view/table/tbody/tr[5]/td[4]'));

    //fechaSalida
    private pickerFechaSalida = element(by.id('pickerFechaSalida'));
    private aniosPickerFechaSalida = element(by.xpath('html/body/div/div[2]/div/mat-datepicker-content/div[2]/mat-calendar/mat-calendar-header/div/div/button[1]'));
    private botonAdelanteAniosPickerFechaSalida = element(by.xpath('html/body/div/div[2]/div/mat-datepicker-content/div[2]/mat-calendar/mat-calendar-header/div/div/button[3]'));
    private botonAnioPickerFechaSalida  = element(by.xpath('html/body/div/div[2]/div/mat-datepicker-content/div[2]/mat-calendar/div/mat-multi-year-view/table/tbody/tr[3]/td[2]'));
    private botonMesPickerFechaSalida  = element(by.xpath('html/body/div/div[2]/div/mat-datepicker-content/div[2]/mat-calendar/div/mat-year-view/table/tbody/tr[3]/td[2]'));
    private botonDiaPickerFechaSalida  = element(by.xpath('html/body/div/div[2]/div/mat-datepicker-content/div[2]/mat-calendar/div/mat-month-view/table/tbody/tr[5]/td[4]'));


   

    async clickInputNombre(){
        await this.inputNombre.click();
    }
    async ingresarNombre(nombre){
        await this.inputNombre.sendKeys(nombre)
    }
    async clickInputCedula(){
        await this.inputCedula.click();
    }
    async ingresarCedula(cedula){
        await this.inputCedula.sendKeys(cedula)
    }
    async clickInputGlamping(){
        await this.inputGlamping.click();
    }

    async clickOpcionIdGlamping(){
        await this.getOpcionIdGlamping().click();
    }
    
    getOpcionIdGlamping(){
        return this.seleccionGlamping.first();
    }

    async clickInputFechaEntrada(){
        await this.inputFechaEntrada.click();
    }
    async clickPickerFechaEntrada(){
        await this.pickerFechaEntrada.click();
    }
    async clickAniosPickerFechaEntrada(){
        await this.aniosPickerFechaEntrada.click();
    }
    async clickBotonAdelanteAniosPickerFechaEntrada(){
        await this.botonAdelanteAniosPickerFechaEntrada.click();
    }
    async clickBotonAnioPickerFechaEntrada(){
        await this.botonAnioPickerFechaEntrada.click();
    }
    async clickBotonMesPickerFechaEntrada(){
        await this.botonMesPickerFechaEntrada.click();
    }
    async clickBotonDiaPickerFechaEntrada(){
        await this.botonDiaPickerFechaEntrada.click();
    }

    async clickInputFechaSalida(){
        await this.inputFechaSalida.click();

    }

    async clickPickerFechaSalida(){
        await this.pickerFechaSalida.click();
    }

    async clickAniosPickerFechaSalida(){
        await this.aniosPickerFechaSalida.click();
    }

    async clickBotonAdelanteAniosPickerFechaSalida(){
        await this.botonAdelanteAniosPickerFechaSalida.click();
    }

    async clickBotonAnioPickerFechaSalida(){
        await this.botonAnioPickerFechaSalida.click();
    }   
    async clickBotonMesPickerFechaSalida(){
        await this.botonMesPickerFechaSalida.click();

    }

    async clickBotonDiaPickerFechaSalida(){
        await this.botonDiaPickerFechaSalida.click();
    }

    async clickInputCantPersonas(){
        await this.inputCantPersonas.click();

    }

    async ingresarCantPersonas(cantPersonas){
        await this.inputCantPersonas.sendKeys(cantPersonas)
    }
    
    async clickInputTelefono(){
        await this.inputTelefono.click();

    }

    async ingresarTelefono(telefono){
        await this.inputTelefono.sendKeys(telefono)
    }

    async clickBotonCrearReserva(){
        await this.botonCrearReserva.click();
    }

    async clickBotonGuardarReserva(){
        await this.botonGuardarReserva.click();
    }

    async getTextoSwal(): Promise<string> {
        return await this.swal.getText();
    }


    
}
