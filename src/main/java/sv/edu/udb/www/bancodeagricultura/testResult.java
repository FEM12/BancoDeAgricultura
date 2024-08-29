package sv.edu.udb.www.bancodeagricultura;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sv.edu.udb.www.entities.Cliente;
import sv.edu.udb.www.utils.HibernateUtil;

import java.util.ArrayList;

public class testResult {

    public static void main(String[] args) {

        SessionFactory sesFact= HibernateUtil.getSessionFactory();
        Session ses=sesFact.openSession();

        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

        String sql="from Cliente";

        listaClientes= (ArrayList<Cliente>) ses.createQuery(sql).list();

        for(int i = 0; i < listaClientes.size(); i++){

            Cliente cliente = (Cliente) listaClientes.get(i);
            System.out.println(cliente.getId() + " " + cliente.getNombres() + " " + cliente.getApellidos());

        }

    }

}

