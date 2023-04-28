package Id;

import Dbconnection.DatabaseConnections;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Id {
    private final List<Integer> id = new ArrayList<>();
    //There two ways , one is if we use the different database way

    //The other is if we use the table way
    Connection connection = DatabaseConnections.createconnectiontoTeethTreatment();

    DatabaseMetaData tabledata;
//So this class will return all the table in our database
    public ResultSet getTable() {
        try {
            tabledata = connection.getMetaData();
            String[] differenttable = {"TABLE"};
            return tabledata.getTables(null, null, null, differenttable);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public Id() {

    }


//This is to add Id to the list however before doing so we need to check if the id is already there
    //This class will only be used when creating a Patient
    public boolean addId(int id) {
        boolean check;
        if (this.id.size() == 0) {
            this.id.add(id);
            return true;
        }
        check = checkifIdisthere(id);
        if (!check) {
            this.id.add(id);
            return true;
        }
        //I would like to create a custom exception here but we can do that later
        // {1,2,3,4}
        //Someone enter 2
        //We send an error back to the user saying that the id is already there and then we will make him add a new one
        System.out.println("The id is already there");
        return false;
    }
    //To check if the id is already there in the list and we are using o(n) Complexity
    //However later on we can try to sort the id in the List and that way we can use
    //Binary search and get it o(log n) Complexity but we can do that later once we are done the project
    public boolean checkifIdisthere(int id){
        if (this.id.size() == 0) {
            return false;
        }
        else {
            for (Integer integer : this.id) {
                if (integer == id) {
                    return true;
                }
            }
            return false;
        }
    }

    public List<Integer> allId() {
        return id;
    }
    // In one table - rayan - id 4 - we wanted to remove it from the list
    //
    //in the other one we imported rayan so now two tables have an id  4
    //So we need to check if the id is in the other table before we can remove it from this table
    //If not then we leave a chance with different patients having the same id which will
    //screw up our program
    public boolean removeIdfromList(String table,int identity) {
        boolean canweRemove;

        try {
            canweRemove = IdExistInOtherTable(table,identity);
            if(canweRemove){
                for (int i = 0; i < this.id.size(); i++) {
                    if (this.id.get(i) == identity) {
                        this.id.remove(i);
                        return true;
                    }
                }
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean DoesIdExistInTable(String table, int id) {
        String sqlQuery = "SELECT id FROM " + table + " WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet ids = preparedStatement.executeQuery(sqlQuery);
            while (ids.next()) {
                if (ids.getInt("id") == id) {
                    return true;
                }
            }

            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean IdExistInOtherTable(String table,int identity) throws SQLException {
        ResultSet tables = getTable();

        boolean check = checkiftableexist(tables, table);
        if (!check){
            return false;
        }

        ArrayList <Integer> ids = new ArrayList<>();

        while (tables.next()) {
            if (!tables.getString("TABLE_NAME").equals(table)) {

                Statement statement = connection.createStatement();
                String mytable = tables.getString("TABLE_NAME");
                String sqlQuery = "SELECT id FROM " + mytable + " WHERE id = ?";
                ResultSet theids = statement.executeQuery(sqlQuery);
                while (theids.next()) {
                    ids.add(theids.getInt("id"));
                }
                for (Integer integer : ids) {
                    if (integer == identity) {
                        return false;
                    }
                }

            }
        }
        return true;

    }

    private boolean checkiftableexist(ResultSet tables, String table) {
        try {
            while (tables.next()) {
                if (tables.getString("TABLE_NAME").equals(table)) {
                    return true;
                }
            }
            //We should make a custom exception here but we can do that later for now we will
            // just return false
            System.out.println("The table does not exist");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }




}
