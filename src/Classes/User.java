/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ydnek
 */
public class User {
    
    private int id;
    private String fullname;
    private String username;
    private String password;
    private String user_type;
    private String phone;
    private String email;

    public User() {
    }

    public User(int id, String fullname, String username, String password, String user_type, String phone, String email) {
        this.id = id;
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.user_type = user_type;
        this.phone = phone;
        this.email = email;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
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
    
        // function to add new user  
    public void addUser(String _fullname,String _username,String _password,String _usertype ,String _phone  ,String _email ){
        
             String  addQuery = "INSERT INTO `users`(`fullname`, `username`, `password`, `user_type`, `phone`, `email`) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps ;
           try {
                   ps = DB.getConnection().prepareStatement( addQuery);
                   ps.setString(1, _fullname);
                   ps.setString(2, _username);
                   ps.setString(3, _password);
                   ps.setString(4, _usertype);
                   ps.setString(5, _phone);
                   ps.setString(6, _email);
                    if(ps.executeUpdate()  !=0)
                    {
                        JOptionPane.showMessageDialog(null, "New User Has Been Added","Add User",1);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "User Not Added","Add User",2);
                    }
        } catch (HeadlessException | SQLException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage(),"Invalid Info",2);
        }   
    }
    
      // function to Edit User 
    public void editUser(int _id, String _fullname,String _username,String _password,String _usertype ,String _phone  ,String _email ){
                String editQuery = "UPDATE `users` SET `fullname`=?,`username`=?,`password`=?,`user_type`=?,`phone`=?,`email`=? WHERE `id` = ?";
        PreparedStatement ps;
        try {
            ps = DB.getConnection().prepareStatement(editQuery);
                   ps.setString(1, _fullname);
                   ps.setString(2, _username);
                   ps.setString(3, _password);
                   ps.setString(4, _usertype);
                   ps.setString(5, _phone);
                   ps.setString(6, _email);
                   ps.setInt(7, _id);
            if(ps.executeUpdate() !=0)
            {
                JOptionPane.showMessageDialog(null, "User Info Has Been Editied","Edit User",1);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "User Info Not Edited","Edit User",2);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Invalid Info",2);
        }
    }
    
    // function to Remove User
    public void removeUser(int _id){
        
                            String removeQuery = "DELETE FROM `users` WHERE `id`=?";
                    PreparedStatement ps ;
        try {
            ps = DB.getConnection().prepareStatement(removeQuery);
            ps.setInt(1, _id);
            if(ps.executeUpdate() !=0)
            {
                JOptionPane.showMessageDialog(null, "User Has been Deleted","Delete User",1);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "User Not Deleted","Delete User",2);
            }
           } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage(),"Invalid Info",2);
        }
    }
        // functoin to get brand by id 
    public User  getUserById(int user_id){
        String query = "SELECT * FROM `users` WHERE `id`= "+user_id;
        
        ResultSet rs = getData(query);
        User user = null;
        try {
            rs.next();
             user= new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7));
              
        } catch (SQLException ex) 
        {
             JOptionPane.showMessageDialog(null, "Enter A Valid User ID","Invalid Info",2);
        }
        return user;
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
    
     //  function to get all User and return an arraylist
    public ArrayList<User> userList(){
        ArrayList<User> user_List = new ArrayList();
        ResultSet rs = getData("SELECT * FROM `users`");
        try { 
            while(rs.next())
            {
               User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7));
               user_List.add(user);
            }
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage(),"Invalid Info",2);
        }
        return user_List; 
    }
    
    
}
