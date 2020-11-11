/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Dao.CourierOrderList;
import Business.Role.AssignRole;
import Business.Role.CourierRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author zlt1997
 */
public class AssignCenterOrganization extends Organization{
   
    private CourierOrderList courierOrderList; 
    
    public AssignCenterOrganization() {
        super(Type.AssignCenter.getValue());
        this.courierOrderList=new CourierOrderList();
    }

   
    public CourierOrderList getCourierOrderList() {
        return courierOrderList;
    }
       
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles=new ArrayList<>();
        roles.add(new AssignRole());
        return roles;
    }
}
