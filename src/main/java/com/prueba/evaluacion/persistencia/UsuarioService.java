package com.prueba.evaluacion.persistencia;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.dozermapper.core.Mapper;
import com.prueba.evaluacion.entidades.Usuario;

@Service
public class UsuarioService {

	@Autowired
    private IUsuarioRepository usuarioRepository;
	@Autowired
	private Mapper mapper;
			
	public int guardarUsuario(Usuario usuario) throws Exception {
		
		return 0;
	}
	
	public int guardarUsuarios(List<Usuario> usuarios) throws Exception {
		
		List<UsuarioEntity> listaUsuariosEntity = usuarios.stream()
			.map(usuario -> mapper.map(usuario, UsuarioEntity.class))
	            .collect(Collectors.toList());
		
		List<UsuarioEntity> registros = usuarioRepository.saveAll(listaUsuariosEntity);
		
		return registros.size();
	}
	
}
