package br.com.carteira.acoes;

import android.content.Context;

/**
 * Created by lucas.coelho.dutra on 16/02/2016.
 */
public class App  extends android.app.Application {

    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        if(instance == null){
            instance = this;
        }
    }

    public static App getInstance() {
        return instance;
    }

    public static Context getContext() {
        return instance.getApplicationContext();
    }

}
