package sv.edu.udb.www.entities;

import java.math.BigDecimal;

public class Prestamo {
    private int id;
    private int idCliente;
    private BigDecimal monto;
    private String estado;
    private int idEmpleado;
    private int idGerenteDeSucursal;
    private BigDecimal cuotaMensual;
    private int plazoAnios;
    private int interes;

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdGerenteDeSucursal() {
        return idGerenteDeSucursal;
    }

    public void setIdGerenteDeSucursal(int idGerenteDeSucursal) {
        this.idGerenteDeSucursal = idGerenteDeSucursal;
    }

    public BigDecimal getCuotaMensual() {
        return cuotaMensual;
    }

    public void setCuotaMensual(BigDecimal cuotaMensual) {
        this.cuotaMensual = cuotaMensual;
    }

    public int getPlazoAnios() {
        return plazoAnios;
    }

    public void setPlazoAnios(int plazoAnios) {
        this.plazoAnios = plazoAnios;
    }

    public int getInteres() {
        return interes;
    }

    public void setInteres(int interes) {
        this.interes = interes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Prestamo prestamo = (Prestamo) o;

        if (id != prestamo.id) return false;
        if (idCliente != prestamo.idCliente) return false;
        if (idEmpleado != prestamo.idEmpleado) return false;
        if (idGerenteDeSucursal != prestamo.idGerenteDeSucursal) return false;
        if (plazoAnios != prestamo.plazoAnios) return false;
        if (interes != prestamo.interes) return false;
        if (monto != null ? !monto.equals(prestamo.monto) : prestamo.monto != null) return false;
        if (estado != null ? !estado.equals(prestamo.estado) : prestamo.estado != null) return false;
        if (cuotaMensual != null ? !cuotaMensual.equals(prestamo.cuotaMensual) : prestamo.cuotaMensual != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idCliente;
        result = 31 * result + (monto != null ? monto.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + idEmpleado;
        result = 31 * result + idGerenteDeSucursal;
        result = 31 * result + (cuotaMensual != null ? cuotaMensual.hashCode() : 0);
        result = 31 * result + plazoAnios;
        result = 31 * result + interes;
        return result;
    }
}
