package org.eec.strucutres;

public class RegistroClaseConDistancia {
	
	private RegistroClase registroClase;
	private double distancia;
	
	public RegistroClaseConDistancia(RegistroClase registroClase, double distancia) {
		super();
		this.registroClase = registroClase;
		this.distancia = distancia;
	}
	
	

	public RegistroClase getRegistroClase() {
		return registroClase;
	}



	public void setRegistroClase(RegistroClase registroClase) {
		this.registroClase = registroClase;
	}



	public double getDistancia() {
		return distancia;
	}



	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}



	@Override
	public String toString() {
		return "RegistroClaseConDistancia [registroClase=" + registroClase + ", distancia=" + distancia + "]";
	}
	
	
	
} //-- fin: RegistroClaseCondistancia
