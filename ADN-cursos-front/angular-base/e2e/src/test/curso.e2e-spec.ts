import { AppPage } from '../app.po';
import { CursoPage } from '../page/curso/curso.po';

describe('workspace-project Curso', () => {
    
    let page: AppPage;
    let curso: CursoPage;

    beforeEach(() => {
        page = new AppPage();
        curso = new CursoPage();
    });

    it('Deberia crear curso', async () => {

        const NOMBRE_CURSO = 'Curso de pruebas';
        const DESCRIPCION_CURSO = 'Curso de pruebas';
        const HORAS_CURSO = 'Curso de pruebas';

        await page.navigateTo('/curso/crear');
        await curso.ingresarNombre(NOMBRE_CURSO);
        await curso.ingresarDescripcion(DESCRIPCION_CURSO);
        await curso.ingresarHoras(HORAS_CURSO);

        await curso.clickBotonGuardarCurso();

        // Adicionamos las validaciones despues de la creación
        // expect(<>).toEqual(<>);
        await expect(1).toBe(curso.contarCursos());
    });

    it('Deberia listar cursos', async () => {        
        page.navigateTo('/curso/listar');

        expect(0).toBe(curso.contarCursos());
    });
});
