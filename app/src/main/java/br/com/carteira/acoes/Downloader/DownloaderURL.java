package br.com.carteira.acoes.Downloader;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lucas.coelho.dutra on 18/02/2016.
 */
public class DownloaderURL implements Downloader {
    private OkHttpClient client = new OkHttpClient();

    public InputStream download(String url) throws IOException {
        if(url == null) return null;
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().byteStream();
    }
}
