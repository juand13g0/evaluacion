package com.prueba.evaluacion.servicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import com.prueba.evaluacion.entidades.Usuario;
import com.prueba.evaluacion.persistencia.UsuarioService;

@Service
@Lazy
@Qualifier("URL")
public class LectorDatosURLServiceImpl implements ILectorDatosService {

	@Autowired
	UsuarioService usuarioService;
		
	@Override
	public Integer leerUsuarios(String url) {
		
		System.out.println("LectorDatosURLServiceImpl :: url=" + url);
		
		BufferedReader contenidoReader;
		List<Usuario> listaUsuarios;
		
		Integer numero_registros = 0;
		
		try {
			
			URL inputURL = new URL(url);
		
			contenidoReader = new BufferedReader(new InputStreamReader(inputURL.openStream()));
			
			CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
			CSVReader csvReader = new CSVReaderBuilder(contenidoReader).withCSVParser(csvParser).build();
			
			listaUsuarios = new ArrayList<Usuario>();
			
			for (String[] registro : csvReader.readAll()) {
				listaUsuarios.add(mapeoRegistroASusuario(registro));
			}
			
			contenidoReader.close();
			
			numero_registros = usuarioService.guardarUsuarios(listaUsuarios);
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (CsvException csve) {
			csve.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return numero_registros;
	}
	
	private Usuario mapeoRegistroASusuario(String[] registro) throws Exception{
		
		List<String> camposUsuario = Arrays.asList(registro);
		Usuario usuario = new Usuario(camposUsuario);
		System.out.println(usuario);
		
		return usuario;
	}

}
