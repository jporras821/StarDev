import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MPOLeadUser extends AuthenticatedUser
{



	public MPOLeadUser()
	{

	}

	/*Approve Project Submission*/
	/*Review Project Submission*/
	/*Archive Project*/
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
