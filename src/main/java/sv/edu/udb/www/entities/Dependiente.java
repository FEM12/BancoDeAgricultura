package sv.edu.udb.www.entities;

import java.math.BigDecimal;
import java.sql.Date;

public class Dependiente {
    private int id;
    private String nombres;
    private String apellidos;
    private String genero;
    private String dui;
    private Date fechaDeNacimiento;
    private String estadoCivil;
    private String negocio;
    private String ocupacion;
    private BigDecimal ingresoMensual;
    private String telefonoMovil;
    private String correoElectronico;
    private String direccion;

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

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
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

    public String getNegocio() {
        return negocio;
    }

    public void setNegocio(String negocio) {
        this.negocio = negocio;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dependiente that = (Dependiente) o;

        if (id != that.id) return false;
        if (nombres != null ? !nombres.equals(that.nombres) : that.nombres != null) return false;
        if (apellidos != null ? !apellidos.equals(that.apellidos) : that.apellidos != null) return false;
        if (genero != null ? !genero.equals(that.genero) : that.genero != null) return false;
        if (dui != null ? !dui.equals(that.dui) : that.dui != null) return false;
        if (fechaDeNacimiento != null ? !fechaDeNacimiento.equals(that.fechaDeNacimiento) : that.fechaDeNacimiento != null)
            return false;
        if (estadoCivil != null ? !estadoCivil.equals(that.estadoCivil) : that.estadoCivil != null) return false;
        if (negocio != null ? !negocio.equals(that.negocio) : that.negocio != null) return false;
        if (ocupacion != null ? !ocupacion.equals(that.ocupacion) : that.ocupacion != null) return false;
        if (ingresoMensual != null ? !ingresoMensual.equals(that.ingresoMensual) : that.ingresoMensual != null)
            return false;
        if (telefonoMovil != null ? !telefonoMovil.equals(that.telefonoMovil) : that.telefonoMovil != null)
            return false;
        if (correoElectronico != null ? !correoElectronico.equals(that.correoElectronico) : that.correoElectronico != null)
            return false;
        if (direccion != null ? !direccion.equals(that.direccion) : that.direccion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nombres != null ? nombres.hashCode() : 0);
        result = 31 * result + (apellidos != null ? apellidos.hashCode() : 0);
        result = 31 * result + (genero != null ? genero.hashCode() : 0);
        result = 31 * result + (dui != null ? dui.hashCode() : 0);
        result = 31 * result + (fechaDeNacimiento != null ? fechaDeNacimiento.hashCode() : 0);
        result = 31 * result + (estadoCivil != null ? estadoCivil.hashCode() : 0);
        result = 31 * result + (negocio != null ? negocio.hashCode() : 0);
        result = 31 * result + (ocupacion != null ? ocupacion.hashCode() : 0);
        result = 31 * result + (ingresoMensual != null ? ingresoMensual.hashCode() : 0);
        result = 31 * result + (telefonoMovil != null ? telefonoMovil.hashCode() : 0);
        result = 31 * result + (correoElectronico != null ? correoElectronico.hashCode() : 0);
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        return result;
    }
}
