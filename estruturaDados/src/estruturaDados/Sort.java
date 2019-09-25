package estruturaDados;

public class Sort {

	public void quicksort(int[] A) {
		quicksort(A, 0, A.length - 1);
	}

	private void quicksort(int[] A, int ini, int fim) {

		if (ini < fim) {
			int posicaoOrdenada = posiciona(A, ini, fim);

			quicksort(A, ini, posicaoOrdenada - 1);
			quicksort(A, posicaoOrdenada + 1, fim); 
		}

	}

	private int posiciona(int[] A, int ini, int fim) {

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
		sort.quicksort(A);
	}
}
