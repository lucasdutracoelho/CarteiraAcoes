package br.com.carteira.acoes.Parser.Json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by lucas.coelho.dutra on 24/05/2016.
 */
public class Meta {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("start")
    @Expose
    private Integer start;
    @SerializedName("count")
    @Expose
    private Integer count;

    /**
     *
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     *     The start
     */
    public Integer getStart() {
        return start;
    }

    /**
     *
     * @param start
     *     The start
     */
    public void setStart(Integer start) {
        this.start = start;
    }

    /**
     *
     * @return
     *     The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     *
     * @param count
     *     The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }
}
