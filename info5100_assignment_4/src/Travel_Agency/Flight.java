/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel_Agency;

//import Travel_Agency.Airplane;

import Travel_Agency.Airliner;
import Travel_Agency.Airplane;
import java.util.Date;


/**
 *
 * @author llm
 */
public class Flight {
    private String flightID;
    private String airplaneNO;
    private String fromAirport;
    private String toAirport;
    private String Airliner;
    private Date ArriveDate;
    private String Time;
    private int AvaTicket=150;
    private boolean[][] AvaSeat=new boolean[25][6];

    public Flight(String flightID, String airplaneNO, String fromAirport, String toAirport, String Airliner, Date ArriveDate, String Time) {
        this.flightID = flightID;
        this.airplaneNO = airplaneNO;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.Airliner = Airliner;
        this.ArriveDate = ArriveDate;
        this.Time = Time;
        seatinit();
       
    }
    public Flight()
    {
        seatinit();
    }

    public int getAvaTicket() {
        return AvaTicket;
    }

    public void setAvaTicket(int AvaTicket) {
        this.AvaTicket = AvaTicket;
    }
    
    
    
    public String getAirplane() {
        return airplaneNO;
    }

    public void setAirplane(String airplaneNO) {
        this.airplaneNO = airplaneNO;
    }

    public String getAirliner() {
        return Airliner;
    }

    public void setAirliner(String Airliner) {
        this.Airliner = Airliner;
    }
    
    
    
    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }


    public Date getArriveDate() {
        return ArriveDate;
    }

    public void setArriveDate(Date ArriveDate) {
        this.ArriveDate = ArriveDate;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }
    
    public String toString()
    {
        return this.flightID;
    }

    public void seatinit()
   {
       for (int i = 0; i < 25; i++) {
           for (int j = 0; j < 6; j++) {
               AvaSeat[i][j]=true;
           }
       }
       
   }
    
      public boolean isavaliable(int row,int Column)
    {
          return AvaSeat[row][Column];
    }
      
      public boolean isticketAva()
      {
          if (this.getAvaTicket()==0) {
              return false;
          }
          else return true;
      }
      
      public String nameoftheseat(int row,int Column)
      {
          StringBuilder sb=new StringBuilder();
          sb.append("Row:");
          sb.append(row);
          switch(Column)
          {
             case 1:
                 sb.append(" Left Window");
                 break;
             case 2:
                 sb.append(" Left Middle");
                 break;
             case 3:
                 sb.append(" Left Aisle");
                 break;
             case 4:
                 sb.append(" Right Aisle");
                 break;
             case 5:
                 sb.append(" Right Middle");
                 break;
             case 6:
                 sb.append(" Right Window");
                 break;
                 
          }
          return sb.toString();
      }
      
         /* public String getType(int column){
        String a = "";
        switch(column){
            case 1:
                a = "Left Window";
            case 2:
                a = "Left Middle" ;
            case 3:
                a = "Left Aisle";                
            case 4:
                a = "Right Window";
            case 5:
                a = "Right Middle";
            case 6:
                a = "Right Aisle";
                 
        }
        return a;
        
    }*/
          
      public void setAvail(int row,int Column){
        AvaSeat[row][Column]=false;    
    }
    
    
    
}
