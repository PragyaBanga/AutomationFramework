package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class baseTest {

	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr;

	
	@BeforeTest
	
  public void setUp() throws IOException {
	if(driver==null) {
		System.out.println(System.getProperty("user.dir"));
		
		FileReader fr= new FileReader("C:\\Users\\pragya.banga\\eclipse-framework\\Automationframework\\src\\test\\resources\\config\\config.properties");
	prop.load(fr);
	}
	
	
		if (prop.getProperty("browser").equalsIgnoreCase("chrome"))
         {
            driver = new ChromeDriver(); // base
		   driver.get(prop.getProperty("testurl"));

         }
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			//WebDriverManager.firefoxdriver().setup();
		   driver = new FirefoxDriver();
driver.get(prop.getProperty("testurl"));			
		}
}

	@AfterTest
	public void tearDown() {
		driver.close();
		System.out.println("Teardown done");

	}
}
