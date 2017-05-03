package com.param;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Parameterize {
	
	private WebDriver driver;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
//		System.setProperty("webdriver.chrome.driver","C:\\Resources\\Exe\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\jbt\\Selenium\\git\\Selenium Project\\Exe\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	
	}

	@After
	public void tearDown() throws Exception {
		 driver.quit();
	}

	@Test
	public void test() {
		try{
			
			// Text file (Properties)
			Properties EnvProps = new Properties();
			InputStream input = null;
			
			input = new FileInputStream("env.properties");
			EnvProps.load(input);
			
			String url = EnvProps.getProperty("URL");
			
			driver.get(url);
			
			// XML file
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			XPath xpath = XPathFactory.newInstance().newXPath();
			
			File file = new File("Sanity.xml");
			Document doc = db.parse(file);
			
			String expression = "//test[2]/@FirstName";
			String firstName = xpath.compile(expression).evaluate(doc);
			
//			WebElement firstNameField = driver.findElement(By.cssSelector("#first_name"));
//			firstNameField.sendKeys(firstName);
			
			// Get 
			String expression1 = "//test";
			NodeList nl = (NodeList) xpath.compile(expression1).evaluate(doc, XPathConstants.NODESET);
			// List nl1 = (List) xpath.compile(expression1).evaluate(doc, XPathConstants.NODESET);

			int numOfTests = nl.getLength();
			for(int i = 0; i < numOfTests; i++){
				Node currentItem = nl.item(i);
				String firstName1 = currentItem.getAttributes().getNamedItem("FirstName").getNodeValue();
				
				String nodeText = currentItem.getTextContent();
			}
			
			// Excel			
			String xlsFileLocation = "F:\\OneDrive\\Work\\My Selenium Course\\Selenium WD\\Final Version - Nice\\Resources\\Parameters Files\\Sanity.xlsx";
			FileInputStream xlsFile = new FileInputStream(new File(xlsFileLocation));
			Workbook workbook = WorkbookFactory.create(xlsFile);
			
			Sheet sheet = workbook.getSheetAt(0);
			
			String lastName = sheet.getRow(1).getCell(1).toString();
			
			int numOfRows = sheet.getLastRowNum();
			for(int i = 1; i <= numOfRows; i++){
				lastName = sheet.getRow(i).getCell(1).toString();
				System.out.println(lastName);
			}
			
			// Connect to Excel
			FileInputStream xlsFile1 = new FileInputStream(new File(xlsFileLocation));
			Workbook workbook1 = WorkbookFactory.create(xlsFile1);
			
			// Get first sheet from the workbook
			Sheet sheet1 = workbook1.getSheetAt(0);
			
			// Get number of rows and iterate on all rows
			int numOfRows1 = sheet.getLastRowNum();
			for(int i = 1; i <= numOfRows1; i++){
				// Write to Excel
				sheet1.getRow(i).getCell(2).setCellValue("PASS");
			}
			
			xlsFile1.close();
						
			FileOutputStream outFile1 = new FileOutputStream(new File(xlsFileLocation));
			workbook1.write(outFile1);
			outFile1.close();
			
		}
		catch(Exception e){
		}
		
		catch(AssertionError e){
			e.printStackTrace();
		}
		
	}

}
