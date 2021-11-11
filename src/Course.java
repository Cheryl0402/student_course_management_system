public class Course {
    private int courseID;
    private String courseName;

    Course(int id, String name){

        this.courseID = id;
        this.courseName = name;
    }

    public int getCourseID(){
        return this.courseID;
    }

    public String getCourseName(){
        return this.courseName;
    }

    public void setCourseID(int id){
        this.courseID = id;
    }

    public void setCourseName(String courseName){
        this.courseName = courseName;
    }


}
