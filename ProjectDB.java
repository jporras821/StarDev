import java.util.ArrayList;

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
	public String createProjectQuery(ArrayList<String> project) 
	{
		/*String query = "INSERT INTO Project" + "(AirQualityAnalysisCO,AirQualityAnalysisNOX,AirQualityAnalysisVOC,Area,CapacityProject"
				+ "City,County,DOTDistrict,FederalFiscalYear,FederalFunctionalClassification,FundProjectType,HighwayRoadwayName,LimitFrom,LimitTo"
				+ "NetworkYear,NumberofExistingLanes,ProjectDescription,ProjectID,ProjectName,ProjectPhases,ProjectType,Remarks,"
				+ "ScopeofWork,SponsorAgency,StateSystemRoad,NumberofMiles,numberofProjectedLanes)" + "VALUES('"+project.get(0)+"','"+project.get(1)+"','"
						+ project.get(2)+"','"+project.get(3)+"','"+project.get(4)+"','"
						+ project.get(5)+"','"+project.get(6)+"','"+project.get(7)+"','"+project.get(8)+"','"+project.get(9)+"','"+project.get(10)+"','"
						+ project.get(11)+"','"+project.get(12)+"','"+project.get(13)+"','"+project.get(14)+"','"+project.get(15)+"','"+project.get(16)+"','"
						+ project.get(17)+"','"+project.get(18)+"','"+project.get(19)+"','"+project.get(20)+"','"+project.get(21)+"','"+project.get(22)+"','"
						+ project.get(23)+"','"+project.get(24)+"','"+project.get(25)+"','"+project.get(26)+"')";*/
		
		String query = "INSERT INTO Project VALUES('"+project.get(0)+"','"+project.get(1)+"','"
						+ project.get(2)+"','"+project.get(3)+"','"+project.get(4)+"','"
						+ project.get(5)+"','"+project.get(6)+"','"+project.get(7)+"','"+project.get(8)+"','"+project.get(9)+"','"+project.get(10)+"','"
						+ project.get(11)+"','"+project.get(12)+"','"+project.get(13)+"','"+project.get(14)+"','"+project.get(15)+"','"+project.get(16)+"','"
						+ project.get(17)+"','"+project.get(18)+"','"+project.get(19)+"','"+project.get(20)+"','"+project.get(21)+"','"+project.get(22)+"','"
						+ project.get(23)+"','"+project.get(24)+"','"+project.get(25)+"','"+project.get(26)+"')";
		
		return query;
		
		
		/*String query = "INSERT INTO USERS VALUES('"+ airQualityAnalysisCO + "','"+ airQualityAnalysisNOX + "','" + airQualityAnalysisVOC + 
				"','" + area + "','" + capacityProject+ "','" + city + "','" + county + "','" + dotDistrict + "','"+ federalFiscalYear + 
				"','"+ federalFunctionalClassifications + "','"+ fundProjectType + "','"+ highwayRoadwayName + "','"+ limitFrom + "','"
				+ limitTo + "','"+networkYear + "','"+ "','" + numberExistingLanes + "','" + projectDescription + "','"+projectID + 
				"','"+projectName + "','" + projectPhases + "','"+projectType + "','"+remarks + "','" + scopeOfProduct
				+ "','"+sponsorAgency + "','"+stateSystemRoad + "','"+ numberMiles +"','" + numberProjectedLanes + "')";
		System.out.println(query);*/

	}
	

	/*Generate Edit Project Query*/
	public String editProjectQuery(String field, String value, String pID) 
	{
		String query = "UPDATE Project SET "+field+" = "+"\""+value+"\" WHERE ProjectID = \""+pID+"\"";
		System.out.println(query);
		return query;
	}

	/*Generate Delete Project Query*/
	public String deleteProjectQuery(String pID) 
	{
		String query = "DELETE FROM Project WHERE ProjectID = \""+pID+"\"";
		System.out.println(query);
		return query;
	}

	/*Generate query to output Project Data*/
	public String retrieveProjectQuery(ArrayList<String> project,String pID) 
	{
		String query = "SELECT * FROM Project WHERE ProjectID=\""+project.get(17)+"\"";
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
