package aplicacao.model;

public class Aluguel {

	private String data;

	private int periodo;

	private String cpf;

	private String nome;

	private double valorFinal;

	//preciso desse atributo ne?
	private Alugavel item;

	public Aluguel(int periodo, String cpf, String nome, Alugavel item) {
		this.periodo = periodo;
		this.cpf = cpf;
		this.nome = nome;
		this.item = item;
		adicionarItem(item);
		valorFinal = calculaValorFinal();
	}

	//nao faz sentido receber o valorFinal no construtor pois ele deve ser calculado pelo metodo
	public Aluguel(String data, int periodo, String cpf, String nome, Alugavel item) {
		this.data = data;
		this.periodo = periodo;
		this.cpf = cpf;
		this.nome = nome;
		adicionarItem(item);
		valorFinal = calculaValorFinal();
	}

	@Override
	public String toString() {
		return "Aluguel{" +
				"data='" + data + '\'' +
				", periodo=" + periodo + " dias" +
				", cpf='" + cpf + '\'' +
				", nome='" + nome + '\'' +
				", valorFinal=" + valorFinal +
				'}';
	}

	//classe para atribuir um item a um aluguel
	public void adicionarItem(Alugavel item){
		this.item = item;
		//como eh um relacionamento bidirecional eu preciso falar para o item que agora ele faz parte desse aluguel
		item.adicionaAluguel(this);
	}

	//um aluguel nao teria que ter um Alugavel
	public double calculaValorFinal() {
		double valorTotal = periodo*item.getPrecoDiario();
		//caso o periodo seja maior que 7 dias damos 10% de desconto no valor Total
		if(periodo>7){
			valorTotal = valorTotal - (valorTotal*0.1);
			valorFinal = valorTotal;
			return valorFinal;
		}
		valorFinal = valorTotal;
		return valorFinal;
	}


	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValorFinal() {
		return valorFinal;
	}

	//setter nesse caso nao faz sentido
//	public void setValorFinal(double valorFinal) {
//		this.valorFinal = valorFinal;
//	}
}
