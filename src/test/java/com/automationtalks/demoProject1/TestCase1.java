package com.automationtalks.demoProject1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase1 {

	public static WebDriver driver;

	@BeforeMethod
	public void launchDriver() {
		// TODO Auto-generated method stub
		System.setProperty("org.apache.commons.logging.Log",
				"org.apache.commons.logging.impl.Jdk14Logger");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vinod.chavan\\eclipse-workspace2022\\demoProject1\\lib\\chromedriver.exe");
		//		WebDriverManager.chromedriver().clearResolutionCache().setup();
		ChromeDriverService service = new ChromeDriverService.Builder().withLogOutput(System.out).build();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
//		options.addArguments("--headless"); //for headless mode
//		options.addArguments("--window-size=800,600");//The invisible browser window is only 800x600 in size
		options.addArguments("start-maximized"); // open Browser in maximized mode
		options.addArguments("disable-infobars"); // disabling info-bars
		options.addArguments("--disable-extensions"); // disabling extensions
//		options.addArguments("--disable-gpu"); // applicable to windows os only
		options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
//		options.addArguments("--no-sandbox");
		options.addArguments("--disable-blink-features='BlockCredentialedSubresources'");
//		options.addArguments("--whitelisted-ips='10.5.243.86'");
		driver = new ChromeDriver(service);
	}

	@Test
	public void Test1() {
		driver.get("https://www.google.com/");
		System.out.println("Test 1 Title is " +driver.getTitle());
	}

	@Test
	public void Test2() {
		driver.get("https://www.google.com/");
		System.out.println("Test 2 Title is " +driver.getTitle());
	}
	
	@AfterMethod
	public void quit() {
		driver.close(); // Close the browser before quitting, it won't show SocketError
		driver.quit(); 
	}
}
