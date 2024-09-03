package sv.edu.udb.www.bancodeagricultura;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.edu.udb.www.entities.Cliente;
import sv.edu.udb.www.utils.HibernateUtil;
import java.math.BigDecimal;
import java.sql.Date;

public class test {

    private void setDataClient(){

        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = ses.beginTransaction();

        Cliente datos = new Cliente();

        datos.setNombres("Victor Francisco");
        datos.setApellidos("Marroquin Ramirez");
        datos.setGenero("Masculino");
        datos.setDocumentoDeIdentidad("06631775-8");
        datos.setFechaDeNacimiento(Date.valueOf("2004-01-08"));
        datos.setEstadoCivil("Soltero/a");
        datos.setOcupacion("Ingeniero en sistemas");
        datos.setIngresoMensual(BigDecimal.valueOf(1000.00));
        datos.setDireccion("Valle Verde 2 PJE.Q-sur POL.32 Casa #7");
        datos.setTelefonoMovil("+503 7946-2301");
        datos.setCorreoElectronico("dedpoolninguno@gmail.com");
        datos.setClasificacionDeCliente("Cliente");
        datos.setDescripcion("Cliente Regular");

        ses.save(datos);
        tra.commit();

    }

    public static void main(String[] args) {

        test prueba = new test();
        prueba.setDataClient();

    }

}

