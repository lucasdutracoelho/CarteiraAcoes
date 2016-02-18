package br.com.carteira.acoes.Downloader;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by lucas.coelho.dutra on 18/02/2016.
 */
public class DownloaderURL implements Downloader {
    @Override
    public InputStream download(String url) throws IOException {
        if(url == null) return null;
        URL endereco = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) endereco.openConnection();
        conn.setReadTimeout(10000 /* milliseconds */);
        conn.setConnectTimeout(15000 /* milliseconds */);
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        // Starts the query
        conn.connect();
        InputStream stream = conn.getInputStream();
        return stream;
    }
}
