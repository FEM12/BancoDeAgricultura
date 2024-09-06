create database BancoDeAgricultura character set utf8mb4 collate utf8mb4_bin;
use BancoDeAgricultura;

create table Cliente (

    ID int auto_increment primary key not null,
    Nombres varchar(100) not null,
    Apellidos varchar(100) not null,
    Genero varchar(10) not null,
    DocumentoDeIdentidad char(10) not null,
    FechaDeNacimiento date not null,
    EstadoCivil varchar(15) not null,
    Ocupacion text not null,
    IngresoMensual decimal(20, 2) not null,
    Direccion text not null,
    TelefonoMovil varchar(20) not null,
    CorreoElectronico text not null,
    ClasificacionDeCliente text not null,
    Descripcion text not null,

    constraint CHK_Genero_Cliente check (Genero in ('Masculino','Femenino')),
    constraint CHK_EstadoCivil_Cliente check (EstadoCivil in ('Soltero/a','Casado/a','Divorciado/a','Viudo/a','Unido/a'))

);

create table Empresa(

    ID int auto_increment primary key  not null,
    Nombre varchar(250) not null,
    NIT varchar(17) not null,
    Telefono varchar(20) not null,
    CorreoElectronico text not null,
    Direccion text not null,
    ID_Cliente int not null

);

create table Cuenta (

    ID int auto_increment primary key not null,
    NumeroDeCuenta char(20) not null,
    TipoDeCuenta text not null,
    FechaDeApertura date not null,
    Saldo decimal(20, 2) not null,
    LimiteDeTransaccionesPorMes int not null,
    Estado varchar(8) not null,
    ID_Cliente int not null, -- Llave Foranea

    constraint CHK_Estado_Cuenta check (Estado in ('Activo','Inactivo'))

);

create table ReferenciaPersonal (

    ID int auto_increment primary key not null,
    Nombre varchar(250) not null,
    Relacion varchar(100) not null,
    TelefonoMovil varchar(20) not null,
    Direccion text not null,
    ID_Cliente int not null -- Llave Foranea

);

create table Transaccion (

    ID int auto_increment primary key not null,
    ID_Cuenta int not null, -- Llave Foranea
    TipoDeTransaccion varchar(20) not null,
    Monto decimal(20, 2) not null,
    FechaHora datetime not null,
    ID_Cuenta_Destino int, -- Llave Foranea
    ID_Empleado int, -- Llave Foranea
    ComisionEmpleado int default 0 not null,

    constraint CHK_TipoDeTransaccion_Transaccion check (TipoDeTransaccion in ('Depósito','Retiro','Transferencia','Pago de Préstamo'))

);

create table CredencialCliente (

    ID int auto_increment primary key not null,
    Usuario varchar(100) not null,
    Contrasena varchar(100) not null,
    ID_Cliente int not null -- Llave Foranea

);

create table CredencialEmpleado(

    ID int auto_increment primary key not null,
    Usuario varchar(100) not null,
    Contrasena varchar(100) not null,
    ID_Empleado int not null -- Llave Foranea

);

create table Empleado (

    ID int auto_increment primary key not null,
    Nombres varchar(100) not null,
    Apellidos varchar(100) not null,
    Genero varchar(10) not null,
    DocumentoDeIdentidad char(10) not null,
    FechaDeNacimiento date not null,
    Direccion text not null,
    TelefonoMovil varchar(20) not null,
    CorreoElectronico text not null,
    ID_Sucursal int not null, -- Llave Foranea
    ID_Supervisor int, -- Llave Foranea
    Cargo varchar(100) not null,
    Estado varchar(8) not null,

    constraint CHK_Genero_Empleado check (Genero in ('Masculino','Femenino')),
    constraint CHK_Estado_Empleado check (Estado in ('Activo','Inactivo'))

);

create table Sucursal (

    ID int auto_increment primary key not null,
    Direccion text not null,
    TelefonoFijo varchar(20) not null,
    CorreoElectronico text,
    ID_GerenteDeSucursal int not null, -- Llave Foranea
    ID_GerenteGeneral int not null -- Llave Foranea

);

create table Prestamo (

    ID int auto_increment primary key not null,
    ID_Cliente int not null, -- Llave Foranea
    Monto decimal(20, 2) not null,
    Estado varchar(10) default 'En Espera' not null,
    ID_Empleado int not null, -- Llave Foranea
    ID_GerenteDeSucursal int default 0 not null, -- Llave Foranea
    CuotaMensual decimal(20, 2) default 0.0 not null,
    PlazoAnios int default 0 not null,
    Interes int default 0 not null,

    constraint CHK_Estado_Prestamo check (Estado in ('Aprobado', 'En Espera','Rechazado'))
    
);

alter table Empresa
add constraint FK_IDCliente_Empresa foreign key (ID_Cliente) references Cliente(ID);

alter table Cuenta 
add constraint FK_IDCliente_Cuenta foreign key (ID_Cliente) references Cliente(ID);

alter table ReferenciaPersonal 
add constraint FK_IDCliente_ReferenciaPersonal foreign key (ID_Cliente) references Cliente(ID);

alter table Transaccion 
add constraint FK_IDCuenta_Transaccion foreign key (ID_Cuenta) references Cuenta(ID),
add constraint FK_IDEmpleado_Transaccion foreign key (ID_Empleado) references Empleado(ID),
add constraint FK_IDCuentaDestino_Transaccion foreign key (ID_Cuenta_Destino) references Cuenta(ID);

alter table CredencialCliente 
add constraint FK_IDCliente_CredencialCliente foreign key (ID_Cliente) references Cliente(ID);

alter table CredencialEmpleado
add constraint FK_IDEmpleado_CredencialEmpleado foreign key (ID_Empleado) references Empleado(ID);

alter table Empleado 
add constraint FK_IDSucursal_Empleado foreign key (ID_Sucursal) references Sucursal(ID),
add constraint FK_IDSupervisor_Empleado foreign key (ID_Supervisor) references Empleado(ID);

alter table Sucursal 
add constraint FK_IDGerenteDeSucursal_Sucursal foreign key (ID_GerenteDeSucursal) references Empleado(ID),
add constraint FK_IDGerenteGeneral_Sucursal foreign key (ID_GerenteGeneral) references Empleado(ID);

alter table Prestamo 
add constraint FK_IDCliente_Prestamo foreign key (ID_Cliente) references Cliente(ID),
add constraint FK_IDEmpleado_Prestamo foreign key (ID_Empleado) references Empleado(ID),
add constraint FK_IDGerenteDeSucursal_Prestamo foreign key (ID_GerenteDeSucursal) references Empleado(ID);