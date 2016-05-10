public interface DatabaseManager 
{

	/*Generate Create Project Query*/

	/*Generate Edit Project Query*/

	/*Generate Delete Project Query*/

	/*Generate query to output Project Data*/

	/*Store project on external database*/


	/*Generate Create User Account Query*/
	String createUserAccountQuery(String username, String password, String firstName, String lastName, String dob, String accountType, 
			String accountID, String creationDate, String requestDate, String phoneNumber, String email, boolean isApproved);

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

}
