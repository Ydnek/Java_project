/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ydnek
 */
public class Booking {
    int id ;
    int car_id;
    int customer_id;
    String pickup_city;
    String pickup_address;
   String pickup_date;
   String pickup_time;
   String dropoff_city;
    String dropoff_address;
   String dropoff_date;
   String dropoff_time;
   int total_price;

    public Booking() {
    }

    public Booking(int id, int car_id, int customer_id, String pickup_city, String pickup_address, String pickup_date, String pickup_time, String dropoff_city, String dropoff_address, String dropoff_date, String dropoff_time, int total_price) {
        this.id = id;
        this.car_id = car_id;
        this.customer_id = customer_id;
        this.pickup_city = pickup_city;
        this.pickup_address = pickup_address;
        this.pickup_date = pickup_date;
        this.pickup_time = pickup_time;
        this.dropoff_city = dropoff_city;
        this.dropoff_address = dropoff_address;
        this.dropoff_date = dropoff_date;
        this.dropoff_time = dropoff_time;
        this.total_price = total_price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getPickup_city() {
        return pickup_city;
    }

    public void setPickup_city(String pickup_city) {
        this.pickup_city = pickup_city;
    }

    public String getPickup_address() {
        return pickup_address;
    }

    public void setPickup_address(String pickup_address) {
        this.pickup_address = pickup_address;
    }

    public String getPickup_date() {
        return pickup_date;
    }

    public void setPickup_date(String pickup_date) {
        this.pickup_date = pickup_date;
    }

    public String getPickup_time() {
        return pickup_time;
    }

    public void setPickup_time(String pickup_time) {
        this.pickup_time = pickup_time;
    }

    public String getDropoff_city() {
        return dropoff_city;
    }

    public void setDropoff_city(String dropoff_city) {
        this.dropoff_city = dropoff_city;
    }

    public String getDropoff_address() {
        return dropoff_address;
    }

    public void setDropoff_address(String dropoff_address) {
        this.dropoff_address = dropoff_address;
    }

    public String getDropoff_date() {
        return dropoff_date;
    }

    public void setDropoff_date(String dropoff_date) {
        this.dropoff_date = dropoff_date;
    }

    public String getDropoff_time() {
        return dropoff_time;
    }

    public void setDropoff_time(String dropoff_time) {
        this.dropoff_time = dropoff_time;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }
   
   
    // addd a new booking 
    public void addNewBooking(int car_id, int customer_id,String pickup_city,String pickup_address,String pickup_date,
            String pickup_time,String dropoff_city,String dropoff_address,String dropoff_date,String dropoff_time,int total_price)
    {
                String pererquery = "INSERT INTO `reservation`(`car_id`, `customer_id`, `pickop_city`, `pickop_address`, `pickop_date`, `pickop_time`, `dropoff_city`, `dropoff_address`, `dropoff_date`, `dropoff_time`, `total_price`) VALUES (?,?,?,?,?,?,?,?,?,?,?) ";
        PreparedStatement ps ;
           try {
                   ps = DB.getConnection().prepareStatement(pererquery);
                                
                    ps.setInt(1, car_id);
                    ps.setInt(2, customer_id);
                    ps.setString(3, pickup_city);
                    ps.setString(4, pickup_address);
                    ps.setString(5, pickup_date);
                    ps.setString(6, pickup_time);
                    ps.setString(7, dropoff_city);
                    ps.setString(8, dropoff_address);
                    ps.setString(9, dropoff_date);
                    ps.setString(10, dropoff_time);
                    ps.setInt(11, total_price);
                 
                    
                    if(ps.executeUpdate() !=0)
                    {
                        JOptionPane.showMessageDialog(null, "This Car has been booked","Booking ",1);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Car not booked","Booking",2);
                    }
            
        } catch (HeadlessException | SQLException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // to remove booking 
    public void removeBooking(int _id)
    {
                            String removeQuery = "DELETE FROM `reservation` WHERE `id`=?";
                    PreparedStatement ps ;
                    
        try {
            ps = DB.getConnection().prepareStatement(removeQuery);
            ps.setInt(1, _id);
            
            if(ps.executeUpdate() !=0)
            {
                JOptionPane.showMessageDialog(null, "This Reservation Has Been Deleted","Delete Reservation",1);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Reservation Not Deleted","Delete Reservation",2);
            }
             
        } catch (SQLException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
