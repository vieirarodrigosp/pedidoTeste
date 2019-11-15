package br.com.meuprojeto.pedidoTeste.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FerramentasSystemaUtil {
	
	// Converte String em LocalDateTime
	public static LocalDateTime converteStringParaLocalDateTime(String dataString) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		LocalDateTime dateTime = LocalDateTime.parse(dataString, formatter);
		
		return dateTime;
	}

}
