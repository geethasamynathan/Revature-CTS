import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcOracleDemo {

	public static void main(String[] args) {
		try {
            // step 1: load the database driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver is loaded....");
           
            // step 2 : get the database connection
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM", "admin");
            System.out.println("Got database connection....");
           
            // step 3: create the statement
            Statement st = con.createStatement();
           
            // step 4: execute the sql query
            ResultSet rs = st.executeQuery("SELECT * FROM EMP");
           
            // step 5: process the results
            while(rs.next())
            {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int sal = rs .getInt("SALARY");
            System.out.println(id + "\t" + name +"\t" + sal);
            }
           
            rs.close();
            st.close();
            con.close();
           
        } catch (ClassNotFoundException e) {
            System.out.println("Exception caught...." + e);
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Exception caught...." + e);
            e.printStackTrace();
        }
 
    }
	}


