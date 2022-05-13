select sum(curso.horas) from curso
    inner join clase on curso.id = clase.curso
        and clase.docente = :docente
        or curso.id = :curso

