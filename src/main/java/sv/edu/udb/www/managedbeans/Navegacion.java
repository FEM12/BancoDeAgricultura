package sv.edu.udb.www.managedbeans;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Navegacion {

    public String goToAperturaCuenta(){ return "/Empleados/AperturadeCuenta"; }
    public String goToPanelCajero(){ return "/Empleados/PanelCajero"; }
    public String goToClienteLogin(){ return "/Clientes/ClienteLogin"; }

}
