package aplicacao;

import aplicacao.model.ACMERental;

public class Main {

	public static void main(String[] args) {
		ACMERental acmeRental = new ACMERental();
		acmeRental.preCadastra();
		acmeRental.executa();
	}
}
