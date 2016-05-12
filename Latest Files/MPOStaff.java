import java.util.ArrayList;

public class MPOStaff extends AuthenticatedUser
{

	
	/*Approve Project Submission*/
	
	/*Assign Approved ID*/
	
	/*Archive Project*/
	
	/*Review Project Submission*/
	
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
