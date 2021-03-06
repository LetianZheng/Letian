/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.customer;

import Travel_Agency.Flights;
import Travel_Agency.Airplane;
import Utils.ArrayListComboBoxModel;
import java.awt.CardLayout;
import java.awt.Component;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import javax.swing.JPanel;

/**
 *
 * @author llm
 */
public class ManageMasterFlightScheduleJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageMasterFlightScheduleJPanel
     */
    public JPanel processPanel;
    public Flights flights;
    public ManageMasterFlightScheduleJPanel(JPanel processPanel, Flights flights) {
        initComponents();
        this.processPanel = processPanel;
        this.flights = flights;
        viewLocation();
        departurejComboBox.setSelectedIndex(-1);
        arrivaljComboBox.setSelectedIndex(-1);
        year.setSelectedIndex(-1);
        month.setSelectedIndex(-1);
        day.setSelectedIndex(-1);
        timeComboBox.setSelectedIndex(-1);
    }
    
    private void viewLocation(){
        HashSet<String> locationList1 = flights.getLocation1();
        ArrayList<String> locationLists1 = new ArrayList();
        for(String location : locationList1){
            locationLists1.add(location);  
        }
        ArrayListComboBoxModel model = new ArrayListComboBoxModel(locationLists1);
        departurejComboBox.setModel(model);
        
        HashSet<String> locationList2 = flights.getLocation2();
        ArrayList<String> locationLists2 = new ArrayList();
        for(String location : locationList2){
            locationLists2.add(location);  
        }
        ArrayListComboBoxModel model1 = new ArrayListComboBoxModel(locationLists2);
        arrivaljComboBox.setModel(model1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        flightNumLable = new javax.swing.JLabel();
        flightNumTextField = new javax.swing.JTextField();
        departureLable = new javax.swing.JLabel();
        departurejComboBox = new javax.swing.JComboBox<>();
        arriveLable = new javax.swing.JLabel();
        arrivaljComboBox = new javax.swing.JComboBox<>();
        departureLable1 = new javax.swing.JLabel();
        timeComboBox = new javax.swing.JComboBox<>();
        backBtn = new javax.swing.JButton();
        dateLable = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        flightNumLable1 = new javax.swing.JLabel();
        airLinerTextField = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        month = new javax.swing.JComboBox<>();
        year = new javax.swing.JComboBox<>();
        day = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        flightNumLable.setForeground(new java.awt.Color(102, 51, 255));
        flightNumLable.setText("Flight Number");

        flightNumTextField.setForeground(new java.awt.Color(102, 51, 255));

        departureLable.setForeground(new java.awt.Color(102, 51, 255));
        departureLable.setText("Departure Location");

        departurejComboBox.setForeground(new java.awt.Color(102, 51, 255));
        departurejComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        departurejComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departurejComboBoxActionPerformed(evt);
            }
        });

        arriveLable.setForeground(new java.awt.Color(102, 51, 255));
        arriveLable.setText("Arrival  Location");

        arrivaljComboBox.setForeground(new java.awt.Color(102, 51, 255));
        arrivaljComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        arrivaljComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arrivaljComboBoxActionPerformed(evt);
            }
        });

        departureLable1.setForeground(new java.awt.Color(102, 51, 255));
        departureLable1.setText("Preferred time of day");

        timeComboBox.setForeground(new java.awt.Color(102, 51, 255));
        timeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Morning", "Day", "Evening" }));
        timeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeComboBoxActionPerformed(evt);
            }
        });

        backBtn.setFont(new java.awt.Font("Lucida Grande", 3, 13)); // NOI18N
        backBtn.setForeground(new java.awt.Color(102, 102, 255));
        backBtn.setText("< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        dateLable.setForeground(new java.awt.Color(102, 51, 255));
        dateLable.setText("Date");

        title.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        title.setForeground(new java.awt.Color(102, 51, 255));
        title.setText("Search Best Flight");

        flightNumLable1.setForeground(new java.awt.Color(102, 51, 255));
        flightNumLable1.setText("AirLiner");

        airLinerTextField.setForeground(new java.awt.Color(102, 51, 255));

        searchBtn.setForeground(new java.awt.Color(102, 51, 255));
        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        month.setForeground(new java.awt.Color(102, 51, 255));
        month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        year.setForeground(new java.awt.Color(102, 51, 255));
        year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2019" }));
        year.setSelectedItem(-1);

        day.setForeground(new java.awt.Color(102, 51, 255));
        day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(flightNumLable, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(departureLable, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dateLable, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(departurejComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(flightNumTextField))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(departureLable1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(timeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(flightNumLable1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(airLinerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(arriveLable)
                        .addGap(55, 55, 55)
                        .addComponent(arrivaljComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(117, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backBtn)
                        .addGap(183, 183, 183)
                        .addComponent(title))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(searchBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(title))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backBtn)))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(flightNumLable1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(airLinerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(flightNumLable, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(flightNumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departureLable, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(departurejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arriveLable, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arrivaljComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLable, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(departureLable1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addComponent(searchBtn)
                .addContainerGap(263, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
        Flights flights1 = flights;
        
        if(!"".equals(flightNumTextField.getText())){
            
            flights1 = flights1.searchFlightByID(flightNumTextField.getText(),flights1);
        }
        if(!"".equals(airLinerTextField.getText())){
            flights1 = flights1.searchFlightByAirliner(airLinerTextField.getText(),flights1);
        }
        if(departurejComboBox.getSelectedIndex() != -1 ){
            flights1 = flights1.searchFlightByFromAirport(departurejComboBox.getSelectedItem().toString(),flights1);
        }
        if(arrivaljComboBox.getSelectedIndex() != -1 ){
            flights1 = flights1.searchFlightByToAirport(arrivaljComboBox.getSelectedItem().toString(),flights1);
        }
        if(year.getSelectedIndex()!=-1 && month.getSelectedIndex() != -1 &&
                day.getSelectedIndex() != -1 ){
            Date a = new Date(Integer.valueOf(year.getSelectedItem().toString()),
                Integer.valueOf(month.getSelectedItem().toString()),Integer.valueOf(day.getSelectedItem().toString()));
            flights1 = flights1.searchFlightByArriveDate(a,flights1);
        }
        if(timeComboBox.getSelectedIndex() != -1){
            flights1 = flights1.searchFlightByTime(timeComboBox.getSelectedItem().toString(),flights1);
        }
        
            
       
        FlightsFoundJPanel panel = new FlightsFoundJPanel(processPanel,flights1);
        processPanel.add("FlightsFoundJPanel",panel);
        CardLayout layout = (CardLayout)processPanel.getLayout();
        layout.next(processPanel);
        departurejComboBox.setSelectedIndex(-1);
        arrivaljComboBox.setSelectedIndex(-1);
        year.setSelectedIndex(-1);
        month.setSelectedIndex(-1);
        day.setSelectedIndex(-1);
        timeComboBox.setSelectedIndex(-1);
        
    }//GEN-LAST:event_searchBtnActionPerformed

    private void arrivaljComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arrivaljComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_arrivaljComboBoxActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        this.processPanel.remove(this);
        CardLayout layout = (CardLayout)this.processPanel.getLayout();
        layout.first(processPanel);
    }//GEN-LAST:event_backBtnActionPerformed

    private void departurejComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departurejComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_departurejComboBoxActionPerformed

    private void timeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timeComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField airLinerTextField;
    private javax.swing.JComboBox<String> arrivaljComboBox;
    private javax.swing.JLabel arriveLable;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel dateLable;
    private javax.swing.JComboBox<String> day;
    private javax.swing.JLabel departureLable;
    private javax.swing.JLabel departureLable1;
    private javax.swing.JComboBox<String> departurejComboBox;
    private javax.swing.JLabel flightNumLable;
    private javax.swing.JLabel flightNumLable1;
    private javax.swing.JTextField flightNumTextField;
    private javax.swing.JComboBox<String> month;
    private javax.swing.JButton searchBtn;
    private javax.swing.JComboBox<String> timeComboBox;
    private javax.swing.JLabel title;
    private javax.swing.JComboBox<String> year;
    // End of variables declaration//GEN-END:variables
}
