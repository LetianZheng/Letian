/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CourierRole;

import Business.Dao.CourierOrder;
import Business.Dao.Order;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.CourierOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AssignWorkRequest;
import Business.WorkQueue.CreateCurorderWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author zlt1997
 */
public class UpdatelogisticsStatusJPanel extends javax.swing.JPanel {

    /**
     * Creates new form UpdatelogisticsStatusJPanel
     */
    private JPanel userProcessContainer;
    CourierOrder courierOrder;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private Network network;
    private EcoSystem system;
    
    public UpdatelogisticsStatusJPanel(JPanel userProcessContainer, CourierOrder c, Enterprise enterprise, UserAccount userAccount, Network network, EcoSystem system) {
                this.userProcessContainer=userProcessContainer;
                this.courierOrder=c;
                this.enterprise=enterprise;
                this.userAccount=userAccount;
                this.network=network;
                this.system=system;
                
                initComponents();
                LogisticStatus.setEnabled(false);
                TransportNum.setText(String.valueOf(courierOrder.getTransportNum()));
                
                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LogisticStatus = new javax.swing.JComboBox<>();
        btnUpdate = new javax.swing.JButton();
        SaveBtn = new javax.swing.JButton();
        TransportNum = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 237, 237));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 204));
        jLabel1.setText("Logistics Status");

        jLabel2.setForeground(new java.awt.Color(255, 102, 204));
        jLabel2.setText("Transport Number:");

        jLabel3.setForeground(new java.awt.Color(255, 102, 204));
        jLabel3.setText("Status:");

        LogisticStatus.setForeground(new java.awt.Color(255, 102, 204));
        LogisticStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Transport", "Finish" }));

        btnUpdate.setForeground(new java.awt.Color(255, 102, 204));
        btnUpdate.setText("Modify");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        SaveBtn.setBackground(new java.awt.Color(204, 204, 204));
        SaveBtn.setForeground(new java.awt.Color(255, 102, 204));
        SaveBtn.setText("Save");
        SaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBtnActionPerformed(evt);
            }
        });

        TransportNum.setForeground(new java.awt.Color(255, 102, 204));
        TransportNum.setText("textfield");

        btnBack.setForeground(new java.awt.Color(255, 102, 204));
        btnBack.setText("<- Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(137, 137, 137)
                            .addComponent(btnUpdate)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SaveBtn))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(146, 146, 146)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(81, 81, 81)
                                    .addComponent(LogisticStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(TransportNum))))))
                .addContainerGap(175, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnBack)))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TransportNum))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(LogisticStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(SaveBtn))
                .addContainerGap(138, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        LogisticStatus.setEnabled(true);
// TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void SaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBtnActionPerformed
        courierOrder.setStatus(LogisticStatus.getSelectedItem().toString());
        Enterprise ens=null;
        for (UserAccount ua : enterprise.searchOrganization("Assign Center Organization").getUserAccountDirectory().getUserAccountList()) 
        {
            for (WorkRequest request : ua.getWorkQueue().getWorkRequestList()) 
            {
               if (request instanceof AssignWorkRequest) 
               {
                   if (((AssignWorkRequest) request).getCurOrder().getOrderNum()==courierOrder.getOrderNum()) 
                   {
                         ((AssignWorkRequest) request).getCurOrder().setStatus(LogisticStatus.getSelectedItem().toString());
                         if (LogisticStatus.getSelectedItem().equals("Finish")) {
                           request.setStatus("Finished");
                           btnUpdate.setEnabled(false);
                             for (Enterprise en : network.getEnterpriseDirectory().getEnterpriseList()) 
                             {
                                 if (en.getName().equals("XX")) {
                                     ens=en;
                                 }
                             }
                             for (WorkRequest req : ens.searchOrganization("SalesPerson Organization").getWorkQueue().getWorkRequestList()) 
                             {
                                 if (req instanceof CreateCurorderWorkRequest) 
                                 {
                                     if (((CreateCurorderWorkRequest) req).getOrder().getOrderID()==courierOrder.getOrderNum())
                                     {
                                         req.setStatus("5");
                                     }
                                     
                                 }
                             }
                              for (Order order : system.getOrderDirectory().getOrderList()) 
                              {
                                        if (order.getOrderID()==courierOrder.getOrderNum()) 
                                             {
                                                 order.setStatus(5);
                                         }
                       }
                   }
            } 
            }
            
            }
        }
      SaveBtn.setEnabled(false);
 
// TODO add your handling code here:
    }//GEN-LAST:event_SaveBtnActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) this.userProcessContainer.getLayout();
        Component[] comps=this.userProcessContainer.getComponents();
           for(Component comp:comps)
           {
               if (comp instanceof CourierWorkAreaJPanel) {
                   CourierWorkAreaJPanel manageP=(CourierWorkAreaJPanel) comp;
                   manageP.populateTable();
                   manageP.populateFinishedTable();
               }
           }
           layout.previous(userProcessContainer);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> LogisticStatus;
    private javax.swing.JButton SaveBtn;
    private javax.swing.JLabel TransportNum;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
