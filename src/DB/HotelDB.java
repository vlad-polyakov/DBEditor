package DB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.City;
import model.Hotel;
import model.Office;
import model.Tour;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HotelDB {
    public ObservableList<Hotel> getDataFromDB(){
        ObservableList<Hotel> data = FXCollections.observableArrayList();
        DBConnection dbConnection = new DBConnection();
        try {
            ResultSet rs =  dbConnection.getConnection().createStatement().executeQuery("SELECT * FROM hotels");
            while (rs.next()) {
                Hotel hotel = new Hotel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4)
                );
              /* Office office = new Office();
               office.setName(rs.getString(1));
               office.setVoucher(rs.getString(2));
               office.setCost(rs.getInt(5));
               off*/
                data.add(hotel);
            }
        } catch (SQLException ex){
            System.out.print("fuck");
        }
        return data;
    }
    public void write(ObservableList<Hotel> list){
        Hotel hotel = list.get(list.size()-1);
        String InsertInfo = "INSERT INTO hotels (id, name, stars, cities_id)" +"VALUES(?,?,?,?)";
        DBConnection dbConnection = new DBConnection();
        try{
            PreparedStatement prst = dbConnection.getConnection().prepareStatement(InsertInfo);
            prst.setInt(1,hotel.getId());
            prst.setString(2,hotel.getName());
            prst.setInt(3,hotel.getStars());
            prst.setInt(4,hotel.getCities_id());
            prst.execute();
        }
        catch (SQLException ex){System.out.print("No");}
        //catch (ClassNotFoundException ex){System.out.print("www");}
    }
    public void delete(Hotel hotel){
        String InsertInfo = "DELETE FROM hotels WHERE id = ?";
        DBConnection dbConnection = new DBConnection();
        try{
            PreparedStatement prst = dbConnection.getConnection().prepareStatement(InsertInfo);
            prst.setInt(1,hotel.getId());
            prst.execute();
        }
        catch (SQLException ex){System.out.print("No");}
    }
    public ObservableList<Hotel> showInfo(){
        ObservableList<Hotel> data = FXCollections.observableArrayList();
        DBConnection dbConnection = new DBConnection();
        try {
            PreparedStatement ps =  dbConnection.getConnection().prepareStatement("SELECT * FROM hotels WHERE stars = ?");
            ps.setInt(1,5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Hotel hotel = new Hotel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4)
                );
              /* Office office = new Office();
               office.setName(rs.getString(1));
               office.setVoucher(rs.getString(2));
               office.setCost(rs.getInt(5));
               off*/
                data.add(hotel);
            }

        } catch (SQLException ex){
            System.out.print("fuck");
        }
        return data;
    }
}
