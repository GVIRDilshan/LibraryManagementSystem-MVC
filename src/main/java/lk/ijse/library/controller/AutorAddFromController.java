package lk.ijse.library.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.library.dto.Autor;
import lk.ijse.library.model.AutorModel;
import lk.ijse.library.util.Alerts;
import org.checkerframework.checker.units.qual.A;

import java.io.IOException;
import java.sql.SQLException;

import static com.jfoenix.svg.SVGGlyphLoader.clear;

public class AutorAddFromController {
    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtAutorID;

    @FXML
    private JFXTextField txtAutorName;

    @FXML
    private JFXTextField txtBookID;

    @FXML
    private JFXTextField txtBookName;

    @FXML
    private JFXTextField txtEnterAutorID;

    public void OnDelete(ActionEvent actionEvent) throws SQLException {
        String AutorID = txtAutorID.getText();

        boolean d1 = AutorModel.deleteFrom(AutorID);

        if(d1) {
            new Alert(Alert.AlertType.CONFIRMATION,"Autor Delete Sucses....!").show();
            clear();
        }
    }

    public void OnSearch(ActionEvent actionEvent) throws SQLException {
        String AutorID = txtEnterAutorID.getText();

        Autor autor = AutorModel.searchFrom(AutorID);

        txtAutorID.setText(autor.getAutorID());
        txtAutorName.setText(autor.getAutorName());
        txtBookID.setText(autor.getBookID());
        txtBookName.setText(autor.getBookName());

    }

    public void OnUpdate(ActionEvent actionEvent) throws SQLException {
        String AutorID = txtAutorID.getText();
        String AutorsName = txtAutorName.getText();
        String BookID = txtBookID.getText();
        String BookName = txtBookName.getText();

        Autor autor1 = new Autor();
        autor1.setAutorID(AutorID);
        autor1.setAutorName(AutorsName);
        autor1.setBookName(BookName);
        autor1.setBookID(BookID);

        boolean A1 = AutorModel.updateAutor(autor1);

        if(A1) {
            new Alert(Alert.AlertType.CONFIRMATION,"Autor Updating Sucses....!").show();
            clear();
            clear();
        }

    }

    public void OnAdd(ActionEvent actionEvent) throws SQLException {
        String AutorID = txtAutorID.getText();
        String AutorName = txtAutorName.getText();
        String BookName = txtBookName.getText();
        String BookID = txtBookID.getText();

        Autor autor = new Autor();

        autor.setAutorID(AutorID);
        autor.setAutorName(AutorName);
        autor.setBookName(BookName);
        autor.setBookID(BookID);

        boolean b1 = AutorModel.AutorAdd(autor);

        if(b1) {
            new Alert(Alert.AlertType.CONFIRMATION,"Autor Adding Sucses....!").show();
            clear();
        }

    }
    public void clear(){
        txtAutorID.setText("");
        txtAutorName.setText("");
        txtBookID.setText("");
        txtBookName.setText("");
    }
}
