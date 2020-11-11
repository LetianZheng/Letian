/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.CustomerService.getValue())){
            organization = new CustomerServiceOrganization();
            organization.setOrganizationID(organizationList.size()+1);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.CustomerManager.getValue())){
            organization = new CustomerManagerOrganization();
            organization.setOrganizationID(organizationList.size()+1);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.SalesPerson.getValue())){
            organization = new SalesPersonOrganization();
            organization.setOrganizationID(organizationList.size()+1);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.AssignCenter.getValue())){
            organization = new AssignCenterOrganization();
            organization.setOrganizationID(organizationList.size()+1);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Courier.getValue())){
            organization = new CourierOrganization();
            organization.setOrganizationID(organizationList.size()+1);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.CustomerService.getValue())){
            organization = new CourierOrganization();
            organization.setOrganizationID(organizationList.size()+1);
            organizationList.add(organization);
        }
        else if(type.getValue().equals(Type.WarehouseManager.getValue())){
            organization = new WarehouseOrganization();
            organization.setOrganizationID(organizationList.size()+1);
            organizationList.add(organization);
        }
        
        else if(type.getValue().equals(Type.SupplierManager.getValue())){
            organization = new ContractorProductOrganization();
            organization.setOrganizationID(organizationList.size()+1);
            organizationList.add(organization);
        
        
        }
        return organization;
    }
}