package mb;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import bean.Usuario;
import dao.Banco;
import model.ModelUsuario;
import util.MsgUtil;
import util.RedirectUtil;

@ManagedBean
@SessionScoped
public class LoginMB implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private String userlog;
	private String senha;	
	private Usuario usuario;	

	public String login() throws IOException {
		
		try {
			ModelUsuario modelUsuario = new ModelUsuario();
			usuario = modelUsuario.getLogUsuario(new Banco(), userlog);
			
			if(usuario.getId()==null) {								
				MsgUtil.msgErro("Usuário não cadastrado");
			}else {
				if(!usuario.getSenha().equals(senha)) {
					MsgUtil.msgErro("Senha inválida");
				}else {				
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userlog", this.userlog);
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("acesso", this.usuario.getAcesso());
					
					 if(this.usuario.getAcesso().equals("1")) {			    	
						 return "admin/admin.xhtml?faces-redirect=true";
			    	 }
			    	 if(this.usuario.getAcesso().equals("2")) {			    
			    		 return "professor/professor.xhtml?faces-redirect=true";
			    	 }
			    	 if(this.usuario.getAcesso().equals("3")) {			    
			    		 return "aluno/aluno.xhtml?faces-redirect=true";
			    	 }
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";

	}
	
	public void logout(){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("userlog");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("acesso");
        
//        ((javax.servlet.http.HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
        
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        this.usuario=null;
        RedirectUtil.redirecionar("/login");
//        return "teste?faces-redirect=true";
    }
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getUserlog() {
		return userlog;
	}

	public void setUserlog(String userlog) {
		this.userlog = userlog;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
