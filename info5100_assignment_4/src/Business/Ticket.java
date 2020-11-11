/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author llm
 */
public class Ticket {
    public String customerID;
    public String flightID;
    public String seatName;

    public Ticket(String customerID, String flightID) {
        this.customerID = customerID;
        this.flightID = flightID;
    }
    public Ticket()
    {
    }
    
    

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }
    

    
}
