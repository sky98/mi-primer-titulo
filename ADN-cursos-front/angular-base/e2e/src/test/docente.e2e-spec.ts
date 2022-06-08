import { AppPage } from '../app.po';
import { DocentePage } from '../page/docente/docente.po';

describe('workspace-project Docente', () => {
    
    let page: AppPage;
    let docente: DocentePage;

    beforeEach(() => {
        page = new AppPage();
        docente = new DocentePage();
    });

    it('Deberia crear docente', async () => {

        const IDENTIFICACION_DOCENTE = '12345';
        const NOMBRE_DOCENTE = 'Docente de pruebas';
        const APELLIDO_DOCENTE = 'Docente de pruebas';
        const DIRECCION_DOCENTE = 'Docente de pruebas';
        const TELEFONO_DOCENTE = 'Docente de pruebas';
        const CORREO_ELECTRONICO_DOCENTE = 'Docente de pruebas';

        await page.navigateTo('/docente/crear');
        await docente.ingresarIdentificacion(IDENTIFICACION_DOCENTE);
        await docente.ingresarNombre(NOMBRE_DOCENTE);
        await docente.ingresarApellido(APELLIDO_DOCENTE);
        await docente.ingresarDireccion(DIRECCION_DOCENTE);
        await docente.ingresarTelefono(TELEFONO_DOCENTE);
        await docente.ingresarCorreoElectronico(CORREO_ELECTRONICO_DOCENTE);

        await docente.clickBotonGuardarDocente();

        await expect(page.getLocation()).toMatch('/docente/listar');
    });

    it('Deberia listar docentes', async () => {        
        page.navigateTo('/docente/listar');

        expect(0).toBe(docente.contarDocentes());
    });
});
