/**
 * This file contains unit tests for the ManagerBalancer interface and its implementing 
 * class, ManagerBalancerImpl
 * 
 * @author Andrew Curry
 */
package com.revature.testing;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.revature.backend.service.ManagerBalancer;
import com.revature.backend.service.ManagerBalancerImpl;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.support.XmlWebApplicationContext;

@SpringBootTest(classes={ManagerBalancer.class, ManagerBalancerImpl.class})
@RunWith(SpringRunner.class)
public class TestManagerBalancer {

    // ----------
    // SETUP
    // ----------

    @Autowired
    private ManagerBalancer managerBalancer;

    // ----------
    // TEST METHODS
    // ----------

    // ----------
    // sortBatchesBySize() TESTS
    // ----------

    @Test
    public void testSortBatchesBySize(){

    }
}
