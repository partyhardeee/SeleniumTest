import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class MailTest {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mail.ru/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-testid='logged-out-one-click']//button[@data-testid='enter-mail-primary']")));
    }

    @BeforeEach
    public void openPopup() {
        driver.findElement(By.xpath("//div[@data-testid='logged-out-one-click']//button[@data-testid='enter-mail-primary']")).click();
        driver.switchTo().frame(14);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='submit-button-wrap']//button[@data-test-id='next-button']")));
    }


    @Test
    public void correctLoginTest() {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("qwerty@mail.ru", Keys.ENTER);
        //Проверка перехода на экран ввода пароля
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='password']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//input[@name='password']")).isDisplayed());
    }

    @Test
    public void mailChangeTest() {
        //По умолчанию Mail
        Assertions.assertTrue(driver.findElement(By.xpath("//div[@data-test-id='domain-select']//span[@data-test-id='domain-select-value']")).getText().contains("@mail.ru"));
        //Проверка переключения на яндекс
        driver.findElement(By.xpath("//div[@data-test-id='providers-list']//div[@data-test-id='yandex']")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//div[@data-test-id='domain-select']//span[@data-test-id='domain-select-value']")).getText().contains("@yandex.ru"));
        //Проверка переключения на Google
        driver.findElement(By.xpath("//div[@data-test-id='providers-list']//div[@data-test-id='google']")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//div[@data-test-id='domain-select']//span[@data-test-id='domain-select-value']")).getText().contains("@gmail.com"));
        //Проверка переключения на "Другой"
        driver.findElement(By.xpath("//div[@data-test-id='providers-list']//div[@data-test-id='other']")).click();
        Assertions.assertTrue(driver.findElements(By.xpath("//div[@data-test-id='domain-select']//span[@data-test-id='domain-select-value']")).size() == 0);
    }

    @Test
    public void wrongAccountErrorTest() {
        //Ввод в поле Mail несуществущей почты
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("йцукен", Keys.ENTER);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-test-id='error-footer-text']")));
        //Проверка что ошибка появилась
        Assertions.assertTrue(driver.findElement(By.xpath("//div[@data-test-id='error-footer-text']")).isDisplayed());
    }

    @Test
    public void emptyLoginErrorTest() {
        //Пустое значение в поле Mail
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Keys.ENTER);
        //Проверка ошибки
        Assertions.assertTrue(driver.findElement(By.xpath("//small[@data-test-id='required']")).isDisplayed());
    }

    @Test
    public void emptyPasswordErrorTest() {
        //Ввод в поле Mail существущей почты
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("qwerty", Keys.ENTER);
        //Ввод в поле пароль неверное значение
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']")));
        driver.findElement(By.xpath("//input[@name='password']")).click();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Keys.ENTER);
        Assertions.assertTrue(driver.findElement(By.xpath("//div[@data-text='Поле «Пароль» должно быть заполнено']")).isDisplayed());
    }


    @AfterEach
    public void closePopup() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-test-id='cross']")));
        driver.findElement(By.xpath("//div[@data-test-id='cross']")).click();
        driver.switchTo().defaultContent();
    }


    @AfterAll
    public static void close() {
        driver.close();
    }

}
