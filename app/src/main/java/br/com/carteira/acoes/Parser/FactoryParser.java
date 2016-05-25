package br.com.carteira.acoes.Parser;

/**
 * Created by lucas.dutra.coelho on 26/02/2016.
 */
public class FactoryParser {

    public enum TipoParser{
        AcaoParserYahoo;
    }

    public static Parser getParser(TipoParser parser) throws ParserException {

        switch (parser){
            case AcaoParserYahoo:
                return new AcaoParserYahoo();
        }
        throw new ParserException("Não foi possível localizar uma implementação para o Parser");
    }
}
