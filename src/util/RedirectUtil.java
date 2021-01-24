package util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectUtil {
	
	public static void redirecionar(String url){        

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        try {
           response.sendRedirect(req.getContextPath() + url + ".xhtml");
           FacesContext.getCurrentInstance().responseComplete();
//           FacesContext.getCurrentInstance().renderResponse();
        }

        catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
