/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Dao.CustomerDirectory;
import Business.Dao.OrderDirectory;
import Business.Dao.ProductDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public abstract class Role {
    
    public enum RoleType{
        CourierRole("Courier Role"),
        AssignRole("AssignRole"),
        Admin("Admin"),
        SalesPerson("SalesPerson"),
        CustomerManager("Customer Manager"),
        WarehouseManager("Warehouse Manager"),
        CustomerServiceRole("Customer Service"),
        SupplierManagerRole("Supplier Manager");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
   public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            EcoSystem business,
    ProductDirectory  productDirectory, OrderDirectory  orderDirectory,CustomerDirectory  customerDirectory);

/*    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
         Organization organization, 
            Enterprise enterprise, 
           EcoSystem business);*/


    
}