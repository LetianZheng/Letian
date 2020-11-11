/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Dao;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author zhaowenxiao
 */
public class Product {

    private String prodName;
    private int prodId;
    private int prodNum;
    private String prodBrand;
    private double prodPrice;
    private Icon picpath;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public double getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(double prodPrice) {
        this.prodPrice = prodPrice;
    }
   
    
    public Product(String prodName, int prodId, int prodNum, String prodBrand, double prodPrice) {
        this.prodName = prodName;
        this.prodId = prodId;
        this.prodNum = prodNum;
        this.prodBrand = prodBrand;
        this.prodPrice = prodPrice;
        
    }
    
    public Product(){
    
    }
    
    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public int getProdNum() {
        return prodNum;
    }

    public void setProdNum(int prodNum) {
        this.prodNum = prodNum;
    }

    public String getProdBrand() {
        return prodBrand;
    }

    public void setProdBrand(String prodBrand) {
        this.prodBrand = prodBrand;
    }
    

    
    @Override
    public String toString(){
    
        return prodName;
    }

    public Icon getPicpath() {
        return picpath;
    }

    public void setPicpath(Icon picpath) {
        this.picpath = picpath;
    }
    
    
    
}
