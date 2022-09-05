package View;

import Method.Methods;
import Object.Subject;
import Object.Class;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import javax.swing.table.TableCellRenderer;
import java.awt.event.MouseEvent;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import writereadexcel.ReadExcel;

public class View extends javax.swing.JFrame {

    public static ArrayList<Subject> listSubject = new ArrayList<Subject>();    // Danh sách các môn hoc
    public static ArrayList<Class> listClass = new ArrayList<Class>();             // Danh sách các lop hoc
    public static ArrayList<String> listSubjectAdded = new ArrayList<String>();     // Danh sách các môn đã được thêm
    public Methods method = new Methods();      // Tạo đối tượng method để sử dụng các hàm xử lý
    public static int[][] viewTime = new int[12][7];        // Ma trận lưu trạng thái của mainTable (dụng để đánh dấu mà tô màu)
    public static String[][] viewSubject = new String[12][7];        // Ma trận lưu trạng thái của mainTable (dụng để đánh dấu mà tô màu)
    public ActionListener action = new Methods(this);   // Biến action lưu những even của người dùng truyền vào, đưa vào method để xử lý

    public View() {
        initComponents();
        mainTable.setBackground(new Color(245, 252, 204));
    }
// Khởi tạo phương thức initComponents, tạo ra các đối tượng trong View
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        viewDetailPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        subjectDetail = new javax.swing.JTextField();
        idDetail = new javax.swing.JTextField();
        kClassDetail = new javax.swing.JTextField();
        weekDetail = new javax.swing.JTextField();
        timeDetail = new javax.swing.JTextField();
        ktimeDetail = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        kinDetail = new javax.swing.JLabel();
        kindText = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        closeButton = new javax.swing.JButton();
        mainJScrollPane = new javax.swing.JScrollPane();
        mainTable = new javax.swing.JTable()
        {
            @Override

            public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex){
                Component componenet = super.prepareRenderer(renderer, rowIndex, columnIndex);
                if(columnIndex == 0){
                    Color color = new Color(204,255,204);
                    componenet.setBackground(color);
                    componenet.setForeground(new Color(51,51,255));
                }
                else
                if(viewTime[rowIndex][columnIndex] != 0){
                    Color color = new Color(211,255,255);
                    componenet.setBackground(color);
                    componenet.setForeground(new Color(51,51,255));
                }
                else{
                    componenet.setBackground(Color.WHITE);
                    componenet.setForeground(new Color(51,51,255));
                }
                return componenet;
            }

        }
        ;
        classTableJScrollPane = new javax.swing.JScrollPane();
        classTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        addTextField = new javax.swing.JTextField();
        findButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        viewDetailButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(10, 10));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(229, 250, 253));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewDetailPanel.setBackground(new java.awt.Color(182, 240, 252));
        viewDetailPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 0)));
        viewDetailPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("MÃ LỚP");
        viewDetailPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 110, 50));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("MÃ HỌC PHẦN");
        viewDetailPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 110, 40));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("TUẦN HỌC");
        viewDetailPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 110, 40));
        viewDetailPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("THỜI GIAN");
        viewDetailPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 110, 40));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("LỚP LT");
        viewDetailPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 110, 40));

        subjectDetail.setEditable(false);
        subjectDetail.setBackground(new java.awt.Color(255, 255, 204));
        subjectDetail.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        subjectDetail.setForeground(new java.awt.Color(0, 0, 255));
        subjectDetail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        subjectDetail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 255), 2));
        subjectDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectDetailActionPerformed(evt);
            }
        });
        viewDetailPanel.add(subjectDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 390, 40));

        idDetail.setEditable(false);
        idDetail.setBackground(new java.awt.Color(255, 255, 204));
        idDetail.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        idDetail.setForeground(new java.awt.Color(255, 51, 51));
        idDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idDetailActionPerformed(evt);
            }
        });
        viewDetailPanel.add(idDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 250, 40));

        kClassDetail.setEditable(false);
        kClassDetail.setBackground(new java.awt.Color(255, 255, 204));
        kClassDetail.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        kClassDetail.setForeground(new java.awt.Color(255, 51, 51));
        viewDetailPanel.add(kClassDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 250, 40));

        weekDetail.setEditable(false);
        weekDetail.setBackground(new java.awt.Color(255, 255, 204));
        weekDetail.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        weekDetail.setForeground(new java.awt.Color(255, 51, 51));
        weekDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weekDetailActionPerformed(evt);
            }
        });
        viewDetailPanel.add(weekDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 250, 40));

        timeDetail.setEditable(false);
        timeDetail.setBackground(new java.awt.Color(255, 255, 204));
        timeDetail.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        timeDetail.setForeground(new java.awt.Color(255, 51, 51));
        timeDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeDetailActionPerformed(evt);
            }
        });
        viewDetailPanel.add(timeDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 250, 40));

        ktimeDetail.setEditable(false);
        ktimeDetail.setBackground(new java.awt.Color(255, 255, 204));
        ktimeDetail.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        ktimeDetail.setForeground(new java.awt.Color(255, 51, 51));
        ktimeDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ktimeDetailActionPerformed(evt);
            }
        });
        viewDetailPanel.add(ktimeDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 250, 40));
        viewDetailPanel.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, -1, -1));
        viewDetailPanel.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 400, 10));
        viewDetailPanel.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 143, 310, 0));
        viewDetailPanel.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 400, 10));
        viewDetailPanel.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 400, 10));
        viewDetailPanel.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 400, 10));
        viewDetailPanel.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 400, 10));

        kinDetail.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        kinDetail.setText("LOẠI LỚP");
        viewDetailPanel.add(kinDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 110, 40));

        kindText.setEditable(false);
        kindText.setBackground(new java.awt.Color(255, 255, 204));
        kindText.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        kindText.setForeground(new java.awt.Color(255, 51, 51));
        kindText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kindTextActionPerformed(evt);
            }
        });
        viewDetailPanel.add(kindText, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 500, 250, 40));
        viewDetailPanel.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, 400, 10));

        closeButton.addActionListener(action);
        closeButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        closeButton.setForeground(new java.awt.Color(255, 0, 51));
        closeButton.setText("X");
        closeButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 0)));
        closeButton.setVisible(false);
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        viewDetailPanel.add(closeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 60, 30));

        jPanel1.add(viewDetailPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 110, 430, 680));
        viewDetailPanel.setVisible(false);

        mainJScrollPane.setBackground(new java.awt.Color(254, 224, 90));

        mainTable.setBackground(new java.awt.Color(254, 224, 90));
        mainTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        mainTable.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        mainTable.setForeground(new java.awt.Color(51, 51, 255));
        mainTable.getTableHeader().setFont(new Font("Times New Roman", 1, 20));
        mainTable.getTableHeader().setOpaque(false);
        mainTable.getTableHeader().setForeground(Color.ORANGE);
        mainTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"6h45-7h30", "", "", "", "", "", ""},
                {"7h30-8h15", "", "", "", "", "", ""},
                {"8h25-9h10", "", "", "", "", "", ""},
                {"9h20-10h5", "", "", "", "", "", ""},
                {"10h15-11h", "", "", "", "", "", ""},
                {"11h-11h45", "", "", "", "", "", ""},
                {"12h30-13h15", "", "", "", "", "", ""},
                {"13h15-14h", "", "", "", "", "", ""},
                {"14h10-14h55", "", "", "", "", "", ""},
                {"15h5-15h50", "", "", "", "", "", ""},
                {"16h-16h45", "", "", "", "", "", ""},
                {"16h45-17h30", "", "", "", "", "", ""}
            },
            new String [] {
                "Time", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        TableModel tableModel = mainTable.getModel();

        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
            mainTable.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
        DefaultTableCellRenderer headerRender  = new DefaultTableCellRenderer();
        headerRender.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        Color hdColor = new Color(254,224,90);
        headerRender.setBackground(hdColor);
        mainTable.getTableHeader().setDefaultRenderer(headerRender);
        mainTable.setColumnSelectionAllowed(true);
        mainTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mainTable.setGridColor(new java.awt.Color(255, 255, 51));
        mainTable.setRowHeight(54);
        mainTable.setSelectionBackground(new java.awt.Color(0, 204, 204));
        mainTable.setSelectionForeground(new java.awt.Color(204, 102, 0));
        mainTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        mainTable.setShowGrid(true);
        mainTable.getTableHeader().setReorderingAllowed(false);
        mainJScrollPane.setViewportView(mainTable);
        mainTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (mainTable.getColumnModel().getColumnCount() > 0) {
            mainTable.getColumnModel().getColumn(0).setResizable(false);
            mainTable.getColumnModel().getColumn(1).setResizable(false);
            mainTable.getColumnModel().getColumn(2).setResizable(false);
            mainTable.getColumnModel().getColumn(3).setResizable(false);
            mainTable.getColumnModel().getColumn(4).setResizable(false);
            mainTable.getColumnModel().getColumn(5).setResizable(false);
            mainTable.getColumnModel().getColumn(6).setResizable(false);
        }
        mainTable.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE){
                    deleteButton.doClick();
                }
            }
        });
        mainTable.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent mouseEvent){
                JTable table = (JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                int column = table.columnAtPoint(point);
                if (mouseEvent.getClickCount() ==2 && row!=-1 && column != -1 ){
                    if (table.getValueAt(row, column)!=""){
                        viewDetailButton.doClick();
                    }
                    else {
                        viewDetailPanel.setVisible(false);
                    }
                }
            }
        });

        jPanel1.add(mainJScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 1020, 680));

        classTableJScrollPane.setBackground(new java.awt.Color(229, 250, 253));

        classTable.setBackground(new java.awt.Color(229, 250, 253));
        classTable.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        classTable.setRowHeight(55);
        classTable.getTableHeader().setFont(new Font("Times New Roman", 1, 20));
        classTable.getTableHeader().setOpaque(false);
        classTable.getTableHeader().setBackground(Color.PINK);
        classTable.getTableHeader().setForeground(Color.red);
        classTable.setForeground(new java.awt.Color(51, 51, 255));
        classTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Class", "Time", "Name Subject"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        classTable.setGridColor(new java.awt.Color(204, 204, 0));
        classTable.setShowGrid(true);
        classTable.getTableHeader().setReorderingAllowed(false);
        classTableJScrollPane.setViewportView(classTable);
        DefaultTableCellRenderer classHeaderRender  = new DefaultTableCellRenderer();
        classHeaderRender.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        Color chdColor = new Color(254,224,90);
        classHeaderRender.setBackground(chdColor);
        classHeaderRender.setFont(new Font("Times New Roman", 1, 20));
        classTable.getTableHeader().setDefaultRenderer(classHeaderRender);
        if (classTable.getColumnModel().getColumnCount() > 0) {
            classTable.getColumnModel().getColumn(0).setResizable(false);
            classTable.getColumnModel().getColumn(1).setResizable(false);
            classTable.getColumnModel().getColumn(1).setPreferredWidth(150);
            classTable.getColumnModel().getColumn(2).setResizable(false);
            classTable.getColumnModel().getColumn(2).setPreferredWidth(170);
        }
        classTable.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent mouseEvent){
                JTable table = (JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() ==2 && row!=-1){
                    addButton.doClick();
                }
            }
        });

        jPanel1.add(classTableJScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 110, 430, 680));

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 153, 255));
        jLabel1.setText("Subject: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 150, 60));

        addTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    findButton.doClick();
                }
            }

        });
        addTextField.setBackground(new java.awt.Color(204, 255, 204));
        addTextField.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        addTextField.setForeground(new java.awt.Color(51, 102, 255));
        addTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        addTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(addTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 370, 50));

        findButton.addActionListener(action);
        findButton.setBackground(new java.awt.Color(255, 252, 218));
        findButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        findButton.setForeground(new java.awt.Color(51, 153, 255));
        findButton.setText("Find");
        findButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findButtonActionPerformed(evt);
            }
        });
        jPanel1.add(findButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 80, 50));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 1450, 10));

        addButton.addActionListener(action);
        addButton.setBackground(new java.awt.Color(255, 255, 221));
        addButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        addButton.setForeground(new java.awt.Color(51, 153, 255));
        addButton.setText("Add");
        jPanel1.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 180, 30));

        deleteButton.setBackground(new java.awt.Color(255, 255, 221));
        deleteButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(51, 153, 255));
        deleteButton.setText("Delete");
        deleteButton.addActionListener(action);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel1.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 20, 150, 50));

        viewDetailButton.addActionListener(action);
        viewDetailButton.setBackground(new java.awt.Color(255, 255, 221));
        viewDetailButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        viewDetailButton.setForeground(new java.awt.Color(51, 153, 255));
        viewDetailButton.setText("View Detail");
        viewDetailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDetailButtonActionPerformed(evt);
            }
        });
        jPanel1.add(viewDetailButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 50, 180, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/iconFix.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 10, 100, 70));

        saveButton.setBackground(new java.awt.Color(255, 255, 221));
        saveButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        saveButton.setForeground(new java.awt.Color(255, 51, 51));
        saveButton.setText("SAVE");
        saveButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        saveButton.addActionListener(action);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jPanel1.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 54, 60, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1470, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addTextFieldActionPerformed

    private void findButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_findButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void viewDetailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDetailButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewDetailButtonActionPerformed

    private void ktimeDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ktimeDetailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ktimeDetailActionPerformed

    private void idDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idDetailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idDetailActionPerformed

    private void timeDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeDetailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timeDetailActionPerformed

    private void weekDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weekDetailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_weekDetailActionPerformed

    private void kindTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kindTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kindTextActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_closeButtonActionPerformed

    private void subjectDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectDetailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectDetailActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButtonActionPerformed

    public void reloadFrame() {
        SwingUtilities.updateComponentTreeUI(mainJScrollPane);
        mainTable.setShowGrid(true);
    }

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
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                View view = new View();
                view.setTitle("Time Table");        // set tên chuong trình
                URL urlIcon = View.class.getResource("iconFix.png");    
                Image img = Toolkit.getDefaultToolkit().createImage(urlIcon);
                view.setIconImage(img);         // set icon chuong trình
                Methods method = new Methods(view);
                ReadExcel read = new ReadExcel(view);       // Tạo đối tượng ReadExcel để đọc file dữ liệu
               // Đọc file dữ liệu môn học
                try {
                    read.readExcelSubject();
                } catch (IOException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                }
                // Đọc file dữ liệu các lớp học
                try {
                    read.readExcelClass();
                } catch (IOException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                }
                // Đọc file dữ liệu người dùng đã lưu
                try {
                    read.loadData();
                } catch (IOException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                }
                view.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    public javax.swing.JTextField addTextField;
    public javax.swing.JTable classTable;
    public javax.swing.JScrollPane classTableJScrollPane;
    public javax.swing.JButton closeButton;
    private javax.swing.JButton deleteButton;
    public javax.swing.JButton findButton;
    public javax.swing.JTextField idDetail;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    public javax.swing.JTextField kClassDetail;
    private javax.swing.JLabel kinDetail;
    public javax.swing.JTextField kindText;
    public javax.swing.JTextField ktimeDetail;
    private javax.swing.JScrollPane mainJScrollPane;
    public static javax.swing.JTable mainTable;
    private javax.swing.JButton saveButton;
    public javax.swing.JTextField subjectDetail;
    public javax.swing.JTextField timeDetail;
    private javax.swing.JButton viewDetailButton;
    public javax.swing.JPanel viewDetailPanel;
    public javax.swing.JTextField weekDetail;
    // End of variables declaration//GEN-END:variables
}
