package jiraAudLog;

import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.lang.String;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.invoke.MethodHandleInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.prefs.Preferences;

import javax.lang.model.element.VariableElement;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class JIRAMethods extends Constants{
	public static WebDriver driver;
	public static int e;
	public static boolean OneTime, exp, TestcaseLabel, TestcaseId, Resolvedjira;
	static String Username, jId, jSummary, dType, rsldJra;
	static ArrayList<String> dummList=new ArrayList<String>();
	static ArrayList<String> jiraId=new ArrayList<String>();
	static ArrayList<String> summary=new ArrayList<String>();
	static ArrayList<String> deviationType=new ArrayList<String>();
	static HashMap<String, String> tesla= new HashMap<String, String>();
	static HashMap<String, String> tesla2= new HashMap<String, String>();
	static String link="//a[(@href='/browse/'+jiraId.get(j)+')]";
	
		public static WebDriver changeLocation() {
 		driver = new ChromeDriver();
 		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 		return driver;	
 			}
	
	 	 	 public static void jiraLogin() throws Exception
		 	 {
	 	 	 	driver.get(JIRA_FILTER_URL);
	 	 	 	Thread.sleep(3000);
	 	 	 	driver.findElement(By.className("idp")).click();
	 	 	 	Thread.sleep(2000);
	 			 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 	         String loginId;   
	 	         System.out.println("Please Enter the user Midway Username :: ");
	 	         loginId = br.readLine();  
	 	 	 	driver.findElement(By.id("user_name")).sendKeys(loginId);
	 	 	 	BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
	 	         String passWord;   
	 	         System.out.println("Please Enter the user Jira Password :: ");
	 	         passWord = br.readLine();  
	 	 	 	driver.findElement(By.id("password")).sendKeys(passWord);
	 	 	 	driver.findElement(By.id("verify_btn")).click();
	 	 	 	driver.manage().window().maximize();
	 	 	 	Thread.sleep(10000);
	 	 	 }
		
	 	 	public static void jiraCount(){
		 		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 	 	List<WebElement> d = driver.findElements(By.xpath("//a[@class='hidden-link issue-link']"));
			System.out.println(d.size());
			e=d.size();
	 	 	}
	 	 	public static void jiraIndexing() throws Exception {
			for (int i=1;i<=e;i++){
			driver.findElement(By.xpath("(//td[contains(@class,'summary')]/p/a)["+i+"]")).click(); 
//	        ((RemoteWebDriver) driver).setLogLevel(Level.INFO);
//			driver.getCurrentUrl();
			Thread.sleep(3000);
			System.out.println("\n");
			System.out.println(i +"\n");
	 		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 	  CheckOneTimeIssue();
		 	  if(OneTime==false) {
		 		 CheckCommonJiralabels();
			 	 CheckExploratoryLabelsAdded();
			 	 if(exp==false){
			 	 TestcaseAffectedLabels();
			 	 CheckTestcaseIdAdded();
			 	CheckRegressionDetails();
			 	 }
			 	 else {
			 		CheckRegressionDetails();
			 	 }
		 	  }
		 	  else {
				 	 backToJiraList();
		 	  }
		}
			System.out.println("\n");
			System.out.println(tesla);
			System.out.println("\n");
			System.out.println(tesla2);

	   }
	 	 	public static void backToJiraList() throws Exception {
	 	 		driver.navigate().back();
	 	 		Thread.sleep(6000);
	 	 	}
	 	 	 
	 	 	 public static void CheckRegressionDetails() throws Exception { 
	 	 	 System.out.println("Checking Regression");
	 	 		if(driver.getPageSource().contains("Regression:Yes") || driver.getPageSource().contains("<b>Regression:</b> Yes,") || driver.getPageSource().contains("<b>Regression:</b>Yes,") || driver.getPageSource().contains("<b>Regression:Yes</b>") || driver.getPageSource().contains("<b>Regression: YES</b>") || driver.getPageSource().contains("<b>Regression</b>:-Yes,") || driver.getPageSource().contains("<b>Regression</b>:-Yes") || driver.getPageSource().contains("Regression: Yes") || driver.getPageSource().contains("<b>Regression: Yes</b>") || driver.getPageSource().contains("<b>REGRESSION</b>: Yes") || driver.getPageSource().contains("<b>Regression:</b> Yes,") || driver.getPageSource().contains("REGRESSION: YES") || driver.getPageSource().contains("REGRESSION: Yes") || driver.getPageSource().contains("REGRESSION: No") || driver.getPageSource().contains("Regression: No") || driver.getPageSource().contains("<b>Regression:</b> No") || driver.getPageSource().contains("REGRESSION: NO") || driver.getPageSource().contains("<b>REGRESSION: NO</b>") || driver.getPageSource().contains("Regression:-No") || driver.getPageSource().contains("<b>Regression</b>: No")){
	            	  System.out.println("5. Regression details added");
	            	  }
	 	 		else if(driver.getPageSource().contains("As In use Indicator for Mic and Camera is a new feature.") || driver.getPageSource().contains("As Vanilla is a new feature.") || driver.getPageSource().contains("As shortcut panel is a new feature.") || driver.getPageSource().contains("As Shortcut panel is a new feature.") || driver.getPageSource().contains("As vanilla is a new feature.") || driver.getPageSource().contains("As Shortcut Panel is a new feature.")) {
	 	 			System.out.println("Regression not needed as it is a new feature");
	 	 			}
	 	 		else
	            	  {
	            		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	            		  Username = driver.findElement(By.xpath("//span[contains(@id,'issue_summary_reporter_')]")).getText();
	            	  System.out.println("5. Regression details not added" +"\t" +Username);//	            	  dummList.add(Username);
		 	 		  jId = driver.findElement(By.xpath("//a[@class='issue-link']")).getText();
	            	  jSummary= driver.findElement(By.xpath("//h1[@id='summary-val']")).getText();
	            	  dType="Regression details not found";
	            	  dummList.add(Username);
	            	  deviationType.add(dType);
	            	  jiraId.add(jId);
	            	  summary.add(jSummary);
	            	  tesla.put(jId,Username);
	            	  tesla2.put(jId, dType);
	            	  }
	 	 		Thread.sleep(2000);
	 	 		backToJiraList();
	 	 }
	 	 	 public static boolean CheckOneTimeIssue() {
	 	 		 OneTime=false;
	 	 		if(driver.getPageSource().contains("Regression: NA") && driver.getPageSource().contains("[One Time Issue]") || driver.getPageSource().contains("[ONE TIME ISSUE]") && driver.getPageSource().contains("REGRESSION: NA")){ //&& driver.getPageSource().contains("One Time Issue") && driver.getPageSource().contains("ONE TIME ISSUE"))
	 	 			 System.out.println("One Time Issue Regression Not Needed");
	 	 			 OneTime=true;
          	         }else
          	         {
          	  System.out.println("This is not OneTime issue-Checking for \n1.Regression 2.Exploratory Labels 3.Testcase Labels 4.Testcase Id's");
          	  }
	 	 		return OneTime;
	 	 }
	 	 	 
	 	 	 public static void CheckCommonJiralabels() {
	 	 		 
	              if(driver.getPageSource().contains("e2e_da") && driver.getPageSource().contains("Kava-7_Trona_PQA") 
	            		  || driver.getPageSource().contains("ftue_da") && driver.getPageSource().contains("Kava-7_Trona_PQA") 
	            		  || driver.getPageSource().contains("ftue_da") && driver.getPageSource().contains("Kava-7_PQA") 
	            		  ||driver.getPageSource().contains("e2e_da") && driver.getPageSource().contains("Kava-7_PQA")){
	            	  System.out.println("1. Common Jira labels are present");
	            	  } else {
	            		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	            		  Username = driver.findElement(By.xpath("//span[contains(@id,'issue_summary_reporter_')]")).getText();
	            	  System.out.println("1. Common Jira labels are absent" +"\t" +Username);
		 	 		  jId = driver.findElement(By.xpath("//a[@class='issue-link']")).getText();
	            	  jSummary= driver.findElement(By.xpath("//h1[@id='summary-val']")).getText();
	            	  dType="Common jira labels not found";
	            	  dummList.add(Username);
	            	  deviationType.add(dType);
	            	  jiraId.add(jId);
	            	  summary.add(jSummary);
	            	  tesla.put(jId,Username);
	            	  tesla2.put(jId, dType);
	            	  }
	 	 	 }
	              
	         public static boolean CheckExploratoryLabelsAdded(){
	        	 System.out.println("Checking for Exploratory Labels");
	        	 exp=false;
	              if(driver.getPageSource().contains("e2e_exp_7319") && driver.getPageSource().contains("E2E_DA_GENERAL")){ 
	            	  System.out.println("2. Exploratory labels are present");
	            	  exp=true;
	            	  }else{
	            		  Username = driver.findElement(By.xpath("//span[contains(@id,'issue_summary_reporter_')]")).getText();
	            	  System.out.println("2. This is not an Exploratory Bug");
	            	  }
	              return exp;
	      }
	         
	 	 	 public static void TestcaseAffectedLabels() {
	        	 System.out.println("Checking for Testcase Affected Labels");
	 	 		if(driver.getPageSource().contains("E2EFOS5Mainline") || driver.getPageSource().contains("e2e_kava7")
	 	 				|| driver.getPageSource().contains("FTUEFOS7Mainline") || driver.getPageSource().contains("ftue_kava7")
	 	 				|| driver.getPageSource().contains("FTUE7319") ||driver.getPageSource().contains("E2E7319")) { 
	 	 			System.out.println("3. This is a test case related bug need to check for tagged test case id");
	            	  }
	 	 		else{
	            	  System.out.println("3. This is an Exploratory Bug");
	            	  }
	      }
	 	 	 
	 	 	 public static void CheckTestcaseIdAdded() { 
	 	 		System.out.println("Checking for Testcase Id's are added");
	 	 		if(driver.getPageSource().contains("Test case link:") || driver.getPageSource().contains("Test case:") || driver.getPageSource().contains("<b>Test case ID:</b>") || driver.getPageSource().contains("TestRail: Results") || driver.getPageSource().contains("<b>Test case ID:-</b>") || driver.getPageSource().contains("Testcase Id") || driver.getPageSource().contains("<b>TEST CASE ID:</b>") || driver.getPageSource().contains("TESTCASE ID") || driver.getPageSource().contains("Testcase id") || driver.getPageSource().contains("Test case id:") || driver.getPageSource().contains("Test Case Id :") || driver.getPageSource().contains("test case ID:") || driver.getPageSource().contains("Test case ID:")){
	 	 	System.out.println("4. Related Testcase id's has been tagged to the Jira");
	                  }
	 	 		else {
	 	 			Username = driver.findElement(By.xpath("//span[contains(@id,'issue_summary_reporter_')]")).getText();
	 	 			System.out.println("4. Related Testcase id's has NOT been tagged to the Jira" +"\t" +Username);
//	 	 			dummList.add(Username);
	 	 		  jId = driver.findElement(By.xpath("//a[@class='issue-link']")).getText();
            	  jSummary= driver.findElement(By.xpath("//h1[@id='summary-val']")).getText();
            	  dType="Test case id not added";
            	  dummList.add(Username);
            	  deviationType.add(dType);
            	  jiraId.add(jId);
            	  summary.add(jSummary);
//            	  tesla.put(jId,Username);
//            	  tesla2.put(jId, dType);
            	  
	 	 		}
	 	 	 }
	      
	 	 	public static void mailCreatorPass() throws Exception{
                
                Properties props = new Properties();
     props.setProperty("mail.transport.protocol", "smtp");
     props.setProperty("mail.host", "smtp.amazon.com");
     Session session = Session.getDefaultInstance(props, null);

     try {
         Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress("PR-DA-BOT@amazon.com"));
         String roseMilk = (indhaVechika.toString());
         int size = roseMilk.length();
         System.out.println(roseMilk);
         System.out.println(size);
         String serupu = roseMilk.substring(1, roseMilk.length()-1);
         System.out.println(serupu);
//         message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(serupu)); 
         message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("abc@xyz.com")); 
        message.setRecipients(Message.RecipientType.CC, InternetAddress.parse("abc@xyz.com, iop@klu.com, dsc@myx.com")); 
        message.setSubject("Jira Deviations Report for Week 10/08/2020 to 14/08/2020");
        
        StringBuilder buf = new StringBuilder();
         buf.append("<html><body style=\"font-family:Calibri; font-size:100%;\">");
         buf.append("<p>Hi All, </p>");
         buf.append("<p>Please find the jira deviations below</p>");
//         buf.append("<p><b>This is a Test email please Ignore</b></p>");
         buf.append(bugstableMainline7());         
         
         String msg = buf.toString();
         message.setContent(msg, "text/html");
 
         Transport.send(message);
 
         System.out.println("Mail sent");
 
     } catch (Exception e) {
        System.out.println("Mail not sent");
        e.printStackTrace();
     }

     finally {
		System.out.println(driver.getCurrentUrl()); 
	}
}
     
     public static String bugstableMainline7(){
 	 	
 		System.out.println("Entered to making table");
 	 	String s2 = "<p><b><i>None</b></i></p>";
 	 	System.out.println(jiraId.size());
 	 	
 	 	if(jiraId.size()>0){
 	 		
 	 	 s2 ="\r\n" + 
 	 	 		"<table id=\"jiras\" style=\"font-size:80%\" cellspacing=\"0\" width=\"100%\" border=\"0\" cellpadding=\"5\">\r\n" + 
 	 	 		"<tbody><tr>\r\n" + 
 	 	 		"<th bgcolor=\"DCDCDC\">Issue-ID</th>\r\n" + 
 	 	 		"<th bgcolor=\"DCDCDC\">Deviation Type</th>\r\n" + 
 	 	 		"<th bgcolor=\"DCDCDC\">Reporter</th>\r\n" + 
 	 	 		"</tr><tr>\r\n"; 
 	 	 		
 	 	 		 	 		
 	 	    for(int j=0; j<jiraId.size(); j++)
 	 	    { 
 	 	    	s2 += "<td bgcolor=\"#9BBB59\"> <a href=\"https://issues.labcollab.net/browse/"+jiraId.get(j)+"\">"+jiraId.get(j) +"</a></td>\r\n" + 

 	 	    	 		"<td bgcolor=\"#EBF1DE\">"+deviationType.get(j) +"</td>\r\n" + 
 	 	    	 		"<td bgcolor=\"#EBF1DE\">"+dummList.get(j) +"</td>\r\n" + 
 	 	    	 		"</tr><tr>\r\n";
 	 	    	}
  	    
 	 	       s2 += "</tr></tbody></table>";
 	 	  }
	 	 	return s2;
    	}

}