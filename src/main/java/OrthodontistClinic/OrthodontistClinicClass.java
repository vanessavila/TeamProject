package DataBaseImplement;
import Dbconnection.DatabaseConnections;
import Patient.PatientClass;

import java.sql.*;

public class OrthodontistClinic implements DatabaseInterface {
        Connection con;

        @Override
        public boolean createPatient(PatientClass pat) {
            con= DatabaseConnections.createconnectiontoTeethTreatment();
            String query="insert into Patient values: ";
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
            String query="select * from Patient";
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
            String query="select * from patient where id=" + id;
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
// we will do this later since this is more complicated
        @Override
        public void updatePatient (int id, String itemtoUpdate, String newValue) {

        }

        @Override
        public void deletePatient (int id) {
            con = DatabaseConnections.createconnectiontoTeethTreatment();
            String query = "delete from employee where id =?";
            try{
                PreparedStatement pst = con.prepareStatement(query);
                pst.setInt( 1, id);
                int cnt = pst.executeUpdate();
               if (cnt!=0) {
                    System.out.println("Patient deleted!" + id);
                }

            } catch(Exception ex) {
                ex.printStackTrace();
            }
            
 
        }
    }
    
    


