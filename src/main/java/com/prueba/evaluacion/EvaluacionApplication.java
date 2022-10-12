package com.prueba.evaluacion;

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
		
		if (args.length > 0) {
			for (String string : args) {
				System.out.println(string);
			}
		}
		
	}

}
