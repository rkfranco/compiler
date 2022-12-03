package br.com.furb.compilador;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.*;
import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;

import java.net.URL;
import java.util.ResourceBundle;

@SuppressWarnings("restriction")
public class ViewController implements Initializable {

    private final GerenciadorArquivo gerenciadorArquivo = new GerenciadorArquivo();
    private final AnalisadorCodigo analisadorCodigo = new AnalisadorCodigo();

    @FXML
    private CodeArea codeInput;

    @FXML
    private VirtualizedScrollPane<CodeArea> virtualScroll;

    @FXML
    private TextArea txtaDebug;

    @FXML
    private Label lFileName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Ativa a contagem de linhas e sua exibição no CodeArea
        codeInput.setParagraphGraphicFactory(LineNumberFactory.get(codeInput));

        virtualScroll.setHbarPolicy(ScrollBarPolicy.ALWAYS);
        virtualScroll.setVbarPolicy(ScrollBarPolicy.ALWAYS);

        txtaDebug.setEditable(false);
    }

    @FXML
    public Button btnNovo;

    public void onBtnNovoAction() {
        this.gerenciadorArquivo.novoArquivo();
        codeInput.clear();
        txtaDebug.clear();
        lFileName.setText("");
    }

    @FXML
    public Button btnAbrir;

    public void onBtnAbrirAction() {
        String conteudoArquivo = this.gerenciadorArquivo.carregarConteudoArquivo();
        if (conteudoArquivo != null) {
            lFileName.setText(this.gerenciadorArquivo.getPathArquivoCodigoFonte());
            codeInput.clear();
            codeInput.appendText(conteudoArquivo);
        }
    }

    @FXML
    public Button btnSalvar;

    public void onBtnSalvarAction() {
        this.gerenciadorArquivo.salvarArquivoCodigoFonte(codeInput.getText());
        if (this.gerenciadorArquivo.temArquivoCarregado()) {
            lFileName.setText(this.gerenciadorArquivo.getPathArquivoCodigoFonte());
        }
        txtaDebug.clear();
    }

    @FXML
    public Button btnCopiar;

    public void onBtnCopiarAction() {
        codeInput.copy();
    }

    @FXML
    public Button btnColar;

    public void onBtnColarAction() {
        codeInput.paste();
    }

    @FXML
    public Button btnRecortar;

    public void onBtnRecortarAction() {
        codeInput.cut();
    }

    @FXML
    public Button btnCompilar;

    public void onBtnCompilarAction() {
        String saida = this.analisadorCodigo.analisar(this.codeInput);
        this.gerenciadorArquivo.gerarArquivoCodigoObjeto(this.analisadorCodigo.getCodigoObjeto());
        txtaDebug.setText(saida);
    }

    @FXML
    public Button btnEquipe;

    public void onBtnEquipeAction() {
        txtaDebug.setText("Alunos que desenvolveram este compilador: \nRodrigo Kapulka Franco \nGustavo Baroni Bruder\n");
    }

    private final KeyCombination keyBtnNovo = new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN);
    private final KeyCombination keyBtnAbrir = new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN);
    private final KeyCombination keyBtnSalvar = new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN);
    private final KeyCombination keyBtnCopiar = new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN);
    private final KeyCombination keyBtnColar = new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_DOWN);
    private final KeyCombination keyBtnRecortar = new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN);
    private final KeyCode keyBtnCompilar = KeyCode.F7;
    private final KeyCode keyBtnEquipe = KeyCode.F1;

    public void handleKeyEvents(KeyEvent event) {
        if (this.keyBtnNovo.match(event)) {
            this.onBtnNovoAction();
        }
        if (this.keyBtnAbrir.match(event)) {
            this.onBtnAbrirAction();
        }
        if (this.keyBtnSalvar.match(event)) {
            this.onBtnSalvarAction();
        }
        if (this.keyBtnCopiar.match(event)) {
            this.onBtnCopiarAction();
        }
        if (this.keyBtnColar.match(event)) {
            this.onBtnColarAction();
        }
        if (this.keyBtnRecortar.match(event)) {
            this.onBtnRecortarAction();
        }
        if (event.getCode().equals(this.keyBtnCompilar)) {
            this.onBtnCompilarAction();
        }
        if (event.getCode().equals(this.keyBtnEquipe)) {
            this.onBtnEquipeAction();
        }
    }
}
