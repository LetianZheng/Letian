/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

/**
 *
 * @author zhaowenxiao
 */
import Business.Dao.Order;
import Business.Dao.Order;
import Business.Dao.Product;
import Business.Dao.Supplier;
import Business.Dao.SupplierDirectory;
import Business.Role.Role;
import Business.Role.SupplierManagerRole;
import Business.Role.WarehouseManagerRole;
import java.util.ArrayList;
public class ContractorProductOrganization extends Organization{
     SupplierDirectory supplierDierectory;

    public SupplierDirectory getSupplierDierectory() {
        return supplierDierectory;
    }

    public void setSupplierDierectory(SupplierDirectory supplierDierectory) {
        this.supplierDierectory = supplierDierectory;
    }
     public ContractorProductOrganization() {
        super(Type.SupplierManager.getValue());
        supplierDierectory = new SupplierDirectory();
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new SupplierManagerRole());
        return roles;
    }
}
