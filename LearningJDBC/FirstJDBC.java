import java.sql.*;
public class FirstJDBC {

    public static void main(String[] args){
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/StudentManagementSystem";
            String username = "root";
            String password = "root";

            Connection con = DriverManager.getConnection(url,username,password);

            if(con.isClosed()){
                System.out.println("Connection is closed");
            }
            else{
                System.out.println("Connection Succesful");
            }


            con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
