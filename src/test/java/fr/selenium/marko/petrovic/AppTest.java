package fr.selenium.marko.petrovic;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase{
	private static final String URL = "http://www.fr.jal.co.jp/frl/en/";
	private static final String PATH_CHROME_DRIVER ="C:\\chromedriver.exe";
	public static WebDriver driver;	
	
	
	
	public static void firstTest() {
		String VilleDepart = "";
		String VilleArrivée = "";
		String FlightNumbers ="";
		String Horarires = "";
		String Prix = "";
		String VilleDepart1 = "";
		String VilleArrivée1 = "";
		String FlightNumbers1 ="";
		String Horarires1 = "";
		String Horarires2 = "";
		String Prix1 = "";
		System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(URL);
		pausa(3);
		WebElement element=driver.findElement(By.cssSelector(".JS_ciBox_submit"));
		element.click();
		Select s= new Select(driver.findElement(By.id("mdlDepLocation1")));
		s.selectByValue("NCE");
		Select m= new Select(driver.findElement(By.id("mdlArrLocation1")));
		m.selectByValue("OSA");
		Select z= new Select(driver.findElement(By.id("DEPARTURE_DATE_1_MONTH")));
		z.selectByValue("8");
		Select f= new Select(driver.findElement(By.id("DEPARTURE_DATE_1_DAY")));
		f.selectByValue("25");
		Select t= new Select(driver.findElement(By.id("DEPARTURE_DATE_2_MONTH")));
		t.selectByValue("8");
		Select r= new Select(driver.findElement(By.id("DEPARTURE_DATE_2_DAY")));
		r.selectByValue("30");

		WebElement elementFinal=driver.findElement(By.cssSelector(".searchBtn"));
		elementFinal.click();
		pausa(3);
		VilleDepart1 = driver.findElement(By.id("bound-departure-0")).getText();
		System.out.println(VilleDepart1);
		try {
			System.out.println(LocalDateTime.now());
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#flightNumber-0-0 .flight-identifier"))));
		} catch(TimeoutException e) {
			System.out.print("J'ai pas trouvé ton WebElement" + LocalDateTime.now());
		}


		if (driver.findElement(By.cssSelector("#flightNumber-0-0 .flight-identifier")).isDisplayed()){
			System.out.println("le flight number s'affiche");
		}else{
			System.out.println("le filight number s'affiche pas .on click pour l'affucher");
			driver.findElements(By.cssSelector(".medium-pattern.mb1.p5")).get(0).click();
		}
		WebElement element10= driver.findElement(By.cssSelector("#flightNumber-0-0 .flight-identifier"));
		String flightNumberAVAI = element10.getText();
		System.out.println("Flight Number:" + flightNumberAVAI);
		
		try {
			System.out.println(LocalDateTime.now());
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#flightNumber-0-0 .flight-identifier"))));
			System.out.println("j'ai bien trouve ton web elelement et maintent est : " + LocalDateTime.now());
		} catch(TimeoutException e) {
			System.out.print("J'ai pas trouvé ton WebElement" + LocalDateTime.now());
		}
		
		WebElement elementContinu=driver.findElement(By.id("continueButton"));
		elementContinu.click();
		/*recupere valeurs de departs

				VilleArrivée1 = driver.findElement(By.id("mdlArrLocation1")).getText();
				System.out.println(VilleArrivée1);
				Horarires1 = driver.findElement(By.id("DEPARTURE_DATE_1_MONTH")).getText();
				System.out.println(Horarires1);
				Horarires2 = driver.findElement(By.id("DEPARTURE_DATE_1_MONTH")).getText();
				System.out.println(Horarires2);*/
		Prix = driver.findElement(By.id("sidebarPriceSummaryTotalPrice")).getText();
				System.out.println(Prix);
		
		
		
		
		Select mr=new Select(driver.findElement(By.id("0-title")));
		mr.selectByValue("MR");
		driver.findElement(By.id("0-last-name")).sendKeys("Petrovic");
		driver.findElement(By.id("0-first-name")).sendKeys("Marko");
		Select gen=new Select(driver.findElement(By.id("0-gender")));
		gen.selectByValue("string:MALE");
		Select dd=new Select(driver.findElement(By.id("0-birth-date-day")));
		dd.selectByValue("string:01");
		Select mm=new Select(driver.findElement(By.id("0-birth-date-month")));
		mm.selectByValue("string:05");
		Select yy=new Select(driver.findElement(By.id("0-birth-date-year")));
		yy.selectByValue("string:1979");
		Select nn=new Select(driver.findElement(By.id("0-nationality")));
		nn.selectByValue("string:FR");
		Select phone= new Select(driver.findElement(By.id("phone1-phone-country-0")));
		phone.selectByValue("FRA");
		driver.findElement(By.id("phone1-phone-number-0")).sendKeys("0123456789");
		driver.findElement(By.id("email-guest-address")).sendKeys("toto@gmail.com");
		driver.findElement(By.id("email-confirm-new")).sendKeys("toto@gmail.com");
		WebElement elementContinu2=driver.findElement(By.id("continueButton"));
		elementContinu2.click();
		WebElement elementContinu3=driver.findElement(By.id("continueButton-PCOF"));
		elementContinu3.click();
		WebElement elementContinu4=driver.findElement(By.id("seatContinue"));
		elementContinu4.click();
		VilleDepart = driver.findElement(By.id("originLocation-0")).getText();
		System.out.println(VilleDepart);
		VilleArrivée = driver.findElement(By.id("destinationLocation-0")).getText();
		System.out.println(VilleArrivée);
		FlightNumbers = driver.findElement(By.id("flightNumber-0-0")).getText();
		System.out.println(FlightNumbers);
		Horarires = driver.findElement(By.id("originDate-0")).getText();
		System.out.println(Horarires);
		Prix = driver.findElement(By.id("sidebarPriceSummaryTotalPrice")).getText();
		System.out.println(Prix);
		
		
		
		WebElement elementContinu5=driver.findElement(By.id("purchaseButton"));
		elementContinu5.click();
		driver.findElement(By.id("CCnb")).sendKeys("378282246310005");
		
		driver.findElement(By.id("sec-code")).sendKeys("4800");
		Select emd=new Select(driver.findElement(By.id("expiration-month-id")));
		emd.selectByValue("number:8");
		pausa(3);
		WebElement elementContinuf=driver.findElement(By.id("continueButton"));
		elementContinuf.click();
		WebElement elementbb = driver.findElement(By.id("confirm"));
		Actions actions = new Actions(driver);
		actions.moveToElement(elementbb).click().build().perform();
		
		WebElement elementContinufff=driver.findElement(By.id("continueButton"));
		elementContinufff.click();
		
		
		assertEquals(VilleDepart1, VilleDepart);
		
	
		driver.close();
	
	}


	
	private static void pausa(int seconds) {
		try {
			Thread.sleep(seconds* 1000);
	}catch (InterruptedException ex) {
		Thread.currentThread().interrupt();
	}
	}
}