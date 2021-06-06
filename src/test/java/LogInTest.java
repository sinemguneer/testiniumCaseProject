import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LogInTest {
    private static final Logger logger = LogManager.getLogger(LogInTest.class);

    WebDriver driver;

    @BeforeAll
    public void setUpDrivers() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.gittigidiyor.com/");
        driver.manage().window().maximize();
    }



    @Test
    public void logIn() {
        WebElement userNameLocator = driver.findElement(By.id("L-UserNameField"));
        userNameLocator.click();
        userNameLocator.sendKeys("sinemguner3@gmail.com");
        WebElement password = driver.findElement(By.id("L-PasswordField"));
        password.click();
        password.sendKeys("336BiN...");
        driver.findElement(By.id("gg-login-enter")).click();
        logger.trace("Login successful!");
    }

//    @AfterAll
//    public void quitDriver(){
//        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
//        driver.quit();
//    }


}