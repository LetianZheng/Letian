/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Travel_Agency.Flight;
import java.awt.CardLayout;
import java.awt.Component;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author llm
 */
public class ViewFlightJPanel extends javax.swing.JPanel {
private Flight flight;
    /**
     * Creates new form ControlJPanel
     */
    private JPanel rightPanel; 
    
    public ViewFlightJPanel(JPanel rightPanel,Flight f) {
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        initComponents();
        this.rightPanel=rightPanel;
        this.flight=f;
        txtAirliner.setText(flight.getAirliner());
        txtAirplane.setText(flight.getAirplane());
        txtDate.setText(sdf.format(flight.getArriveDate()));
        txtFlightno.setText(flight.getFlightID());
        TimeCombox.setSelectedItem(flight.getTime());
        txtTo.setText(flight.getToAirport());
        txtfrom.setText(flight.getFromAirport());
        setineditable();
    }

    public void setineditable()
    {
        txtAirliner.setEnabled(false);
        txtAirplane.setEnabled(false);
        txtDate.setEnabled(false);
        txtFlightno.setEnabled(false);
        TimeCombox.setEnabled(false);
        txtTo.setEnabled(false);
        txtfrom.setEnabled(false);
    }
     public void seteditable()
    {
        txtDate.setEnabled(true);
        TimeCombox.setEnabled(true);
        txtTo.setEnabled(true);
        txtfrom.setEnabled(true);
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
        txtTo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        idLable1 = new javax.swing.JLabel();
        txtAirliner = new javax.swing.JTextField();
        idLable = new javax.swing.JLabel();
        txtFlightno = new javax.swing.JTextField();
        nameLabel1 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        txtfrom = new javax.swing.JTextField();
        title = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtAirplane = new javax.swing.JTextField();
        Btnsave = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        TimeCombox = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setForeground(new java.awt.Color(102, 51, 255));
        jLabel1.setText("To:");

        txtTo.setForeground(new java.awt.Color(102, 51, 255));

        jLabel2.setForeground(new java.awt.Color(102, 51, 255));
        jLabel2.setText("Date:");

        txtDate.setForeground(new java.awt.Color(102, 51, 255));

        idLable1.setForeground(new java.awt.Color(102, 51, 255));
        idLable1.setText("Airliner:");

        txtAirliner.setForeground(new java.awt.Color(102, 51, 255));

        idLable.setForeground(new java.awt.Color(102, 51, 255));
        idLable.setText("FlightNo:");

        txtFlightno.setForeground(new java.awt.Color(102, 51, 255));
        txtFlightno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFlightnoActionPerformed(evt);
            }
        });

        nameLabel1.setForeground(new java.awt.Color(102, 51, 255));
        nameLabel1.setText("Time:");

        nameLabel.setForeground(new java.awt.Color(102, 51, 255));
        nameLabel.setText("From:");

        txtfrom.setForeground(new java.awt.Color(102, 51, 255));

        title.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        title.setForeground(new java.awt.Color(102, 51, 255));
        title.setText("View Flight");

        btnBack.setFont(new java.awt.Font("Lucida Grande", 3, 13)); // NOI18N
        btnBack.setForeground(new java.awt.Color(102, 102, 255));
        btnBack.setText("< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(102, 51, 255));
        jLabel3.setText("Airplane:");

        txtAirplane.setForeground(new java.awt.Color(102, 51, 255));

        Btnsave.setForeground(new java.awt.Color(102, 51, 255));
        Btnsave.setText("Save");
        Btnsave.setEnabled(false);
        Btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnsaveActionPerformed(evt);
            }
        });

        btnupdate.setForeground(new java.awt.Color(102, 51, 255));
        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        TimeCombox.setForeground(new java.awt.Color(102, 51, 255));
        TimeCombox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Morning", "Day", "Evening" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnupdate))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idLable)
                                    .addComponent(nameLabel))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtFlightno, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtfrom, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameLabel1)
                                    .addComponent(idLable1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAirliner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TimeCombox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(title, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(35, 35, 35)
                                .addComponent(txtAirplane))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack)))
                .addContainerGap(315, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addGap(25, 25, 25)
                .addComponent(title)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLable)
                    .addComponent(txtFlightno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(txtfrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLable1)
                    .addComponent(txtAirliner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel1)
                    .addComponent(TimeCombox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAirplane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btnsave)
                    .addComponent(btnupdate))
                .addContainerGap(112, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtFlightnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFlightnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFlightnoActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
            this.rightPanel.remove(this);
           CardLayout layout=(CardLayout)this.rightPanel.getLayout();
           
           Component[] comps=this.rightPanel.getComponents();
           for(Component comp:comps)
           {
               if (comp instanceof TravelAgencyPanel) {
                   TravelAgencyPanel manageP=(TravelAgencyPanel) comp;
                   manageP.populate();
               }
           }
           layout.previous(rightPanel);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
    Btnsave.setEnabled(true);  
    seteditable();
    btnupdate.setEnabled(false);
// TODO add your handling code here:
    }//GEN-LAST:event_btnupdateActionPerformed

    private void BtnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnsaveActionPerformed
btnupdate.setEnabled(true);
DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");  

if (txtfrom.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "From City Can't be null");
            return;
        }else flight.setFromAirport(txtfrom.getText());
           
if (txtTo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "To City Can't be null");
            return;
        }else flight.setToAirport(txtTo.getText());

flight.setTime(TimeCombox.getSelectedItem().toString());
try {
            flight.setArriveDate(format1.parse(txtDate.getText()));
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Date format is not right");
        }
JOptionPane.showMessageDialog(null, "Success");
           

// TODO add your handling code here:
    }//GEN-LAST:event_BtnsaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btnsave;
    private javax.swing.JComboBox<String> TimeCombox;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel idLable;
    private javax.swing.JLabel idLable1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel nameLabel1;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtAirliner;
    private javax.swing.JTextField txtAirplane;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtFlightno;
    private javax.swing.JTextField txtTo;
    private javax.swing.JTextField txtfrom;
    // End of variables declaration//GEN-END:variables
}