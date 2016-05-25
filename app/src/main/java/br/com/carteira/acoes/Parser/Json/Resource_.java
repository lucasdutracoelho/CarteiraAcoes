package br.com.carteira.acoes.Parser.Json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by lucas.coelho.dutra on 24/05/2016.
 */
public class Resource_ {
    @SerializedName("classname")
    @Expose
    private String classname;
    @SerializedName("fields")
    @Expose
    private Fields fields;

    /**
     *
     * @return
     *     The classname
     */
    public String getClassname() {
        return classname;
    }

    /**
     *
     * @param classname
     *     The classname
     */
    public void setClassname(String classname) {
        this.classname = classname;
    }

    /**
     *
     * @return
     *     The fields
     */
    public Fields getFields() {
        return fields;
    }

    /**
     *
     * @param fields
     *     The fields
     */
    public void setFields(Fields fields) {
        this.fields = fields;
    }
}
