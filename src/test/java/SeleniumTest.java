import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static WebDriver driver;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //123
    }


    //тест
    @Test
    public void openBrowserTest() {
        driver = new ChromeDriver();
        driver.quit();
    }
}
