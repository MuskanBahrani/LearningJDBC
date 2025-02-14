import java.sql.DriverManager;
import java.sql.*;
import java.io.*;

public class TransactionInJDBC {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts","root","root");

            System.out.println("Connection Succesful");

            conn.setAutoCommit(false);

            String withdrawQuery = "UPDATE acc SET balance = balance - ? WHERE accNumber = ?";
            String depositQuery = "UPDATE acc SET balance = balance + ? WHERE accNumber = ?";

            PreparedStatement withdrawPreparedStatement = conn.prepareStatement(withdrawQuery);
            PreparedStatement depositPreparedStatement = conn.prepareStatement(depositQuery);

            withdrawPreparedStatement.setInt(1, 500);
            withdrawPreparedStatement.setInt(2, 101);


            depositPreparedStatement.setInt(1, 500);
            depositPreparedStatement.setInt(2, 102);

            int withdrawls = withdrawPreparedStatement.executeUpdate();
            int deposits = depositPreparedStatement.executeUpdate();

            if(withdrawls>0 && deposits>0){
                conn.commit();
                System.out.println("Transaction successful");
            }
            else{
                conn.rollback();
                System.err.println("Transaction failed");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
