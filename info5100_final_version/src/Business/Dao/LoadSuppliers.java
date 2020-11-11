/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Dao;

import java.util.ArrayList;

/**
 *
 * @author zhaowenxiao
 */
public class LoadSuppliers {
     
        ArrayList<Supplier> supplierList;
        public LoadSuppliers(ArrayList<Supplier> supplierList) {
            supplierList = new ArrayList<Supplier>();
            this.supplierList = supplierList;
            Supplier s1 = new Supplier("Channel", 1);
            Supplier s2 = new Supplier("Dior", 2);
            Supplier s3 = new Supplier("Nars", 3); 
            Supplier s4 = new Supplier("Clinique", 4); 
            Supplier s5 = new Supplier("Urban Decay", 5);
        
            supplierList.add(s1);
            supplierList.add(s2);
            supplierList.add(s3);
            supplierList.add(s4);
            supplierList.add(s5);
        }
        
        ArrayList<Supplier> getSpl(){
        
            return supplierList;
        }
        
    
    
    
}
