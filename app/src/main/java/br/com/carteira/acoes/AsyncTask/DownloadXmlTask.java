package br.com.carteira.acoes.AsyncTask;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.List;

import br.com.carteira.acoes.Entity.Acao;
import br.com.carteira.acoes.Parser.AcoesParser;
import br.com.carteira.acoes.R;
import de.greenrobot.event.EventBus;

/**
 * Created by lucas.coelho.dutra on 16/10/2015.
 */
public class DownloadXmlTask extends AsyncTask<String, Void, List<Acao>> {

    private final String TAG = "DownloadXmlTask";
    private Context mContext;
    public DownloadXmlTask (Context context){
        mContext = context;
    }
    @Override
    protected List<Acao> doInBackground(String... urls) {
        try {
            return loadXmlFromNetwork(urls[0]);
        } catch (IOException e) {
            return null;
        } catch (XmlPullParserException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(List<Acao> result) {

        EventBus.getDefault().post(result);
    }

    // Uploads XML from stackoverflow.com, parses it, and combines it with
    // HTML markup. Returns HTML string.
    private List<Acao> loadXmlFromNetwork(String urlString) throws XmlPullParserException, IOException {
        InputStream stream = null;
        AcoesParser acaoXmlParser = new AcoesParser();
        List<Acao> entries = null;
        String title = null;
        String url = null;
        String summary = null;


        try {
            stream = downloadUrl(urlString);
            entries = acaoXmlParser.parse(stream);
            // Makes sure that the InputStream is closed after the app is
            // finished using it.
        } finally {
            if (stream != null) {
                stream.close();
            }
        }

        // StackOverflowXmlParser returns a List (called "entries") of Entry objects.
        // Each Entry object represents a single post in the XML feed.
        // This section processes the entries list to combine each entry with HTML markup.
        // Each entry is displayed in the UI as a link that optionally includes
        // a text summary.
        for (Acao entry : entries) {
            Log.i(TAG, entry.getCodigo());
        }
        return entries;
    }

    // Given a string representation of a URL, sets up a connection and gets
    // an input stream.
    private InputStream downloadUrl(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000 /* milliseconds */);
        conn.setConnectTimeout(15000 /* milliseconds */);
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        // Starts the query
        conn.connect();
        InputStream stream = conn.getInputStream();
        //String xml =  convertStreamToString(stream);
        return stream;
    }

    private String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
