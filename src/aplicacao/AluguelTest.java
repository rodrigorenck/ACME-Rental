package aplicacao;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Autor: Rodrigo Rosa Renck
 */
public class AluguelTest {

    /**
     * Testando toString
     */
    @Test
    void deveExibirDataPeriodoCpfNomeValorFinal(){
        Alugavel item = new Alugavel(1, "Raquete", 30.00);
        Aluguel aluguel = new Aluguel(7, "1111111", "Joao", item);
        String resultadoEsperado = "Aluguel{" +
                "data='" + null + '\'' +
                ", periodo=" + 7 + " dias" +
                ", cpf='" + 1111111 + '\'' +
                ", nome='" + "Joao" + '\'' +
                ", valorFinal=" + 210.0 +
                '}';
        assertEquals(resultadoEsperado, aluguel.toString());
    }

    /**
     * Testando adicionaItem
     */
    @Test
    void deveAdicionarUmItemNoAluguelEoItemDeveAdicionarEsseAluguelNaSuaLista(){
        Aluguel aluguel = new Aluguel(7, "1111111", "Joao");
        Alugavel item = new Alugavel(1, "Raquete", 30.00);

        aluguel.adicionarItem(item);

        assertEquals(aluguel.getItem(), item);
        assertEquals(item.getListaAlugueis().get(0), aluguel);
    }

    /**
     * Testamos os 3 cenarios possiveis para o nosso metodo que calcula o valor final
     */
    @Test
    void naoDeveDarDescontoParaPeriodoIgual7Dias() {
        //primeiro vamos criar o cenario
        Alugavel item = new Alugavel(1, "Raquete", 30.00);
        Aluguel aluguel = new Aluguel(7, "1111111", "Joao", item);
        //valor sem desconto
        double valorOriginal = 30*7;
        //calculo do nosso metodo
        double valorFinal = aluguel.calculaValorFinal();
        assertEquals(valorOriginal, valorFinal);
    }

    @Test
    void naoDeveDarDescontoParaPeriodoInferior7Dias() {
        //primeiro vamos criar o cenario
        Alugavel item = new Alugavel(1, "Raquete", 30.00);
        Aluguel aluguel = new Aluguel(6, "1111111", "Joao", item);
        //valor sem desconto
        double valorOriginal = 30*6;
        //calculo do nosso metodo
        double valorFinal = aluguel.calculaValorFinal();
        assertEquals(valorOriginal, valorFinal);
    }

    @Test
    void deveDarDezPorCentoDeDescontoParaPeriodoSuperior7Dias() {
        //primeiro vamos criar o cenario
        Alugavel item = new Alugavel(1, "Raquete", 30.00);
        Aluguel aluguel = new Aluguel(8, "1111111", "Joao", item);
        //valor sem desconto
        double valorOriginal = 30 * 8;
        //calculo do nosso metodo
        double valorFinal = aluguel.calculaValorFinal();
        //o valor que esperamos que seja igual o do metodo
        double valorEsperado = valorOriginal - (valorOriginal * 0.1);
        assertEquals(valorEsperado, valorFinal);
    }

    /**
     * Testando getters e setters
     */
    @Test
    void deveDevolverAData(){
        String data = "10/08/2022";
        Aluguel aluguel = new Aluguel(8, "1111111", "Joao");
        aluguel.setData(data);

        assertEquals(data, aluguel.getData());
    }

    @Test
    void deveSettarData(){
        Aluguel aluguel = new Aluguel("10/08/2022",8, "1111111", "Joao", new Alugavel());
        aluguel.setData("05/02/2023");

        assertEquals("05/02/2023", aluguel.getData());
    }

    @Test
    void deveDevolverPeriodo(){
        int periodo = 8;
        Aluguel aluguel = new Aluguel(periodo, "1111111", "Joao");

        assertEquals(periodo, aluguel.getPeriodo());
    }

    @Test
    void deveSettarPeriodo(){
        int periodo = 8;
        Aluguel aluguel = new Aluguel();
        aluguel.setPeriodo(periodo);

        assertEquals(periodo, aluguel.getPeriodo());
    }

    @Test
    void deveDevolverCpf(){
        String cpf = "1111111";
        Aluguel aluguel = new Aluguel(5, cpf, "Joao");

        assertEquals(cpf, aluguel.getCpf());
    }

    @Test
    void deveSettarCpf(){
        String cpf = "1111111";
        Aluguel aluguel = new Aluguel(5, null, "Joao");
        aluguel.setCpf(cpf);

        assertEquals(cpf, aluguel.getCpf());
    }

    @Test
    void deveDevolverNome(){
        String nome = "Joao";
        Aluguel aluguel = new Aluguel(5, "123", nome);

        assertEquals(nome, aluguel.getNome());
    }

    @Test
    void deveSettarNome(){
        String nome = "Joao";
        Aluguel aluguel = new Aluguel(5, "123", null);
        aluguel.setNome(nome);

        assertEquals(nome, aluguel.getNome());
    }

    @Test
    void deveDevolverValorFinal(){
        Alugavel item = new Alugavel(1, "Raquete", 30.00);
        Aluguel aluguel = new Aluguel(5, "1111111", "Joao", item);
        double valorFinal = 5*30;

        assertEquals(valorFinal, aluguel.getValorFinal());
    }

    //nao tenho o set valor final -> nao faz sentido para a minha aplicacao

    @Test
    void deveDevolverItem(){
        Alugavel item = new Alugavel(1, "Raquete", 30.00);
        Aluguel aluguel = new Aluguel(5, "1111111", "Joao", item);


        assertEquals(item, aluguel.getItem());
    }

    @Test
    void deveSettarItem(){
        Aluguel aluguel = new Aluguel(5, "1111111", "Joao");
        Alugavel item = new Alugavel(1, "Raquete", 30.00);

        aluguel.setItem(item);

        assertEquals(item, aluguel.getItem());
    }
}