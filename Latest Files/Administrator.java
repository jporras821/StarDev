import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Administrator extends AuthenticatedUser 
{

	
	public Administrator()
	{
		
	}

	/*Create User Account*/
	public boolean createUserAccount(String username, String password, String firstName, String lastName, String dob, String accountType, 
			String accountID, String creationDate, String requestDate, String phoneNumber, String email, boolean isApproved)
	{
		boolean createUserAccount = false;
		DBConnection connect = new DBConnection();
		DatabaseManager db = new UserDB();
		Statement stmt = null;
		Connection conn = null; 
		String uname = ""; /*Username retrieved from db*/
		String query = db.authenticateUserQuery(username);
		String sql;
		try 
		{
			conn = connect.connectToDatabase();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next())
			{
				uname = rs.getString("username");
				System.out.println(uname);
			}
			if (uname.equals(username))
			{
				/*Don't create user*/
				createUserAccount = false;
			}else
			{
				AuthenticatedUser user = new AuthenticatedUser(username, password, firstName, lastName, dob, 
						accountType, accountID, creationDate, requestDate, phoneNumber, email, isApproved);
				 sql = db.createUserAccountQuery(user);
				stmt.executeUpdate(sql);
				createUserAccount = true;
			}

		}catch(SQLException se){
			se.printStackTrace();
		}

		return createUserAccount;
	}

	/*Edit User Account*/
	public boolean editUserAccount(String username, String field, String value) 
	{
		boolean editUserAccount = false;
		DBConnection connect = new DBConnection();
		DatabaseManager db = new UserDB();
		Statement stmt = null;
		Connection conn = null; 
		String query = db.editUserAccountQuery(username, field, value);

		try 
		{
			conn = connect.connectToDatabase();
			stmt = conn.createStatement();
			int rs = stmt.executeUpdate(query);
			if(rs==0)
			{
				editUserAccount = false;
			}
			else
			{
				editUserAccount = true;
			}

		}catch(SQLException se){
			se.printStackTrace();
		}

		return editUserAccount;
	}

	/*Delete User Account*/
	public boolean deleteUserAccountQuery(String username)
	{
		boolean deleteUserAccount = false;
		DBConnection connect = new DBConnection();
		DatabaseManager db = new UserDB();
		Statement stmt = null;
		Connection conn = null; 
		String query = db.deleteUserAccountQuery(username);

		try 
		{
			conn = connect.connectToDatabase();
			stmt = conn.createStatement();
			int rs = stmt.executeUpdate(query);
			if(rs==0)
			{
				deleteUserAccount = false;
			}
			else
			{
				deleteUserAccount = true;
			}

		}catch(SQLException se){
			se.printStackTrace();
		}

		return deleteUserAccount;
	}
}
