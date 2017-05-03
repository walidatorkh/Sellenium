package com.param.utils;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;
public class ObjectsActions {

	public ObjectsActions() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean actionOnTableChildObject(WebElement table, int iSearchCol, String sSearchText, int iActionCol, String sActionTag, String sAction, int iIndex)
    {
    	try
    	{
    		
    		String sLinkText = "";
			
			List<WebElement> WebElementRows = null;
	        List<WebElement> WebElementsCells = null;
	        List<WebElement> WebElementsChildren = null;
	        WebElementRows = table.findElements(By.tagName("TR"));
	        	        	        
	        int iRows = WebElementRows.size();
	        int i;
	        int iCells;
	        String sText = "";
	        for(i = 0; i < iRows; i++)
	        {
	        	WebElementsCells = WebElementRows.get(i).findElements(By.tagName("TD"));
	        	iCells = WebElementsCells.size();
	        	if(iCells >= iSearchCol)
	        	{
		        	sText = WebElementsCells.get(iSearchCol - 1).getText();
		        	if(sText.matches(sSearchText))
		        	{
		        		WebElementsChildren = WebElementsCells.get(iActionCol).findElements(By.tagName(sActionTag));
		        		int iChildren = WebElementsChildren.size();
		        		if(iChildren >= iIndex)
		        			WebElementsChildren.get(iIndex - 1).click();
		        		break;
		        	}
	        	}
	        }
	       
	       
	        
    		return(true);
    	}
        catch(Exception e)
        {
        	return(false);
        }
    }
	
	public int getTableRowCount(WebElement table)
    {
    	try
    	{
    		String sLinkText = "";
			
			List<WebElement> WebElementRows = null;
	        WebElementRows = table.findElements(By.tagName("TR"));
	        	        	        
	        int iRows = WebElementRows.size();
	        	        	        
    		return(iRows);
    	}
        catch(Exception e)
        {
        	return(-1);
        }
    }
	
	public boolean verifryTableCellText(WebElement table, int iSearchCol, String sSearchText, int iVerifyCol, String sVerifyText)
    {
    	try
    	{
    		
    		String sText = getTableCellText(table, iSearchCol, sSearchText, iVerifyCol);
	        
    		if(sText.matches(sVerifyText))
	        {
	            System.out.println("PASS - Verify text in column " + iVerifyCol + " by text " + sSearchText + " in column " + iSearchCol);
	            return(true);
	        }
	        else
	        {
	        	System.out.println("FAIL - Verify text in column " + iVerifyCol + " by text " + sSearchText + " in column " + iSearchCol);
	            return(false);
	        }
    	}
        catch(Exception e)
        {
        	return(false);
        }
    }
	
	public String getTableCellText(WebElement table, int iSearchCol, String sSearchText, int iReturnCol)
	{
		try
		{
			String sLinkText = "";
									
			// For reporting
	        String sType = table.getTagName();
	        if(sType.equals("a"))
	        {
	            sLinkText = table.getText();
	        }
	        
	        List<WebElement> WebElementRows = null;
	        List<WebElement> WebElementsCells = null;
	        WebElementRows = table.findElements(By.tagName("TR"));
	        	        	        
	        int iRows = WebElementRows.size();
	        int i;
	        int iCells;
	        String sText = "";
	        for(i = 0; i < iRows; i++)
	        {
	        	WebElementsCells = WebElementRows.get(i).findElements(By.tagName("TD"));
	        	
	        	// Instead - No need to get all cells - Use xPath to get the correct one
	        	String cellText = WebElementRows.get(i).findElement(By.xpath("./td[2]")).getText();
	        	
	        	iCells = WebElementsCells.size();
	        	if(iCells >= iSearchCol)
	        	{
		        	sText = WebElementsCells.get(iSearchCol - 1).getText();
		        	if(sText.matches(sSearchText))
		        	{
		        		sText = WebElementsCells.get(iReturnCol - 1).getText();
		        		break;
		        	}
	        	}
	        }
	        
	        return(sText);
		}
		catch(Exception e)
		{
			return("");
		}

	}

	
	public String getTableCellText(WebElement table, int iRow, int iCol)
	{
		try
		{
			
			String sLinkText = "";
					
			// For reporting
	        String sType = table.getTagName();
	        if(sType.equals("a"))
	        {
	            sLinkText = table.getText();
	        }
	        
	        List<WebElement> WebElementRows = null;
	        List<WebElement> WebElementsCells = null;
	        WebElementRows = table.findElements(By.tagName("TR"));
	        WebElementsCells = WebElementRows.get(iRow - 1).findElements(By.tagName("TD"));
	        String sText = WebElementsCells.get(iCol - 1).getText();
	        	        
	        return(sText);
			
		}
		catch(Exception e)
		{
			return("");
		}
	}
}


