drop database if exists Ejemplo;
Create database Ejemplo ;
use Ejemplo;

create table agenda (
	codigo int auto_increment primary key ,
    nombre varchar(50) not null,
    apellido varchar(50)not null,
    descripcion varchar(50) not null,
    telefono varchar(50) not null
);

select * from agenda ;