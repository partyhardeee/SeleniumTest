import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

    }


    //тест
    @Test
    public void openBrowserTest() throws InterruptedException {
        driver = new ChromeDriver();
        driver.quit();
    }
}
