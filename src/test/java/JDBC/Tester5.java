package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Tester5 {

	public static void main(String[] args)throws Throwable {
		Connection connection=null;
		try {
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");

Statement statement = connection.createStatement();
int result = statement.executeUpdate("insert student_info values('6','rani','mm','dd')");
if(result==1) {
	System.out.println("data is added in database");
}else
{
	System.out.println("data is not added");
	
}
int result1 = statement.executeUpdate("delete from student_info where regno='9'");
if(result1==1) {
	System.out.println("data is delete in database");
}else
{
	System.out.println("data is not delete");
	
}
		}
		catch(Exception e) {
		}
		
		finally {
			connection.close();
		}

	}

}
