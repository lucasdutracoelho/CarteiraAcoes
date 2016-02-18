package br.com.carteira.acoes.Parser;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import br.com.carteira.acoes.Entity.Acao;

/**
 * Created by lucas.coelho.dutra on 16/10/2015.
 */
public class AcoesParser {
    private static final String ns = null;
    private final String START_TAG = "ComportamentoPapeis";
    private final String PAPEL = "Papel";

    /**
     * Método responsável pelo parse do XML no InputStream
     * @param in
     * @return Lista de Acões
     * @throws XmlPullParserException
     * @throws IOException
     */
    public List<Acao> parse(InputStream in) throws XmlPullParserException, IOException {
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in, null);
            parser.nextTag();
            return readFeed(parser);
        } finally {
            in.close();
        }
    }

    /**
     * Método responsável por iniciar a leitura dos ativos
     * @param parser
     * @return Lista de Acões
     * @throws XmlPullParserException
     * @throws IOException
     */
    private List<Acao> readFeed(XmlPullParser parser) throws XmlPullParserException, IOException {
        List<Acao> entries = new ArrayList<Acao>();

        parser.require(XmlPullParser.START_TAG, ns, START_TAG);
        while (parser.next() != XmlPullParser.END_DOCUMENT) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            // Starts by looking for the Papel tag
            if (name.equals(PAPEL)) {
                entries.add(readEntry(parser));
            } else {
                skip(parser);
            }
        }
        return entries;
    }

    /**
     * Método responsável por recuperar cada Acao
     * @param parser
     * @return Acao
     * @throws XmlPullParserException
     * @throws IOException
     */
    private Acao readEntry(XmlPullParser parser) throws XmlPullParserException, IOException {
        return Acao.createAcao(parser);
    }

    /**
     * Método responsável por pular o nó
     * @param parser
     * @throws XmlPullParserException
     * @throws IOException
     */
    private void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0) {
            switch (parser.next()) {
                case XmlPullParser.END_TAG:
                    depth--;
                    break;
                case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
    }
}
