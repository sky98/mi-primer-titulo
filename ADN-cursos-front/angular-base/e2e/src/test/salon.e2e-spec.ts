import { AppPage } from '../app.po';
import { SalonPage } from '../page/salon/salon.po';

describe('workspace-project Salon', () => {
    
    let page: AppPage;
    let salon: SalonPage;

    beforeEach(() => {
        page = new AppPage();
        salon = new SalonPage();
    });

    it('Deberia crear salon', async () => {

        const ALUMNO_SALON = 'Alumno 1';
        const CURSO_SALON = 'Curso 1';

        await page.navigateTo('/salon/crear');
        await salon.ingresarAlumno(ALUMNO_SALON);
        await salon.ingresarCurso(CURSO_SALON);

        await salon.clickBotonGuardarSalon();

        
    });
});
