package br.com.carteira.acoes.Helper;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import br.com.carteira.acoes.App;

/**
 * Created by lucas.coelho.dutra on 16/02/2016.
 */
public class ConexaoUtils {
    private static final String TAG = "ConexaoUtils";

    public static boolean verificaConexao(){
        try {
            ConnectivityManager connMgr =
                    (ConnectivityManager)  App.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

            return networkInfo != null
                    && networkInfo.isAvailable()
                    && networkInfo.isConnected();
        }catch (Exception e){
            Log.i(TAG, e.getMessage());
            return false;
        }
    }
}
