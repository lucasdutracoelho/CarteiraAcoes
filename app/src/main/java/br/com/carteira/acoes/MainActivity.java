package br.com.carteira.acoes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.carteira.acoes.Adapters.BaseInflaterAdapter;
import br.com.carteira.acoes.Adapters.CardItem;
import br.com.carteira.acoes.Adapters.Inflater.CardInflater;
import br.com.carteira.acoes.AsyncTask.DownloadTask;
import br.com.carteira.acoes.Downloader.DownloaderURL;
import br.com.carteira.acoes.Entity.Acao;
import br.com.carteira.acoes.Helper.ConexaoUtils;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";

    @Bind(R.id.toolbar) public Toolbar toolbar;
    @Bind(R.id.fab) public FloatingActionButton fab;
    @Bind((R.id.card_listView))ListView cardList;
    private BaseInflaterAdapter<CardItem> adapter;
    //Constante utilizada para teste
    protected String CONSTANTE_TESTE = "NOK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        cardList.addHeaderView(new View(this));
        cardList.addFooterView(new View(this));

        adapter = new BaseInflaterAdapter<CardItem>(new CardInflater());
        cardList.setAdapter(adapter);

    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    public void onEvent(List<Acao> acoes) {

        CONSTANTE_TESTE = "OK";
        adapter.clear(false);
        adapter.addItems(CardItem.createListCardItem(acoes), true);


    }

    @OnClick(R.id.fab)
    public void onClickFloatingAction(View view){
        Log.i(TAG, "onClickFloatingAction");
        /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();*/

        if(ConexaoUtils.verificaConexao()){
            new DownloadTask(this, new DownloaderURL()).execute("http://finance.yahoo.com/webservice/v1/symbols/PETR4.SA,BBAS3.SA/quote?format=json&view=detail");
        }else {
            Toast.makeText(this, "Sem conexão!", Toast.LENGTH_SHORT).show();
        }


        Log.i(TAG, "SUCESSO");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
