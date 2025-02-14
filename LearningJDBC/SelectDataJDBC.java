import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class SelectDataJDBC {
    public static void main(String[] args) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentManagementSystem", "root", "root");

            String query = "select * from StudentData";

            Statement stmt = conn.createStatement();

            ResultSet rset = stmt.executeQuery(query);

            while(rset.next()){
                int id = rset.getInt(1);
                String name = rset.getString(2);

                System.out.println(id + " " + name);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
