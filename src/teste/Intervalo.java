package teste;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Intervalo {

	public static void main(String[] args) {
		input();
	}

	public static void input() {

		Scanner stdin = new Scanner(System.in);

		System.out.println("Digite uma sequencia de 10 numeros , a cada input aperte Enter:");
		int v[] = new int[10]; // Cria um novo array com espaço para 10 inteiros
		// int n = stdin.nextInt(); // Ler a quantidade de numeros que se seguem

		for (int i = 0; i < 10; i++) { // Ler os numeros a partir do stdin
			v[i] = stdin.nextInt();
		}
		// writeArray(v); // Chamar procedimento que escreve

		for (Sequencia sequencia : gerarSequencias(v))
			System.out.println(sequencia);
	}

	private static class Sequencia {
		int inicio;
		int fim;

		public Sequencia(int inicio) {
			this.inicio = inicio;
			fim = inicio;
		}

		@Override
		public String toString() {
			if (inicio != fim)
				return "Inicio: " + inicio + " Fim: " + fim;
			return "Apenas: " + inicio;
		};
	}

	private static List<Sequencia> gerarSequencias(int[] numeros) {
		List<Sequencia> sequencias = new ArrayList();
		Sequencia seq = new Sequencia(numeros[0]);
		for (int i = 1; i < numeros.length; i++) {
			if (seq.fim + 1 == numeros[i])
				seq.fim++;
			else {
				sequencias.add(seq);
				seq = new Sequencia(numeros[i]);
			}
		}
		return sequencias;
	}

}