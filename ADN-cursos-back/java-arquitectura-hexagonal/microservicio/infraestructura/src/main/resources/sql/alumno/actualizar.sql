update alumno
set identificacion = :identificacion,
    nombre = :nombre,
    apellido = :apellido,
    direccion = :direccion,
    telefono = :telefono,
    correo_electronico = :correoElectronico
where id = :id