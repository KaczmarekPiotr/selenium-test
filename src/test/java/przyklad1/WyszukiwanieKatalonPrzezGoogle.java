package przyklad1;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class WyszukiwanieKatalonPrzezGoogle {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testWyszukiwanieKatalonPrzezGoogle() throws Exception {
        System.out.println("Otwieramy strone : google.com");
        driver.get("https://www.google.pl/");
        // ERROR: Caught exception [ERROR: Unsupported command [captureEntirePageScreenshot |  | ]]
        System.out.println("Klikamy w okno dialogowe");
        driver.findElement(By.name("q")).click();
        System.out.println("Wpisujemy i wyszukujemy : Selenium");
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("Selenium");
        // ERROR: Caught exception [ERROR: Unsupported command [captureEntirePageScreenshot |  | ]]
        driver.findElement(By.name("btnK")).click();
        try {
            assertEquals("Selenium (software) - Wikipedia", driver.findElement(By.xpath("//div[@id='rso']/div/div/div[3]/div/div/div/a/h3")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // ERROR: Caught exception [ERROR: Unsupported command [captureEntirePageScreenshot |  | ]]
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
