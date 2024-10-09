package sv.edu.udb.www.managedbeans;

import sv.edu.udb.www.entities.Cliente;

import static sv.edu.udb.www.utils.ConversorFecha.convertirFecha;
import static sv.edu.udb.www.utils.ExpresionesUtil.validacion;
import sv.edu.udb.www.utils.HibernateUtil;
import static sv.edu.udb.www.utils.JsfUtil.*;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;
import java.math.BigDecimal;
import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
@ViewScoped
public class ClienteRegistro {

    private String nombres;
    private String apellidos;
    private String genero;
    private String dui;
    private String fechaDeNacimiento;
    private String estadoCivil;
    private String ocupacion;
    private BigDecimal ingresoMensual;
    private String telefonoMovil;
    private String correoElectronico;
    private String direccion;
    private String clasificacionDeCliente;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {

        if (validacion(1, nombres)){

            this.nombres = nombres;
            mensajeExito("Nombre correcto");

        }
        else { mensajeError("Formato de nombre incorrecto"); }

    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {

        if (validacion(1, apellidos)){

            this.apellidos = apellidos;
            mensajeExito("Apellido correcto");

        }
        else { mensajeError("Formato de apellido incorrecto"); }

    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {

        if (validacion(2, genero)) {

            this.genero = genero;
            mensajeExito("Genero correcto");

        }
        else { mensajeError("Formato de genero incorrecto"); }

    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {

        if (validacion(3, dui)) {

            this.dui = dui;
            mensajeExito("DUI correcto");

        }
        else { mensajeError("Formato de DUI incorrecto"); }

    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {

        if(validacion(4, fechaDeNacimiento)) {

            this.fechaDeNacimiento = convertirFecha(fechaDeNacimiento);
            mensajeExito("Fecha correcta");

        }
        else { mensajeError("Formato de fecha incorrecto"); }

    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {

        if (validacion(5, estadoCivil)) {

            this.estadoCivil = estadoCivil;
            mensajeExito("Estado civil correcto");

        }
        else { mensajeError("Formato de estado civil incorrecto"); }

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

        if (validacion(6, ingresoMensual.toString())) {

            this.ingresoMensual = ingresoMensual;
            mensajeExito("Ingreso mensual correcto");

        }
        else { mensajeError("Formato de ingreso mensual incorrecto"); }

    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {

        if (validacion(7, telefonoMovil)) {

            this.telefonoMovil = telefonoMovil;
            mensajeExito("Teléfono móvil correcto");

        }
        else { mensajeError("Formato de teléfono móvil incorrecto"); }

    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {

        if (validacion(8, correoElectronico)) {

            this.correoElectronico = correoElectronico;
            mensajeExito("Correo electrónico correcto");

        }
        else { mensajeError("Formato de correo electrónico incorrecto"); }

    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getClasificacionDeCliente() {
        return clasificacionDeCliente;
    }

    public void setClasificacionDeCliente(String clasificacionDeCliente) {

        if (validacion(9, clasificacionDeCliente)) {

            this.clasificacionDeCliente = clasificacionDeCliente;
            mensajeExito("Clasificación de cliente correcta");

        }
        else { mensajeError("Formato de clasificación de cliente incorrecto"); }

    }

    public String register() {

        Session session = null;
        Transaction tx = null;

        try {

            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            Cliente nuevoCliente = new Cliente();

            nuevoCliente.setNombres(getNombres());
            nuevoCliente.setApellidos(getApellidos());
            nuevoCliente.setGenero(getGenero());
            nuevoCliente.setDui(getDui());
            nuevoCliente.setFechaDeNacimiento(Date.valueOf(getFechaDeNacimiento()));
            nuevoCliente.setEstadoCivil(getEstadoCivil());
            nuevoCliente.setOcupacion(getOcupacion());
            nuevoCliente.setIngresoMensual(getIngresoMensual());
            nuevoCliente.setTelefonoMovil(getTelefonoMovil());
            nuevoCliente.setCorreoElectronico(getCorreoElectronico());
            nuevoCliente.setDireccion(getDireccion());
            nuevoCliente.setClasificacionDeCliente(getClasificacionDeCliente());

            session.save(nuevoCliente);
            tx.commit();

            mensajeExito("Cliente registrado con éxito");

            return "RegistroCliente";

        }
        catch (Exception e) {

            if (tx != null) { tx.rollback(); }
            e.printStackTrace();

            mensajeError("Error al registrar cliente");

            return "RegistroCliente";
        }
        finally { if (session != null) { session.close(); } }

    }

}
