package java_car_rental;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fanos
 */
public class Form_Brands extends javax.swing.JFrame {

    /**
     * Creates new form Form_Brands
     */
    Classes.Brand_Cls brand = new Classes.Brand_Cls();
    ArrayList<Classes.Brand_Cls> brands_list = brand.brandList();
    int index = 0;
    
    Border white_border  = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
     Border empty_border  = BorderFactory.createMatteBorder(1, 1, 1, 1, new  Color( 0,102,102 ));
     
    public Form_Brands() {
        initComponents();
        
        // center the form
        this.setLocationRelativeTo(null);
        
        // populates JTable
        populateJtableWithBrand();
        
        
    }
    
        public void displayimages(int width, int height,String image_path,JLabel label)
    {// get the images
        
        ImageIcon imageIcon = new ImageIcon(image_path);
        // resize the image
        Image image = imageIcon.getImage().getScaledInstance(width, height,  Image.SCALE_SMOOTH);
        // set the image into the jlabel
        label.setIcon(new ImageIcon(image));
    }
    
            public void displayByteImage(int width, int height,byte[] image_byte,JLabel label)
    {
        // get the images
        
        ImageIcon imageIcon = new ImageIcon(image_byte);
        // resize the image
        Image image = imageIcon.getImage().getScaledInstance(width, height,  Image.SCALE_SMOOTH);
        // set the image into the jlabel
        label.setIcon(new ImageIcon(image));
    }    

            // create a function to  select an image
            // the function will return the image path 
    public String selectImage(){
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select Picture");
        
        fileChooser.setCurrentDirectory(new File("C:\\Users\\fanos\\OneDrive\\Pictures\\CAR LOGOS"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("image","png","jpg");
        fileChooser.addChoosableFileFilter(filter);
        
        int state = fileChooser.showSaveDialog(null);
        String path = "";
        
        if(state== JFileChooser.APPROVE_OPTION){
            path = fileChooser.getSelectedFile().getAbsolutePath();
        }
        
        return path;
    }
    
    // create a function to populate the Table with brand (id and name)
    public void populateJtableWithBrand(){
        
        // clear array list 
        brands_list.clear();
        //populate arraylist
        brands_list = brand.brandList();
        // jtabel columns
        
        String [] columnsName = {"Id","Name"};        
        
        // jtable rows
        
        Object[][] rows = new Object[brands_list.size()][columnsName.length];
        
        for(int i = 0;i < brands_list.size();i++){
            
            rows[i][0] = brands_list.get(i).getId();
            rows[i][1] = brands_list.get(i).getName();
        }
        
        DefaultTableModel model = new DefaultTableModel(rows,columnsName);
        
        Table_Brands.setModel(model);
    }
    
    // function to dispay brand
    public void dispalyBrands(){
        
        Classes.Brand_Cls selected_brand = brands_list.get(index);
        jSpinner_logo_Id.setValue(selected_brand.getId());
        Textfiledbrand_name.setText(selected_brand.getName());
         displayByteImage(brand_logol.getWidth(),brand_logol.getHeight(),selected_brand.getLogo(),brand_logol);
        
    }
    
    //Functon to check Empty Fields
    public boolean verify(String add_or_edit)
    {
        String name = Textfiledbrand_name.getText();
        String pc_path = lbl_image_path.getText();
        boolean val = false;
        
        if(!name.trim().equals("" ))
        {
            if("add".equals(add_or_edit))
            {
                if(pc_path.trim().equals(""))
                {
                   JOptionPane.showMessageDialog(null, "Enter Valid Brand Data","Invalid Info",2);
                   val = false;
                }
                else
                {
                    val = true;
                }
            }
            if("edit".equals(add_or_edit))
            {
                if(brand_logol.getIcon() == null)
                {
                    JOptionPane.showMessageDialog(null, "Enter Valid Brand Data to edit","Invalid Info",2);
                    val = false;
                }
                else
                {
                  val = true;
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Enter Valid Brand Data","Invalid Info",2);
            val = false;
        }
        return val;
    }   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lbl_brands_logo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel_close = new javax.swing.JLabel();
        jLabel_for_back = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Brands = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        int max = 10000;
        int min = 0;
        int step = 1;
        int i = 0;
        SpinnerModel spinner_model = new SpinnerNumberModel(i,min,max,step);
        jSpinner_logo_Id = new javax.swing.JSpinner(spinner_model );
        Textfiledbrand_name = new javax.swing.JTextField();
        brand_logol = new javax.swing.JLabel();
        Button_browse = new javax.swing.JButton();
        Button_add = new javax.swing.JButton();
        Button_edit = new javax.swing.JButton();
        Button_remove = new javax.swing.JButton();
        Button_Previous = new javax.swing.JButton();
        Button_Next = new javax.swing.JButton();
        Button_Frist = new javax.swing.JButton();
        Button_Last = new javax.swing.JButton();
        lbl_image_path = new javax.swing.JLabel();
        Button_refresh = new javax.swing.JButton();
        Button_clear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1080, 600));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setToolTipText("");

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        lbl_brands_logo.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 24)); // NOI18N
        lbl_brands_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_brands_logo.setText("brands log");

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 36)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Brands");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel_close.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_close.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_close.setText("x");
        jLabel_close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_closeMouseExited(evt);
            }
        });

        jLabel_for_back.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 24)); // NOI18N
        jLabel_for_back.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_for_back.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_for_back.setText("<");
        jLabel_for_back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_for_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_for_backMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_for_backMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_for_backMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel_for_back, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(lbl_brands_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(197, 197, 197)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 351, Short.MAX_VALUE)
                .addComponent(jLabel_close, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_close, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_for_back, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbl_brands_logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                .addContainerGap())
        );

        Table_Brands.setAutoCreateRowSorter(true);
        Table_Brands.setBackground(new java.awt.Color(255, 255, 255));
        Table_Brands.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 51, 0)));
        Table_Brands.setForeground(new java.awt.Color(0, 0, 0));
        Table_Brands.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Table_Brands.setFocusTraversalPolicyProvider(true);
        Table_Brands.setGridColor(new java.awt.Color(0, 0, 0));
        Table_Brands.setInheritsPopupMenu(true);
        Table_Brands.setSelectionBackground(new java.awt.Color(153, 153, 153));
        Table_Brands.setSelectionForeground(new java.awt.Color(0, 0, 0));
        Table_Brands.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_BrandsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table_Brands);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("ID:");

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Name:");

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Logo:");

        jSpinner_logo_Id.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 16)); // NOI18N
        jSpinner_logo_Id.setPreferredSize(new java.awt.Dimension(20, 32));

        Textfiledbrand_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Textfiledbrand_nameActionPerformed(evt);
            }
        });

        brand_logol.setBackground(new java.awt.Color(153, 153, 153));
        brand_logol.setForeground(new java.awt.Color(0, 153, 153));
        brand_logol.setOpaque(true);

        Button_browse.setText("Browse");
        Button_browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_browseActionPerformed(evt);
            }
        });

        Button_add.setBackground(new java.awt.Color(29, 209, 161));
        Button_add.setForeground(new java.awt.Color(0, 0, 0));
        Button_add.setText("Add");
        Button_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_addActionPerformed(evt);
            }
        });

        Button_edit.setBackground(new java.awt.Color(29, 209, 161));
        Button_edit.setForeground(new java.awt.Color(0, 0, 0));
        Button_edit.setText("Edit");
        Button_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_editActionPerformed(evt);
            }
        });

        Button_remove.setBackground(new java.awt.Color(29, 209, 161));
        Button_remove.setForeground(new java.awt.Color(0, 0, 0));
        Button_remove.setText("Remove");
        Button_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_removeActionPerformed(evt);
            }
        });

        Button_Previous.setBackground(new java.awt.Color(29, 209, 161));
        Button_Previous.setForeground(new java.awt.Color(0, 0, 0));
        Button_Previous.setText(">");
        Button_Previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_PreviousActionPerformed(evt);
            }
        });

        Button_Next.setBackground(new java.awt.Color(29, 209, 161));
        Button_Next.setForeground(new java.awt.Color(0, 0, 0));
        Button_Next.setText("<");
        Button_Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_NextActionPerformed(evt);
            }
        });

        Button_Frist.setBackground(new java.awt.Color(29, 209, 161));
        Button_Frist.setForeground(new java.awt.Color(0, 0, 0));
        Button_Frist.setText("<<");
        Button_Frist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_FristActionPerformed(evt);
            }
        });

        Button_Last.setBackground(new java.awt.Color(29, 209, 161));
        Button_Last.setForeground(new java.awt.Color(0, 0, 0));
        Button_Last.setText(">>");
        Button_Last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_LastActionPerformed(evt);
            }
        });

        lbl_image_path.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Button_refresh.setBackground(new java.awt.Color(29, 209, 161));
        Button_refresh.setForeground(new java.awt.Color(0, 0, 0));
        Button_refresh.setText("Refresh");
        Button_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_refreshActionPerformed(evt);
            }
        });

        Button_clear.setBackground(new java.awt.Color(29, 209, 161));
        Button_clear.setForeground(new java.awt.Color(0, 0, 0));
        Button_clear.setText("Clear");
        Button_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSpinner_logo_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Textfiledbrand_name, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(brand_logol, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(154, 154, 154)
                            .addComponent(Button_browse, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGap(55, 55, 55)
                            .addComponent(lbl_image_path, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Button_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Button_add, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Button_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Button_remove, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Button_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Button_Frist, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Button_Previous, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Button_Next, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Button_Last, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(50, 50, 50))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner_logo_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Textfiledbrand_name, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(brand_logol, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(lbl_image_path)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Button_browse))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Frist)
                    .addComponent(Button_Previous)
                    .addComponent(Button_Last)
                    .addComponent(Button_add)
                    .addComponent(Button_edit)
                    .addComponent(Button_remove)
                    .addComponent(Button_Next))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_refresh)
                    .addComponent(Button_clear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_browseActionPerformed
        // browse and dispaly image
        
        String imagePath = selectImage();
        displayimages(brand_logol.getWidth(),brand_logol.getHeight(),imagePath,brand_logol);
        // display the image path
        
        lbl_image_path.setText(imagePath);
        
    }//GEN-LAST:event_Button_browseActionPerformed

    private void Button_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_addActionPerformed
        // add new brand 
        try {
            String name = Textfiledbrand_name.getText();
            byte[] logo;
            logo = Files.readAllBytes(Paths.get(lbl_image_path.getText()));
            
            if(verify("add"))
            {
                Classes.Brand_Cls brand = new Classes.Brand_Cls();
                brand.addBrand(name,logo);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Select The Brand Logo [ "+ex+" ]","Invalid Info",2);
        }
    }//GEN-LAST:event_Button_addActionPerformed

    private void Button_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_editActionPerformed
        // edit brand
               
        try {
            int id = (int) jSpinner_logo_Id.getValue();
            String name = Textfiledbrand_name.getText();
            byte[] logo;
            if(lbl_image_path.getText().trim().equals(""))
            {
                logo = brand.getBrandById(id).getLogo();
            }
            else
            {
                logo = Files.readAllBytes(Paths.get(lbl_image_path.getText()));
            }
            if(verify("edit")){
            Classes.Brand_Cls brand = new Classes.Brand_Cls();
            try{
                brand.editBrand(id, name, logo);
            }catch (Exception ex) 
        {    
            JOptionPane.showMessageDialog(null, "Use a Smaller Size Image [ "+ex+" ]","Invalid Info",2);
        }
            
            }
            
        } catch (Exception ex) 
        {    
            JOptionPane.showMessageDialog(null, "Select The Brand Logo [ "+ex+" ]","Invalid Info",2);
        }
        
    }//GEN-LAST:event_Button_editActionPerformed

    private void Button_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_removeActionPerformed
        // remove brand  
        
        try {
            int id =  (int)jSpinner_logo_Id.getValue();
            int confirm = JOptionPane.showConfirmDialog(null, "Are You Sure You Want to Delete this Brand", "Confirm",JOptionPane.YES_NO_OPTION);
            if(confirm==JOptionPane.YES_OPTION){
                            Classes.Brand_Cls brand = new Classes.Brand_Cls();
            brand.removeBrand(id);
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Form_Brands.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Button_removeActionPerformed

    private void Button_PreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_PreviousActionPerformed
        // Button_Previous
        index --;
        if(index <  0){
            index = 0;
        }
        dispalyBrands();
    }//GEN-LAST:event_Button_PreviousActionPerformed

    private void Button_NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_NextActionPerformed
        // Button_Next
       index++;
       if(index > brands_list.size()-1){
           index = brands_list.size()-1;
       }
       dispalyBrands();
    }//GEN-LAST:event_Button_NextActionPerformed

    private void Button_FristActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_FristActionPerformed
        // TButton_Frist
         index = 0; 
        dispalyBrands();
    }//GEN-LAST:event_Button_FristActionPerformed

    private void Button_LastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_LastActionPerformed
        // Button_Last
        index = brands_list.size()-1;
        dispalyBrands();
    }//GEN-LAST:event_Button_LastActionPerformed

    private void jLabel_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeMouseClicked
        // close the form
                               int confirm = JOptionPane.showConfirmDialog(null, "Are You Sure You Want to Exit", "Confirm",JOptionPane.YES_NO_OPTION);
                if(confirm==JOptionPane.YES_OPTION)
                {
                    System.exit(0);
                }
    }//GEN-LAST:event_jLabel_closeMouseClicked

    private void jLabel_for_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_for_backMouseClicked
        // TODO add your handling code here:
        
        Form_Dashboard dashboard = new Form_Dashboard();
        dashboard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel_for_backMouseClicked

    private void Table_BrandsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_BrandsMouseClicked
        // get the selected brand 
        
        int index = Table_Brands.getSelectedRow();
        int id = Integer.valueOf(Table_Brands.getValueAt(index,0).toString());
        Classes.Brand_Cls brd = new Classes.Brand_Cls().getBrandById(id);
        jSpinner_logo_Id.setValue(brd.getId());
        Textfiledbrand_name.setText(brd.getName());
        displayByteImage(brand_logol.getWidth(),brand_logol.getHeight(),brd.getLogo(),brand_logol);
        
    }//GEN-LAST:event_Table_BrandsMouseClicked

    private void Button_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_refreshActionPerformed
        // To refresh the Table
        populateJtableWithBrand();
    }//GEN-LAST:event_Button_refreshActionPerformed

    private void Button_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_clearActionPerformed
        // TO clear fields
        jSpinner_logo_Id.setValue(0);
        Textfiledbrand_name.setText("");
        brand_logol.setIcon(null);
        lbl_image_path.setText("");
    }//GEN-LAST:event_Button_clearActionPerformed

    private void Textfiledbrand_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Textfiledbrand_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Textfiledbrand_nameActionPerformed

    private void jLabel_for_backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_for_backMouseEntered
        // TODO add your handling code here:
        jLabel_for_back.setBorder(white_border);
    }//GEN-LAST:event_jLabel_for_backMouseEntered

    private void jLabel_for_backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_for_backMouseExited
        // TODO add your handling code here:
        jLabel_for_back.setBorder(empty_border);
    }//GEN-LAST:event_jLabel_for_backMouseExited

    private void jLabel_closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeMouseEntered
        // TODO add your handling code here:
        jLabel_close.setBorder(white_border);
    }//GEN-LAST:event_jLabel_closeMouseEntered

    private void jLabel_closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeMouseExited
        // TODO add your handling code here:
        jLabel_close.setBorder(empty_border);
    }//GEN-LAST:event_jLabel_closeMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form_Brands.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Brands.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Brands.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Brands.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Brands().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Frist;
    private javax.swing.JButton Button_Last;
    private javax.swing.JButton Button_Next;
    private javax.swing.JButton Button_Previous;
    private javax.swing.JButton Button_add;
    private javax.swing.JButton Button_browse;
    private javax.swing.JButton Button_clear;
    private javax.swing.JButton Button_edit;
    private javax.swing.JButton Button_refresh;
    private javax.swing.JButton Button_remove;
    private javax.swing.JTable Table_Brands;
    private javax.swing.JTextField Textfiledbrand_name;
    private javax.swing.JLabel brand_logol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_close;
    private javax.swing.JLabel jLabel_for_back;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner_logo_Id;
    private javax.swing.JLabel lbl_brands_logo;
    private javax.swing.JLabel lbl_image_path;
    // End of variables declaration//GEN-END:variables
}
