/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CustomerManagementWorkArea;

//import userinterface.CustomerServiceWorkArea.*;
import Business.Dao.Customer;
import Business.Dao.CustomerDirectory;
import Business.Dao.Order;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.CustomerManagerOrganization;
import Business.Organization.CustomerServiceOrganization;

import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.CMOrderCheckWorkRequest;
import Business.WorkQueue.CMOrderPlacedWorkRequest;
import Business.WorkQueue.CMRefundWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raunak
 */
public class CustomerManagementWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private CustomerManagerOrganization customerManagerOrganization;
    private CustomerDirectory customerDirectory;
    private Enterprise enterprise;
    
    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public CustomerManagementWorkAreaJPanel(JPanel userProcessContainer, UserAccount account,
            Organization organization, Enterprise enterprise,EcoSystem business,
            CustomerDirectory customerDirectory) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business = business;
        this.customerManagerOrganization = (CustomerManagerOrganization)organization;
        this.enterprise = enterprise;
        this.customerDirectory = customerDirectory;
        
        valueLabel.setText(enterprise.getName());
        populateTable();
        populateWorkQueueTable();
        populateWorkQueueTable1();
        populateRefundTable();
    }
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)customerInfoJTable.getModel();
        
        model.setRowCount(0);
        
        
        for(Customer c : customerDirectory.getCustomerList()){
            Object[] row = new Object[4];
            row[0] = c;
            row[1] = c.getCusName();
            row[2] = c.getCusBalance();
            row[3] = c.getCusAddress();
            
            model.addRow(row);
        }
    }
    
    public void populateWorkQueueTable(){
        DefaultTableModel model = (DefaultTableModel)workRequestJTable.getModel();
        
        model.setRowCount(0);
        
        for(WorkRequest w : customerManagerOrganization.getWorkQueue().getWorkRequestList()){
            if(w.getStatus().equals("0-Unchecked")||w.getStatus().equals("0-Processing")||w.getStatus().equals("0-Pending")||w.getStatus().equals("0-Completed")){
                Object[] row = new Object[5];
                row[0] = w;
                row[1] = w.getReceiver();
                row[2] = w.getStatus();
                row[3] = w.getRequestDate();
                row[4] = w.getResolveDate();
                model.addRow(row);
            }
        }
    }
    
    public void populateWorkQueueTable1(){
        DefaultTableModel model = (DefaultTableModel)workRequestJTable1.getModel();
        
        model.setRowCount(0);
        
        for(WorkRequest w : customerManagerOrganization.getWorkQueue().getWorkRequestList()){
            if(w.getStatus().equals("1-Unplaced")||w.getStatus().equals("1-Processing")||w.getStatus().equals("1-Pending")||w.getStatus().equals("1-Completed")){
                Object[] row = new Object[5];
                row[0] = w;
                row[1] = w.getReceiver();
                row[2] = w.getStatus();
                row[3] = w.getRequestDate();
                row[4] = w.getResolveDate();
                model.addRow(row);
            }
            
        }
    }
    
    public void populateRefundTable(){
        DefaultTableModel model = (DefaultTableModel)refundJTable.getModel();
        
        model.setRowCount(0);
        
        for(WorkRequest w : customerManagerOrganization.getWorkQueue().getWorkRequestList()){
            if(w.getStatus().equals("2-Unrefund")||w.getStatus().equals("2-Processing")||w.getStatus().equals("2-Pending")||w.getStatus().equals("2-Completed")){
                Object[] row = new Object[5];
                row[0] = w;
                row[1] = w.getReceiver();
                row[2] = w.getStatus();
                row[3] = w.getRequestDate();
                row[4] = w.getResolveDate();
                model.addRow(row);
            }
            
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        assignJButton = new javax.swing.JButton();
        checkBtn = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        workRequestJTable1 = new javax.swing.JTable();
        assignJButton1 = new javax.swing.JButton();
        placeBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        customerInfoJTable = new javax.swing.JTable();
        refreshJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        viewBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        refundJTable = new javax.swing.JTable();
        assignJButton2 = new javax.swing.JButton();
        refundBtn = new javax.swing.JButton();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        refreshTestJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 237, 237));

        jTabbedPane1.setForeground(new java.awt.Color(255, 102, 204));

        jPanel6.setBackground(new java.awt.Color(255, 237, 237));
        jPanel6.setForeground(new java.awt.Color(255, 102, 204));

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

        assignJButton.setForeground(new java.awt.Color(255, 102, 204));
        assignJButton.setText("Assign to me");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });

        checkBtn.setForeground(new java.awt.Color(255, 102, 204));
        checkBtn.setText("Check");
        checkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBtnActionPerformed(evt);
            }
        });

        workRequestJTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(workRequestJTable1);

        assignJButton1.setForeground(new java.awt.Color(255, 102, 204));
        assignJButton1.setText("Assign to me");
        assignJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButton1ActionPerformed(evt);
            }
        });

        placeBtn.setForeground(new java.awt.Color(255, 102, 204));
        placeBtn.setText("Place");
        placeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placeBtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 204));
        jLabel2.setText("Unchecked Orders");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 204));
        jLabel3.setText("Unplaced Orders");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(assignJButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                .addComponent(placeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(assignJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                .addComponent(checkBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(assignJButton)
                        .addGap(53, 53, 53)
                        .addComponent(checkBtn))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addComponent(jLabel3)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(assignJButton1)
                        .addGap(49, 49, 49)
                        .addComponent(placeBtn))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("WorkArea", jPanel6);

        jPanel4.setBackground(new java.awt.Color(255, 237, 237));

        customerInfoJTable.setBackground(new java.awt.Color(255, 204, 255));
        customerInfoJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Balance", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
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
        jScrollPane1.setViewportView(customerInfoJTable);
        if (customerInfoJTable.getColumnModel().getColumnCount() > 0) {
            customerInfoJTable.getColumnModel().getColumn(0).setResizable(false);
            customerInfoJTable.getColumnModel().getColumn(1).setResizable(false);
            customerInfoJTable.getColumnModel().getColumn(2).setResizable(false);
            customerInfoJTable.getColumnModel().getColumn(3).setResizable(false);
        }

        refreshJButton.setForeground(new java.awt.Color(255, 102, 204));
        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 204));
        jLabel1.setText("Customer Information");

        addBtn.setForeground(new java.awt.Color(255, 102, 204));
        addBtn.setText("Add New Customer");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        updateBtn.setForeground(new java.awt.Color(255, 102, 204));
        updateBtn.setText("Update Information");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        viewBtn.setForeground(new java.awt.Color(255, 102, 204));
        viewBtn.setText("View Details");
        viewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(jLabel1)
                        .addGap(68, 68, 68)
                        .addComponent(refreshJButton))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(addBtn)
                                .addGap(28, 28, 28)
                                .addComponent(updateBtn)
                                .addGap(34, 34, 34)
                                .addComponent(viewBtn))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(226, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(refreshJButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(updateBtn)
                    .addComponent(viewBtn))
                .addContainerGap(255, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View Customer Information", jPanel4);

        jPanel1.setBackground(new java.awt.Color(255, 237, 237));
        jPanel1.setForeground(new java.awt.Color(255, 102, 204));

        refundJTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(refundJTable);

        assignJButton2.setForeground(new java.awt.Color(255, 102, 204));
        assignJButton2.setText("Assign to me");
        assignJButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButton2ActionPerformed(evt);
            }
        });

        refundBtn.setForeground(new java.awt.Color(255, 102, 204));
        refundBtn.setText("Refund");
        refundBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refundBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(assignJButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(refundBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(assignJButton2)
                        .addGap(53, 53, 53)
                        .addComponent(refundBtn))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(285, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Refund WorkArea", jPanel1);

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");

        valueLabel.setText("<value>");

        refreshTestJButton.setText("Refresh");
        refreshTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTestJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addGap(1, 1, 1))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(333, 333, 333)
                .addComponent(refreshTestJButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(refreshTestJButton))
                    .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateTable();
        populateWorkQueueTable();
        populateWorkQueueTable1();
        populateRefundTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = customerInfoJTable.getSelectedRow();
        if (selectedRow >= 0 ){
            Customer c = (Customer) customerInfoJTable.getValueAt(selectedRow, 0);
            UpdateCustomerJPanel panel = new UpdateCustomerJPanel(userProcessContainer,c);
            userProcessContainer.add("UpdateCustomerJPanel",panel);
            CardLayout layout = (CardLayout)userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
        else
            JOptionPane.showMessageDialog(null, "Please select any rows");
       
        
    }//GEN-LAST:event_updateBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        CreateCustomerJPanel panel = new CreateCustomerJPanel(userProcessContainer,customerDirectory);
        userProcessContainer.add("CreateCustomerJPanel",panel);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_addBtnActionPerformed

    private void viewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = customerInfoJTable.getSelectedRow();
        if (selectedRow >= 0 ){
            Customer c = (Customer) customerInfoJTable.getValueAt(selectedRow, 0);
            CustomerDetailsJPanel panel = new CustomerDetailsJPanel(userProcessContainer,c);
            userProcessContainer.add("CustomerDetailsJPanel",panel);
            CardLayout layout = (CardLayout)userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
        else
            JOptionPane.showMessageDialog(null, "Please select any rows");
       
    }//GEN-LAST:event_viewBtnActionPerformed

    private void checkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        
        CMOrderCheckWorkRequest request = (CMOrderCheckWorkRequest)workRequestJTable.getValueAt(selectedRow, 0);
     
        request.setStatus("0-Processing");
        request.setResolveDate(new Date());
        populateWorkQueueTable();
        
        CheckJPanel processWorkRequestJPanel = new CheckJPanel(userProcessContainer,customerDirectory.getCustomerByID(request.getOrder().getCusID()), request);
        userProcessContainer.add("processWorkRequestJPanel", processWorkRequestJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_checkBtnActionPerformed

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0){
            return;
        }

        WorkRequest request = (WorkRequest)workRequestJTable.getValueAt(selectedRow, 0);
        request.setReceiver(userAccount);
        request.setStatus("0-Pending");
        populateWorkQueueTable();

    }//GEN-LAST:event_assignJButtonActionPerformed

    private void refreshTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTestJButtonActionPerformed

        populateWorkQueueTable();
        populateTable();

    }//GEN-LAST:event_refreshTestJButtonActionPerformed

    private void assignJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButton1ActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable1.getSelectedRow();

        if (selectedRow < 0){
            return;
        }

        WorkRequest request = (WorkRequest)workRequestJTable1.getValueAt(selectedRow, 0);
        request.setReceiver(userAccount);
        request.setStatus("1-Pending");
        populateWorkQueueTable1();
    }//GEN-LAST:event_assignJButton1ActionPerformed

    private void placeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placeBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable1.getSelectedRow();

        if (selectedRow < 0){
            return;
        }

        CMOrderPlacedWorkRequest request = (CMOrderPlacedWorkRequest)workRequestJTable1.getValueAt(selectedRow, 0);
        request.setReceiver(userAccount);
        Order o = request.getOrder();
        int cid = o.getCusID();
        double price = o.getPrice();
        Customer c = customerDirectory.getCustomerByID(cid);
        double balance = c.getCusBalance();
        c.setCusBalance(balance-price);
        request.setStatus("1-Completed");
        request.setResolveDate(new Date());
        populateWorkQueueTable1();
    }//GEN-LAST:event_placeBtnActionPerformed

    private void assignJButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButton2ActionPerformed
        // TODO add your handling code here:
        int selectedRow = refundJTable.getSelectedRow();

        if (selectedRow < 0){
            return;
        }

        WorkRequest request = (WorkRequest)refundJTable.getValueAt(selectedRow, 0);
        request.setReceiver(userAccount);
        request.setStatus("2-Pending");
        populateRefundTable();
    }//GEN-LAST:event_assignJButton2ActionPerformed

    private void refundBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refundBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = refundJTable.getSelectedRow();

        if (selectedRow < 0){
            return;
        }

        CMRefundWorkRequest request = (CMRefundWorkRequest)refundJTable.getValueAt(selectedRow, 0);
        Order o = request.getOrder();
        int cid = o.getCusID();
        double price = o.getPrice();
        Customer c = customerDirectory.getCustomerByID(cid);
        double balance = c.getCusBalance();
        c.setCusBalance(balance+price);
        request.setReceiver(userAccount);
        request.setResolveDate(new Date());
        request.setStatus("2-Completed");
        populateRefundTable();
    }//GEN-LAST:event_refundBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton assignJButton;
    private javax.swing.JButton assignJButton1;
    private javax.swing.JButton assignJButton2;
    private javax.swing.JButton checkBtn;
    private javax.swing.JTable customerInfoJTable;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton placeBtn;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JButton refreshTestJButton;
    private javax.swing.JButton refundBtn;
    private javax.swing.JTable refundJTable;
    private javax.swing.JButton updateBtn;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JButton viewBtn;
    private javax.swing.JTable workRequestJTable;
    private javax.swing.JTable workRequestJTable1;
    // End of variables declaration//GEN-END:variables
}
