import DataBaseImplement.DataBaseCrudOperation;
import DataBaseImplement.DatabaseInterface;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    static Scanner myInput = new Scanner(System.in);
  static  String[] tables = {"orthodontistclinic", "dentaldepartment"};
    public static void main(String[] args) {
        boolean exitApplicaton = false;
        System.out.println("Welcome to Dental Department!\n");
        DatabaseInterface implement = new DataBaseCrudOperation();
        int ch = databasetoEnter() - 1;
        System.out.println("You have entered the " + tables[ch] + " database\n");

        do {
            try {
                long secondsToSleep = 2;
                Thread.sleep(secondsToSleep * 500);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            int CrudNumber = CrudOption();

            switch (CrudNumber) {
                case 1 -> CreatePatient();
                case 2 -> showAllPatient();
                case 3 -> showPatientById();
                case 4 -> UpdatePatient();
                case 5 -> DeletePatient();
                case 6 -> exitApplicaton = true;
            }
        } while (!exitApplicaton) ;

    }

    public static boolean VerifyDetails(String DatabaseName){
        DataBaseCrudOperation db = new DataBaseCrudOperation();
        int count = 0;
        System.out.println();
        System.out.println("Please enter the password to enter the database for " +
                DatabaseName + "\n");
        String password = myInput.nextLine();
        while (count < 3) {
            if (Objects.equals(password, db.GetPassword(DatabaseName))) {
                return true;
            } else {
                System.out.println("Wrong password entered\n");
                System.out.println("Please try again\n");
                count++;
            }
        }
        System.out.println("You have entered the wrong password 3 times\n");
        System.out.println("Please try again later\n");
        System.exit(0);
        return false;
    }

    public static int databasetoEnter() {
        // using file create a password and username identification system
        System.out.println("Which database do you want to enter\n");
        System.out.println("1. Orthodontist Clinic\n");
        System.out.println("2. Dental Department\n");
        int ch = myInput.nextInt();
        switch (ch) {
            case 1 -> {
                VerifyDetails(tables[ch - 1]);
                return 1;
            }
            case 2 -> {
                VerifyDetails(tables[ch - 1]);
                return 2;
            }
            default -> {
                System.out.println("Please enter a valid number | 1 | 2\n");
                System.out.println("1. Orthodontist Clinic\n");
                System.out.println("2. Dental Department\n");
                return databasetoEnter();
            }
        }
    }


    public static int CrudOption() {
        System.out.println();
        System.out.println("1. Create Patient\n");
        System.out.println("2. Show All Patient\n");
        System.out.println("3. Show Patient by Id\n");
        System.out.println("4. Update Patient\n");
        System.out.println("5. Delete Patient\n");
        System.out.println("6. Exit Application\n");
        System.out.println(" Please enter your choice\n");
        int CrudOption = myInput.nextInt();
        if (CrudOption > 0 && CrudOption <= 6) {
            return CrudOption;
        } else {
            System.out.println("Please enter a valid number | 1 | 2 | 3 | 4 | 5 | 6\n");
            System.out.println("The options are as follows\n");
            return CrudOption();
        }

    }

    public static void CreatePatient(){
        PatientClass patient = new PatientClass();
        System.out.println("Enter ID: ");
        int ID = myInput.nextInt();
        System.out.println("Enter Name: ");
        String name = myInput.next();
        System.out.println("Enter DOB: ");
        String dateOfBirthday = myInput.next();
        System.out.println("Enter Treatment Date: ");
        String dateOfTreatment= myInput.next();
        System.out.println("Enter Address: ");
        String address = myInput.next();
        System.out.println("Enter Age: ");
        int age = myInput.nextInt();
        System.out.println("Enter Allergies: ");
        String allergies = myInput.next();
        System.out.println("Is Special Needs?: ");
        boolean needspecialNeeds = myInput.nextBoolean();
        System.out.println("Enter Treatment Type: ");
        String typeOfTreatment = myInput.next();
        patient.setID(ID);
        patient.setName(name);
        patient.setDateOfBirthday(dateOfBirthday);
        patient.setDateOfTreatment(dateOfTreatment);
        patient.setAddress(address);
        patient.setAge(age);
        patient.setNeedspecialNeeds(needspecialNeeds);
        patient.setTypeOfTreatment(typeOfTreatment);
        implement.createPatient(patient);

    }
    public static void showAllPatient(){

    }

    public static void showPatientById(){

    }

    public static void UpdatePatient(){

    }

    public static void DeletePatient(){


    }

}