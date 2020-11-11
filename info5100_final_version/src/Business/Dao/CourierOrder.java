/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Dao;

import java.util.Date;

/**
 *
 * @author zlt1997
 */
public class CourierOrder {
   private Date OrderDate;
   private String status;
   private int OrderNum;
   private String from;
   private String to;
   private int transportNum;
   private String CourierName;

    public CourierOrder(Date OrderDate, int OrderNum) {
        this.OrderDate = OrderDate;
        this.OrderNum = OrderNum;
        this.status="Pending";
    }
    

    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date OrderDate) {
        this.OrderDate = OrderDate;
    }

    public int getTransportNum() {
        return transportNum;
    }

    public void setTransportNum(int transportNum) {
        this.transportNum = transportNum;
    }

    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOrderNum() {
        return OrderNum;
    }

    public void setOrderNum(int OrderNum) {
        this.OrderNum = OrderNum;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCourierName() {
        return CourierName;
    }

    public void setCourierName(String CourierName) {
        this.CourierName = CourierName;
    }

    
    
    public String toString()
    {
        return String.valueOf(this.getOrderNum());
    }
    
   
    
   
}
