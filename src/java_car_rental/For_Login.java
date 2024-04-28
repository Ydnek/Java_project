 package java_car_rental;

import Classes.DB;
import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author yidnek
 */

public class For_Login extends javax.swing.JFrame {
    

    public For_Login() {
        initComponents();
        
        //cente the form 
         this.setLocationRelativeTo(null);
        
        // display image on the jlables
        dispalyimages(jLabel_Logo.getWidth(),jLabel_Logo.getHeight(),"images/Car1.png",jLabel_Logo);
        
        jLabel_user.setIcon(new ImageIcon(getClass().getResource("images/Username_34x34.png")));
        jLabel_user1.setIcon(new ImageIcon(getClass().getResource("images/Password2_34x34.png")));
        
        // create border 
        Border title_border = BorderFactory.createMatteBorder(0, 0, 3, 0, Color.red);
        jLabel_title.setBorder(title_border);
        
    }
    
    // craete function to resize the images so it can fit jlabel
        public void dispalyimages(int width, int height,String image_path,JLabel label)
    {
        // get the images
        
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(image_path));
        // resize the image
        Image image = imageIcon.getImage().getScaledInstance(width, height,  Image.SCALE_SMOOTH);
        // set the image into the jlabel
        label.setIcon(new ImageIcon(image));
        
    }
    
    public void dispalyimage(int width, int height,byte[] image_byte,JLabel label)
    {
        // get the images
        
        ImageIcon imageIcon = new ImageIcon(image_byte);
        // resize the image
        Image image = imageIcon.getImage().getScaledInstance(width, height,  Image.SCALE_SMOOTH);
        // set the image into the jlabel
        label.setIcon(new ImageIcon(image));
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel_title = new javax.swing.JLabel();
        jLabel_user = new javax.swing.JLabel();
        jButton_Login = new javax.swing.JButton();
        jLabel_Close = new javax.swing.JLabel();
        jLabel_user1 = new javax.swing.JLabel();
        jLabel_Logo = new javax.swing.JLabel();
        usernamefiled = new javax.swing.JTextField();
        passwordfiled = new javax.swing.JPasswordField();
        jCheckBox_password = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel_title.setFont(new java.awt.Font("Sitka Text", 1, 48)); // NOI18N
        jLabel_title.setText("Login");

        jLabel_user.setBackground(new java.awt.Color(255, 51, 0));
        jLabel_user.setOpaque(true);

        jButton_Login.setBackground(new java.awt.Color(0, 153, 0));
        jButton_Login.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton_Login.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Login.setText("Login");
        jButton_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LoginActionPerformed(evt);
            }
        });

        jLabel_Close.setBackground(new java.awt.Color(153, 153, 153));
        jLabel_Close.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_Close.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Close.setText("x");
        jLabel_Close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_Close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_CloseMouseClicked(evt);
            }
        });

        jLabel_user1.setBackground(new java.awt.Color(255, 51, 0));
        jLabel_user1.setOpaque(true);

        jLabel_Logo.setBackground(new java.awt.Color(0, 204, 255));
        jLabel_Logo.setOpaque(true);

        usernamefiled.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        usernamefiled.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernamefiledFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernamefiledFocusLost(evt);
            }
        });

        passwordfiled.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        passwordfiled.setText("password");
        passwordfiled.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordfiledFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordfiledFocusLost(evt);
            }
        });

        jCheckBox_password.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jCheckBox_password.setText("Show Pasword");
        jCheckBox_password.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_passwordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel_Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel_user1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(passwordfiled))
                                    .addComponent(jButton_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel_user, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel_title, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(usernamefiled, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))))
                                .addGap(78, 78, 78))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel_Close, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jCheckBox_password, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel_Close, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jLabel_title, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_user, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernamefiled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_user1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordfiled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jCheckBox_password)
                .addGap(73, 73, 73)
                .addComponent(jButton_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
            .addComponent(jLabel_Logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LoginActionPerformed

            String username = usernamefiled.getText();
            String password = String.valueOf(passwordfiled.getPassword());
            String Loged_usernme = null;
            
            PreparedStatement pst ;
            ResultSet rsss;
            
            String sql = "SELECT * FROM `users` WHERE `username`=? AND `password`=?";
            
            if(username.trim().toLowerCase().equals("username")||
                    password.trim().toLowerCase().equals("password"))
                    {
                        JOptionPane.showMessageDialog(null, "Enter a Valid Username & Password","Log In",2);
                    }
            else
                    {
                try 
                    {
                        pst = DB.getConnection().prepareStatement(sql);
                            pst.setString(1, username);
                            pst.setString(2, password);
                            rsss = pst.executeQuery();


                            if(rsss.next())
                                {
                                    JOptionPane.showMessageDialog(null, "Logged In","Log In",1);
                                    Form_Dashboard menu = new Form_Dashboard();
                                    menu.setVisible(true);
                                    this.dispose();
                                    // to show logged  username
                                    
                                    Form_Dashboard.lbl_logged_username.setText(rsss.getString("username"));
                                  //  Loged_usernme.equals(rsss.getString("username"));

                                    // to show logged user profilepic
                                    //  dispalyimage(Form_Dashboard.lbl_logged_username.getWidth(),Form_Dashboard.lbl_logged_username.getHeight(),rsss.getBytes("image"),Form_Dashboard.lbl_userprofile_pic);

                                }
                            else
                                {
                                    JOptionPane.showMessageDialog(null, "Invalid Username or Password","Log In",2);
                                }
                    } 
                catch (SQLException ex) 
                    {
                        JOptionPane.showMessageDialog(null, ex.getMessage(),"Invalid Info",2);
                    }
                    }
    }//GEN-LAST:event_jButton_LoginActionPerformed

    private void jLabel_CloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_CloseMouseClicked
       // close the form
       
                       int confirm = JOptionPane.showConfirmDialog(null, "Are You Sure You Want to Exit", "Confirm",JOptionPane.YES_NO_OPTION);
                if(confirm==JOptionPane.YES_OPTION)
                {
                    System.exit(0);
                }
        
    }//GEN-LAST:event_jLabel_CloseMouseClicked

    private void usernamefiledFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernamefiledFocusGained
        // clear text if text = 'username'
        
        if(usernamefiled.getText().trim().toLowerCase().equals("username")){
            usernamefiled.setText("");
            usernamefiled.setForeground(Color.black);
        } 
    }//GEN-LAST:event_usernamefiledFocusGained

    private void usernamefiledFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernamefiledFocusLost
        // TODO add your handling code here:
        
        if(usernamefiled.getText().trim().toLowerCase().equals("username")||
                usernamefiled.getText().trim().toLowerCase().equals(""))
        {
            usernamefiled.setText("username");
            usernamefiled.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_usernamefiledFocusLost

    private void passwordfiledFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordfiledFocusGained
        // clear text if text = 'pasword'
        
        String passwordd = String.valueOf(passwordfiled.getPassword());
        if(passwordd.trim().toLowerCase().equals("password")){
            passwordfiled.setText("");
            passwordfiled.setForeground(Color.black);
        }
    }//GEN-LAST:event_passwordfiledFocusGained

    private void passwordfiledFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordfiledFocusLost
        // TODO add your handling code here:
        
        String passwordd = String.valueOf(passwordfiled.getPassword());
        if(passwordd.trim().toLowerCase().equals("username")||
                passwordd.trim().toLowerCase().equals(""))
        {
            passwordfiled.setText("password");
            passwordfiled.setForeground(new Color(153,153,153));
        } 
    }//GEN-LAST:event_passwordfiledFocusLost

    private void jCheckBox_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_passwordActionPerformed
        // TO show the password 
        if(jCheckBox_password.isSelected())
            {
                passwordfiled.setEchoChar((char)0);
            }
        else
            {
                passwordfiled.setEchoChar('#');
            } 
    }//GEN-LAST:event_jCheckBox_passwordActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(For_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(For_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(For_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(For_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new For_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton jButton_Login;
    private javax.swing.JCheckBox jCheckBox_password;
    private javax.swing.JLabel jLabel_Close;
    private javax.swing.JLabel jLabel_Logo;
    private javax.swing.JLabel jLabel_title;
    private javax.swing.JLabel jLabel_user;
    private javax.swing.JLabel jLabel_user1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField passwordfiled;
    private javax.swing.JTextField usernamefiled;
    // End of variables declaration//GEN-END:variables
}
