//import { NavbarPage } from '../page/navbar/navbar.po';
import { AppPage } from '../app.po';
import { AlumnoPage } from '../page/alumno/alumno.po';

describe('workspace-project Alumno', () => {
    
    let page: AppPage;
    //let navBar: NavbarPage;
    let alumno: AlumnoPage;

    beforeEach(() => {
        page = new AppPage();
        //navBar = new NavbarPage();
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

        // Adicionamos las validaciones despues de la creación
        // expect(<>).toEqual(<>);
        await expect(0).toBe(alumno.contarAlumnos());
    });

    it('Deberia listar alumnos', async () => {        
        page.navigateTo();
        /* navBar.clickBotonAlumnos();
        alumno.clickBotonListarAlumnos(); */

        expect(0).toBe(alumno.contarAlumnos());
    });
});
