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
public class ProductDirectory {
     ArrayList<Product> productList;

    public ProductDirectory() {
       productList = new ArrayList<Product>();
       //loadProduct();
    }

    public Product addProduct(){
        Product p = new Product();
        //productList.add(p);
        return p;
    }
    
    public void deleteProduct(Product p){
        productList.remove(p);
    }
    
    public int getProductNum(Product p){
        return p.getProdNum();
    }
    
    public ArrayList<Integer> getProductIDList() {
        ArrayList<Integer> sublist= new  ArrayList<>();
        for(Product p : productList){
            sublist.add(p.getProdId());
        }
        return sublist;
    }
    
    public ArrayList<String> getProductNameList() {
        ArrayList<String> sublist= new  ArrayList<>();
        for(Product p : productList){
            sublist.add(p.getProdName());
        }
        return sublist;
    }
    
    public void modifyProductNumCheckStatus(Order o){//检查是否被卖掉
        Product p = new Product();
        for(Product p1: productList){
            if(p1.getProdId()==o.getProdID()){
                p = p1;
            }       
        }
        int status = o.getStatus();
        int boughtNum = o.getNum();
        int left =p.getProdNum()-boughtNum;
        if(status==21){  
            if(left>=0){
                o.setStatus(2);//pass
                p.setProdNum(left);
            }
            else 
                o.setStatus(22); // pass failed
        }
        
   }
    
    public double getProductPrice(Order o){
        double price = 0.0;
        for(Product p: productList){
            if(p.getProdId()==o.getProdID()){
                price = p.getProdPrice();
            }       
        }
        return price;
    }
    
     public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
     
    public final  void loadProduct(){
        
        Product p1 = new Product("Lipstick", 1,100,"Channel",38);
        Product p2 = new Product("Lipgloss", 2,200,"Dior",32);
        Product p3 = new Product("Mascara", 3,210,"Nars",30);
        Product p4 = new Product("Facial Cream", 4,189,"Clinique",78);
        Product p5 = new Product("Eyeshadow", 5,0,"Urban Decay",65);//这个是用来测试核对产品库存的,个数我只写了0个
        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        productList.add(p4);
        productList.add(p5);
        
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
        /*Product p6 = new Product("Lipstick", 001,100,"Channel",38);
        Product p7 = new Product("Lipstick", 001,100,"Channel",38);
        Product p8 = new Product("Lipstick", 001,100,"Channel",38);
        Product p9 = new Product("Lipstick", 001,100,"Channel",38);
        Product p10 = new Product("Lipstick", 001,100,"Channel",38);
        Product p11 = new Product("Lipstick", 001,100,"Channel",38);
        Product p12 = new Product("Lipstick", 001,100,"Channel",38);
        Product p13 = new Product("Lipstick", 001,100,"Channel",38);
        Product p14 = new Product("Lipstick", 001,100,"Channel",38);*/
    
    }
    
}
