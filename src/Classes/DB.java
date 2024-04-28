
package Classes;

import java.sql.DriverManager;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
/**

 *
 * @author ydinek
 */
public class DB {
   //  connect java to mysql by  XAMPP

        private static String serverName = "loclahost";
        private static String userName  = "root";
        private static String dbName = "java_car_rental";
        private static int portNumber = 3306;
        private static String pass = "";
        
        
         public static Connection getConnection(){
             
             Connection con ;
            con = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName,userName,pass);
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
                }
             return  con;
         }
}
