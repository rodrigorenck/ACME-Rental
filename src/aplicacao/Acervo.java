package aplicacao;

import java.util.ArrayList;
import java.util.List;

/**
 * classe catálogo que gerencia o cadastro de itens alugáveis
 * Autor: Rodrigo Rosa Renck
 */
public class Acervo {

    //lista de itensAlugaveis
    private List<Alugavel> listaItens = new ArrayList<>();

    public boolean adicionaAlugavel(Alugavel alugavel) {
        //se a lista esta vazia ele adiciona o item e retorna true
        if (listaItens.isEmpty()) {
            listaItens.add(alugavel);
            return true;
        }
        //se a lista nao esta vazia entao vamos iterar por ela e caso algum item tenha o mesmo codigo do item passado no parametro retornamos false e nao adicionamos o item
        for (Alugavel item :
                listaItens) {
            if(item.getCodigo() == alugavel.getCodigo()){
                return false;
            }
        }
        //se eu passei pelo for entao significa que o codigo eh unico e eu posso adicionar o item na minha lista
        listaItens.add(alugavel);
        return true;
    }

    public Alugavel pesquisaAlugavel(int codigo) {
        for (Alugavel item :
                listaItens) {
            //se o codigo de algum item da lista corresponder com codigo solicitado retorna o item
            if (item.getCodigo() == codigo) return item;
        }
        //se iterarmos por toda nossa lista e nao acharmos um item do codigo desejado retornamos null
        return null;
    }

    public ArrayList<Alugavel> pesquisaAlugavel(String nome) {
        ArrayList<Alugavel> listaNomeSolicitado = new ArrayList<>();
        for (Alugavel item :
                listaItens) {
            //se o item tiver o nome solicitado adicionamos ele na lista
            if(item.getNome().equalsIgnoreCase(nome)) listaNomeSolicitado.add(item);
        }
        //se a lista estiver vazia quer dizer que nenhum item correspondeu com a busca entao retornamos null
        if(listaNomeSolicitado.isEmpty()){
            return null;
        }
        return listaNomeSolicitado;
    }

    /**
     * metodo que devolve a listaItens para a gente imprimir la no ACME Rental
     */
    public List<Alugavel> mostrarTodos() {
        return listaItens;
    }

    /**
     * metodo para verificar se o acervo esta vazio
     */
    public boolean estaVazio() {
        return listaItens.isEmpty();
    }
}
