  
package Classes;

import java.awt.HeadlessException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class Brand_Cls {
    
    private int id;
    private String name;
    private byte[] logo;
    
    public Brand_Cls(){}
    
    public Brand_Cls(int _id, String _name, byte[] _logo) {
        this.id = _id;
        this.name = _name;
        this.logo = _logo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
    
    // creat function to add a new brand
    public void addBrand(String name,byte[] logo){
        
        String insertQuery = "INSERT INTO brands( name,logo) VALUES (?,?)";
        PreparedStatement ps ;
           try {
                   ps = DB.getConnection().prepareStatement(insertQuery);
                                
                    ps.setString(1, name);
                    ps.setBytes(2, logo);
                                    
                    if(ps.executeUpdate() !=0)
                    {
                        JOptionPane.showMessageDialog(null, "Brand Has Been Added","Brand Add",1);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Brand Not Added","Brand Add",2);
                    }
        } catch (HeadlessException | SQLException ex) 
        {
            Logger.getLogger(Brand_Cls.class.getName()).log(Level.SEVERE, null, ex);       
        }
    }
    
     // function to edit the brand
    public void editBrand(int _id, String _name, byte[] _logo){
        
        String editQuery = "UPDATE brands SET name =?, logo =? WHERE id =?";
        PreparedStatement ps;
        
        try {
            ps = DB.getConnection().prepareStatement(editQuery);
            ps.setString(1, _name);
            ps.setBytes(2, _logo);
            ps.setInt(3, _id);
            
            if(ps.executeUpdate() !=0)
            {
                JOptionPane.showMessageDialog(null, "The Brand Has Been Edited","Edit Brand",1);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Brand Not Edited","Edit Brand",2 );
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Brand_Cls.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // function to Remove brand
    public void removeBrand(int _id){
                    String removeQuery = "DELETE FROM `brands` WHERE `id`=?";
                    PreparedStatement ps ;
                    
        try {
            ps = DB.getConnection().prepareStatement(removeQuery);
            ps.setInt(1, _id);
            
            if(ps.executeUpdate() !=0)
            {
                JOptionPane.showMessageDialog(null, "Brand Has Been Deleted","Delete Barnd",1);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Brand Not Deleted","Delete Barnd",2);
            }
             
        } catch (SQLException ex) {
            Logger.getLogger(Brand_Cls.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Brand_Cls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
        
    }
    
    // create a function to get all brand and return an arraylist
    public ArrayList<Brand_Cls> brandList(){
        ArrayList<Brand_Cls> brandlist = new ArrayList();
        ResultSet rs = getData("SELECT * FROM `brands`"); 
        
        try { 
            while(rs.next())
            {
                Brand_Cls brand = new Brand_Cls(rs.getInt(1),rs.getString(2),rs.getBytes(3));
                brandlist.add(brand);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Brand_Cls.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return brandlist; 
    }
    
    // functoin to get brand by id 
    public Brand_Cls getBrandById(int brand_id){
        String query = "SELECT * FROM `brands` WHERE `id`= "+brand_id;
        
        ResultSet rs = getData(query);
        Brand_Cls brand = null;
        try {
            rs.next();
           brand = new Brand_Cls(rs.getInt(1),rs.getString(2),rs.getBytes(3));
        } catch (SQLException ex) {
            Logger.getLogger(Brand_Cls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return brand;
    }
    
    // function to populate a hashmap with brands (id and name)
    public HashMap<Integer ,String> brandHasMap()
    {
        HashMap<Integer ,String> brands_map = new HashMap<Integer ,String>();
        
        ResultSet rs = getData("SELECT * FROM `brands`");
        
        try
        {
            while(rs.next()){
                brands_map.put(  rs.getInt(1)  ,rs.getString(2));
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(Brand_Cls.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return brands_map; 
    }
    
}
