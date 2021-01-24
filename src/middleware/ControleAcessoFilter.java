package middleware;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import util.MsgUtil;

@WebFilter(urlPatterns={"/admin/*", "/professor/*", "/aluno/*"})
public class ControleAcessoFilter implements Filter{

//	private static String PAG_ADMIN;
//	private static String PAG_PROFESSOR;
//	private static String PAG_ALUNO;
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		 HttpServletRequest req = (HttpServletRequest) request;
	     HttpServletResponse resp = (HttpServletResponse) response;
	     
	     
	     if (!req.getRequestURI().endsWith("login.xhtml") && req.getSession().getAttribute("userlog") == null) {
//	    	 System.out.println("passei");
//	    	 MsgUtil.msgErro2("	Acesso negado", FacesContext.getCurrentInstance().getExternalContext());
//	    	 
//	    	 FacesContext.getCurrentInstance()
//	         .getExternalContext()
//	         .getFlash().setKeepMessages(true);
	    	 
	    	 resp.sendRedirect(req.getContextPath() + "/login.xhtml");
//	    	 
	     }else {
	    	 if(req.getRequestURI().contains("/admin/") && !req.getSession().getAttribute("acesso").equals("1")) {	    		 
	    		 resp.sendRedirect(req.getContextPath() + "/login.xhtml");
	    	 }
	    	 if(req.getRequestURI().contains("/professor/") && !req.getSession().getAttribute("acesso").equals("2")) {	    		 
	    		 resp.sendRedirect(req.getContextPath() + "/login.xhtml");
	    	 }
	    	 if(req.getRequestURI().contains("/aluno/") && !req.getSession().getAttribute("acesso").equals("3")) {
	    		 resp.sendRedirect(req.getContextPath() + "/login.xhtml");
	    	 }
	     }
	        chain.doFilter(req, resp);
	}
}
