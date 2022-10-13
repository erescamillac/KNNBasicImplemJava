package org.eec.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eec.strucutres.RegistroClase;
import org.eec.strucutres.RegistroClaseConDistancia;
import org.eec.math.Point2D;
import org.eec.math.OrdenadorBurbuja;
import org.eec.math.EstimadorDistancias;
import org.eec.math.KNNExtractor;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<RegistroClase> puntosConClase;
		List<RegistroClaseConDistancia> listaDistancias, listaOrdenada, listaKNN;
		// System.out.println("##--Test Distancia Manhattan, Euclidiana, Mikowski--##");
		System.out.println("--Test KNN Algorithm... by EEC");
		Point2D puntoPrueba = new Point2D(4, 3);
		double distanciaTmp;
		int maxFreq, maxFreqClass;
		int k = 7;
		
		
		listaDistancias = new ArrayList<>();
		
		puntosConClase = initAsignedPoints();
		
		for(RegistroClase registroClase : puntosConClase) {
			//System.out.println(puntoClase);
			distanciaTmp = EstimadorDistancias.distanciaEuclidiana(registroClase.getPunto(), puntoPrueba);
			System.out.println("Evaluando distancia del Punto " 
			+ registroClase.getPunto() + " al punto PRUEBA " + puntoPrueba + " :: = " 
					+ distanciaTmp);
			listaDistancias.add( new RegistroClaseConDistancia(registroClase, distanciaTmp) );
		} // fin for
		
		System.out.println("##Lista RegistroClaseConDistancia :: ");
		System.out.println( "tamanio listaDistancias :: " + listaDistancias.size() );
		
		for(RegistroClaseConDistancia registroConDistancia : listaDistancias) {
			System.out.println( registroConDistancia );
		}
		
		// TODO :: Ordenar de menor a MAYOR ::
		System.out.println("\n####--Test Ordenamiento por BURBUJA--####\n");
		
		listaOrdenada = OrdenadorBurbuja.ordenarPorBurbuja( listaDistancias );
		
		System.out.println("\n++Lista ORDENADA :: \n");
		
		for(RegistroClaseConDistancia rCCD : listaOrdenada) {
			System.out.println( rCCD );
		} //-- fin : FOR : listaOrdenada
		
		// listaOrdenada : OK.
		System.out.println("\nk = " + k + "\n");
		
		// TODO : extract ONLY k-NEAREST neighbors from listaOrdenada :
		System.out.println("[" + k + "] NEAREST Neighbors to the TestPoint " + puntoPrueba);
		
		listaKNN = KNNExtractor.extractKNN(listaOrdenada, k);
		System.out.println("\n--Lista KNN--\n");
		for(RegistroClaseConDistancia rCCD : listaKNN) {
			System.out.println( rCCD );
		}
		System.out.println("\n++Lista KNN++\n");
		
		// Map<Integer, Integer> mapaContadorClase;
		// mapaContadorClase = new HashMap<>();
		// key-NO-Existe :: retorna NULL (null)
		// System.out.println( "key NO existe :: " + mapaContadorClase.get(6) );
		
		System.out.println("\n--Mapa Contador de Clases--\n");
		Map<Integer, Integer> mapaContadorClases = KNNExtractor.contadorClases( listaKNN );
		
		for(Map.Entry<Integer, Integer> entry : mapaContadorClases.entrySet()) {
			System.out.println( "Key = " + entry.getKey() + ", Value = " + entry.getValue() );
		} //--fin : FOR : RECORRIDO - mapaContadorClases
		
		maxFreq = KNNExtractor.maxFrequency( mapaContadorClases );
		System.out.println( "maxFreq := [" + maxFreq + "]" );
		
		maxFreqClass = KNNExtractor.maxFrequencyClass( mapaContadorClases );
		System.out.println( "maxFreqCLASS : " + maxFreqClass );
		
		System.out.println( "\nEl Test-Point <<" + puntoPrueba 
				+ ">>, pertenece a la Clase (" + maxFreqClass 
				+ ") -- '" + KNNExtractor.integerClassCodeToString(maxFreqClass) 
				+ "'" );
		
	} //--fin: main()
	
	private static List<RegistroClase> initAsignedPoints() {
		List<RegistroClase> listaPuntosClase;
		
		listaPuntosClase = new ArrayList<>();
		
		// Clase 0 :: 'Rojos'
		listaPuntosClase.add( new RegistroClase(new Point2D(1, 1), 0) );
		listaPuntosClase.add( new RegistroClase(new Point2D(1, 2), 0) );
		listaPuntosClase.add( new RegistroClase(new Point2D(2, 4), 0) );
		listaPuntosClase.add( new RegistroClase(new Point2D(2, 5), 0) );
		listaPuntosClase.add( new RegistroClase(new Point2D(3, 1), 0) );
		listaPuntosClase.add( new RegistroClase(new Point2D(3, 3), 0) );
		listaPuntosClase.add( new RegistroClase(new Point2D(4, 2), 0) );
		listaPuntosClase.add( new RegistroClase(new Point2D(4, 5), 0) );
		listaPuntosClase.add( new RegistroClase(new Point2D(4, 7), 0) );
		listaPuntosClase.add( new RegistroClase(new Point2D(5, 2), 0) );
		listaPuntosClase.add( new RegistroClase(new Point2D(5, 3), 0) );
		listaPuntosClase.add( new RegistroClase(new Point2D(6, 3), 0) );
		listaPuntosClase.add( new RegistroClase(new Point2D(7, 1), 0) );
		listaPuntosClase.add( new RegistroClase(new Point2D(7, 4), 0) );
		
		// Clase 1 :: 'Azules'
		listaPuntosClase.add( new RegistroClase(new Point2D(1, 4), 1) );
		listaPuntosClase.add( new RegistroClase(new Point2D(1, 7), 1) );
		listaPuntosClase.add( new RegistroClase(new Point2D(2, 2), 1) );
		listaPuntosClase.add( new RegistroClase(new Point2D(2, 7), 1) );
		listaPuntosClase.add( new RegistroClase(new Point2D(2, 8), 1) );
		listaPuntosClase.add( new RegistroClase(new Point2D(3, 4), 1) );
		listaPuntosClase.add( new RegistroClase(new Point2D(3, 6), 1) );
		listaPuntosClase.add( new RegistroClase(new Point2D(4, 4), 1) );
		listaPuntosClase.add( new RegistroClase(new Point2D(4, 6), 1) );
		listaPuntosClase.add( new RegistroClase(new Point2D(5, 4), 1) );
		listaPuntosClase.add( new RegistroClase(new Point2D(5, 5), 1) );
		listaPuntosClase.add( new RegistroClase(new Point2D(5, 8), 1) );
		listaPuntosClase.add( new RegistroClase(new Point2D(6, 4), 1) );
		listaPuntosClase.add( new RegistroClase(new Point2D(6, 5), 1) );
		listaPuntosClase.add( new RegistroClase(new Point2D(7, 5), 1) );
		
		return listaPuntosClase;
	}

} //--fin: CLASE : MainClass
