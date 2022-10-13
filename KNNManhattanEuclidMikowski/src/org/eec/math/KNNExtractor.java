package org.eec.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eec.strucutres.*;

public class KNNExtractor {

	public static List<RegistroClaseConDistancia> extractKNN(List<RegistroClaseConDistancia> listaOrdenada, int k){
		List<RegistroClaseConDistancia> listaKNN;
		int counter = 0;
		
		listaKNN = new ArrayList<>();
		
		for(RegistroClaseConDistancia rCCD : listaOrdenada) {
			listaKNN.add( rCCD );
			counter++;
			if(counter == k) {
				break;
			}
		} //--fin: FOR : RECORRIDO - listaOrdenada
		
		return listaKNN;
	} //--fin : extractKNN()
	
	public static Map<Integer, Integer> contadorClases(List<RegistroClaseConDistancia> listaKNN){
		Map<Integer, Integer> mapaContadorClases;
		Integer contadorClaseTmp;
		
		mapaContadorClases = new HashMap<>();
		
		for(RegistroClaseConDistancia rCCD : listaKNN) {
			contadorClaseTmp = mapaContadorClases.get( rCCD.getRegistroClase().getClase() );
			if(contadorClaseTmp == null) {
				// significa que la KEY para la Clase AÚN NO se ha registrado 
				// en el HashMap, es la PRIMERA VEZ que se inserta la CLASE en el HashMap ::
				// inicializar contador en 1 (uno), primera coincidencia (ocurrencia)
				mapaContadorClases.put( rCCD.getRegistroClase().getClase(), 1);
			}else {
				// si el VALOR (Integer : contadorClaseTmp) NO es NULO
				// significa que la CLASE YA ESTÁ Registrada en el HashMap
				// por lo tanto SOLO es necesario actualizar el VALOR del Contador
				// contador++ (contador = contador + 1)
				contadorClaseTmp = contadorClaseTmp + 1;
				mapaContadorClases.put( rCCD.getRegistroClase().getClase(), contadorClaseTmp);
			}
		} //--fin : FOR : RECORRIDO - listaKNN
		
		return mapaContadorClases;
	} //--fin: contadroClases
	
	public static String integerClassCodeToString(int classCode) {
		String className = "";
		Map<Integer, String> mapaNombresClases;
		mapaNombresClases = new HashMap<>();
		
		mapaNombresClases.put(0, "ROJO");
		mapaNombresClases.put(1, "Azul");
		
		return mapaNombresClases.get( classCode );
	} //--fin : integerClassCodeToString
	
	public static int maxFrequency(Map<Integer, Integer> mapaContadorClases) {
		int maxFreq = Integer.MIN_VALUE;
		
		for(Map.Entry<Integer, Integer> entry : mapaContadorClases.entrySet()) {
			maxFreq = Math.max(maxFreq, entry.getValue());
		} //--fin : FOR : RECORRIDO - mapaContadorClases
		
		return maxFreq;
	} //--fin : maxFrequency()
	
	public static int maxFrequencyClass(Map<Integer, Integer> mapaContadorClases) {
		int clase = -1, maxFreq;
		
		maxFreq = maxFrequency(mapaContadorClases);
		
		for(Map.Entry<Integer, Integer> entry : mapaContadorClases.entrySet()) {
			clase = entry.getKey();
			if(entry.getValue() == maxFreq) {
				break;
			}
		} //--fin : FOR : RECORRIDO - mapaContadorClases
		
		return clase;
	} //--fin : maxFrequencyClass
	
} //--fin: KNNExtractor
