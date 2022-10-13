package org.eec.strucutres;

public class ContadorClase {

	private int clase;
	private int ocurrencias;
	
	public ContadorClase(int clase, int ocurrencias) {
		super();
		this.clase = clase;
		this.ocurrencias = ocurrencias;
	}//--fin : Constructor

	public int getClase() {
		return clase;
	}

	public void setClase(int clase) {
		this.clase = clase;
	}

	public int getOcurrencias() {
		return ocurrencias;
	}

	public void setOcurrencias(int ocurrencias) {
		this.ocurrencias = ocurrencias;
	}

	@Override
	public String toString() {
		return "ContadorClase [clase=" + clase + ", ocurrencias=" + ocurrencias + "]";
	}
	
} //--fin : ContadorClase
