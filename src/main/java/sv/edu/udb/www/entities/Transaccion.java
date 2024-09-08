package sv.edu.udb.www.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Transaccion {
    private int id;
    private int idCuenta;
    private String tipoDeTransaccion;
    private BigDecimal monto;
    private Timestamp fechaHora;
    private String cuentaDeDestino;
    private Integer idEmpleado;
    private Integer comisionEmpleado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getTipoDeTransaccion() {
        return tipoDeTransaccion;
    }

    public void setTipoDeTransaccion(String tipoDeTransaccion) {
        this.tipoDeTransaccion = tipoDeTransaccion;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getCuentaDeDestino() {
        return cuentaDeDestino;
    }

    public void setCuentaDeDestino(String cuentaDeDestino) {
        this.cuentaDeDestino = cuentaDeDestino;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getComisionEmpleado() {
        return comisionEmpleado;
    }

    public void setComisionEmpleado(Integer comisionEmpleado) {
        this.comisionEmpleado = comisionEmpleado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaccion that = (Transaccion) o;

        if (id != that.id) return false;
        if (idCuenta != that.idCuenta) return false;
        if (tipoDeTransaccion != null ? !tipoDeTransaccion.equals(that.tipoDeTransaccion) : that.tipoDeTransaccion != null)
            return false;
        if (monto != null ? !monto.equals(that.monto) : that.monto != null) return false;
        if (fechaHora != null ? !fechaHora.equals(that.fechaHora) : that.fechaHora != null) return false;
        if (cuentaDeDestino != null ? !cuentaDeDestino.equals(that.cuentaDeDestino) : that.cuentaDeDestino != null)
            return false;
        if (idEmpleado != null ? !idEmpleado.equals(that.idEmpleado) : that.idEmpleado != null) return false;
        if (comisionEmpleado != null ? !comisionEmpleado.equals(that.comisionEmpleado) : that.comisionEmpleado != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idCuenta;
        result = 31 * result + (tipoDeTransaccion != null ? tipoDeTransaccion.hashCode() : 0);
        result = 31 * result + (monto != null ? monto.hashCode() : 0);
        result = 31 * result + (fechaHora != null ? fechaHora.hashCode() : 0);
        result = 31 * result + (cuentaDeDestino != null ? cuentaDeDestino.hashCode() : 0);
        result = 31 * result + (idEmpleado != null ? idEmpleado.hashCode() : 0);
        result = 31 * result + (comisionEmpleado != null ? comisionEmpleado.hashCode() : 0);
        return result;
    }
}
