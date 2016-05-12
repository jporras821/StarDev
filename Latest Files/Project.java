import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Project{
	
	ArrayList<String> project = new ArrayList<String>();
		
	String airQualityAnalysisCO;
	String airQualityAnalysisNOX;
	String airQualityAnalysisVOC;
	String area; 
	String capacityProject;
	String city;
	String county;
	String dotDistrict; 
	String federalFiscalYear;
	String federalFunctionalClassifications;
	String fundProjectType;
	String highwayRoadwayName;
	String limitFrom;
	String limitTo;
	String networkYear;
	String numberExistingLanes;
	String projectDescription;
	String projectID;
	String projectName;
	String projectPhases;
	String projectType;
	String remarks;
	String scopeOfProduct;
	String sponsorAgency; 
	String stateSystemRoad; 
	String numberMiles;
	String numberProjectedLanes;
	
	public ArrayList<String> createProject(String airQualityAnalysisCO,String airQualityAnalysisNOX,String airQualityAnalysisVOC,
			String area, String capacityProject, String city, String county, String dotDistrict, String federalFiscalYear, 
			String federalFunctionalClassifications,String fundProjectType,String highwayRoadwayName, String limitFrom, 
			String limitTo, String networkYear, String numberExistingLanes, String projectDescription, String projectID,
			String projectName, String projectPhases, String projectType, String remarks,  String scopeOfProduct, 
			String sponsorAgency, String stateSystemRoad, String numberMiles, String numberProjectedLanes)
	{
		
		setAirQualityAnalysisCO(airQualityAnalysisCO);
		setAirQualityAnalysisNOX(airQualityAnalysisNOX);
		setAirQualityAnalysisVOC(airQualityAnalysisVOC);
		setArea(area);
		setCapacityProject(capacityProject);
		setCity(city);
		setCounty(county);
		setDotDistrict(dotDistrict);
		setFederalFiscalYear(federalFiscalYear);
		setFederalFunctionalClassifications(federalFunctionalClassifications);
		setFundProjectType(fundProjectType);
		setHighwayRoadwayName(highwayRoadwayName);
		setLimitFrom(limitFrom);
		setLimitTo(limitTo);
		setNetWorkYear(networkYear);
		setNumberOfExistingLanes(numberExistingLanes);
		setProjectDescription(projectDescription);
		setProjectID(projectID);
		setProjectName(projectName);
		setProjectPhases(projectPhases);
		setProjectType(projectType);
		setRemarks(remarks);
		setScopeOfProduct(scopeOfProduct);
		setSponsorAgency(sponsorAgency);
		setStateSystemRoad(stateSystemRoad);
		setNumberMiles(numberMiles);
		setNumberProjectedLanes(numberProjectedLanes);
		
		
		String co = getAirQualityAnalysisCO();
		String nox = getAirQualityAnalysisNOX();
		String voc =getAirQualityAnalysisVOC();
		String a = getArea();
		String cp = getCapacityProject();
		String ci = getCity();
		String cou = getCounty();
		String dot = getDotDistrict();
		String ffy = getFederalFiscalYear();
		String ffc = getFederalFunctionalClassifications();
		String fpt = getFundProjectType();
		String hr = getHighwayRoadwayName();
		String lf = getLimitFrom();
		String lt =getLimitTo();
		String ny = getNetWorkYear();
		String nel = getNumberOfExistingLanes();
		String pd = getProjectDescription();
		String pID = getProjectID();
		String pn = getProjectName();
		String pp = getProjectPhases();
		String pt = getProjectType();
		String rem = getRemarks();
		String sp = getScopeOfProduct();
		String sa = getSponsorAgency();
		String ssr = getStateSystemRoad();
		String nm = getNumberMiles();
		String npl = getNumberProjectedLanes();
		
		project.add(co);	//0
		project.add(nox);	//1
		project.add(voc);	//2
		project.add(a);		//3
		project.add(cp);	//4
		project.add(ci);	//5
		project.add(cou);	//6
		project.add(dot);	//7
		project.add(ffy);	//8
		project.add(ffc);	//9
		project.add(fpt);	//10
		project.add(hr);	//11
		project.add(lf);	//12
		project.add(lt);	//13
		project.add(ny);	//14
		project.add(nel);	//15
		project.add(pd);	//16
		project.add(pID);	//17
		project.add(pn);	//18
		project.add(pp);	//19
		project.add(pt);	//20
		project.add(rem);	//21
		project.add(sp);	//22
		project.add(sa);	//23
		project.add(ssr);	//24
		project.add(nm);	//25
		project.add(npl);	//26
		
		return project;	
	}
	
	public boolean storeProject(ArrayList<String> project)
	{
		DBConnection connect = new DBConnection();
		DatabaseManager db = new ProjectDB();
		Statement stmt = null;
		String pid = "";
		Connection connection = null; 
		String sql = db.createProjectQuery(project);
		boolean storeProject = false;
		
		try 
		{
			connection = connect.connectToDatabase();
			stmt = connection.createStatement();
			stmt.executeUpdate(sql);


		}catch(SQLException se){
			se.printStackTrace();
		}
		
		if (pid.equals(project.get(17)))
		{
			storeProject = true;
			System.out.println("This project ID# already exists");
			
		}

		else
		{
			storeProject = false;
			System.out.println("Project was stored successfully!");
		}
		
		return storeProject;
	}
				
	
	public boolean editProject(String field, String value, String pID){
		
		DBConnection connect = new DBConnection();
		DatabaseManager db = new ProjectDB();
		Statement stmt = null;
		Connection conn = null; 
		boolean success = false;
		String sql = db.editProjectQuery(field, value, pID);
		
		try 
		{
			conn = connect.connectToDatabase();
			stmt = conn.createStatement();
			int rs = stmt.executeUpdate(sql);
			if (rs == 0)
			{
				success = false;
				System.out.println("Project WAS NOT updated");
				
			}

			else
			{
				success = true;
				System.out.println("The project WAS updated SUCCESSFULLY");
			}
			
		}catch(SQLException se){
			se.printStackTrace();
		}
		
		return success;
	}
	
	public boolean deleteProject(String pID)
	{
		DBConnection connect = new DBConnection();
		DatabaseManager db = new ProjectDB();
		Statement stmt = null;
		Connection conn = null; 
		//String pjID = "";
		boolean deleteProject = false;
		String sql = db.deleteProjectQuery(pID);
		
		try 
		{
			conn = connect.connectToDatabase();
			stmt = conn.createStatement();
			int rs = stmt.executeUpdate(sql);
			if (rs == 0)
			{
				deleteProject = false;
				System.out.println("Project WAS NOT deleted");
				
			}

			else
			{
				deleteProject = true;
				System.out.println("The project WAS deleted");
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
				
		return deleteProject;
	}
	
	public void setAirQualityAnalysisCO(String airQualityAnalysisCO)
	{
		this.airQualityAnalysisCO = airQualityAnalysisCO;
	}
	
	public void setAirQualityAnalysisNOX(String airQualityAnalysisNOX)
	{
		this.airQualityAnalysisNOX = airQualityAnalysisNOX;
	}
	
	public void setAirQualityAnalysisVOC(String airQualityAnalysisVOC)
	{
		this.airQualityAnalysisVOC = airQualityAnalysisVOC;
	}
	
	public void setArea(String area)
	{
		this.area = area;
	}
	
	public void setCapacityProject(String capacityProject)
	{
		this.capacityProject = capacityProject;
	}
	
	public void setCity(String city)
	{
		this.city = city;
	}
	
	public void setCounty(String county)
	{
		this.county = county;
	}
	
	public void setDotDistrict(String dotDistrict)
	{
		this.dotDistrict = dotDistrict;
	}
	
	public void setFederalFiscalYear(String federalFiscalYear)
	{
		this.federalFiscalYear = federalFiscalYear;
	}
	
	public void setFederalFunctionalClassifications(String federalFunctionalClassifications)
	{
		this.federalFunctionalClassifications = federalFunctionalClassifications;
	}
	
	public void setFundProjectType(String fundProjectType)
	{
		this.fundProjectType = fundProjectType;
	}
	
	public void setHighwayRoadwayName(String highwayRoadwayName)
	{
		this.highwayRoadwayName = highwayRoadwayName;
	}
	
	public void setLimitFrom(String limitFrom)
	{
		this.limitFrom = limitFrom;
	}
	
	public void setLimitTo(String limitTo)
	{
		this.limitTo = limitTo;
	}
	
	public void setNetWorkYear(String networkYear)
	{
		this.networkYear = networkYear;
	}
	
	public void setNumberOfExistingLanes(String numberExistingLanes)
	{
		this.numberExistingLanes = numberExistingLanes;
	}
	
	public void setProjectDescription(String projectDescription)
	{
		this.projectDescription = projectDescription;
	}
	
	public void setProjectID(String projectID)
	{
		this.projectID = projectID;
	}
	
	public void setProjectName(String projectName)
	{
		this.projectName = projectName;
	}
	
	public void setProjectPhases(String projectPhases)
	{
		this.projectPhases = projectPhases;
	}
	
	public void setProjectType(String projectType)
	{
		this.projectType = projectType;
	}
	
	public void setRemarks(String remarks)
	{
		this.remarks = remarks;
	}
	
	public void setScopeOfProduct(String scopeOfProduct)
	{
		this.scopeOfProduct = scopeOfProduct;
	}
	
	public void setSponsorAgency(String sponsorAgency)
	{
		this.sponsorAgency = sponsorAgency;
	}
	
	public void setStateSystemRoad(String stateSystemRoad)
	{
		this.stateSystemRoad = stateSystemRoad;
	}
	
	public void setNumberMiles(String numberMiles)
	{
		this.numberMiles = numberMiles;
	}
	
	public void setNumberProjectedLanes(String numberProjectedLanes)
	{
		this.numberProjectedLanes = numberProjectedLanes;
	}
	
	public String getAirQualityAnalysisCO()
	{
		return airQualityAnalysisCO;
	}
	
	public String getAirQualityAnalysisNOX()
	{
		return airQualityAnalysisNOX;
	}
	
	public String getAirQualityAnalysisVOC()
	{
		return airQualityAnalysisVOC;
	}
	
	public String getArea()
	{
		return area;
	}
	
	public String getCapacityProject()
	{
		return capacityProject;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public String getCounty()
	{
		return county;
	}
	
	public String getDotDistrict()
	{
		return dotDistrict;
	}
	
	public String getFederalFiscalYear()
	{
		return federalFiscalYear;
	}
	
	public String getFederalFunctionalClassifications()
	{
		return federalFunctionalClassifications;
	}
	
	public String getFundProjectType()
	{
		return fundProjectType;
	}
	
	public String getHighwayRoadwayName()
	{
		return highwayRoadwayName;
	}
	
	public String getLimitFrom()
	{
		return limitFrom;
	}
	
	public String getLimitTo()
	{
		return limitTo;
	}
	
	public String getNetWorkYear()
	{
		return networkYear;
	}
	
	public String getNumberOfExistingLanes()
	{
		return numberExistingLanes;
	}
	
	public String getProjectDescription()
	{
		return projectDescription;
	}
	
	public String getProjectID()
	{
		return projectID;
	}
	
	public String getProjectName()
	{
		return projectName;
	}
	
	public String getProjectPhases()
	{
		return projectPhases;
	}
	
	public String getProjectType()
	{
		return projectType;
	}
	
	public String getRemarks()
	{
		return remarks;
	}
	
	public String getScopeOfProduct()
	{
		return scopeOfProduct;
	}
	
	public String getSponsorAgency()
	{
		return sponsorAgency;
	}
	
	public String getStateSystemRoad()
	{
		return stateSystemRoad;
	}
	
	public String getNumberMiles()
	{
		return numberMiles;
	}
	
	public String getNumberProjectedLanes()
	{
		return numberProjectedLanes;
	}

}