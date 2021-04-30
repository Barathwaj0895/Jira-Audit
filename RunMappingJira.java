package jiraAudLog;

import java.io.IOException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.seleniumhq.jetty9.server.Authentication.User;

public class RunMappingJira extends JIRAMethods {
	 public static int k=0;
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ravisanb\\workspace\\Jira Audit\\driver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
//	        ((RemoteWebDriver) driver).setLogLevel(Level.INFO);
		changeLocation();
		jiraLogin();
		jiraCount();
		jiraIndexing();
		System.out.println(dummList);
		System.out.println(deviationType);
		System.out.println(jiraId);
		getEmailAddress();
		String d = emailId.get(Username);
//		Set<String> set = new HashSet<String>(emailId.get(dummList));
		for (String user : dummList) {
			if (emailId.containsKey(user)) {
//				for (int i = 0; i <= emailId.size(); i++) 
//				{
					System.out.println(emailId.get(user));
//				 finalEmailId.put(k, emailId.get(user));
					indhaVechika.add(emailId.get(user));
//				 k++;
//				}
			}
		}
		
//		 System.out.println(finalEmailId.size());
//		 System.out.println("*********************");
//		for (int i = 0; i <= finalEmailId.size(); i++) {
//			indhaVechika.add(finalEmailId.get(i));
//		}
//		for(int i = 0; i <= indhaVechika.size(); i++) 
//		System.out.println(indhaVechika.size());
//		for (String ff : indhaVechika) {
			mailCreatorPass();
//		}
//		{
//			System.out.println(indhaVechika);
//			String f = indhaVechika.get(i);
//			mailCreatorPass(f);
//		}
    }
}

