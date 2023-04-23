package DataBaseImplement;

import Patient.PatientClass;

public interface DatabaseInterface {
    boolean createPatient(PatientClass pat, String DatabaseName);

    void showAllPatient(String DatabaseName);

    void showPatientBasedonID(int id, String DatabaseName);
    void updatePatient (int id, String itemtoUpdate, String newValue, int index ,String DatabaseName);

    void deletePatient (int id,String DatabaseName);

    String GetPassword (String databaseName);

    void SetPassword (String password, String databaseName);

}
