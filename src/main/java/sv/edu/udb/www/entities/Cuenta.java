package sv.edu.udb.www.entities;

import java.math.BigDecimal;
import java.sql.Date;

public class Cuenta {
    private int id;
    private String numeroDeCuenta;
    private String tipoDeCuenta;
    private Date fechaDeApertura;
    private BigDecimal saldo;
    private String estado;
    private Integer idCliente;
    private Integer idDependiente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public void setNumeroDeCuenta(String numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }

    public String getTipoDeCuenta() {
        return tipoDeCuenta;
    }

    public void setTipoDeCuenta(String tipoDeCuenta) {
        this.tipoDeCuenta = tipoDeCuenta;
    }

    public Date getFechaDeApertura() {
        return fechaDeApertura;
    }

    public void setFechaDeApertura(Date fechaDeApertura) {
        this.fechaDeApertura = fechaDeApertura;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdDependiente() {
        return idDependiente;
    }

    public void setIdDependiente(Integer idDependiente) {
        this.idDependiente = idDependiente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cuenta cuenta = (Cuenta) o;

        if (id != cuenta.id) return false;
        if (numeroDeCuenta != null ? !numeroDeCuenta.equals(cuenta.numeroDeCuenta) : cuenta.numeroDeCuenta != null)
            return false;
        if (tipoDeCuenta != null ? !tipoDeCuenta.equals(cuenta.tipoDeCuenta) : cuenta.tipoDeCuenta != null)
            return false;
        if (fechaDeApertura != null ? !fechaDeApertura.equals(cuenta.fechaDeApertura) : cuenta.fechaDeApertura != null)
            return false;
        if (saldo != null ? !saldo.equals(cuenta.saldo) : cuenta.saldo != null) return false;
        if (estado != null ? !estado.equals(cuenta.estado) : cuenta.estado != null) return false;
        if (idCliente != null ? !idCliente.equals(cuenta.idCliente) : cuenta.idCliente != null) return false;
        if (idDependiente != null ? !idDependiente.equals(cuenta.idDependiente) : cuenta.idDependiente != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (numeroDeCuenta != null ? numeroDeCuenta.hashCode() : 0);
        result = 31 * result + (tipoDeCuenta != null ? tipoDeCuenta.hashCode() : 0);
        result = 31 * result + (fechaDeApertura != null ? fechaDeApertura.hashCode() : 0);
        result = 31 * result + (saldo != null ? saldo.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (idCliente != null ? idCliente.hashCode() : 0);
        result = 31 * result + (idDependiente != null ? idDependiente.hashCode() : 0);
        return result;
    }
}
