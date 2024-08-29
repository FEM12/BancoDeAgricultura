package sv.edu.udb.www.entities;

import java.math.BigDecimal;
import java.sql.Date;

public class Cliente {
    private int id;
    private String nombres;
    private String apellidos;
    private String genero;
    private String documentoDeIdentidad;
    private Date fechaDeNacimiento;
    private String estadoCivil;
    private String ocupacion;
    private BigDecimal ingresoMensual;
    private String direccion;
    private String telefonoMovil;
    private String correoElectronico;
    private String clasificacionDeCliente;
    private String descripcion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDocumentoDeIdentidad() {
        return documentoDeIdentidad;
    }

    public void setDocumentoDeIdentidad(String documentoDeIdentidad) {
        this.documentoDeIdentidad = documentoDeIdentidad;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public BigDecimal getIngresoMensual() {
        return ingresoMensual;
    }

    public void setIngresoMensual(BigDecimal ingresoMensual) {
        this.ingresoMensual = ingresoMensual;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getClasificacionDeCliente() {
        return clasificacionDeCliente;
    }

    public void setClasificacionDeCliente(String clasificacionDeCliente) {
        this.clasificacionDeCliente = clasificacionDeCliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        if (id != cliente.id) return false;
        if (nombres != null ? !nombres.equals(cliente.nombres) : cliente.nombres != null) return false;
        if (apellidos != null ? !apellidos.equals(cliente.apellidos) : cliente.apellidos != null) return false;
        if (genero != null ? !genero.equals(cliente.genero) : cliente.genero != null) return false;
        if (documentoDeIdentidad != null ? !documentoDeIdentidad.equals(cliente.documentoDeIdentidad) : cliente.documentoDeIdentidad != null)
            return false;
        if (fechaDeNacimiento != null ? !fechaDeNacimiento.equals(cliente.fechaDeNacimiento) : cliente.fechaDeNacimiento != null)
            return false;
        if (estadoCivil != null ? !estadoCivil.equals(cliente.estadoCivil) : cliente.estadoCivil != null) return false;
        if (ocupacion != null ? !ocupacion.equals(cliente.ocupacion) : cliente.ocupacion != null) return false;
        if (ingresoMensual != null ? !ingresoMensual.equals(cliente.ingresoMensual) : cliente.ingresoMensual != null)
            return false;
        if (direccion != null ? !direccion.equals(cliente.direccion) : cliente.direccion != null) return false;
        if (telefonoMovil != null ? !telefonoMovil.equals(cliente.telefonoMovil) : cliente.telefonoMovil != null)
            return false;
        if (correoElectronico != null ? !correoElectronico.equals(cliente.correoElectronico) : cliente.correoElectronico != null)
            return false;
        if (clasificacionDeCliente != null ? !clasificacionDeCliente.equals(cliente.clasificacionDeCliente) : cliente.clasificacionDeCliente != null)
            return false;
        if (descripcion != null ? !descripcion.equals(cliente.descripcion) : cliente.descripcion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nombres != null ? nombres.hashCode() : 0);
        result = 31 * result + (apellidos != null ? apellidos.hashCode() : 0);
        result = 31 * result + (genero != null ? genero.hashCode() : 0);
        result = 31 * result + (documentoDeIdentidad != null ? documentoDeIdentidad.hashCode() : 0);
        result = 31 * result + (fechaDeNacimiento != null ? fechaDeNacimiento.hashCode() : 0);
        result = 31 * result + (estadoCivil != null ? estadoCivil.hashCode() : 0);
        result = 31 * result + (ocupacion != null ? ocupacion.hashCode() : 0);
        result = 31 * result + (ingresoMensual != null ? ingresoMensual.hashCode() : 0);
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        result = 31 * result + (telefonoMovil != null ? telefonoMovil.hashCode() : 0);
        result = 31 * result + (correoElectronico != null ? correoElectronico.hashCode() : 0);
        result = 31 * result + (clasificacionDeCliente != null ? clasificacionDeCliente.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        return result;
    }
}
