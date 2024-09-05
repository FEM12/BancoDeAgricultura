package sv.edu.udb.www.managedbeans;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;
import jakarta.faces.context.FacesContext;
import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sv.edu.udb.www.entities.Credencialcliente;
import sv.edu.udb.www.utils.HibernateUtil;

@ManagedBean
@ViewScoped
public class EmpleadoLogin implements Serializable{

    private String username;
    private String password;


    public String getUsername() {
        return username;
    }

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

            Query<Credencialcliente> query = session.createQuery("FROM Credencialempleado WHERE usuario = :username AND contrasena = :password", Credencialcliente.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            Credencialcliente credencial = query.uniqueResult();

            tx.commit();

            if (credencial != null) { return "PanelCajero"; }
            else {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login failed", "Invalid username or password"));
                return "failure";

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
