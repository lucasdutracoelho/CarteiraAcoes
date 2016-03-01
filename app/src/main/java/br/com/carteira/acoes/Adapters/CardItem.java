package br.com.carteira.acoes.Adapters;

import java.util.ArrayList;
import java.util.List;

import br.com.carteira.acoes.Entity.Acao;

/**
 * Created by lucas.coelho.dutra on 22/02/2016.
 */
public class CardItem {

    private String m_text1;
    private String m_text2;

    private CardItem(String m_text1, String m_text2) {
        this.m_text1 = m_text1;
        this.m_text2 = m_text2;
    }

    public static CardItem createCardItem(String m_text1, String m_text2) {
        return new CardItem(m_text1, m_text2);
    }

    public static List<CardItem> createListCardItem(List<Acao> listaAcoes) {
        List<CardItem> cardsItem = new ArrayList<CardItem>();
        for (Acao acao: listaAcoes) {
            cardsItem.add(new CardItem(acao.getNome(), acao.getOscilacao()));
        }
        return  cardsItem;
    }

    public String getText1() {
        return m_text1;
    }

    public void setText1(String m_text1) {
        this.m_text1 = m_text1;
    }

    public String getText2() {
        return m_text2;
    }

    public void setText2(String m_text2) {
        this.m_text2 = m_text2;
    }
}
