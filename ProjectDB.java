
public class ProjectDB implements DatabaseManager
{


	@Override
	public String editUserAccountQuery(String username, String field, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUserAccountQuery(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String retrieveUserAccountQuery(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	/*Authenticate User*/
	public String authenticateUserQuery(String username) {

		return null;
	}

	@Override
	public String approveUserAccountQuery(String username, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createUserAccountQuery(String username, String password, String firstName, String lastName,
			String dob, String accountType, String accountID, String creationDate, String requestDate,
			String phoneNumber, String email, boolean isApproved) {
		// TODO Auto-generated method stub
		return null;
	}

	/*Generate Create Project Query*/
	public String createProjectQuery(long airQualityAnalysisCO,long airQualityAnalysisNOX,long airQualityAnalysisVOC,
			String area, boolean capacityProject, String city, String county, String dotDistrict, int federalFiscalYear, 
			String federalFunctionalClassifications,String fundProjectType,String highwayRoadwayName, String limitFrom, 
			String limitTo, int networkYear, int numberExistingLanes, String projectDescription, String projectID,
			String projectName, String projectPhases, String projectType, String remarks,  String scopeOfProduct, 
			String sponsorAgency, String stateSystemRoad, long numberMiles, int numberProjectedLanes
			) 
	{
		String query = "INSERT INTO USERS VALUES('"+ airQualityAnalysisCO + "','"+ airQualityAnalysisNOX + "','" + airQualityAnalysisVOC + 
				"','" + area + "','" + capacityProject+ "','" + city + "','" + county + "','" + dotDistrict + "','"+ federalFiscalYear + 
				"','"+ federalFunctionalClassifications + "','"+ fundProjectType + "','"+ highwayRoadwayName + "','"+ limitFrom + "','"
				+ limitTo + "','"+networkYear + "','"+ "','" + numberExistingLanes + "','" + projectDescription + "','"+projectID + 
				"','"+projectName + "','" + projectPhases + "','"+projectType + "','"+remarks + "','" + scopeOfProduct
				+ "','"+sponsorAgency + "','"+stateSystemRoad + "','"+ numberMiles +"','" + numberProjectedLanes + "')";
		System.out.println(query);
		return query;
	}

	/*Generate Edit Project Query*/
	public String editProjectQuery(String username, String field, String value) 
	{
		String query = "UPDATE Project SET "+field+" = "+"\""+value+"\" where username = \""+username+"\"";
		System.out.println(query);
		return query;
	}

	/*Generate Delete Project Query*/
	public String deleteProjectQuery(String username) 
	{
		String query = "DELETE FROM Project WHERE username=\""+username+"\"";
		System.out.println(query);
		return query;
	}

	/*Generate query to output Project Data*/
	public String retrieveProjectQuery(String username) 
	{
		String query = "SELECT * FROM Project WHERE username=\""+username+"\"";
		System.out.println(query);
		return query;
	}

	/*Store project on external database*/

	/*Create Project Submission*/
	/*Edit Project Submission*/
	public String editSubmittedProjectQuery(String username, String field, String value) 
	{
		String query = "UPDATE SubmittedProject SET "+field+" = "+"\""+value+"\" where username = \""+username+"\"";
		System.out.println(query);
		return query;
	}

	/*Delete Project Submission*/
	public String deleteSubmittedProjectQuery(String username) 
	{
		String query = "DELETE FROM SubmittedProject WHERE username=\""+username+"\"";
		System.out.println(query);
		return query;
	}

	/*Approve Project Submission*/
	/*Assign Approved ID*/

	/*Review Project Submission*/
	public String retrieveSubmittedProjectQuery(String username) 
	{
		String query = "SELECT * FROM SubmittedProject WHERE username=\""+username+"\"";
		System.out.println(query);
		return query;
	}

}
