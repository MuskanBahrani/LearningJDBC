import java.sql.*;
import java.io.*;
import java.util.*;

public class InsertDataJDBC {
    
    public static void main(String[] args){
        try{


            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/StudentManagementSystem";
            String username = "root";
            String password = "root";

            Connection conn = DriverManager.getConnection(url, username, password);

            String InsertDataQuery = "Insert into StudentData(Student_name) values(?)";

            PreparedStatement ptst = conn.prepareStatement(InsertDataQuery);
/*Inserting hard coded values 
            ptst.setString(1, "Muskan Bahrani");
*/
/* Inserting values through user input */
Scanner sc =  new Scanner(System.in);
System.out.println("Enter name");
String name = sc.next();

            ptst.setString(1, name);
ptst.executeUpdate();

            System.out.println("Data Inserted");

            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
