package br.com.carteira.acoes.Parser;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by lucas.dutra.coelho on 26/02/2016.
 */
public interface Parser<T> {
    List<T> parse(InputStream in) throws ParserException;
}
