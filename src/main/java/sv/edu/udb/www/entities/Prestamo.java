package sv.edu.udb.www.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Prestamo {
    private int id;
    private int idCliente;
    private BigDecimal monto;
    private Timestamp fechaHoraSolicitud;
    private String estado;
    private BigDecimal cuotaMensual;
    private Integer plazoAnios;
    private Integer interes;
    private Timestamp fechaHoraRespuesta;
    private String motivoDeRechazo;
    private Integer idEmpleado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Timestamp getFechaHoraSolicitud() {
        return fechaHoraSolicitud;
    }

    public void setFechaHoraSolicitud(Timestamp fechaHoraSolicitud) {
        this.fechaHoraSolicitud = fechaHoraSolicitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getCuotaMensual() {
        return cuotaMensual;
    }

    public void setCuotaMensual(BigDecimal cuotaMensual) {
        this.cuotaMensual = cuotaMensual;
    }

    public Integer getPlazoAnios() {
        return plazoAnios;
    }

    public void setPlazoAnios(Integer plazoAnios) {
        this.plazoAnios = plazoAnios;
    }

    public Integer getInteres() {
        return interes;
    }

    public void setInteres(Integer interes) {
        this.interes = interes;
    }

    public Timestamp getFechaHoraRespuesta() {
        return fechaHoraRespuesta;
    }

    public void setFechaHoraRespuesta(Timestamp fechaHoraRespuesta) {
        this.fechaHoraRespuesta = fechaHoraRespuesta;
    }

    public String getMotivoDeRechazo() {
        return motivoDeRechazo;
    }

    public void setMotivoDeRechazo(String motivoDeRechazo) {
        this.motivoDeRechazo = motivoDeRechazo;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Prestamo prestamo = (Prestamo) o;

        if (id != prestamo.id) return false;
        if (idCliente != prestamo.idCliente) return false;
        if (monto != null ? !monto.equals(prestamo.monto) : prestamo.monto != null) return false;
        if (fechaHoraSolicitud != null ? !fechaHoraSolicitud.equals(prestamo.fechaHoraSolicitud) : prestamo.fechaHoraSolicitud != null)
            return false;
        if (estado != null ? !estado.equals(prestamo.estado) : prestamo.estado != null) return false;
        if (cuotaMensual != null ? !cuotaMensual.equals(prestamo.cuotaMensual) : prestamo.cuotaMensual != null)
            return false;
        if (plazoAnios != null ? !plazoAnios.equals(prestamo.plazoAnios) : prestamo.plazoAnios != null) return false;
        if (interes != null ? !interes.equals(prestamo.interes) : prestamo.interes != null) return false;
        if (fechaHoraRespuesta != null ? !fechaHoraRespuesta.equals(prestamo.fechaHoraRespuesta) : prestamo.fechaHoraRespuesta != null)
            return false;
        if (motivoDeRechazo != null ? !motivoDeRechazo.equals(prestamo.motivoDeRechazo) : prestamo.motivoDeRechazo != null)
            return false;
        if (idEmpleado != null ? !idEmpleado.equals(prestamo.idEmpleado) : prestamo.idEmpleado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idCliente;
        result = 31 * result + (monto != null ? monto.hashCode() : 0);
        result = 31 * result + (fechaHoraSolicitud != null ? fechaHoraSolicitud.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (cuotaMensual != null ? cuotaMensual.hashCode() : 0);
        result = 31 * result + (plazoAnios != null ? plazoAnios.hashCode() : 0);
        result = 31 * result + (interes != null ? interes.hashCode() : 0);
        result = 31 * result + (fechaHoraRespuesta != null ? fechaHoraRespuesta.hashCode() : 0);
        result = 31 * result + (motivoDeRechazo != null ? motivoDeRechazo.hashCode() : 0);
        result = 31 * result + (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return result;
    }
}
