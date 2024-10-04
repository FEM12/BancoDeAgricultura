package sv.edu.udb.www.entities;

import java.sql.Date;

public class Empleado {
    private int id;
    private String nombres;
    private String apellidos;
    private String genero;
    private String dui;
    private Date fechaDeNacimiento;
    private String telefonoMovil;
    private String correoElectronico;
    private String direccion;
    private String cargo;
    private String estado;
    private Integer idGerente;

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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(Integer idGerente) {
        this.idGerente = idGerente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Empleado empleado = (Empleado) o;

        if (id != empleado.id) return false;
        if (nombres != null ? !nombres.equals(empleado.nombres) : empleado.nombres != null) return false;
        if (apellidos != null ? !apellidos.equals(empleado.apellidos) : empleado.apellidos != null) return false;
        if (genero != null ? !genero.equals(empleado.genero) : empleado.genero != null) return false;
        if (dui != null ? !dui.equals(empleado.dui) : empleado.dui != null) return false;
        if (fechaDeNacimiento != null ? !fechaDeNacimiento.equals(empleado.fechaDeNacimiento) : empleado.fechaDeNacimiento != null)
            return false;
        if (telefonoMovil != null ? !telefonoMovil.equals(empleado.telefonoMovil) : empleado.telefonoMovil != null)
            return false;
        if (correoElectronico != null ? !correoElectronico.equals(empleado.correoElectronico) : empleado.correoElectronico != null)
            return false;
        if (direccion != null ? !direccion.equals(empleado.direccion) : empleado.direccion != null) return false;
        if (cargo != null ? !cargo.equals(empleado.cargo) : empleado.cargo != null) return false;
        if (estado != null ? !estado.equals(empleado.estado) : empleado.estado != null) return false;
        if (idGerente != null ? !idGerente.equals(empleado.idGerente) : empleado.idGerente != null) return false;

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
        result = 31 * result + (telefonoMovil != null ? telefonoMovil.hashCode() : 0);
        result = 31 * result + (correoElectronico != null ? correoElectronico.hashCode() : 0);
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        result = 31 * result + (cargo != null ? cargo.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (idGerente != null ? idGerente.hashCode() : 0);
        return result;
    }
}
