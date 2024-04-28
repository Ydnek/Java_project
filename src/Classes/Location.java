
package Classes;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Location {
    
    private int id;
    private String city;
    private String address;

    public Location() {
    }

    public Location(int _id, String _city, String _address) {
        this.id = _id;
        this.city = _city;
        this.address = _address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    // function to add Location 
    public void addLocation(String _city,String _address ){
        
             String  addQuery = "INSERT INTO `locations`( city,location) VALUES (?,?)";
        PreparedStatement ps ;
           try {
                   ps = DB.getConnection().prepareStatement( addQuery);
                   ps.setString(1, _city);
                   ps.setString(2, _address);
                    if(ps.executeUpdate() !=0)
                    {
                        JOptionPane.showMessageDialog(null, "Location Has Been Added","Add Location",1);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Location Not Added","Add Location",2);
                    }
        } catch (HeadlessException | SQLException ex) {
            Logger.getLogger(Location.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    // function to Edit Location 
    public void editLocation(int _id,String _city,String _address){
                String editQuery = "UPDATE `locations` SET `city`=? ,`location`=? WHERE `id`=?";
        PreparedStatement ps;
       
            
        try {
            ps = DB.getConnection().prepareStatement(editQuery);
            ps.setString(1, _city);
            ps.setString(2, _address);
            ps.setInt(3, _id);
            if(ps.executeUpdate() !=0)
            {
                JOptionPane.showMessageDialog(null, "Location Has Been Editied","Edit Location",1);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Location Not Edited","Edit Location",2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Location.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // function to Remove Location
    public void removeLocation(int _id){
        
                            String removeQuery = "DELETE FROM `locations` WHERE `id`=?";
                    PreparedStatement ps ;
        try {
            ps = DB.getConnection().prepareStatement(removeQuery);
            ps.setInt(1, _id);
            if(ps.executeUpdate() !=0)
            {
                JOptionPane.showMessageDialog(null, "Location Has been Deleted","Delete Location",1);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Location Not Deleted","Delete Location",2);
            }
           } catch (SQLException ex) {
            Logger.getLogger(Location.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
       // function to return a resultSet
    public ResultSet getData(String query){
        PreparedStatement ps ;
        ResultSet rs = null;
        try {
            ps = DB.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage(),"Invalid Info",2);
        }
        return rs;
    }
    
     // create a function to get all brand and return an arraylist
    public ArrayList<Location> locationList(){
        ArrayList<Location> locationList = new ArrayList<>();
        ResultSet rs = getData("SELECT * FROM `locations`");
        try { 
            while(rs.next())
            {
               Location location = new Location(rs.getInt(1),rs.getString(2),rs.getString(3));
               locationList.add(location);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Location.class.getName()).log(Level.SEVERE, null, ex);
        }
        return locationList; 
    }
    
         // create a function to get all location on the city and return an arraylist
    public ArrayList<Location> locationListByCity(String city){
        ArrayList<Location> locationList = new ArrayList<>();   
        ResultSet rs = getData("SELECT * FROM `locations` WHERE `city` = '" + city+"'");
        try { 
            while(rs.next())
            {
               Location location = new Location(rs.getInt(1),rs.getString(2),rs.getString(3));
               locationList.add(location);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Location.class.getName()).log(Level.SEVERE, null, ex);
        }
        return locationList; 
    }
    
}
