package sv.edu.udb.www.utils;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

public class JsfUtil {

    public static void mensajeExito(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public static void mensajeError(String msg) {

        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);

    }

}
