/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Dao;

/**
 *
 * @author zhaowenxiao
 */
public class SupplierProducts {

    
    private String name;
    private int quantity;

    public SupplierProducts(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
    public SupplierProducts(){
    
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public String toString(){
    
    
        return name;
    
    }
    
}
