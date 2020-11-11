/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CustomerServiceWorkArea;

import Business.Dao.CourierOrder;
import Business.Dao.CustomerDirectory;
import Business.Dao.Order;
import Business.Dao.OrderDirectory;
import Business.Dao.ProductDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.AssignCenterOrganization;
import Business.Organization.CustomerManagerOrganization;
import Business.Organization.CustomerServiceOrganization;
import Business.Organization.Organization;
import Business.Organization.WarehouseOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.CMOrderPlacedWorkRequest;
import Business.WorkQueue.CMRefundWorkRequest;
import Business.WorkQueue.CreateCurorderWorkRequest;
import Business.WorkQueue.WMOrderPlacedWorkRequest;
import Business.WorkQueue.WMReturnWorkRequest;
//import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.WorkRequest;
import Utils.ArrayListComboBoxModel;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.SalesPersonRole.ViewOrderJPanel;

/**
 *
 * @author raunak
 */
public class CustomerServiceWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private CustomerServiceOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem system;
    private OrderDirectory  orderDirectory;
    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    public CustomerServiceWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, 
            CustomerServiceOrganization organization, Enterprise enterprise,EcoSystem system
            ) {
        initComponents();
        this.system = system;
        this.orderDirectory =  system.getOrderDirectory();
        this.userProcessContainer = userProcessContainer;
        this.organization = (CustomerServiceOrganization)organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        valueLabel.setText(enterprise.getName());
        populateWorkQueueTable(userAccount.getWorkQueue().getWorkRequestList());
        populateUpdateJTable(orderDirectory.getOrderList());
//        viewProductList(productDirectory);
//        viewCustomerList(customerDirectory);    
    }
    
//     public void viewProductList(ProductDirectory  productDirectory){
//        ArrayListComboBoxModel model_id = new ArrayListComboBoxModel(productDirectory.getProductIDList());
//        productSearchComboBox1.setModel(model_id);
//
//    }
//    
//    public void viewCustomerList(CustomerDirectory  customerDirectory){
//        ArrayListComboBoxModel model_id = new ArrayListComboBoxModel(customerDirectory.getCustomerIDList());
//        customerSearchComboBox1.setModel(model_id);
//        
//    }
    public void populateUpdateJTable(ArrayList<Order> ol){
        DefaultTableModel model = (DefaultTableModel) updateJTable.getModel();
        
        model.setRowCount(0);
        for (Order o : ol){
            Object[] row = new Object[2];
            if(o.getStatus() == 5 ){
                row[0] = o;
                row[1] = getStatus(o.getStatus());
                model.addRow(row);
            }
            
        }
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
                
            case("Waiting for returned product"):
                return 61; 
            
            case("Returned, waiting for refund"):
                return 62;   
            
            case("Refunded, Cacellation process completed"):
                return 63;     
            
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
                
            case(61):
                return "Waiting for returned product"; 
            
            case(62):
                return "Returned, waiting for refund";   
            
            case(63):
                return "Refunded, Cacellation process completed";     
            
            case(7):
                return "Order completed";    
        }
        return null;
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
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        updateJTable = new javax.swing.JTable();
        detailBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();

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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(247, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("WorkArea", jPanel6);

        jPanel3.setBackground(new java.awt.Color(255, 237, 237));

        updateJTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(updateJTable);

        detailBtn.setForeground(new java.awt.Color(255, 102, 204));
        detailBtn.setText("View Details");
        detailBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailBtnActionPerformed(evt);
            }
        });

        deleteBtn.setForeground(new java.awt.Color(255, 102, 204));
        deleteBtn.setText("Cancel");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(detailBtn)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(detailBtn)
                        .addGap(29, 29, 29)
                        .addComponent(deleteBtn))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Return and Refund Orders", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refreshTestJButton)
                .addGap(103, 103, 103))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(refreshTestJButton)
                        .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addComponent(jTabbedPane1)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTestJButtonActionPerformed

        populateWorkQueueTable(userAccount.getWorkQueue().getWorkRequestList());
        populateUpdateJTable(orderDirectory.getOrderList());
        
    }//GEN-LAST:event_refreshTestJButtonActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = updateJTable.getSelectedRow();
        if (selectedRow >= 0 ){
            Order o = (Order) updateJTable.getValueAt(selectedRow, 0);
            CMRefundWorkRequest request = new CMRefundWorkRequest(o);
            request.setSender(userAccount);
            request.setStatus("2-Unrefund");
            
           
       
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
            
            o.setStatus(63);
            populateUpdateJTable(orderDirectory.getOrderList());
        }
        else
            JOptionPane.showMessageDialog(null, "Please select any rows");
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void detailBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = updateJTable.getSelectedRow();
        if (selectedRow >= 0 ){
            Order o = (Order) updateJTable.getValueAt(selectedRow, 0);
            ViewOrderJPanel panel = new ViewOrderJPanel(userProcessContainer,o);
            userProcessContainer.add("ViewOrderJPanel",panel);
            CardLayout layout = (CardLayout)userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
        else
            JOptionPane.showMessageDialog(null, "Please select any rows");
    }//GEN-LAST:event_detailBtnActionPerformed

    private void refundBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refundBtnActionPerformed
        // TODO add your handling code here:
        
                                             

    }//GEN-LAST:event_refundBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton detailBtn;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton refreshTestJButton;
    private javax.swing.JTable updateJTable;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
