/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Dao.Order;

/**
 *
 * @author zlt1997
 */
public class CreateCurorderWorkRequest extends WorkRequest{
    private Order order;

    public CreateCurorderWorkRequest(Order order) {
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
    
        return String.valueOf(this.order.orderID);
    
    }
    
}
