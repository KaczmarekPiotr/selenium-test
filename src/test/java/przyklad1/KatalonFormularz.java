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

public class KatalonFormularz {
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
    public void testKatalonFormularz() throws Exception {
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
        // ERROR: Caught exception [ERROR: Unsupported command [loadVars | dane.csv | ]]
        driver.findElement(By.id("first-name")).click();
        System.out.println("wpisz imie : Karol");
        driver.findElement(By.id("first-name")).clear();
        driver.findElement(By.id("first-name")).sendKeys("${imie}");
        // ERROR: Caught exception [ERROR: Unsupported command [captureEntirePageScreenshot |  | ]]
        driver.findElement(By.id("last-name")).click();
        System.out.println("wpisz nazwisko : Kowalski");
        driver.findElement(By.id("last-name")).clear();
        driver.findElement(By.id("last-name")).sendKeys("${nazwisko}");
        // ERROR: Caught exception [ERROR: Unsupported command [captureEntirePageScreenshot |  | ]]
        driver.findElement(By.xpath("//form[@id='infoForm']/div[3]/div/div/label")).click();
        driver.findElement(By.id("dob")).click();
        driver.findElement(By.id("dob")).clear();
        driver.findElement(By.id("dob")).sendKeys("05/22/2010");
        // ERROR: Caught exception [ERROR: Unsupported command [captureEntirePageScreenshot |  | ]]
        driver.findElement(By.id("address")).click();
        System.out.println("wpisz adres : Prosta 51");
        driver.findElement(By.id("address")).clear();
        driver.findElement(By.id("address")).sendKeys("Prosta 51");
        // ERROR: Caught exception [ERROR: Unsupported command [captureEntirePageScreenshot |  | ]]
        driver.findElement(By.id("email")).click();
        System.out.println("wpisz e mail : karol.kowalski@mailinator.com");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("${email}");
        // ERROR: Caught exception [ERROR: Unsupported command [captureEntirePageScreenshot |  | ]]
        System.out.println("Wpisz haslo : Pass123");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Pass123");
        // ERROR: Caught exception [ERROR: Unsupported command [captureEntirePageScreenshot |  | ]]
        driver.findElement(By.id("company")).clear();
        driver.findElement(By.id("company")).sendKeys("CodersLab");
        // ERROR: Caught exception [ERROR: Unsupported command [captureEntirePageScreenshot |  | ]]
        new Select(driver.findElement(By.id("role"))).selectByVisibleText("Manager");
        driver.findElement(By.id("role")).click();
        new Select(driver.findElement(By.id("role"))).selectByVisibleText("QA");
        driver.findElement(By.id("role")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [addSelection | id=expectation | label=Challenging]]
        driver.findElement(By.xpath("//select[@id='expectation']/option[6]")).click();
        driver.findElement(By.xpath("//form[@id='infoForm']/div[11]/div/div/label")).click();
        driver.findElement(By.xpath("//form[@id='infoForm']/div[11]/div/div[2]/label")).click();
        driver.findElement(By.id("comment")).click();
        driver.findElement(By.id("comment")).clear();
        driver.findElement(By.id("comment")).sendKeys("To moj pierwszy automat testowy");
        // ERROR: Caught exception [ERROR: Unsupported command [captureEntirePageScreenshot |  | ]]
        driver.findElement(By.id("submit")).click();
        assertEquals("Successfully submitted!", driver.findElement(By.id("submit-msg")).getText());
        // ERROR: Caught exception [ERROR: Unsupported command [endLoadVars |  | ]]
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
