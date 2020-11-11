/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel_Agency;



/**
 *
 * @author zlt1997
 */
public class Airplane {
    
    
    int seats;
    String serialNum;
    private String airplaneModel;

    public Airplane() {
    }
    

   
    
    public Airplane(String airplaneModel, String serialNum, int Seat){
        this.airplaneModel = airplaneModel;
        this.serialNum= serialNum;
        this.seats=Seat;

    }

 

    public String getAirplaneModel() {
        return airplaneModel;
    }

    public void setAirplaneModel(String airplaneModel) {
        this.airplaneModel = airplaneModel;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String SerialNum) {
        this.serialNum = SerialNum;
    }

   

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
   
  @Override
  public String toString()
  {
      return this.serialNum;
  }
    
    
}
