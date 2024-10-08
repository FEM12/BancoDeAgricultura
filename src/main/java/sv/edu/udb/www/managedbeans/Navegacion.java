package sv.edu.udb.www.managedbeans;

import jakarta.faces.application.NavigationHandler;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import jakarta.faces.bean.ViewScoped;
import jakarta.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class Navegacion {

    public String goToAperturaCuenta(){ return "/Empleados/AperturadeCuenta"; }

    public String goToPanelCajero(){ return "/Empleado/PanelCajero"; }

}
