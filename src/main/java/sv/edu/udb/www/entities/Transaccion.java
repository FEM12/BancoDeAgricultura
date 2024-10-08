package sv.edu.udb.www.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Transaccion {
    private int id;
    private int idCuentaOrigen;
    private String tipoDeTransaccion;
    private BigDecimal monto;
    private Timestamp fechaHora;
    private Integer idCuentaDestino;
    private Integer idEmpleado;
    private int comisionEmpleado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCuentaOrigen() {
        return idCuentaOrigen;
    }

    public void setIdCuentaOrigen(int idCuentaOrigen) {
        this.idCuentaOrigen = idCuentaOrigen;
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

    public Integer getIdCuentaDestino() {
        return idCuentaDestino;
    }

    public void setIdCuentaDestino(Integer idCuentaDestino) {
        this.idCuentaDestino = idCuentaDestino;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getComisionEmpleado() {
        return comisionEmpleado;
    }

    public void setComisionEmpleado(int comisionEmpleado) {
        this.comisionEmpleado = comisionEmpleado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaccion that = (Transaccion) o;

        if (id != that.id) return false;
        if (idCuentaOrigen != that.idCuentaOrigen) return false;
        if (comisionEmpleado != that.comisionEmpleado) return false;
        if (tipoDeTransaccion != null ? !tipoDeTransaccion.equals(that.tipoDeTransaccion) : that.tipoDeTransaccion != null)
            return false;
        if (monto != null ? !monto.equals(that.monto) : that.monto != null) return false;
        if (fechaHora != null ? !fechaHora.equals(that.fechaHora) : that.fechaHora != null) return false;
        if (idCuentaDestino != null ? !idCuentaDestino.equals(that.idCuentaDestino) : that.idCuentaDestino != null)
            return false;
        if (idEmpleado != null ? !idEmpleado.equals(that.idEmpleado) : that.idEmpleado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idCuentaOrigen;
        result = 31 * result + (tipoDeTransaccion != null ? tipoDeTransaccion.hashCode() : 0);
        result = 31 * result + (monto != null ? monto.hashCode() : 0);
        result = 31 * result + (fechaHora != null ? fechaHora.hashCode() : 0);
        result = 31 * result + (idCuentaDestino != null ? idCuentaDestino.hashCode() : 0);
        result = 31 * result + (idEmpleado != null ? idEmpleado.hashCode() : 0);
        result = 31 * result + comisionEmpleado;
        return result;
    }
}
