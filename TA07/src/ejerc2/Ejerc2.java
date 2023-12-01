/**
 * 
 */
package ejerc2;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

/**
 * @author Nayara Nivea Gomes Santos
 *
 */
public class Ejerc2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final double IVA = 0.21;
		ArrayList<Double> lista = new ArrayList<>();

		lista.add(5.80);
		lista.add(9.70);
		lista.add(6.50);
		lista.add(2.30);

		Iterator<Double> it = lista.iterator();
		int precioTotalBruto = 0;
		while (it.hasNext()) {
			precioTotalBruto += it.next();
		}

		JOptionPane.showMessageDialog(null, "IVA APLICADO 21% ");
		JOptionPane.showMessageDialog(null, "Precio bruto: " + precioTotalBruto + " Precio mas IVA: "
				+ (precioTotalBruto + (precioTotalBruto * IVA)));
		JOptionPane.showMessageDialog(null, "Cantidad de articulos comprados: " + lista.size());
		int cantidadPagada = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el valor a pagar"));
		JOptionPane.showMessageDialog(null,
				"El cambio a devolver es de: " + (cantidadPagada - (precioTotalBruto + (precioTotalBruto * IVA))));

	}

}
