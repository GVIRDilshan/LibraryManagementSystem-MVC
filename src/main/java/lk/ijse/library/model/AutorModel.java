package lk.ijse.library.model;

import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.Autor;
import lk.ijse.library.dto.Book;
import lk.ijse.library.dto.Member;

import java.sql.*;
import java.util.ArrayList;

public class AutorModel {
    public static boolean AutorAdd(Autor Aotor) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "insert into autor values(?,?,?,?)";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1,Aotor.getAutorID());
        stm.setObject(2,Aotor.getAutorName());
        stm.setObject(3,Aotor.getBookName());
        stm.setObject(4,Aotor.getBookID());

        int result = stm.executeUpdate();

        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }
    public static Autor searchFrom(String id) throws SQLException {

        Connection con = DBConnection.getInstance().getConnection();

        String sql = "select * from autor where AutorId=?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1,id);

        ResultSet result = stm.executeQuery();

        if (result.next()) {
            Autor autor = new Autor();
            autor.setAutorID(result.getString(1));
            autor.setAutorName(result.getString(2));
            autor.setBookID(result.getString(3));
            autor.setBookName(result.getString(4));

            return autor;
        }
        return null;
    }
    public static Boolean updateAutor(Autor autor) throws SQLException {

        Connection con = DBConnection.getInstance().getConnection();

        String sql = "update autor set name=?, BookName=?,Book_Id=? where AutorId=?";

        PreparedStatement stm = con.prepareStatement(sql);


        stm.setObject(1,autor.getAutorName());
        stm.setObject(2,autor.getBookName());
        stm.setObject(3,autor.getBookID());
        stm.setObject(4,autor.getAutorID());

        int result = stm.executeUpdate();

        if (result == 1) {
            return true;
        }
        return null;
    }
    public static boolean deleteFrom(String id) throws SQLException {

        Connection con = DBConnection.getInstance().getConnection();

        String sql = "delete from autor where AutorId =?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1, id);

        int result = stm.executeUpdate();

        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }
    public static ArrayList<String> loadAllAutorIds() throws SQLException {

        Connection con = DBConnection.getInstance().getConnection();

        String sql = "select  AutorId from Autor";

        PreparedStatement stm = con.prepareStatement(sql);

            ResultSet result = stm.executeQuery();

            ArrayList<String> AutorIds = new ArrayList<>();

            while (result.next()) {
               AutorIds.add(result.getString(1));
            }
            return AutorIds;
    }
    public static ArrayList<Autor> loadAllAutors() throws SQLException {

        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from autor";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet result = stm.executeQuery();

        ArrayList<Autor> autors = new ArrayList<>();

        while (result.next()) {
            Autor autor = new Autor();
            autor.setAutorID(result.getString(1));
            autor.setAutorName(result.getString(2));
            autor.setBookName(result.getString(3));
            autor.setBookID(result.getString(4));

            autors.add(autor);
        }

        return autors;
    }
}
