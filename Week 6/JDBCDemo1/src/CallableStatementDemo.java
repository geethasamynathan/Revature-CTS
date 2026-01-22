import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class CallableStatementDemo {

    public static void main(String[] args) {

        try {
            // STEP 1: Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver loaded");

            // STEP 2: Create Connection
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE",
                    "system",
                    "admin"
            );
            System.out.println("Database connected");

            // STEP 3: Prepare CallableStatement
            CallableStatement cs =
                    con.prepareCall("{ call get_emp_salary(?, ?) }");

            // STEP 4: Set IN parameter
            cs.setInt(1, 107);   // EMP_ID

            // STEP 5: Register OUT parameter
            cs.registerOutParameter(2, Types.INTEGER);

            // STEP 6: Execute stored procedure
            cs.execute();

            // STEP 7: Get OUT parameter value
            int salary = cs.getInt(2);
            System.out.println("Employee Salary: " + salary);

            // STEP 8: Close resources
            cs.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
