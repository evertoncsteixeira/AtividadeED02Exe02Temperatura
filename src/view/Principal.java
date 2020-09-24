package view;

import controller.ListaTemperatura;

public class Principal {

	public static void main(String[] args) {
		ListaTemperatura temp = new ListaTemperatura();

		temp.removeIni();
		
		for (int i = 0; i < 5; i++) {

			// addIni01
			temp.adicionaIni((int) (Math.round(Math.random() * 80)-40));
			System.out.println(temp.listaPercorre());
			// addFim01
			temp.adicionaFim((int) (Math.round(Math.random() * 80)-40));
			System.out.println(temp.listaPercorre());
			// AddPos01
			temp.adicionaPos((int) (Math.round(Math.random() * 80)-40), (int) (Math.round(Math.random() * 3)+1));
			System.out.println(temp.listaPercorre());
			// RemFim01
			temp.removeFim();
			System.out.println(temp.listaPercorre());
			// RemPos01
			temp.removePos((int) (Math.round(Math.random() * 3)+1));
			System.out.println(temp.listaPercorre());
			// RemIni01
			temp.removeIni();
			System.out.println(temp.listaPercorre());
		}

	}

}
