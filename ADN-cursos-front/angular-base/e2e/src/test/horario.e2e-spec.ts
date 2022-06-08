import { AppPage } from '../app.po';
import { HorarioPage } from '../page/horario/horario.po';

describe('workspace-project Horario', () => {
    
    let page: AppPage;
    let horario: HorarioPage;

    beforeEach(() => {
        page = new AppPage();
        horario = new HorarioPage();
    });

    it('Deberia crear horario', async () => {

        const CLASE_HORARIO = 1;
        const DIA_HORARIO = 'Martes';
        const HORA_INICIO_HORARIO = '8 AM';
        const CANTIDAD_HORAS_HORARIO = '2';

        await page.navigateTo('/horario/crear');
        await horario.ingresarNombreClase(CLASE_HORARIO);
        await horario.ingresarDiaHorario(DIA_HORARIO);
        await horario.ingresarHoraHorario(HORA_INICIO_HORARIO);
        await horario.ingresarCantidadHorasHorario(CANTIDAD_HORAS_HORARIO);

        await horario.clickBotonGuardarHorario();

        await expect(page.getLocation()).toMatch('/horario/listar');
    });

    it('Deberia listar horarios', async () => {        
        page.navigateTo('/horario/listar');

        expect(0).toBe(horario.contarHorarios());
    });
});
