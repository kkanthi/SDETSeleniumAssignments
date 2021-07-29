package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.DriverObject;

public class LoginPage {
	
	static WebDriver driver;
	static {
		driver = DriverObject.getDriver();
		PageFactory.initElements(driver, LoginPage.class);
	}
	
	//This is for username field
	@FindBy(how=How.ID,using="txtUsername")	
	WebElement txtUsername;
	
	//This is for pwd field
	@FindBy(how=How.ID,using="txtPassword")	
	WebElement txtPassword;

	//This is for login button
	@FindBy(how=How.ID,using="btnLogin")	
	WebElement btnLogin;
	
	
	
	//This is for forgot pwd link
	@FindBy(how=How.PARTIAL_LINK_TEXT,using="Forgot your password?")	
	WebElement forgotPasswordLink;
	
	//This is for pwd field
	@FindBy(how=How.XPATH,using="//img[@src='/webres_6051af48107ce6.31500353/themes/default/images/login/logo.png']")	
	WebElement loginpage_logo;
	
	//This is for pwd field
	@FindBy(how=How.XPATH,using="//span[contains(text(),'( Username : Admin | Password : admin123 )')]")	
	WebElement loginCredentials;
	
	public void enterUserName(String text){
		txtUsername.sendKeys(text);
	}
	public void enterpwd(String text){
		txtPassword.sendKeys(text);
	}
	public void clickloginbtn(){
		btnLogin.click();
	}
	


	public boolean gettextforUserName() {
		return txtUsername.isDisplayed();
	}

	public boolean getTextforPassword() {
		return txtPassword.isDisplayed();
	}

	public boolean getStaySignedInSelected() {
	    return btnLogin.isSelected();
	}
	
	@FindAll(@FindBy(xpath="//*[contains(@href,'.com/')]"))
	@CacheLookup
	List<WebElement> AllLinks;

	public List<WebElement> getAllLinks() {

	return AllLinks;
	}
	
	@FindAll(@FindBy(xpath="//*[contains(@src,'.png')]"))
	@CacheLookup
	List<WebElement> allImages;

	public List<WebElement> getAllImages() {

	return allImages;
	}
	
	@FindAll(@FindBy(xpath="//*[contains(@class,'textInputContainer')]"))
	@CacheLookup
	List<WebElement> alltexBox;

	public List<WebElement> getAllTextbox() {

	return alltexBox;
	}		
	@FindBy(id="content")
	@CacheLookup
	WebElement DashBoardCheck;
	
	public boolean getDashBoardisplayed() {
	    return DashBoardCheck.isDisplayed();
	}
	
	@FindBy(id="menu_admin_viewAdminModule")
	@CacheLookup
	WebElement AdminMenu;
	
	public void settoAdminMenu() {
		AdminMenu.click();
	}

	public boolean gettoAdminMenuSelected() {
	    return AdminMenu.isSelected();
	}
	@FindAll(@FindBy(xpath="//*[contains(@class,'arrow')]"))
	@CacheLookup
	List<WebElement> allItems_AdminMenu;

	public List<WebElement> getAllItems_AdminMenu() {

	return allItems_AdminMenu;
	}	
	@FindBy(xpath="/html/body/div[1]/div[2]/ul/li[1]/ul/li[2]/a")
	@CacheLookup
	WebElement JobMenu;
	
	public void settoJobMenu() {
		Actions action = new Actions(driver);
		action.moveToElement(JobMenu).build().perform();
		JobMenu.click();
		//AdminMenu.click();
	}

	public boolean gettoJobMenuSelected() {
	    return JobMenu.isSelected();
	}
	
	@FindBy(xpath="/html/body/div[1]/div[2]/ul/li[1]/ul/li[2]/ul/li[1]/a")
	@CacheLookup
	WebElement JobTitle;
	
	public String settoJobTitle() {
		String text;
		JobTitle.click();
		text = JobMenu.getText();;
		return text;
	}

	/*public String gettoJobTitleSelected() {
		
	    return JobMenu.getText();
	    System.out.println(JobMenu.getText());
	    
	}*/
	@FindBy(id="frmList_ohrmListComponent")
	@CacheLookup
	WebElement JobTitleList;
	
	public void getJobTitle() {
		
		System.out.println(JobTitleList.getText());
	}
	
	@FindBy(xpath="/html/body/div[1]/div[2]/ul/li[5]/a/b")
	@CacheLookup
	WebElement Recruitment;
	
	public void settoRecruitment() {
		
		//Actions action = new Actions(Driver);
		//action.moveToElement(JobMenu).build().perform();
		Recruitment.click();
	}
	
	@FindBy(id="menu_recruitment_viewJobVacancy")
	@CacheLookup
	WebElement Vacancy;
	
	public void settoVacancies() {
		
		Actions action = new Actions(driver);
		action.moveToElement(Vacancy).build().perform();
		Vacancy.click();
	}
	
	@FindBy(xpath = "/html/body/div[1]/div[3]/div[1]/div[2]/form/fieldset/p/input[1]")
	@CacheLookup
	WebElement PimSearch;
	
	public void setPIMSearch() {
		PimSearch.click();
	}
	
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/ul/li[2]/a/b")
	@CacheLookup
	WebElement Pim;
	
	public void setPIM() {
		Pim.click();
	}
	
	@FindBy(name="empsearch[employee_name][empName]")
	@CacheLookup
	WebElement TextforEmployeeName;
	
	public void setTextforEmployeeName(String EmployeeName) {
		TextforEmployeeName.clear();
		TextforEmployeeName.sendKeys(EmployeeName);
	}

	public boolean getTextforEmployeeName() {
		return TextforEmployeeName.isDisplayed();
	}
	
	@FindBy(xpath="//*[@id=\"welcome\"]")
	@CacheLookup
	WebElement UserProfile;
	
	public void setUserProfile() {
		
		Actions action = new Actions(driver);
		action.moveToElement(UserProfile).build().perform();
		UserProfile.click();
	}
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div[10]/ul/li[2]/a")
	@CacheLookup
	WebElement Logout;
	
	public void setLogout() {
		
		Actions action = new Actions(driver);
		action.moveToElement(Logout).build().perform();
		Logout.click();
	}
	
	@FindBy(id="menu_admin_viewAdminModule")
	@CacheLookup
	WebElement AdminLink;
	
	public void ClickOnAdminLink() {
		AdminLink.click();
	}
	
	@FindBy(id="menu_pim_viewPimModule")
	@CacheLookup
	WebElement PIMLink;
	
	public void ClickOnPIMLink() {
		PIMLink.click();
	}
	
	@FindBy(id="menu_dashboard_index")
	@CacheLookup
	WebElement DashBoardLink;
	
	public void ClickOnDashBoardLink() {
		DashBoardLink.click();
	}
	
	@FindBy(id="menu_maintenance_purgeEmployee")
	@CacheLookup
	WebElement MaintenanceLink;
	
	public void ClickOnMaintenanceLink() {
		MaintenanceLink.click();
	}
	
	
	@FindBy(id="menu_directory_viewDirectory")
	@CacheLookup
	WebElement DirectoryLink;
	
	
	 @FindBy(xpath="//*[@id=\"content\"]/div/div[1]/h1")
	    WebElement DashBoardHeader;
	    
	    public String GetDashBoardHeaderText() {
	    	return DashBoardHeader.getText();
	    }
	


}


