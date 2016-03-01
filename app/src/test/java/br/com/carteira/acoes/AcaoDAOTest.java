package br.com.carteira.acoes;

import android.content.Context;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import br.com.carteira.acoes.DAO.AcaoDAO;
import br.com.carteira.acoes.Entity.Acao;

/**
 * Created by lucas.coelho.dutra on 01/03/2016.
 */
@Config(constants = BuildConfig.class, sdk = 21)
@RunWith(RobolectricGradleTestRunner.class)
public class AcaoDAOTest extends BaseTest {
    private Context context;
    AcaoDAO dao;

    @Before
    public void setup() {
        context = Robolectric.setupActivity(MainActivity.class).getApplicationContext();
        dao = (AcaoDAO)configureDao(AcaoDAO.class, context);
    }

    @Test
    public void valida_Contexto_NotNull(){
        Assert.assertNotNull(context);
    }

    @Test
    public void valida_AcaoDAO_NotNull(){
        Assert.assertNotNull(dao);
    }

    @Test
    public void insere_Acao(){
        Acao acao = (Acao)returnInstance(Acao.class, null);
        acao.setCodigo("ABEV3");
        acao.setAbertura("1");
        acao.setBovespa("1");
        acao.setData("01/03/2016");
        acao.setMaximo("1");
        acao.setMedio("1");
        acao.setMinimo("1");
        acao.setNome("Ambev");
        acao.setOscilacao("1");
        acao.setUltimo("1");
        Acao acaoSalvo = dao.save(acao);

        Assert.assertNotNull(acaoSalvo);
    }

    @Test
    public void lista_Acao() {
        Acao acao = (Acao)returnInstance(Acao.class, null);
        acao.setCodigo("ABEV3");
        acao.setAbertura("1");
        acao.setBovespa("1");
        acao.setData("01/03/2016");
        acao.setMaximo("1");
        acao.setMedio("1");
        acao.setMinimo("1");
        acao.setNome("Ambev");
        acao.setOscilacao("1");
        acao.setUltimo("1");
        Acao acaoSalvo = dao.save(acao);

        Assert.assertTrue(dao.findAll().size() > 0);

    }

    @Test
    public void consulta_Acao() {
        Acao acao = (Acao)returnInstance(Acao.class, null);
        acao.setCodigo("ABEV3");
        acao.setAbertura("1");
        acao.setBovespa("1");
        acao.setData("01/03/2016");
        acao.setMaximo("1");
        acao.setMedio("1");
        acao.setMinimo("1");
        acao.setNome("Ambev");
        acao.setOscilacao("1");
        acao.setUltimo("1");
        dao.save(acao);

        Acao acaoSalva = dao.findById(acao.getCodigo());

        Assert.assertTrue(acao.getCodigo().equals(acaoSalva.getCodigo()));

    }
}
