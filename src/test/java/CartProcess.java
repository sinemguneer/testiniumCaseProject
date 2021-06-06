import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CartProcess {
    private static final Logger logger = LogManager.getLogger(CartProcess.class);
    WebDriver driver;

    @BeforeAll
    public void setUpDrivers() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.gittigidiyor.com/");
        driver.manage().window().maximize();

    }

    @Test
    public void productSearch() {
        WebElement searchBox = driver.findElement(By.className("sc-4995aq-4 dNPmGY"));
        searchBox.click();
        searchBox.sendKeys("bilgisayar");
        driver.findElement(By.className("qjixn8-0 sc-1bydi5r-0 hKfdXF")).click();
        logger.trace("SearchBox used for 'bilgisayar' word!");

        driver.findElement(By.linkText("https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2")).click();
        driver.findElement(By.className("product-title ")).click();
        logger.trace("Moved to page 2!");

        WebElement addToCart = driver.findElement(By.id("add-to-basket"));
        addToCart.click();
        logger.trace("Product adding to cart!");

        WebElement goToCart = driver.findElement(By.linkText("https://www.gittigidiyor.com/sepetim"));
        logger.trace("Move to cart!");

        WebElement priceInCart = driver.findElement(By.id("cart-total-price"));
        WebElement price = driver.findElement(By.id("sp-price-lowPrice"));

        if (price == priceInCart) {
            logger.trace("The price in the cart and the product price are equal!");

        }


        driver.findElement(By.className("btn-delete btn-update-item")).click();
        logger.trace("The cart is empty!");

    }

        @AfterAll
        public void quitDriver(){
            driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
            driver.quit();




        }






}
