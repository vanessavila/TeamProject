package DataBaseImplement;
import Dbconnection.DatabaseConnections;
import Id.Id;
import Patient.PatientClass;

import java.sql.*;
import java.util.Objects;

public class OrthodontistClinic  extends Id implements DatabaseInterface  {
    Connection con;

    @Override
    public boolean createPatient(PatientClass pat) {
        con= DatabaseConnections.createconnectiontoTeethTreatment();
        String query="insert into orthodontistclinic values: ";
        try{
            PreparedStatement pst=con.prepareStatement(query);
            pst.setInt( 1, pat.getID());
            pst.setString( 2, pat.getName());
            pst.setString( 3, pat.getDateOfBirthday());
            pst.setString( 4, pat.getDateOfTreatment());
            pst.setString( 5, pat.getAddress());
            pst.setInt( 6, pat.getAge());
            pst.setString( 7, pat.getAllergies());
            pst.setBoolean( 8, pat.isNeedspecialNeeds());
            pst.setString( 9, pat.getTypeOfTreatment());

            int cnt=pst.executeUpdate();
            addId(pat.getID());
            if(cnt!=0){
                return true;
            }

        }catch(Exception ex){
            return false;
        }
        return false;
    }

    @Override
    public void showAllPatient() {
        con= DatabaseConnections.createconnectiontoTeethTreatment();
        String query="select * from orthodontistclinic";
        System.out.println("Enter Patient details: ");
        System.out.println("*****************");
        System.out.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s", "ID", "Name", "DateofBirth", "DateofTreatment", "Address", "Age", "Allergies", "NeedsSpecialNeeds", "TypeOfTreatment");
        System.out.println("***********************");

        try{
            Statement stm2 =con.createStatement();
            ResultSet result= stm2.executeQuery(query);
            while(result.next()){
                System.out.format("%d\t%s\t%s\t%s\t%s\t%s\t%s\t%b\t%s",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getInt(6),
                        result.getString(7),
                        result.getBoolean(8),
                        result.getString(9));


                System.out.println("******************");

            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void showPatientBasedonID(int id) {
        con=DatabaseConnections.createconnectiontoTeethTreatment();
        String query="select * from orthodontistclinic where id=" + id;
        try {
            Statement stm2=con.createStatement();
            ResultSet result= stm2.executeQuery(query);
            while(result.next()){
                System.out.format("%d\t%s\t%s\t%s\t%s\t%s\t%s\t%b\t%s",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getInt(6),
                        result.getString(7),
                        result.getBoolean(8),
                        result.getString(9));
                System.out.println("******************");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void updatePatient (int id, String itemtoUpdate, String newValue, int index) {
        // take 3 things
        //id to know which person to update

        con = DatabaseConnections.createconnectiontoTeethTreatment();
        String query = "update orthodontistclinic set " + itemtoUpdate + " = ? where id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            if (Objects.equals(itemtoUpdate, "Id") || Objects.equals(itemtoUpdate, "age")){
                ps.setInt(index, Integer.parseInt(newValue));

            } else if (Objects.equals(itemtoUpdate, "needspecialNeeds")) {
                ps.setBoolean(index, Boolean.parseBoolean(newValue));

            }else{
                ps.setString(index,newValue);
            }
            int count = ps.executeUpdate();
            if (count > 0){
                System.out.println("Employee updated successfully");
            }
            else {
                System.out.println("Employee not updated");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePatient (int id) {
        con = DatabaseConnections.createconnectiontoTeethTreatment();
        String query = "delete from orthodontistclinic where id =?";
        try{
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt( 1, id);
            int cnt = pst.executeUpdate();
            if (cnt!=0) {
                System.out.println("Patient deleted!" + id);
                removeIdfromList("orthodontistclinic",id);
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }


    }
}



    

