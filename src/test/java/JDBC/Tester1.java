package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class Tester1 {

	public static void main(String[] args)throws Throwable {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
		
		Statement statement = connection.createStatement();
		int result = statement.executeUpdate("insert into student_info values('9','ram','r','m')");
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
connection.close();
	}



}
