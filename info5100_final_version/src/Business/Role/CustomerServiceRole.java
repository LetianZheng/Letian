/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Dao.CustomerDirectory;
import Business.Dao.OrderDirectory;
import Business.Dao.ProductDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.CustomerServiceOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.AdministrativeRole.AdminWorkAreaJPanel;
import userinterface.CustomerManagementWorkArea.CustomerManagementWorkAreaJPanel;
import userinterface.CustomerServiceWorkArea.CustomerServiceWorkAreaJPanel;

/**
 *
 * @author llm
 */
public class CustomerServiceRole extends Role {
    
    

    @Override
     public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, 
            Organization organization, Enterprise enterprise, EcoSystem system,
            ProductDirectory  productDirectory, OrderDirectory  orderDirectory,
            CustomerDirectory  customerDirectory) {
        return new CustomerServiceWorkAreaJPanel(userProcessContainer, account, (CustomerServiceOrganization) organization,enterprise,system);
    }
     public String toString()
    {
        return RoleType.CustomerServiceRole.toString();
    }
    
     
     
}
