package test;


import org.junit.jupiter.api.Test;

import aplicacao.model.Alugavel;
import aplicacao.model.Aluguel;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AluguelTest {


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
        double valorOriginal = 30*8;
        //calculo do nosso metodo
        double valorFinal = aluguel.calculaValorFinal();
        //o valor que esperamos que seja igual o do metodo
        double valorEsperado = valorOriginal - (valorOriginal*0.1);
        assertEquals(valorEsperado, valorFinal);
    }
}