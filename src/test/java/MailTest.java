import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MailTest {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mail.ru/");
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class,'resplash-btn resplash-btn_primary')]")));
    }


    @Test
    public void openBrowserTest() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(@class,'resplash-btn resplash-btn_primary')]")).click();
        Thread.sleep(6000);
        driver.switchTo().frame(14);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("asd");
        Thread.sleep(2000);
        driver.quit();
        }
    }
