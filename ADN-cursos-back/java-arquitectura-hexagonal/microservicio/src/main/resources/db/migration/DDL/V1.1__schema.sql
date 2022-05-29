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
 nombre varchar(100) not null,
 docente int(11) not null,
 curso int(11) not null,
 primary key (id)
);

create table horario(
 id int(11) not null auto_increment,
 clase int(11) not null,
 dia int(11) not null,
 hora_inicio int(11) not null,
 cantidad_horas int(11) not null,
 primary key (id)
);

create table salon(
 id int(11) not null auto_increment,
 alumno int(11) not null,
 curso int(11) not null,
 primary key (id)
);

create table persona (
 id int(11) not null auto_increment,
 identificacion varchar(100) not null,
 nombre varchar(100) not null,
 apellido varchar(100) not null,
 direccion varchar(100) not null,
 telefono varchar(100) not null,
 correo_electronico varchar(100) not null,
 tipo int(11) not null,
 primary key (id)
);