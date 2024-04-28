package Classes;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Ydnek
 */
public class Customer {
    
    private int id;
    private String fullname;
    private String birthdate;
    private String phone;
    private String email;
    private String address;

    public Customer() {
    }

    public Customer(int id, String fullname, String birthdate, String phone, String email, String address) {
        this.id = id;
        this.fullname = fullname;
        this.birthdate = birthdate;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    // function to add Location 
    public void addCustomer(String _fullname,String _birthdate,String _phone,String _email ,String _address ){
        
             String  addQuery = "INSERT INTO `customers`(`fullname`, `brith_date`, `phone`, `email`, `address`) VALUES (?,?,?,?,?)";
        PreparedStatement ps ;
           try {
                   ps = DB.getConnection().prepareStatement( addQuery);
                   ps.setString(1, _fullname);
                   ps.setString(2, _birthdate);
                   ps.setString(3, _phone);
                   ps.setString(4, _email);
                   ps.setString(5, _address);
                    if(ps.executeUpdate()  !=0)
                    {
                        JOptionPane.showMessageDialog(null, "New Customer Has Been Added","Add Customer",1);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Customer Not Added","Add Customer",2);
                    }
        } catch (HeadlessException | SQLException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage(),"Invalid Info",2);
        }   
    }
    
    // function to Edit Customer 
    public void editCustomer(int _id, String _fullname,String _birthdate,String _phone,String _email ,String _address ){
                String editQuery = "UPDATE `customers` SET `fullname`=? ,`brith_date`=?,`phone`=?,`email`=?,`address`=? WHERE `id` = ?";
        PreparedStatement ps;
        try {
            ps = DB.getConnection().prepareStatement(editQuery);
                   ps.setString(1, _fullname);
                   ps.setString(2, _birthdate);
                   ps.setString(3, _phone);
                   ps.setString(4, _email);
                   ps.setString(5, _address);
                   ps.setInt(6, _id);
            if(ps.executeUpdate() !=0)
            {
                JOptionPane.showMessageDialog(null, "Customer Has Been Editied","Edit Customer",1);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Customer Not Edited","Edit Customer",2);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Invalid Info",2);
        }
    }
    
    // function to Remove Location
    public void removeCustomer(int _id){
        
                            String removeQuery = "DELETE FROM `customers` WHERE `id`=?";
                    PreparedStatement ps ;
        try {
            ps = DB.getConnection().prepareStatement(removeQuery);
            ps.setInt(1, _id);
            if(ps.executeUpdate() !=0)
            {
                JOptionPane.showMessageDialog(null, "Customer Has been Deleted","Delete Customer",1);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Customer Not Deleted","Delete Customer",2);
            }
           } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(),"Invalid Info",2);
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
    public ArrayList<Customer> customerList(){
        ArrayList<Customer> customerList = new ArrayList();
        ResultSet rs = getData("SELECT * FROM `customers`");
        try { 
            while(rs.next())
            {
               Customer customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
               customerList.add(customer);
            }
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage(),"Invalid Info",2);
        }
        return customerList; 
    }
    
}
