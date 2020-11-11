/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.WarehouseWorkArea;

import userinterface.SupplierWorkArea.AddNewSupplierPanel;
import Business.Dao.Order;
import Business.Dao.OrderDirectory;
import Business.Dao.Product;
import Business.Dao.ProductDirectory;
import Business.Dao.Supplier;
import Business.Dao.SupplierDirectory;
import Business.Dao.SupplierProducts;
import userinterface.CustomerServiceWorkArea.*;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.ContractorProductOrganization;
import Business.Organization.CustomerManagerOrganization;
import Business.Organization.CustomerServiceOrganization;
import Business.Organization.Organization;
import Business.Organization.SalesPersonOrganization;
import Business.Organization.WarehouseOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.CMOrderCheckWorkRequest;
import Business.WorkQueue.SignSupplierRequest;
import Business.WorkQueue.WMOrderCheckWorkRequest;
//import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.WorkRequest;
import com.db4o.collections.ActivatableArrayList;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raunak
 */
public class WarehouseWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private WarehouseOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private ProductDirectory  productDirectory;
    private OrderDirectory orderDirectory;
    private SupplierDirectory  supplierDirectory;
    private Product product;
    private ArrayList<Network> networkList;
    private EcoSystem system;
    private ArrayList<Supplier> supplierConList;
    private ArrayList<WorkRequest> requestedSupplierList;
   // private Image img;
    /**
     * Creates new form SalesPersonWorkAreaJPanel
     */
    public WarehouseWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, 
        WarehouseOrganization organization, Enterprise enterprise,EcoSystem system,
        OrderDirectory orderDirectory,ProductDirectory  productDirectory) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.productDirectory = organization.getProdirect();
//        givesale();
        //organization.setProdirect(productDirectory);
        this.supplierDirectory = organization.getSupplierDierectory();
        for (Product pd : productDirectory.getProductList()) {
            
        }
        this.system = system;
        this.networkList = system.getNetworkList();
        this.orderDirectory = orderDirectory;
        
        supplierConList = getSupplierConList();
        valueLabel.setText(enterprise.getName());
        requestedSupplierList = new ArrayList<>();
        
        populateTableSupplier();
        populateComboSupplier();
        populateComboSupplier1();
        populateComboProductBrand();
        populatePanelView();
        populateTableSalesRequest();
        populateTableSupplierRespond();
        populateTableSupplierCon();
        
       
        
    }
    
    
    
    /*
    *Refresh supplier Combobox
    *
    */
   public void populateComboSupplier(){
 
        comboSupplierID.removeAllItems();
        comboSupplierName.removeAllItems();
        comboSupplierID.addItem("0");
        comboSupplierName.addItem("Select supplier name");
        for (Supplier s : supplierDirectory.getSupplierList()) {
            comboSupplierID.addItem(String.valueOf(s.getSupplierID()));
            comboSupplierName.addItem(s.getSupplierName());
        }
    }
   
   public void populateComboSupplier1(){
 
        comboSupplierID1.removeAllItems();
        comboSupplierName1.removeAllItems();
        comboSupplierID1.addItem("0");
        comboSupplierName1.addItem("Select supplier name");
        for (Supplier s : supplierConList) {
            comboSupplierID1.addItem(String.valueOf(s.getSupplierID()));
            comboSupplierName1.addItem(s.getSupplierName());
        }
    }
   
   /*
    *Refresh product Combobox
    *
    */
   
   public void populateComboProductBrand(){
 
        comboBrand.removeAllItems();
        comboBrand.addItem("Select a brand");
        for(Supplier s : supplierConList){
            comboBrand.addItem(s.getSupplierName());
        }
    }
   
   public void populateComboProductName(String brandStr){
 
        comboProdName.removeAllItems();
        comboProdName.addItem("Select Product Name");
       
        for (Supplier s: supplierDirectory.getSupplierList()) {
            if(s.getSupplierName().equals(brandStr)){
                for(int i=0;i<s.getProList().size();i++){
                    comboProdName.addItem(s.getProList().get(i).getName());
                }
            }
        }
    }
 
    /*
    *Refresh supplier Table
    *
    */
    public void populateTableSupplier(){
        DefaultTableModel model = (DefaultTableModel) tableAllSuppliers.getModel();
        
        model.setRowCount(0);
        for (Supplier supplier : supplierDirectory.getSupplierList()){
            Object[] row = new Object[2];
            row[0] = supplier;
            row[1] = supplier.getSupplierName();

            model.addRow(row);
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

        refreshTestJButton = new javax.swing.JButton();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        jtabWork = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableSalesRequest = new javax.swing.JTable();
        btnApproveRequest = new javax.swing.JButton();
        CreateProdPanel = new javax.swing.JPanel();
        comboBrand = new javax.swing.JComboBox<>();
        btnCreate = new javax.swing.JButton();
        numLabel = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        numLabel1 = new javax.swing.JLabel();
        labelImg = new javax.swing.JLabel();
        btnUploadImg = new javax.swing.JButton();
        numLabel2 = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNum = new javax.swing.JTextField();
        comboProdName = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        comboProdID1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        ComboBrand1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        comboProdName1 = new javax.swing.JComboBox<>();
        btnViewDetail1 = new javax.swing.JButton();
        btnDelete1 = new javax.swing.JButton();
        bynSearch1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProducts1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        comboSupplierID = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        comboSupplierName = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableAllSuppliers = new javax.swing.JTable();
        btnAddSupplier = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnViewSupplier2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        comboSupplierID1 = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        comboSupplierName1 = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableSuppliersCon = new javax.swing.JTable();
        btnSearch1 = new javax.swing.JButton();
        btnDeleteSupplier1 = new javax.swing.JButton();
        btnViewSupplier1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tableSupplierResond = new javax.swing.JTable();
        btnViewDetail = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 237, 237));

        refreshTestJButton.setForeground(new java.awt.Color(255, 102, 204));
        refreshTestJButton.setText("Refresh");
        refreshTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTestJButtonActionPerformed(evt);
            }
        });

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setForeground(new java.awt.Color(255, 102, 204));
        enterpriseLabel.setText("EnterPrise :");

        valueLabel.setForeground(new java.awt.Color(255, 102, 204));
        valueLabel.setText("<value>");

        jtabWork.setBackground(new java.awt.Color(255, 255, 255));
        jtabWork.setForeground(new java.awt.Color(255, 102, 204));

        jPanel6.setBackground(new java.awt.Color(255, 237, 237));

        tableSalesRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OrderID", "Sender", "Status", "RequestDate"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tableSalesRequest);
        if (tableSalesRequest.getColumnModel().getColumnCount() > 0) {
            tableSalesRequest.getColumnModel().getColumn(0).setResizable(false);
            tableSalesRequest.getColumnModel().getColumn(1).setResizable(false);
            tableSalesRequest.getColumnModel().getColumn(2).setResizable(false);
            tableSalesRequest.getColumnModel().getColumn(3).setResizable(false);
        }

        btnApproveRequest.setForeground(new java.awt.Color(255, 102, 204));
        btnApproveRequest.setText("Check Quantity to Approve");
        btnApproveRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveRequestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnApproveRequest)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(393, 393, 393))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnApproveRequest)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        jtabWork.addTab("Sales requests", jPanel6);

        CreateProdPanel.setBackground(new java.awt.Color(255, 237, 237));

        comboBrand.setForeground(new java.awt.Color(255, 102, 204));
        comboBrand.setMaximumRowCount(4);
        comboBrand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBrandActionPerformed(evt);
            }
        });

        btnCreate.setBackground(new java.awt.Color(255, 255, 255));
        btnCreate.setForeground(new java.awt.Color(255, 102, 204));
        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        numLabel.setForeground(new java.awt.Color(255, 102, 204));
        numLabel.setText("Description");

        txtPrice.setForeground(new java.awt.Color(255, 102, 204));

        numLabel1.setForeground(new java.awt.Color(255, 102, 204));
        numLabel1.setText("Image");

        btnUploadImg.setForeground(new java.awt.Color(255, 102, 204));
        btnUploadImg.setText("Upload Image");
        btnUploadImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadImgActionPerformed(evt);
            }
        });

        numLabel2.setForeground(new java.awt.Color(255, 102, 204));
        numLabel2.setText("Price");

        txtDescription.setForeground(new java.awt.Color(255, 102, 204));
        txtDescription.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel1.setForeground(new java.awt.Color(255, 102, 204));
        jLabel1.setText("Quantity");

        txtNum.setForeground(new java.awt.Color(255, 102, 204));
        txtNum.setEnabled(false);
        txtNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumActionPerformed(evt);
            }
        });

        comboProdName.setForeground(new java.awt.Color(255, 102, 204));
        comboProdName.setMaximumRowCount(4);
        comboProdName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboProdName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProdNameActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 102, 204));
        jLabel10.setText("Brand");

        jLabel11.setForeground(new java.awt.Color(255, 102, 204));
        jLabel11.setText("Product Name");

        javax.swing.GroupLayout CreateProdPanelLayout = new javax.swing.GroupLayout(CreateProdPanel);
        CreateProdPanel.setLayout(CreateProdPanelLayout);
        CreateProdPanelLayout.setHorizontalGroup(
            CreateProdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateProdPanelLayout.createSequentialGroup()
                .addGroup(CreateProdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CreateProdPanelLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(CreateProdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(numLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(numLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10))
                        .addGap(78, 78, 78)
                        .addGroup(CreateProdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboProdName, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(89, 89, 89)
                        .addGroup(CreateProdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(CreateProdPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(49, 49, 49)
                                .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(CreateProdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(CreateProdPanelLayout.createSequentialGroup()
                                    .addComponent(numLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnUploadImg))
                                .addComponent(labelImg, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(CreateProdPanelLayout.createSequentialGroup()
                        .addGap(456, 456, 456)
                        .addComponent(btnCreate)))
                .addContainerGap(489, Short.MAX_VALUE))
        );
        CreateProdPanelLayout.setVerticalGroup(
            CreateProdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateProdPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(CreateProdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numLabel1)
                    .addComponent(comboBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(btnUploadImg))
                .addGap(16, 16, 16)
                .addGroup(CreateProdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(CreateProdPanelLayout.createSequentialGroup()
                        .addComponent(labelImg, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CreateProdPanelLayout.createSequentialGroup()
                        .addGroup(CreateProdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboProdName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(23, 23, 23)
                        .addGroup(CreateProdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numLabel)
                            .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)))
                .addGap(28, 28, 28)
                .addGroup(CreateProdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CreateProdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(numLabel2)
                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addGap(33, 33, 33)
                .addComponent(btnCreate))
        );

        jtabWork.addTab("Create Products", CreateProdPanel);

        jPanel2.setBackground(new java.awt.Color(255, 237, 237));

        jLabel4.setForeground(new java.awt.Color(255, 102, 204));
        jLabel4.setText("Product ID");

        comboProdID1.setForeground(new java.awt.Color(255, 102, 204));
        comboProdID1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setForeground(new java.awt.Color(255, 102, 204));
        jLabel8.setText("Brand");

        ComboBrand1.setForeground(new java.awt.Color(255, 102, 204));
        ComboBrand1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboBrand1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBrand1ActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 102, 204));
        jLabel9.setText("Product Name");

        comboProdName1.setForeground(new java.awt.Color(255, 102, 204));
        comboProdName1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnViewDetail1.setForeground(new java.awt.Color(255, 102, 204));
        btnViewDetail1.setText("View Details");
        btnViewDetail1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetail1ActionPerformed(evt);
            }
        });

        btnDelete1.setForeground(new java.awt.Color(255, 102, 204));
        btnDelete1.setText("Delete");
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });

        bynSearch1.setForeground(new java.awt.Color(255, 102, 204));
        bynSearch1.setText("Search");
        bynSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bynSearch1ActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 102, 204));
        jLabel3.setText("Quantity>=");

        txtQuantity.setForeground(new java.awt.Color(255, 102, 204));
        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });

        tableProducts1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Product ID", "Brand", "Quantity", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableProducts1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnViewDetail1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelete1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboProdID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBrand1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboProdName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 301, Short.MAX_VALUE)))
                .addComponent(bynSearch1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboProdID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(ComboBrand1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(comboProdName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bynSearch1)
                    .addComponent(jLabel3)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(btnViewDetail1)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(85, 85, 85))
        );

        jtabWork.addTab("View Products", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 237, 237));

        jLabel15.setForeground(new java.awt.Color(255, 102, 204));
        jLabel15.setText("Supplier ID");

        comboSupplierID.setForeground(new java.awt.Color(255, 102, 204));
        comboSupplierID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Supplier ID", "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel16.setForeground(new java.awt.Color(255, 102, 204));
        jLabel16.setText("Supplier Name");

        comboSupplierName.setForeground(new java.awt.Color(255, 102, 204));
        comboSupplierName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Supplier Name", "Item 1", "Item 2", "Item 3", "Item 4" }));

        tableAllSuppliers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier ID", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableAllSuppliers);
        if (tableAllSuppliers.getColumnModel().getColumnCount() > 0) {
            tableAllSuppliers.getColumnModel().getColumn(0).setResizable(false);
            tableAllSuppliers.getColumnModel().getColumn(1).setResizable(false);
        }

        btnAddSupplier.setForeground(new java.awt.Color(255, 102, 204));
        btnAddSupplier.setText("Sign Selected Supplier");
        btnAddSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSupplierActionPerformed(evt);
            }
        });

        btnSearch.setForeground(new java.awt.Color(255, 102, 204));
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnViewSupplier2.setForeground(new java.awt.Color(255, 102, 204));
        btnViewSupplier2.setText("View Details");
        btnViewSupplier2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewSupplier2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboSupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(comboSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)
                        .addComponent(btnSearch))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnViewSupplier2))))
                .addContainerGap(328, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(comboSupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(comboSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnViewSupplier2)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddSupplier)))
                .addContainerGap(140, Short.MAX_VALUE))
        );

        jtabWork.addTab("View All Suppliers", jPanel4);

        jPanel1.setBackground(new java.awt.Color(255, 237, 237));

        jLabel17.setForeground(new java.awt.Color(255, 102, 204));
        jLabel17.setText("Supplier ID");

        comboSupplierID1.setForeground(new java.awt.Color(255, 102, 204));
        comboSupplierID1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Supplier ID", "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel23.setForeground(new java.awt.Color(255, 102, 204));
        jLabel23.setText("Supplier Name");

        comboSupplierName1.setForeground(new java.awt.Color(255, 102, 204));
        comboSupplierName1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Supplier Name", "Item 1", "Item 2", "Item 3", "Item 4" }));

        tableSuppliersCon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier ID", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tableSuppliersCon);
        if (tableSuppliersCon.getColumnModel().getColumnCount() > 0) {
            tableSuppliersCon.getColumnModel().getColumn(0).setResizable(false);
            tableSuppliersCon.getColumnModel().getColumn(1).setResizable(false);
        }

        btnSearch1.setForeground(new java.awt.Color(255, 102, 204));
        btnSearch1.setText("Search");
        btnSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch1ActionPerformed(evt);
            }
        });

        btnDeleteSupplier1.setForeground(new java.awt.Color(255, 102, 204));
        btnDeleteSupplier1.setText("Contract termination");
        btnDeleteSupplier1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSupplier1ActionPerformed(evt);
            }
        });

        btnViewSupplier1.setForeground(new java.awt.Color(255, 102, 204));
        btnViewSupplier1.setText("View Details");
        btnViewSupplier1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewSupplier1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1181, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(94, 94, 94)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(comboSupplierID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(52, 52, 52)
                            .addComponent(jLabel23)
                            .addGap(18, 18, 18)
                            .addComponent(comboSupplierName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(103, 103, 103)
                            .addComponent(btnSearch1))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnViewSupplier1)
                                .addComponent(btnDeleteSupplier1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(303, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(comboSupplierID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23)
                        .addComponent(comboSupplierName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearch1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addComponent(btnViewSupplier1)
                            .addGap(18, 18, 18)
                            .addComponent(btnDeleteSupplier1)))
                    .addContainerGap(108, Short.MAX_VALUE)))
        );

        jtabWork.addTab("View Contracted Suppliers", jPanel1);

        jPanel5.setBackground(new java.awt.Color(255, 237, 237));

        jLabel7.setForeground(new java.awt.Color(255, 102, 204));
        jLabel7.setText("Requests for suppliers");

        tableSupplierResond.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RequestDate", "Sender", "Message", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(tableSupplierResond);

        btnViewDetail.setForeground(new java.awt.Color(255, 102, 204));
        btnViewDetail.setText("View Details");
        btnViewDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnViewDetail)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(0, 174, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnViewDetail)
                .addContainerGap(169, Short.MAX_VALUE))
        );

        jtabWork.addTab("Supplier Requests", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtabWork)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshTestJButton)
                        .addGap(93, 93, 93))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(refreshTestJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtabWork))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTestJButtonActionPerformed

       populateTableSupplier();
       populateComboSupplier(); 
       populateComboProductBrand();
       populateComboProductName((String)comboBrand.getSelectedItem());
       populatePanelView();
    }//GEN-LAST:event_refreshTestJButtonActionPerformed

    protected void populatePanelView(){
       populateComboProductIDView();
       populateComboProductNameView();
       populateomboProductBrandView();
       populateTableProductView();
     
    }
    
    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        String ProdNameStr = (String)comboProdName.getSelectedItem();
        String brandStr = (String)comboBrand.getSelectedItem();
        String descrStr = txtDescription.getText();
        int quantity = Integer.parseInt(txtNum.getText());
        Product product = productDirectory.addProduct();
        product.setProdName(ProdNameStr);
        product.setProdBrand(brandStr);
        product.setProdNum(quantity);
        product.setDescription(descrStr);
        
        try{
            product.setProdId(productDirectory.getProductList().size()+1);
            try{
                product.setProdPrice(Double.parseDouble(txtPrice.getText()));
                productDirectory.getProductList().add(product);
                
                populatePanelView();
                JOptionPane.showMessageDialog(null, "Product Created successfully!");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Product Price must be an number"); 
            }
            
        }    
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Product ID must be an integer");
        }
       
        
        System.out.println("是否在里面? "+productDirectory.getProductList().contains(product));
        System.out.println("照片的路径? "+product.getPicpath());
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnViewDetail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetail1ActionPerformed
        // TODO add your handling code here:
        int selectedRow = tableProducts1.getSelectedRow();
        if (selectedRow >= 0 ){
            Product p = (Product) tableProducts1.getValueAt(selectedRow, 0);
            ViewProductDetailPanel panel = new ViewProductDetailPanel(userProcessContainer,p);
            userProcessContainer.add("ViewProductPanel",panel);
            CardLayout layout = (CardLayout)userProcessContainer.getLayout();
            layout.show(userProcessContainer,"ViewProductPanel");
        }
        else
            JOptionPane.showMessageDialog(null, "Please select any rows");
    }//GEN-LAST:event_btnViewDetail1ActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        // TODO add your handling code here:
        int selectedRow = tableProducts1.getSelectedRow();
        if (selectedRow >= 0 ){
           Product p = (Product) tableProducts1.getValueAt(selectedRow, 0);
            productDirectory.getProductList().remove(p);
            populateTableProductView();
        }
        else
            JOptionPane.showMessageDialog(null, "Please select any rows");
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void btnUploadImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadImgActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        
        int result = chooser.showOpenDialog(null);
				if(result==JFileChooser.APPROVE_OPTION){
					String name = chooser.getSelectedFile().getPath();
					ImageIcon icon = new ImageIcon(name);
					Image image = icon.getImage();
					Image newImage = image.getScaledInstance(labelImg.getWidth(), labelImg.getHeight(), Image.SCALE_DEFAULT);
					icon.setImage(newImage);
                                        product.setPicpath(icon);
                                        labelImg.setIcon(icon);
        }                                        
   
    }//GEN-LAST:event_btnUploadImgActionPerformed

    private void txtNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumActionPerformed

    private void bynSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bynSearch1ActionPerformed
        // TODO add your handling code here:
        String str = (String)comboProdID1.getSelectedItem();
        int prodID = Integer.parseInt(str);
        String prodName = (String)comboProdName1.getSelectedItem();
        String prodBrand = (String)ComboBrand1.getSelectedItem();
        ArrayList<Product> tempProd = new ArrayList<Product>();
        if(!txtQuantity.getText().equals(""))
        {    
            try{
                int quantity = Integer.parseInt(txtQuantity.getText());
                

                for(Product pr:productDirectory.getProductList()){
                    if(pr.getProdId()==prodID||pr.getProdName().equals(prodName)||pr.getProdNum()>=quantity||pr.getProdBrand().equals(prodBrand)){
                        tempProd.add(pr);
                    }   
                }
        
                DefaultTableModel model = (DefaultTableModel) tableProducts1.getModel();
                model.setRowCount(0);
                
                for (Product prod : tempProd){
                    Object[] row = new Object[5];
                    row[0] = prod;
                    row[1] = prod.getProdId();
                    row[2] = prod.getProdBrand();
                    row[3] = prod.getProdNum();
                    row[4] = prod.getProdPrice();

                    model.addRow(row);
                }
        /*comboProdID1.setSelectedIndex(0);
        comboProdName1.setSelectedIndex(0);
        ComboBrand1.setSelectedIndex(0);*/
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Quantity must be a number");
            }
        }
        
        else{
            for(Product pr:productDirectory.getProductList()){
                    if(pr.getProdId()==prodID||pr.getProdName().equals(prodName)||pr.getProdBrand().equals(prodBrand)){
                        tempProd.add(pr);
                    }   
                }
        
                DefaultTableModel model = (DefaultTableModel) tableProducts1.getModel();
                model.setRowCount(0);
                
                for (Product prod : tempProd){
                    Object[] row = new Object[5];
                    row[0] = prod;
                    row[1] = prod.getProdId();
                    row[2] = prod.getProdBrand();
                    row[3] = prod.getProdNum();
                    row[4] = prod.getProdPrice();

                    model.addRow(row);
                }
        }
    }//GEN-LAST:event_bynSearch1ActionPerformed

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void btnAddSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSupplierActionPerformed
        // TODO add your handling code here:
        int selectedRow = tableAllSuppliers.getSelectedRow();
        int res = JOptionPane.showConfirmDialog(null, "Are you sure that you want to send request to selected supplier?", "Ensure to send request",JOptionPane.YES_NO_OPTION); 
       
        if (selectedRow >= 0 ){
            
            if(res == JOptionPane.YES_OPTION){
                Supplier su = (Supplier) tableAllSuppliers.getValueAt(selectedRow, 0);
                if(supplierConList.contains(su)){
                    JOptionPane.showMessageDialog(null, "You have already have a contract with this supplier!");
                }
                
                else{
                    SignSupplierRequest request = new SignSupplierRequest();
                    request.setSender(userAccount);
                    request.setStatus("Wait for supplier respond");
                    request.setMessage(su.getSupplierName());

                    Enterprise supplierAgency = getSupplierAgency();
                    for (Organization organization : supplierAgency.getOrganizationDirectory().getOrganizationList()){
                        if (organization instanceof ContractorProductOrganization){
                            organization.getWorkQueue().getWorkRequestList().add(request);
                            this.organization.getWorkQueue().getWorkRequestList().add(request);
                            JOptionPane.showMessageDialog(null, "Request sent!");
                            populateTableSupplierRespond();
                            break;
                        }
                    }
                }
            }
        }
            //populateCheckTable();
        else{
            JOptionPane.showMessageDialog(null, "Please select a row!");
        }
    }//GEN-LAST:event_btnAddSupplierActionPerformed

    private void ComboBrand1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBrand1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBrand1ActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String str = (String)comboSupplierID.getSelectedItem();
        int supID = Integer.parseInt(str);
        String supName = (String)comboSupplierName.getSelectedItem();
        ArrayList<Supplier> tempSup = new ArrayList<Supplier>();
        
        
        for(Supplier sup:supplierDirectory.getSupplierList()){
            
            
            if(sup.getSupplierID()==supID||sup.getSupplierName().equals(supName)){
                tempSup.add(sup);
            }   
        }
        
        DefaultTableModel model = (DefaultTableModel) tableAllSuppliers.getModel();
        
            model.setRowCount(0);
            for (Supplier supplier : tempSup){
                Object[] row = new Object[2];
                row[0] = supplier;
                row[1] = supplier.getSupplierName();

                model.addRow(row);
            }
        comboSupplierID.setSelectedIndex(0);
        comboSupplierName.setSelectedIndex(0);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void comboBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBrandActionPerformed
         populateComboProductName((String)comboBrand.getSelectedItem());
// TODO add your handling code here:
        
    }//GEN-LAST:event_comboBrandActionPerformed

    private void btnSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch1ActionPerformed
        // TODO add your handling code here:
        String str = (String)comboSupplierID1.getSelectedItem();
        int supID = Integer.parseInt(str);
        String supName = (String)comboSupplierName1.getSelectedItem();
        ArrayList<Supplier> tempSup = new ArrayList<Supplier>();
        
        
        for(Supplier sup:supplierConList){
            
            
            if(sup.getSupplierID()==supID||sup.getSupplierName().equals(supName)){
                tempSup.add(sup);
            }   
        }
        
        DefaultTableModel model = (DefaultTableModel) tableSuppliersCon.getModel();
        
            model.setRowCount(0);
            for (Supplier supplier : tempSup){
                Object[] row = new Object[2];
                row[0] = supplier;
                row[1] = supplier.getSupplierName();

                model.addRow(row);
            }
        comboSupplierID1.setSelectedIndex(0);
        comboSupplierName1.setSelectedIndex(0);
    }//GEN-LAST:event_btnSearch1ActionPerformed

    private void btnDeleteSupplier1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSupplier1ActionPerformed
        // TODO add your handling code here:
        int selectedRow = tableSuppliersCon.getSelectedRow();
        if (selectedRow >= 0 ){
            int res = JOptionPane.showConfirmDialog(null, "Are you sure to delete this supplier?", "Yes or No", JOptionPane.YES_NO_OPTION);
            if(res == JOptionPane.YES_OPTION){
                Supplier s = (Supplier) tableSuppliersCon.getValueAt(selectedRow, 0);
                for(WorkRequest wr:organization.getWorkQueue().getWorkRequestList()){
                    if(s.getSupplierName().equals(wr.getMessage())){
                        wr.setStatus("Contract ends");
                    }
                }
                supplierConList.remove(s);
               
                
    
                populateTableSupplierCon();
                populateComboSupplier1();
                populateTableProductView();
                
               
            }
        }
        
        else
        JOptionPane.showMessageDialog(null, "Please select a supplier");
    }//GEN-LAST:event_btnDeleteSupplier1ActionPerformed

    private void btnViewSupplier1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewSupplier1ActionPerformed
        // TODO add your handling code here:
        int selectedRow = tableSuppliersCon.getSelectedRow();
        if (selectedRow >= 0 ){
            Supplier s = (Supplier) tableSuppliersCon.getValueAt(selectedRow, 0);
            ViewSupplierDetailPanel viewSupplierPanel = new ViewSupplierDetailPanel(userProcessContainer,s);
            userProcessContainer.add("ViewSupplierJPanel",viewSupplierPanel);
            CardLayout layout = (CardLayout)userProcessContainer.getLayout();
            layout.show(userProcessContainer, "ViewSupplierJPanel");
        }
        else
        JOptionPane.showMessageDialog(null, "Please select a supplier");

    }//GEN-LAST:event_btnViewSupplier1ActionPerformed

    private void btnViewSupplier2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewSupplier2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewSupplier2ActionPerformed

    private void btnApproveRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveRequestActionPerformed
        // TODO add your handling code here:
        int selectedRow = tableSalesRequest.getSelectedRow();
        if (selectedRow >= 0 ){
            WMOrderCheckWorkRequest req = (WMOrderCheckWorkRequest) tableSalesRequest.getValueAt(selectedRow, 0);
            int orderID = Integer.parseInt(req.toString());
            for(Order o:orderDirectory.getOrderList()){
                if(o.getOrderID() == orderID){
                    productDirectory.modifyProductNumCheckStatus(o);
                    req.setStatus("Completed");
                    req.setResolveDate(new Date());
                    req.setReceiver(userAccount);
                    System.out.println("Order id: "+orderID);
                    JOptionPane.showMessageDialog(null, "Request Approved! Product quantity updated!");
                }
            }
            
        }
        else
            JOptionPane.showMessageDialog(null, "Please select any rows");
        
        
        
    }//GEN-LAST:event_btnApproveRequestActionPerformed

    private void comboProdNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProdNameActionPerformed
    String ProdNameStr = (String)comboProdName.getSelectedItem();
        String brandStr = (String)comboBrand.getSelectedItem();
        for (Supplier s: supplierDirectory.getSupplierList()) {
            if(s.getSupplierName().equals(brandStr)){
                //System.out.println("让我看看brand名字brandStr:  "+brandStr);
                for(int i=0;i<s.getProList().size();i++){
                    if(s.getProList().get(i).getName().equals(ProdNameStr))
                        txtNum.setText(String.valueOf(s.getProList().get(i).getQuantity()));
                }
                
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_comboProdNameActionPerformed

    private void btnViewDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetailActionPerformed
        // TODO add your handling code here:
        int selectedRow = tableSupplierResond.getSelectedRow();
        if (selectedRow >= 0 ){
            SignSupplierRequest req = (SignSupplierRequest) tableSupplierResond.getValueAt(selectedRow, 0);
            ViewRequestPanel panel = new ViewRequestPanel(userProcessContainer,req);
            userProcessContainer.add("ViewRequestPanel",panel);
            CardLayout layout = (CardLayout)userProcessContainer.getLayout();
            layout.show(userProcessContainer,"ViewRequestPanel");
        }
        else
            JOptionPane.showMessageDialog(null, "Please select any rows");
    }//GEN-LAST:event_btnViewDetailActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBrand1;
    private javax.swing.JPanel CreateProdPanel;
    private javax.swing.JButton btnAddSupplier;
    private javax.swing.JButton btnApproveRequest;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnDeleteSupplier1;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearch1;
    private javax.swing.JButton btnUploadImg;
    private javax.swing.JButton btnViewDetail;
    private javax.swing.JButton btnViewDetail1;
    private javax.swing.JButton btnViewSupplier1;
    private javax.swing.JButton btnViewSupplier2;
    private javax.swing.JButton bynSearch1;
    private javax.swing.JComboBox<String> comboBrand;
    private javax.swing.JComboBox<String> comboProdID1;
    private javax.swing.JComboBox<String> comboProdName;
    private javax.swing.JComboBox<String> comboProdName1;
    private javax.swing.JComboBox<String> comboSupplierID;
    private javax.swing.JComboBox<String> comboSupplierID1;
    private javax.swing.JComboBox<String> comboSupplierName;
    private javax.swing.JComboBox<String> comboSupplierName1;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jtabWork;
    private javax.swing.JLabel labelImg;
    private javax.swing.JLabel numLabel;
    private javax.swing.JLabel numLabel1;
    private javax.swing.JLabel numLabel2;
    private javax.swing.JButton refreshTestJButton;
    private javax.swing.JTable tableAllSuppliers;
    private javax.swing.JTable tableProducts1;
    private javax.swing.JTable tableSalesRequest;
    private javax.swing.JTable tableSupplierResond;
    private javax.swing.JTable tableSuppliersCon;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtNum;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables

    private void populateComboProductIDView() {
        comboProdID1.removeAllItems();
        comboProdID1.addItem("0");
        for(Product pr : productDirectory.getProductList()){
            comboProdID1.addItem(String.valueOf(pr.getProdId()));
        }
    }

    private void populateComboProductNameView() {
        comboProdName1.removeAllItems();
        comboProdName1.addItem("Select product Name");
        ArrayList<Product> productList = productDirectory.getProductList();
        ArrayList<String> productNames = new ArrayList<>();
        for(int i=0;i<productList.size();i++){
            String s = productList.get(i).getProdName();
            productNames.add(s);
        }
        
        for(String s: productNames){
            comboProdName1.addItem(s);
        }
    }

    private void populateomboProductBrandView() {
        ComboBrand1.removeAllItems();
        ComboBrand1.addItem("Select product Name");
        ArrayList<Product> productList = productDirectory.getProductList();
        ArrayList<String> productBrands = new ArrayList<>();
        for(int i=0;i<productList.size();i++){
            String s = productList.get(i).getProdBrand();
            productBrands.add(s);
        }
        
        for(String s: productBrands){
            ComboBrand1.addItem(s);
        }
        
    }

    private void populateTableProductView() {
        DefaultTableModel model = (DefaultTableModel) tableProducts1.getModel();
        
        model.setRowCount(0);
        //System.out.println("getProductList: "+productDirectory.getProductList().get(0)+"  "+productDirectory.getProductList().get(1));
        for (Product pr : productDirectory.getProductList()){
            Object[] row = new Object[5];
            row[0] = pr;
            row[1] = pr.getProdId();
            row[2] = pr.getProdBrand();
            row[3] = pr.getProdNum();
            row[4] = pr.getProdPrice();

            model.addRow(row);
        }
        
    }

   
   
    
    private final Network getNetwork(){
       
        for(Network network: networkList){
            if(network.getName().equals("1")){
                System.out.println("看看network: "+network);
                return network;
            }
        }
        return null;
    }
    
    private final Organization getSaleOrganization(){
    
    
       return null;
    }
    
    private final Enterprise getSupplierAgency(){
        Network net = getNetwork();
        
        for(Enterprise enterprise:net.getEnterpriseDirectory().getEnterpriseList()){
            System.out.println("Let me see the enterprise Name: "+enterprise.getName());
            if(enterprise.getName().equals("Supplier Agency"))
                return enterprise;
        } 
        
        return null;
    }
    
    private void populateTableSalesRequest(){
        DefaultTableModel model = (DefaultTableModel) tableSalesRequest.getModel();
        model.setRowCount(0);
        ArrayList<WorkRequest> reqs = getSalesRequests();
        
        for (WorkRequest request : reqs){
            Object[] row = new Object[5];
            row[0] = request;
            row[1] = request.getSender();
            row[2] = request.getStatus();
            row[3] = request.getRequestDate();
            model.addRow(row);
        }
    
    }
    
    private void populateTableSupplierRespond(){
    
        DefaultTableModel model = (DefaultTableModel) tableSupplierResond.getModel();
        model.setRowCount(0);
        ArrayList<WorkRequest> reqs = getSupplierRequests();
        for (WorkRequest request : reqs){
                Object[] row = new Object[5];
                row[0] = request;
                row[1] = request.getSender();//delete
                row[2] = request.getMessage();
                row[3] = request.getStatus();
                model.addRow(row);
            
        }
        
    
    
    
    }

    private void populateTableSupplierCon() {
        DefaultTableModel model = (DefaultTableModel) tableSuppliersCon.getModel();

        model.setRowCount(0);
        
        
        for (Supplier su : supplierConList){
            Object[] row = new Object[2];
            row[0] = su;
            row[1] = su.getSupplierName();
            model.addRow(row);
        }
        
    }
    
    private ArrayList<Supplier> getSupplierConList(){
    
        ArrayList<WorkRequest> reqs = getSupplierRequests();
        ArrayList<String> supplierNameList = new ArrayList<>();
        ArrayList<Supplier> list = new ArrayList<>();
        for (WorkRequest request : reqs){
            if(request.getStatus().equals("Request approved"))
                supplierNameList.add(request.getMessage());
        }
        HashSet<String> set = new HashSet<String>(supplierNameList);
        ArrayList<String> supNames = new ArrayList<>(set);
        
        for(Supplier s: supplierDirectory.getSupplierList()){
            for(String s1:supNames)
            {
                if(s.getSupplierName().equals(s1)){
                    list.add(s);
                }
            }
        }
        
        return list;
    
    }
    
    private ArrayList<WorkRequest> getSupplierRequests(){
    
        ArrayList<WorkRequest> reList =organization.getWorkQueue().getWorkRequestList();
        ArrayList<WorkRequest> reqs = new ArrayList<>();
        for(WorkRequest req:reList){
            //System.out.println("req.getStatus()+ "+req.getStatus());
            if(req.getStatus().equals("Request declined")||req.getStatus().equals("Request approved")||req.getStatus().equals("Wait for supplier respond")){
                reqs.add(req);
            }
        }
    
    return reqs;
    }
    
    private ArrayList<WorkRequest> getSalesRequests(){
    
        ArrayList<WorkRequest> reList =organization.getWorkQueue().getWorkRequestList();
        ArrayList<WorkRequest> reqs = new ArrayList<>();
        for(WorkRequest req:reList){
            //System.out.println("req.getStatus()+ "+req.getStatus());
            if(!getSupplierRequests().contains(req)&&!req.getStatus().equals("Contractor ends")){
                reqs.add(req);
            }
        }
    
    return reqs;
    }
    
    /*for(Product pr: productDirectory.getProductList()){
                        if(!pr.getProdBrand().equals(s.getSupplierName())){
                        productDirectory.getProductList().remove(pr);
                        }
                }*/

//    private void givesale() {
//        
//        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
//            if (organization instanceof SalesPersonOrganization){
//            ((SalesPersonOrganization) organization).setProductDirectory(productDirectory);
//            }
//
//        }
//    }
    
}
