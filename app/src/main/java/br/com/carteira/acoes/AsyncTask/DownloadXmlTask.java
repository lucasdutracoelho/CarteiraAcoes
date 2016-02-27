package br.com.carteira.acoes.AsyncTask;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import br.com.carteira.acoes.Downloader.Downloader;
import br.com.carteira.acoes.Entity.Acao;
import br.com.carteira.acoes.Parser.AcoesParser;
import br.com.carteira.acoes.Parser.FactoryParser;
import br.com.carteira.acoes.Parser.Parser;
import br.com.carteira.acoes.Parser.ParserException;
import de.greenrobot.event.EventBus;

/**
 * Created by lucas.coelho.dutra on 16/10/2015.
 */
public class DownloadXmlTask extends AsyncTask<String, Void, List<Acao>> {

    private final String TAG = "DownloadXmlTask";
    private Context mContext;
    private Downloader mDownloader;
    public DownloadXmlTask (Context context, Downloader downloader){
        mContext = context;
        mDownloader = downloader;
    }
    @Override
    protected List<Acao> doInBackground(String... urls) {
        try {
            return loadXmlFromNetwork(urls[0]);
        } catch (IOException e) {
            Log.i(TAG, e.getMessage());
            return null;
        }catch (ParserException re){
            Log.i(TAG, re.getMessage());
            return null;
        }
    }

    @Override
    protected void onPostExecute(List<Acao> result) {
        EventBus.getDefault().post(result);
    }

    private List<Acao> loadXmlFromNetwork(String urlString) throws ParserException, IOException {
        InputStream stream = null;
        Parser acaoXmlParser = FactoryParser.getParser(FactoryParser.TipoParser.AcoesParse);
        List<Acao> entries = null;
        try {
            stream = mDownloader.download(urlString);
            entries = acaoXmlParser.parse(stream);
            // Makes sure that the InputStream is closed after the app is
            // finished using it.
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
        return entries;
    }
}
