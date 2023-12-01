/**
 * 
 */
package ejerc1;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * @author Nayara Nivea Gomes Santos
 *
 */
public class Ejerc1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[][] notes = { { 8, 7, 9, 6, 6, 7 }, { 4, 7, 5, 6, 6, 3 }, { 9, 7, 9, 5, 8, 7 }, };

		Hashtable<Integer, Double> contenedor = new Hashtable<Integer, Double>();

		for (int i = 0; i < notes.length; i++) {
			double suma = 0;
			double media = 0;
			for (int j = 0; j < notes.length; j++) {
				suma += notes[i][j];
			}
			media = suma / notes.length;
			contenedor.put(i, media);
		}

		Enumeration<Integer> llaves = contenedor.keys();
		Enumeration<Double> media = contenedor.elements();

		while (media.hasMoreElements()) {
			System.out.println("Llave: " + llaves.nextElement() + " Media: " + media.nextElement());
		}
	}

}
