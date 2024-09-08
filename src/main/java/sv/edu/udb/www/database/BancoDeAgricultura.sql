create database BancoDeAgricultura character set utf8mb4 collate utf8mb4_bin;
use BancoDeAgricultura;

create table Cliente(

    ID int auto_increment primary key not null,
    Nombres varchar(100) not null,
    Apellidos varchar(100) not null,
    Genero varchar(10) not null,
    DUI char(10) not null,
    FechaDeNacimiento date not null,
    EstadoCivil varchar(15) not null,
    Ocupacion text not null,
    IngresoMensual decimal(20,2) not null,
    TelefonoMovil varchar(20) not null,
    CorreoElectronico text not null,
    Direccion text not null,
    ClasificacionDeCliente text not null,

    check (Genero in ('Masculino','Femenino')),
    check (EstadoCivil in ('Soltero/a','Casado/a','Divorciado/a','Viudo/a','Unido/a'))

);

create table Dependiente(

    ID int auto_increment primary key not null,
    Nombres varchar(100) not null,
    Apellidos varchar(100) not null,
    Genero varchar(10) not null,
    DUI char(10) not null,
    FechaDeNacimiento date not null,
    EstadoCivil varchar(15) not null,
    Negocio text not null,
    Ocupacion text not null,
    IngresoMensual decimal(20,2) not null,
    TelefonoMovil varchar(20) not null,
    CorreoElectronico text not null,
    Direccion text not null,

    check (Genero in ('Masculino','Femenino')),
    check (EstadoCivil in ('Soltero/a','Casado/a','Divorciado/a','Viudo/a','Unido/a'))

);

create table Cuenta(

   ID int auto_increment primary key not null,
   NumeroDeCuenta char(20) not null,
   TipoDeCuenta text not null,
   FechaDeApertura date not null,
   Saldo decimal(20,2) not null,
   Estado varchar(8) default 'Activa' not null,
   ID_Cliente int, -- Llave Foranea
   ID_Dependiente int, -- Llave Foranea

   check (Estado in ('Activa','Inactiva'))

);

create table ReferenciaPersonal(

   ID int auto_increment primary key not null,
   Nombre varchar(250) not null,
   Relacion varchar(100) not null,
   TelefonoMovil varchar(20) not null,
   Direccion text not null,
   ID_Cliente int, -- Llave Foranea
   ID_Dependiente int -- Llave Foranea

);

create table Transaccion(

    ID int auto_increment primary key not null,
    ID_Cuenta int not null, -- Llave Foranea
    TipoDeTransaccion varchar(20) not null,
    Monto decimal(20,2) not null,
    FechaHora datetime not null,
    CuentaDeDestino char(20),
    ID_Empleado int, -- Llave Foranea
    ComisionEmpleado int default 0,

    check (TipoDeTransaccion in ('Depósito','Retiro','Transferencia'))

);

create table CredencialCliente(

  ID int auto_increment primary key not null,
  Usuario varchar(100) not null,
  Contrasena varchar(260) not null,
  ID_Cliente int not null -- Llave Foranea

);

create table CredencialEmpleado(

    ID int auto_increment primary key not null,
    Usuario varchar(100) not null,
    Contrasena varchar(260) not null,
    ID_Empleado int not null -- Llave Foranea

);

create table CredencialGerente(

  ID int auto_increment primary key not null,
  Usuario varchar(100) not null,
  Contrasena varchar(260) not null,
  ID_Gerente int not null -- Llave Foranea

);

create table Empleado(

     ID int auto_increment primary key not null,
     Nombres varchar(100) not null,
     Apellidos varchar(100) not null,
     Genero varchar(10) not null,
     DUI char(10) not null,
     FechaDeNacimiento date not null,
     TelefonoMovil varchar(20) not null,
     CorreoElectronico text not null,
     Direccion text not null,
     Cargo varchar(100) default 'Cajero' not null,
     Estado varchar(8) default 'Activo' not null,
     ID_Gerente int not null, -- Llave Foranea

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
    TelefonoMovil varchar(20) not null,
    CorreoElectronico text not null,
    Direccion text not null,
    Cargo varchar(100) default 'Gerente de sucursal' not null,
    Estado varchar(8) default 'Activo' not null,

    check (Genero in ('Masculino','Femenino')),
    check (Estado in ('Activo','Inactivo'))

);

create table Sucursal(

     ID int auto_increment primary key not null,
     Direccion text not null,
     TelefonoFijo varchar(20) not null,
     CorreoElectronico text,
     ID_Gerente int not null -- Llave Foranea

);

create table Prestamo(

     ID int auto_increment primary key not null,
     ID_Cliente int not null, -- Llave Foranea
     Monto decimal(20,2) not null,
     FechaHoraSolicitud datetime not null,
     Estado varchar(10) default 'En Espera' not null,
     CuotaMensual decimal(20,2) default 0.0 not null,
     PlazoAnios int default 0 not null,
     Interes int default 0 not null,
     FechaHoraRespuesta datetime not null,
     MotivoDeRechazo text,
     ID_Empleado int not null, -- Llave Foranea

     check (Estado in ('Aprobado','En Espera','Rechazado'))

);


alter table Cuenta
add foreign key (ID_Cliente) references Cliente(ID),
add foreign key (ID_Dependiente) references Dependiente(ID);

alter table ReferenciaPersonal
add foreign key (ID_Cliente) references Cliente(ID),
add foreign key (ID_Dependiente) references Dependiente(ID);

alter table Transaccion
add foreign key (ID_Cuenta) references Cuenta(ID),
add foreign key (ID_Empleado) references Empleado(ID);

alter table CredencialCliente
add foreign key (ID_Cliente) references Cliente(ID);

alter table CredencialEmpleado
add foreign key (ID_Empleado) references Empleado(ID);

alter table CredencialGerente
add foreign key (ID_Gerente) references Gerente(ID);

alter table Empleado
add foreign key (ID_Gerente) references Gerente(ID);

alter table Sucursal
add foreign key (ID_Gerente) references Gerente(ID);

alter table Prestamo
add foreign key (ID_Cliente) references Cliente(ID),
add foreign key (ID_Empleado) references Empleado(ID);
