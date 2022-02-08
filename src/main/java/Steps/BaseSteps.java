package Steps;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.TestProperties;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {
    public static WebDriver getDriver() {
        return driver;
    }

    protected static WebDriver driver;
    protected static String baseUrl;
    public static Properties properties = TestProperties.getInstance().getProperties();


    @BeforeClass
        public static void setUp() throws Exception {
            switch (properties.getProperty("browser")){
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                    driver = new ChromeDriver();
                    break;
                default:
                    System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                    driver = new FirefoxDriver();
            }
            baseUrl = properties.getProperty("app.url");
        System.out.println(baseUrl);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterClass
    public static void afterTest() {
        driver.quit();
    }
}
