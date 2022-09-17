package br.com.furb.compilador;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;

import java.io.*;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import br.com.furb.compilador.gals.*;

@SuppressWarnings("restriction")
public class ViewController implements Initializable {
    private String filePath = "";
    private String nameFile;

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
        filePath = "";
        codeInput.clear();
        txtaDebug.clear();
        lFileName.setText("");
    }

    @FXML
    public Button btnAbrir;

    public void onBtnAbrirAction() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            nameFile = selectedFile.getName();
            filePath = selectedFile.getAbsolutePath();
            lFileName.setText(filePath);
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
                String linha = bufferedReader.readLine(), codigo = "";
                while (true) {
                    if (linha != null) {
                        codigo += linha + "\n";
                    } else {
                        break;
                    }
                    linha = bufferedReader.readLine();
                }
                codeInput.clear();
                codeInput.appendText(codigo);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    public Button btnSalvar;

    public void onBtnSalvarAction() {
        boolean sucessSaveFile;
        if (filePath == "") {
            String newFileName = "";
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Nome do arquivo");
            dialog.setHeaderText("Digite o nome do novo arquivo a ser criado");
            dialog.setContentText("Nome do arquivo:");
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()) {
                newFileName = result.get() + ".txt";
                String newFilePath = getNewFilePath();
                sucessSaveFile = saveFile(newFilePath + "/" + newFileName);
                saveFileFeedBack(newFilePath, newFileName, sucessSaveFile);
            }
        } else {
            sucessSaveFile = saveFile(filePath);
            saveFileFeedBack(filePath, nameFile, sucessSaveFile);
        }
        txtaDebug.clear();
    }

    public void saveFileFeedBack(String newFilePath, String newFileName, boolean sucessSaveFile) {
        Alert feedbackAlert;
        if (sucessSaveFile) {
            if (filePath == "") {
                nameFile = newFileName + ".txt";
                filePath = newFilePath + "\\" + newFileName;
                lFileName.setText(filePath);
            }
            feedbackAlert = new Alert(Alert.AlertType.INFORMATION);
            feedbackAlert.setTitle("Arquivo salvo");
            feedbackAlert.setHeaderText("Arquivo salvo com sucesso");
            feedbackAlert.setContentText("Arquivo salvo em" + filePath);
        } else {
            feedbackAlert = new Alert(Alert.AlertType.ERROR);
            feedbackAlert.setTitle("Erro");
            feedbackAlert.setHeaderText("Ocorreu um erro ao salvar o arquivo");
        }
        feedbackAlert.showAndWait();
    }

    public boolean saveFile(String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.append(codeInput.getText());
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public String getNewFilePath() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        return directoryChooser.showDialog(null).getPath();
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
        String debugOutput = "Lexema - Class - Linha\n";
        Lexico lexico = new Lexico();
        lexico.setInput(codeInput.getText());
        try {
            Token t = null;
            while ((t = lexico.nextToken()) != null) {
                debugOutput += t.getLexeme() + " - " + getClassById(t.getId()) + " na linha " + getLine(t.getPosition()) + "\n";

                // só escreve o lexema, necessário escrever t.getId, t.getPosition()

                // t.getId () - retorna o identificador da classe. Olhar Constants.java e adaptar, pois
                // deve ser apresentada a classe por extenso
                // t.getPosition () - retorna a posição inicial do lexema no editor, necessário adaptar
                // para mostrar a linha

                // esse código apresenta os tokens enquanto não ocorrer erro
                // no entanto, os tokens devem ser apresentados SÓ se não ocorrer erro, necessário adaptar
                // para atender o que foi solicitado
            }
        } catch (LexicalError e) {  // tratamento de erros
            debugOutput = e.getMessage() + " na linha " + getLine(e.getPosition()) + "\n";

            // e.getMessage() - retorna a mensagem de erro de SCANNER_ERRO (olhar ScannerConstants.java
            // e adaptar conforme o enunciado da parte 2)
            // e.getPosition() - retorna a posição inicial do erro, tem que adaptar para mostrar a
            // linha
        }
        txtaDebug.appendText(debugOutput);
    }

    private int getLine(int erroPosition) {
        codeInput.selectRange(erroPosition, erroPosition);
        int numberline = codeInput.getCaretSelectionBind().getParagraphIndex() + 1;
        return numberline;
    }

    @FXML
    public Button btnEquipe;

    public void onBtnEquipeAction() {
        txtaDebug.appendText("Alunos que desenvolveram este compilador: \nRodrigo Kapulka Franco \nGustavo Baroni Bruder\n");
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
    private String getClassById(int id) {
        switch (id) {
            case 2:
                return "identificador";
            case 3:
                return "constante int";
            case 4:
                return "constante float";
            case 5:
                return "constante char";
            case 6:
                return "constante string";
        }
        if (id >= 7 && id <= 26) {
            return "palavra reservada";
        }
        if (id > 26) {
            return "símbolo especial";
        }
        return "Ainda não implementado";

//        int t_identificador = 2;
//        int t_cint = 3;
//        int t_cfloat = 4;
//        int t_cchar = 5;
//        int t_cstring = 6;
//        int t_boolean = 7;
//        int t_break = 8;
//        int t_char = 9;
//        int t_do = 10;
//        int t_else = 11;
//        int t_end = 12;
//        int t_false = 13;
//        int t_float = 14;
//        int t_fun = 15;
//        int t_if = 16;
//        int t_int = 17;
//        int t_main = 18;
//        int t_print = 19;
//        int t_println = 20;
//        int t_readln = 21;
//        int t_string = 22;
//        int t_true = 23;
//        int t_val = 24;
//        int t_var = 25;
//        int t_while = 26;
//        int t_TOKEN_27 = 27; //":"
//        int t_TOKEN_28 = 28; //","
//        int t_TOKEN_29 = 29; //";"
//        int t_TOKEN_30 = 30; //"="
//        int t_TOKEN_31 = 31; //")"
//        int t_TOKEN_32 = 32; //"("
//        int t_TOKEN_33 = 33; //"{"
//        int t_TOKEN_34 = 34; //"}"
//        int t_TOKEN_35 = 35; //"=="
//        int t_TOKEN_36 = 36; //"<"
//        int t_TOKEN_37 = 37; //">"
//        int t_TOKEN_38 = 38; //"+"
//        int t_TOKEN_39 = 39; //"-"
//        int t_TOKEN_40 = 40; //"*"
//        int t_TOKEN_41 = 41; //"/"
//        int t_TOKEN_42 = 42; //"%"
//        int t_TOKEN_43 = 43; //"!="
//        int t_TOKEN_44 = 44; //"&&"
//        int t_TOKEN_45 = 45; //"||"
//        int t_TOKEN_46 = 46; //"!"
//        int t_TOKEN_47 = 47; //"++"
//        int t_TOKEN_48 = 48; //"--"
    }
}
