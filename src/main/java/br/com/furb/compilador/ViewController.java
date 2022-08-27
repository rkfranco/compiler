package br.com.furb.compilador;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;

public class ViewController {

    @FXML
    private TextArea taInput;

    @FXML
    private TextArea taMsg;

    @FXML
    private Label lFileName;

    @FXML
    private Button btNew;

    public void onBtNewAction() {
        taInput.clear();
        taMsg.clear();
        lFileName.setText("");
        System.out.println("Novo");
    }

    @FXML
    private Button btOpen;

    public void onBtOpenAction() {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            lFileName.setText(selectedFile.getName());
            // Só pega o nome e seta o label lá em baixo
        }
        System.out.println("Abrir");
    }

    @FXML
    private Button btSave;

    public void onBtSaveAction() {
        System.out.println("Salvar");
    }

    @FXML
    private Button btCopy;

    public void onBtCopyAction() {
        System.out.println("Copiar");
    }

    @FXML
    private Button btPaste;

    public void onBtPasteAction() {
        System.out.println("Colar");
    }

    @FXML
    private Button btCut;

    public void onBtCutAction() {
        System.out.println("Cortar");
    }

    @FXML
    private Button btCompile;

    public void onBtCompileAction() {
        System.out.println("Compilar");
    }

    @FXML
    private Button btTeam;

    public void onBtTeamAction() {
        System.out.println("Equipe");
    }

    private final KeyCombination keyBtNew = new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN);
    private final KeyCombination keyBtOpen = new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN);
    private final KeyCombination keyBtSave = new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN);
    private final KeyCombination keyBtCopy = new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN);
    private final KeyCombination keyBtPaste = new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_DOWN);
    private final KeyCombination keyBtCut = new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN);
    private final KeyCode keyBtCompile = KeyCode.F7;
    private final KeyCode keyBtTeam = KeyCode.F1;

    public void handleKeyEvents(KeyEvent event) {
        if (this.keyBtNew.match(event)) {
            this.onBtNewAction();
        }
        if (this.keyBtOpen.match(event)) {
            this.onBtOpenAction();
        }
        if (this.keyBtSave.match(event)) {
            this.onBtSaveAction();
        }
        if (this.keyBtCopy.match(event)) {
            this.onBtCopyAction();
        }
        if (this.keyBtPaste.match(event)) {
            this.onBtPasteAction();
        }
        if (this.keyBtCut.match(event)) {
            this.onBtCutAction();
        }
        if (event.getCode().equals(this.keyBtCompile)) {
            this.onBtCompileAction();
        }
        if (event.getCode().equals(this.keyBtTeam)) {
            this.onBtTeamAction();
        }
    }
}
