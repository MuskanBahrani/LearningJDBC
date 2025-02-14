import java.sql.*;
import java.io.*;
public class InsertingImageJDBC {
    public static void main(String[] args){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/StudentManagementSystem";
            String user = "root";
            String pass = "root";
Connection conn = DriverManager.getConnection(url,user,pass);

// String CreateTable = "create table ImageData(imageID int(10) primary key auto_increment, actualImage blob)";

// Statement stmt = conn.createStatement();
// stmt.executeUpdate(CreateTable);

// System.out.println("Table Created");

String updateQuery = "alter table ImageData modify actualImage mediumblob";

Statement stmt = conn.createStatement();

stmt.executeUpdate(updateQuery);

System.out.println("Table Updated....");

String InsertImage = "insert into ImageData(actualImage) values(?)";

PreparedStatement ptst = conn.prepareStatement(InsertImage);

FileInputStream fis =  new FileInputStream("DemoImage.png");
ptst.setBinaryStream(1, fis,fis.available());

ptst.executeUpdate();

System.out.println("Image Inserted...");


conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
