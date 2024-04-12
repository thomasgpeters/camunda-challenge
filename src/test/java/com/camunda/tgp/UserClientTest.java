package com.camunda.tgp;

import org.apache.log4j.BasicConfigurator;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit test for simple App.
 */
public class UserClientTest {

    private static final Logger logger = LoggerFactory.getLogger(UserClient.class);
    
    private List<User> users = new ArrayList<User>();
    private UserClient userClient;

    static Integer EXPECTED_LIST_SIZE = new Integer(6);
    static String EXPECTED_USER_NAME = new String("George");
    /**
     * Rigorous Test :-)
     */
    
    @org.junit.Before
    public void setUp() throws Exception {
        BasicConfigurator.configure(); 
        logger.info( "Setting-up: Camunda Challenge." );

        userClient = new UserClient();

    }

    @org.junit.Test
    public void camundaChallenge_test1_validateNumberOfUsersReturned() {

        logger.info("Running: Camunda Challenge : test1 validate number of Users returned.");
        String[] args = new String[1];
        args[0] = "1";

        try {
            users = userClient.getUsers(args);
        } catch (InvalidUserResponseException iurex) {
            logger.error("Incorrect Data from api.");
        } catch (NullPointerException npe) {
            logger.error("null pointer!");
        }

        Integer resultCount = new Integer(users.size());
        logger.info( "User Count: " + resultCount );

        assertTrue("Validate User List size.", (resultCount.equals(EXPECTED_LIST_SIZE)));
    }

    @org.junit.Test
    public void camundaChallenge_test2_validateFirstUserIsGeorge() {
        
        logger.info("Running: Camunda Challenge : test2 validate User's first name is George.");
        String[] args = new String[1];
        args[0] = "1";

        try {
            users = userClient.getUsers(args);
        } catch (InvalidUserResponseException iurex) {
            logger.error("Incorrect Data from api.");
        } catch (NullPointerException npe) {
            logger.error("null pointer!");
        }

        User firstUserRecord = users.get(0);
        logger.info( "First Name: " + firstUserRecord.getFirstName() );

        assertTrue("Validate User Name is George.", ( firstUserRecord.getFirstName().equals( EXPECTED_USER_NAME ) ));   
    }
 
    @org.junit.After
    public void tearDown() throws Exception {
        logger.info("Teardown: Camunda Challenge.");
        users = null;
        userClient = null;
        assertTrue("Validate User List is null", ( users == null ));
    }
}
