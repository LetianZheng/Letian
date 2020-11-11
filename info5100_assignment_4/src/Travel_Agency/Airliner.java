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
public class Airliner {
    private ArrayList<Airplane> airList;
    private String AirlinerNames;
    private int totalairplane;
    private String addr;

    public Airliner() {
        airList=new ArrayList<>();
    }

    
    
    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
    
    
    
        public void setTotalairplane(int totalairplane) {
        this.totalairplane = totalairplane;
    }

    public int getTotalairplane() {
        if(airList.isEmpty()==false){
            
            totalairplane=airList.size();
            return totalairplane;
        }
            
        return 0;
    }

    public String getAirlinerNames() {
        return AirlinerNames;
    }

    public void setAirlinerNames(String AirlinerNames) {
        this.AirlinerNames = AirlinerNames;
    }
    

    public Airliner(String names) {
        this.airList = new ArrayList<Airplane>();
        this.AirlinerNames=names;
    }

    public ArrayList<Airplane> getAirList() {
        return airList;
    }

    public void setAirList(ArrayList<Airplane> airList) {
        this.airList = airList;
    }
    
    public Airplane addAirplane(Airplane a)
    {   
        airList.add(a);
        return a;
    }
    
    public void deleteairplane(Airplane a)
    {
        airList.remove(a);
    }
    
    public Airplane SearchAirPlane(String serialNum)
    {
        for (Airplane plane : airList) {
            if (plane.getSerialNum().equals(serialNum)) {
                return plane;
            }
        }
        return null;
    }
    
    @Override
    public String toString()
    {
        return this.AirlinerNames;
    }
    
}
