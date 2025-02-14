import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.*;
import javax.swing.JFileChooser;

public class DynamicImageInsert {

    public static void main(String[] args){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentManagementSystem", "root", "root");

            String query = "insert into ImageData(actualImage) values(?)";

            PreparedStatement ptst  = conn.prepareStatement(query);

            JFileChooser jfc = new JFileChooser();

            jfc.showOpenDialog(null);

            File selectedFile = jfc.getSelectedFile();

            FileInputStream fis = new FileInputStream(selectedFile);

            ptst.setBinaryStream(1, fis, fis.available());

            ptst.executeUpdate();

            System.out.println("Image inserted");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
