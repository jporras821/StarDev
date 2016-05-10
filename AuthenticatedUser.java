import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;

public class AuthenticatedUser extends RegularUser 
{

	LinkedHashMap <String, Object> authenticatedUserInfo = new LinkedHashMap <String, Object>();
	

	
	public AuthenticatedUser(String username, String password, String firstname, String lastname, String dob,
			String accountType, String accountID, String creationDate, String requestDate, String phoneNumber,
			String email, boolean isApproved) {
		authenticatedUserInfo.put("username", username);
		authenticatedUserInfo.put("password", password);
		authenticatedUserInfo.put("firstname", firstname);
		authenticatedUserInfo.put("lastname", lastname);
		authenticatedUserInfo.put("dob", dob);
		authenticatedUserInfo.put("accountType", accountType);
		authenticatedUserInfo.put("accountID", accountID);
		authenticatedUserInfo.put("creationDate", creationDate);
		authenticatedUserInfo.put("requestDate", requestDate);
		authenticatedUserInfo.put("phoneNumber", phoneNumber);
		authenticatedUserInfo.put("email", email);
		authenticatedUserInfo.put("isApproved", isApproved);
		
	}
	
	public AuthenticatedUser()
	{
		
	}

	/* Authenticates User */
	public boolean authenticateUser(String username, String password)
	{
		boolean authenticated = false;
		DBConnection connect = new DBConnection();
		DatabaseManager db = new UserDB();
		Statement stmt = null;
		Connection conn = null; 
		String pass = ""; /*Password retrieved from db*/
		String sql = db.authenticateUserQuery(username);
		
		try 
		{
			conn = connect.connectToDatabase();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				pass = rs.getString("password");
			}

		}catch(SQLException se){
			se.printStackTrace();
		}
		if (pass.equals(password))
		{
			authenticated = true;
		}
		
		return authenticated;
	}
	

	public LinkedHashMap<String, Object> getAuthenticatedUserInfo() {
		return authenticatedUserInfo;
	}

	public void setAuthenticatedUserInfo(LinkedHashMap<String, Object> accountElements) {
		this.authenticatedUserInfo = authenticatedUserInfo;
	}
}
