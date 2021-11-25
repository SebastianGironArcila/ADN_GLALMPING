import { AppPage } from '../../app.po';
import { ToolBarPage } from '../../page/toolbar/toolbar.po';
import { EliminarReservaPage } from '../../page/reserva/eliminar-reserva.po';

describe('Eliminar reserva', () => {
    let page: AppPage;
    let menu: ToolBarPage;
    let eliminarReserva: EliminarReservaPage;
    const RESERVA_ELIMINADA = 'Reserva eliminada correctamente';

    beforeEach(() => {
        page = new AppPage();
        menu = new ToolBarPage();
        eliminarReserva = new EliminarReservaPage();
    
    });

    it('Deberia eliminar la reserva' , async () => {
        await page.navigateTo();
        await menu.clickBotonReserva();
        await eliminarReserva.clickBotonEliminarReserva();

        const alerta = await eliminarReserva.getTextoSwal();
        expect(alerta).toEqual(RESERVA_ELIMINADA);
    })

})