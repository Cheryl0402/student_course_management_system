public class Student {
    private int studentID;
    private String firstName;
    private String lastName;

    Student(int id, String firstName, String lastName){
        this.studentID = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getStudentID(){
        return this.studentID;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getName(){
        return this.firstName + " " + this.lastName;
    }

    public void setStudentID(int studentID){
        this.studentID = studentID;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void  setLastName(String lastName){
        this.lastName = lastName;
    }


}
