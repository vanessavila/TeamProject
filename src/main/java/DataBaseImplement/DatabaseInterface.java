package DataBaseImplement;

import Patient.PatientClass;

public interface DatabaseInterface {
    boolean createPatient(PatientClass pat);

    void showAllPatient();

    void showPatientBasedonID(int id);
    void updatePatient (int id, String itemtoUpdate, String newValue, int index);

    void deletePatient (int id);



}