/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author llm
 */
public class Tickets {
    private ArrayList<Ticket> tickets;

    public Tickets() {
        tickets=new ArrayList<Ticket>();
        Ticket t1 = new Ticket("Letian Zheng","MU5289");
        tickets.add(t1);
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;}
    
    public void addticket(Ticket t){
            tickets.add(t);
    }
    
   public void deleteticket(ArrayList<Ticket> ts){
        for(Ticket ticket:ts){
           tickets.remove(ticket);   
       } 
   }
     
    public Ticket SearchTicket(String CustomerID,String FlightID){
        for (Ticket ticket : tickets) {
            if (ticket.getFlightID().equals(FlightID)&&ticket.getCustomerID().equals(CustomerID)) {
                return ticket;
            }
        }
        return null;
    }
    
    public ArrayList<Ticket> SearchTicketbyFlight(String FlightID){
        tickets=new ArrayList<Ticket>();
        for (Ticket ticket : tickets) {
            if (ticket.getFlightID().equals(FlightID)) {
                tickets.add(ticket);
            }
        }
        return null;
    }
    
    
    
    
    
    
}
