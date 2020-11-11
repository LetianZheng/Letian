/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CourierRole;

import Business.Dao.CourierOrder;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.AssignCenterOrganization;
import Business.Organization.CourierOrganization;
import Business.Organization.Organization;
import Business.Role.CourierRole;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AssignWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zlt1997
 */
public class CourierWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private CourierOrganization courierOrganization;
    private Network network;
    private EcoSystem system;
    
    /**
     * Creates new form CourierWorkAreaJPanel
     */
    public CourierWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business)
    {
        this.userProcessContainer=userProcessContainer;
        this.userAccount = account;
        this.enterprise = enterprise;
        this.courierOrganization=(CourierOrganization)organization;
        initComponents();    
        CourierName.setText(userAccount.getEmployee().getEmployeeName());
        populateTable();
        populateFinishedTable();
        this.network=business.searchNetwork("1");
        this.system=business;
        }

        public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)CourierWorklist.getModel();
        int counts=0;
        model.setRowCount(0);
        for (WorkRequest workRequest : userAccount.getWorkQueue().getWorkRequestList()) {
              if (workRequest instanceof AssignWorkRequest) {
                    CourierOrder c=((AssignWorkRequest) workRequest).getCurOrder();
                        if (!c.getStatus().equals("Finish")) {
                        Object[] row = new Object[7];
                        row[0] = c;
                        row[1] = c.getFrom();
                        row[2] = c.getTo();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        row[3] =dateFormat.format(c.getOrderDate());
                        row[4] = c.getTransportNum();
                        row[5] = c.getStatus();
                        model.addRow(row);
                      counts++;
                  }
                }
            }
            if (userAccount.getRole() instanceof CourierRole) {
                ((CourierRole)userAccount.getRole()).setTotalcourier(counts);
            }
            this.count.setText(String.valueOf(((CourierRole)userAccount.getRole()).getTotalcourier()));
            
    }
    
                public void populateFinishedTable(){
        DefaultTableModel model = (DefaultTableModel)Finishedtable.getModel();
        int counts=0;
        model.setRowCount(0);
        for (WorkRequest workRequest : userAccount.getWorkQueue().getWorkRequestList()) {
              if (workRequest instanceof AssignWorkRequest) {
                    CourierOrder c=((AssignWorkRequest) workRequest).getCurOrder();
                        if (c.getStatus().equals("Finish")) {
                        Object[] row = new Object[7];
                        row[0] = c;
                        row[1] = c.getFrom();
                        row[2] = c.getTo();
                        row[3] = c.getOrderDate();
                        row[4] = c.getTransportNum();
                        row[5] = c.getStatus();
                        model.addRow(row);
                      counts++;
                  }
                }
            }
            if (userAccount.getRole() instanceof CourierRole) {
                ((CourierRole)userAccount.getRole()).setTotalcourier(counts);
            }
            this.count.setText(String.valueOf(((CourierRole)userAccount.getRole()).getTotalcourier()));
            
    }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        CourierWorklist = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        CourierName = new javax.swing.JLabel();
        UpdateBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        count = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Finishedtable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 237, 237));
        setForeground(new java.awt.Color(255, 102, 204));

        CourierWorklist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OrderNo.", "From", "To", "OrderDate", "TransportNo", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(CourierWorklist);
        if (CourierWorklist.getColumnModel().getColumnCount() > 0) {
            CourierWorklist.getColumnModel().getColumn(0).setResizable(false);
            CourierWorklist.getColumnModel().getColumn(1).setResizable(false);
            CourierWorklist.getColumnModel().getColumn(2).setResizable(false);
            CourierWorklist.getColumnModel().getColumn(3).setResizable(false);
            CourierWorklist.getColumnModel().getColumn(4).setResizable(false);
            CourierWorklist.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 204));
        jLabel1.setText("Couriers WorkList");

        CourierName.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        CourierName.setForeground(new java.awt.Color(255, 102, 204));
        CourierName.setText("Name:");

        UpdateBtn.setForeground(new java.awt.Color(255, 102, 204));
        UpdateBtn.setText("Update Status");
        UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBtnActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 102, 204));
        jLabel2.setText("Count:");

        count.setForeground(new java.awt.Color(255, 102, 204));
        count.setText("<value>");

        Finishedtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OrderNo.", "From", "To", "OrderDate", "TransportNo", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Finishedtable);
        if (Finishedtable.getColumnModel().getColumnCount() > 0) {
            Finishedtable.getColumnModel().getColumn(0).setResizable(false);
            Finishedtable.getColumnModel().getColumn(1).setResizable(false);
            Finishedtable.getColumnModel().getColumn(2).setResizable(false);
            Finishedtable.getColumnModel().getColumn(3).setResizable(false);
            Finishedtable.getColumnModel().getColumn(4).setResizable(false);
            Finishedtable.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(count)
                        .addGap(171, 171, 171)
                        .addComponent(UpdateBtn))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(CourierName, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(499, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CourierName))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(UpdateBtn)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(count)))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
            
            int selectedRow = CourierWorklist.getSelectedRow();
            if (selectedRow >= 0 ){
            CourierOrder c = (CourierOrder) CourierWorklist.getValueAt(selectedRow, 0);
                if (c.getStatus().equals("Finish")) {
                    JOptionPane.showMessageDialog(this, "The order is finished, You can't make change anymore!");
                    return;
                }
            UpdatelogisticsStatusJPanel panel = new UpdatelogisticsStatusJPanel(userProcessContainer,c,enterprise,userAccount,network,system);
            userProcessContainer.add("UpdateCustomerJPanel",panel);
            CardLayout layout = (CardLayout)userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CourierName;
    private javax.swing.JTable CourierWorklist;
    private javax.swing.JTable Finishedtable;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JLabel count;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}