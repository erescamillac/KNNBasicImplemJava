package org.eec.math;

import java.util.ArrayList;
import java.util.List;

import org.eec.strucutres.RegistroClaseConDistancia;
import org.eec.strucutres.RegistroClase;


public class OrdenadorBurbuja {

	public static List<RegistroClaseConDistancia> ordenarPorBurbuja(List<RegistroClaseConDistancia> listaDistancias) {
		RegistroClaseConDistancia rCCDJ, rCCDJ1, regJ, regJ1;
		RegistroClaseConDistancia[] arrayRCCD;
		List<RegistroClaseConDistancia> listaOrdenada;
		
		listaOrdenada = new ArrayList<>();
		
		int tamanioLista = listaDistancias.size();
		int idxTmp = -1;
		arrayRCCD = new RegistroClaseConDistancia[tamanioLista];
		
		for(RegistroClaseConDistancia rCCD : listaDistancias) {
			idxTmp++;
			arrayRCCD[idxTmp] = new RegistroClaseConDistancia(
					new RegistroClase(new Point2D( rCCD.getRegistroClase().getPunto().getX(),
													rCCD.getRegistroClase().getPunto().getY()), rCCD.getRegistroClase().getClase()), rCCD.getDistancia());
		} //-- fin :: FOR :: RECORRIDO :: Cnv List<> -->> array[]
		
		System.out.println("Tamanio Array :: " + arrayRCCD.length);
		
		idxTmp = -1;
		System.out.println("\n--Contenido de ARRAY::\n");
		for(RegistroClaseConDistancia rCCD : arrayRCCD) {
			idxTmp++;
			System.out.println("[" + idxTmp + "] -- " + rCCD);
		}
		System.out.println("\n++Contenido de ARRAY++\n");
		
		
		for(int i = 0; i < tamanioLista; i++) {
			for(int j = 0; j < tamanioLista - 1; j++) {
				//PASO 1.- Clonar Objetos [j] y [j+1]
				/*
				rCCDJ = new RegistroClaseConDistancia( new RegistroClase(
						new Point2D( listaDistancias.get(j).getRegistroClase().getPunto().getX(),
								listaDistancias.get(j).getRegistroClase().getPunto().getY()), 
						listaDistancias.get(j).getRegistroClase().getClase()), 
						listaDistancias.get(j).getDistancia() );  
				 */
				
				rCCDJ = new RegistroClaseConDistancia( new RegistroClase(
						new Point2D( arrayRCCD[j].getRegistroClase().getPunto().getX(),
								arrayRCCD[j].getRegistroClase().getPunto().getY()), 
						arrayRCCD[j].getRegistroClase().getClase()), 
						arrayRCCD[j].getDistancia() );
				
				/*
				 rCCDJ1 = new RegistroClaseConDistancia( new RegistroClase(
						new Point2D( listaDistancias.get(j+1).getRegistroClase().getPunto().getX(),
								listaDistancias.get(j+1).getRegistroClase().getPunto().getY()), 
						listaDistancias.get(j+1).getRegistroClase().getClase()), 
						listaDistancias.get(j+1).getDistancia() );				  
				 */
				
				rCCDJ1 = new RegistroClaseConDistancia( new RegistroClase(
						new Point2D( arrayRCCD[j+1].getRegistroClase().getPunto().getX(),
								arrayRCCD[j+1].getRegistroClase().getPunto().getY()), 
						arrayRCCD[j+1].getRegistroClase().getClase()), 
						arrayRCCD[j+1].getDistancia() );
				
				// regJ = listaDistancias.get(j);
				// regJ1 = listaDistancias.get(j+1);
				
				if(rCCDJ.getDistancia() > rCCDJ1.getDistancia()) {
					// listaDistancias.add(j, regJ1);
					// rCCDJ ('pesado') -->> enviar AL FONDO [j+1]
					arrayRCCD[j+1] = rCCDJ;
					// rCCDJ1 'ligero'/'burbuja' -->> enviar hacia LA SUPERFICIE (j)
					arrayRCCD[j] = rCCDJ1;
				}
				
			} //fin : FOR anidado (j)
		} //fin: FOR principal (i)
		
		//al final convertir ARRAY to List<>
		for(RegistroClaseConDistancia rCCD : arrayRCCD) {
			listaOrdenada.add( rCCD );
		}
		
		return listaOrdenada;
	} //--ordenarPorBurbuja
	
} //-- OrdenadorBurbuja
