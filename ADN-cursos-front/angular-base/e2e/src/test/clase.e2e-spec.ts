import { AppPage } from '../app.po';
import { ClasePage } from '../page/clase/clase.po';

describe('workspace-project Clase', () => {
    
    let page: AppPage;
    let clase: ClasePage;

    beforeEach(() => {
        page = new AppPage();
        clase = new ClasePage();
    });

    it('Deberia crear clase', async () => {

        const NOMBRE_CLASE = 'Clase de pruebas';
        const CURSO_CLASE = 'Curso 1';
        const DOCENTE_CLASE = 'Docente 1';

        await page.navigateTo('/clase/crear');
        await clase.ingresarNombre(NOMBRE_CLASE);
        await clase.ingresarCurso(CURSO_CLASE);
        await clase.ingresarDocente(DOCENTE_CLASE);

        await clase.clickBotonGuardarClase();

        await expect(page.getLocation()).toMatch('/clase/listar');
    });

    it('Deberia listar clases', async () => {        
        page.navigateTo('/clase/listar');

        expect(0).toBe(clase.contarClases());
    });
});
