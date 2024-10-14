package sv.edu.udb.www.managedbeans;

import sv.edu.udb.www.entities.Credencialcliente;
import sv.edu.udb.www.utils.HibernateUtil;
import static sv.edu.udb.www.utils.EncriptarContrasenaUtil.encriptarContrasena;
import static sv.edu.udb.www.utils.JsfUtil.mensajeError;
import static sv.edu.udb.www.utils.JsfUtil.mensajeExito;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.bean.ViewScoped;
import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@ManagedBean
@SessionScoped
public class ClienteLogin implements Serializable{

    private String username;
    private String password;

    public String getUsername() { return username; }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {

        Session session = null;
        Transaction tx = null;

        try {

            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            Query<Credencialcliente> query = session.createQuery("FROM Credencialcliente WHERE usuario = :username AND contrasena = :password", Credencialcliente.class);
            query.setParameter("username", username);
            query.setParameter("password", encriptarContrasena(password));
            Credencialcliente credencial = query.uniqueResult();

            tx.commit();

            if (credencial != null) {

                mensajeExito("Haz iniciado sesión correctamente");
                return "PanelCliente";

            }
            else {

                mensajeError("Error: Usuario o Contraseña incorrectos");
                return "ClienteLogin";

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
