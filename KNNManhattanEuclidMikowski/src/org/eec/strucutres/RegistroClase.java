package org.eec.strucutres;

import org.eec.math.Point2D;

public class RegistroClase {

	private Point2D punto;
	private int clase;
	
	public RegistroClase(Point2D punto, int clase) {
		super();
		this.punto = punto;
		this.clase = clase;
	}

	
	
	public Point2D getPunto() {
		return punto;
	}



	public void setPunto(Point2D punto) {
		this.punto = punto;
	}



	public int getClase() {
		return clase;
	}



	public void setClase(int clase) {
		this.clase = clase;
	}



	@Override
	public String toString() {
		return "RegistroClase [punto=" + punto + ", clase=" + clase + "]";
	}
	
} //--fin: RegistroClase
