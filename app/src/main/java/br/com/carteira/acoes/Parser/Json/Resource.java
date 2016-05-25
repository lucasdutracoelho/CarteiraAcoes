package br.com.carteira.acoes.Parser.Json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by lucas.coelho.dutra on 24/05/2016.
 */
public class Resource {

    @SerializedName("resource")
    @Expose
    private Resource_ resource;

    /**
     *
     * @return
     *     The resource
     */
    public Resource_ getResource() {
        return resource;
    }

    /**
     *
     * @param resource
     *     The resource
     */
    public void setResource(Resource_ resource) {
        this.resource = resource;
    }
}
