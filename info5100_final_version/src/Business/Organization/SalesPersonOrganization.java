/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Dao.ProductDirectory;
import Business.Role.CustomerManagerRole;
import Business.Role.Role;
import Business.Role.SalesPersonRole;
import java.util.ArrayList;

/**
 *
 * @author llm
 */
public class SalesPersonOrganization extends Organization {

    

//    public ProductDirectory getProductDirectory() {
//        return productDirectory;
//    }
//
//    public void setProductDirectory(ProductDirectory productDirectory) {
//        this.productDirectory = productDirectory;
//    }
     public SalesPersonOrganization() {
        super(Type.SalesPerson.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new SalesPersonRole());
        return roles;
    }
    
    
}
