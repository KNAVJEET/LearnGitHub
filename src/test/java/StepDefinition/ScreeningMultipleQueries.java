package StepDefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.Assert;

import PageObject.DatabaseSelectionPage;
import PageObject.InboxPage;
import PageObject.LoginPage;
import PageObject.QueryPage;
import PageObject.TestBase;
import PageObject.ViewsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ScreeningMultipleQueries extends TestBase {
	
	LoginPage loginPage;
	
	InboxPage inboxPage;
	
	QueryPage queryPage;
	
	DatabaseSelectionPage databaseSelectionPage;
	
	ViewsPage viewsPage;
	
	//ReadPropertyFile readPropertyFile;	
	
	@Given("user is on Login Page")
	public void user_is_on_login_page() {
		
		//loginPage=new LoginPage(driver);
		
		loginPage=new LoginPage();
		
		System.out.println(driver);
		
		queryPage=new QueryPage(driver);
		
		databaseSelectionPage=new DatabaseSelectionPage(driver);
		
		viewsPage=new ViewsPage(driver);
		
		//readPropertyFile=new ReadPropertyFile();
		
		//System.out.println(readPropertyFile.getValue("URL"));
	    
	}
	
	
	@When("User enters valid username and password")
	public void user_enters_valid_username_and_password(DataTable dataTable) {
		
		List<Map<String,String>> list=dataTable.asMaps();
		
		System.out.println(">>>>>>" + list);
		
		System.out.println(list.get(0).get("Username"));
		
		System.out.println(list.get(1).get("Password"));
		
		loginPage.enterUserName(list.get(0).get("Username"));
		
		loginPage.enterPassword(list.get(1).get("Password"));
		
		System.out.println(readPropertyFile.getValue("UserName"));	   
	}
	
	
	@When("Click on Login Button")
	public void click_on_login_button() {
		
		loginPage.submitButton();
	    
	}
	
	
	@Then("User is navigated to Home Page")
	public void user_is_navigated_to_home_page() throws InterruptedException {
		
		inboxPage=new InboxPage(driver);
		
		boolean status=inboxPage.inboxPageLoaded();
		
		System.out.println(">>>>>>" + status);
		
		Assert.assertTrue(status, "Inbox Page Loaded Successfully");
		
		boolean status1=inboxPage.selectSavedScreeningTab("Saved Screenings");
		
		System.out.println(">>>>>>" + status1);
		
		Assert.assertTrue(status1, "Saved Screenings Tab is selected Successfully");
	    
	}
	
	
	@Then("Click on Start New Screening Button")
	public void click_on_start_new_screening_button() {
		
		inboxPage.clickNewScreening();
	    
	}
	
	@Then("User is navigated to Query Page")
	public void user_is_navigated_to_query_page() {
		
		boolean status=queryPage.queryPageLoaded();
		
		System.out.println(status);
	  
	}
	
	
	@Then("Select Trademark and IC Class from dropdown.")
	public void select_trademark_and_ic_class_from_dropdown() {
		
		queryPage.selectFirstDropDown(1,"Trademark - Exact");
		
		queryPage.selectFirstDropDown(2,"International Class");
	    
	}
	
	
	@Then("Enter values in respective textboxes and Execute Standard Query.")
	public void enter_values_in_respective_textboxes_and_execute_standard_query(DataTable dataTable) throws InterruptedException {
		
		
		List<Map<String,String>> list=dataTable.asMaps();
		
		System.out.println(list.size());
		
		System.out.println(list.get(0).get("Trademark"));
		
		System.out.println(list.get(0).get("IC Class"));
		
		for(int i=0;i<list.size();i++)
		{
		
		queryPage.enterTextBox(1, list.get(i).get("Trademark"));
		
		if(list.get(i).get("IC Class")==null)
		{
		
		}
		else
		{
		queryPage.enterTextBox(2, list.get(i).get("IC Class"));
		}
		
		queryPage.clickSubmitQuery();
		
		boolean queryProcessingStatus=queryPage.queryProcessingStatus();
		
		//Assert.assertTrue(queryProcessingStatus, "Query Processed is Successfully");
		
		if(queryProcessingStatus==false)
		{
			boolean status=queryPage.checkWarningPopup();
			
			if(status==false)
			{
				System.out.println("Query Processing stucked due to other reason");
			}
		}
		
		queryPage.clearQuery();
		
		Thread.sleep(5000);
		
		}
	   
	}
	
	
	@Then("Click on Corsearch vantage button.")
	public void click_on_corsearch_vantage_button() {
		
		queryPage.clickVantage();
	   
	}
	
	
	@Then("Switch to Vantage Mode and submit the query.")
	public void switch_to_vantage_mode_and_submit_the_query(DataTable dataTable) throws InterruptedException {
		
        List<Map<String,String>> list=dataTable.asMaps();
		
		System.out.println(list.size());
		
		System.out.println(list.get(0).get("Trademark"));
		
		System.out.println(list.get(0).get("IC Class"));
		
		for(int i=0;i<list.size();i++)
		{
		
		queryPage.enterTextBox(1, list.get(i).get("Trademark"));
		
		queryPage.clickTabButton();
		
		Thread.sleep(2000);
		
		queryPage.enterTextBox(2, list.get(i).get("IC Class"));
		
		Thread.sleep(5000);
		
		queryPage.submitQueryJavaExecutor();
		
		queryPage.queryProcessingStatus();
		
		queryPage.clearQuery();
		
		Thread.sleep(5000);
		
		}
	}
	
	
	@Then("Click on Database Selection button.")
	public void click_on_database_selection_button() {
		
		databaseSelectionPage.clickSelectDatabase();
		
		databaseSelectionPage.databasePageLoaded();
	   
	}
	
	
	@Then("Select Databases.")
	public void select_databases() {
		
		databaseSelectionPage.selectDatabaseTab("Pharma");
		
		databaseSelectionPage.databasePageLoaded();
		
		databaseSelectionPage.selectJurisdiction();
	    
	}
	
	
	@Then("Click on OK button.")
	public void click_on_ok_button() {
		
		databaseSelectionPage.clickOKButton();
	    
	}
	
	
	@Then("User is navigated back to Query Page")
	public void user_is_navigated_back_to_query_page() {
		
        boolean status=queryPage.queryPageLoaded();
		
		System.out.println(status);
	    
	}
	
	
	@Then("User is in Vantage Mode and submit the query.")
	public void user_is_in_vantage_mode_and_submit_the_query(DataTable dataTable) throws InterruptedException {
		
		    List<Map<String,String>> list=dataTable.asMaps();
			
			System.out.println(list.size());
			
			System.out.println(list.get(0).get("Trademark"));
			
			System.out.println(list.get(0).get("IC Class"));
			
			for(int i=0;i<list.size();i++)
			{
			
			queryPage.enterTextBox(1, list.get(i).get("Trademark"));
			
			queryPage.clickTabButton();
			
			Thread.sleep(2000);
			
			queryPage.enterTextBox(2, list.get(i).get("IC Class"));
			
			Thread.sleep(5000);
			
			queryPage.submitQueryJavaExecutor();
			
			queryPage.queryProcessingStatus();
			
			queryPage.clearQuery();
			
			Thread.sleep(5000);
			
			}
	   
	}
	
	
	@Then("Combine the queries.")
	public void combine_the_queries() {
		
		queryPage.combineQueries(2, 4);
		
		queryPage.queryProcessingStatus();
	    
	}
	
	
	@Then("Click on Standard Mode button.")
	public void click_on_standard_mode_button() throws InterruptedException {
		
		queryPage.switchToStandardMaode();
		
        databaseSelectionPage.clickSelectDatabase();
		
		databaseSelectionPage.databasePageLoaded();
		
		Thread.sleep(5000);
		
		databaseSelectionPage.selectMasterCheckBox();
		
		Thread.sleep(5000);
		
		databaseSelectionPage.unselectMasterCheckBox();
		
		Thread.sleep(5000);
		
		databaseSelectionPage.selectDatabaseTab("Trademark");
		
		databaseSelectionPage.databasePageLoaded();
	    
	}
	
	
	@Then("Click on Database Selection button and Execute queries by selecting jurisdictions header under Trademark tab.")
	public void click_on_database_selection_button_and_execute_queries_by_selecting_jurisdictions_header_under_trademark_tab(DataTable dataTable) throws InterruptedException {
	    
		List<Map<String,String>> list=dataTable.asMaps();
		
		System.out.println(list.get(0).get("Jurisdiction Header"));
		
		System.out.println(list.get(1).get("Jurisdiction Header"));
		
		System.out.println(list.size());
		
		for(int i=0;i<list.size();i++)
		{
			databaseSelectionPage.selectJurisdictionHeader(list.get(i).get("Jurisdiction Header"));
			
			Thread.sleep(5000);
			
			databaseSelectionPage.clickOKButton();
			
			boolean status=queryPage.queryPageLoaded();
				
			System.out.println(status);
			
			queryPage.enterTextBox(1, list.get(i).get("Trademark"));
			
			if(list.get(i).get("IC Class")==null)
			{
			
			}
			else
			{
			queryPage.enterTextBox(2, list.get(i).get("IC Class"));
			}
			
			queryPage.clickSubmitQuery();
			
			queryPage.queryProcessingStatus();
			
			queryPage.clearQuery();
			
			Thread.sleep(5000);
			
			databaseSelectionPage.clickSelectDatabase();
			
			databaseSelectionPage.databasePageLoaded();
			
			Thread.sleep(5000);
		}
		
	}
	
	
	@Then("Select Company Names tab and Execute queries by selecting jurisdictions name.")
	public void select_company_names_tab_and_execute_queries_by_selecting_jurisdictions_name(DataTable dataTable) throws InterruptedException {
		
        databaseSelectionPage.selectMasterCheckBox();
		
		Thread.sleep(5000);
		
		databaseSelectionPage.unselectMasterCheckBox();
		
		Thread.sleep(5000);
		
		databaseSelectionPage.selectDatabaseTab("Company Names");
		
		databaseSelectionPage.databasePageLoaded();
		
		List<Map<String,String>> list=dataTable.asMaps();
		
		System.out.println(list.get(0).get("Jurisdiction Name"));
		
		for(int i=0;i<list.size();i++)
		{
			databaseSelectionPage.selectJurisdictionByName(list.get(i).get("Jurisdiction Name"));
			
			Thread.sleep(5000);	
		}
		
		databaseSelectionPage.clickOKButton();
		
		boolean status=queryPage.queryPageLoaded();
			
		System.out.println(status);
		
		queryPage.enterTextBox(1,"coke");
		
		queryPage.enterTextBox(2,"1,2,3,4");
		
		queryPage.clickSubmitQuery();
		
		queryPage.queryProcessingStatus();
		
		queryPage.clearQuery();
		
		Thread.sleep(5000);
	 
	}

	
	@Then("Select Domains tab and Execute queries by selecting jurisdictions header.")
	public void select_domains_tab_and_execute_queries_by_selecting_jurisdictions_header(DataTable dataTable) throws InterruptedException {
		
		databaseSelectionPage.clickSelectDatabase();
		
		databaseSelectionPage.databasePageLoaded();
		
		Thread.sleep(5000);
		
		databaseSelectionPage.selectMasterCheckBox();
			
		Thread.sleep(5000);
			
		databaseSelectionPage.unselectMasterCheckBox();
			
		Thread.sleep(5000);
			
		databaseSelectionPage.selectDatabaseTab("Domains");
			
		databaseSelectionPage.databasePageLoaded();
		
		Thread.sleep(5000);
		
		List<Map<String,String>> list=dataTable.asMaps();
		
		for(int i=0;i<list.size();i++)
		{
			//databaseSelectionPage.selectJurisdictionHeader(list.get(i).get("Jurisdiction Header"));
			
			databaseSelectionPage.selectJurisdictionHeaderExpand(list.get(i).get("Jurisdiction Header"));
			
			Thread.sleep(5000);
			
			databaseSelectionPage.clickOKButton();
			
			boolean status=queryPage.queryPageLoaded();
				
			System.out.println(status);
			
			queryPage.enterTextBox(1, list.get(i).get("Trademark"));
			
			queryPage.clickSubmitQuery();
			
			queryPage.queryProcessingStatus();
			
			queryPage.clearQuery();
			
			Thread.sleep(5000);
			
			databaseSelectionPage.clickSelectDatabase();
			
			databaseSelectionPage.databasePageLoaded();
			
			Thread.sleep(5000);
		}
	 
	}
	
	
	@Then("Select Specialty Databases tab and Execute queries by selecting jurisdictions name.")
	public void select_specialty_databases_tab_and_execute_queries_by_selecting_jurisdictions_name(DataTable dataTable) throws InterruptedException {
		
        databaseSelectionPage.selectMasterCheckBox();
		
		Thread.sleep(5000);
		
		databaseSelectionPage.unselectMasterCheckBox();
		
		Thread.sleep(5000);
		
		databaseSelectionPage.selectDatabaseTab("Specialty Databases");
		
		databaseSelectionPage.databasePageLoaded();
		
		List<Map<String,String>> list=dataTable.asMaps();
		
		System.out.println(list.get(0).get("Jurisdiction Name"));
		
		for(int i=0;i<list.size();i++)
		{
			databaseSelectionPage.selectJurisdictionByName(list.get(i).get("Jurisdiction Name"));
			
			Thread.sleep(5000);	
		}
		
		databaseSelectionPage.clickOKButton();
		
		boolean status=queryPage.queryPageLoaded();
			
		System.out.println(status);
		
		queryPage.enterTextBox(1,"Pepsi");
		
		queryPage.enterTextBox(2,"1,2,3,4");
		
		queryPage.clickSubmitQuery();
		
		queryPage.queryProcessingStatus();
		
		queryPage.clearQuery();
		
		Thread.sleep(5000);
	}
	
	@Then("Click on View button and Default view is loaded.")
	public void click_on_view_button_and_default_view_is_loaded() throws InterruptedException {
	    
		queryPage.queryViewButtonStatus();
		
		viewsPage.loadView();
		
		
		//Thread.sleep(10000);
		
		viewsPage.navigateViews();
		
	}


}
