package com.prueba.evaluacion.servicios;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("Google")
public class LectorDatosGoogleSheetServiceImpl implements ILectorDatosService{

	private String spreadsheetId = "";
	private String rango = "";
	
	@Override
	public Integer leerUsuarios(String url) {
		 
		return 0;
	}
	
}
