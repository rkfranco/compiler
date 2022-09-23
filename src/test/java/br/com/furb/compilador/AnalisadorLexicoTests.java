package br.com.furb.compilador;

import org.fxmisc.richtext.CaretSelectionBind;
import org.fxmisc.richtext.CodeArea;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AnalisadorLexicoTests {

    private final String quebraLinha = System.lineSeparator();

    @Mock
    CodeArea codeArea;

    @Mock
    CaretSelectionBind caretSelectionBind;

    AnalisadorLexico analisadorLexico;

    @BeforeEach
    void setUp() {
        this.analisadorLexico = new AnalisadorLexico();
    }

    private void Entrada(String entrada) {
        when(this.codeArea.getText()).thenReturn(entrada);
        when(this.codeArea.getCaretSelectionBind()).thenReturn(this.caretSelectionBind);
        when(this.caretSelectionBind.getParagraphIndex()).thenReturn(0);
    }

    @Test
    public void deveAnalisarEExibirCabecalhoERodapeCorretamente() {
        Entrada("test1\ntest2");

        String saida = this.analisadorLexico.analisar(this.codeArea);
        String[] linhas = saida.split(this.quebraLinha);

        assertEquals("linha     classe                        lexema", linhas[0]);
        assertEquals("1         identificador                 test1", linhas[1]);
        assertEquals("1         identificador                 test2", linhas[2]);
        assertEquals("programa compilado com sucesso", linhas[4]);
    }

    @Test
    public void deveAnalisarIdentificador() {
        Entrada("a\nA\na_a\na_A\na_1\na_a_aa\na_1_a\na_1_A");

        String saida = this.analisadorLexico.analisar(this.codeArea);
        String[] linhas = saida.split(this.quebraLinha);

        assertEquals("1         identificador                 a", linhas[1]);
        assertEquals("1         identificador                 A", linhas[2]);
        assertEquals("1         identificador                 a_a", linhas[3]);
        assertEquals("1         identificador                 a_A", linhas[4]);
        assertEquals("1         identificador                 a_1", linhas[5]);
        assertEquals("1         identificador                 a_a_aa", linhas[6]);
        assertEquals("1         identificador                 a_1_a", linhas[7]);
        assertEquals("1         identificador                 a_1_A", linhas[8]);
    }

    @Test
    public void deveAnalisarConstanteInt() {
        Entrada("1\n12\n123\n1d1\n2d9\n12d21\n102d210");

        String saida = this.analisadorLexico.analisar(this.codeArea);
        String[] linhas = saida.split(this.quebraLinha);

        assertEquals("1         constante int                 1", linhas[1]);
        assertEquals("1         constante int                 12", linhas[2]);
        assertEquals("1         constante int                 123", linhas[3]);
        assertEquals("1         constante int                 1d1", linhas[4]);
        assertEquals("1         constante int                 2d9", linhas[5]);
        assertEquals("1         constante int                 12d21", linhas[6]);
        assertEquals("1         constante int                 102d210", linhas[7]);
    }

    @Test
    public void deveAnalisarConstanteFloat() {
        Entrada(".1\n.1289\n.1d1\n.901d109\n1.8d9\n56.8d9");

        String saida = this.analisadorLexico.analisar(this.codeArea);
        String[] linhas = saida.split(this.quebraLinha);

        assertEquals("1         constante float               .1", linhas[1]);
        assertEquals("1         constante float               .1289", linhas[2]);
        assertEquals("1         constante float               .1d1", linhas[3]);
        assertEquals("1         constante float               .901d109", linhas[4]);
        assertEquals("1         constante float               1.8d9", linhas[5]);
        assertEquals("1         constante float               56.8d9", linhas[6]);
    }

    @Test
    public void deveAnalisarConstanteChar() {
        Entrada("\\n\\s\\t");

        String saida = this.analisadorLexico.analisar(this.codeArea);
        String[] linhas = saida.split(this.quebraLinha);

        assertEquals("1         constante char                \\n", linhas[1]);
        assertEquals("1         constante char                \\s", linhas[2]);
        assertEquals("1         constante char                \\t", linhas[3]);
    }

    @Test
    public void deveAnalisarConstanteString() {
        Entrada("\"test\"\n\"12345\"\n\"test123\"");

        String saida = this.analisadorLexico.analisar(this.codeArea);
        String[] linhas = saida.split(this.quebraLinha);

        assertEquals("1         constante string              \"test\"", linhas[1]);
        assertEquals("1         constante string              \"12345\"", linhas[2]);
        assertEquals("1         constante string              \"test123\"", linhas[3]);
    }

    @Test
    public void deveAnalisarPalavraReservada() {
        Entrada("boolean\nbreak\nchar\ndo\nelse\nend\nfalse\nfloat\nfun\nif\nint\nmain\nprint\nprintln\nreadln\nstring\ntrue\nval\nvar\nwhile\n");

        String saida = this.analisadorLexico.analisar(this.codeArea);
        String[] linhas = saida.split(this.quebraLinha);

        assertEquals("1         palavra reservada             boolean", linhas[1]);
        assertEquals("1         palavra reservada             break", linhas[2]);
        assertEquals("1         palavra reservada             char", linhas[3]);
        assertEquals("1         palavra reservada             do", linhas[4]);
        assertEquals("1         palavra reservada             else", linhas[5]);
        assertEquals("1         palavra reservada             end", linhas[6]);
        assertEquals("1         palavra reservada             false", linhas[7]);
        assertEquals("1         palavra reservada             float", linhas[8]);
        assertEquals("1         palavra reservada             fun", linhas[9]);
        assertEquals("1         palavra reservada             if", linhas[10]);
        assertEquals("1         palavra reservada             int", linhas[11]);
        assertEquals("1         palavra reservada             main", linhas[12]);
        assertEquals("1         palavra reservada             print", linhas[13]);
        assertEquals("1         palavra reservada             println", linhas[14]);
        assertEquals("1         palavra reservada             readln", linhas[15]);
        assertEquals("1         palavra reservada             string", linhas[16]);
        assertEquals("1         palavra reservada             true", linhas[17]);
        assertEquals("1         palavra reservada             val", linhas[18]);
        assertEquals("1         palavra reservada             var", linhas[19]);
        assertEquals("1         palavra reservada             while", linhas[20]);
    }

    @Test
    public void deveAnalisarSimboloEspecial() {
        Entrada(":\n,\n;\n=\n)\n(\n{\n}\n==\n<\n>\n+\n-\n*\n/\n%\n!=\n&&\n||\n!\n++\n--\n");

        String saida = this.analisadorLexico.analisar(this.codeArea);
        String[] linhas = saida.split(this.quebraLinha);

        assertEquals("1         símbolo especial              :", linhas[1]);
        assertEquals("1         símbolo especial              ,", linhas[2]);
        assertEquals("1         símbolo especial              ;", linhas[3]);
        assertEquals("1         símbolo especial              =", linhas[4]);
        assertEquals("1         símbolo especial              )", linhas[5]);
        assertEquals("1         símbolo especial              (", linhas[6]);
        assertEquals("1         símbolo especial              {", linhas[7]);
        assertEquals("1         símbolo especial              }", linhas[8]);
        assertEquals("1         símbolo especial              ==", linhas[9]);
        assertEquals("1         símbolo especial              <", linhas[10]);
        assertEquals("1         símbolo especial              >", linhas[11]);
        assertEquals("1         símbolo especial              +", linhas[12]);
        assertEquals("1         símbolo especial              -", linhas[13]);
        assertEquals("1         símbolo especial              *", linhas[14]);
        assertEquals("1         símbolo especial              /", linhas[15]);
        assertEquals("1         símbolo especial              %", linhas[16]);
        assertEquals("1         símbolo especial              !=", linhas[17]);
        assertEquals("1         símbolo especial              &&", linhas[18]);
        assertEquals("1         símbolo especial              ||", linhas[19]);
        assertEquals("1         símbolo especial              !", linhas[20]);
        assertEquals("1         símbolo especial              ++", linhas[21]);
        assertEquals("1         símbolo especial              --", linhas[22]);
    }

    @Test
    public void deveAnalisarComentariosDeLinhaEIgnorar() {
        Entrada("test#comentario de linha aaa bbb 123\n123");

        String saida = this.analisadorLexico.analisar(this.codeArea);
        String[] linhas = saida.split(this.quebraLinha);

        assertEquals("1         identificador                 test", linhas[1]);
        assertEquals("1         constante int                 123", linhas[2]);
    }

    @Test
    public void deveAnalisarComentariosDeBlocoEIgnorar() {
        Entrada("test[\ncomentario de bloco\n]123");

        String saida = this.analisadorLexico.analisar(this.codeArea);
        String[] linhas = saida.split(this.quebraLinha);

        assertEquals("1         identificador                 test", linhas[1]);
        assertEquals("1         constante int                 123", linhas[2]);
    }

    @Test
    public void deveExibirErroAoAnalisarConstanteChar() {
        Entrada("\\r");
        String saida = this.analisadorLexico.analisar(this.codeArea);
        String[] linhas = saida.split(this.quebraLinha);
        assertEquals("Erro na linha 1 - constante char inválida", linhas[0]);

        Entrada("\\u");
        saida = this.analisadorLexico.analisar(this.codeArea);
        linhas = saida.split(this.quebraLinha);
        assertEquals("Erro na linha 1 - constante char inválida", linhas[0]);

        Entrada("\\w");
        saida = this.analisadorLexico.analisar(this.codeArea);
        linhas = saida.split(this.quebraLinha);
        assertEquals("Erro na linha 1 - constante char inválida", linhas[0]);
    }

    @Test
    public void deveExibirErroAoAnalisarConstanteString() {
        Entrada("\"te\nst\"");
        String saida = this.analisadorLexico.analisar(this.codeArea);
        String[] linhas = saida.split(this.quebraLinha);
        assertEquals("Erro na linha 1 - constante string inválida ou não finalizada", linhas[0]);

        Entrada("\"123\\45\"");
        saida = this.analisadorLexico.analisar(this.codeArea);
        linhas = saida.split(this.quebraLinha);
        assertEquals("Erro na linha 1 - constante string inválida ou não finalizada", linhas[0]);

        Entrada("\"tes\\t123\"");
        saida = this.analisadorLexico.analisar(this.codeArea);
        linhas = saida.split(this.quebraLinha);
        assertEquals("Erro na linha 1 - constante string inválida ou não finalizada", linhas[0]);
    }

    @Test
    public void deveExibirErroAoAnalisarSimboloInvalido() {
        Entrada("@");
        String saida = this.analisadorLexico.analisar(this.codeArea);
        String[] linhas = saida.split(this.quebraLinha);
        assertEquals("Erro na linha 1 - @ símbolo inválido", linhas[0]);

        Entrada("$");
        saida = this.analisadorLexico.analisar(this.codeArea);
        linhas = saida.split(this.quebraLinha);
        assertEquals("Erro na linha 1 - $ símbolo inválido", linhas[0]);
    }

    @Test
    public void deveExibirErroAoAnalisarComentarioDeBlocoInvalido() {
        Entrada("test[\ncomentario de bloco\n123");
        String saida = this.analisadorLexico.analisar(this.codeArea);
        String[] linhas = saida.split(this.quebraLinha);
        assertEquals("Erro na linha 1 - comentário de bloco inválido ou não finalizado", linhas[0]);

        Entrada("test[comentario de bloco\n]123");
        saida = this.analisadorLexico.analisar(this.codeArea);
        linhas = saida.split(this.quebraLinha);
        assertEquals("Erro na linha 1 - comentário de bloco inválido ou não finalizado", linhas[0]);
    }
}
