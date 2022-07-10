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
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author OMEN
 */
public class Lists extends javax.swing.JFrame {
    DefaultTableModel model;
    XSSFSheet sheet;
    FormulaEvaluator fmEval;
    String path;
    String [][] vehicle;
    int r1 = 0;
    
    
    
    /**
     * Creates new form GuiLists
     * @throws java.io.FileNotFoundException
     */
    public Lists() throws FileNotFoundException, IOException {
        initComponents();
        model = new DefaultTableModel() {
            
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        table.setModel(model);//setting the table model
        table.getTableHeader().setResizingAllowed(false);
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
        centerRenderer.setHorizontalAlignment(JLabel.CENTER );//setting the alignment of first column to center
        Svname.setSelected(true);
        
        //Setting action commmands to radio buttons
        Svname.setActionCommand("Vehicle Name");
        Sprice.setActionCommand("Price");
        
        //Setting the widths of the columns of the table
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(new Color(210, 143, 255));
        table.getColumnModel().getColumn(0).setPreferredWidth(15);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(50);
        table.getColumnModel().getColumn(3).setPreferredWidth(15);
        table.getColumnModel().getColumn(4).setPreferredWidth(30);
        table.getColumnModel().getColumn(5).setPreferredWidth(15);
        table.getColumnModel().getColumn(6).setPreferredWidth(20);
        table.getColumnModel().getColumn(7).setPreferredWidth(40);
        table.getColumnModel().getColumn(8).setPreferredWidth(15);
        JTableHeader header = table.getTableHeader();
        header.setPreferredSize(new Dimension(100, 40));
        table.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,18));
        
        jPanel2.setVisible(false);
        
        path = "vehicle_info.xlsx";
        FileInputStream fins = new FileInputStream(new File(path));
        XSSFWorkbook wb = new XSSFWorkbook(fins);//getting the workbook at at file path of the fileInputStream
        sheet = wb.getSheetAt(0);//getting the first sheet of wb
        fmEval = wb.getCreationHelper().createFormulaEvaluator();
        int r = 0;
        int c = -1;
        vehicle = new String[sheet.getLastRowNum()][8];
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
        
        File f = new File("wishlist.xls");
        try {
            WritableWorkbook wbk = Workbook.createWorkbook(f);//creating writable workbook at file path f 
            WritableSheet sheet1 = wbk.createSheet("sheet", 0);//creating writable sheet in wbk
            wbk.write();
            try {
                wbk.close();
            } catch (WriteException ex) {
                Logger.getLogger(Lists.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(Lists.class.getName()).log(Level.SEVERE, null, ex);
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

        searchBy = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        Searchbar = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        Sgenre = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Sbrand = new javax.swing.JComboBox<>();
        Sfuel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        petrol = new javax.swing.JCheckBox();
        electric = new javax.swing.JCheckBox();
        hybrid = new javax.swing.JCheckBox();
        diesel = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        sort = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Search = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        filter = new javax.swing.JToggleButton();
        back1 = new javax.swing.JToggleButton();
        user = new javax.swing.JLabel();
        Svname = new javax.swing.JRadioButton();
        Sprice = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        viewAll = new javax.swing.JButton();
        addwish = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
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
        table.setRowHeight(40);
        table.setSelectionBackground(new java.awt.Color(0, 153, 204));
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
        Searchbar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Searchbar.setForeground(new java.awt.Color(255, 255, 255));
        Searchbar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Searchbar.setText("Search");
        Searchbar.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255)));
        Searchbar.setPreferredSize(new java.awt.Dimension(56, 36));
        Searchbar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SearchbarFocusGained(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(8, 18, 38));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 153)), "Advanced Filter", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(204, 255, 255))); // NOI18N

        Sgenre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Sgenre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Sports", "Luxury", "SUV", "Adventure" }));
        Sgenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SgenreActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sort By Brand");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Sort By Genre");

        Sbrand.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Sbrand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Volkswagen", "Cupra", "Skoda", "Audi", "Lamborghini", "Ducati", "Bentley", "Bugatti", "Porsche" }));
        Sbrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SbrandActionPerformed(evt);
            }
        });

        Sfuel.setBackground(new java.awt.Color(51, 51, 51));
        Sfuel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Sfuel.setForeground(new java.awt.Color(255, 255, 255));
        Sfuel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pics/search white.png"))); // NOI18N
        Sfuel.setText("Search");
        Sfuel.setIconTextGap(3);
        Sfuel.setMargin(new java.awt.Insets(2, 10, 2, 10));
        Sfuel.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Pics/search_00000.png"))); // NOI18N
        Sfuel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SfuelActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 51, 102)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Fuel Type");

        petrol.setBackground(new java.awt.Color(51, 51, 51));
        petrol.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        petrol.setForeground(new java.awt.Color(255, 255, 255));
        petrol.setSelected(true);
        petrol.setText("Petrol");

        electric.setBackground(new java.awt.Color(51, 51, 51));
        electric.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        electric.setForeground(new java.awt.Color(255, 255, 255));
        electric.setSelected(true);
        electric.setText("Electric");

        hybrid.setBackground(new java.awt.Color(51, 51, 51));
        hybrid.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        hybrid.setForeground(new java.awt.Color(255, 255, 255));
        hybrid.setSelected(true);
        hybrid.setText("Hybrid");

        diesel.setBackground(new java.awt.Color(51, 51, 51));
        diesel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        diesel.setForeground(new java.awt.Color(255, 255, 255));
        diesel.setSelected(true);
        diesel.setText("Diesel");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(petrol)
                            .addComponent(hybrid))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(electric)
                            .addComponent(diesel))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(petrol)
                    .addComponent(electric))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hybrid)
                    .addComponent(diesel))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jSeparator1.setBackground(new java.awt.Color(0, 0, 204));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 204));
        jSeparator1.setOpaque(true);

        jSeparator3.setBackground(new java.awt.Color(0, 0, 204));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 204));
        jSeparator3.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(Sbrand, 0, 165, Short.MAX_VALUE)
                            .addComponent(Sgenre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(Sfuel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(17, 17, 17))
            .addComponent(jSeparator3)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Sgenre, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Sbrand, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Sfuel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        sort.setBackground(new java.awt.Color(204, 204, 204));
        sort.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default (Sort)", "Alphabetical ascending", "Alphabetical descending", "Price (High to Low)", "Price (Low to High)", "Safety Rating (High to Low)" }));
        sort.setToolTipText("Select to Sort the list in following options");
        sort.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 51, 102), new java.awt.Color(0, 0, 255), null, null));
        sort.setPreferredSize(new java.awt.Dimension(287, 37));
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

        Search.setBackground(new java.awt.Color(51, 51, 51));
        Search.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Search.setForeground(new java.awt.Color(255, 255, 255));
        Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pics/search white.png"))); // NOI18N
        Search.setText("Search");
        Search.setIconTextGap(3);
        Search.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Pics/search_00000.png"))); // NOI18N
        Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SearchMouseExited(evt);
            }
        });
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pics/brandlogoe.png"))); // NOI18N

        filter.setBackground(new java.awt.Color(0, 0, 0));
        filter.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        filter.setForeground(new java.awt.Color(255, 255, 255));
        filter.setText("Advanced Filter");
        filter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                filterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                filterMouseExited(evt);
            }
        });
        filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterActionPerformed(evt);
            }
        });

        back1.setBackground(new java.awt.Color(204, 204, 204));
        back1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        back1.setForeground(new java.awt.Color(0, 102, 153));
        back1.setText("<- Home");
        back1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back1ActionPerformed(evt);
            }
        });

        user.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        user.setForeground(new java.awt.Color(255, 102, 102));
        user.setText("Admin");

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

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Search by:");

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

        addwish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pics/wishic.png"))); // NOI18N
        addwish.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Pics/wishpressed.png"))); // NOI18N
        addwish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addwishActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Searchbar, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(sort, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(addwish, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(filter))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Svname)
                                        .addGap(10, 10, 10)
                                        .addComponent(Sprice)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(viewAll, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(back1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(user)
                                .addGap(21, 21, 21)))))
                .addGap(40, 40, 40))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(back1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Searchbar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(sort, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(addwish, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(filter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Svname)
                                .addComponent(Sprice)
                                .addComponent(jLabel6))
                            .addComponent(viewAll, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuBar1.setMinimumSize(new java.awt.Dimension(64, 30));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(64, 30));

        jMenu1.setText("File");

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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE)
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
        if(Sbrand.getSelectedItem().equals("All"))
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
            petrol.setSelected(false);
            diesel.setSelected(false);
            electric.setSelected(false);
            hybrid.setSelected(false);
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
            JOptionPane.showMessageDialog(rootPane,  r + " vehicles of " + Sbrand.getSelectedItem() + " were found.", "Volkswagen Group IS", JOptionPane.INFORMATION_MESSAGE);
        }            
                        
    }//GEN-LAST:event_SbrandActionPerformed
    /*
    * Method for searching the data based on vehicle name and price.
    */
    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
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
                        table.setValueAt(data, 0,i );
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
    }//GEN-LAST:event_SearchActionPerformed
    /*
    * Method for changing the property of search button when mouse enters the hover area of it.
    */
    private void SearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchMouseEntered
        // TODO add your handling code here:
        Search.setBackground(new Color(123, 182, 201));
    }//GEN-LAST:event_SearchMouseEntered
    /*
    * Method for changing the property of search button when mouse leaves the hover area of it.
    */
    private void SearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchMouseExited
        // TODO add your handling code here:
        Search.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_SearchMouseExited
    /*
    * Method for opening the advanced filter frame when filter button is clicked.
    */
    private void filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterActionPerformed
        // TODO add your handling code here:
        if (jPanel2.isVisible()==false)
        {
            jPanel2.setVisible(true);
        }
        else{
            jPanel2.setVisible(false);
        }
    }//GEN-LAST:event_filterActionPerformed
    /*
    * Method for changing the property of filter button when mouse enters the hover area of it.
    */
    private void filterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filterMouseEntered
        // TODO add your handling code here:
        filter.setBackground(new Color(133, 149, 255));
        filter.setForeground(Color.black);
    }//GEN-LAST:event_filterMouseEntered
    /*
    * Method for changing the property of filter button when mouse leaves the hover area of it.
    */
    private void filterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filterMouseExited
        // TODO add your handling code here:
        filter.setBackground(new Color(0,0,0));
        filter.setForeground(Color.white);
    }//GEN-LAST:event_filterMouseExited
    /*
    * Method for returning to home page based on user category
    */            
    private void back1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back1ActionPerformed
        // TODO add your handling code here:
        switch (user.getText()) {
            case "Admin" ->                 {
                    close();
                    Admin homeAd = new Admin();
                    homeAd.setVisible(true);
                }
            case "User" ->                 {
                    close();
                    User homeAd = new User();
                    homeAd.setVisible(true);
                }
            case "Guest" -> {
                close();
                Login a = new Login();
                a.setVisible(true);
            }   
        }
    }//GEN-LAST:event_back1ActionPerformed
    /*
    * Method for sorting the data of vehicles
    */
    private void sortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortActionPerformed
        // TODO add your handling code here:
        model.setRowCount(0);
        double[] prices = new double[vehicle.length];
        int i = 0;
        //Storing the prices of vehicles in an array
        for(String[] c1 : vehicle)
        {
            
            prices[i] = Double.parseDouble(c1[7]);
            i++;
        }
        
        //Displaying all the vehicles in default order
        if(sort.getSelectedItem().equals("Default (Sort)"))
        {
            model.setRowCount(0);
            petrol.setSelected(true);
            diesel.setSelected(true);
            electric.setSelected(true);
            hybrid.setSelected(true);
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
        if(sort.getSelectedItem().equals("Price (High to Low)"))
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
        else if(sort.getSelectedItem().equals("Price (Low to High)"))
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
        if(sort.getSelectedItem().equals("Price (High to Low)") || sort.getSelectedItem().equals("Price (Low to High)"))
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
        if(sort.getSelectedItem().equals("Alphabetical ascending"))
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
        else if(sort.getSelectedItem().equals("Alphabetical descending"))
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
        if(sort.getSelectedItem().equals("Alphabetical ascending") || sort.getSelectedItem().equals("Alphabetical descending"))
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
        if(sort.getSelectedItem().equals("Safety Rating (High to Low)"))
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
    private void SgenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SgenreActionPerformed
        // TODO add your handling code here:
        model.setRowCount(0);
        //Displaying vehicles of all genre
        if(Sgenre.getSelectedItem().equals("All"))
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
            petrol.setSelected(false);
            diesel.setSelected(false);
            electric.setSelected(false);
            hybrid.setSelected(false);
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
                    model.addRow(new Object[]{});
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
            JOptionPane.showMessageDialog(rootPane,  r + " " + Sgenre.getSelectedItem() + " vehicles were found.", "Volkswagen Group IS", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_SgenreActionPerformed
    /*
    * Method for changing the property of search bar when there is focus int it.
    */       
    private void SearchbarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchbarFocusGained
        // TODO add your handling code here:
        Searchbar.setText("");
    }//GEN-LAST:event_SearchbarFocusGained
    /*
    * Method for sorting the vehicles based on fuel type
    */            
    private void SfuelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SfuelActionPerformed
        // TODO add your handling code here:
        model.setRowCount(0);
        int r = 0;
        for(String[] c : vehicle)
        {
            int col = 1;
            //Sorting the data based on petrol fuel type
            if(c[3].equals("Petrol") && petrol.isSelected() == true)
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
            
            //Sorting the data based on petrol diesel type
            if(c[3].equals("Diesel") && diesel.isSelected() == true)
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
            
            //Sorting the data based on electric fuel type
            if(c[3].equals("Electric") && electric.isSelected() == true)
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
            
            //Sorting the data based on hybrid fuel type
            if(c[3].equals("Hybrid") && hybrid.isSelected() == true)
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
        
    }//GEN-LAST:event_SfuelActionPerformed
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
    * Method for changing the property of vehicle name radio radio button when there is focus in it.
    */    
    private void SvnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SvnameFocusGained
        // TODO add your handling code here:
        Svname.setForeground(Color.cyan);
    }//GEN-LAST:event_SvnameFocusGained
    /*
    * Method for changing the property of vehicle name radio radio button when the is focus in it is lost.
    */
    private void SvnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SvnameFocusLost
        // TODO add your handling code here:
        Svname.setForeground(Color.white);
        
    }//GEN-LAST:event_SvnameFocusLost
    /*
    * Method for changing the property of price radio radio button when there is focus in it.
    */
    private void SpriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SpriceFocusGained
        // TODO add your handling code here:
        Sprice.setForeground(Color.cyan);
        Svname.setForeground(Color.white);
    }//GEN-LAST:event_SpriceFocusGained
     /*
    * Method for changing the property of price radio radio button when the is focus in it is lost.
    */
    private void SpriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SpriceFocusLost
        // TODO add your handling code here:
        Sprice.setForeground(Color.white);
    }//GEN-LAST:event_SpriceFocusLost
    /*
    * Method for adding vehicles into wishlist file
    */
    private void addwishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addwishActionPerformed
        // TODO add your handling code here:
        if(table.getSelectionModel().isSelectionEmpty())
        {
            JOptionPane.showMessageDialog(rootPane, "Please select a row to add to wishlist.", "Alert", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            File f = new File("wishlist.xls");
            try
            {
                Workbook w = Workbook.getWorkbook(f);
                WritableWorkbook wbk = Workbook.createWorkbook(f,w);//getting workbook w at path f to write data
                WritableSheet sheet1 = wbk.getSheet(0);//getting first sheet of writable workbook wbk
                
                String svec = table.getValueAt(table.getSelectedRow(), 1).toString();
                for(String[] c : vehicle)
                {
                    int col = 0;
                    if(c[0].equals(svec))
                    {
                        for(String data : c)
                        {
                            sheet1.addCell(new Label(col,r1,data));//adding the selectecd data in the sheet
                            col++;
                        }
                        r1++;
                        JOptionPane.showMessageDialog(rootPane, svec + " has been successfully added to your wishlist.", "Volkswagen Group IS", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                }
                wbk.write();
                wbk.close();
            }
            
            catch (IOException | BiffException | WriteException ex) {
                Logger.getLogger(Lists.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    }//GEN-LAST:event_addwishActionPerformed
    /*
    * Method for changing the property of view all button when mouse enters the hover area of it.
    */
    private void viewAllMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewAllMousePressed
        // TODO add your handling code here:
        viewAll.setFont(new Font("Segoe UI",Font.BOLD, 20));
    }//GEN-LAST:event_viewAllMousePressed
    /*
    * Method for changing the property of view all button when mouse leaves the hover area of it.
    */
    private void viewAllMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewAllMouseReleased
        // TODO add your handling code here:
        viewAll.setFont(new Font("Segoe UI",Font.BOLD, 18));
    }//GEN-LAST:event_viewAllMouseReleased
    /*
    * Method for closing the whole program.
    */
    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed
    /*
    * Method for opening the help file
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
            java.util.logging.Logger.getLogger(Lists.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lists.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lists.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lists.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Lists().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(Lists.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }
    
    /*
    * Method for displaying the details of all vehicles
    */
    public void viewAll()
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
    private javax.swing.JMenuItem Exit;
    private javax.swing.JComboBox<String> Sbrand;
    public javax.swing.JButton Search;
    private javax.swing.JTextField Searchbar;
    private javax.swing.JButton Sfuel;
    private javax.swing.JComboBox<String> Sgenre;
    private javax.swing.JRadioButton Sprice;
    private javax.swing.JRadioButton Svname;
    public javax.swing.JButton addwish;
    private javax.swing.JToggleButton back1;
    private javax.swing.JCheckBox diesel;
    private javax.swing.JCheckBox electric;
    private javax.swing.JToggleButton filter;
    private javax.swing.JCheckBox hybrid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JCheckBox petrol;
    private javax.swing.ButtonGroup searchBy;
    private javax.swing.JComboBox<String> sort;
    private javax.swing.JTable table;
    public javax.swing.JLabel user;
    private javax.swing.JButton viewAll;
    // End of variables declaration//GEN-END:variables
}
