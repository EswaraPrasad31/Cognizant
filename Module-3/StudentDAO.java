import java.sql.*;
public class StudentDAO {
    Connection con;
    StudentDAO() throws Exception {
       Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test",
                "root",
                "password");
    }
    void insertStudent(int id, String name) throws Exception {
        String q = "insert into students values(?,?)";
        PreparedStatement ps = con.prepareStatement(q);
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.executeUpdate();
    }
    void updateStudent(int id, String name) throws Exception {
        String q = "update students set name=? where id=?";
        PreparedStatement ps = con.prepareStatement(q);
        ps.setString(1, name);
        ps.setInt(2, id);
        ps.executeUpdate();
    }
    public static void main(String[] args) throws Exception {
        StudentDAO s = new StudentDAO();
        s.insertStudent(1, "Ravi");
        s.updateStudent(1, "Kiran");
        System.out.println("Done");
    }
}