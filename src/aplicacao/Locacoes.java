package aplicacao;

import java.util.ArrayList;
import java.util.List;

/**
 * Autor: Rodrigo Rosa Renck
 */
public class Locacoes {

//	private Aluguel[] aluguel;
	private List<Aluguel> listaAluguel = new ArrayList<>();

	public void adicionaAluguel(Aluguel aluguel) {
		listaAluguel.add(aluguel);
	}

	public ArrayList<Aluguel> pesquisaAluguel(String cpf) {
		ArrayList<Aluguel> listaAlugueisPorCpf = new ArrayList<>();
		for (Aluguel aluguel :
				listaAluguel) {
			if (aluguel.getCpf().equals(cpf)) listaAlugueisPorCpf.add(aluguel);
		}
		//se eu passar por toda a minha lista de alugueis e nao achar nenhum com o CPF escolhido a minha listaPorCpf estara vazia, entao eu devolvo null
		if(listaAlugueisPorCpf.isEmpty()){
			return null;
		}
		return listaAlugueisPorCpf;
	}
}
