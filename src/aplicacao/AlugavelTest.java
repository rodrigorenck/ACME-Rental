package aplicacao;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Autor: Rodrigo Rosa Renck
 */
public class AlugavelTest {

    @Test
    void deveExibirCodigoNomePrecoDiarioEsporteMarcaAlugueis(){
        Alugavel item = new Alugavel(1, "Raquete", 30.00, "Tenis", "Wilson");
        Aluguel aluguel = new Aluguel(7, "1111111", "Joao", item);
        String resultadoEsperado = "Alugavel{" +
                "codigo=" + 1 +
                ", nome='" + "Raquete" + '\'' +
                ", precoDiario=" + 30.00 +
                ", esporte='" + "Tenis" + '\'' +
                ", marca='" + "Wilson" + '\'' +
                ", listaAlugueis=" + item.getListaAlugueis() +
                '}';
        assertEquals(resultadoEsperado, item.toString());
    }

    @Test
    void adicionaAluguel() {
        Alugavel item = new Alugavel(1, "Raquete", 30.00, "Tenis", "Wilson");
        Aluguel aluguel = new Aluguel(7, "1111111", "Joao");
        item.adicionaAluguel(aluguel);

        assertEquals(item.getListaAlugueis().get(0), aluguel);
    }

    @Test
    void getListaAlugueis() {
        Alugavel item = new Alugavel(1, "Raquete", 30.00, "Tenis", "Wilson");
        Aluguel aluguel = new Aluguel(7, "1111111", "Joao", item);
        Aluguel alugue2 = new Aluguel(10, "1234567", "Marcio", item);
        List<Aluguel> resultadoEsperado = new ArrayList<>(Arrays.asList(aluguel, alugue2));

        assertEquals(resultadoEsperado, item.getListaAlugueis());
    }

    @Test
    void getCodigo() {
        int codigo = 1;
        Alugavel item = new Alugavel(codigo, "Raquete", 30.00);

        assertEquals(1, item.getCodigo());
    }

    @Test
    void setCodigo() {
        Alugavel item = new Alugavel(1, "Raquete", 30.00, "Tenis", "Wilson");
        item.setCodigo(100);

        assertEquals(100, item.getCodigo());
    }

    @Test
    void getNome() {
        Alugavel item = new Alugavel(1, "Raquete", 30.00, "Tenis", "Wilson");

        assertEquals("Raquete", item.getNome());
    }

    @Test
    void setNome() {
        Alugavel item = new Alugavel(1, "Raquete", 30.00, "Tenis", "Wilson");
        item.setNome("Chuteira");

        assertEquals("Chuteira", item.getNome());
    }

    @Test
    void getPrecoDiario() {
        Alugavel item = new Alugavel(1, "Raquete", 30.00, "Tenis", "Wilson");

        assertEquals(30.00, item.getPrecoDiario());
    }

    @Test
    void setPrecoDiario() {
        Alugavel item = new Alugavel();
        item.setPrecoDiario(100);

        assertEquals(100, item.getPrecoDiario());
    }

    @Test
    void getEsporte() {
        Alugavel item = new Alugavel(1, "Raquete", 30.00, "Tenis", "Wilson");

        assertEquals("Tenis", item.getEsporte());
    }

    @Test
    void setEsporte() {
        Alugavel item = new Alugavel(1, "Raquete", 30.00, "Tenis", "Wilson");
        item.setEsporte("Ping pong");

        assertEquals("Ping pong", item.getEsporte());
    }

    @Test
    void getMarca() {
        Alugavel item = new Alugavel(1, "Raquete", 30.00, "Tenis", "Wilson");

        assertEquals("Wilson", item.getMarca());
    }

    @Test
    void setMarca() {
        Alugavel item = new Alugavel(1, "Raquete", 30.00, "Tenis", "Wilson");
        item.setMarca("Adidas");

        assertEquals("Adidas", item.getMarca());
    }
}