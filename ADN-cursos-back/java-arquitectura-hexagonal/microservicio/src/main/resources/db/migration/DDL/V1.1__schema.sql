create table docente (
 id int(11) not null auto_increment,
 identificacion varchar(100) not null,
 nombre varchar(100) not null,
 apellido varchar(100) not null,
 direccion varchar(100) not null,
 telefono varchar(100) not null,
 correo_electronico varchar(100) not null,
 primary key (id)
);