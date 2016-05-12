import java.util.ArrayList;

public interface DatabaseManager 
{

	/*Generate Create Project Query*/
	String createProjectQuery(ArrayList<String> project);

	/*Generate Edit Project Query*/
	String editProjectQuery(String field, String value, String pID);
	
	/*Generate Delete Project Query*/
	String deleteProjectQuery(String pID);
	
	/*Generate query to output Project Data*/
	public String retrieveProjectQuery(ArrayList<String> project, String pID);

	/*Generate Create User Account Query*/
	String createUserAccountQuery(AuthenticatedUser user);

	/*Generate Edit User Account Query*/
	String editUserAccountQuery(String username, String field, String value);

	/*Generate Delete User Account Query*/
	String deleteUserAccountQuery(String username);

	/*Generate query to output user account data*/
	String retrieveUserAccountQuery(String username);

	/*Approve User Account*/
	String approveUserAccountQuery(String username, String value);
	
	/*Authenticate User Query*/
	String authenticateUserQuery(String username);

	String createSubmittedProjectQuery(ArrayList<String> submittedProject);

	String editSubmittedProjectQuery(String columnName, String newValue, String pID);
	
	String deleteSubmittedProjectQuery(String pID);
	
	String createProposedProjectQuery(ArrayList<String> project);
	
	String editProposedProjectQuery(String columnName, String newValue, String pID);
	
	String deleteProposedProjectQuery(String pID);

	String retrieveProposedProjectQuery(String pID) ;

}
