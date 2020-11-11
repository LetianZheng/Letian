/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Dao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author llm
 */
public class Customer {
    public int cusID;
    public String cusName;
    public double cusBalance;
    public List<Order> order;
    public String cusAddress;

    public Customer(int cusID, String cusName, double cusBalance, String cusAddress) {
        this.cusID = cusID;
        this.cusName = cusName;
        this.cusBalance = cusBalance;
        this.cusAddress = cusAddress;
        this.order = new ArrayList<Order>();
    }

    public Customer() {
    }

    
    public int getCusID() {
        return cusID;
    }

    public void setCusID(int cusID) {
        this.cusID = cusID;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public double getCusBalance() {
        return cusBalance;
    }

    public void setCusBalance(double cusBalance) {
        this.cusBalance = cusBalance;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }
    
    
    
}
