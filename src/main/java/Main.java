import DataBaseImplement.DataBaseCrudOperation;
import DataBaseImplement.DatabaseInterface;
import Id.Id;
import Patient.PatientClass;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    static Scanner myInput = new Scanner(System.in);
    static String[] tables = {"orthodontistclinic", "dentaldepartment"};
    static DatabaseInterface implement = new DataBaseCrudOperation();
   static String DatabaseName;

    public static void main(String[] args) {
        boolean exitApplicaton = false;
        System.out.println("Welcome to Dental Clinic!\n");
        int ch = databasetoEnter() - 1;
        DatabaseName = tables[ch];
        System.out.println("You have entered the " + tables[ch] + " department\n");

        do {
            try {
                long secondsToSleep = 2;
                Thread.sleep(secondsToSleep * 500);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            int CrudNumber = CrudOption();

            switch (CrudNumber) {
                case 1 -> createPatient();
                case 2 -> showAllPatient();
                case 3 -> showPatientById();
                case 4 -> updatePatient();
                case 5 -> deletePatient();
                case 6 -> exitApplicaton = true;
            }
        } while (!exitApplicaton) ;

    }

    public static void VerifyDetails(String DatabaseName){
        DataBaseCrudOperation db = new DataBaseCrudOperation();
        int count = 0;
        System.out.println();
        System.out.println("Please enter the password to enter the database for " +
                DatabaseName + "\n");
        String password = myInput.nextLine();
        while (count < 3) {
            if (Objects.equals(password, db.GetPassword(DatabaseName))) {
                System.out.println("You have successfully logged in ");
                break;
            } else {
                System.out.println("Wrong password entered\n");
                System.out.println("Please try again\n");
                count++;
            }
        }
        if (count ==3) {
            System.out.println("You have entered the wrong password 3 times\n");
            System.out.println("Please try again later\n");
            System.exit(0);
        }
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

    public static void createPatient(){
        PatientClass pat = new PatientClass();
        System.out.println("Enter ID: ");
        pat.setID(myInput.nextInt());
        System.out.println("Enter Name: ");
        pat.setName( myInput.next());
        System.out.println("Enter DOB: ");
        pat.setDateOfBirthday( myInput.next());
        System.out.println("Enter Treatment Date: ");
        pat.setDateOfTreatment( myInput.next());
        System.out.println("Enter Age: ");
        pat.setAge(myInput.nextInt());
        System.out.println("Is Special Needs?: ");
        pat.setNeedspecialNeeds(myInput.nextBoolean());
        System.out.println("Enter Treatment Type: ");
        pat.setTypeOfTreatment( myInput.next());

        implement.createPatient(pat, DatabaseName);

    }
    public static void showAllPatient(){
        implement.showAllPatient(DatabaseName);
    }

    public static void showPatientById(){
        System.out.println("Enter ID: ");
        int id = myInput.nextInt();
        implement.showPatientBasedonID(id, DatabaseName);
    }

    public static int WhichOptiontoUpdate(String [] updateOptions){
        System.out.println("Which of the options would you like to Update?\n");
        int counter = 1;
        for(String option : updateOptions){
            System.out.println(counter + ". " +  option);
        }
        System.out.println("Please Enter: ");
        int input = myInput.nextInt();
        if(input > 0 && input <= 5){
            return input;
    }
        else{
            System.out.println("Please enter a valid number | 1 | 2 | 3 | 4 | 5 \n");
            return WhichOptiontoUpdate(updateOptions);
        }
        }

    public static void updatePatient(){
        Id id = new Id();
        System.out.println("Enter the ID of the Patient you would like to change : ");
        int idToUpdate = myInput.nextInt();
        if (!id.checkifIdisthere(idToUpdate)){
            System.out.println("The ID you have entered does not exist in the database");
            System.out.println("Please enter a valid ID");
            updatePatient();
        }
        if (!id.DoesIdExistInTable(DatabaseName, idToUpdate)) {
            System.out.println("The ID you have entered does not exist in the database");
            System.out.println("Please enter a valid ID");
            updatePatient();
        }
        String[] updateOptions = {"DateofBirth", "DateofTreatment",
                "Age", "NeedSpecialNeeds", "TypeOfTreatment"};
         int updateOption = WhichOptiontoUpdate(updateOptions) - 1;
        switch (updateOption) {
            case 0 -> {
                System.out.println("Enter DateOfBirth: ");
                implement.updatePatient(idToUpdate, updateOptions[updateOption], myInput.next(), WhichOptiontoUpdate(updateOptions) + 2, DatabaseName);
            }
            case 1 -> {
                System.out.println("Enter DateOfTreatment: ");
                implement.updatePatient(idToUpdate, updateOptions[updateOption], myInput.next(), WhichOptiontoUpdate(updateOptions) + 2, DatabaseName);
            }
            case 2 -> {
                System.out.println("Enter Age: ");
                implement.updatePatient(idToUpdate, updateOptions[updateOption], myInput.next(), WhichOptiontoUpdate(updateOptions) + 2, DatabaseName);
            }
            case 3 -> {
                System.out.println("Enter  if you require NeedSpecialNeed: true or false: ");
                implement.updatePatient(idToUpdate, updateOptions[updateOption], myInput.next(), WhichOptiontoUpdate(updateOptions) + 2, DatabaseName);
            }
            case 4 -> {
                System.out.println("Enter  the TypeOfTreatment: ");
                implement.updatePatient(idToUpdate, updateOptions[updateOption], myInput.next(), WhichOptiontoUpdate(updateOptions) + 2, DatabaseName);
            }
            default -> System.out.println("ERROR!");
        }


    }

    public static void deletePatient(){
        System.out.println("Enter ID: ");
        int id = myInput.nextInt();
        implement.deletePatient(id, DatabaseName);
    }

}