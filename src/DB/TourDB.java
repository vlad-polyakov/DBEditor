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

public class TourDB {
    public ObservableList<Tour> getDataFromDB(){
        ObservableList<Tour> data = FXCollections.observableArrayList();
        DBConnection dbConnection = new DBConnection();
        try {
            ResultSet rs =  dbConnection.getConnection().createStatement().executeQuery("SELECT * FROM tours");
            while (rs.next()) {
                Tour tour = new Tour(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                );
              /* Office office = new Office();
               office.setName(rs.getString(1));
               office.setVoucher(rs.getString(2));
               office.setCost(rs.getInt(5));
               off*/
                data.add(tour);
            }
        } catch (SQLException ex){
            System.out.print("fuck");
        }
        return data;
    }
    public void write(ObservableList<Tour> list){
        Tour tour = list.get(list.size()-1);
        String InsertInfo = "INSERT INTO tours (tour_id, type, duration_days, city_id," +
                " hotel_id, transport_type, departure_point, office_name)" +"VALUES(?,?,?,?,?,?,?,?)";
        DBConnection dbConnection = new DBConnection();
        try{
            PreparedStatement prst = dbConnection.getConnection().prepareStatement(InsertInfo);
            prst.setInt(1,tour.getId());
            prst.setString(2,tour.getType());
            prst.setInt(3,tour.getDays());
            prst.setInt(4,tour.getCity_id());
            prst.setInt(5,tour.getHotel_id());
            prst.setString(6,tour.getTransport_type());
            prst.setString(7,tour.getDeparture_point());
            prst.setString(8,tour.getOfficeName());
            prst.execute();
        }
        catch (SQLException ex){System.out.print("No");}
        //catch (ClassNotFoundException ex){System.out.print("www");}
    }
    public void delete(Tour tour){
        String InsertInfo = "DELETE FROM tours WHERE type = ?";
        DBConnection dbConnection = new DBConnection();
        try{
            PreparedStatement prst = dbConnection.getConnection().prepareStatement(InsertInfo);
            prst.setString(1,tour.getType());
            prst.execute();
        }
        catch (SQLException ex){System.out.print("No");}
    }
    public Tour getInfo(int id){
        Tour tour = new Tour();
        DBConnection dbConnection = new DBConnection();
        try {
            PreparedStatement ps =  dbConnection.getConnection().prepareStatement("SELECT * FROM tours WHERE tour_id = ?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               tour = new Tour(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                );
              /* Office office = new Office();
               office.setName(rs.getString(1));
               office.setVoucher(rs.getString(2));
               office.setCost(rs.getInt(5));
               off*/


            }

            return tour;
        } catch (SQLException ex){
            System.out.print("fuck");
        }
        return tour;
    }
}
