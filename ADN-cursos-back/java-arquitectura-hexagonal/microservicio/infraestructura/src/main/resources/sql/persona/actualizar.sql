update persona
set identificacion = :identificacion,
    nombre = :nombre,
    apellido = :apellido,
    direccion = :direccion,
    telefono = :telefono,
    correo_electronico = :correoElectronico,
    tipo = :tipo
where id = :id