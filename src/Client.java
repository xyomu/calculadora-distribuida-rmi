import java.rmi.Naming;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String sair = "S";
		String operador;
		double valor1;
		double valor2;
		double resultado;

		try {
			BasicServerInterface calculadoraBasica = (BasicServerInterface) Naming
					.lookup("rmi://localhost:10001/BasicServer");
			System.out.println("Conectado ao Servidor Basico...");

			SpecialServerInterface calculadoraEspecial = (SpecialServerInterface) Naming
					.lookup("rmi://localhost:10002/SpecialServer");
			System.out.println("Conectado ao Servidor Especial...");

			while (sair.equalsIgnoreCase("S")) {
				operador = "";
				valor1 = 0;
				valor2 = 0;
				resultado = 0;

				System.out.println("\nOperadores Validos: " + "\nSoma: + " + "\nSubtração: - " + "\nMultiplicação: * "
						+ "\nDivisão: / " + "\nPotencia: ^ " + "\nPorcentagem: % " + "\nRaiz Quadrada: @");
				
				do {
					
					System.out.println("\nInforme um operador valido: ");
					operador = scan.next();

				} while (!validaOperador(operador));


				if (operador.equals("@")) {

					System.out.println("Informe o valor: ");
					valor1 = Double.parseDouble(scan.next());

				} else {
					System.out.println("Informe o primeiro valor: ");
					valor1 = Double.parseDouble(scan.next());

					System.out.println("Informe o segundo valor: ");
					valor2 = Double.parseDouble(scan.next());
				}

				try {

					resultado = switch (operador) {
					case "+" -> calculadoraBasica.adicao(valor1, valor2);
					case "-" -> calculadoraBasica.subtracao(valor1, valor2);
					case "*" -> calculadoraBasica.multiplicacao(valor1, valor2);
					case "/" -> calculadoraBasica.divisao(valor1, valor2);
					case "^" -> calculadoraEspecial.potencia(valor1, valor2);
					case "%" -> calculadoraEspecial.porcentagem(valor1, valor2);
					case "@" -> calculadoraEspecial.raizQuadrada(valor1);
					default -> throw new Exception("Operador Invalido");
					};

					System.out.println("\nResultado: " + resultado);

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				do {

					System.out.println("\nDeseja realizar outra operação? S/N");
					sair = scan.next();

				} while (!sair.equalsIgnoreCase("S") && !sair.equalsIgnoreCase("N"));

			}

			System.out.println("Cliente Desligado...");

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			scan.close();

		}
	}

	public static boolean validaOperador(String operador) {
		return switch (operador) {
		case "+", "-", "*", "/", "^", "%", "@" -> true;
		default -> {
			System.out.println("Operador Invalido, Tente Novamente...");
			yield false;
		}
		};
	}

}
