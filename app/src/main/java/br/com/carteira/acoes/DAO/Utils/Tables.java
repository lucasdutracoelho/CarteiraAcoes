package br.com.carteira.acoes.DAO.Utils;


import br.com.carteira.acoes.Entity.Acao;

/**
 * Created by lucas.coelho.dutra on 29/02/2016.
 */
public enum Tables {

    ACAO(Acao.class);

    Tables(Class tableClass) {
        this.tableClass = tableClass;
    }

    private Class tableClass;

    public Class getTableClass() {
        return tableClass;
    }

    public void setTableClass(Class tableClass) {
        this.tableClass = tableClass;
    }
}
