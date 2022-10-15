package persistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import entidades.Usuario;

public class UsusarioService {

	@Autowired
	private UsuarioRepository repositorio;
	
	public int guardarUsuario(Usuario usuario) throws Exception {
		
		return 0;
	}
	
	public int guardarUsuarios(List<Usuario> usuarios) throws Exception {
		
		return 0;
	}
	
}
