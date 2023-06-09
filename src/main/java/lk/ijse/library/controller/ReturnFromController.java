package lk.ijse.library.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.library.dto.Issuse;
import lk.ijse.library.dto.Return;
import lk.ijse.library.model.IssuseModelDTO;
import lk.ijse.library.model.ReturnModelDTO;


import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ReturnFromController implements Initializable {
    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtIssuseID;

    @FXML
    private JFXTextField txtReturnID;

    @FXML
    private Label lblIssueID;

    @FXML
    private Label lblBookID;

    @FXML
    private Label lblMemberID;

    @FXML
    private Label lblIssuseDate;

    @FXML
    private Label lblDueDate;

    @FXML
    private Label lblQty;

    @FXML
    private Label lblMemebrEmail;

    @FXML
    private TableView<Return> tblReturns;

    @FXML
    private TableColumn<?, ?> colReturnID;

    @FXML
    private TableColumn<?, ?> ReturnDate;

    @FXML
    private TableColumn<?, ?> colIssuseID;

    @FXML
    private TableColumn<?, ?> ColIssuseDate;

    @FXML
    private TableColumn<?, ?> colBookID;

    Issuse issuse = new Issuse();

    public ReturnFromController() throws SQLException {
    }


    public void GoIssuse(ActionEvent actionEvent) throws SQLException {

        String IssueseID = txtIssuseID.getText();

        Issuse issuse  = IssuseModelDTO.IssuseSearch(IssueseID);

        lblIssueID.setText(issuse.getIssusId());
        lblBookID.setText(issuse.getBookId());
        lblDueDate.setText(issuse.getDueDate());
        lblIssuseDate.setText(issuse.getIssusDate());
        lblQty.setText(issuse.getIssuseQty());
        lblMemberID.setText(issuse.getMemberId());

//        lblMemberID.getText();
//        Member member = MemberModel.searchFrom(String.valueOf(lblMemberID));
//        lblMemebrEmail.setText(member.getEmail());

    }



    public void GoReturn(ActionEvent actionEvent) throws SQLException {

        String IssuseId = txtIssuseID.getText();
        String ReturnId = txtReturnID.getText();
        String ReturnDate = String.valueOf(LocalDate.now());
        String BookId = lblBookID.getText();
        String IssuseDate = lblIssuseDate.getText();
        String BookQty = lblQty.getText();


        Return return1 = new Return();
        return1.setIssuseId(IssuseId);
        return1.setReturnId(ReturnId);
        return1.setReturnDate(ReturnDate);
        return1.setBookId(BookId);
        return1.setIssuseDate(IssuseDate);

        boolean b1 = ReturnModelDTO.ReturnSet(return1,BookQty,BookId,IssuseId);
        System.out.println(return1.getIssuseId()+" "+return1.getReturnId()+" "+return1.getBookId()+" " +
                " "+return1.getReturnDate()+" "+return1.getIssuseDate());

      //  EmailModel.sendMail("librarys586@gmail.com" , "csaywdwsfqnjxjep" , lblContact.getText(), "Hi "+lblMemberID.getText()+" You'r Book is Issuse Sucses fully Completed \n"+"Return Date is ToDay : "+LocalDate.now()+"\"You'r IssuseId is : "+txtIssuseID.getText()+"\nBook Id : "+cmbBookID.getValue()+"\nDueDate is :"+DatePiker.getValue()+"\nPlease return your book by the date we have notified. Otherwise, after that date, fines will be added.\n"+"Thank you...."+lblMemberName.getText()+" for visiting our library.");


    }

    public void ReturnTableView(){
        tblReturns.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("ReturnId"));
        tblReturns.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("ReturnDate"));
        tblReturns.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("IssuseId"));
        tblReturns.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("IssuseDate"));
        tblReturns.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("BookId"));

        ArrayList<Return> returns;
        try {
            returns = ReturnModelDTO.loadAllReturnas();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tblReturns.setItems(FXCollections.observableArrayList(returns));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ReturnTableView();
    }

}
