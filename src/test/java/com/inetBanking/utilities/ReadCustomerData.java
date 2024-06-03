package com.inetBanking.utilities;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReadCustomerData {
	
	public static JSONObject loadJSONFileContainingArray(String filePath, int index) throws IOException, ParseException{
		
			FileReader reader = new FileReader(filePath);
			JSONParser parser = new JSONParser();
			
			Object obj = parser.parse(reader);
			JSONArray jsonArray = (JSONArray) obj;
			
			JSONObject jsonObject = (JSONObject) jsonArray.get(index);
			
			return jsonObject;
			
	}
	
	public static JSONObject loadJSONFile(String filePath) throws IOException, ParseException{
		FileReader reader = new FileReader(filePath);
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(reader);
		JSONObject jsonObject = (JSONObject) obj;
		return jsonObject;
	}
	
	@SuppressWarnings("unchecked")
	public static void addCustomerID(String Id) {
		String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\com\\inetBanking\\testData\\Customer.json";
		
		try(FileReader reader = new FileReader(filePath)){
			
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(reader);
			JSONObject userObj =  (JSONObject) obj;
			
			userObj.put("CustomerId", Id);
			try(FileWriter file = new FileWriter(filePath)){
				file.write(userObj.toJSONString());
				file.flush();
				file.close();
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void waitForElement(WebDriver driver,WebElement element,int TIME_UNIT_SECONDS) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_UNIT_SECONDS));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public static String getCustomerId(String filePath) {
		
		try(FileReader reader = new FileReader(filePath)){
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(reader);
			JSONObject userObj = (JSONObject) obj;
			String customerId = (String) userObj.get("CustomerId");
			
			return customerId;
			
		}catch(Exception e) {
			
			return null;
		}
		
	}
}
