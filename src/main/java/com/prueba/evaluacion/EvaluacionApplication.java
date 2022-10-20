package com.prueba.evaluacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;

import com.prueba.evaluacion.persistencia.UsuarioService;
import com.prueba.evaluacion.servicios.ILectorDatosService;

@SpringBootApplication
public class EvaluacionApplication implements CommandLineRunner{

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	@Lazy
	@Qualifier("URL")
	ILectorDatosService servicioLectorURL;
	
	@Autowired
	@Lazy
	@Qualifier("Google")
	ILectorDatosService servicioLectorGoogle;
	
	public static void main(String[] args) {
		SpringApplication.run(EvaluacionApplication.class, args);
			
	}
	
	@Override
	public void run(String... args) throws Exception {
				
		String mensaje = "final del programa";
		String error = "no parametro url";
		
		String googleURL = "sheets.googleapis.com";
		
		Integer numeroRegistrosProcesados = 0;		
				
		if (args.length == 0) {
			System.err.println(error);		
		} else {
			
			String url = args[0];
			
			if (url.contains(googleURL)) {
				numeroRegistrosProcesados = servicioLectorGoogle.leerUsuarios(url);
			} else {
				numeroRegistrosProcesados = servicioLectorURL.leerUsuarios(url);
			}
			
			System.out.println("Se han procesado: " + numeroRegistrosProcesados + " filas");
		}
		
		System.out.println(mensaje);
				
	}

}
