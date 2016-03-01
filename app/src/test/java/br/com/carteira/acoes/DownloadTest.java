package br.com.carteira.acoes;

import junit.framework.Assert;

import org.junit.Test;

import java.io.InputStream;
import java.lang.String;

import br.com.carteira.acoes.Downloader.Downloader;
import br.com.carteira.acoes.Downloader.DownloaderURL;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class DownloadTest extends BaseTest{

    @Test
    public void DownloadURLValido() throws Exception {
        String url = "http://www.bmfbovespa.com.br/Pregao-Online/ExecutaAcaoAjax.asp?CodigoPapel=ABEV3|BBPO11";
        Downloader downloader = new DownloaderURL();
        InputStream stream = downloader.download(url);
        Assert.assertNotNull(stream);
    }

    @Test
    public void DownloadURLNull() throws Exception {
        String url = null;
        Downloader downloader = new DownloaderURL();
        InputStream stream = downloader.download(url);
        Assert.assertNull(stream);
    }
}