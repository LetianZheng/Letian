/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.CustomerManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author llm
 */
public class CustomerManagerOrganization extends Organization {

     public CustomerManagerOrganization() {
        super(Type.CustomerManager.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new CustomerManagerRole());
        return roles;
    }
    
}
