create database BancoDeAgricultura character set utf8mb4 collate utf8mb4_bin;
use BancoDeAgricultura;

create table Cliente(

    ID int auto_increment primary key not null,
    Nombres varchar(100) not null,
    Apellidos varchar(100) not null,
    Genero varchar(10) not null,
    DUI char(10) not null,
    FechaDeNacimiento date not null,
    EstadoCivil varchar(12) not null,
    Ocupacion varchar(60) not null,
    IngresoMensual decimal(6,2) not null,
    TelefonoMovil char(9) not null,
    CorreoElectronico varchar(100) not null,
    Direccion text not null,
    ClasificacionDeCliente varchar(12) default 'Cliente' not null,

    check (Genero in ('Masculino','Femenino')),
    check (EstadoCivil in ('Soltero/a','Casado/a','Divorciado/a','Viudo/a','Unido/a')),
    check (ClasificacionDeCliente in ('Cliente','Prestamista'))

);

create table Dependiente(

    ID int auto_increment primary key not null,
    Nombres varchar(100) not null,
    Apellidos varchar(100) not null,
    Genero varchar(10) not null,
    DUI char(10) not null,
    FechaDeNacimiento date not null,
    EstadoCivil varchar(12) not null,
    Negocio text not null,
    Ocupacion varchar(60) not null,
    IngresoMensual decimal(6,2) not null,
    TelefonoMovil char(9) not null,
    CorreoElectronico varchar(100) not null,
    Direccion text not null,

    check (Genero in ('Masculino','Femenino')),
    check (EstadoCivil in ('Soltero/a','Casado/a','Divorciado/a','Viudo/a','Unido/a'))

);

create table Cuenta(

    ID int auto_increment primary key not null,
    NumeroDeCuenta char(20) not null,
    TipoDeCuenta varchar(10) not null,
    FechaDeApertura date not null,
    Saldo decimal(6,2) not null,
    Estado varchar(8) default 'Activa' not null,
    ID_Cliente int, -- Llave Foranea
    ID_Dependiente int, -- Llave Foranea

    check(TipoDeCuenta in ('Ahorro','Corriente')),
    check (Estado in ('Activa','Inactiva'))

);

create table Transaccion(

    ID int auto_increment primary key not null,
    ID_CuentaOrigen int not null, -- Llave Foranea
    TipoDeTransaccion varchar(14) not null,
    Monto decimal(6,2) not null,
    FechaHora datetime not null,
    ID_CuentaDestino int, -- Llave Foranea
    ID_Empleado int, -- Llave Foranea
    ComisionEmpleado int default 0 not null,

    check (TipoDeTransaccion in ('Depósito','Retiro','Transferencia'))

);

create table CredencialCliente(

    ID int auto_increment primary key not null,
    Usuario varchar(50) not null,
    Contrasena varchar(70) not null,
    ID_Cliente int not null -- Llave Foranea

);

create table CredencialEmpleado(

   ID int auto_increment primary key not null,
   Usuario varchar(50) not null,
   Contrasena varchar(70) not null,
   ID_Empleado int, -- Llave Foranea
   ID_Gerente int -- Llave Foranea

);

create table Empleado(

     ID int auto_increment primary key not null,
     Nombres varchar(100) not null,
     Apellidos varchar(100) not null,
     Genero varchar(10) not null,
     DUI char(10) not null,
     FechaDeNacimiento date not null,
     TelefonoMovil char(9) not null,
     CorreoElectronico varchar(100) not null,
     Direccion text not null,
     Cargo varchar(60) default 'Cajero' not null,
     Estado varchar(8) default 'Activo' not null,
     ID_Gerente int, -- Llave Foranea

     check (Genero in ('Masculino','Femenino')),
     check (Estado in ('Activo','Inactivo'))

);

create table Gerente(

    ID int auto_increment primary key not null,
    Nombres varchar(100) not null,
    Apellidos varchar(100) not null,
    Genero varchar(10) not null,
    DUI char(10) not null,
    FechaDeNacimiento date not null,
    TelefonoMovil char(9) not null,
    CorreoElectronico varchar(100) not null,
    Direccion text not null,
    Cargo varchar(20) default 'Gerente de Sucursal' not null,
    ID_Sucursal int, -- Llave Foranea
    Estado varchar(8) default 'Activo' not null,

    check (Genero in ('Masculino','Femenino')),
    check (Cargo in ('Gerente de Sucursal','Gerente General')),
    check (Estado in ('Activo','Inactivo'))

);

create table Sucursal(

     ID int auto_increment primary key not null,
     Direccion text not null,
     TelefonoFijo char(9) not null,
     CorreoElectronico varchar(100)

);

create table Prestamo(

     ID int auto_increment primary key not null,
     ID_Cliente int not null, -- Llave Foranea
     Monto decimal(6,2) not null,
     FechaHoraSolicitud datetime not null,
     Estado varchar(10) default 'En Espera' not null,
     CuotaMensual decimal(6,2) default 0,
     PlazoAnios int default 0,
     Interes int default 0,
     FechaHoraRespuesta datetime,
     MotivoDeRechazo text,
     ID_Empleado int, -- Llave Foranea

     check (Estado in ('Aprobado','En Espera','Rechazado'))

);

-- ************************************************ ↓ Llaves Foráneas ↓ ************************************************ --

alter table Cuenta
add foreign key (ID_Cliente) references Cliente(ID),
add foreign key (ID_Dependiente) references Dependiente(ID);

alter table Transaccion
add foreign key (ID_CuentaOrigen) references Cuenta(ID),
add foreign key (ID_CuentaDestino) references Cuenta(ID),
add foreign key (ID_Empleado) references Empleado(ID);

alter table CredencialCliente
add foreign key (ID_Cliente) references Cliente(ID);

alter table CredencialEmpleado
add foreign key (ID_Empleado) references Empleado(ID),
add foreign key (ID_Gerente) references Gerente(ID);

alter table Empleado
add foreign key (ID_Gerente) references Gerente(ID);

alter table Gerente
add foreign key (ID_Sucursal) references Sucursal(ID);

alter table Prestamo
add foreign key (ID_Cliente) references Cliente(ID),
add foreign key (ID_Empleado) references Empleado(ID);

-- ************************************************ ↓ Inserción de datos ↓ ************************************************ --

insert into Cliente (Nombres, Apellidos, Genero, DUI, FechaDeNacimiento, EstadoCivil, Ocupacion, IngresoMensual, TelefonoMovil, CorreoElectronico, Direccion, ClasificacionDeCliente)
values
('Juan', 'Perez', 'Masculino', '01234567-8', '1985-06-15', 'Casado/a', 'Ingeniero', 1500.00, '7123-4567', 'juan.perez@mail.com', 'Calle Falsa 123', 'Cliente'),
('Ana', 'Martinez', 'Femenino', '02345678-9', '1990-08-23', 'Soltero/a', 'Doctora', 2000.00, '6123-4567', 'ana.martinez@mail.com', 'Avenida Central 456', 'Cliente'),
('Luis', 'Gomez', 'Masculino', '03456789-0', '1978-12-01', 'Casado/a', 'Abogado', 1800.50, '7123-4568', 'luis.gomez@mail.com', 'Calle Real 789', 'Cliente'),
('Maria', 'Lopez', 'Femenino', '04567890-1', '1987-03-14', 'Unido/a', 'Contadora', 2500.00, '6123-4568', 'maria.lopez@mail.com', 'Colonia Jardines 101', 'Prestamista'),
('Carlos', 'Hernandez', 'Masculino', '05678901-2', '1980-11-09', 'Divorciado/a', 'Profesor', 1200.00, '7223-4567', 'carlos.hernandez@mail.com', 'Barrio San Jose 202', 'Cliente'),
('Lucia', 'Ramirez', 'Femenino', '06789012-3', '1995-04-22', 'Soltero/a', 'Arquitecta', 3000.00, '7323-4567', 'lucia.ramirez@mail.com', 'Residencial Los Pinos 303', 'Cliente'),
('Andres', 'Morales', 'Masculino', '07890123-4', '1982-02-10', 'Casado/a', 'Mecanico', 900.00, '7423-4567', 'andres.morales@mail.com', 'Callejon Los Naranjos 404', 'Prestamista'),
('Sofia', 'Gutierrez', 'Femenino', '08901234-5', '1988-09-30', 'Unido/a', 'Psicologa', 1750.00, '7523-4567', 'sofia.gutierrez@mail.com', 'Colonia Bella Vista 505', 'Cliente'),
('Pedro', 'Sanchez', 'Masculino', '09012345-6', '1993-07-25', 'Soltero/a', 'Electricista', 850.00, '7623-4567', 'pedro.sanchez@mail.com', 'Barrio Nuevo 606', 'Cliente'),
('Laura', 'Cruz', 'Femenino', '10123456-7', '1984-01-05', 'Casado/a', 'Veterinaria', 2200.00, '7723-4567', 'laura.cruz@mail.com', 'Residencial Alameda 707', 'Cliente');

insert into Dependiente (Nombres, Apellidos, Genero, DUI, FechaDeNacimiento, EstadoCivil, Negocio, Ocupacion, IngresoMensual, TelefonoMovil, CorreoElectronico, Direccion)
values
('Carlos', 'Lopez', 'Masculino', '11234567-8', '1980-05-10', 'Casado/a', 'Venta de Electronicos', 'Vendedor', 1000.00, '7123-4567', 'carlos.lopez@mail.com', 'Centro Comercial 1'),
('Juana', 'Perez', 'Femenino', '12234567-9', '1991-06-12', 'Soltero/a', 'Tienda de Ropa', 'Comerciante', 1500.00, '6223-4567', 'juana.perez@mail.com', 'Centro Comercial 2'),
('Manuel', 'Gomez', 'Masculino', '13234567-0', '1983-08-22', 'Unido/a', 'Papeleria', 'Gerente', 2000.00, '7323-4567', 'manuel.gomez@mail.com', 'Colonia Las Flores'),
('Elena', 'Rodriguez', 'Femenino', '14234567-1', '1987-03-14', 'Divorciado/a', 'Cafeteria', 'Cocinera', 1200.00, '7423-4567', 'elena.rodriguez@mail.com', 'Barrio San Juan'),
('David', 'Ramirez', 'Masculino', '15234567-2', '1977-12-18', 'Casado/a', 'Panaderia', 'Panadero', 900.00, '7523-4567', 'david.ramirez@mail.com', 'Colonia La Paz'),
('Rosa', 'Martinez', 'Femenino', '16234567-3', '1990-09-09', 'Soltero/a', 'Salon de Belleza', 'Estilista', 1300.00, '7623-4567', 'rosa.martinez@mail.com', 'Residencial Las Lomas'),
('Pedro', 'Cruz', 'Masculino', '17234567-4', '1984-05-15', 'Casado/a', 'Taller Mecanico', 'Mecanico', 1100.00, '7723-4567', 'pedro.cruz@mail.com', 'Barrio Nuevo'),
('Marta', 'Sanchez', 'Femenino', '18234567-5', '1992-10-12', 'Unido/a', 'Clinica Dental', 'Dentista', 2500.00, '7823-4567', 'marta.sanchez@mail.com', 'Residencial Alameda'),
('Oscar', 'Hernandez', 'Masculino', '19234567-6', '1979-01-22', 'Viudo/a', 'Venta de Frutas', 'Vendedor', 800.00, '7923-4567', 'oscar.hernandez@mail.com', 'Mercado Central'),
('Lucia', 'Gutierrez', 'Femenino', '20234567-7', '1985-03-30', 'Divorciado/a', 'Restaurante', 'Mesera', 950.00, '8123-4567', 'lucia.gutierrez@mail.com', 'Colonia Jardines');

insert into Sucursal (Direccion, TelefonoFijo, CorreoElectronico)
values
('Calle 1, San Salvador', '2123-4567', 'sucursal1@mail.com'),
('Calle 2, Santa Ana', '2223-4567', 'sucursal2@mail.com'),
('Calle 3, San Miguel', '2323-4567', 'sucursal3@mail.com'),
('Calle 4, Usulután', '2423-4567', 'sucursal4@mail.com'),
('Calle 5, La Libertad', '2523-4567', 'sucursal5@mail.com');

insert into Gerente (Nombres, Apellidos, Genero, DUI, FechaDeNacimiento, TelefonoMovil, CorreoElectronico, Direccion, Cargo, ID_Sucursal, Estado)
values
('Luis', 'Garcia', 'Masculino', '20234567-8', '1980-07-05', '7223-4567', 'luis.garcia@mail.com', 'Colonia A', 'Gerente de Sucursal', 1,'Activo'),
('Sofia', 'Mendoza', 'Femenino', '21234567-9', '1985-10-12', '7323-4567', 'sofia.mendoza@mail.com', 'Colonia B', 'Gerente de Sucursal', 2,'Activo'),
('Carlos', 'Ruiz', 'Masculino', '22234567-0', '1982-01-20', '7423-4567', 'carlos.ruiz@mail.com', 'Colonia C', 'Gerente de Sucursal', null, 'Inactivo'),
('Maria', 'Perez', 'Femenino', '23234567-1', '1987-03-14', '7523-4567', 'maria.perez@mail.com', 'Colonia D', 'Gerente de Sucursal', 4, 'Activo'),
('Ana', 'Lopez', 'Femenino', '25234567-3', '1990-06-18', '7723-4567', 'ana.lopez@mail.com', 'Colonia E', 'Gerente de Sucursal', 5, 'Activo'),
('Juan', 'Flores', 'Masculino', '24234567-2', '1983-09-09', '7623-4567', 'juan.flores@mail.com', 'Colonia F', 'Gerente General', null, 'Activo');

insert into Empleado (Nombres, Apellidos, Genero, DUI, FechaDeNacimiento, TelefonoMovil, CorreoElectronico, Direccion, Cargo, Estado, ID_Gerente)
values
('Jose', 'Morales', 'Masculino', '10234567-8', '1990-05-15', '7123-4567', 'jose.morales@mail.com', 'Calle 1', 'Cajero', 'Activo', 1),
('Ana', 'Lopez', 'Femenino', '11234567-9', '1987-07-20', '7223-4567', 'ana.lopez@mail.com', 'Calle 2', 'Cajero', 'Activo', 1),
('Pedro', 'Ramirez', 'Masculino', '12234567-0', '1985-03-10', '7323-4567', 'pedro.ramirez@mail.com', 'Calle 3', 'Cajero', 'Inactivo', 2),
('Laura', 'Gomez', 'Femenino', '13234567-1', '1992-11-25', '7423-4567', 'laura.gomez@mail.com', 'Calle 4', 'Cajero', 'Activo', 2),
('Carlos', 'Martinez', 'Masculino', '14234567-2', '1988-08-18', '7523-4567', 'carlos.martinez@mail.com', 'Calle 5', 'Cajero', 'Activo', 1),
('Lucia', 'Hernandez', 'Femenino', '15234567-3', '1990-04-15', '7623-4567', 'lucia.hernandez@mail.com', 'Calle 6', 'Cajero', 'Activo', 2),
('Juan', 'Rodriguez', 'Masculino', '16234567-4', '1987-02-22', '7723-4567', 'juan.rodriguez@mail.com', 'Calle 7', 'Cajero', 'Inactivo', 4),
('Sofia', 'Sanchez', 'Femenino', '17234567-5', '1993-06-30', '7823-4567', 'sofia.sanchez@mail.com', 'Calle 8', 'Cajero', 'Activo', 4),
('Manuel', 'Gutierrez', 'Masculino', '18234567-6', '1991-09-15', '7923-4567', 'manuel.gutierrez@mail.com', 'Calle 9', 'Cajero', 'Activo', 5),
('Marta', 'Cruz', 'Femenino', '19234567-7', '1994-12-01', '8123-4567', 'marta.cruz@mail.com', 'Calle 10', 'Cajero', 'Activo', 5);

insert into Cuenta (NumeroDeCuenta, TipoDeCuenta, FechaDeApertura, Saldo, Estado, ID_Cliente, ID_Dependiente)
values
('9837264510293847', 'Ahorro', '2023-01-01', 1500.00, 'Activa', 1, null),
('5748392019473826', 'Corriente', '2023-02-01', 2500.00, 'Activa', 2, null),
('3847291048572019', 'Ahorro', '2023-03-01', 3000.00, 'Activa', 3, null),
('8492018374650293', 'Ahorro', '2023-05-01', 4000.00, 'Activa', 5, null),
('2938475647291048', 'Corriente', '2023-06-01', 4500.00, 'Activa', 6, null),
('2019384758472930', 'Corriente', '2023-08-01', 5500.00, 'Activa', 8, null),
('9473820104857293', 'Ahorro', '2023-09-01', 6000.00, 'Activa', 9, null),
('4857293029384756', 'Corriente', '2023-10-01', 6500.00, 'Inactiva', 10, null),

('1029384756472938', 'Ahorro', '2023-11-01', 7000.00, 'Activa', null, 1),
('7382019485739201', 'Corriente', '2023-12-01', 7500.00, 'Activa', null, 2),
('8475647382910203', 'Ahorro', '2024-01-01', 8000.00, 'Activa', null, 3),
('9384756472013948', 'Corriente', '2024-02-01', 8500.00, 'Inactiva', null, 4),
('2019485739203847', 'Ahorro', '2024-03-01', 9000.00, 'Activa', null, 5),
('5647293847201938', 'Corriente', '2024-04-01', 9500.00, 'Activa', null, 6),
('9485739201938475', 'Ahorro', '2024-05-01', 10000.00, 'Inactiva', null, 7),
('3948571029384756', 'Corriente', '2024-06-01', 10500.00, 'Activa', null, 8),
('5739201948572938', 'Ahorro', '2024-07-01', 11000.00, 'Activa', null, 9),
('8492017384759201', 'Corriente', '2024-08-01', 11500.00, 'Inactiva', null, 10);

insert into Transaccion (ID_CuentaOrigen, TipoDeTransaccion, Monto, FechaHora, ID_CuentaDestino, ID_Empleado, ComisionEmpleado)
values
(1, 'Depósito', 500.00, '2023-06-10 10:30:00', null, 1, 0),
(1, 'Retiro', 200.00, '2023-06-11 11:45:00', null, 3, 0),
(1, 'Transferencia', 1000.00, '2023-06-12 14:00:00', 4, null, 0),

(3, 'Depósito', 1500.00, '2023-06-13 09:15:00', null, 5, 0),
(3, 'Retiro', 750.00, '2023-06-14 12:00:00', null, 7, 0),

(15, 'Depósito', 2000.00, '2023-06-16 08:30:00', null, 8, 5),
(15, 'Retiro', 1000.00, '2023-06-17 10:00:00', null, 8, 5),
(15, 'Transferencia', 1200.00, '2023-06-18 11:15:00', 9, null, 5),

(10, 'Depósito', 300.00, '2023-06-19 14:30:00', null, 10, 0);

insert into CredencialCliente (Usuario, Contrasena, ID_Cliente)
values
('jperez', sha2('c0ntr@s3na1', 256), 1),
('amartinez', sha2('p@ssw0rd2', 256), 2),
('lgomez', sha2('pass123456', 256), 3),
('chernandez', sha2('password2023', 256), 5),
('lramirez', sha2('myp@ssword', 256), 6),
('sgutierrez', sha2('securepass!', 256), 8),
('psanchez', sha2('mypassword1', 256), 9),
('lacruz', sha2('lacruz123', 256), 10);


insert into CredencialEmpleado (Usuario, Contrasena, ID_Empleado, ID_Gerente)
values
('cajero1', sha2('empleado1', 256), 1, null),
('cajero2', sha2('empleado2', 256), 2, null),
('cajero3', sha2('empleado3', 256), 3, null),
('cajero4', sha2('empleado4', 256), 4, null),
('cajero5', sha2('empleado5', 256), 5, null),
('cajero6', sha2('empleado6', 256), 6, null),
('cajero7', sha2('empleado7', 256), 7, null),
('cajero8', sha2('empleado8', 256), 8, null),
('cajero9', sha2('empleado9', 256), 9, null),
('cajero10', sha2('empleado10', 256), 10, null),
('gerentedesucursal1', sha2('gerentedesucursal1', 256), null, 1),
('gerentedesucursal2', sha2('gerentedesucursal2', 256), null, 2),
('gerentedesucursal3', sha2('gerentedesucursal3', 256), null, 3),
('gerentedesucursal4', sha2('gerentedesucursal4', 256), null, 4),
('gerentedesucursal5', sha2('gerentedesucursal5', 256), null, 5),
('gerentegeneral', sha2('gerentegeneral', 256), null, 6);

insert into Prestamo (ID_Cliente, Monto, FechaHoraSolicitud, Estado, CuotaMensual, PlazoAnios, Interes, FechaHoraRespuesta, MotivoDeRechazo, ID_Empleado)
values
(4, 10000.00, '2023-01-15 10:30:00', 'Aprobado', 500.00, 2, 5, '2023-01-16 09:00:00', null, 1),
(7, 5000.00, '2023-02-20 11:00:00', 'Rechazado', default, default, default, '2023-02-21 10:00:00', 'Ingreso insuficiente', 2);

