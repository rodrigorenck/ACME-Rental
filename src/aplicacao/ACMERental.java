package aplicacao;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Autor: Rodrigo Rosa Renck
 */
public class ACMERental {

    private Acervo acervo;

    private Locacoes locacoes;

    //scanner para numeros
    private Scanner sc;

    //scanner para String
    private Scanner scStr;

    public ACMERental() {
        acervo = new Acervo();
        locacoes = new Locacoes();
        sc = new Scanner(System.in);
        scStr = new Scanner(System.in);
    }


    public void preCadastra() {
        Alugavel item1 = new Alugavel(1, "Raquete de tenis", 30, "Tenis", "Wilson");
        Alugavel item2 = new Alugavel(2, "Bola de basquete", 45, "Basquete", "Nike");
        Alugavel item3 = new Alugavel(3, "Chuteira", 85, "Futebol", "Adidas");
        acervo.adicionaAlugavel(item1);
        acervo.adicionaAlugavel(item2);
        acervo.adicionaAlugavel(item3);


        // 5 alugueis - um dos alugueis deve ter periodo maior que 7 dias, um dos itens alugaveis deve possuir tres alugueis diferentes,
        // dois alugueis devem ser do mesmo cliente
        Aluguel aluguel1 = new Aluguel("20/08/2022", 5, "230.149.108-05", "Roberto Pereira", item1);
        Aluguel aluguel2 = new Aluguel("20/08/2022", 8, "230.149.108-05", "Roberto Pereira", item3);
        Aluguel aluguel3 = new Aluguel("17/08/2022", 3, "061.231.180-15", "Carlos Santos", item2);
        Aluguel aluguel4 = new Aluguel("15/08/2022", 6, "921.329.171-09", "Giovana Duarte", item1);
        Aluguel aluguel5 = new Aluguel("15/08/2022", 5, "432.156.987-12", "Jose da Silve", item1);
        locacoes.adicionaAluguel(aluguel1);
        locacoes.adicionaAluguel(aluguel2);
        locacoes.adicionaAluguel(aluguel3);
        locacoes.adicionaAluguel(aluguel4);
        locacoes.adicionaAluguel(aluguel5);
    }

    public void executa() {
        int opcao;
        do {
            //rodo o menu e depois pego a resposta do usuario
            menu();
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    mostrarTodos();
                    break;
                case 2:
                    pesquisarPeloCodigo();
                    break;
                case 3:
                    pesquisarPeloNome();
                    break;
                case 4:
                    pesquisarAlugueisPeloCliente();
                    break;
                case 5:
                    cadastrarAluguel();
                    break;
                case 6:
                    encerrarAplicacao();
                    break;
                default:
                    System.out.println("[Opcao invalida!]");
                    System.out.println();
                    break;
            }
        } while (opcao != 6);
    }

    private void cadastrarAluguel() {
        System.out.println();
        System.out.println("[Cadastro de Aluguel]");
        System.out.println("-----------------------");
        System.out.println("Informe os dados abaixo." );
        System.out.print("Data: ");
        String data = scStr.nextLine();
        System.out.print("Periodo: ");
        int periodo = sc.nextInt();
        System.out.print("CPF: ");
        String cpf = scStr.nextLine();
        System.out.print("Nome: ");
        String nome = scStr.nextLine();
        System.out.print("Codigo do item que deseja alugar: ");
        int codigo = sc.nextInt();
        Alugavel alugavel = acervo.pesquisaAlugavel(codigo);
        if(alugavel != null){
            Aluguel novoAluguel = new Aluguel(data, periodo, cpf, nome, alugavel);
            locacoes.adicionaAluguel(novoAluguel);
            System.out.println("Aluguel cadastrado com sucesso!");
        }else{
            System.out.println("Erro! Item que voce deseja alugar nao esta cadastrado no sistema!");
        }
    }

    private void encerrarAplicacao() {
        System.out.println();
        System.out.println("Encerrando o programa...");
    }

    private void menu() {
        System.out.println("MENU ACME-RENTAL");
        System.out.println("----------------");
        System.out.println("[1] Mostrar todos os dados cadastrados");
        System.out.println("[2] Pesquisar item alugavel pelo codigo");
        System.out.println("[3] Pesquisar itens alugaveis pelo nome");
        System.out.println("[4] Pesquisar alugueis de um cliente");
        System.out.println("[5] Cadastrar um aluguel");
        System.out.println("[6] Sair");
        System.out.print("Opcao desejada: ");
    }

    private void mostrarTodos() {
        //se o acervo nao estiver vazio, printamos os itens
        if (!acervo.estaVazio()) {
            System.out.println("Itens cadastrados no sistema: ");
            acervo.mostrarTodos().forEach(System.out::println);
        } else {
            System.out.println("Nenhum item alugavel cadastrado no sistema.");
        }
        System.out.println();
    }

    private void pesquisarPeloCodigo() {
        System.out.print("Digite o codigo do item: ");
        int codigo = sc.nextInt();
        Alugavel alugavel = acervo.pesquisaAlugavel(codigo);
        if (alugavel == null) {
            System.out.println("Nao existe item com este codigo \n");
        } else {
            System.out.println(alugavel + "\n");
        }
    }

    private void pesquisarPeloNome() {
        System.out.print("Digite o nome do item: ");
        String nome = scStr.nextLine();
        ArrayList<Alugavel> listaItensPeloNome = acervo.pesquisaAlugavel(nome);
        if (listaItensPeloNome == null) {
            System.out.println("Nenhum item alugavel encontrado com esse nome");
        } else {
            listaItensPeloNome.forEach(System.out::println);
        }
        System.out.println();
    }

    private void pesquisarAlugueisPeloCliente() {
        System.out.print("Informe o cpf: ");
        String cpf = scStr.nextLine();
        ArrayList<Aluguel> listaAlugueisCliente = locacoes.pesquisaAluguel(cpf);
        if (listaAlugueisCliente == null) {
            System.out.println("Nenhum aluguel encontrado com esse CPF");
        } else {
            for (Aluguel aluguel :
                    listaAlugueisCliente) {
                System.out.println(aluguel + " {Item Alugado: " + aluguel.getItem().getNome() + ", codigo: " + aluguel.getItem().getCodigo() +
                        ", preco diario: " + aluguel.getItem().getPrecoDiario() + ", esporte: " + aluguel.getItem().getEsporte() +
                        ", marca: " + aluguel.getItem().getMarca() + "}");
            }
        }
        System.out.println();
    }
}
