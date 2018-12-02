package DB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
                        rs.getString(7)
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
                " hotel_id, transport_type, departure_point)" +"VALUES(?,?,?,?,?,?,?)";
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
            prst.execute();
        }
        catch (SQLException ex){System.out.print("No");}
        //catch (ClassNotFoundException ex){System.out.print("www");}
    }
}
