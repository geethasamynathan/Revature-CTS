import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeCrudDemo {

    // ==============================
    // DATABASE CONFIGURATION
    // ==============================
    private static final String DB_URL =
            "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String DB_USER = "system";
    private static final String DB_PASSWORD = "admin";

    // ==============================
    // GET DATABASE CONNECTION
    // ==============================
    private static Connection getConnection()
            throws ClassNotFoundException, SQLException {

        // Load Oracle JDBC Driver
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // Return database connection
        return DriverManager.getConnection(
                DB_URL, DB_USER, DB_PASSWORD);
    }

    // ==============================
    // CREATE (INSERT EMPLOYEE)
    // ==============================
    public static void addEmployee(int empId, String name, int salary) {

        String insertSql =
                "INSERT INTO EMP (EMP_ID, NAME, SALARY) VALUES (?, ?, ?)";

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(insertSql);

            ps.setInt(1, empId);
            ps.setString(2, name);
            ps.setInt(3, salary);

            ps.executeUpdate();
            System.out.println("Employee inserted successfully");

        } catch (Exception e) {
            System.out.println("Insert Error: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // ==============================
    // READ (FETCH ALL EMPLOYEES)
    // ==============================
    public static void getAllEmployees() {

        String selectSql =
                "SELECT EMP_ID, NAME, SALARY FROM EMP";

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(selectSql);
            rs = ps.executeQuery();

            System.out.println("\nEMPLOYEE LIST");
            System.out.println("--------------------");

            while (rs.next()) {
                int id = rs.getInt("EMP_ID");
                String name = rs.getString("NAME");
                int salary = rs.getInt("SALARY");

                System.out.println(id + " | " + name + " | " + salary);
            }

        } catch (Exception e) {
            System.out.println("Read Error: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // ==============================
    // UPDATE (UPDATE SALARY)
    // ==============================
    public static void updateEmployeeSalary(int empId, int newSalary) {

        String updateSql =
                "UPDATE EMP SET SALARY = ? WHERE EMP_ID = ?";

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(updateSql);

            ps.setInt(1, newSalary);
            ps.setInt(2, empId);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Employee salary updated");
            else
                System.out.println("Employee not found");

        } catch (Exception e) {
            System.out.println("Update Error: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // ==============================
    // DELETE (REMOVE EMPLOYEE)
    // ==============================
    public static void deleteEmployee(int empId) {

        String deleteSql =
                "DELETE FROM EMP WHERE EMP_ID = ?";

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(deleteSql);

            ps.setInt(1, empId);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Employee deleted");
            else
                System.out.println("Employee not found");

        } catch (Exception e) {
            System.out.println("Delete Error: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // ==============================
    // MAIN METHOD
    // ==============================
    public static void main(String[] args) {

        addEmployee(301, "RAJ", 12000);
        addEmployee(302, "ANU", 14000);

        getAllEmployees();

        updateEmployeeSalary(301, 16000);

        deleteEmployee(302);

        getAllEmployees();
    }
}
