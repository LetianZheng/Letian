/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Dao;

import java.util.ArrayList;

/**
 *
 * @author zlt1997
 */
public class CourierOrderList {
    ArrayList<CourierOrder> orderlist=new ArrayList<CourierOrder>();

    public ArrayList<CourierOrder> getOrderlist() {
        return orderlist;
    }

    public void setOrderlist(ArrayList<CourierOrder> orderlist) {
        this.orderlist = orderlist;
    }
    
    public void addOrder(CourierOrder order)
    {
        orderlist.add(order);
    }
    
    public void deleteOrder(CourierOrder order)
    {
        orderlist.remove(order);
    }
    
    public CourierOrder searchOrder(int orderNum)
    {   
        for (CourierOrder order : orderlist) {
            if (order.getOrderNum()==orderNum) {
                return order;
            }
        }
        return null;
    }
}
