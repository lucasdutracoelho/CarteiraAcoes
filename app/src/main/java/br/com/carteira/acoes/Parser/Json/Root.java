package br.com.carteira.acoes.Parser.Json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by lucas.coelho.dutra on 24/05/2016.
 */
public class Root {
    @SerializedName("list")
    @Expose
    private List list;

    /**
     *
     * @return
     *     The list
     */
    public List getList() {
        return list;
    }

    /**
     *
     * @param list
     *     The list
     */
    public void setList(List list) {
        this.list = list;
    }
}
