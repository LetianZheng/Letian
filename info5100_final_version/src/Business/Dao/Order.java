/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Dao;

import java.util.Date;

/**
 *
 * @author llm
 */
public class Order {
    public static int counter ;
    public int orderID;
    public int prodID;
    public int cusID;
    public int status;//0-未确认订单 1-余额核验通过 2-库存核验通过 3-下单 4-订单发货 5-订单送达 6-订单取消 7-订单完成
    public Date date;
    public int num;
    public String address;
    public double price;

    public Order(OrderDirectory od, int prodID, int cusID, int status, Date date, int num,String address) {
        counter = od.getOrderList().size();
        orderID = counter;
        this.orderID = orderID;
        this.prodID = prodID;
        this.cusID = cusID;
        this.status = status;
        this.date = date;
        this.num = num;
        this.address = address;
        counter++;
    }

    public Order(){
        
    }
    
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getProdID() {
        return prodID;
    }

    public void setProdID(int prodID) {
        this.prodID = prodID;
    }

    public int getCusID() {
        return cusID;
    }

    public void setCusID(int cusID) {
        this.cusID = cusID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
    
    
    @Override
    public String toString(){
        return orderID+"";
        
        
    }
    
    
    
}
