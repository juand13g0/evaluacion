package com.prueba.evaluacion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EvaluacionApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EvaluacionApplication.class, args);
			
	}

	@Override
	public void run(String... args) throws Exception {
		
		String mensaje = "final del programa";
		String error = "no parametro url";
		
		URL inputURL;
		
		if (args.length == 0) {
			System.err.println(error);		
		} else {
			
			System.out.println(args[0]);
			
			inputURL = new URL(args[0]);
			
			BufferedReader contenidoReader = new BufferedReader(new InputStreamReader(inputURL.openStream()));
			
			String linea;
			
			while ((linea = contenidoReader.readLine()) != null) {
				
				System.out.println(linea);
				
			}
			
			contenidoReader.close();
			
		}
		
		System.out.println(mensaje);
		
	}

}
