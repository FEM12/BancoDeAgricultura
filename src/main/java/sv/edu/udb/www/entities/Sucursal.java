package sv.edu.udb.www.entities;

public class Sucursal {
    private int id;
    private String direccion;
    private String telefonoFijo;
    private String correoElectronico;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sucursal sucursal = (Sucursal) o;

        if (id != sucursal.id) return false;
        if (direccion != null ? !direccion.equals(sucursal.direccion) : sucursal.direccion != null) return false;
        if (telefonoFijo != null ? !telefonoFijo.equals(sucursal.telefonoFijo) : sucursal.telefonoFijo != null)
            return false;
        if (correoElectronico != null ? !correoElectronico.equals(sucursal.correoElectronico) : sucursal.correoElectronico != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        result = 31 * result + (telefonoFijo != null ? telefonoFijo.hashCode() : 0);
        result = 31 * result + (correoElectronico != null ? correoElectronico.hashCode() : 0);
        return result;
    }
}
