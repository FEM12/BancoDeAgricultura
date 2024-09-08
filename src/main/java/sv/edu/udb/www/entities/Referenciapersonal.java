package sv.edu.udb.www.entities;

public class Referenciapersonal {
    private int id;
    private String nombre;
    private String relacion;
    private String telefonoMovil;
    private String direccion;
    private Integer idCliente;
    private Integer idDependiente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

        Referenciapersonal that = (Referenciapersonal) o;

        if (id != that.id) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (relacion != null ? !relacion.equals(that.relacion) : that.relacion != null) return false;
        if (telefonoMovil != null ? !telefonoMovil.equals(that.telefonoMovil) : that.telefonoMovil != null)
            return false;
        if (direccion != null ? !direccion.equals(that.direccion) : that.direccion != null) return false;
        if (idCliente != null ? !idCliente.equals(that.idCliente) : that.idCliente != null) return false;
        if (idDependiente != null ? !idDependiente.equals(that.idDependiente) : that.idDependiente != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (relacion != null ? relacion.hashCode() : 0);
        result = 31 * result + (telefonoMovil != null ? telefonoMovil.hashCode() : 0);
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        result = 31 * result + (idCliente != null ? idCliente.hashCode() : 0);
        result = 31 * result + (idDependiente != null ? idDependiente.hashCode() : 0);
        return result;
    }
}
