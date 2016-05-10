//STEP 1. Import required packages
import java.sql.*;

public class DBConnection {


	public Connection connectToDatabase() throws SQLException
	{
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String DB_URL = "jdbc:mysql://earth.cs.utep.edu/cs4311team8sp16";
		String user = "cs4311team8sp16";
		String pass = "team8stardev";
		Connection conn = null;

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL,user,pass);

			if (conn != null)
			{
				System.out.println("Connected to the database");
			}
		} catch (ClassNotFoundException ex)
		{
			System.out.println("Could not find database driver class");
			ex.printStackTrace();
		} catch (SQLException ex)
		{
			System.out.println("An error occurred. Maybe user/password is invalid");
			ex.printStackTrace();
		} 

		return conn;
	}

	public static void main(String[] args) 
	{
		Administrator user = new Administrator();
		user.createUserAccount("mporras", "mporras", "Mario", "Porras", "1996-2-5", "MPO Staff", "555", "2014-6-7", "2014-7-6", "5554321", "mporras@gmail.com", false);
	}
}