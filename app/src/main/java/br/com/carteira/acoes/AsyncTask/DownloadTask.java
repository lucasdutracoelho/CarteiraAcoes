package br.com.carteira.acoes.AsyncTask;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import br.com.carteira.acoes.Downloader.Downloader;
import br.com.carteira.acoes.Entity.Acao;
import br.com.carteira.acoes.Parser.FactoryParser;
import br.com.carteira.acoes.Parser.Parser;
import br.com.carteira.acoes.Parser.ParserException;
import de.greenrobot.event.EventBus;

/**
 * Created by lucas.coelho.dutra on 16/10/2015.
 */
public class DownloadTask extends AsyncTask<String, Void, List<Acao>> {

    private final String TAG = "DownloadTask";
    private Context mContext;
    private Downloader mDownloader;
    public DownloadTask(Context context, Downloader downloader){
        mContext = context;
        mDownloader = downloader;
    }
    @Override
    protected List<Acao> doInBackground(String... urls) {
        try {
            return loadFromNetwork(urls[0]);
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

    private List<Acao> loadFromNetwork(String urlString) throws ParserException, IOException {
        InputStream stream = null;
        Parser acaoParser = FactoryParser.getParser(FactoryParser.TipoParser.AcaoParserYahoo);
        List<Acao> entries = null;
        try {
            stream = mDownloader.download(urlString);
            entries = acaoParser.parse(stream);
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
        return entries;
    }
}
