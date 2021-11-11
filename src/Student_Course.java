public class Student_Course {
    private int courseID;
    private int studentID;

    public int getCourseID(){
        return this.courseID;
    }

    public int getStudentID(){
        return this.studentID;
    }

    public void setCourseID(int courseId){
        this.courseID = courseId;
    }

    public void setStudentID(int studentId){
        this.studentID = studentId;
    }
}
