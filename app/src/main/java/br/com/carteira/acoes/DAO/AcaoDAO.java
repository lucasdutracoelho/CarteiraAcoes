package br.com.carteira.acoes.DAO;

import android.content.Context;

import br.com.carteira.acoes.Entity.Acao;

/**
 * Created by lucas.coelho.dutra on 01/03/2016.
 */
public class AcaoDAO extends BaseDAO<Acao, String> {

    private AcaoDAO instance;

    private AcaoDAO(Context context) {
        super(Acao.class, context);
    }

    public AcaoDAO getInstance(Context context){
        if(instance == null){
            instance = new AcaoDAO(context);
        }
        return instance;
    }
}
