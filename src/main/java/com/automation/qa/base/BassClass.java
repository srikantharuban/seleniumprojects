package com.automation.qa.base;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.automation.qa.util.WebEventListener;

public class BassClass {
	public static EventFiringWebDriver e_webdriver;
	public static WebDriver webdriver;
	public static Properties prop;

	public BassClass() {

		try {
			prop = new Properties();
			FileInputStream fileinputstream = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\automation\\qa\\config\\config.properties");
			prop.load(fileinputstream);
		} catch (Exception e) {

		}
	}

	public static void initialization() {
		String browsertype = prop.getProperty("browser");
		System.out.println(browsertype);
		if (browsertype.equals("chrome")) {
			String path = "D:\\Eclipse\\Webdrivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", path);
			webdriver = new ChromeDriver();
		} else if (browsertype.equals("firefox")) {
			String path = "D:\\Eclipse\\Webdrivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", path);
			webdriver = new FirefoxDriver();
		}
		e_webdriver = new EventFiringWebDriver(webdriver);
		WebEventListener eventlistener = new WebEventListener();
		e_webdriver.register(eventlistener);
		webdriver = e_webdriver;

		webdriver.get("http://demo.automationtesting.in/");
		webdriver.manage().window().maximize();
	}

}
