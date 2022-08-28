package aplicacao;

import java.util.ArrayList;
import java.util.List;

/**
 * Equipamento esportivo
 * Autor: Rodrigo Rosa Renck
 */
public class Alugavel {

	private int codigo;

	private String nome;

	private double precoDiario;

	private String esporte;

	private String marca;

	private List<Aluguel> listaAlugueis = new ArrayList<>();


	public Alugavel(int codigo, String nome, double precoDiario){
		this.codigo = codigo;
		this.nome = nome;
		this.precoDiario = precoDiario;
	}


	public Alugavel(){}

	public Alugavel(int codigo, String nome, double precoDiario, String esporte, String marca) {
		this.codigo = codigo;
		this.nome = nome;
		this.precoDiario = precoDiario;
		this.esporte = esporte;
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Alugavel{" +
				"codigo=" + codigo +
				", nome='" + nome + '\'' +
				", precoDiario=" + precoDiario +
				", esporte='" + esporte + '\'' +
				", marca='" + marca + '\'' +
				", listaAlugueis=" + listaAlugueis +
				'}';
	}

	public boolean adicionaAluguel(Aluguel aluguel) {
		return listaAlugueis.add(aluguel);
	}

	public List<Aluguel> getListaAlugueis() {
		return listaAlugueis;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrecoDiario() {
		return precoDiario;
	}

	public void setPrecoDiario(double precoDiario) {
		this.precoDiario = precoDiario;
	}

	public String getEsporte() {
		return esporte;
	}

	public void setEsporte(String esporte) {
		this.esporte = esporte;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
}
