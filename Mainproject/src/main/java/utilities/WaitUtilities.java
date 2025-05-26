package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {
	public static int implicitWaitDuration=10;
	public void implicitwait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitDuration));	
	}
	
	
	public static int explicitWaitDuration=15;
public void waitUntilElementIsVisible(WebDriver driver,WebElement element)//separate method for different conditions
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(element));
}
public void waitUntilAlertIsPresent(WebDriver driver)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.alertIsPresent());
}
public void elementToBeClickable(WebDriver driver,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
public void elementToBeSelected(WebDriver driver,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeSelected(element));
}
public void visibilityOf(WebDriver driver,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(element));
}

public void textToBePresentInElement(WebDriver driver,WebElement element,String textToBePresent )
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.textToBePresentInElement(element, textToBePresent));
}


public static int fluentWaitDuration=30;
public static int timeInterval=5;
public void fluentWaitUtility(WebDriver driver,WebElement element)
{
	FluentWait<WebDriver>wait3=new FluentWait<>(driver)	
			.withTimeout(Duration.ofSeconds(fluentWaitDuration))
			.pollingEvery(Duration.ofSeconds(5))
			.ignoring(NoSuchElementException.class);
			wait3.until(ExpectedConditions.elementToBeClickable(element));
}


}
