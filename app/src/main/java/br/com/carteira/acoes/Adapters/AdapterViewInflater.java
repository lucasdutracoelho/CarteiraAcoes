package br.com.carteira.acoes.Adapters;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lucas.coelho.dutra on 22/02/2016.
 */
public interface AdapterViewInflater<T> {

    public View inflate(BaseInflaterAdapter<T> adapter, int pos, View convertView, ViewGroup parent);

}
