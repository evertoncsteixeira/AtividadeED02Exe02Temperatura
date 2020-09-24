package controller;

public class ListaTemperatura {
	private Item inicio;

	public ListaTemperatura() {
		inicio = null;
	}

	// verificar vazio
	public boolean listaVazia() {
		return inicio == null;
	}

	// adiciona no inicio
	public void adicionaIni(int t) {
		Item novo = new Item(t);
		novo.prox = inicio;
		inicio = novo;
	}

	// recursiva para pegar o ultimo item
	public Item retornaUltimo(Item i) {
		Item aux;
		if (i.prox == null) {
			aux = i;
		} else {
			aux = retornaUltimo(i.prox);
		}
		return aux;
	}

	// recursiva para pegar o penultimo item
	public Item retornaPenulto(Item i) {
		Item aux;
		aux = i.prox;
		if (aux.prox == null) {
			aux = i;
		} else {
			aux = retornaUltimo(i.prox);
		}
		return aux;
	}

	// recursiva para pegar o posição
	public Item retornaPosicao(Item i, int p, int c) {
		Item aux;
		if (i.prox != null && c == p) {
			aux = i;
		} else {
			if (i.prox == null) {
				System.out.println("Posição invalida");
				aux = null;
			} else {
				c++;
				aux = retornaPosicao(i.prox, p, c);
			}
		}
		return aux;
	}

	// adiciona no final
	public void adicionaFim(int t) {
		if (!(inicio == null)) {
			Item aux = retornaUltimo(inicio);
			aux.prox = new Item(t);
		} else
			inicio = new Item(t);
	}

	// adicionar uma temperatura em determinada posição da lista
	public void adicionaPos(int t, int p) {
		if (p == 1 || listaVazia()) {
			adicionaIni(t);
		} else {
			// while (aux.prox != null && c < p - 1) {
			// aux = aux.prox;
			// c++;
			// }
			try {
				Item aux = retornaPosicao(inicio, p, 0);
				Item novo = new Item(t);
				novo.prox = aux.prox;
				aux.prox = novo;
			} catch (Exception e) {
				// TODO: handle exception
			}
			

			// if (c == p - 1) {
		
			// } else {

			// System.out.println("Posição não encontrada");
			// }
		}
	}

	// remover a temperatura do início da lista
	public int removeIni() {
		int r = -1;
		if (listaVazia()) {
			System.out.println("Lista esta vazia!");
		} else {
			r = inicio.t;
			inicio = inicio.prox;
		}
		return r;
	}

	// remover a temperatura do final da lista
	public int removeFim() {
		int r = -1;
		if (listaVazia())
			System.out.println("Lista esta vazia!");
		else if (inicio.prox == null) {
			r = inicio.t;
			inicio = null;
		} else {
			Item aux1 = retornaUltimo(inicio);
			Item aux2 = retornaPenulto(inicio);
			// while (aux1.prox != null) {
			// aux2 = aux1;
			// aux1 = aux1.prox;
			// }
			r = aux1.t;
			aux2.prox = null;
		}
		return r;
	}

	// remover a temperatura de determinada posição da lista
	public int removePos(int p) {
		int r = -1;
		if (!listaVazia()) {
			if (p == 1) {
				removeIni();
			} else {
				
				try {
					Item aux = retornaPosicao(inicio, p - 1, 0);
					Item novo = aux.prox;
					r = novo.t;
					aux.prox = novo.prox;
				} catch (Exception e) {
					r = 0;
				}
				
				// int c = 1;
				// while (aux.prox != null && c < p - 2) {
				// aux = aux.prox;
				// c++;
				// }

				// if (c == p - 1) {
			
				// } else {

				// System.out.println("Posição não encontrada");
				// }

			}
			return r;
		} else {
			System.out.println("Lista está vazia");
			return r;
		}

	}

	// percorrer e apresentar cada um dos elementos
	public String listaRecursiva(Item i) {
		String r = "";
		if (i.prox == null) {
			r += i.t + "; ";
		} else {
			r += i.t + "; " + listaRecursiva(i.prox);
		}

		return r;
	}

	public String listaPercorre() {
		String r = "";
		if (! listaVazia()) {
			r = listaRecursiva(inicio);
		}
		return r;
	}
}
