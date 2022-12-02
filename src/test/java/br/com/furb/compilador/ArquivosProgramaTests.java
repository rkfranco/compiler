package br.com.furb.compilador;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArquivosProgramaTests {

    @Test
    public void deveObterInformacoesArquivoCodigoFonte() {
        ArquivosPrograma arquivosPrograma = new ArquivosPrograma("arquivo-test", "C:\\Furb\\Compiladores");

        String nomeArquivoCodigoFonte = arquivosPrograma.getNomeArquivoCodigoFonte();
        String pathArquivoCodigoFonte = arquivosPrograma.getPathArquivoCodigoFonte();

        assertEquals("arquivo-test.txt", nomeArquivoCodigoFonte);
        assertEquals("C:\\Furb\\Compiladores\\arquivo-test.txt", pathArquivoCodigoFonte);
    }

    @Test
    public void deveObterInformacoesArquivoCodigoObjeto() {
        ArquivosPrograma arquivosPrograma = new ArquivosPrograma("arquivo-test", "C:\\Furb\\Compiladores");

        String nomeArquivoCodigoObjeto = arquivosPrograma.getNomeArquivoCodigoObjeto();
        String pathArquivoCodigoObjeto = arquivosPrograma.getPathArquivoCodigoObjeto();

        assertEquals("arquivo-test.il", nomeArquivoCodigoObjeto);
        assertEquals("C:\\Furb\\Compiladores\\arquivo-test.il", pathArquivoCodigoObjeto);
    }
}
