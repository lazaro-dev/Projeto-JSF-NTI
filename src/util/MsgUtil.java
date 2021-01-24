package util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MsgUtil {

	public static void msgErro(String msg) {
		FacesContext.getCurrentInstance().addMessage("" ,new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
	}

	public static void msgWarn(String msg) {
		FacesContext.getCurrentInstance().addMessage("" ,new FacesMessage(FacesMessage.SEVERITY_WARN, msg, msg));
	}
	
	public static void msgInfo(String msg) {
		FacesContext.getCurrentInstance().addMessage("" ,new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));		
	}
}
