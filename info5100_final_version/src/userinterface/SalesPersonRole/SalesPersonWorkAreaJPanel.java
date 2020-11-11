/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SalesPersonRole;

import Business.Dao.CourierOrder;
import Business.Dao.Customer;
import Business.Dao.CustomerDirectory;
import Business.Dao.Order;
import Business.Dao.OrderDirectory;
import Business.Dao.Product;
import Business.Dao.ProductDirectory;
import userinterface.CustomerServiceWorkArea.*;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.AssignCenterOrganization;
import Business.Organization.CustomerManagerOrganization;
import Business.Organization.CustomerServiceOrganization;
import Business.Organization.Organization;
import Business.Organization.SalesPersonOrganization;
import Business.Organization.WarehouseOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.CMOrderCheckWorkRequest;
import Business.WorkQueue.CMOrderPlacedWorkRequest;
import Business.WorkQueue.CreateCurorderWorkRequest;
import Business.WorkQueue.WMOrderCheckWorkRequest;
import Business.WorkQueue.WMOrderPlacedWorkRequest;
import Business.WorkQueue.WorkQueue;
//import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.WorkRequest;
import Utils.ArrayListComboBoxModel;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author llm
 */
public class SalesPersonWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private SalesPersonOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private ProductDirectory  productDirectory;
    private OrderDirectory  orderDirectory;
    private CustomerDirectory  customerDirectory;
    private EcoSystem system;
    private Network network;
    private static int TransportNum;
    
    /**
     * Creates new form SalesPersonWorkAreaJPanel
     */
    public SalesPersonWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, 
            SalesPersonOrganization organization, Enterprise enterprise,EcoSystem system,
            
            CustomerDirectory  customerDirectory) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        for (Organization or : enterprise.getOrganizationDirectory().getOrganizationList()){
                if (or instanceof WarehouseOrganization){
                    this.productDirectory = ((WarehouseOrganization) or).getProdirect();
                    break;
                }
        }
        
        this.customerDirectory = customerDirectory;
        this.system = system;
        this.orderDirectory =  system.getOrderDirectory();
        this.network=system.searchNetwork("1");
        
        
        valueLabel.setText(enterprise.getName());
        populateCheckTable(orderDirectory.getOrderList());
        viewProductList(productDirectory);
        viewCustomerList(customerDirectory);
        populatePlaceTable(orderDirectory.getOrderList());
        populateWorkQueueTable(userAccount.getWorkQueue().getWorkRequestList());
        populateCompletedTable(orderDirectory.getOrderList());
    }
    
    
    public void populateCheckTable(ArrayList<Order> ol){
        DefaultTableModel model = (DefaultTableModel) checkOrderJTable.getModel();
        int count = 0;
        model.setRowCount(0);
        for (Order o : ol){
            Object[] row = new Object[2];
            if(o.getStatus()==0 ||o.getStatus()==1 
                    ||o.getStatus()==11 ||o.getStatus()==12 
                    ||o.getStatus()==21 ||o.getStatus()==22){
                row[0] = o;
                row[1] = getStatus(o.getStatus());
                model.addRow(row);
            }
            if(o.getStatus()==0 ||o.getStatus()==1 ){
                count +=1;
            }
        }
        
        checkjLabel.setText(count+"");
        
    }
    
    public void populatePlaceTable(ArrayList<Order> ol){
        DefaultTableModel model = (DefaultTableModel) placeJTable.getModel();
        int count = 0;
        model.setRowCount(0);
        for (Order o : ol){
            Object[] row = new Object[2];
            if(o.getStatus()==2 ||o.getStatus()==3 ||o.getStatus()==4 
                    ||o.getStatus()==5  ){
                row[0] = o;
                row[1] = getStatus(o.getStatus());
                model.addRow(row);
            }
            if(o.getStatus()==2 ){
                count +=1;
            }
            
        }
        placejLabel.setText(count+"");
    }
    
    public void populateWorkQueueTable(ArrayList<WorkRequest> wl){
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        
        model.setRowCount(0);
        for (WorkRequest w : wl){
            Object[] row = new Object[5];
            row[0] = w;
            row[1] = w.getReceiver();
            row[2] = w.getStatus();
            row[3] = w.getRequestDate();
            row[4] = w.getResolveDate();
            model.addRow(row);
            
            
        }
    }
    
    public void populateCompletedTable(ArrayList<Order> ol){
        DefaultTableModel model = (DefaultTableModel) completedTable.getModel();
        int count = 0;
        model.setRowCount(0);
        for (Order o : ol){
            Object[] row = new Object[2];
            if(o.getStatus()==7||o.getStatus()==6){
                row[0] = o;
                row[1] = getStatus(o.getStatus());
                model.addRow(row);
            }
            if(o.getStatus()==7){
               count+=1;
            }    
            
        }
        completedjLabel.setText(count+"");
    }
    
    public int setStatus(String status){
        switch(status){
            case("Hasn't sent any check requests"):
                return 0;
     
            case("Balance is checked"):
                return 1;
                
            case("Wating for Customer Manager to process"):
                return 11;
                
            case("Don't have enough money"):
                return 12;    
                
            case("Balance and storage are checked"):
                return 2;
            
            case("Wating for Warehouse Manager to process"):
                return 21; 
                
            case("Don't have enough products"):
                return 22;
            
            case("Order been placed"):
                return 3;
            
            case("Start shipping"):
                return 4;
                
            case("Finish shipping"):
                return 5;
            
            case("Order canceled"):
                return 6;
            
            case("Order completed"):
                return 7;    
        }
        return -1;
    }
    
        public String getStatus(int status){
        switch(status){
            case(0):
                return "Hasn't sent any check requests";
     
            case(1):
                return "Balance is checked";
                
            case(11):
                return "Wating for Customer Manager to process";
                
            case(12):
                return "Don't have enough money";    
                
            case(2):
                return "Balance and storage are checked";
            
            case(21):
                return "Wating for Warehouse Manager to process"; 
                
            case(22):
                return "Don't have enough products";
            
            case(3):
                return "Order been placed";
            
            case(4):
                return "Start shipping";
                
            case(5):
                return "Finish shipping";
            
            case(6):
                return "Order canceled";
            
            case(7):
                return "Order completed";    
        }
        return null;
    }
    
    public void viewProductList(ProductDirectory  productDirectory){
        ArrayListComboBoxModel model_id = new ArrayListComboBoxModel(productDirectory.getProductIDList());
        ArrayListComboBoxModel model_name = new ArrayListComboBoxModel(productDirectory.getProductNameList());
        
        productSearchComboBox.setModel(model_id);
        productSearchComboBox1.setModel(model_id);
        productSearchComboBox2.setModel(model_id);
        productComboBox.setModel(model_name);

        
    }
    
    public void viewCustomerList(CustomerDirectory  customerDirectory){
        ArrayListComboBoxModel model_id = new ArrayListComboBoxModel(customerDirectory.getCustomerIDList());
        customerComboBox.setModel(model_id);
        customerSearchComboBox.setModel(model_id);
        customerSearchComboBox1.setModel(model_id);
        customerSearchComboBox2.setModel(model_id);
    
        
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        completedjLabel = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        checkjLabel = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        placejLabel = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        customerLabel = new javax.swing.JLabel();
        customerComboBox = new javax.swing.JComboBox<>();
        productLabel = new javax.swing.JLabel();
        productComboBox = new javax.swing.JComboBox<>();
        createBtn = new javax.swing.JButton();
        numLabel = new javax.swing.JLabel();
        numberTextField = new javax.swing.JTextField();
        numLabel1 = new javax.swing.JLabel();
        addressTextField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        productSearchComboBox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        customerSearchComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        checkOrderJTable = new javax.swing.JTable();
        requestCMbtn = new javax.swing.JButton();
        requestWMbtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        statusComboBox = new javax.swing.JComboBox<>();
        detailBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        searchBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        productSearchComboBox1 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        customerSearchComboBox1 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        statusComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        placeJTable = new javax.swing.JTable();
        detailBtn1 = new javax.swing.JButton();
        updateBtn1 = new javax.swing.JButton();
        placeBtn = new javax.swing.JButton();
        moveBtn = new javax.swing.JButton();
        searchBtn1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        productSearchComboBox2 = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        customerSearchComboBox2 = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        statusComboBox2 = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        completedTable = new javax.swing.JTable();
        detailBtn2 = new javax.swing.JButton();
        deleteBtn2 = new javax.swing.JButton();
        searchBtn2 = new javax.swing.JButton();

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

        jTabbedPane1.setForeground(new java.awt.Color(255, 102, 204));

        jPanel6.setBackground(new java.awt.Color(255, 237, 237));

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OrderID", "Receiver", "Status", "RequestDate", "ResolveDate"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(workRequestJTable);
        if (workRequestJTable.getColumnModel().getColumnCount() > 0) {
            workRequestJTable.getColumnModel().getColumn(0).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(1).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(2).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(3).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(4).setResizable(false);
        }

        completedjLabel.setForeground(new java.awt.Color(0, 153, 0));
        completedjLabel.setText("0");

        jLabel18.setForeground(new java.awt.Color(255, 102, 204));
        jLabel18.setText("Orders Completed");

        checkjLabel.setForeground(new java.awt.Color(255, 0, 0));
        checkjLabel.setText("0");

        jLabel20.setForeground(new java.awt.Color(255, 102, 204));
        jLabel20.setText("Orders need to be checked");

        placejLabel.setForeground(new java.awt.Color(255, 0, 0));
        placejLabel.setText("0");

        jLabel22.setForeground(new java.awt.Color(255, 102, 204));
        jLabel22.setText("Orders need to be placed");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(completedjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)
                        .addGap(57, 57, 57)
                        .addComponent(checkjLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(placejLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel22))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(326, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22)
                        .addComponent(placejLabel))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(completedjLabel)
                        .addComponent(jLabel18)
                        .addComponent(jLabel20)
                        .addComponent(checkjLabel)))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("WorkArea", jPanel6);

        jPanel1.setBackground(new java.awt.Color(255, 237, 237));
        jPanel1.setForeground(new java.awt.Color(255, 102, 204));

        customerLabel.setForeground(new java.awt.Color(255, 102, 204));
        customerLabel.setText("Customer ID");

        customerComboBox.setForeground(new java.awt.Color(255, 102, 204));
        customerComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

        productLabel.setForeground(new java.awt.Color(255, 102, 204));
        productLabel.setText("Product Name");

        productComboBox.setForeground(new java.awt.Color(255, 102, 204));
        productComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        createBtn.setForeground(new java.awt.Color(255, 102, 204));
        createBtn.setText("Create");
        createBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBtnActionPerformed(evt);
            }
        });

        numLabel.setForeground(new java.awt.Color(255, 102, 204));
        numLabel.setText("Number");

        numberTextField.setForeground(new java.awt.Color(255, 102, 204));

        numLabel1.setForeground(new java.awt.Color(255, 102, 204));
        numLabel1.setText("Address");

        addressTextField.setForeground(new java.awt.Color(255, 102, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(351, 351, 351)
                        .addComponent(createBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(numLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(productLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(customerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(numLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(90, 90, 90)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(customerComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(productComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(numberTextField)
                            .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(414, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerLabel)
                    .addComponent(customerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productLabel)
                    .addComponent(productComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numLabel)
                    .addComponent(numberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numLabel1)
                    .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addComponent(createBtn)
                .addGap(33, 33, 33))
        );

        jTabbedPane1.addTab("Create Orders", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 237, 237));

        jLabel3.setForeground(new java.awt.Color(255, 102, 204));
        jLabel3.setText("Order ID");

        jTextField2.setForeground(new java.awt.Color(255, 102, 204));

        jLabel4.setForeground(new java.awt.Color(255, 102, 204));
        jLabel4.setText("Product ID");

        productSearchComboBox.setForeground(new java.awt.Color(255, 102, 204));
        productSearchComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        productSearchComboBox.setSelectedIndex(-1);

        jLabel8.setForeground(new java.awt.Color(255, 102, 204));
        jLabel8.setText("Customer ID");

        customerSearchComboBox.setForeground(new java.awt.Color(255, 102, 204));
        customerSearchComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        customerSearchComboBox.setSelectedIndex(-1);

        checkOrderJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(checkOrderJTable);
        if (checkOrderJTable.getColumnModel().getColumnCount() > 0) {
            checkOrderJTable.getColumnModel().getColumn(0).setResizable(false);
            checkOrderJTable.getColumnModel().getColumn(1).setResizable(false);
        }

        requestCMbtn.setForeground(new java.awt.Color(255, 102, 204));
        requestCMbtn.setText("Send Check Request to Customer Manager");
        requestCMbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestCMbtnActionPerformed(evt);
            }
        });

        requestWMbtn.setForeground(new java.awt.Color(255, 102, 204));
        requestWMbtn.setText("Send Check Request to Warehouse Manager");
        requestWMbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestWMbtnActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 102, 204));
        jLabel9.setText("Status");

        statusComboBox.setForeground(new java.awt.Color(255, 102, 204));
        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hasn't sent any check requests", "Balance is checked", "Wating for Customer Manager to process", "Don't have enough money\"", "Storage is checked", "Wating for Warehouse Manager to process", "Don't have enough products" }));
        statusComboBox.setSelectedIndex(-1);

        detailBtn.setForeground(new java.awt.Color(255, 102, 204));
        detailBtn.setText("View Details");
        detailBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailBtnActionPerformed(evt);
            }
        });

        updateBtn.setForeground(new java.awt.Color(255, 102, 204));
        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        deleteBtn.setForeground(new java.awt.Color(255, 102, 204));
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        searchBtn.setForeground(new java.awt.Color(255, 102, 204));
        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(detailBtn)
                            .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(requestCMbtn)
                        .addGap(18, 18, 18)
                        .addComponent(requestWMbtn))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productSearchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(customerSearchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchBtn)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(productSearchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(customerSearchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(detailBtn)
                        .addGap(12, 12, 12)
                        .addComponent(updateBtn)
                        .addGap(18, 18, 18)
                        .addComponent(deleteBtn)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(requestCMbtn)
                    .addComponent(requestWMbtn))
                .addGap(0, 0, 0))
        );

        jTabbedPane1.addTab("Check Order Status", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 237, 237));
        jPanel3.setForeground(new java.awt.Color(255, 102, 204));

        jLabel10.setForeground(new java.awt.Color(255, 102, 204));
        jLabel10.setText("Order ID");

        jTextField3.setForeground(new java.awt.Color(255, 102, 204));

        jLabel11.setForeground(new java.awt.Color(255, 102, 204));
        jLabel11.setText("Product ID");

        productSearchComboBox1.setForeground(new java.awt.Color(255, 102, 204));
        productSearchComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        productSearchComboBox1.setSelectedIndex(-1);

        jLabel12.setForeground(new java.awt.Color(255, 102, 204));
        jLabel12.setText("Customer ID");

        customerSearchComboBox1.setForeground(new java.awt.Color(255, 102, 204));
        customerSearchComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        customerSearchComboBox1.setSelectedIndex(-1);

        jLabel13.setForeground(new java.awt.Color(255, 102, 204));
        jLabel13.setText("Status");

        statusComboBox1.setForeground(new java.awt.Color(255, 102, 204));
        statusComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Balance and storage are checked", "Order been placed", "Start shipping", "Finish shipping", "Order canceled" }));
        statusComboBox1.setSelectedIndex(-1);

        placeJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(placeJTable);
        if (placeJTable.getColumnModel().getColumnCount() > 0) {
            placeJTable.getColumnModel().getColumn(0).setResizable(false);
            placeJTable.getColumnModel().getColumn(1).setResizable(false);
        }

        detailBtn1.setForeground(new java.awt.Color(255, 102, 204));
        detailBtn1.setText("View Details");
        detailBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailBtn1ActionPerformed(evt);
            }
        });

        updateBtn1.setForeground(new java.awt.Color(255, 102, 204));
        updateBtn1.setText("Update");
        updateBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtn1ActionPerformed(evt);
            }
        });

        placeBtn.setBackground(new java.awt.Color(204, 204, 204));
        placeBtn.setForeground(new java.awt.Color(255, 102, 204));
        placeBtn.setText("Place Order");
        placeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placeBtnActionPerformed(evt);
            }
        });

        moveBtn.setForeground(new java.awt.Color(255, 102, 204));
        moveBtn.setText("Move to Completed Orders");
        moveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveBtnActionPerformed(evt);
            }
        });

        searchBtn1.setForeground(new java.awt.Color(255, 102, 204));
        searchBtn1.setText("Search");
        searchBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(placeBtn)
                        .addGap(43, 43, 43)
                        .addComponent(moveBtn))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productSearchComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(customerSearchComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(statusComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(searchBtn1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(updateBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(detailBtn1))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(productSearchComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(customerSearchComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(statusComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn1))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(detailBtn1)
                        .addGap(64, 64, 64)
                        .addComponent(updateBtn1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(placeBtn)
                    .addComponent(moveBtn))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View Checked Orders", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 237, 237));
        jPanel4.setForeground(new java.awt.Color(255, 102, 204));

        jLabel14.setForeground(new java.awt.Color(255, 102, 204));
        jLabel14.setText("Order ID");

        jTextField4.setForeground(new java.awt.Color(255, 102, 204));

        jLabel15.setForeground(new java.awt.Color(255, 102, 204));
        jLabel15.setText("Product ID");

        productSearchComboBox2.setForeground(new java.awt.Color(255, 102, 204));
        productSearchComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        productSearchComboBox2.setSelectedIndex(-1);

        jLabel16.setForeground(new java.awt.Color(255, 102, 204));
        jLabel16.setText("Customer ID");

        customerSearchComboBox2.setForeground(new java.awt.Color(255, 102, 204));
        customerSearchComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        customerSearchComboBox2.setSelectedIndex(-1);

        jLabel17.setForeground(new java.awt.Color(255, 102, 204));
        jLabel17.setText("Status");

        statusComboBox2.setForeground(new java.awt.Color(255, 102, 204));
        statusComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Order canceled", "Order completed" }));
        statusComboBox2.setSelectedIndex(-1);

        completedTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(completedTable);
        if (completedTable.getColumnModel().getColumnCount() > 0) {
            completedTable.getColumnModel().getColumn(0).setResizable(false);
            completedTable.getColumnModel().getColumn(1).setResizable(false);
        }

        detailBtn2.setForeground(new java.awt.Color(255, 102, 204));
        detailBtn2.setText("View Details");
        detailBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailBtn2ActionPerformed(evt);
            }
        });

        deleteBtn2.setForeground(new java.awt.Color(255, 102, 204));
        deleteBtn2.setText("Delete");
        deleteBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtn2ActionPerformed(evt);
            }
        });

        searchBtn2.setForeground(new java.awt.Color(255, 102, 204));
        searchBtn2.setText("Search");
        searchBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtn2ActionPerformed(evt);
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
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(detailBtn2)
                            .addComponent(deleteBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(productSearchComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(customerSearchComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(statusComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(searchBtn2)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(customerSearchComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(statusComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productSearchComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn2))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(detailBtn2)
                        .addGap(66, 66, 66)
                        .addComponent(deleteBtn2)))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View Completed Orders", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refreshTestJButton)
                .addGap(93, 93, 93))
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(refreshTestJButton)
                        .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTestJButtonActionPerformed

        populateCheckTable(orderDirectory.getOrderList());
        productSearchComboBox.setSelectedIndex(-1);
        customerSearchComboBox.setSelectedIndex(-1);
        statusComboBox.setSelectedIndex(-1);
        populatePlaceTable(orderDirectory.getOrderList());
        productSearchComboBox1.setSelectedIndex(-1);
        customerSearchComboBox1.setSelectedIndex(-1);
        statusComboBox1.setSelectedIndex(-1);
        populateWorkQueueTable(userAccount.getWorkQueue().getWorkRequestList());
        populateCompletedTable(orderDirectory.getOrderList());
        productSearchComboBox2.setSelectedIndex(-1);
        customerSearchComboBox2.setSelectedIndex(-1);
        statusComboBox2.setSelectedIndex(-1);
        
        
    }//GEN-LAST:event_refreshTestJButtonActionPerformed

    private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtnActionPerformed
        // TODO add your handling code here:
//        int orderID = Integer.parseInt(orderText.getText());
        if(numberTextField.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Numbers cannot be null");
            numberTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
            numLabel.setForeground(Color.red);
            return;
        }
        if(addressTextField.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Address cannot be null");
            addressTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
            numLabel1.setForeground(Color.red);
            return;
        }
        int customerID = Integer.parseInt(customerComboBox.getSelectedItem().toString());
        String productName = productComboBox.getSelectedItem().toString();
        int productID = -1;
        for(Product p : productDirectory.getProductList()){
            if(p.getProdName().equals(productName)){
                productID = p.getProdId();
                break;
            }
        }
        int status = 0;
        Date date = new Date();
        int num = Integer.parseInt(numberTextField.getText());
        String address = addressTextField.getText();
        Order o = new Order(orderDirectory,productID,customerID,status,date,num,address);
        double prodprice = productDirectory.getProductPrice(o)*num;
        o.setPrice(prodprice);
        system.createAndAddOrder(o);
        Customer c = customerDirectory.getCustomerByID(customerID);
        c.getOrder().add(o);
        populateCheckTable(orderDirectory.getOrderList());
//        orderText.setText("");
        customerComboBox.setSelectedIndex(-1);
        productComboBox.setSelectedIndex(-1);
        numberTextField.setText("");
        addressTextField.setText("");
        numberTextField.setBorder(BorderFactory.createLineBorder(Color.black));
        numLabel.setForeground(Color.black);
        addressTextField.setBorder(BorderFactory.createLineBorder(Color.black));
        numLabel1.setForeground(Color.black);
        
//        System.out.println(o);
    }//GEN-LAST:event_createBtnActionPerformed

    private void detailBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = checkOrderJTable.getSelectedRow();
        if (selectedRow >= 0 ){
            Order o = (Order) checkOrderJTable.getValueAt(selectedRow, 0);
            ViewOrderJPanel panel = new ViewOrderJPanel(userProcessContainer,o);
            userProcessContainer.add("ViewOrderJPanel",panel);
            CardLayout layout = (CardLayout)userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
        else
            JOptionPane.showMessageDialog(null, "Please select any rows");
    }//GEN-LAST:event_detailBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = checkOrderJTable.getSelectedRow();
        if (selectedRow >= 0 ){
            Order o = (Order) checkOrderJTable.getValueAt(selectedRow, 0);
            UpdateOrderJPanel panel = new UpdateOrderJPanel(userProcessContainer,o);
            userProcessContainer.add("UpdateOrderJPanel",panel);
            CardLayout layout = (CardLayout)userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
        else
            JOptionPane.showMessageDialog(null, "Please select any rows");
    }//GEN-LAST:event_updateBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = checkOrderJTable.getSelectedRow();
        if (selectedRow >= 0 ){
            Order o = (Order) checkOrderJTable.getValueAt(selectedRow, 0);
            o.setStatus(6);
            populateCheckTable(orderDirectory.getOrderList());
        }
        else
            JOptionPane.showMessageDialog(null, "Please select any rows");
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void requestCMbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestCMbtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = checkOrderJTable.getSelectedRow();
        if (selectedRow >= 0 ){
            Order o = (Order) checkOrderJTable.getValueAt(selectedRow, 0);
            CMOrderCheckWorkRequest request = new CMOrderCheckWorkRequest(o);
            request.setSender(userAccount);
            request.setStatus("0-Unchecked");
        
            Organization org = null;
            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
                if (organization instanceof CustomerManagerOrganization){
                    org = organization;
                    break;
                }
            }
            if (org!=null){
                org.getWorkQueue().getWorkRequestList().add(request);
                userAccount.getWorkQueue().getWorkRequestList().add(request);
            }
            o.setStatus(11);
            populateCheckTable(orderDirectory.getOrderList());
            populateWorkQueueTable(userAccount.getWorkQueue().getWorkRequestList());
        }
        else
            JOptionPane.showMessageDialog(null, "Please select any rows");
    }//GEN-LAST:event_requestCMbtnActionPerformed

    private void requestWMbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestWMbtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = checkOrderJTable.getSelectedRow();
        if (selectedRow >= 0 ){
            Order o = (Order) checkOrderJTable.getValueAt(selectedRow, 0);
            if(o.getStatus()!=1){
                JOptionPane.showMessageDialog(null,"Balance unchecked");
                return;
            }
            else{
                WMOrderCheckWorkRequest request = new WMOrderCheckWorkRequest(o);
                request.setSender(userAccount);
                request.setStatus("Sent");

                Organization org = null;
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
                    if (organization instanceof WarehouseOrganization){
                        organization.getWorkQueue().getWorkRequestList().add(request);
                        userAccount.getWorkQueue().getWorkRequestList().add(request);
                        break;
                    }
                }

                o.setStatus(21);
                populateCheckTable(orderDirectory.getOrderList());
            }
            
        }
        else
            JOptionPane.showMessageDialog(null, "Please select any rows");
    }//GEN-LAST:event_requestWMbtnActionPerformed

    private void placeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placeBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = placeJTable.getSelectedRow();
        Enterprise ens=null;
        if (selectedRow >= 0 ){
            Order o = (Order) placeJTable.getValueAt(selectedRow, 0);
            CMOrderPlacedWorkRequest request = new CMOrderPlacedWorkRequest(o);
            WMOrderPlacedWorkRequest request1 = new WMOrderPlacedWorkRequest(o);
            CreateCurorderWorkRequest request2=new CreateCurorderWorkRequest(o);
            request.setSender(userAccount);
            request.setStatus("1-Unplaced");
//            request1.setSender(userAccount);
//            request1.setStatus("Sent");
            request2.setSender(userAccount);
            request2.setStatus("Sent");
            
            CourierOrder courierOrder=new CourierOrder(new Date(), o.getOrderID());
            courierOrder.setFrom("Beijing");
            courierOrder.setTo(o.getAddress());
           
        
            Organization org = null;
            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
                if (organization instanceof CustomerManagerOrganization){
                    org = organization;
                    break;
                }
            }
            if (org!=null){
                org.getWorkQueue().getWorkRequestList().add(request);
                userAccount.getWorkQueue().getWorkRequestList().add(request);
            }
//            Organization org1 = null;
//            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
//                if (organization instanceof WarehouseOrganization){
//                    org1 = organization;
//                    break;
//                }
//            }
//            if (org1!=null){
//                org1.getWorkQueue().getWorkRequestList().add(request1);
//                userAccount.getWorkQueue().getWorkRequestList().add(request1);
//            }
//            
            Organization org2 = null;
            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
                if (organization instanceof CustomerManagerOrganization){
                    org2 = organization;
                    break;
                }
            }
            if (org2!=null){
                org2.getWorkQueue().getWorkRequestList().add(request2);
                userAccount.getWorkQueue().getWorkRequestList().add(request2);
                 for (Enterprise en : network.getEnterpriseDirectory().getEnterpriseList()) {
                if (en.getName().equals("success")) {
                    ens=en;
                }
            }
                 ens.searchOrganization("Assign Center Organization").getWorkQueue().getWorkRequestList().add(request2);
                 Organization ogss=ens.searchOrganization("Assign Center Organization");
                 if (ogss instanceof AssignCenterOrganization) {
                     courierOrder.setTransportNum(((AssignCenterOrganization) ogss).getCourierOrderList().getOrderlist().size()+1);
                    ((AssignCenterOrganization) ogss).getCourierOrderList().addOrder(courierOrder);
                }
                 
            }
            
            o.setStatus(3);
            populatePlaceTable(orderDirectory.getOrderList());
        }
        else
            JOptionPane.showMessageDialog(null, "Please select any rows");
        
        
    }//GEN-LAST:event_placeBtnActionPerformed

    private void moveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = placeJTable.getSelectedRow();
        if (selectedRow >= 0 ){
            
            Order o = (Order) placeJTable.getValueAt(selectedRow, 0);
            if(o.getStatus()!= 5){
                JOptionPane.showMessageDialog(null,"Can not move to completed orders");
                return;
            }
            else{
                o.setStatus(7);
                populatePlaceTable(orderDirectory.getOrderList());
                populateCompletedTable(orderDirectory.getOrderList());
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Please select any rows");
    }//GEN-LAST:event_moveBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
        OrderDirectory sublist = orderDirectory;
        if(statusComboBox.getSelectedIndex()!=-1){
            String s = statusComboBox.getSelectedItem().toString();
            int status = setStatus(s);
            sublist = sublist.getOrderByStatus(status,sublist);
        }
        if(productSearchComboBox.getSelectedIndex()!=-1){
            int id = (int)productSearchComboBox.getSelectedItem();
            sublist = sublist.getOrderByProductID(id,sublist);
        }
        if(customerSearchComboBox.getSelectedIndex()!=-1){
            int id = (int)customerSearchComboBox.getSelectedItem();
            sublist = sublist.getOrderByCustomerID(id,sublist);
        }
        populateCheckTable(sublist.getOrderList());   
    }//GEN-LAST:event_searchBtnActionPerformed

    private void searchBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtn1ActionPerformed
        // TODO add your handling code here:
        OrderDirectory sublist = orderDirectory;
        if(statusComboBox1.getSelectedIndex()!=-1){
            String s = statusComboBox1.getSelectedItem().toString();
            int status = setStatus(s);
            sublist = sublist.getOrderByStatus(status,sublist);
        }
        if(productSearchComboBox1.getSelectedIndex()!=-1){
            int id = (int)productSearchComboBox1.getSelectedItem();
            sublist = sublist.getOrderByProductID(id,sublist);
        }
        if(customerSearchComboBox1.getSelectedIndex()!=-1){
            int id = (int)customerSearchComboBox1.getSelectedItem();
            sublist = sublist.getOrderByCustomerID(id,sublist);
        }
        populatePlaceTable(sublist.getOrderList());   
    }//GEN-LAST:event_searchBtn1ActionPerformed

    private void searchBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtn2ActionPerformed
        // TODO add your handling code here:
        OrderDirectory sublist = orderDirectory;
        if(statusComboBox2.getSelectedIndex()!=-1){
            String s = statusComboBox2.getSelectedItem().toString();
            int status = setStatus(s);
            sublist = sublist.getOrderByStatus(status,sublist);
        }
        if(productSearchComboBox2.getSelectedIndex()!=-1){
            int id = (int)productSearchComboBox2.getSelectedItem();
            sublist = sublist.getOrderByProductID(id,sublist);
        }
        if(customerSearchComboBox2.getSelectedIndex()!=-1){
            int id = (int)customerSearchComboBox2.getSelectedItem();
            sublist = sublist.getOrderByCustomerID(id,sublist);
        }
        populateCompletedTable(sublist.getOrderList()); 
    }//GEN-LAST:event_searchBtn2ActionPerformed

    private void detailBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailBtn1ActionPerformed
        // TODO add your handling code here:
        int selectedRow = placeJTable.getSelectedRow();
        if (selectedRow >= 0 ){
            Order o = (Order) placeJTable.getValueAt(selectedRow, 0);
            ViewOrderJPanel panel = new ViewOrderJPanel(userProcessContainer,o);
            userProcessContainer.add("ViewOrderJPanel",panel);
            CardLayout layout = (CardLayout)userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
        else
            JOptionPane.showMessageDialog(null, "Please select any rows");
    }//GEN-LAST:event_detailBtn1ActionPerformed

    private void updateBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtn1ActionPerformed
        // TODO add your handling code here:
        int selectedRow = placeJTable.getSelectedRow();
        if (selectedRow >= 0 ){
            Order o = (Order) placeJTable.getValueAt(selectedRow, 0);
            UpdateOrderJPanel panel = new UpdateOrderJPanel(userProcessContainer,o);
            userProcessContainer.add("UpdateOrderJPanel",panel);
            CardLayout layout = (CardLayout)userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
        else
            JOptionPane.showMessageDialog(null, "Please select any rows");
    }//GEN-LAST:event_updateBtn1ActionPerformed

    private void detailBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailBtn2ActionPerformed
        // TODO add your handling code here:
        int selectedRow = completedTable.getSelectedRow();
        if (selectedRow >= 0 ){
            Order o = (Order) completedTable.getValueAt(selectedRow, 0);
            ViewOrderJPanel panel = new ViewOrderJPanel(userProcessContainer,o);
            userProcessContainer.add("ViewOrderJPanel",panel);
            CardLayout layout = (CardLayout)userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
        else
            JOptionPane.showMessageDialog(null, "Please select any rows");
    }//GEN-LAST:event_detailBtn2ActionPerformed

    private void deleteBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtn2ActionPerformed
        // TODO add your handling code here:
        int selectedRow = completedTable.getSelectedRow();
        if (selectedRow >= 0 ){
            Order o = (Order) completedTable.getValueAt(selectedRow, 0);
            orderDirectory.getOrderList().remove(o);
            populateCompletedTable(orderDirectory.getOrderList());
        }
        else
            JOptionPane.showMessageDialog(null, "Please select any rows");
    }//GEN-LAST:event_deleteBtn2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressTextField;
    private javax.swing.JTable checkOrderJTable;
    private javax.swing.JLabel checkjLabel;
    private javax.swing.JTable completedTable;
    private javax.swing.JLabel completedjLabel;
    private javax.swing.JButton createBtn;
    private javax.swing.JComboBox<String> customerComboBox;
    private javax.swing.JLabel customerLabel;
    private javax.swing.JComboBox<String> customerSearchComboBox;
    private javax.swing.JComboBox<String> customerSearchComboBox1;
    private javax.swing.JComboBox<String> customerSearchComboBox2;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton deleteBtn2;
    private javax.swing.JButton detailBtn;
    private javax.swing.JButton detailBtn1;
    private javax.swing.JButton detailBtn2;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JButton moveBtn;
    private javax.swing.JLabel numLabel;
    private javax.swing.JLabel numLabel1;
    private javax.swing.JTextField numberTextField;
    private javax.swing.JButton placeBtn;
    private javax.swing.JTable placeJTable;
    private javax.swing.JLabel placejLabel;
    private javax.swing.JComboBox<String> productComboBox;
    private javax.swing.JLabel productLabel;
    private javax.swing.JComboBox<String> productSearchComboBox;
    private javax.swing.JComboBox<String> productSearchComboBox1;
    private javax.swing.JComboBox<String> productSearchComboBox2;
    private javax.swing.JButton refreshTestJButton;
    private javax.swing.JButton requestCMbtn;
    private javax.swing.JButton requestWMbtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JButton searchBtn1;
    private javax.swing.JButton searchBtn2;
    private javax.swing.JComboBox<String> statusComboBox;
    private javax.swing.JComboBox<String> statusComboBox1;
    private javax.swing.JComboBox<String> statusComboBox2;
    private javax.swing.JButton updateBtn;
    private javax.swing.JButton updateBtn1;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
