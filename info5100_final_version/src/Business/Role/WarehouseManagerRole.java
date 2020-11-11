/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Dao.CustomerDirectory;
import Business.Dao.OrderDirectory;
import Business.Dao.ProductDirectory;
import Business.Dao.SupplierDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.WarehouseOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.WarehouseWorkArea.WarehouseWorkAreaJPanel;

/**
 *
 * @author zhaowenxiao
 */
public class WarehouseManagerRole extends Role{
    
     private SupplierDirectory  supplierDirectory;
     private OrderDirectory orderDirectory;
     private EcoSystem system;
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business,
            ProductDirectory  productDirectory, OrderDirectory  orderDirectory,
            CustomerDirectory  customerDirectory) {
        
        
        this.system = business;
        this.orderDirectory = orderDirectory;
         return new WarehouseWorkAreaJPanel(userProcessContainer, account, 
                (WarehouseOrganization)organization, enterprise, system,
                  orderDirectory,productDirectory);
    }
    public String toString()
    {
        return RoleType.WarehouseManager.toString();
    }

  
}
