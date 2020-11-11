/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel_Agency;

import java.util.ArrayList;

/**
 *
 * @author zlt1997
 */
public class AirlinerList {
    private ArrayList<Airliner> airliners;

    public ArrayList<Airliner> getAirliners() {
        return airliners;
    }

    public void setAirliners(ArrayList<Airliner> airliners) {
        this.airliners = airliners;
    }

    public AirlinerList() {
        this.airliners = new ArrayList<Airliner>();
    }
    
    public Airliner addaAirliner(Airliner a)
    {
        airliners.add(a);
        return a;
    }
    public void deleteAirliner(Airliner a)
    {
        airliners.remove(a);
    }
    
    public boolean SearchAirliner(String AirlinerName)
    {
        for (Airliner a : airliners) {
            if (a.getAirlinerNames().equals(AirlinerName)) {
             
                return true;
            }
        }
        return false;
    }
    
     public Airliner SearchAirliners(String AirlinerName)
    {
        for (Airliner a : airliners) {
            if (a.getAirlinerNames().equals(AirlinerName)) {
             
                return a;
            }
        }
        return null;
    }
    
    public int numairliner()
    {    int sum=0;
        for(Airliner a: airliners)
        {
            sum++;
        }
        return sum;
    }
}
