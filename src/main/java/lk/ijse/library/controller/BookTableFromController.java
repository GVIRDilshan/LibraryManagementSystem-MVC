package lk.ijse.library.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.library.dto.Book;
import lk.ijse.library.model.BookModelDTO;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BookTableFromController implements Initializable {


    @FXML
    private TableView<Book> tblBooks;

    @FXML
    private TableColumn<?, ?> colBookID;

    @FXML
    private TableColumn<?, ?> colBookName;

    @FXML
    private TableColumn<?, ?> colAutorID;

    @FXML
    private TableColumn<?, ?> colPublisherID;

    @FXML
    private TableColumn<?, ?> colSupplierID;

    @FXML
    private TableColumn<?, ?> colQty;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblBooks.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblBooks.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblBooks.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("author"));
        tblBooks.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Publisher"));
        tblBooks.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("Supplier"));
        tblBooks.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("qty"));

        ArrayList<Book> books;
        try {
            books = BookModelDTO.loadAllBooks();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tblBooks.setItems(FXCollections.observableArrayList(books));
    }
}
