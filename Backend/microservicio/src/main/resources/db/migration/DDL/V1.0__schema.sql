create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);


create table tipo(
    id int(11) not null auto_increment,
    definicion varchar(100) not null,
    cantPersonasMax int(11) not null,
    primary  key (id)

);

create table glamping(
     id int(11) not null auto_increment,
     idTipoGlamping int(11) not null,
     descripcion varchar(300) NOT NULL,
     precio double NOT NULL,
     estado int NOT NULL,
     PRIMARY KEY(id),
     FOREIGN KEY(idTipoGlamping)
         REFERENCES tipo(id)
         ON DELETE CASCADE
         ON UPDATE CASCADE

);

CREATE TABLE reserva (
     id int(11) not null auto_increment,
     idGlamping int(11) not null,
     cedula varchar(11) not null,
     nombre varchar(100) not null,
     fechaEntrada date not null,
     fechaSalida date not null,
     cantPersonas int not null,
     telefono varchar(20) not null,
     costoTotal double not null,
     fechaRegistro datetime not null,
     PRIMARY KEY(id),
     FOREIGN KEY(idGlamping)
         REFERENCES glamping(id)
         ON DELETE CASCADE
         ON UPDATE CASCADE
);

