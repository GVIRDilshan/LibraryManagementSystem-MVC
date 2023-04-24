package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import lk.ijse.library.db.DBConnection;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;

public class ReportServiesFromController {

    @FXML
    private AnchorPane root;

    public void btnBookReport(ActionEvent actionEvent) throws FileNotFoundException, JRException, SQLException {
        InputStream input=new FileInputStream(new File("F:\\rep\\LibraryManagementSystem\\src\\main\\resources\\Report\\BooksReport.jrxml"));
        JasperDesign jasperDesign = JRXmlLoader.load(input);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null, DBConnection.getInstance().getConnection());

        JasperViewer.viewReport(jasperPrint,false);
    }

    public void btnMemberReport(ActionEvent actionEvent) throws FileNotFoundException, JRException, SQLException {
        InputStream input=new FileInputStream(new File("F:\\rep\\LibraryManagementSystem\\src\\main\\resources\\Report\\Wood.jrxml"));
   //     InputStream input=new FileInputStream(new File("F:\\rep\\LibraryManagementSystem\\src\\main\\resources\\Report\\BooksReport.jrxml"));
        JasperDesign jasperDesign = JRXmlLoader.load(input);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null, DBConnection.getInstance().getConnection());

        JasperViewer.viewReport(jasperPrint,false);
    }

    public void btnIssuseReport(ActionEvent actionEvent) {
    }

    public void btnReturnReport(ActionEvent actionEvent) {

    }

    public void btnPublisherReport(ActionEvent actionEvent) {

    }

    public void btnSupplierReport(ActionEvent actionEvent) {

    }

    public void btnAutorReport(ActionEvent actionEvent) {

    }

    public void btnFinresReport(ActionEvent actionEvent) {

    }
}
