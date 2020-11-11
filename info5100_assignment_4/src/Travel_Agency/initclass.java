/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel_Agency;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 *
 * @author zlt1997
 */
public class initclass {
     DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");  
    
        private Flights flightlist;
        private AirlinerList airlinerList;
    public initclass(Flights flights,AirlinerList airliners) {
        
    this.airlinerList=airliners;
    this.flightlist=flights;
    Airplane air1 = new Airplane("A320","001",250);
    Airplane air2 = new Airplane("B787","002",200);
    Airplane air3 = new Airplane("A330","003",150);
    Airplane air4 = new Airplane("A320","004",250);
    Airplane air5 = new Airplane("B747","005",300);
    
    Airliner airliner1= new Airliner("China Eastern Airlines");
    airliner1.addAirplane(air1);
    airliner1.addAirplane(air3);
    airliner1.addAirplane(air5);
    airliner1.setAddr("Shanghai");
   
    Airliner airliner2= new Airliner("China Southern Airlines");
    airliner2.addAirplane(air2);
    airliner2.addAirplane(air4);
    airliner2.setAddr("GuangZhou");
    
    airlinerList.addaAirliner(airliner1);
    airlinerList.addaAirliner(airliner2);
    
        try {
    Flight f1 = new Flight("MU5289", "001", "Beijing", "New York", "China Eastern Airlines", format1.parse("2019-11-21"), "Morning");
    Flight f2 = new Flight("MU5111", "002","New York", "Seattle","China Eastern Airlines",format1.parse("2019-11-22"),"Morning");
    Flight f3 = new Flight("MU6100", "003","Beijing", "New York","China Eastern Airlines",format1.parse("2019-11-23"),"Day");
    Flight f4 = new Flight("CZ7844", "004","Shanghai", "New York","China Southern Airlines",format1.parse("2019-11-24"),"Day");
    Flight f5 = new Flight("CZ9876", "005","New York", "Seattle","China Southern Airlines",format1.parse("2019-11-25"),"Evening");
    flightlist.addflight(f1);
    flightlist.addflight(f2);
    flightlist.addflight(f3);
    flightlist.addflight(f4);
    flightlist.addflight(f5);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "no");
        }
    
    
 
    

    
    
    }
    
   
    
   
    /*Airliner airliner3= new Airliner("Delta Airlines");
    Airliner airliner4= new Airliner("JetBlue Airlines");
    Airliner airliner5= new Airliner("Virgin Airlines");
    Airliner airliner6= new Airliner("Frontier Airlines");
    Airliner airliner7= new Airliner("Spirit Airlines");
    Airliner airliner8= new Airliner("United Airlines");
    Airliner airliner9= new Airliner("American Airlines");
    Airliner airliner10= new Airliner("Southwest Airlines");*/
    
    
    /*Flight f8 = new Flight("AB8921", "004","Paris Airport", "Boston Airport","JetBlue Airlines",new Date("2019-11-2"),"Day");
    Flight f9 = new Flight("CD8921", "004","Paris Airport", "Boston Airport","JetBlue Airlines",new Date("2019-11-2"),"Evening");*/
    
    
    
}
