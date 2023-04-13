package OrthodontistClinic;

import java.sql.PreparedStatement;

public class OrthodontistClinicClass implements OrthodontistClinicDaoIntrf {
    Connection con;

    @Override
    public void createPatient(Patient pat) {
        con=DBConnection.createDBConnection();
        String query="insert into Patient values: ";
        try{
            PreparedStatement pst=con.PreparedStatement(query);
            pst.setInt(parameterindex: 1, pat.getId());
            pst.setString(parameterIndex: 2, pat.getName());
            pst.setInt(parameterIndex: 3, pat.getDate());
            int cnt=pst.executeUpdate();
            if(cnt!=0)
                System.out.println("Patient Validated!");
        }catch(Exception ex){

        }
    }

    @Override
    public void showAllPatient() {
        con=DBConnection.createDBConnection();
        String query="select * from Patient";
        System.out.println("Enter Patient details: ");
        System.out.println("*****************");
        System.out.format("%d\t%s\t%d\t%d\n", ID, "ID", "Name", "Date", "Age");
        System.out.println("***********************");

        try{
            Statement pst=con.createStatement();
            ResultSet result= stm2.executeQuery(query);
            while(result.next()){
                System.out.format("%d\t%s\t%d\t%d",
                        result.getInt(columnIndex: 1),
                result.getString(columnIndex: 2),
                result.getDouble(columnIndex: 3),
                result.getInt(columnIndex: 4);
                System.out.println("******************");

            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void showPatientBasedonID(int id) {
        con=DBConnection.createDBConnection();
        String query="select * from patient where id=" +id);
        try {
            Statement stm2=con.createStatement();
            ResultSet result= stm2.executeQuery(query);
            while(result.next()){
                System.out.format("%d\t%s\t%d\t%d",
                        result.getInt(columnIndex: 1),
                result.getString(columnIndex: 2),
                result.getDouble(columnIndex: 3),
                result.getInt(columnIndex: 4);
                System.out.println("******************");
            }
        }
    }

    @Override
    public void updatePatient (int id, String name) {
        con = DBConnection.createDBConnection();
        String query = "Update Patient";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(parameterIndex: 1, name);
            pst.setInt(parameterIndex: 2, id);
            int cnt= pst.executeUpdate();
            if(cnt!=0)
                System.out.println("Employee Details updated!");

        }catch(Exception ex){
            ex.printStackrace();
        }
    }

    @Override
    public void deletePatient (int id) {
        con = DBConnection.createDBConnection();
        String query = "delete from employee where id =?";
        try{
            PreparedStatement pst = con.preparedStatement(query);
            pst.setInt(parameterIndex: 1, id);
            int cnt = pst.executeUpdate();
            id(cnt!=0)
            System.out.println("Patient deleted!" +id);

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}


