package myworkspace;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class W3Schools_Automation {

	WebDriver driver;

	@Test
	public void test1() {
		
		System.out.println("We'll Use this method to Set-Up Chromedriver and" 
				+  " launch Google.com on Chrome Browser");
		System.out.println("=============================");
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void test2() {
		
		System.out.println("We'll Use this method to Verify whether google.com is launched or not");
		System.out.println("=============================");
		
		System.out.println(driver.getCurrentUrl());
		System.out.println("=============================");
		
		WebElement logo1= driver.findElement(By.cssSelector("img.lnXdpd"));
		if(logo1.isDisplayed()) {
			System.out.println("Congrats, Welcome to Google");
			System.out.println("=============================");
		}
		else {
			System.out.println("Please Check Your Source code");
			System.out.println("=============================");
		}
	}

	@Test
	public void test3() throws InterruptedException {
		
		System.out.println("We'll Use this method to Search W3 Schools from the Google Auto Suggestion");
		System.out.println("=============================");
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("w3");
		Thread.sleep(3000);
		List<WebElement> auto= driver.findElements(By.xpath("//ul[@class='G43f7e']/li"));
		
		/*System.out.println(auto.get);
		int count= auto.size();
		System.out.println(count);
		int el[]= new int[count];
		
		for (int i=0; i<count; i++) {
			if(el[i])*/
		
		int count= auto.size();
		System.out.println(count);
		
		String selText= "W3schools";
		for(WebElement option: auto) {
			//System.out.println(option);
			
			if(option.getText().equalsIgnoreCase(selText)){
				option.click();
				break;
			}		
		  }
		driver.findElement(By.cssSelector("h3.LC20lb.MBeuO.DKV0Md")).click();
	}
	
	@Test
	public void test4() {
		
		System.out.println("We'll Use this method to Check Whether W3Schools website is launched or not");
		System.out.println("=============================");
		
		System.out.println(driver.getCurrentUrl());
		System.out.println("=============================");
		
		WebElement logo2= driver.findElement(By.cssSelector("i.fa.fa-logo"));
		if(logo2.isDisplayed()) {
			System.out.println("Welcome to W3Schools");
			System.out.println("=============================");
		}
		else {
			System.out.println("Please check your Source code");
			System.out.println("=============================");
		}
		
		/*System.out.println(driver.getCurrentUrl());
		WebElement logo2= driver.findElement(By.className("fa fa-logo"));
		
		if(logo2.isDisplayed()) {
			System.out.println("Success");
			   System.out.println("===============");
		}
		else {
			System.out.println("Kindly Check Your Code");
			      System.out.println("===============");
		}*/
		driver.findElement(By.id("search2")).sendKeys("SQL"+Keys.ENTER);
	}
	
	@Test
	public void test5() throws InterruptedException {
		
		System.out.println("We'll Use this method to Check Whether W3 Schools SQL page "
				+ " is opened or not and Open SQL Query Editor");
		System.out.println("=============================");
		
		System.out.println(driver.getCurrentUrl());
		System.out.println("=============================");
		
		WebElement logo3= driver.findElement
				(By.cssSelector("i.fa.fa-logo.ws-text-green.ws-hover-text-green"));
		//fa fa-logo ws-text-green ws-hover-text-green
		if(logo3.isDisplayed()) {
			System.out.println("Welcome to W3Schools SQL Tutorial");
			System.out.println("=============================");
		}
		else {
			System.out.println("Please Check Your Source Code");
			System.out.println("=============================");
		}
		
		Actions action1= new Actions (driver);
		action1.moveToElement(driver.findElement(By.linkText
				("Try it Yourself »"))).click().build().perform();
		
		Thread.sleep(3000);
		Set<String> Win= driver.getWindowHandles();
		Iterator<String> it= Win.iterator();
		String Win1= it.next();
		String Win2= it.next();
		
		driver.switchTo().window(Win2);
		
		/*action.moveToElement(driver.findElement(By.className("CodeMirror-scroll")))
		.keyDown(Keys.CONTROL).sendKeys("a")
		.keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(query).build().perform();
		
	  WebElement QueryEdit= driver.findElement(By.cssSelector("div.CodeMirror-scroll"));
	  
	  action.moveToElement(QueryEdit).doubleClick()
	  .click().sendKeys(Keys.BACK_SPACE)
	  .sendKeys(query).build().perform();
	   action.moveToElement(QueryEdit)
	  .keyDown(Keys.CONTROL).sendKeys("a"+Keys.BACK_SPACE)
	  .keyUp(Keys.CONTROL).build().perform();
	  
	  QueryEdit.clear();*/
	}
	
	@Test
	public void test6() throws InterruptedException {
		
		System.out.println("We'll Use this method to Clear the Text in the Query box,"
				+ " Re-Enter our query and Run our Query");
		System.out.println("=============================");
		
		System.out.println(driver.getCurrentUrl());
		System.out.println("=============================");
		
		Actions action2= new Actions(driver);
		String query= ("Select CustomerID, CustomerName, Country from Customers where CustomerID between 1 and 5");
		Thread.sleep(3000);
		
		action2.moveToElement(driver.findElement(By.className("CodeMirror-lines")))
		.doubleClick().click().sendKeys(Keys.BACK_SPACE)
		.sendKeys(query).build().perform();
		
		driver.findElement(By.className("ws-btn")).click();
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(5000);
		driver.quit();
	}
}
