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
import userinterface.SystemAdminWorkArea.SystemAdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class SystemAdminRole extends Role{


    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, 
            Organization organization, Enterprise enterprise, EcoSystem system,
            ProductDirectory  productDirectory, OrderDirectory  orderDirectory,
            CustomerDirectory  customerDirectory) {
        return new SystemAdminWorkAreaJPanel(userProcessContainer, system);
    }
    
}
