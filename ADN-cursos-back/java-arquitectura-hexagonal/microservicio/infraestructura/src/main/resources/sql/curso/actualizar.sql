update curso
set identificacion = :identificacion,
    nombre = :nombre,
    descripcion = :descripcion,
    horas = :horas,
    docente = :docente
where id = :id