package br.com.carteira.acoes.Entity;

import android.util.Log;

import com.j256.ormlite.field.DatabaseField;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

import br.com.carteira.acoes.DAO.Utils.Tables;

/**
 * Created by lucas.coelho.dutra on 16/10/2015.
 */
public class Acao implements Entidade{

    private static final String TAG = "Acao";

    private static final String CODIGO = "Codigo";
    private static final String NOME = "Nome";
    private static final String IBOVESPA = "Ibovespa";
    private static final String DATA = "Data";
    private static final String ABERTURA = "Abertura";
    private static final String MINIMO = "Minimo";
    private static final String MAXIMO = "Maximo";
    private static final String MEDIO = "Medio";
    private static final String ULTIMO = "Ultimo";
    private static final String OSCILACAO = "Oscilacao";
    private static final String START_TAG = "ComportamentoPapeis";
    private static final String PAPEL = "Papel";
    private static final String ns = null;

    @DatabaseField(id = true)
    private String Codigo;
    @DatabaseField
    private String Nome;
    @DatabaseField
    private String Bovespa;
    @DatabaseField
    private String Data;
    @DatabaseField
    private String Abertura;
    @DatabaseField
    private String Minimo;
    @DatabaseField
    private String Maximo;
    @DatabaseField
    private String Medio;
    @DatabaseField
    private String Ultimo;
    @DatabaseField
    private String Oscilacao;

    private Acao() {
    }

    @Override
    public Tables getTableClass() {
        return Tables.ACAO;
    }

    /**
     * Método responsável por criar uma acao atraves do XmlPullParser
     * @param parser
     * @return Acao
     * @throws Exception
     */
    public static Acao createAcao(XmlPullParser parser) {
        Acao acao = new Acao();
        try{
            parser.require(XmlPullParser.START_TAG, ns, PAPEL);
            acao.setCodigo(readCampo(parser, CODIGO));
            acao.setNome(readCampo(parser, NOME));
            acao.setBovespa(readCampo(parser, IBOVESPA));
            acao.setData(readCampo(parser, DATA));
            acao.setAbertura(readCampo(parser, ABERTURA));
            acao.setMinimo(readCampo(parser, MINIMO));
            acao.setMaximo(readCampo(parser, MAXIMO));
            acao.setMedio(readCampo(parser, MEDIO));
            acao.setUltimo(readCampo(parser, ULTIMO));
            acao.setOscilacao(readCampo(parser, OSCILACAO));
        }catch (Exception e){
            Log.i(TAG, e.getMessage());
        }
        return acao;
    }

    /**
     * Método responsável por recuperar o valor do campo
     * @param parser
     * @param campo
     * @return Valor do campo
     * @throws IOException
     * @throws XmlPullParserException
     */
    private static String readCampo(XmlPullParser parser, String campo) throws IOException, XmlPullParserException {
        return parser.getAttributeValue(null, campo);
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
