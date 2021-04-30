package jiraAudLog;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;

public  class Constants {
		 static HashMap<String, String> emailId = new HashMap<>();
		 static HashMap<Integer, String> finalEmailId = new HashMap<>();
		 static ArrayList<String> pascal = new ArrayList<String>();
		public static HashSet<String> indhaVechika = new HashSet<String>();

//		public static Set<String> set = new HashSet<String>(emailId.values());
	 	public static String JIRA_USERNAME_ID = "auth_user_username"; 
	 	public static String JIRA_PASSWORD_ID = "";
	 	
	 	public static String JIRA_FILTER_URL = "https://issues.labcollab.net/issues/?filter=-2&jql=issuetype%20%3D%20Bug%20AND%20resolution%20%3D%20Unresolved%20AND%20created%20%3E%3D%202021-02-14%20AND%20created%20%3C%3D%202021-02-20%20AND%20reporter%20in%20(currentUser()%2C%20mgunase%2C%20murugsub%2C%20monibabu%2C%20vahinh%2C%20kubhis%2C%20sangeert%2C%20nshantm%2C%20snewslin)%20order%20by%20created%20DESC";
	 	public static String JIRA_USERNAME_TXTBOX_ID = "JIRA_USERNAME"; 
	 	public static String JIRA_PASSWORD_TXTBOX_ID = "JIRA_PASSWORD"; 
	 	public static String JIRA_SUBMIT_BUTTON_XPATH = "//input[@class='aui-button aui-button-primary']";
	 	
	 	public static String JIRA_USERNAME = "qaesdet"; 
	 	public static String JIRA_PASSWORD = "123456789"; 
	 	public static String MIDWAY_TOKEN = "eneccchjkdhpldkjdyorplsvdggugfihdleinrg";
	 	
	 	public static void getEmailAddress(){
	 		emailId.put("Abcde", "abc@xyz.com");
	 		emailId.put("Abcde", "abc@xyz.com");
	 		emailId.put("Abcde", "abc@xyz.com");
	 		emailId.put("Abcde", "abc@xyz.com");
	 		emailId.put("Abcde", "abc@xyz.com");
	 		emailId.put("Abcde", "abc@xyz.com");
	 		emailId.put("Abcde", "abc@xyz.com");
	 		emailId.put("Abcde", "abc@xyz.com");
	 		emailId.put("Abcde", "abc@xyz.com");
	 		emailId.put("Abcde", "abc@xyz.com");
	 	}
	 }
	 