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

create table alumno (
 id int(11) not null auto_increment,
 identificacion varchar(100) not null,
 nombre varchar(100) not null,
 apellido varchar(100) not null,
 direccion varchar(100) not null,
 telefono varchar(100) not null,
 correo_electronico varchar(100) not null,
 primary key (id)
);

create table curso (
 id int(11) not null auto_increment,
 identificacion varchar(100) not null,
 nombre varchar(100) not null,
 descripcion varchar(100) not null,
 horas int(11) not null,
 primary key (id)
);

create table clase (
 id int(11) not null auto_increment,
 docente int(11) not null,
 curso int(11) not null,
 primary key (id)
);