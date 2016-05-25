package br.com.carteira.acoes.Parser;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.commons.lang3.StringEscapeUtils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;

import br.com.carteira.acoes.Entity.Acao;
import br.com.carteira.acoes.Entity.FactoryAcao;
import br.com.carteira.acoes.Parser.Json.Root;

/**
 * Created by lucas.coelho.dutra on 24/05/2016.
 */
public class AcaoParserYahoo implements Parser<Acao> {
    @Override
    public List<Acao> parse(InputStream in) throws ParserException {
        try {
            Gson gson = new Gson();
            String json = convertStreamToString(in);
            json = StringEscapeUtils.unescapeXml(json);
            Root root = gson.fromJson(json, Root.class);
            return FactoryAcao.createAcao(root);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ParserException(e.getMessage());
        }
    }

    static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
