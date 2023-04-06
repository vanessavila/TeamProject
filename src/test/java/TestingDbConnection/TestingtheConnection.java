package TestingDbConnection;
import Dbconnection.DatabaseConnections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
//Test passed 100% so the connection is created successfully
@Execution(ExecutionMode.CONCURRENT) // this is so it can run the different tests at the same time
//using multiple threads to run the tests and not one thread and we are able to do this because
// we are using junit 5 and also we enabled it true in the properties file
public class TestingtheConnection {


        @Test
        @DisplayName("Test to check if the connection is created to orthodontic department")
        public void testCreateConnectiontoOrtho() throws SQLException {
            Connection connection = DatabaseConnections.createconnectiontoTeethTreatment();

            assertNotNull(connection);// check if the connection is not null if it is null then
            // it will fail but if it not then there is a connection
        }

    }


