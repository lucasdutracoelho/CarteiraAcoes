package br.com.carteira.acoes.Entity;

import java.util.ArrayList;
import java.util.List;

import br.com.carteira.acoes.Parser.Json.Fields;
import br.com.carteira.acoes.Parser.Json.Resource;
import br.com.carteira.acoes.Parser.Json.Root;

/**
 * Created by lucas.coelho.dutra on 24/05/2016.
 */
public class FactoryAcao {

    public static List<Acao> createAcao(Root root){
        List<Acao> acoes = new ArrayList<Acao>();
        for (Resource resource:
             root.getList().getResources()) {
            Fields field = resource.getResource().getFields();
            if(field!=null){
                acoes.add(parseToAcao(field));
            }
        }
        return acoes;
    }

    private static Acao parseToAcao(Fields field){
        Acao acao = new Acao();
        acao.setNome(field.getIssuerName());
        acao.setCodigo(field.getSymbol());
        acao.setOscilacao(field.getChgPercent());
        acao.setUltimo(field.getPrice());
        acao.setMinimo(field.getDayLow());
        acao.setMaximo(field.getDayHigh());
        acao.setData(field.getUtctime());
        return acao;
    }
}
