package sv.edu.udb.www.entities;

public class Empresa {
    private int id;
    private String nombre;
    private String nit;
    private String telefono;
    private String correoElectronico;
    private String direccion;
    private int idCliente;

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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Empresa empresa = (Empresa) o;

        if (id != empresa.id) return false;
        if (idCliente != empresa.idCliente) return false;
        if (nombre != null ? !nombre.equals(empresa.nombre) : empresa.nombre != null) return false;
        if (nit != null ? !nit.equals(empresa.nit) : empresa.nit != null) return false;
        if (telefono != null ? !telefono.equals(empresa.telefono) : empresa.telefono != null) return false;
        if (correoElectronico != null ? !correoElectronico.equals(empresa.correoElectronico) : empresa.correoElectronico != null)
            return false;
        if (direccion != null ? !direccion.equals(empresa.direccion) : empresa.direccion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (nit != null ? nit.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        result = 31 * result + (correoElectronico != null ? correoElectronico.hashCode() : 0);
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        result = 31 * result + idCliente;
        return result;
    }
}
