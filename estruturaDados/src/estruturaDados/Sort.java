package estruturaDados;

import java.util.Arrays;

public class Sort {

	public void quicksort(int[] A) {
		quicksort(A, 0, A.length - 1);
	}

	public void mergesort(int[] A) {
		mergesort(A, 0, A.length - 1);
	}

	private void mergesort(int[] A, int ini, int fim) {

		if (fim > ini) {
			int pMetade = (fim + ini) / 2;
			mergesort(A, ini, pMetade);
			mergesort(A, pMetade + 1, fim);
			merge(A, ini, pMetade, fim);
		}

	}

	private void merge(int[] A, int ini, int pMetade, int fim) {

		int tam1 = pMetade - ini + 1;
		int tam2 = fim - pMetade;

		int[] vetorEsquerda = new int[tam1];
		int[] vetorDireita = new int[tam2];

		for (int i = 0; i < tam1; i++) {
			vetorEsquerda[i] = A[ini + i];
		}

		for (int i = 0; i < tam2; i++) {
			vetorDireita[i] = A[pMetade + 1 + i];
		}

		int i = 0, j = 0, k = ini;

		while (i < tam1 && j < tam2) {
			if (vetorEsquerda[i] <= vetorDireita[j]) {
				A[k] = vetorEsquerda[i];
				i++;
			} else {
				A[k] = vetorDireita[j];
				j++;
			}
			k++;
		}

		for (; i < tam1; i++) {
			A[k] = vetorEsquerda[i];
			k++;
		}

		for (; j < tam2; j++) {
			A[k] = vetorDireita[j];
			k++;
		}
	}

	private void quicksort(int[] A, int ini, int fim) {

		if (ini < fim) {
			int posicaoOrdenada = posicionaQuicksort(A, ini, fim);

			quicksort(A, ini, posicaoOrdenada - 1);
			quicksort(A, posicaoOrdenada + 1, fim);
		}
	}

	private int posicionaQuicksort(int[] A, int ini, int fim) {

		int pi = A[ini];

		int i = ini + 1;
		int j = fim;
		int aux = 0;
		while (i <= j) {

			if (A[i] > pi && A[j] < pi) {
				aux = A[i];
				A[i] = A[j];
				A[j] = aux;
				j--;
				i++;
			} else {
				if (A[i] <= pi) {
					i++;
				}
				if (A[j] > pi) {
					j--;
				}
			}

		}

		aux = A[ini];
		A[ini] = A[j];
		A[j] = aux;

		return j;
	}

	public static void main(String[] args) {
		int[] A = { 10, 16, 8, 12, 15, 6, 3, 9, 5 };

		Sort sort = new Sort();
		sort.mergesort(A);
		System.out.println(Arrays.toString(A));
	}
}
