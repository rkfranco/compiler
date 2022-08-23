package com.example.testefavafx;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
}
