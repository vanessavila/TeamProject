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

public class TestingtheConnection {


        @Test
        @DisplayName("Test to check if the connection is created to orthodontic department")
        public void testCreateConnectiontoOrtho() throws SQLException {
            Connection connection = DatabaseConnections.createconnectiontoTeethTreatment();

            assertNotNull(connection);// check if the connection is not null if it is null then
            // it will fail but if it not then there is a connection
        }

    }


