import java.util.ArrayList;

public class UserDB implements DatabaseManager
{

	/*Generate Create User Account Query*/
	public String createUserAccountQuery(AuthenticatedUser user) 
	{
		AuthenticatedUser newUser = user;
		String query = "INSERT INTO USERS VALUES('"+ newUser.getUsername() + "','"+ 
	newUser.getPassword() + "','" + newUser.getFirstname() + "','" + 
	newUser.getLastname() + "','" + newUser.getDob() + "','" + 
	newUser.getAccountType() + "','" + newUser.getAccountID() + "','" + 
	newUser.getCreationDate()+ "','" + newUser.getRequestDate() + "','" + 
				newUser.getPhoneNumber() + "','" + newUser.getEmail() + "','"+ 
				newUser.isApproved() + "')";
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

	@Override
	public String createSubmittedProjectQuery(ArrayList<String> submittedProject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editSubmittedProjectQuery(String columnName, String newValue, String pID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteSubmittedProjectQuery(String pID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createProposedProjectQuery(ArrayList<String> project) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editProposedProjectQuery(String columnName, String newValue, String pID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteProposedProjectQuery(String pID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String retrieveProposedProjectQuery(String pID) {
		// TODO Auto-generated method stub
		return null;
	}

	public String viewProject(String pID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String reviewProjectSubmissionQuery(String pID) {
		// TODO Auto-generated method stub
		return null;
	}

}

