package br.com.carteira.acoes.Entity;

import android.util.Log;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

import br.com.carteira.acoes.DAO.Utils.Tables;

/**
 * Created by lucas.coelho.dutra on 16/10/2015.
 */
public class Acao implements Entidade{

    @DatabaseField(id = true)
    @SerializedName("symbol")
    private String Codigo;
    @DatabaseField
    @SerializedName("issuer_name")
    private String Nome;
    @DatabaseField
    private String Bovespa;
    @DatabaseField
    @SerializedName("utctime")
    private String Data;
    @DatabaseField
    private String Abertura;
    @DatabaseField
    @SerializedName("day_low")
    private String Minimo;
    @DatabaseField
    @SerializedName("day_high")
    private String Maximo;
    @DatabaseField
    private String Medio;
    @DatabaseField
    private String Ultimo;
    @DatabaseField
    @SerializedName("chg_percent")
    private String Oscilacao;

    protected Acao(){}

    @Override
    public Tables getTableClass() {
        return Tables.ACAO;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getBovespa() {
        return Bovespa;
    }

    public void setBovespa(String bovespa) {
        Bovespa = bovespa;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public String getAbertura() {
        return Abertura;
    }

    public void setAbertura(String abertura) {
        Abertura = abertura;
    }

    public String getMinimo() {
        return Minimo;
    }

    public void setMinimo(String minimo) {
        Minimo = minimo;
    }

    public String getMaximo() {
        return Maximo;
    }

    public void setMaximo(String maximo) {
        Maximo = maximo;
    }

    public String getMedio() {
        return Medio;
    }

    public void setMedio(String medio) {
        Medio = medio;
    }

    public String getUltimo() {
        return Ultimo;
    }

    public void setUltimo(String ultimo) {
        Ultimo = ultimo;
    }

    public String getOscilacao() {
        return Oscilacao;
    }

    public void setOscilacao(String oscilacao) {
        Oscilacao = oscilacao;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Acao{");
        sb.append("Codigo='").append(Codigo).append('\'');
        sb.append(", Nome='").append(Nome).append('\'');
        sb.append(", Bovespa='").append(Bovespa).append('\'');
        sb.append(", Data='").append(Data).append('\'');
        sb.append(", Abertura='").append(Abertura).append('\'');
        sb.append(", Minimo='").append(Minimo).append('\'');
        sb.append(", Maximo='").append(Maximo).append('\'');
        sb.append(", Medio='").append(Medio).append('\'');
        sb.append(", Ultimo='").append(Ultimo).append('\'');
        sb.append(", Oscilacao='").append(Oscilacao).append('\'');
        sb.append('}');
        return sb.toString();
    }


}
