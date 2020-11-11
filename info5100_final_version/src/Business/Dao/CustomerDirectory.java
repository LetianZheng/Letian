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
public class CustomerDirectory {
    private ArrayList<Customer> customerList;

    public CustomerDirectory() {
         customerList = new ArrayList();
         loadCustomer();
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }
    public void addCustomer(Customer c) {
        customerList.add(c);
    }
    
    public ArrayList<Integer> getCustomerIDList() {
        ArrayList<Integer> sublist= new  ArrayList<>();
        for(Customer c : customerList){
            sublist.add(c.getCusID());
        }
        return sublist;
    }
    
    public Customer getCustomerByID(int id) {
        for(Customer c : customerList){
            if(c.getCusID()==id)
                return c;
        }
        return null;
    }

    private void loadCustomer() {
        Customer c1 = new Customer(1,"llm",100,"Boston");
        Customer c2 = new Customer(2,"zwx",100,"Boston");
        Customer c3 = new Customer(3,"zlt",100,"Boston");
        
        customerList.add(c1);
        customerList.add(c2);
        customerList.add(c3);
        
    }
   
    
}
