package br.com.carteira.acoes.Downloader;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lucas.coelho.dutra on 18/02/2016.
 */
public interface Downloader {

    InputStream download(String url) throws IOException;
}
