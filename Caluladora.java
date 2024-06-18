package gitPrueba;

import java.util.InputMismatchException;

import javax.swing.JOptionPane;

public class Caluladora {
	// Calculadora Simple Java
	public static void main(String[] args) {

		try {
			String numero1 = JOptionPane.showInputDialog("Introduce el primer numero:");
			if (numero1 == null || numero1.isEmpty()) {
				throw new CampoVacioException("No puede estar vacío el campo número 1");
			}
			String numero2 = JOptionPane.showInputDialog("Introduce el segundo numero:");
			if (numero2 == null || numero2.isEmpty()) {
				throw new CampoVacioException("No puede estar vacío el campo número 2");
			}
			double num1 = Double.parseDouble(numero1);
			double num2 = Double.parseDouble(numero2);
			String opcion = JOptionPane.showInputDialog(
					"Qué operación quieres realizar: \nSuma '+' \nResta '-' \nMultiplicación '*' \nDivisión '/'");
			if (opcion.equals("+")) {
				Double suma = num1 + num2;
				JOptionPane.showMessageDialog(null, "Resultado Suma: " + suma);
			} else if (opcion.equals("-")) {
				Double resta = num1 - num2;
				JOptionPane.showMessageDialog(null, "Resultado Resta: " + resta);
			} else if (opcion.equals("*")) {
				Double multiplicacion = num1 * num2;
				JOptionPane.showMessageDialog(null, "Resultado Multiplicación: " + multiplicacion);
			} else if (opcion.equals("/")) {
				if (num2 == 0) {
					throw new ArithmeticException("No se puede dividir por cero");
				}
				Double division = num1 / num2;
				JOptionPane.showMessageDialog(null, "Resultado División: " + division);
			} else {
				throw new IllegalArgumentException("Operación no válida");
			}

		} catch (ArithmeticException a) {
			JOptionPane.showMessageDialog(null, "No se puede dividir por cero");
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Solo se pueden introducir números");
		} catch (InputMismatchException e) {
			JOptionPane.showMessageDialog(null, "Error numérico");
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
		} catch (CampoVacioException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
		}

	}

	public static class CampoVacioException extends Exception {
		private static final long serialVersionUID = 1L;

		public CampoVacioException(String message) {
			super(message);
		}
	}
}
