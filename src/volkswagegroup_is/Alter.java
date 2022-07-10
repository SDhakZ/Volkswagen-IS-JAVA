/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package volkswagegroup_is;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author OMEN
 */
public class Alter extends javax.swing.JFrame {
DefaultTableModel model;
    /**
     * Creates new form GuiLists
     */
     String [][] vehicle;   
     
    public Alter() throws FileNotFoundException, IOException, ClassNotFoundException, InstantiationException, UnsupportedLookAndFeelException, IllegalAccessException {
        initComponents();
        
        
        model = new DefaultTableModel() {
            
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        table.setModel(model);//setting the table model
        table.getTableHeader().setResizingAllowed(false);//making table headers unresizable
        
        //adding columns in the model
        model.addColumn("     S.N.");
        model.addColumn("Vehicle Name");
        model.addColumn("Vehicle Brand");
        model.addColumn("Type");
        model.addColumn("Fuel type");
        model.addColumn("Genre");
        model.addColumn("Production");
        model.addColumn("Safety Rating");
        model.addColumn("Price ($)");
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER );
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);//setting the alignment of first column to center  
        
        
        //Setting the widths of the columns of the table
        table.getColumnModel().getColumn(0).setPreferredWidth(15);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        table.getColumnModel().getColumn(2).setPreferredWidth(60);
        table.getColumnModel().getColumn(3).setPreferredWidth(20);
        table.getColumnModel().getColumn(4).setPreferredWidth(35);
        table.getColumnModel().getColumn(5).setPreferredWidth(40);
        table.getColumnModel().getColumn(6).setPreferredWidth(50);
       //table.getColumnModel().getColumn(7).setPreferredWidth(20);
        
        //Setting the size and font of table header
        JTableHeader header = table.getTableHeader();
        header.setPreferredSize(new Dimension(100, 40));
        table.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,16));
        table.setRowHeight(40);
        
        
        //Setting action commmands to radio buttons
        Svname.setActionCommand("Vehicle Name");
        Sprice.setActionCommand("Price");
        bike.setActionCommand("Bike");
        car.setActionCommand("Car");
        
        
        FileInputStream fins = new FileInputStream(new File("vehicle_info.xlsx"));
        XSSFWorkbook wb = new XSSFWorkbook(fins);//getting the workbook at file path "vehicle_info.xlsx"
        XSSFSheet sheet = wb.getSheetAt(0);//getting the first sheet of wb
        FormulaEvaluator fmEval = wb.getCreationHelper().createFormulaEvaluator();
        
        vehicle = new String[sheet.getLastRowNum()][8];
        int r = 0;
        int c = -1;
        //looping all the rows of the sheet
        for(Row row : sheet)
        {
            if(c != -1)
            {
                model.addRow(new Object[]{});//adding the rows in the table model
                model.setValueAt(r+1, r, 0);
                
                //looping all the data in the cells of a row
                for(Cell cell : row)
                {
                    
                    switch(fmEval.evaluateInCell(cell).getCellTypeEnum())//calculating the formula and getting the data type of the cell
                    {
                        
                        case NUMERIC -> {
                            model.setValueAt(cell.getNumericCellValue() + "", r, c);//getting the value from the cell and adding in the table
                            vehicle[r][c-1] = cell.getNumericCellValue() + "";
                        }
                        
                        case STRING -> {
                            model.setValueAt(cell.getStringCellValue(), r, c);//getting the value from the cell and adding in the table
                            vehicle[r][c-1] = cell.getStringCellValue();
                        }
                    }
                    c++;
                }
                r++;
            }
            c = 1;
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        group = new javax.swing.ButtonGroup();
        searchBy = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        Searchbar = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        prod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        vname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        brand = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        genre = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        rating = new javax.swing.JTextField();
        price = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Clear = new javax.swing.JButton();
        Add = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        car = new javax.swing.JRadioButton();
        bike = new javax.swing.JRadioButton();
        ftype = new javax.swing.JComboBox<>();
        sort = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        SearchAdmin = new javax.swing.JButton();
        Sbrand = new javax.swing.JComboBox<>();
        Sgenre = new javax.swing.JComboBox<>();
        Remove = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        backadmin = new javax.swing.JToggleButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Svname = new javax.swing.JRadioButton();
        Sprice = new javax.swing.JRadioButton();
        viewAll = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Open = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        About = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1080, 753));

        jScrollPane1.setBackground(new java.awt.Color(102, 153, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setViewportBorder(new javax.swing.border.MatteBorder(null));

        table.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 51, 204)));
        table.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "S.N.", "Vehicle Name", "Vehicle Brand", "Type", "Fuel type", "Genre", "Production", "Safety rating", "Price ($)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        table.setFocusable(false);
        table.setGridColor(new java.awt.Color(21, 112, 173));
        table.setInheritsPopupMenu(true);
        table.setRowHeight(30);
        table.setSelectionBackground(new java.awt.Color(0, 153, 204));
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table.setShowGrid(true);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
            table.getColumnModel().getColumn(4).setResizable(false);
            table.getColumnModel().getColumn(5).setResizable(false);
            table.getColumnModel().getColumn(6).setResizable(false);
            table.getColumnModel().getColumn(7).setResizable(false);
            table.getColumnModel().getColumn(8).setResizable(false);
        }

        Searchbar.setBackground(new java.awt.Color(51, 51, 51));
        Searchbar.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        Searchbar.setForeground(new java.awt.Color(255, 255, 255));
        Searchbar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Searchbar.setText("Search");
        Searchbar.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255)));
        Searchbar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SearchbarFocusGained(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(8, 18, 38));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 102)), "Add Vehicle", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24), new java.awt.Color(102, 255, 255))); // NOI18N

        prod.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Total Production");

        vname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Vehicle Name");

        brand.setBackground(new java.awt.Color(204, 204, 204));
        brand.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        brand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Volkswagen", "Cupra", "Skoda", "Audi", "Lamborghini", "Ducati", "Bentley", "Bugatti", "Porche" }));
        brand.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 102), new java.awt.Color(0, 0, 255), null, null));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Brand ");

        genre.setBackground(new java.awt.Color(204, 204, 204));
        genre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        genre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sports", "Luxury", "Volume", "Adventure" }));
        genre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 102), new java.awt.Color(51, 51, 255), null, null));
        genre.setPreferredSize(new java.awt.Dimension(144, 31));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Genre");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Fuel Type");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Safety Rating");

        rating.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        price.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Price ($)");

        Clear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Clear.setText("CLEAR");
        Clear.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 204, 204), null, null));
        Clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ClearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ClearMouseExited(evt);
            }
        });
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        Add.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pics/pluss.png"))); // NOI18N
        Add.setText("ADD");
        Add.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 204, 0), null, null));
        Add.setIconTextGap(-4);
        Add.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Pics/plus entered.png"))); // NOI18N
        Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddMouseExited(evt);
            }
        });
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Vehicle Type");

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        group.add(car);
        car.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        car.setForeground(new java.awt.Color(255, 255, 255));
        car.setText("Car");
        car.setContentAreaFilled(false);

        group.add(bike);
        bike.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bike.setForeground(new java.awt.Color(255, 255, 255));
        bike.setText("Bike");
        bike.setContentAreaFilled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(car, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bike)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(car)
                    .addComponent(bike))
                .addContainerGap())
        );

        ftype.setBackground(new java.awt.Color(204, 204, 204));
        ftype.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ftype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Petrol", "Diesel", "Electric", "Hybrid" }));
        ftype.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 102), new java.awt.Color(0, 0, 255), null, null));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rating, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prod, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(brand, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(genre, 0, 162, Short.MAX_VALUE)
                                        .addComponent(vname))
                                    .addComponent(ftype, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vname, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(brand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(10, 10, 10)))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ftype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prod, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(rating, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        sort.setBackground(new java.awt.Color(204, 204, 204));
        sort.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default(Sort)", "A-Z", "Z-A", "Price (H to L)", "Price (L to H)", "Rating (H to L)" }));
        sort.setToolTipText("Select to Sort the list in following options");
        sort.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 51, 102), new java.awt.Color(0, 0, 255), null, null));
        sort.setLightWeightPopupEnabled(false);
        sort.setMinimumSize(new java.awt.Dimension(144, 31));
        sort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pics/vwlogo_00000.png"))); // NOI18N
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel4.setIconTextGap(0);

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Volkswagen Group Information System");

        SearchAdmin.setBackground(new java.awt.Color(51, 51, 51));
        SearchAdmin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SearchAdmin.setForeground(new java.awt.Color(255, 255, 255));
        SearchAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pics/search white.png"))); // NOI18N
        SearchAdmin.setText("Search");
        SearchAdmin.setIconTextGap(3);
        SearchAdmin.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Pics/search_00000.png"))); // NOI18N
        SearchAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SearchAdminMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SearchAdminMouseExited(evt);
            }
        });
        SearchAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchAdminActionPerformed(evt);
            }
        });

        Sbrand.setBackground(new java.awt.Color(204, 204, 204));
        Sbrand.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Sbrand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All (Brand)", "Volkswagen", "Cupra", "Skoda", "Audi", "Lamborghini", "Ducati", "Bentley", "Bugatti", "Porsche" }));
        Sbrand.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 102), new java.awt.Color(0, 0, 255), null, null));
        Sbrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SbrandActionPerformed(evt);
            }
        });

        Sgenre.setBackground(new java.awt.Color(204, 204, 204));
        Sgenre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Sgenre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All (Genre)", "Sports", "Luxury", "SUV", "Adventure" }));
        Sgenre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 102), new java.awt.Color(51, 51, 255), null, null));
        Sgenre.setPreferredSize(new java.awt.Dimension(144, 31));
        Sgenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SgenreActionPerformed(evt);
            }
        });

        Remove.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pics/Remove.png"))); // NOI18N
        Remove.setText("REMOVE");
        Remove.setIconTextGap(10);
        Remove.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Pics/remove opened.png"))); // NOI18N
        Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RemoveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RemoveMouseExited(evt);
            }
        });
        Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveActionPerformed(evt);
            }
        });

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pics/brandlogoe.png"))); // NOI18N

        backadmin.setBackground(new java.awt.Color(204, 204, 204));
        backadmin.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        backadmin.setForeground(new java.awt.Color(0, 102, 153));
        backadmin.setText("<- Home");
        backadmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backadminMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backadminMouseExited(evt);
            }
        });
        backadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backadminActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 102, 102));
        jLabel11.setText("Admin");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Search by:");

        searchBy.add(Svname);
        Svname.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Svname.setForeground(new java.awt.Color(0, 255, 255));
        Svname.setSelected(true);
        Svname.setText("Vehicle Name");
        Svname.setContentAreaFilled(false);
        Svname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SvnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                SvnameFocusLost(evt);
            }
        });

        searchBy.add(Sprice);
        Sprice.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Sprice.setForeground(new java.awt.Color(255, 255, 255));
        Sprice.setText("Price");
        Sprice.setContentAreaFilled(false);
        Sprice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SpriceFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                SpriceFocusLost(evt);
            }
        });

        viewAll.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        viewAll.setForeground(new java.awt.Color(255, 255, 255));
        viewAll.setText("View All");
        viewAll.setContentAreaFilled(false);
        viewAll.setMargin(new java.awt.Insets(2, 14, 2, 0));
        viewAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewAllMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewAllMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                viewAllMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                viewAllMouseReleased(evt);
            }
        });
        viewAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1005, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Svname)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Sprice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(viewAll))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Searchbar, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SearchAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sort, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Sgenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Sbrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 12, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 207, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addGap(73, 73, 73))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(Remove, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backadmin, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 1335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel11)
                        .addGap(28, 28, 28)
                        .addComponent(backadmin, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Remove, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Searchbar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Sbrand, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Sgenre, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(sort, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Svname)
                            .addComponent(Sprice)
                            .addComponent(jLabel12)
                            .addComponent(viewAll, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuBar1.setMinimumSize(new java.awt.Dimension(64, 30));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(64, 30));

        jMenu1.setText("File");

        Open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        Open.setText("Open");
        Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenActionPerformed(evt);
            }
        });
        jMenu1.add(Open);

        Exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        jMenu1.add(Exit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");

        About.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        About.setText("About");
        About.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutActionPerformed(evt);
            }
        });
        jMenu2.add(About);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1383, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
    * Method for sorting the data based on vehicle brand
    */
    private void SbrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SbrandActionPerformed
        // TODO add your handling code here:
        
        model.setRowCount(0);
        //Displaying data of all brands.
        if(Sbrand.getSelectedItem().equals("All (Brand)"))
        {
            model.setRowCount(0);
            int r = 0;
            for(String[] c : vehicle)
            {
                int col = 1;
                model.addRow(new Object[]{});
                model.setValueAt(r+1, r, 0);
                for(String data : c)
                {
                    model.setValueAt(data, r, col);
                    col++;
                }
                r++;
            }
            sort.setSelectedIndex(0);
            Sgenre.setSelectedIndex(0);
        }
        else
        {
            int r = 0;
            //looping the data of all the vehicles
            for(String[] c : vehicle)
            {
                int col = 1;
                //Sorting and displaying the data of Lamborghini brand
                if(c[1].equals("Lamborghini") && Sbrand.getSelectedItem().equals("Lamborghini"))
                {
                    model.addRow(new Object[]{});
                    model.setValueAt(r+1, r, 0);
                    for(String data : c)
                    {
                        model.setValueAt(data, r, col);
                        col++;
                    }
                    r++;
                }
                
                //Sorting and displaying the data of Volkswagen brand
                else if(c[1].equals("Volkswagen") && Sbrand.getSelectedItem().equals("Volkswagen"))
                {
                    model.addRow(new Object[]{});
                    //new Lists().addData(r, col,c);
                    model.setValueAt(r+1, r, 0);
                    for(String data : c)
                    {
                        model.setValueAt(data, r, col);
                        col++;
                    }
                    r++;
                }
                
                //Sorting and displaying the data of Cupra brand
                else if(c[1].equals("Cupra") && Sbrand.getSelectedItem().equals("Cupra"))
                {
                    model.addRow(new Object[]{});
                    model.setValueAt(r+1, r, 0);
                    for(String data : c)
                    {
                        model.setValueAt(data, r, col);
                        col++;
                    }
                    r++;
                }
                
                //Sorting and displaying the data of Skoda brand
                else if(c[1].equals("Skoda") && Sbrand.getSelectedItem().equals("Skoda"))
                {
                    model.addRow(new Object[]{});
                    model.setValueAt(r+1, r, 0);
                    for(String data : c)
                    {
                        model.setValueAt(data, r, col);
                        col++;
                    }
                    r++;
                }
                
                //Sorting and displaying the data of Audi brand
                else if(c[1].equals("Audi") && Sbrand.getSelectedItem().equals("Audi"))
                {
                    model.addRow(new Object[]{});
                    model.setValueAt(r+1, r, 0);
                    for(String data : c)
                    {
                        model.setValueAt(data, r, col);
                        col++;
                    }
                    r++;
                }
                
                //Sorting and displaying the data of Ducati brand
                else if(c[1].equals("Ducati") && Sbrand.getSelectedItem().equals("Ducati"))
                {
                    model.addRow(new Object[]{});
                    model.setValueAt(r+1, r, 0);
                    for(String data : c)
                    {
                        model.setValueAt(data, r, col);
                        col++;
                    }
                    r++;
                }
                
                //Sorting and displaying the data of Bentley brand
                else if(c[1].equals("Bentley") && Sbrand.getSelectedItem().equals("Bentley"))
                {
                    model.addRow(new Object[]{});
                    model.setValueAt(r+1, r, 0);
                    for(String data : c)
                    {
                        model.setValueAt(data, r, col);
                        col++;
                    }
                    r++;
                }
                
                //Sorting and displaying the data of Bugatti brand
                else if(c[1].equals("Bugatti") && Sbrand.getSelectedItem().equals("Bugatti"))
                {
                    model.addRow(new Object[]{});
                    model.setValueAt(r+1, r, 0);
                    for(String data : c)
                    {
                        model.setValueAt(data, r, col);
                        col++;
                    }
                    r++;
                }
                
                //Sorting and displaying the data of Porsche brand
                else if(c[1].equals("Porsche") && Sbrand.getSelectedItem().equals("Porsche"))
                {
                    model.addRow(new Object[]{});
                    model.setValueAt(r+1, r, 0);
                    for(String data : c)
                    {
                        model.setValueAt(data, r, col);
                        col++;
                    }
                    r++;
                }
            }
        }            
    }//GEN-LAST:event_SbrandActionPerformed

    /*
    * Method for searching the data based on vehicle name and price.
    */
    private void SearchAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchAdminActionPerformed
        // TODO add your handling code here:'
        //Searching the data based on Vehicle Name
        if(searchBy.getSelection().getActionCommand().equals("Vehicle Name"))
        {
            int ct = 0;
            //looping the data of all the vehicles
            for(String[] c : vehicle)
            {
                //comparing the vehicle names
                if(Searchbar.getText().toLowerCase().equals(c[0].toLowerCase()))
                {
                    ct = 1;
                    int i = 1;
                    JOptionPane.showMessageDialog(rootPane,"Vehicle match found.");
                    model.setRowCount(1);
                    //Writing the data of the searched vehicle in the table
                    for(String data : c)
                    {  
                        table.setValueAt(data , 0 , i);
                        i++;
                    }
                    break;
                }
            }
            
            //Dialog Box to be shown when the vehicle name searched is not found
            if(ct == 0)
            {
                JOptionPane.showMessageDialog(rootPane, "There is no vehicle with name " + Searchbar.getText(), "Alert", JOptionPane.ERROR_MESSAGE);    
            }
        }
        
        //Searching the data based on Price
        else if(searchBy.getSelection().getActionCommand().equals("Price"))
        {
            double[] prices = new double[vehicle.length];
            int i = 0;
            //Storing prices of vehicles in an array
            for(String[] c1 : vehicle)
            { 
                prices[i] = Double.parseDouble(c1[7]);
                i++;
            }
            
            //Sorting the prices of the vehicles
            for(i = 0 ; i < prices.length-1 ; i++)
            {
                int min = i;
                for(int j = i + 1 ; j < prices.length ; j++)
                {
                    if(prices[min] > prices[j])
                    {
                        min = j;
                    }    
                }
                if(i != min)
                {
                    Double a = prices[i];
                    prices[i] = prices[min];
                    prices[min] = a;
                }        
            }
            
            //Searching the vehicle
            int start = 0;
            int end = prices.length-1;
            try
            {
                int sval = Integer.parseInt(Searchbar.getText());
                int ct = 0;
                while(start <= end)
                {
                    int mid = (start + end) / 2;
                    if(sval == prices[mid])
                    {
                        int col = 1;
                        //looping the data of all vehicles
                        for(String[] c : vehicle)
                        {
                            //comparing the prices of vehicles
                            if(sval == Double.parseDouble(c[7]))
                            {
                                JOptionPane.showMessageDialog(rootPane, "The vehicle " + c[0] + " matches the price that has been searched.", "Info", JOptionPane.INFORMATION_MESSAGE);
                                model.setRowCount(1);
                                ct = 1;
                                //Writing the data of searched vehicle in the table
                                for(String data : c)
                                {
                                    table.setValueAt(data, 0, col);
                                    col++;
                                }
                                break;
                            }
                        }
                        break;
                    }
                    else if(sval < prices[mid])
                    {
                        end = mid - 1;
                    }
                    else
                    {
                        start = mid + 1;
                    }
                }
                
                //Dialog Box to be shown when there is no vehicle with the price that is searched
                if(ct == 0)
                {
                    JOptionPane.showMessageDialog(rootPane, "There is no vehicle of price $" + sval , "Alert", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch(NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(rootPane, "Please enter a number in the search textfield." , "Alert", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_SearchAdminActionPerformed
    /*
    * Method for changing the property of search button when mouse enters the hover area of it.
    */
    private void SearchAdminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchAdminMouseEntered
        // TODO add your handling code here:
        SearchAdmin.setBackground(new Color(123, 182, 201));
    }//GEN-LAST:event_SearchAdminMouseEntered
    /*
    * Method for changing the property of search button when mouse leaves the hover area of it.
    */
    private void SearchAdminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchAdminMouseExited
        // TODO add your handling code here:
        SearchAdmin.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_SearchAdminMouseExited
    /*
    * Method for changing the property of remove button when mouse enters the hover area of it.
    */
    private void RemoveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveMouseEntered
        // TODO add your handling code here:
        Remove.setForeground(Color.red);
    }//GEN-LAST:event_RemoveMouseEntered
    /*
    * Method for changing the property of remove button when mouse leaves the hover area of it.
    */
    private void RemoveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveMouseExited
        // TODO add your handling code here:
        Remove.setForeground(Color.black);
    }//GEN-LAST:event_RemoveMouseExited
    /*
    * Method for changing the property of clear button when mouse enters the hover area of it.
    */
    private void ClearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearMouseEntered
        // TODO add your handling code here:
        Clear.setForeground(new Color(74,145,168));
    }//GEN-LAST:event_ClearMouseEntered
    /*
    * Method for changing the property of clear button when mouse leaves the hover area of it.
    */
    private void ClearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearMouseExited
        // TODO add your handling code here:
        Clear.setForeground(Color.black);
    }//GEN-LAST:event_ClearMouseExited
    /*
    * Method for changing the property of add button when mouse enters the hover area of it.
    */
    private void AddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMouseEntered
        // TODO add your handling code here:
        Add.setForeground(new Color(49, 133, 91));
    }//GEN-LAST:event_AddMouseEntered
    /*
    * Method for changing the property of add button when mouse leaves the hover area of it.
    */
    private void AddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMouseExited
        // TODO add your handling code here:
        Add.setForeground(Color.black);
    }//GEN-LAST:event_AddMouseExited
    /*
    * Method for changing the property of home button when mouse enters the hover area of it.
    */
    private void backadminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backadminMouseEntered
        // TODO add your handling code here:
        backadmin.setBackground(new Color(133, 149, 255));
        backadmin.setForeground(Color.white);
    }//GEN-LAST:event_backadminMouseEntered
    /*
    * Method for changing the property of home button when mouse leaves the hover area of it.
    */
    private void backadminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backadminMouseExited
        // TODO add your handling code here:
        backadmin.setBackground(new Color(204,204,204));
        backadmin.setForeground(new Color(0,102,153));
    }//GEN-LAST:event_backadminMouseExited
    /*
    * Method for closing the current frame and opening the admin frame.
    */
    private void backadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backadminActionPerformed
        // TODO add your handling code here:
        close();
        Admin homeAd = new Admin();
        homeAd.setVisible(true);
    }//GEN-LAST:event_backadminActionPerformed
    /*
    * Method for adding the data of vehicles
    */
    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        String arr[] = new String[table.getRowCount()];
        
        //storing the value of vehicle names in an array
        for(int i = 0 ; i < table.getRowCount() ; i++)
        {
            arr[i] = (table.getValueAt(i, 1)+"").toLowerCase();
        }
        
        int c = 0;
        //validation when the add button is pressed
        if(vname.getText().isEmpty() || prod.getText().isEmpty() || rating.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane, "Please fill in all the fields.", "Alert", JOptionPane.ERROR_MESSAGE);
            c = 1;
        }
        else if(!rating.getText().toUpperCase().equals("A") && !rating.getText().toUpperCase().equals("B") && !rating.getText().toUpperCase().equals("C") && !rating.getText().toUpperCase().equals("D"))
        {
            JOptionPane.showMessageDialog(rootPane, "Please enter a valid grade in safety rating textfield.", "Alert", JOptionPane.ERROR_MESSAGE);
            c = 1;
        }
        
        if (c == 0)
        {
            try
            {
                Double.parseDouble(price.getText());
                try
                {
                    Double.parseDouble(prod.getText());
                    try
                    {
                        group.getSelection().getActionCommand();   
                    }
                    catch(NullPointerException ex)
                    {
                        JOptionPane.showMessageDialog(rootPane, "Please select a vehicle type.", "Alert", JOptionPane.ERROR_MESSAGE);
                        c = 1;
                    }
                }
                catch(NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(rootPane, "Please enter a number in the production textfield.", "Alert", JOptionPane.ERROR_MESSAGE);
                    c = 1;
                }
            }
            catch(NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(rootPane, "Please enter a number in the price textfield.", "Alert", JOptionPane.ERROR_MESSAGE);
                c = 1;
            }
        }
        
        if (c == 0)
        {
            //looping the vehicle names
            for(String vclnames : arr)
            {
                //Checking if the vehicle is already in the table
                if(vname.getText().toLowerCase().equals(vclnames))
                {
                    JOptionPane.showMessageDialog(rootPane, "The vehicle you're trying to add is already in the list.", "Alert", JOptionPane.ERROR_MESSAGE);
                    c = 1;
                    break;
                }
            }
        }
        
        if (c == 0)
        {
            try
            {
                // TODO add your handling code here:
                int sn = (Integer) model.getValueAt(model.getRowCount()-1,0);//Getting the serial number of the last vehicle in the list
                String path = "vehicle_info.xlsx";
                FileInputStream inputStream = new FileInputStream(new File(path));
                Workbook workbook = WorkbookFactory.create(inputStream);
                Sheet sheet1 = workbook.getSheetAt(0);
                
                Object[] vdetails = {vname.getText(),brand.getSelectedItem(), group.getSelection().getActionCommand(),ftype.getSelectedItem(),
                        genre.getSelectedItem(),prod.getText(),rating.getText().toUpperCase(),price.getText()};
                
                int rowCount = sheet1.getLastRowNum()+1;
                
                //Adding the vehicle details in the excel file
                Row row = sheet1.createRow(rowCount++);
                int col = 0;
                //looping the vehicle details
                for (Object data : vdetails) {
                    Cell cell = row.createCell(col++);
                    if (data instanceof String) {
                        cell.setCellValue((String) data);
                    } else if (data instanceof Integer) {
                        cell.setCellValue((Integer) data);
                    }
                }
                inputStream.close();
                try
                {
                    FileOutputStream outputStream = new FileOutputStream(path);
                    workbook.write(outputStream);
                    outputStream.close();
                    
                    //adding data in the table
                    model.addRow(new Object[]{sn+1,vname.getText(),brand.getSelectedItem(), group.getSelection().getActionCommand(),
                        ftype.getSelectedItem(), genre.getSelectedItem(),prod.getText(),rating.getText().toUpperCase(),price.getText()});
                    JOptionPane.showMessageDialog(rootPane, vname.getText() + " has been added successfully.", "Volkswagen Group IS", JOptionPane.INFORMATION_MESSAGE);
                }
                catch(FileNotFoundException ex)
                {
                    JOptionPane.showMessageDialog(rootPane, "Data couldn't be added to the excel file as it is already in use.", "Alert", JOptionPane.ERROR_MESSAGE);
                }
                workbook.close();

            }
            catch(IOException | InvalidFormatException | EncryptedDocumentException ex)
            {
                Logger.getLogger(Alter.class.getName()).log(Level.SEVERE, null, ex);
            }
       }    
    }//GEN-LAST:event_AddActionPerformed
    /*
    * Method for clearing the data of add vehicle section
    */
    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        // TODO add your handling code here:
        vname.setText("");
        brand.setSelectedIndex(0);
        group.clearSelection();
        ftype.setSelectedIndex(0);
        genre.setSelectedIndex(0);
        prod.setText("");
        rating.setText("");
        price.setText("");
    }//GEN-LAST:event_ClearActionPerformed
    /*
    * Method for removing the selected data from the table
    */
    private void RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveActionPerformed
        // TODO add your handling code here:
        try
        {
            int srow = table.getSelectedRow();
            model.removeRow(srow);
            JOptionPane.showMessageDialog(rootPane, vehicle[srow][0] + " has been successfully removed.", "Volkswagen Group IS", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(ArrayIndexOutOfBoundsException ex)
        {
            JOptionPane.showMessageDialog(rootPane, "Please select a vehicle to be removed.", "Alert", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_RemoveActionPerformed
    /*
    * Method for sorting the data of vehicles
    */
    private void sortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortActionPerformed
        // TODO add your handling code here:
        model.setRowCount(0);
        double[] prices = new double[vehicle.length];
        int i = 0;
        //storing the prices of vehicles in an array 
        for(String[] c1 : vehicle)
        {
            prices[i] = Double.parseDouble(c1[7]);
            i++;
        }
        
        //Displaying all the vehicles in default order
        if(sort.getSelectedItem().equals("Default(Sort)"))
        {
            model.setRowCount(0);
            int r = 0;
            for(String[] c : vehicle)
            {
                int col = 1;
                model.addRow(new Object[]{});
                model.setValueAt(r+1, r, 0);
                for(String data : c)
                {
                    model.setValueAt(data, r, col);
                    col++;
                }
                r++;
            }
            Sbrand.setSelectedIndex(0);
            Sgenre.setSelectedIndex(0);
        }
        
        //Sorting the vehicles based on prices High to Low
        if(sort.getSelectedItem().equals("Price (H to L)"))
        {
            for(i = 0 ; i < prices.length-1 ; i++)
            {
                int max = i;
                for(int j = i + 1 ; j < prices.length ; j++)
                {
                    if(prices[max] < prices[j])
                    {
                        max = j;
                    }
                }
                if(i != max)
                {
                    Double a = prices[i];
                    prices[i] = prices[max];
                    prices[max] = a;
                    
                }
            }  
        }
        
        
        ////Sorting the vehicles based on prices Low to High
        else if(sort.getSelectedItem().equals("Price (L to H)"))
        {
            for(i = 0 ; i < prices.length-1 ; i++)
            {
                int min = i;
                for(int j = i + 1 ; j < prices.length ; j++)
                {
                    if(prices[min] > prices[j])
                    {
                        min = j;
                    }
                }
                if(i != min)
                {
                    Double a = prices[i];
                    prices[i] = prices[min];
                    prices[min] = a;
                    
                }
            }
        }
        //Writing the sorted data in the table
        if(sort.getSelectedItem().equals("Price (H to L)") || sort.getSelectedItem().equals("Price (L to H)"))
        {
            int r = 0;
            ArrayList vnames = new ArrayList();
            //looping the sorted prices of vehicle
            for(Double p : prices)
            {
                int col = 1;
                //looping the data of vehicles
                for(String[] c : vehicle)
                {
                    if(p == Double.parseDouble(c[7]))
                    {
                        int ct = 0;
                        //looping the vehicle names
                        /*
                        model.addRow(c);
                        */
                        for(Object b: vnames)
                        {
                            if(c[0].toLowerCase().equals(b))
                            {ct = 1;}
                        }
                        if(ct == 0)
                        {
                            model.addRow(new Object[]{});
                            table.setValueAt(r+1, r, 0);
                            for(String data : c)
                            {
                                table.setValueAt(data, r, col);
                                col++;
                            }
                            vnames.add(c[0].toLowerCase());
                            break;
                        }
                    }
                }
                r++;
            }
        }
        
        String[] vclnames = new String[vehicle.length];
        i = 0;
        //storing vehicle names in an array
        for(String[] c : vehicle)
        {
            vclnames[i] = c[0];
            i++;    
        }
        
        //Sorting the data of vehicles based on vehicle names in ascending alphabetical order
        if(sort.getSelectedItem().equals("A-Z"))
        {
            model.setRowCount(0); //clearing the table
            for(i = 0 ; i < vclnames.length-1 ; i++)
            {
                int min = i;
                for(int j = i + 1 ; j < vclnames.length ; j++)
                {
                    if(vclnames[min].compareToIgnoreCase(vclnames[j]) > 0)
                    {
                        min = j;
                    }   
                }
                if(i != min)
                {
                    String a = vclnames[i];
                    vclnames[i] = vclnames[min];
                    vclnames[min] = a;    
                }   
            }
        }
        
        //Sorting the data of vehicles based on vehicle names in descending alphabetical order
        else if(sort.getSelectedItem().equals("Z-A"))
        {
            for(i = 0 ; i < vclnames.length-1 ; i++)
            {
                int min = i;
                for(int j = i + 1 ; j < vclnames.length ; j++)
                {
                    if(vclnames[min].compareToIgnoreCase(vclnames[j]) < 0)
                    {
                        min = j;
                    }
                }
                if(i != min)
                {
                    String a = vclnames[i];
                    vclnames[i] = vclnames[min];
                    vclnames[min] = a;    
                }    
            }
        }
        
        //Writing the sorted data of vehicles in the table
        if(sort.getSelectedItem().equals("A-Z") || sort.getSelectedItem().equals("Z-A"))
        {
            int r = 0;
            for(String name : vclnames)
            {
                int col = 1;
                for(String[] c : vehicle)
                {
                    if(name.equals(c[0]))
                    {
                        model.addRow(new Object[]{});
                        table.setValueAt(r+1, r, 0);
                        for(String data : c)
                        {
                            table.setValueAt(data, r, col);
                            col++;
                        }
                        break;
                    }
                }
                r++;
            }
        }
        
        int r = 0;
        //Sorting the data of vehicles based on rating high to low
        if(sort.getSelectedItem().equals("Rating (H to L)"))
        {
            for(String[] c : vehicle)
            {
                int col = 1;
                if(c[6].equals("A"))
                {
                    model.addRow(new Object[]{});
                    table.setValueAt(r+1, r, 0);
                    for(String data : c)
                    {
                        table.setValueAt(data, r, col);
                        col++;
                    }
                    r++;
                }    
            }
            for(String[] c : vehicle)
            {
                int col = 1;
                if(c[6].equals("B"))
                {
                    model.addRow(new Object[]{});
                    table.setValueAt(r+1, r, 0);
                    for(String data : c)
                    {
                        table.setValueAt(data, r, col);
                        col++;
                    }
                    r++;
                }    
            }
            for(String[] c : vehicle)
            {
                int col = 1;
                if(c[6].equals("C"))
                {
                    model.addRow(new Object[]{});
                    table.setValueAt(r+1, r, 0);
                    for(String data : c)
                    {
                        table.setValueAt(data, r, col);
                        col++;
                    }
                    r++;
                }
                
            }
        }    
    }//GEN-LAST:event_sortActionPerformed
    /*
    * Method for sorting the vehicles based on genre
    */
@SuppressWarnings("empty-statement")
    private void SgenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SgenreActionPerformed
        // TODO add your handling code here:
        model.setRowCount(0);
        //Displaying vehicles of all genre
        if(Sgenre.getSelectedItem().equals("All (Genre)"))
        {
            model.setRowCount(0);
            int r = 0;
            for(String[] c : vehicle)
            {
                int col = 1;
                model.addRow(new Object[]{});
                model.setValueAt(r+1, r, 0);
                for(String data : c)
                {
                    model.setValueAt(data, r, col);
                    col++;
                }
                r++;
            }
            sort.setSelectedIndex(0);
            Sbrand.setSelectedIndex(0);
        }
        else
        {
            int r = 0;
            for(String[] c : vehicle)
            {
                int col = 1;
                //Sorting the data of vehicles based on Sports genre
                if(c[4].equals("Sports") && Sgenre.getSelectedItem().equals("Sports"))
                {
                    model.addRow(new Object[]{});
                    model.setValueAt(r+1, r, 0);
                    for(String data : c)
                    {
                        model.setValueAt(data, r, col);
                        col++;
                    }
                    r++;
                }
                
                //Sorting the data of vehicles based on Luxury genre
                else if(c[4].equals("Luxury") && Sgenre.getSelectedItem().equals("Luxury"))
                {
                    model.addRow(new Object[]{});
                    model.setValueAt(r+1, r, 0);
                    for(String data : c)
                    {
                        model.setValueAt(data, r, col);
                        col++;
                    }
                    r++;
                }
                
                //Sorting the data of vehicles based on SUV genre
                else if(c[4].equals("SUV") && Sgenre.getSelectedItem().equals("SUV"))
                {
                    model.addRow(new Object[]{});;
                    model.setValueAt(r+1, r, 0);
                    for(String data : c)
                    {
                        model.setValueAt(data, r, col);
                        col++;
                    }
                    r++;
                }
                
                //Sorting the data of vehicles based on Adventure genre
                else if(c[4].equals("Adventure") && Sgenre.getSelectedItem().equals("Adventure"))
                {
                    model.addRow(new Object[]{});
                    model.setValueAt(r+1, r, 0);
                    for(String data : c)
                    {
                        model.setValueAt(data, r, col);
                        col++;
                    }
                    r++;
                }    
            }
        }
    }//GEN-LAST:event_SgenreActionPerformed
    /*
    * Method for changing the property of vehicle radio radio button when there is focus int it.
    */
    private void SvnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SvnameFocusGained
        // TODO add your handling code here:
        Svname.setForeground(Color.cyan);
    }//GEN-LAST:event_SvnameFocusGained
    /*
    * Method for changing the property of vehicle name radio button when the focus on the it is lost.
    */
    private void SvnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SvnameFocusLost
        // TODO add your handling code here:
        Svname.setForeground(Color.white);
    }//GEN-LAST:event_SvnameFocusLost
    /*
    * Method for changing the property of Price radio button when there is focus int it.
    */
    private void SpriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SpriceFocusGained
        // TODO add your handling code here:
        Sprice.setForeground(Color.cyan);
        Svname.setForeground(Color.white);
    }//GEN-LAST:event_SpriceFocusGained
    /*
    * Method for changing the property of Price radio button when the focus on the it is lost.
    */
    private void SpriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SpriceFocusLost
        // TODO add your handling code here:
        Sprice.setForeground(Color.white);
    }//GEN-LAST:event_SpriceFocusLost
    /*
    * Method for changing the property of view all button when mouse enters the hover area of it.
    */
    private void viewAllMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewAllMouseEntered
        // TODO add your handling code here:
        viewAll.setForeground(Color.red);
    }//GEN-LAST:event_viewAllMouseEntered
    /*
    * Method for changing the property of view all button when mouse leaves the hover area of it.
    */
    private void viewAllMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewAllMouseExited
        // TODO add your handling code here:
        viewAll.setForeground(Color.white);
    }//GEN-LAST:event_viewAllMouseExited
    /*
    * Method for displaying details of all vehicles
    */
    private void viewAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAllActionPerformed
        model.setRowCount(0);
        int r = 0;
        for(String[] c : vehicle)
        {
            int col = 1;
            model.addRow(new Object[]{});
            model.setValueAt(r+1, r, 0);
            for(String data : c)
            {
                model.setValueAt(data, r, col);
                col++;
            }
            r++;
        }
        sort.setSelectedIndex(0);
        Sbrand.setSelectedIndex(0);
        Sgenre.setSelectedIndex(0);
    }//GEN-LAST:event_viewAllActionPerformed
    /*
    * Method for changing the property of view all button when it is clicked.
    */
    private void viewAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewAllMousePressed
        // TODO add your handling code here:
        viewAll.setFont(new Font("Segoe UI",Font.BOLD, 20));
    }//GEN-LAST:event_viewAllMousePressed
    /*
    * Method for changing the property of view all button when mouse is released after clicking it.
    */
    private void viewAllMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewAllMouseReleased
        // TODO add your handling code here:
        viewAll.setFont(new Font("Segoe UI",Font.BOLD, 18));
    }//GEN-LAST:event_viewAllMouseReleased
    /*
    * Method for changing the property of search bar when mouse it is focused.
    */
    private void SearchbarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchbarFocusGained
        // TODO add your handling code here:
        Searchbar.setText("");
    }//GEN-LAST:event_SearchbarFocusGained
    /*
    * Method for opening file chooser to select an excel file.
    */
    private void OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenActionPerformed
        try {
            // TODO add your handling code here:
            LookAndFeel lf = UIManager.getLookAndFeel();
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//changing the look and feel of the user interface to system look and feel
            
            JFileChooser chooser = new JFileChooser(".");
            chooser.removeChoosableFileFilter(chooser.getFileFilter());//removing the default all files option from the file chooser
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel files", "xlsx");//filtering the files to be diaplayed in the file chooser
            chooser.setFileFilter(filter);
            int ct = chooser.showOpenDialog(null);//opening the file chooser
            UIManager.setLookAndFeel(lf);//changing the user interface look and feel to default
            
            //Importing the data of the selected file
            if(ct == JFileChooser.APPROVE_OPTION)
            {
                FileInputStream fins = null;
                
                try {
                    fins = new FileInputStream(new File(chooser.getSelectedFile().getAbsolutePath()));
                    XSSFWorkbook wb = new XSSFWorkbook(fins);//getting the workbook at file path of the fileInputStream
                    XSSFSheet sheet = wb.getSheetAt(0);//getting the first sheet of wb
                    FormulaEvaluator fmEval = wb.getCreationHelper().createFormulaEvaluator();
                    vehicle = new String[sheet.getLastRowNum()][8];
                    int r = 0;
                    int c = -1;
                    vehicle = new String[sheet.getLastRowNum()][8];
                    model.setRowCount(0);
                    for(Row row : sheet)
                    {
                        if(c != -1)
                        {
                            model.addRow(new Object[]{});
                            model.setValueAt(r+1, r, 0);
                            for(Cell cell : row)
                            {
                                switch(fmEval.evaluateInCell(cell).getCellTypeEnum())//calculating the formula and getting the data type of the cell
                                {
                                    case NUMERIC -> {
                                        model.setValueAt(cell.getNumericCellValue() + "", r, c);//adding data of the sheet in table
                                        vehicle[r][c-1] = cell.getNumericCellValue() + "";
                                    }
                                    
                                    case STRING -> {
                                        model.setValueAt(cell.getStringCellValue(), r, c);//adding data of the sheet in table
                                        vehicle[r][c-1] = cell.getStringCellValue();
                                    }
                                }
                                c++;
                            }
                            r++;
                        }
                        c = 1;
                    }
                    JOptionPane.showMessageDialog(rootPane, "The data of the file has been successfully imported to table.", "Volkswagen Group IS", JOptionPane.INFORMATION_MESSAGE);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Alter.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Alter.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch(NotOfficeXmlFileException ex)
                {
                    JOptionPane.showMessageDialog(rootPane, "There are no valid entries in the file you selected.", "Alert", JOptionPane.ERROR_MESSAGE);
                }
                finally {
                    try {
                        fins.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Alter.class.getName()).log(Level.SEVERE, null, ex);
                    }   
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Alter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_OpenActionPerformed
    /*
    * Method for closing the program
    */
    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    /*
    * Method for opening the help pdf
    */
    private void AboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutActionPerformed
        // TODO add your handling code here:
        File f = new File("help.pdf");
        Desktop desktop = Desktop.getDesktop();  
        try {
            desktop.open(f);
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AboutActionPerformed

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
            java.util.logging.Logger.getLogger(Alter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Alter().setVisible(true);
            } catch (IOException | ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException ex) {
                Logger.getLogger(Alter.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    /*
    * Method for closing the current frame
    */
    private void close() {
        WindowEvent closeWindow=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem About;
    private javax.swing.JButton Add;
    private javax.swing.JButton Clear;
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenuItem Open;
    private javax.swing.JButton Remove;
    private javax.swing.JComboBox<String> Sbrand;
    private javax.swing.JButton SearchAdmin;
    private javax.swing.JTextField Searchbar;
    private javax.swing.JComboBox<String> Sgenre;
    private javax.swing.JRadioButton Sprice;
    private javax.swing.JRadioButton Svname;
    private javax.swing.JToggleButton backadmin;
    private javax.swing.JRadioButton bike;
    private javax.swing.JComboBox<String> brand;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton car;
    private javax.swing.JComboBox<String> ftype;
    private javax.swing.JComboBox<String> genre;
    private javax.swing.ButtonGroup group;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField price;
    private javax.swing.JTextField prod;
    private javax.swing.JTextField rating;
    private javax.swing.ButtonGroup searchBy;
    private javax.swing.JComboBox<String> sort;
    private javax.swing.JTable table;
    private javax.swing.JButton viewAll;
    private javax.swing.JTextField vname;
    // End of variables declaration//GEN-END:variables
}
