/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Dao;

import java.util.ArrayList;

/**
 *
 * @author llm
 */
public class OrderDirectory {
    private ArrayList<Order> orderList;

    public OrderDirectory() {
         orderList = new ArrayList();
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }

    
    public void addOrder(Order o) {
        orderList.add(o);
    }
    
    public OrderDirectory getOrderByProductID(int id, OrderDirectory od) {
        OrderDirectory sublist= new OrderDirectory();
        for(Order o : od.getOrderList()){
            if(o.getProdID() == id)
            sublist.orderList.add(o);
        }
        return sublist;
    }
    
    public OrderDirectory getOrderByCustomerID(int id, OrderDirectory od) {
        OrderDirectory sublist= new OrderDirectory();
        for(Order o : od.orderList){
            if(o.getCusID()== id)
            sublist.orderList.add(o);
        }
        return sublist;
    }
    
    public OrderDirectory getOrderByStatus(int status, OrderDirectory od) {
        OrderDirectory sublist= new OrderDirectory();
        for(Order o : od.orderList){
            if(o.getStatus()== status)
            sublist.orderList.add(o);
        }
        return sublist;
    }
    
}
