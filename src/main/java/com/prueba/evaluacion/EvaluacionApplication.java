package com.prueba.evaluacion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.prueba.evaluacion.entidades.Usuario;
import com.prueba.evaluacion.persistencia.UsuarioService;

@SpringBootApplication
public class EvaluacionApplication implements CommandLineRunner{

	@Autowired
	UsuarioService usuarioService;
	
	public static void main(String[] args) {
		SpringApplication.run(EvaluacionApplication.class, args);
			
	}
	
	@Override
	public void run(String... args) throws Exception {
				
		String mensaje = "final del programa";
		String error = "no parametro url";
		List<Usuario> listaUsuarios;
		
		URL inputURL;
		
		if (args.length == 0) {
			System.err.println(error);		
		} else {
			
			System.out.println(args[0]);
			
			inputURL = new URL(args[0]);
			
			BufferedReader contenidoReader = new BufferedReader(new InputStreamReader(inputURL.openStream()));
									
			CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
			
			CSVReader csvReader = new CSVReaderBuilder(contenidoReader).withCSVParser(csvParser).build();
			
			listaUsuarios = new ArrayList<Usuario>();
			for (String[] registro : csvReader.readAll()) {
												
				List<String> camposUsuario = Arrays.asList(registro);
				
				Usuario usuario = new Usuario(camposUsuario);
				System.out.println(usuario);
				
				listaUsuarios.add(usuario);
				
			}
			
			contenidoReader.close();
			
			int numero_registros = usuarioService.guardarUsuarios(listaUsuarios);
			System.out.println("Se han procesado: " + numero_registros + " filas");
		}
		
		System.out.println(mensaje);
				
	}

}
