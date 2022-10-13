package org.eec.math;

public class EstimadorDistancias {

	/*
	def distanciaEuclidiana(puntoA, puntoB):
   		return math.sqrt(pow((puntoB.x - puntoA.x),2) + pow((puntoB.y - puntoA.y),2)) 
	 */
	
	public static double distanciaEuclidiana(Point2D pointA, Point2D pointB) {
		double distancia = 0.0;
		distancia = Math.sqrt( (Math.pow( (pointB.getX() - pointA.getX()), 2)) + (Math.pow( (pointB.getY() - pointA.getY()), 2)) );
		return distancia;
	} //--fin: distanciaEuclidiana(pointA : Point2D, pointB : Point2D)
	
} //--fin: CLASE : EstimadorDistancias
