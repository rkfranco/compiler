package br.com.furb.compilador;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

@SuppressWarnings("restriction")
public class ViewController implements Initializable {
    private String filePath = "";
    private String nameFile;
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
        String saida = this.analisadorCodigo.analisar(this.codeInput);
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
