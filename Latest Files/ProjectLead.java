import java.util.ArrayList;

public class ProjectLead extends AuthenticatedUser 
{

	
	public ProjectLead()
	{
		
	}

	/*Create Project Submission*/

	public boolean createSubmittedProject(String tpbApproval,String federalApproval,String stateApproval,
													String submissionStatus,String projectID)
	{
		ArrayList<String> newProject = new ArrayList<String>();
		SubmittedProject project = new SubmittedProject();
		newProject = project.createSubmittedProject(tpbApproval,federalApproval,stateApproval,submissionStatus,projectID);
		boolean isCreated = project.storeProjectSubmission(newProject);
		
		return isCreated;
	
	}
	
	/*Edit Project Submission*/
	public boolean editSubmittedProject(String columnName, String newValue, String pID)
	{
		boolean isUpdated;
		SubmittedProject project = new SubmittedProject();
		isUpdated = project.editSubmittedProject(columnName, newValue, pID);
		
		return isUpdated;
	}
	
	/*Delete Project Submission*/
	public boolean deleteSubmittedProject(String pID)
	{
		boolean isDeleted;
		SubmittedProject project = new SubmittedProject();
		isDeleted = project.deleteSubmittedProject(pID);
		
		return isDeleted;
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
		newProject = project.createProject(airQualityAnalysisCO, airQualityAnalysisNOX, airQualityAnalysisVOC,
				area, capacityProject,  city,  county, dotDistrict, federalFiscalYear, 
				federalFunctionalClassifications, fundProjectType, highwayRoadwayName, limitFrom, 
				limitTo, networkYear, numberExistingLanes, projectDescription, projectID,
				projectName, projectPhases, projectType, remarks, scopeOfProduct, 
				sponsorAgency, stateSystemRoad, numberMiles, numberProjectedLanes);
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
