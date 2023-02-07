import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailTest {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mail.ru/");
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class,'resplash-btn resplash-btn_primary')]")));
    }

    @BeforeEach
    public void openPopup() {
        driver.findElement(By.xpath("//button[contains(@class,'resplash-btn resplash-btn_primary')]")).click();
        driver.switchTo().frame(14);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='username']")));
    }


    @Test
    public void correctLoginTest() {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("qwerty@mail.ru", Keys.ENTER);
        //Проверка перехода на экран ввода пароля
        Assertions.assertTrue(driver.findElement(By.xpath("//h3[@class='base-0-2-25 h3-0-2-29']")).isDisplayed());
    }

    @Test
    public void mailChangeTest() {
        //По умолчанию Mail
        Assertions.assertTrue(driver.findElement(By.xpath("//div[@class='Select__value-container Select__value-container--has-value css-0']/span[@class='base-0-2-25 control-0-2-33']/span[.='@mail.ru']")).getText().contains("@mail.ru"));
        //Проверка переключения на яндекс
        driver.findElement(By.xpath("//span[@class='ProvidersListItemIcon ProvidersListItemIconYandex']")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//div[@class='Select__value-container Select__value-container--has-value css-0']/span[@class='base-0-2-25 control-0-2-33']/span[.='@yandex.ru']")).getText().contains("@yandex.ru"));
        //Проверка переключения на Google
        driver.findElement(By.xpath("//span[@class='ProvidersListItemIcon ProvidersListItemIconGoogle']")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//div[@class='Select__value-container Select__value-container--has-value css-0']/span[@class='base-0-2-25 control-0-2-33']/span[.='@gmail.com']")).getText().contains("@gmail.com"));
        //Проверка переключения на "Другой"
        driver.findElement(By.className("ProvidersListItemIconText")).click();
        Assertions.assertTrue(driver.findElements(By.xpath("//div[@class='Select__value-container Select__value-container--has-value css-0']/span[@class='base-0-2-25 control-0-2-33']")).size() == 0);
    }

    @Test
    public void wrongAccountErrorTest() {
        //Ввод в поле Mail несуществущей почты
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("йцукен", Keys.ENTER);
        //Проверка что ошибка появилась
        Assertions.assertTrue(driver.findElement(By.xpath("//small[contains(@class,'base-0-2-25 small-0-2-34')]")).isDisplayed());
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
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='input-0-2-71 withIcon-0-2-72']")));
        driver.findElement(By.xpath("//input[@class='input-0-2-71 withIcon-0-2-72']")).click();
        driver.findElement(By.xpath("//input[@class='input-0-2-71 withIcon-0-2-72']")).sendKeys(Keys.ENTER);
        Assertions.assertTrue(driver.findElement(By.xpath("//div[@data-text='Поле «Пароль» должно быть заполнено']")).isDisplayed());
    }


    @AfterEach
    public void closePopup() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[d='M7.983 6.455l4.34-4.34a1.105 1.105 0 011.562 1.562l-4.34 4.34 4.34 4.34a1.08 1.08 0 11-1.528 1.528l-4.34-4.34-4.34 4.34a1.105 1.105 0 01-1.562-1.562l4.34-4.34-4.34-4.34a1.08 1.08 0 111.528-1.528l4.34 4.34z']")));
        driver.findElement(By.cssSelector("[d='M7.983 6.455l4.34-4.34a1.105 1.105 0 011.562 1.562l-4.34 4.34 4.34 4.34a1.08 1.08 0 11-1.528 1.528l-4.34-4.34-4.34 4.34a1.105 1.105 0 01-1.562-1.562l4.34-4.34-4.34-4.34a1.08 1.08 0 111.528-1.528l4.34 4.34z']")).click();
        driver.switchTo().defaultContent();
    }


    @AfterAll
    public static void close() {
        driver.close();
    }

}
