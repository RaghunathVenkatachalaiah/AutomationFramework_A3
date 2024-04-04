package pratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

	public class SampleJDBCExecuteUpdate {
		
		public static void main(String[] args) throws SQLException {
			
			Driver driverRef = new Driver();
			
			//Step1:register the driver
			DriverManager.registerDriver(driverRef);
		
		//Step2::get connection with DB
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","root");
			
		//Step3: issue create statement
		Statement state = con.createStatement();
		
		//Step 4: execute a query
		int result=state.executeUpdate("insert into customer_info value(16, 'SUPER MAN','Bangkok');");{
		if(result==1)
		{
			System.out.println("Data added");
		}
		}
		//Step 5: close DB
		{
		con.close();
	}
		}
	
		}
	
