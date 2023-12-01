/**
 * 
 */
package ejerc3;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

/**
 * @author Nayara Nivea Gomes Santos
 *
 */
public class Ejerc3 {
	public static void main(String[] args) {
		Hashtable<String, Double> contenedor = new Hashtable<String, Double>();

		contenedor.put("Huevos", 2.4);
		contenedor.put("Mantequilla", 2.3);
		contenedor.put("Palomitas", 1.5);
		contenedor.put("Aceitunas", 1.8);

		boolean seguir = true;
		while (seguir) {
			int opcion = Integer.parseInt(JOptionPane.showInputDialog("Elige una opcin \n" + "1. Aadir producto \n"
					+ "2. Consultar producto \n" + "3. Listar producto \n" + "4. Finalizar"));
			switch (opcion) {
			case 1:
				anadir(contenedor);
				break;
			case 2:
				consultar(contenedor);
				break;
			case 3:
				listar(contenedor);
				break;
			case 4:
				seguir = false;
				break;
			}
		}

	}

	public static void anadir(Hashtable<String, Double> contenedor) {
		String producto = JOptionPane.showInputDialog("Introduzca el producto");
		double precio = Double.parseDouble(JOptionPane.showInputDialog("Introduzca el valor del producto"));
		contenedor.put(producto, precio);
	}

	public static void consultar(Hashtable<String, Double> contenedor) {
		String producto = JOptionPane.showInputDialog("Introduzca el nombre del producto a consultar");
		JOptionPane.showMessageDialog(null, contenedor.get(producto));
	}

	public static void listar(Hashtable<String, Double> contenedor) {
		Enumeration<String> llaves = contenedor.keys();
		Enumeration<Double> productos = contenedor.elements();

		while (productos.hasMoreElements()) {
			System.out.println("Producto: " + llaves.nextElement() + " Precio: " + productos.nextElement());
		}
	}
}
