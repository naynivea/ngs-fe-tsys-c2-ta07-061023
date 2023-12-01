/**
 * 
 */
package ejerc4;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

/**
 * @author Nayara Nivea Gomes Santos
 *
 */
public class Ejerc4 {

	private static final double IVA = 0.21;

	public static void main(String[] args) {
		Hashtable<String, Double> contenedor = new Hashtable<String, Double>();

		contenedor.put("Huevos", 2.4);
		contenedor.put("Mantequilla", 2.3);
		contenedor.put("Palomitas", 1.5);
		contenedor.put("Aceitunas", 1.8);

		boolean seguir = true;
		while (seguir) {
			int opcion = Integer.parseInt(JOptionPane.showInputDialog("Elige una opcin \n" + "1. Aadir producto \n"
					+ "2. Consultar producto \n" + "3. Listar productos \n"
					+ "4. Ver el precio total (con IVA includo) \n" + "5. Pagar producto \n"
					+ "6. Mostrar cantidad de productos \n" + "7. Consultar el IVA \n" + "8. Finalizar"));
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
				double total = verTotal(contenedor);
				JOptionPane.showMessageDialog(null,
						"El valor total de los productos aadidos hasta el momento es de: " + total);
				break;
			case 5:
				double valor = Double.parseDouble(JOptionPane.showInputDialog("Introduce valor para pagar"));
				double cambio = pagarProductos(contenedor, valor);
				JOptionPane.showMessageDialog(null, "Tu cambio es de: " + cambio + "  ");
				seguir = false;
			case 6:
				mostrarCantidadProductos(contenedor);
				break;
			case 7:
				consultarIVA(IVA);
				break;
			case 8:
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

	public static void mostrarCantidadProductos(Hashtable<String, Double> contenedor) {
		JOptionPane.showMessageDialog(null, "Cantidad de artculos comprados: " + contenedor.size());
	}

	public static void consultarIVA(double IVA) {
		JOptionPane.showMessageDialog(null, "El IVA es de: " + (IVA * 100) + "%");
	}

	public static double verTotal(Hashtable<String, Double> contenedor) {
		Enumeration<Double> productos = contenedor.elements();
		double precioBruto = 0;
		double precioTotal;
		while (productos.hasMoreElements()) {
			precioBruto += productos.nextElement();
		}
		precioTotal = precioBruto + (precioBruto * IVA);
		return precioTotal;
	}

	public static double pagarProductos(Hashtable<String, Double> contenedor, double valor) {
		Enumeration<Double> productos = contenedor.elements();
		double cambio = 0;
		double precioBruto = 0;
		while (productos.hasMoreElements()) {
			precioBruto += productos.nextElement();
		}

		double precioIVA = precioBruto + (precioBruto * IVA);
		if (valor < precioIVA) {
			valor = Double.parseDouble(
					JOptionPane.showInputDialog("Dinero insuficiente, el precio total es de: " + precioIVA));
		}

		cambio = valor - precioIVA;
		return cambio;
	}

}
