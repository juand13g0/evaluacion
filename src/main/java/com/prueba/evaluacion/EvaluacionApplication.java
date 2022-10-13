package com.prueba.evaluacion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import entidades.Usuario;

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
									
			CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
			
			CSVReader csvReader = new CSVReaderBuilder(contenidoReader).withCSVParser(csvParser).build();
			
			for (String[] registro : csvReader.readAll()) {
												
				List<String> camposUsuario = Arrays.asList(registro);
				
				Usuario usuario = new Usuario(camposUsuario);
				System.out.println(usuario);
				
			}
			
			contenidoReader.close();
			
		}
		
		System.out.println(mensaje);
		
	}

}
