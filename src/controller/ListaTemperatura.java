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

	// adiciona no final
	public void adicionaFim(int t) {
		if (!(inicio == null)) {
			Item aux = inicio;
			while (aux.prox != null) {
				aux = aux.prox;
			}
			aux.prox = new Item(t);
		} else
			inicio = new Item(t);
	}

	// adicionar uma temperatura em determinada posição da lista
	public void adicionaPos(int t, int p) {
		if (p == 1 || listaVazia()) {
			adicionaIni(t);
		} else {
			Item aux = inicio;
			int c = 1;
			while (aux.prox != null && c < p - 1) {
				aux = aux.prox;
				c++;
			}

			if (c == p - 1) {
				Item novo = new Item(t);
				novo.prox = aux.prox;
				aux.prox = novo;
			} else {

				System.out.println("Posição não encontrada");
			}
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
			Item aux1 = inicio;
			Item aux2 = null;
			while (aux1.prox != null) {
				aux2 = aux1;
				aux1 = aux1.prox;
			}
			r = aux1.t;
			aux2.prox = null;
		}
		return r;
	}
	//remover a temperatura de determinada posição da lista
	public int removePos(int p) {
		int r = -1;
		if (!listaVazia()) {
			if (p == 1) {
				removeIni();
			} else {
				Item aux = inicio;
				int c = 1;
				while (aux.prox != null && c < p - 2) {
					aux = aux.prox;
					c++;
				}

				if (c == p - 1) {
					Item novo = aux.prox;
					r = novo.t;
					aux.prox = novo.prox;
				} else {

					System.out.println("Posição não encontrada");
				}

			}
			return r;
		} else {
			System.out.println("Lista está vazia");
			return r;
		}
		
	}

	// percorrer e apresentar cada um dos elementos
	public String listaPercorre() {
		String r = "";
		Item aux = inicio;
		while (aux != null) {
			r = r + " " + aux.t;
			aux = aux.prox;
		}
		return r;
	}
}
