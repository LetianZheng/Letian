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
public class SupplierDirectory {
    ArrayList<Supplier> supplierList;

    public SupplierDirectory() {
        supplierList = new  ArrayList<Supplier>();
        LoadSuppliers loadSuppiler = new LoadSuppliers(supplierList);
        supplierList = loadSuppiler.getSpl();
    }
    
    
    
     public ArrayList<Supplier> getSupplierList() {
        return supplierList;
    }

    public void setSupplierList(ArrayList<Supplier> supplierList) {
        this.supplierList = supplierList;
    }
    
    
    public Supplier addSupplier(){
        Supplier s = new Supplier();
        supplierList.add(s);
        return s;
    }
    
    public void deleteSupplier(Supplier s){
        supplierList.remove(s);  
    }
    
}

