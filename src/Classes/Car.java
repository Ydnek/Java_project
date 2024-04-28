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
 * @author ydnek
 */
public class Car {
    
    private int id;
    private int brand;
    private int passengers;
    private int price;
    private String model;
    private String fuel;
    private String color;
    private String  _calss_ ;
    private String gearbox;
    private String air_condi;
    private String airbag;
    private String sunroof;
    private String heated_seat;
    private String nav_system;
    private String bluetooth;
    private String elec_window;
    private String gps;

    public Car() {
    }

    public Car(int id, int brand,String model, String fuel,String color,String _calss_, int passengers,  String gearbox,  int price,   String air_condi, String airbag, String sunroof, 
            String heated_seat, String nav_system, String bluetooth, String elec_window, String gps) {
        this.id = id;
        this.brand = brand;
        this.passengers = passengers;
        this.price = price;
        this.model = model;
        this.fuel = fuel;
        this.color = color;
        this._calss_ = _calss_;
        this.gearbox = gearbox;
        this.air_condi = air_condi;
        this.airbag = airbag;
        this.sunroof = sunroof;
        this.heated_seat = heated_seat;
        this.nav_system = nav_system;
        this.bluetooth = bluetooth;
        this.elec_window = elec_window;
        this.gps = gps;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBrand() {
        return brand;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCalss_() {
        return _calss_;
    }

    public void setCalss_(String _calss_) {
        this._calss_ = _calss_;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public String getAir_condi() {
        return air_condi;
    }

    public void setAir_condi(String air_condi) {
        this.air_condi = air_condi;
    }

    public String getAirbag() {
        return airbag;
    }

    public void setAirbag(String airbag) {
        this.airbag = airbag;
    }

    public String getSunroof() {
        return sunroof;
    }

    public void setSunroof(String sunroof) {
        this.sunroof = sunroof;
    }

    public String getHeated_seat() {
        return heated_seat;
    }

    public void setHeated_seat(String heated_seat) {
        this.heated_seat = heated_seat;
    }

    public String getNav_system() {
        return nav_system;
    }

    public void setNav_system(String nav_system) {
        this.nav_system = nav_system;
    }

    public String getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }

    public String getElec_window() {
        return elec_window;
    }

    public void setElec_window(String elec_window) {
        this.elec_window = elec_window;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }
    
        // function to return a resultSet
    public ResultSet getData(String query)
    {
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
        // create a function to get all cars and return an arraylist
    public ArrayList<Car> carsList()
    {
        ArrayList<Car> carList = new ArrayList();
        ResultSet rs = getData("SELECT * FROM `cars`");
        try {   
            while(rs.next())
            {
                Car car = new Car(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),
                        rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),
                        rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16),
                        rs.getString(17));
                carList.add(car);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
        }
        return carList; 
    }
    

        // function to add new Car 
    public void addCar(int _brand,String _model,String _fuel,String _color,String _class,int _passengers,String _gearebox
            ,int price,String _air_condi,String _airbag,String _sunroof,String _heated_seat,String _nav_system
            ,String _bluetooth,String _elec_window,String _gps){
        
             String  addQuery = "INSERT INTO `cars`(`brand`, `model`, `fuel`, `color`, `class`, `passengers`, `gearbox`, `price`, `ait_condtion`, `air_bag`, `sunroof`, `heated_seat`, `nav_systen`, `bluetooth`, `electric_window`, `gps`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps ;
           try {
                   ps = DB.getConnection().prepareStatement( addQuery);
                   ps.setInt(1,_brand);
                   ps.setString(2, _model);
                   ps.setString(3, _fuel);
                   ps.setString(4, _color);
                   ps.setString(5, _class);
                   ps.setInt(6, _passengers);
                   ps.setString(7, _gearebox);
                   ps.setInt(8,price);
                   ps.setString(9, _air_condi);
                   ps.setString(10, _airbag);
                   ps.setString(11, _sunroof);
                   ps.setString(12, _heated_seat);
                   ps.setString(13, _nav_system);
                   ps.setString(14, _bluetooth);
                   ps.setString(15, _elec_window);
                   ps.setString(16, _gps);
                   
                    if(ps.executeUpdate() !=0)
                    {
                        JOptionPane.showMessageDialog(null, "The New Car Has Been Added","Add Car",1);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Car Not Added","Add Car",2);
                    }
        } catch (HeadlessException | SQLException ex) {
            Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
        // create function to add a new car image
        public void addCarImage(int car_id,byte[] car_image){
        
        String insertQuery = "INSERT INTO `car_images`(`car_id`, `car_image`) VALUES (?,?)";
        PreparedStatement ps ;
           try {
                   ps = DB.getConnection().prepareStatement(insertQuery);
                                
                    ps.setInt(1, car_id);
                    ps.setBytes(2, car_image); 
                    if(ps.executeUpdate() !=0)
                    {
                        JOptionPane.showMessageDialog(null, "New Image Added","Car Image Add",1);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Image Not Added","Car Image Add",2);
                    }
            
        } catch (HeadlessException | SQLException ex) {
            Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        
        // function to edit the car
    public void editCar(int id,int _brand,String _model,String _fuel,String _color,String _class,int _passengers,String _gearebox
            ,int price,String _air_condi,String _airbag,String _sunroof,String _heated_seat,String _nav_system
            ,String _bluetooth,String _elec_window,String _gps){
        
        String editQuery = "UPDATE `cars` SET `brand`=?,`model`=?,`fuel`=?,`color`=?,`class`=?,`passengers`=?,`gearbox`=?,`price`=?,`ait_condtion`=?,`air_bag`=?,`sunroof`=?,`heated_seat`=?,`nav_systen`=?,`bluetooth`=?,`electric_window`=?,`gps`=? WHERE `id`= ?";
        PreparedStatement ps;
        
        try {
            ps = DB.getConnection().prepareStatement(editQuery);
                   ps.setInt(1,_brand);
                   ps.setString(2, _model);
                   ps.setString(3, _fuel);
                   ps.setString(4, _color);
                   ps.setString(5, _class);
                   ps.setInt(6, _passengers);
                   ps.setString(7, _gearebox);
                   ps.setInt(8,price);
                   ps.setString(9, _air_condi);
                   ps.setString(10, _airbag);
                   ps.setString(11, _sunroof);
                   ps.setString(12, _heated_seat);
                   ps.setString(13, _nav_system);
                   ps.setString(14, _bluetooth);
                   ps.setString(15, _elec_window);
                   ps.setString(16, _gps);
                    ps.setInt(17,id);
            
            if(ps.executeUpdate() !=0)
            {
                JOptionPane.showMessageDialog(null, "Car Info Has Been Edited","Edit Car Info",1);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Car Info Not Edited","Edit Car Info",2 );
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // function to Remove Car
    public void removeCar(int _id){
                    String removeQuery = "DELETE FROM `cars` WHERE `id`=?";
                    PreparedStatement ps ;
                    
        try {
            ps = DB.getConnection().prepareStatement(removeQuery);
            ps.setInt(1, _id);
            
            if(ps.executeUpdate() !=0)
            {
                JOptionPane.showMessageDialog(null, "Car Has Been Deleted","Delete Car",1);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Car Not Deleted","Delete Car",2);
            }
             
        } catch (SQLException ex) {
            Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    // function to Remove Car
    public void removeCarImage(int img_id){
                    String removeQuery = "DELETE FROM `car_images` WHERE `id` = ?";
                    PreparedStatement ps ;
                    
        try {
            ps = DB.getConnection().prepareStatement(removeQuery);
            ps.setInt(1, img_id);
            
            if(ps.executeUpdate() !=0)
            {
                JOptionPane.showMessageDialog(null, "Car Image Has Been Deleted","Delete Car Image",1);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Car Image Not Deleted","Delete Car Image",2);
            }
             
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Select the Image First","Delete Car Image",2);
        }
        
    }
public class CarImage{
    private int img_id;
    private int car_id;
    private byte[] car_img;

        public CarImage() {
        }

        public CarImage(int img_id, int car_id, byte[] car_img) {
            this.img_id = img_id;
            this.car_id = car_id;
            this.car_img = car_img;
        }  

        public int getImg_id() {
            return img_id;
        }

        public void setImg_id(int img_id) {
            this.img_id = img_id;
        }

        public int getCar_id() {
            return car_id;
        }

        public void setCar_id(int car_id) {
            this.car_id = car_id;
        }

        public byte[] getCar_img() {
            return car_img;
        }

        public void setCar_img(byte[] car_img) {
            this.car_img = car_img;
        }
    
}
    
        // get car Imges
            public ArrayList<CarImage > carImageList(int car_id)
            {
                ArrayList<CarImage> images = new ArrayList<>();
                ResultSet rs = getData("SELECT `id`, `car_id`, `car_image` FROM `car_images` WHERE   `car_id`  =  " + car_id );
               CarImage car_image;
                try {
                    
                    while(rs.next())
                    {
                       // images.add(rs.getInt(2));
                        car_image = new CarImage();
                        car_image.setImg_id(rs.getInt(1));
                        car_image.setCar_id(rs.getInt(2));
                        car_image.setCar_img(rs.getBytes(3));
                        images.add(car_image);
                    }
                } catch (SQLException ex)
                {
                    Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
                }
        return images; 
    }
            
            
          //  a function to search car by id 
    public Car getCarById(int car_id){
        String query = "SELECT  *  FROM `cars` WHERE `id`= "+car_id;
        
        ResultSet rs = getData(query);
        Car car = null;
        try {
            if(rs.next()){
                 JOptionPane.showMessageDialog(null, "Display car info","Valid Info",1);
            car = new Car(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),
                   rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),
                   rs.getInt(9) ,rs.getString(10),rs.getString(11),rs.getString(12),
                   rs.getString(13),rs.getString(14),rs.getString(15),
                   rs.getString(16),rs.getString(17));
            }
            else 
            {
                JOptionPane.showMessageDialog(null, "No Car With This ID","Invalid Info",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
        }
        return car;
    }
    
        // create a function to get all cars and return an arraylist
    public ArrayList<Car> carsByBrandList(int brand_id)
    {
        ArrayList<Car> carList = new ArrayList();
        ResultSet rs = getData("SELECT * FROM `cars` WHERE  `brand` = " +brand_id);
        try {   
            while(rs.next())
            {Car car = new Car(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),
                        rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),
                        rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16),
                        rs.getString(17));
                carList.add(car);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
        }
        return carList; 
    }
    
    
}
