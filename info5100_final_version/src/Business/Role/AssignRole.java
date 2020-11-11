/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Dao.CourierOrderList;
import Business.Dao.CustomerDirectory;
import Business.Dao.OrderDirectory;
import Business.Dao.ProductDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.LogisticsEnterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.CourierRole.CourierWorkAreaJPanel;
import userinterface.LogisticsAssignCenter.AssignWorkAreaJPanel;

/**
 *
 * @author zlt1997
 */
public class AssignRole extends Role{


    
            @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, ProductDirectory  productDirectory, OrderDirectory  orderDirectory, CustomerDirectory  customerDirectory) {
        return new AssignWorkAreaJPanel(userProcessContainer,  account,  organization, enterprise, business);
    }

 
    
    
    
    @Override
    public String toString()
    {
        return RoleType.AssignRole.toString();
    }
           
}
