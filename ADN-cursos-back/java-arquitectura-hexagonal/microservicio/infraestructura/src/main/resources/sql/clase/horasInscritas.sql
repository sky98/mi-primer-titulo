SELECT sum(curso.horas) FROM curso
    INNER JOIN clase ON clase.curso = curso.id
    WHERE clase.docente=:docente;

