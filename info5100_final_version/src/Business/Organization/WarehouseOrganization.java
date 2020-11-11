/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;
/*
*lana  123
*/
import Business.Dao.Order;
import Business.Dao.Order;
import Business.Dao.Product;
import Business.Dao.ProductDirectory;
import Business.Dao.Supplier;
import Business.Dao.SupplierDirectory;
import Business.Role.Role;
import Business.Role.WarehouseManagerRole;
import java.util.ArrayList;

/**
 *
 * @author zhaowenxiao
 */
public class WarehouseOrganization extends Organization{

   
     ProductDirectory prodirect;
     SupplierDirectory supplierDierectory;

    public SupplierDirectory getSupplierDierectory() {
        return supplierDierectory;
    }

    public void setSupplierDierectory(SupplierDirectory supplierDierectory) {
        this.supplierDierectory = supplierDierectory;
    }

    public ProductDirectory getProdirect() {
        return prodirect;
    }

    public void setProdirect(ProductDirectory prodirect) {
        this.prodirect = prodirect;
    }
   
      public WarehouseOrganization() {
        super(Type.WarehouseManager.getValue());
        prodirect = new ProductDirectory();
        supplierDierectory = new SupplierDirectory();
    }

    
      
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new WarehouseManagerRole());
        return roles;
    }
    
  
    
    
    
    
    
 
    
    
    
}
