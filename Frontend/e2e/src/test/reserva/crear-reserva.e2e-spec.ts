
import { CrearReserva } from '../../page/reserva/crear-reserva.po';
import { AppPage } from '../../app.po';
import { ToolBarPage } from '../../page/toolbar/toolbar.po';



describe('Crear reserva',  () => {
    
    let page: AppPage
    let menu: ToolBarPage;
    let crearReserva: CrearReserva;
    const RESERVA_CREADA = "Reserva creada correctamente";
   

    beforeEach(() => {
        page = new AppPage();
        menu = new ToolBarPage();
        crearReserva = new CrearReserva();
    
    });

    it('Deberia crear la reserva', async () => {
        const NOMBRE = 'Mauricio';
        const CEDULA = '1118589632';
        const CANT_PERSONAS=2;
        const TELEFONO  = '3053198749';

        await page.navigateTo();
        await menu.clickBotonReserva();
        await menu.clickBotonCrearReserva();
        await crearReserva.clickInputNombre();
        await crearReserva.ingresarNombre(NOMBRE);
        await crearReserva.clickInputCedula();
        await crearReserva.ingresarCedula(CEDULA);
        await crearReserva.clickInputGlamping();
        await crearReserva.clickOpcionIdGlamping();
        await crearReserva.clickPickerFechaEntrada();
        await crearReserva.clickAniosPickerFechaEntrada();
        await crearReserva.clickBotonAdelanteAniosPickerFechaEntrada();
        await crearReserva.clickBotonAnioPickerFechaEntrada();
        await crearReserva.clickBotonMesPickerFechaEntrada();
        await crearReserva.clickBotonDiaPickerFechaEntrada();
        await crearReserva.clickPickerFechaSalida();
        await crearReserva.clickAniosPickerFechaSalida();
        await crearReserva.clickBotonAdelanteAniosPickerFechaSalida();
        await crearReserva.clickBotonAnioPickerFechaSalida();
        await crearReserva.clickBotonMesPickerFechaSalida();
        await crearReserva.clickBotonDiaPickerFechaSalida();        
        await crearReserva.clickInputCantPersonas();
        await crearReserva.ingresarCantPersonas(CANT_PERSONAS)
        await crearReserva.clickInputTelefono();
        await crearReserva.ingresarTelefono(TELEFONO);

        await crearReserva.clickBotonGuardarReserva();
        const alerta = await crearReserva.getTextoSwal();
        expect(alerta).toEqual(RESERVA_CREADA);
    
        
    })

});