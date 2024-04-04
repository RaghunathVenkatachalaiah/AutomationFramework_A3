package pratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SampleJDBCEecuteQuery {

public static void main(String[] args) throws SQLException {
	
	Driver driverRef = new Driver();
	
	//Step1:register the driver
	DriverManager.registerDriver(driverRef);
	
	//Step2::get connection with DB
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/m4db","root","root");
		
	//Step3: issue create statement
	Statement state = con.createStatement();
	
	//Step 4: execute a query
	ResultSet result=state.executeQuery("select * from customer_info;");
	
	while(result.next())
	{
		System.out.println(result.getInt(1)+"-"+result.getString(2)+"-"+result.getString(3));
	}
	
	//Step 5: close DB
	con.close();
	
	
}
}