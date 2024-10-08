package sv.edu.udb.www.managedbeans;

import sv.edu.udb.www.entities.Cliente;
import sv.edu.udb.www.utils.ExpresionesUtil;
import sv.edu.udb.www.utils.HibernateUtil;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;
import jakarta.faces.context.FacesContext;
import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
@ViewScoped
public class ClienteRegistro {

    private String nombres;
    private String apellidos;
    private String genero;
    private String dui;
    private Date fechaDeNacimiento;
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

        if (ExpresionesUtil.validacion(1, nombres)){ this.nombres = nombres; }
        else { System.out.println("Error"); }

    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {

        if (ExpresionesUtil.validacion(1, apellidos)){ this.apellidos = apellidos; }
        else { System.out.println("Error"); }

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

        if (ExpresionesUtil.validacion(2, dui)){ this.dui = dui; }
        else { System.out.println("Error"); }

    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
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

        if (ExpresionesUtil.validacion(3, ingresoMensual.toString())){ this.ingresoMensual = ingresoMensual; }
        else { System.out.println("Error"); }

    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {

        if (ExpresionesUtil.validacion(4, telefonoMovil)){ this.telefonoMovil = telefonoMovil; }
        else { System.out.println("Error"); }

    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {

        if (ExpresionesUtil.validacion(5, correoElectronico)){ this.correoElectronico = correoElectronico; }
        else { System.out.println("Error");}

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
        this.clasificacionDeCliente = clasificacionDeCliente;
    }

    public String register() {

        Session session = null;
        Transaction tx = null;

        try {

            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            Cliente nuevoCliente = new Cliente();

            nuevoCliente.setNombres(nombres);
            nuevoCliente.setApellidos(apellidos);
            nuevoCliente.setGenero(genero);
            nuevoCliente.setDui(dui);
            nuevoCliente.setFechaDeNacimiento(fechaDeNacimiento);
            nuevoCliente.setEstadoCivil(estadoCivil);
            nuevoCliente.setOcupacion(ocupacion);
            nuevoCliente.setIngresoMensual(ingresoMensual);
            nuevoCliente.setTelefonoMovil(telefonoMovil);
            nuevoCliente.setCorreoElectronico(correoElectronico);
            nuevoCliente.setDireccion(direccion);
            nuevoCliente.setClasificacionDeCliente(clasificacionDeCliente);

            session.save(nuevoCliente);
            tx.commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente registrado con éxito"));

            return "RegistroCliente";

        }
        catch (Exception e) {

            if (tx != null) { tx.rollback(); }
            e.printStackTrace();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al registrar cliente", e.getMessage()));

            return "PanelCajero";
        }
        finally { if (session != null) { session.close(); } }

    }

}
