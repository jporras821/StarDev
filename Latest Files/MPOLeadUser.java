
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.ResultSetMetaData;

public class MPOLeadUser extends AuthenticatedUser
{

	public MPOLeadUser()
	{

	}

	/*Archive Project*/

	/*Approve Project Submission*/
	public boolean approveSubmittedProject(String columnName, String newValue, String pID)
	{
		boolean isUpdated;
		SubmittedProject project = new SubmittedProject();
		isUpdated = project.editSubmittedProject(columnName, newValue, pID);

		return isUpdated;
	}

	/*Review Project Submission*/
	public void reviewProjectSubmission(String pID)
	{
		DBConnection connect = new DBConnection();
		DatabaseManager db = new ProjectDB();
		Statement stmt = null;
		Connection conn = null; 
		String query = db.reviewProjectSubmissionQuery(pID);

		try 
		{
			conn = connect.connectToDatabase();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			ResultSetMetaData rsmd = (ResultSetMetaData)rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			while (rs.next()) 
			{
				for (int i = 1; i <= columnsNumber; i++) 
				{
					if (i > 1);
					String columnValue = rs.getString(i);
					System.out.print(rsmd.getColumnName(i) + ": " + columnValue + "\n");
				}
			}
		}catch(SQLException se)
		{
			se.printStackTrace();
		}
	}

	/*Approve User Account Request*/
	public boolean approveUserAccountRequest(String username, String value)
	{
		boolean approveUserAccount = false;
		DBConnection connect = new DBConnection();
		DatabaseManager db = new UserDB();
		Statement stmt = null;
		Connection conn = null; 
		String query = db.approveUserAccountQuery(username, value);

		try 
		{
			conn = connect.connectToDatabase();
			stmt = conn.createStatement();
			int rs = stmt.executeUpdate(query);
			if(rs==0)
			{
				approveUserAccount = false;
			}
			else
			{
				approveUserAccount = true;
			}

		}catch(SQLException se){
			se.printStackTrace();
		}

		return approveUserAccount;
	}


}
