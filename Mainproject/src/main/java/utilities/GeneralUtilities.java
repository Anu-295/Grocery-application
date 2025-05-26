package utilities;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	public String selectDropdownWithValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
		WebElement selectedElement = select.getFirstSelectedOption();
		return selectedElement.getText();
	}
 
 public String selectDropDownWithIndex(WebElement element,int index)
 {
	 Select select = new Select(element);
	 select.selectByIndex(index);
	 WebElement selectedElement = select.getFirstSelectedOption();
		return selectedElement.getText();
 }
 
 public String selectDropDownWithVisibleText(WebElement element,String visibleText)
 {
	 Select select = new Select(element);
	 select.selectByVisibleText(visibleText);
	 WebElement selectedElement = select.getFirstSelectedOption();
		return selectedElement.getText();
 }
 
 public void clickJavaScriptExecutor(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
 
 public void scrollJavascriptExecuter(WebDriver driver)
 {
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,-350)","");	 
 }

 
 public void simpleAlert(WebDriver driver,WebElement element)
 {
	 element.click();
		driver.switchTo().alert().accept(); 
 }
 
 public void confirmationAlert(WebDriver driver,WebElement element,String alerttext)
 {
	 element.click();
	 alerttext= driver.switchTo().alert().getText();
	 driver.switchTo().alert().dismiss();
 }

 public void promptAlert(WebDriver driver,WebElement element,String input)
 {
    element.click();
	driver.switchTo().alert().sendKeys(input);
	driver.switchTo().alert().accept();
 }
 
 public void singleCheckbox(WebElement element)
 {
	 if(!element.isSelected())
		{
			element.click();
		}
		else
		{element.click(); 
		}
		element.click(); 
 }
 public String generateCurrentDateAndTime() { 
		Date date = new Date(); 
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss"); 
		return formatter.format(date); 
	}
 
 
 
 public void multipleCheckBox(WebElement element,WebDriver driver,String inputXpath) {
	 List<WebElement>multiple=driver.findElements(By.xpath(inputXpath));
	 for(WebElement checkbox:multiple)
		{
			if(!checkbox.isSelected())
			{
				checkbox.click();
			}
		}
 }
 
 public void unSelectAll(WebElement element)
 {
	 element.click(); 
 }
 
 
}
