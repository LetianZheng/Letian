/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel_Agency;

import Travel_Agency.Airliner;
import Travel_Agency.Airplane;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

/**
 *
 * @author zlt1997
 */
public class Flights {
    private ArrayList<Flight> flights;

    public Flights() {
        flights=new ArrayList<Flight>();
    }
    

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }
    
    public void cancelFlight(Flight f)
    {
        flights.remove(f);
    }
    
    public ArrayList<Flight> SearchFlight(String Airliner)
    {
        ArrayList<Flight> searchAirliner=new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getAirliner().equals(Airliner)) {
                searchAirliner.add(flight);
            }
        }
        return searchAirliner;
    }
    
    public Flights searchFlightByID(String ID, Flights flights)
    {
        Flights flights1 = new Flights();
        flights1.flights.clear();
        for (Flight flight : flights.flights) {
            if (flight.getFlightID().equals(ID)) {
                flights1.flights.add(flight);
            }
        }
        return flights1;
    }
    
    public Flights searchFlightByAirliner(String Airliner,Flights flights)
    {
        Flights flights1 = new Flights();
        flights1.flights.clear();
        for (Flight flight : flights.flights) {
            if (flight.getAirliner().equals(Airliner)) {
                flights1.flights.add(flight);
            }
        }
        return flights1;
    }
    
    public Flight searchFlightbyNo(String FlightID)
    {
        for (Flight flight : flights) {
            if (flight.getFlightID().equals(FlightID)) {
                return flight;
            }
        }
        return null;
    }
    
    public Flights searchFlightByFromAirport(String fromAirport, Flights flights)
    {
        Flights flights1 = new Flights();
        flights1.flights.clear();
        for (Flight flight : flights.flights) {
            if (flight.getFromAirport().equals(fromAirport)) {
                flights1.flights.add(flight);
            }
        }
        return flights1;
    }
    
    public Flights searchFlightByToAirport(String toAirport, Flights flights)
    {
        Flights flights1 = new Flights();
        flights1.flights.clear();
        for (Flight flight : flights.flights) {
            if (flight.getToAirport().equals(toAirport)) {
                flights1.flights.add(flight);
            }
        }
        return flights1;
    }
    
    public Flights searchFlightByArriveDate(Date ArriveDate, Flights flights)
    {
        Flights flights1 = new Flights();
        flights1.flights.clear();
        for (Flight flight : flights.flights) {
            if (flight.getArriveDate().equals(ArriveDate)) {
                flights1.flights.add(flight);
            }
        }
        return flights1;
    }
    
    public Flights searchFlightByTime(String time,Flights flights)
    {
        Flights flights1 = new Flights();
        flights1.flights.clear();
        for (Flight flight : flights.flights) {
            if (flight.getTime().equals(time)) {
                flights1.flights.add(flight);
            }
        }
        return flights1;
    }
    
    
    
    public HashSet<String> getLocation1(){
      
        HashSet<String> location1 = new HashSet<String>();
        for(Flight flight: flights){
            String location= flight.getFromAirport();
            location1.add(location);
            
        }
        return location1;
    }
    
    public HashSet<String> getLocation2(){
      
        HashSet<String> location1 = new HashSet<String>();
        for(Flight flight: flights){
            String location= flight.getToAirport();
            location1.add(location);
            
        }
        return location1;
    }
    
      public void addflight(Flight flight)
    {
        flights.add(flight);
    }
    
        public int numflight()
    {    int sum=0;
        for(Flight a: flights)
        {
            sum++;
        }
        return sum;
    }
    
    
}
