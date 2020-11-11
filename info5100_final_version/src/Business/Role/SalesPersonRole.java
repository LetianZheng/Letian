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
import Business.Organization.Organization;
import Business.Organization.SalesPersonOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkQueue;
import javax.swing.JPanel;
import userinterface.SalesPersonRole.SalesPersonWorkAreaJPanel;

/**
 *
 * @author llm
 */
public class SalesPersonRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, 
            Organization organization, Enterprise enterprise, EcoSystem system,
            ProductDirectory  productDirectory, OrderDirectory  orderDirectory,
            CustomerDirectory  customerDirectory) {
        return new SalesPersonWorkAreaJPanel(userProcessContainer, account, 
                (SalesPersonOrganization)organization, enterprise,system,
                   customerDirectory);
    }
     public String toString()
    {
        return RoleType.SalesPerson.toString();
    }
    
}
