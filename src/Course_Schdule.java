import java.sql.Time;

public class Course_Schdule {
    private int scheduleID;
    private int courseID;
    private String classDay;
    Time startTime;
    Time endTime;

    Course_Schdule(int id, int courseID, String classDay, Time startTime, Time endTime){
        this.scheduleID = id;
        this.courseID = courseID;
        this.classDay = classDay;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getScheduleID(){
        return  this.scheduleID;
    }

    public int getCourseID(){
        return this.courseID;
    }

    public String getClassDay(){
        return this.classDay.toUpperCase();
    }

    public void setScheduleID(int scheduleID){
        this.scheduleID = scheduleID;
    }

    public void setClassDay(String classDay){
        this.classDay = classDay;
    }

    public void  setStartTime(Time time){
        this.startTime = time;
    }

    public void  setEndTime(Time time){
        this.endTime = time;
    }
}
