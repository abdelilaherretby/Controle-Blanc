package org.example.controle_blanc.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;
import org.example.controle_blanc.Dao.MembreDao;
import org.example.controle_blanc.Dao.MembreDaoImpl;
import org.example.controle_blanc.Model.Membre;




public class Controller {

    @FXML
    private Button ajout;

    @FXML
    private TextField femail;

    @FXML
    private TextField fnom;

    @FXML
    private TextField fphone;

    @FXML
    private TextField fprenom;

    MembreDao membreDao = new MembreDaoImpl();

    @FXML
    void ajouter(ActionEvent event) {
        Membre membre= new Membre(fnom.getText(),fprenom.getText(),femail.getText(),fphone.getText());
        membreDao.inserer(membre);
    }


}
