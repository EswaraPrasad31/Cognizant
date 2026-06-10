import java.sql.*;
public class TransactionDemo {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test",
                    "root",
                    "password");
            con.setAutoCommit(false);
            Statement st = con.createStatement();
            st.executeUpdate(
                    "update accounts set balance=balance-500 where id=1");
            st.executeUpdate(
                    "update accounts set balance=balance+500 where id=2");
            con.commit();
            System.out.println("Transfer Successful");
        } catch(Exception e) {
            System.out.println("Transfer Failed");
        }
    }
}