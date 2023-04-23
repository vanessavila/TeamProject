import DataBaseImplement.OrthodontistClinic;
import Patient.PatientClass;

import java.util.Scanner;

public class Main {
    static Scanner myinput = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exitApplicaton = false;
        String[] tables = {"orthodontistclinic", "dentaldepartment"};
        System.out.println("Welcome to Dental Department!\n");
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

    public static int databasetoEnter() {
        // using file create a password and username identification system
        System.out.println("Which database do you want to enter\n");
        System.out.println("1. Orthodontist Clinic\n");
        System.out.println("2. Dental Department\n");
        int ch = myinput.nextInt();
        switch (ch) {
            case 1 -> {
                return 1;
            }
            case 2 -> {
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
        int CrudOption = myinput.nextInt();
        if (CrudOption > 0 && CrudOption <= 6) {
            return CrudOption;
        } else {
            System.out.println("Please enter a valid number | 1 | 2 | 3 | 4 | 5 | 6\n");
            System.out.println("The options are as follows\n");
            return CrudOption();
        }

    }

    public static void CreatePatient(){

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