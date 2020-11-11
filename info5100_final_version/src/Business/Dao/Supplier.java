/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Dao;

import java.util.ArrayList;

/**
 *
 * @author zhaowenxiao
 */
public class Supplier {
    private String SupplierName;
    private int SupplierID;
    private String description;
    private ArrayList<SupplierProducts> proList;

    public Supplier(){
        proList = new ArrayList<SupplierProducts>();
        this.defaultProducts();
    }
    
    public Supplier(String SupplierName, int SupplierID) {
        this.SupplierName = SupplierName;
        this.SupplierID = SupplierID;
        proList = new ArrayList<SupplierProducts>();
        
        //Products for suppliers can supply
        switch (SupplierName) {
            case "Channel":
                proList.add(new SupplierProducts("Lipstick", 100));
                proList.add(new SupplierProducts("Eyeliner", 213));
                proList.add(new SupplierProducts("Lipgloss", 189));
                this.setDescription("Chanel S.A. (/ʃəˈnɛl/, French pronunciation: [ʃanɛl]) "
                        + "is a French privately held company owned by Alain Wertheimer and Gérard Wertheimer,"
                        + " grandsons of Pierre Wertheimer, who was an early business partner of the couturière Coco Chanel.");
                break;
            case "Dior":
                proList.add(new SupplierProducts("Lipstick", 21));
                proList.add(new SupplierProducts("Foundation", 14));
                proList.add(new SupplierProducts("Lipgloss", 200));
                proList.add(new SupplierProducts("Bronze", 5));
                this.setDescription("Christian Dior SE (French: [kʁistjɑ̃ djɔʁ]), "
                        + "commonly known as Dior, is a French luxury goods company "
                        + "controlled and chaired by French businessman Bernard Arnault, "
                        + "who also heads LVMH, the world's largest luxury group. ");
                break;
            case "Nars":
                proList.add(new SupplierProducts("Lipstick", 21));
                proList.add(new SupplierProducts("Consealer", 4));
                proList.add(new SupplierProducts("Mascara", 210));
                proList.add(new SupplierProducts("Blush", 2));
                this.setDescription("NARS Cosmetics is a French cosmetics and skin care company"
                        + " founded by make-up artist and photographer François Nars in 1994. "
                        + "The cosmetics line began with twelve lipsticks sold at Barneys New York. "
                        + "Since then, NARS has created various multi-use beauty products and now is a subsidiary of Shiseido.");
                break;
            case "Clinique":
                proList.add(new SupplierProducts("Facial Cream", 189));
                proList.add(new SupplierProducts("Sun Protector", 7));
                proList.add(new SupplierProducts("Blush", 1));
                this.setDescription("Clinique Laboratories, LLC (/klɪˈniːk/) "
                        + "is an American manufacturer of skincare, cosmetics, "
                        + "toiletries and fragrances, usually sold in high-end department stores. "
                        + "It is a subsidiary of the Estée Lauder Companies.");
                break;
            case "Urban Decay":
                proList.add(new SupplierProducts("Eyeshadow", 0));
                this.setDescription("Urban Decay, an American cosmetics brand headquartered "
                        + "in Newport Beach, California, "
                        + "is a subsidiary of French cosmetics company L'Oréal.[1]");
                break;
            
        }
    }
    
    
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String SupplierName) {
        this.SupplierName = SupplierName;
    }

    public int getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(int SupplierID) {
        this.SupplierID = SupplierID;
    }

    public ArrayList<SupplierProducts> getProList() {
        return proList;
    }

    public void setProList(ArrayList<SupplierProducts> proList) {
        this.proList = proList;
    }

    private void defaultProducts() {// In case when we add a new supplier, there are no products leading null pointer exception
        proList.add(new SupplierProducts("Eyeshadow", 2));
        proList.add(new SupplierProducts("Lipgloss", 200));
        proList.add(new SupplierProducts("Bronze", 5));
        
    }
    
    @Override
    public String toString(){

        return String.valueOf(SupplierID);
    }
    
    
}
