package com.prueba.evaluacion.persistencia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prueba.evaluacion.entidades.Usuario;

@Component("usuarioService")
public class UsuarioService {

	@Autowired
    private IUsuarioRepository usuarioRepository;
			
	public int guardarUsuario(Usuario usuario) throws Exception {
		
		return 0;
	}
	
	public int guardarUsuarios(List<Usuario> usuarios) throws Exception {
		
		List<UsuarioEntity> listaUsuariosEntity = new ArrayList<UsuarioEntity>();
		//mapper.map(usuarios,listaUsuariosEntity);
		
		for (Usuario usuario : usuarios) {
			UsuarioEntity usuarioEntity = mapearAUsuarioEntity(usuario);
			//mapper.map(usuario, usuarioEntity);
			System.out.println(usuarioEntity);
			listaUsuariosEntity.add(usuarioEntity);
		}
		
		/*listaUsuariosEntity = usuarios.stream()
			.map(usuario -> mapper.map(usuario, UsuarioEntity.class))
	            .collect(Collectors.toList());
		*/
		List<UsuarioEntity> registros = usuarioRepository.saveAll(listaUsuariosEntity);
		
		return registros.size();
	}
	
	private UsuarioEntity mapearAUsuarioEntity(Usuario usuario) {
		
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		
		usuarioEntity.setNombre(usuario.getNombre());
		usuarioEntity.setApellidos(usuario.getApellidos());
		usuarioEntity.setNif(usuario.getNif());
		usuarioEntity.setFechaNacimiento(usuario.getFechaNacimiento());
		usuarioEntity.setEmail(usuario.getEmail());
				
		return usuarioEntity;
		
	}
	
}
