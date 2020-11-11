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
import Business.Organization.ContractorProductOrganization;
import Business.Organization.Organization;
import Business.Organization.WarehouseOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.SupplierWorkArea.SupplierWorkAreaJPanel;
import userinterface.WarehouseWorkArea.WarehouseWorkAreaJPanel;

/**
 *
 * @author zhaowenxiao
 */
public class SupplierManagerRole extends Role{
    
     private SupplierDirectory  supplierDirectory;
     private EcoSystem system;
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business,
            ProductDirectory  productDirectory, OrderDirectory  orderDirectory,
            CustomerDirectory  customerDirectory) {
       
        this.system = business;
         return new SupplierWorkAreaJPanel(userProcessContainer, account, 
                (ContractorProductOrganization)organization, enterprise,
                 system);
    }
    public String toString()
    {
        return RoleType.SupplierManagerRole.toString();
    }
}
