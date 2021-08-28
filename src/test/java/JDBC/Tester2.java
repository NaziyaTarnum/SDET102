package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Tester2 {

	public static void main(String[] args) throws Throwable {
		Driver driver=new  Driver();
		//step1: register the driver
		DriverManager.registerDriver(driver);
		//step2: establish the connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
		//step3: issue the statement
		Statement statement = connection.createStatement();
		//step4: execute the query
		ResultSet result = statement.executeQuery("select * from student_info");
		while(result.next())
		{
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
		}
		//step5: close the connection
		connection.close();


	}

}
