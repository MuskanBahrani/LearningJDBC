import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateDataJDBC {
    public static void main(String[] args) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentManagementSystem", "root", "root");

            String query = "update StudentData set Student_name=? where Student_ID=?";

            Scanner sc = new Scanner(System.in);

            System.out.println("Enter name");
            String name = sc.nextLine();

            System.out.println("Enter ID");
            int id = sc.nextInt();

            PreparedStatement ptst = conn.prepareStatement(query);

            ptst.setString(1, name);
            ptst.setInt(2, id);

            ptst.executeUpdate();

            System.out.println("Value updated");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
