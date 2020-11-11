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
import userinterface.AdministrativeRole.AdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class AdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, 
            Organization organization, Enterprise enterprise, EcoSystem system,
            ProductDirectory  productDirectory, OrderDirectory  orderDirectory,
            CustomerDirectory  customerDirectory) {
        return new AdminWorkAreaJPanel(userProcessContainer, enterprise);
    }

    
    
}
