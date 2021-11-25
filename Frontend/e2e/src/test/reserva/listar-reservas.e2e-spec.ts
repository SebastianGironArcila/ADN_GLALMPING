
import { AppPage } from '../../app.po';
import { ToolBarPage } from '../../page/toolbar/toolbar.po';
import { ReservaTarjetaPage } from '../../page/reserva/tarjeta-reserva.po';


describe('Listar reservas',  () => {
    
    let page: AppPage
    let menu: ToolBarPage;
    let tarjeta:  ReservaTarjetaPage;
   

    beforeEach(() => {
        page = new AppPage();
        menu = new ToolBarPage();
        tarjeta = new ReservaTarjetaPage();
    
    });

    it('Deberia listar las reservas', async () => {
        await page.navigateTo();
        await menu.clickBotonReserva();

        expect(tarjeta.obtenerReservaId()).not.toBe('');
        expect(tarjeta.obtenerCedula()).not.toBe('');
        expect(tarjeta.obtenerFechas()).not.toBe('')
        expect(tarjeta.obtenerIdGlamping()).not.toBe('')
        expect(tarjeta.obtenerTelefono()).not.toBe('')
        expect(tarjeta.obtenerCostoTotal()).not.toBe('')


        
        
    })

});