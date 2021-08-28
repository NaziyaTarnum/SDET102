package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Tester3 {

	public static void main(String[] args) throws Exception {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/apply", "root", "root");
		
	Statement statement = connection.createStatement();
	int result = statement.executeUpdate("insert into enquire values('3','applied','2346')");
	if(result==1)
	{
		System.out.println("pass::");
	}else
	{
		System.out.println("fail::");
	}
	connection.close();

	}

}
