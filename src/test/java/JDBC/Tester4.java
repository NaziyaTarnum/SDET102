package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Tester4 {

	public static void main(String[] args) throws Throwable {
		Driver driver=new Driver();
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/apply", "root", "root");
		
		Statement statement = connection.createStatement();

	ResultSet result = statement.executeQuery("select * from enquire where regno='1'");

	if(result.next())
	{
		System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3));
		System.out.println("pass");
	}
	else
	{
		System.out.println("fail");
	}
	connection.close();

	}

}
