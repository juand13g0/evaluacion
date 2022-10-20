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
	
	//@Autowired
	//@Lazy
	//@Qualifier("Google")
	//ILectorDatosService servicioLectorGoogle;
	
	public static void main(String[] args) {
		SpringApplication.run(EvaluacionApplication.class, args);
			
	}
	
	@Override
	public void run(String... args) throws Exception {
				
		String mensaje = "final del programa";
		String error = "no parametro url";
		String servicioNoDisponible = "servicio de Google no disponible";
		
		String googleURL = "sheets.googleapis.com";
		
		Integer numeroRegistrosProcesados = 0;		
				
		if (args.length == 0) {
			System.err.println(error);		
		} else {
			
			String url = args[0];
			
			try {
			
				if (url.contains(googleURL)) {
					//numeroRegistrosProcesados = servicioLectorGoogle.leerUsuarios(url);
					System.out.println(servicioNoDisponible);
				} else {
					numeroRegistrosProcesados = servicioLectorURL.leerUsuarios(url);
				}
			
			} catch(Exception e) {
				System.err.println(causaExcepcion(e));
			}
			
			System.out.println("Se han procesado: " + numeroRegistrosProcesados + " filas");
		}
		
		System.out.println(mensaje);
				
	}
	
	private String causaExcepcion(Exception e) {
		
		Exception excepcion = e;
		
		while (e instanceof Exception && e.getCause() != null && e.getCause() instanceof Exception) {
			e = (Exception) e.getCause();
		}
		
		return e.toString();
	}

}
