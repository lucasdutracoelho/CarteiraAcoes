package br.com.carteira.acoes.Entity;

import java.io.Serializable;

import br.com.carteira.acoes.DAO.Utils.Tables;

/**
 * Created by lucas.coelho.dutra on 01/03/2016.
 */
public interface Entidade  extends Serializable {

    Tables getTableClass();
}
