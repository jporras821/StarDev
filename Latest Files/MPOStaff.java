import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSetMetaData;

public class MPOStaff extends AuthenticatedUser
{

	/*Assign Approved ID*/
	

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

	/*Create Project*/
	public boolean createProject(String airQualityAnalysisCO,String airQualityAnalysisNOX,String airQualityAnalysisVOC,
			String area, String capacityProject, String city, String county, String dotDistrict, String federalFiscalYear, 
			String federalFunctionalClassifications,String fundProjectType,String highwayRoadwayName, String limitFrom, 
			String limitTo, String networkYear, String numberExistingLanes, String projectDescription, String projectID,
			String projectName, String projectPhases, String projectType, String remarks,  String scopeOfProduct, 
			String sponsorAgency, String stateSystemRoad, String numberMiles, String numberProjectedLanes)
	{

		ArrayList<String> newProject = new ArrayList<String>();
		Project project = new Project();
		newProject = project.createProject("5","10","50","East","true","El Paso","El Paso","El Paso District","2015","Major Arterial",
				"Highway/Roadway","Arterial 1","Pellicano Dr","1 mile south of Pellicano Dr","2016","2", 
				"Project Sponsor paying for PE and/or ROW Costs, if any", "A426X-CAP","Arterial 1", "C", "Additional Lanes", 
				"Amend to add into H13-16 TIP and H15-18 TIP in FY 2015 (simultaneous submittal",  
				"w Cat3-VRF County EP part of 2013 EPC CMPO project from Horizon 2040 MTP Developer List", 
				"County EP","ON_State System Road","2","3");
		boolean isCreated = project.storeProject(newProject);

		return isCreated;
	}

	/*Edit Project*/
	public boolean editProject(String field, String value, String pID)
	{
		boolean isUpdated;
		Project project = new Project();
		isUpdated = project.editProject(field, value, pID);

		return isUpdated;
	}

	/*Delete Project*/
	public boolean deleteProject(String pID)
	{
		boolean isDeleted;
		Project project = new Project();
		isDeleted = project.deleteProject(pID);

		return isDeleted;
	}

}
