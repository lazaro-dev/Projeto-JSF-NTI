package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Usuario;
import dao.Banco;

public class ModelUsuario {
	

	public Usuario getLogUsuario(Banco con, String userlog) {
			
			Connection conn = null;
			String sql = null;			
			Usuario usuario = new Usuario();
			
			try {
				
				conn = con.connection();
				if (conn != null) {
					
					sql = "SELECT * FROM USUARIO WHERE USERLOG = ?";
					PreparedStatement st = conn.prepareStatement(sql);
					
					st.setString(1, userlog);
					
					ResultSet result = st.executeQuery();
					
					if(result.next()){					
						usuario.setId(result.getString("ID"));
						usuario.setNome(result.getString("NOME"));
						usuario.setIdade(result.getString("IDADE"));
						usuario.setUserlog(result.getString("USERLOG"));
						usuario.setSenha(result.getString("SENHA"));
						usuario.setAcesso(result.getString("ACESSO"));
					}
																
					st.close();
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return usuario;
			
		}
}
