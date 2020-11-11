/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Business.Tickets;
import Travel_Agency.AirlinerList;
import Travel_Agency.Flight;
import Travel_Agency.Flights;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zhaowenxiao
 */
public class TravelAgencyPanel extends javax.swing.JPanel {

    /**
     * Creates new form AirplanePanel
     */
    private JPanel rightPanel; 
    private AirlinerList airlinerList;
    private Flights flightlist;
    private Tickets customerCatalog;
    
    public TravelAgencyPanel(JPanel processPanel,Flights flightList,AirlinerList airlinerList,Tickets customerCatalog) {
        this.rightPanel=processPanel;
        this.airlinerList=airlinerList;
        this.flightlist=flightList;
        this.customerCatalog=customerCatalog;
        initComponents();
        System.out.println(airlinerList.numairliner());
        System.out.println(flightList.numflight());
        populate();
        
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
        tblFlight = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtAirliner = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnBook = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        tblFlight.setBackground(new java.awt.Color(153, 102, 255));
        tblFlight.setForeground(new java.awt.Color(255, 255, 255));
        tblFlight.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FlightNo", "Route", "Airliner", "Date", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblFlight);
        if (tblFlight.getColumnModel().getColumnCount() > 0) {
            tblFlight.getColumnModel().getColumn(0).setResizable(false);
            tblFlight.getColumnModel().getColumn(0).setPreferredWidth(12);
            tblFlight.getColumnModel().getColumn(1).setPreferredWidth(60);
            tblFlight.getColumnModel().getColumn(2).setResizable(false);
            tblFlight.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblFlight.getColumnModel().getColumn(3).setPreferredWidth(60);
        }

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Flight Manager");

        jLabel2.setForeground(new java.awt.Color(102, 51, 255));
        jLabel2.setText("Airliner Name:");

        txtAirliner.setForeground(new java.awt.Color(102, 51, 255));

        btnSearch.setForeground(new java.awt.Color(102, 51, 255));
        btnSearch.setText("Go!");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnback.setBackground(new java.awt.Color(204, 204, 204));
        btnback.setFont(new java.awt.Font("Lucida Grande", 3, 13)); // NOI18N
        btnback.setForeground(new java.awt.Color(102, 102, 255));
        btnback.setText("< Back");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        btnCreate.setForeground(new java.awt.Color(102, 51, 255));
        btnCreate.setText("New Flight>>");
        btnCreate.setEnabled(false);
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnView.setForeground(new java.awt.Color(102, 51, 255));
        btnView.setText("View Flight>>");
        btnView.setEnabled(false);
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnBook.setForeground(new java.awt.Color(102, 51, 255));
        btnBook.setText("Book>>");
        btnBook.setEnabled(false);
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
            }
        });

        btncancel.setForeground(new java.awt.Color(102, 51, 255));
        btncancel.setText("Cancel Flight");
        btncancel.setEnabled(false);
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnback)
                                .addGap(164, 164, 164)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtAirliner, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(btnBook)
                        .addGap(42, 42, 42)
                        .addComponent(btnCreate)
                        .addGap(36, 36, 36)
                        .addComponent(btnView)
                        .addGap(18, 18, 18)
                        .addComponent(btncancel)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnback)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtAirliner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCreate)
                        .addComponent(btnView)
                        .addComponent(btncancel))
                    .addComponent(btnBook))
                .addContainerGap(160, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        CreateFlightJPanel panel=new CreateFlightJPanel(rightPanel,airlinerList,flightlist);
        rightPanel.add("CreateFlightJPanel",panel);
        CardLayout layout= (CardLayout) rightPanel.getLayout();
        layout.next(rightPanel);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        int Selectedrow = tblFlight.getSelectedRow();
        if (Selectedrow< 0)
        {
        JOptionPane.showMessageDialog(null,"Please select row from the Table first to view","Warning",JOptionPane.WARNING_MESSAGE);
                }
        else{
        Flight f= (Flight)tblFlight.getValueAt(Selectedrow, 0);
        
        ViewFlightJPanel panel=new ViewFlightJPanel(rightPanel,f);
        rightPanel.add("ViewFlightJPanel",panel);
        CardLayout layout= (CardLayout) rightPanel.getLayout();
        layout.next(rightPanel);}
        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        btnBook.setEnabled(true);
        btnCreate.setEnabled(true);
        btnView.setEnabled(true);
        btncancel.setEnabled(true);
        DefaultTableModel dtm = (DefaultTableModel)tblFlight.getModel();
        dtm.setRowCount(0);
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        if (airlinerList.SearchAirliner(txtAirliner.getText())==false) {
            JOptionPane.showMessageDialog(null, "No result");
            populate();
            btnBook.setEnabled(false);
        btnCreate.setEnabled(false);
        btnView.setEnabled(false);
        btncancel.setEnabled(false);
            return;
            
        }else{
            
        for (Flight a : flightlist.SearchFlight(txtAirliner.getText())) {
            
            Object[] row = new Object[dtm.getColumnCount()];
            row[0]=a;
            row[1]=a.getFromAirport()+"-"+a.getToAirport();
            row[2]=a.getAirliner();
            row[3]=sdf.format(a.getArriveDate());
            row[4]=a.getTime();
            dtm.addRow(row);
       }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed
       int Selectedrow = tblFlight.getSelectedRow();
        if (Selectedrow< 0)
        {
        JOptionPane.showMessageDialog(null,"Please select row from the Table first to view","Warning",JOptionPane.WARNING_MESSAGE);
                }
        else{
        Flight f= (Flight)tblFlight.getValueAt(Selectedrow, 0);
        if (f.isticketAva()) {
          BookTicketPanel panel=new BookTicketPanel(rightPanel,f,customerCatalog);
        rightPanel.add("BookTicketPanel",panel);
        CardLayout layout= (CardLayout) rightPanel.getLayout();
        layout.next(rightPanel);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBookActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
            rightPanel.remove(this);
            CardLayout layout= (CardLayout) rightPanel.getLayout();
            layout.first(rightPanel);                // TODO add your handling code here:
    }//GEN-LAST:event_btnbackActionPerformed

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        int Selectedrow = tblFlight.getSelectedRow();
        if (Selectedrow< 0)
        {
        JOptionPane.showMessageDialog(null,"Please select row from the Table first to view","Warning",JOptionPane.WARNING_MESSAGE);
                }
        else{
        Flight f= (Flight)tblFlight.getValueAt(Selectedrow, 0);
        flightlist.cancelFlight(f);
        customerCatalog.deleteticket(customerCatalog.SearchTicketbyFlight(tblFlight.getValueAt(Selectedrow, 0).toString()));
        JOptionPane.showMessageDialog(this, "Cancel Successfully");
        populate();
        }
// TODO add your handling code here:
    }//GEN-LAST:event_btncancelActionPerformed
    
   public void populate(){
        DefaultTableModel dtm = (DefaultTableModel)tblFlight.getModel();
        dtm.setRowCount(0);
         SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        for (Flight a : flightlist.getFlights()) {
            Object[] row = new Object[dtm.getColumnCount()];
            row[0]=a;
            row[1]=a.getFromAirport()+"-"+a.getToAirport();
            row[2]=a.getAirliner();
            row[3]=sdf.format(a.getArriveDate());
            row[4]=a.getTime();
            dtm.addRow(row);
       }
       
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnView;
    private javax.swing.JButton btnback;
    private javax.swing.JButton btncancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFlight;
    private javax.swing.JTextField txtAirliner;
    // End of variables declaration//GEN-END:variables
}