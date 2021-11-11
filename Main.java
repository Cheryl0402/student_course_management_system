import java.sql.*;

public class Main {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String USER = "root";
    static final String PASSWORD = "G8Da7Meu#%";
    private static Connection connection = null;
    private static Statement statement = null;

    // function to get database connection
    private static void getDBConnection(){
        System.out.println("Program started...");
        try{
            //Connect to the database
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connected to the database!!!");

            // get statement connection.
            statement = connection.createStatement();
        }catch(SQLException e){
            System.out.println(e.getNextException());
        }catch (ClassNotFoundException e){
            System.out.println(e.getException());
        }
    }

    //Function to stop database connection
    private static void stopDBConnection(){
        try{
            if(connection != null){
                connection.close();
                System.out.println("Connection to the database has been stopped!!!");
            }
        }catch(SQLException e){
            System.out.println(e.getNextException());
        }

    }

    // Function to init new database
    private static void createDB(){
        try{
            String createDB = "CREATE DATABASE IF NOT EXISTS STUDENT_COURSE_MANAGEMENT ";
            statement.executeUpdate(createDB);
            System.out.println("Database created successfully...");
        }catch(SQLException e){
            System.out.println(e.getNextException());
        }
    }

    // Function to create table
    private static void createTables(){
        try{
            statement = connection.createStatement();
            String student_table = "CREATE TABLE IF NOT EXISTS STUDENT_COURSE_MANAGEMENT.Student " +
                    "(student_id INT NOT NULL AUTO_INCREMENT UNIQUE, " +
                    " first_name VARCHAR(200) NOT NULL, " +
                    " last_name  VARCHAR(200) NOT NULL, " +
                    " PRIMARY KEY (student_id ))";
            String course_table = "CREATE TABLE IF NOT EXISTS STUDENT_COURSE_MANAGEMENT.Course " +
                    "(course_id INT NOT NULL AUTO_INCREMENT UNIQUE, " +
                    " course_name VARCHAR(250) NOT NULL UNIQUE, " +
                    " PRIMARY KEY (course_id)) ";
            String student_course = "CREATE TABLE IF NOT EXISTS STUDENT_COURSE_MANAGEMENT.Student_Course " +
                    "(course_id INT NOT NULL, " +
                    " student_id INT NOT NULL, " +
                    " CONSTRAINT Student_Course_fk_Student " +
                    "   FOREIGN KEY (student_id) REFERENCES Student (student_id), " +
                    " CONSTRAINT Student_Course_fk_Course " +
                    "   FOREIGN KEY (course_id) REFERENCES Course (course_id)) ";
            String course_schedule = "CREATE TABLE IF NOT EXISTS STUDENT_COURSE_MANAGEMENT.Course_Schedule " +
                    "(schedule_id INT NOT NULL AUTO_INCREMENT UNIQUE, " +
                    "course_id INT NOT NULL UNIQUE, " +
                    " classDay VARCHAR(25) NOT NULL, " +
                    " start_time TIME(0) NOT NULL, " +
                    " end_time TIME(0) NOT NULL, " +
                    " PRIMARY KEY (schedule_id), " +
                    " CONSTRAINT Course_Schedule_fk_Course " +
                    "   FOREIGN KEY (course_id) REFERENCES Course (course_id)) ";

            statement.executeUpdate(student_table);
            statement.executeUpdate(course_table);
            statement.executeUpdate(student_course);
            statement.executeUpdate(course_schedule);

            System.out.println("Tables created successfully...");

        }catch(SQLException e){
            System.out.println(e.getSQLState());
        }
    }

    // ADD new student to student table
    // ADD NEW COURSE TO COURSE TABLE

    // ENROLL STUDENT TO COURSE

    //


    public static void main(String args[]){
        getDBConnection();
        createDB();
        createTables();
        stopDBConnection();

    }



}
