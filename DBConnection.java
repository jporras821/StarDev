//STEP 1. Import required packages
import java.sql.*;
import java.util.ArrayList;

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
		Project project = new Project();
		//
		ArrayList<String> newProject = new ArrayList<String>();
		//user.createUserAccount("mporras", "mporras", "Mario", "Porras", "1996-2-5", "MPO Staff", "555", "2014-6-7", "2014-7-6", "5554321", "mporras@gmail.com", false);
		
		newProject = project.createProject("5","10","50","East","true","El Paso","El Paso","El Paso District","2015","Major Arterial",
				"Highway/Roadway","Arterial 1","Pellicano Dr","1 mile south of Pellicano Dr","2016","2", 
				"Project Sponsor paying for PE and/or ROW Costs, if any", "A426X-CAP","Arterial 1", "C", "Additional Lanes", 
				"Amend to add into H13-16 TIP and H15-18 TIP in FY 2015 (simultaneous submittal",  
				"w Cat3-VRF County EP part of 2013 EPC CMPO project from Horizon 2040 MTP Developer List", 
				"County EP","ON_State System Road","2","3");

		//project.storeProject(newProject);
		//project.editProject("ProjectName", "Bike Road", "123");
		project.deleteProject("null"); //Working
	}
}