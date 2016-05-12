import java.util.ArrayList;

public class UserDB implements DatabaseManager
{

	/*Generate Create User Account Query*/
	public String createUserAccountQuery(String username, String password, String firstName, String lastName, String dob, String accountType, 
			String accountID, String creationDate, String requestDate, String phoneNumber, String email, boolean isApproved) 
	{
		String query = "INSERT INTO USERS VALUES('"+ username + "','"+ password + "','" + firstName + "','" + lastName + "','" + dob + "','" + accountType + "','" +
				accountID + "','" + creationDate+ "','" + requestDate + "','" + phoneNumber + "','" + email + "','"+ isApproved + "')";
		System.out.println(query);
		return query;
	}

	/*Generate Edit User Account Query*/
	public String editUserAccountQuery(String username, String field, String value) 
	{
		String query = "UPDATE USERS SET "+field+" = "+"\""+value+"\" where username = \""+username+"\"";
		System.out.println(query);
		return query;
	}

	/*Generate Delete User Account Query*/
	public String deleteUserAccountQuery(String username) 
	{
		String query = "DELETE FROM USERS WHERE username=\""+username+"\"";
		System.out.println(query);
		return query;
	}

	/*Generate query to output user account data*/
	public String retrieveUserAccountQuery(String username) 
	{
		String query = "SELECT * FROM USERS WHERE username = \""+username+"\"";
		System.out.println(query);
		return query;
	}

	/*Authenticate User*/
	public String authenticateUserQuery(String username) {
		String query = "SELECT * FROM USERS WHERE username = \""+username+"\"";
		System.out.println(query);
		return query;
	}
	
	public String approveUserAccountQuery(String username, String value)
	{
		String query = "UPDATE USERS SET Approved = '" + value + "' where username = '" + username + "'";
		System.out.println(query);
		return query;
	}


	@Override
	public String createProjectQuery(ArrayList<String> project) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteProjectQuery(String pID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String retrieveProjectQuery(ArrayList<String> project, String pID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editProjectQuery(String field, String value, String pID) {
		// TODO Auto-generated method stub
		return null;
	}

}

