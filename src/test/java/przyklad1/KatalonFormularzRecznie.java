package przyklad1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.*;

import java.util.List;
import java.util.Random;

public class KatalonFormularzRecznie {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver(); // otwarcie przegladarki google.com
        driver.manage().window().maximize(); //zmaksymalizowanie okna
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html"); //otworzenie strony z formularzem
    }

    @Test
    public void testKatalon() {
        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.clear();
        firstName.sendKeys("Zenek");
        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.clear();
        lastName.sendKeys("Martyniuk");
        List<WebElement> gender = driver.findElements(By.name("gender"));
        gender.get(0).click();
        WebElement date = driver.findElement(By.id("dob"));
        date.clear();
        date.sendKeys("05/22/2010");
        WebElement address = driver.findElement(By.name("address"));
        address.clear();
        address.sendKeys("Prosta 51");
        WebElement email = driver.findElement(By.id("email"));
        email.clear();
        email.sendKeys("zenek.martyniuk@mailinator.com");
        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys("Pass123");
        WebElement company = driver.findElement(By.id("company"));
        company.clear();
        company.sendKeys("Coders Lab");
        WebElement comment = driver.findElement(By.id("comment"));
        comment.clear();
        comment.sendKeys("Oddawaj piniondze za las");
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();



    }

    @After
    public void tearDown() throws Exception {
        // Zamknij przeglądarkę
       // driver.quit();
    }

}
