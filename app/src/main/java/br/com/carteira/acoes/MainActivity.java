package br.com.carteira.acoes;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import br.com.carteira.acoes.AsyncTask.DownloadXmlTask;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
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

        for (Acao item:acoes) {

            Log.i(TAG, item.getNome());
            Toast.makeText(this, item.getNome(), Toast.LENGTH_SHORT).show();

        }
    }

    @OnClick(R.id.fab)
    public void onClickFloatingAction(View view){
        Log.i(TAG, "onClickFloatingAction");
        /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();*/

        if(ConexaoUtils.VerificaConexao()){
            new DownloadXmlTask(this).execute("http://www.bmfbovespa.com.br/Pregao-Online/ExecutaAcaoAjax.asp?CodigoPapel=ABEV3|BBPO11");
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
