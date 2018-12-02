package DB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Office;

import java.sql.*;

public class OfficesDB {
    public ObservableList<Office> getDataFromDB(){
        ObservableList<Office> data = FXCollections.observableArrayList();
        DBConnection dbConnection = new DBConnection();
        try {
            ResultSet rs =  dbConnection.getConnection().createStatement().executeQuery("SELECT * FROM offices");
            while (rs.next()) {
                Office office = new Office(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(3),
                        rs.getInt(6)
                );
              /* Office office = new Office();
               office.setName(rs.getString(1));
               office.setVoucher(rs.getString(2));
               office.setCost(rs.getInt(5));
               off*/
                data.add(office);
            }
        } catch (SQLException ex){
            System.out.print("fuck");
        }
        return data;
    }
    public void write(ObservableList<Office> list){
        Office office = list.get(list.size()-1);
        String InsertInfo = "INSERT INTO offices (name, voucher, cost, adress, FIO, phone_number)" +"VALUES(?,?,?,?,?,?)";
        DBConnection dbConnection = new DBConnection();
        try{
            PreparedStatement prst = dbConnection.getConnection().prepareStatement(InsertInfo);
            prst.setString(1,office.getName());
            prst.setString(2,office.getVoucher());
            prst.setInt(3,office.getCost());
            prst.setString(4,office.getAddress());
            prst.setString(5,office.getFIO());
            prst.setInt(6,office.getPhone_number());
            prst.execute();
        }
        catch (SQLException ex){System.out.print("No");}
        //catch (ClassNotFoundException ex){System.out.print("www");}
    }
}
