/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Dao.OrderDirectory;
import Business.Network.Network;
import Business.Role.Role;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author llm
 */
public class EcoSystemTest {
    
    public EcoSystemTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class EcoSystem.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        EcoSystem expResult = null;
        EcoSystem result = EcoSystem.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createAndAddNetwork method, of class EcoSystem.
     */
    @Test
    public void testCreateAndAddNetwork() {
        System.out.println("createAndAddNetwork");
        EcoSystem instance = null;
        Network expResult = null;
        Network result = instance.createAndAddNetwork();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSupportedRole method, of class EcoSystem.
     */
    @Test
    public void testGetSupportedRole() {
        System.out.println("getSupportedRole");
        EcoSystem instance = null;
        ArrayList<Role> expResult = null;
        ArrayList<Role> result = instance.getSupportedRole();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrderDirectory method, of class EcoSystem.
     */
    @Test
    public void testGetOrderDirectory() {
        System.out.println("getOrderDirectory");
        EcoSystem instance = null;
        OrderDirectory expResult = null;
        OrderDirectory result = instance.getOrderDirectory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOrderDirectory method, of class EcoSystem.
     */
    @Test
    public void testSetOrderDirectory() {
        System.out.println("setOrderDirectory");
        OrderDirectory orderDirectory = null;
        EcoSystem instance = null;
        instance.setOrderDirectory(orderDirectory);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNetworkList method, of class EcoSystem.
     */
    @Test
    public void testGetNetworkList() {
        System.out.println("getNetworkList");
        EcoSystem instance = null;
        ArrayList<Network> expResult = null;
        ArrayList<Network> result = instance.getNetworkList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNetworkList method, of class EcoSystem.
     */
    @Test
    public void testSetNetworkList() {
        System.out.println("setNetworkList");
        ArrayList<Network> networkList = null;
        EcoSystem instance = null;
        instance.setNetworkList(networkList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkIfUserIsUnique method, of class EcoSystem.
     */
    @Test
    public void testCheckIfUserIsUnique() {
        System.out.println("checkIfUserIsUnique");
        String userName = "";
        EcoSystem instance = null;
        boolean expResult = false;
        boolean result = instance.checkIfUserIsUnique(userName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
