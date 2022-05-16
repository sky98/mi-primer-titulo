select sum(curso.horas) from salon
    inner join curso on salon.curso = curso.id
    where salon.alumno = :alumno