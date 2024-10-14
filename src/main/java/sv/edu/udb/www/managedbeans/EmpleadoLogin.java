package sv.edu.udb.www.managedbeans;

import sv.edu.udb.www.entities.Credencialempleado;
import static sv.edu.udb.www.utils.EncriptarContrasenaUtil.encriptarContrasena;
import sv.edu.udb.www.utils.HibernateUtil;
import static sv.edu.udb.www.utils.JsfUtil.*;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;
import jakarta.faces.bean.SessionScoped;
import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@ManagedBean
@SessionScoped
public class EmpleadoLogin implements Serializable{

    private String username;
    private String password;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String login() {

        Session session = null;
        Transaction tx = null;

        try {

            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            Query<Credencialempleado> query = session.createQuery("FROM Credencialempleado WHERE usuario = :username AND contrasena = :password AND idEmpleado != null", Credencialempleado.class);
            query.setParameter("username", username);
            query.setParameter("password", encriptarContrasena(password));


            Credencialempleado credencial = query.uniqueResult();

            tx.commit();

            if (credencial != null) {

                mensajeExito("Haz iniciado sesión correctamente");
                return "PanelCajero";

            }
            else {

                mensajeError("Error: Usuario o Contraseña incorrectos");
                return "EmpleadoLogin";

            }

        }
        catch (Exception e) {

            if (tx != null) tx.rollback();
            e.printStackTrace();

            return "error";

        }
        finally { if (session != null) session.close(); }

    }

}
