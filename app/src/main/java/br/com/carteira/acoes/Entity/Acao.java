package br.com.carteira.acoes.Entity;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by lucas.coelho.dutra on 16/10/2015.
 */
public class Acao {

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

    private String Codigo;
    private String Nome;
    private String Bovespa;
    private String Data;
    private String Abertura;
    private String Minimo;
    private String Maximo;
    private String Medio;
    private String Ultimo;
    private String Oscilacao;

    private Acao() {
    }

    public static Acao createAcao() {
        return new Acao();
    }

    public static Acao createAcao(XmlPullParser parser) {
        Acao acao = Acao.createAcao();
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

    private void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public String getNome() {
        return Nome;
    }

    private void setNome(String nome) {
        Nome = nome;
    }

    public String getBovespa() {
        return Bovespa;
    }

    private void setBovespa(String bovespa) {
        Bovespa = bovespa;
    }

    public String getData() {
        return Data;
    }

    private void setData(String data) {
        Data = data;
    }

    public String getAbertura() {
        return Abertura;
    }

    private void setAbertura(String abertura) {
        Abertura = abertura;
    }

    public String getMinimo() {
        return Minimo;
    }

    private void setMinimo(String minimo) {
        Minimo = minimo;
    }

    public String getMaximo() {
        return Maximo;
    }

    private void setMaximo(String maximo) {
        Maximo = maximo;
    }

    public String getMedio() {
        return Medio;
    }

    private void setMedio(String medio) {
        Medio = medio;
    }

    public String getUltimo() {
        return Ultimo;
    }

    private void setUltimo(String ultimo) {
        Ultimo = ultimo;
    }

    public String getOscilacao() {
        return Oscilacao;
    }

    private void setOscilacao(String oscilacao) {
        Oscilacao = oscilacao;
    }
}
