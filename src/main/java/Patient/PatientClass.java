package Patient;

public class PatientClass {
    private int ID;
    private String name;
    private String dateOfBirthday;
    private String dateOfTreatment;
    private int age;
    private String allergies;
    private boolean needspecialNeeds;
    private String typeOfTreatment;

    public PatientClass() {

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(String dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public String getDateOfTreatment() {
        return dateOfTreatment;
    }

    public void setDateOfTreatment(String dateOfTreatment) {
        this.dateOfTreatment = dateOfTreatment;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public boolean getSpecialNeeds() {
        return needspecialNeeds;
    }

    public void setSpecialNeeds(boolean specialNeeds) {
        this.needspecialNeeds = specialNeeds;
    }

    public String getTypeOfTreatment() {
        return typeOfTreatment;
    }

    public void setTypeOfTreatment(String typeOfTreatment) {
        this.typeOfTreatment = typeOfTreatment;
    }


    @Override
    public String toString() {
        return "Patient" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", dateOfBirthday='" + dateOfBirthday + '\'' +
                ", dateOfTreatment='" + dateOfTreatment + '\'' +
                ", age=" + age +
                ", allergies='" + allergies + '\'' +
                ", specialNeeds=" + needspecialNeeds +
                ", typeOfTreatment='" + typeOfTreatment + '\'';
    }
}
