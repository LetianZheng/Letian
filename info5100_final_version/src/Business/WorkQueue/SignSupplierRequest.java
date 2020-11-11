/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.Date;

/**
 *
 * @author zhaowenxiao
 */
    
public class SignSupplierRequest extends WorkRequest{

    public String getSenderen() {
        return senderen;
    }

    public void setSenderen(String senderen) {
        this.senderen = senderen;
    }
   
  
    String senderen;
   
   

    @Override
    public String toString(){
    
        return String.valueOf(super.getRequestDate());
    
    }
    
    

  
    
}
