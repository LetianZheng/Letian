/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Dao.Order;

/**
 *
 * @author llm
 */
public class WMOrderCheckWorkRequest extends WorkRequest{
    
    private Order order;
    
    public WMOrderCheckWorkRequest(Order order){
        this.order = order;
        
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    
    @Override
    public String toString(){
    
        return String.valueOf(order.getOrderID());
    
    }
    
}
