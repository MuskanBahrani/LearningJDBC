import java.sql.*;

public class CreateTableJDBC {
    

    public static void main(String[] args){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/StudentManagementSystem";
            String user = "root";
            String password = "root";

            Connection conn = DriverManager.getConnection(url, user, password);

            String createTableQuery = "create table StudentData(Student_ID int(10) primary key auto_increment, Student_name varchar(100) not null)";

            Statement stmt = conn.createStatement();

            stmt.executeUpdate(createTableQuery);
            System.out.println("Table is created");

            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
}
