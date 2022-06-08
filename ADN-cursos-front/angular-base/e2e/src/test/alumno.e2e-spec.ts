import { AppPage } from '../app.po';
import { AlumnoPage } from '../page/alumno/alumno.po';

describe('workspace-project Alumno', () => {
    
    let page: AppPage;
    let alumno: AlumnoPage;

    beforeEach(() => {
        page = new AppPage();
        alumno = new AlumnoPage();
    });

    it('Deberia crear alumno', async () => {

        const IDENTIFICACION_ALUMNO = '12345';
        const NOMBRE_ALUMNO = 'Alumno de pruebas';
        const APELLIDO_ALUMNO = 'Alumno de pruebas';
        const DIRECCION_ALUMNO = 'Alumno de pruebas';
        const TELEFONO_ALUMNO = 'Alumno de pruebas';
        const CORREO_ELECTRONICO_ALUMNO = 'Alumno de pruebas';

        await page.navigateTo('/alumno/crear');
        await alumno.ingresarIdentificacion(IDENTIFICACION_ALUMNO);
        await alumno.ingresarNombre(NOMBRE_ALUMNO);
        await alumno.ingresarApellido(APELLIDO_ALUMNO);
        await alumno.ingresarDireccion(DIRECCION_ALUMNO);
        await alumno.ingresarTelefono(TELEFONO_ALUMNO);
        await alumno.ingresarCorreoElectronico(CORREO_ELECTRONICO_ALUMNO);

        await alumno.clickBotonGuardarAlumno();

        await expect(page.getLocation()).toMatch('/alumno/listar');
    });

    it('Deberia listar alumnos', async () => {        
        page.navigateTo('/alumno/listar');

        expect(0).toBe(alumno.contarAlumnos());
    });
});
