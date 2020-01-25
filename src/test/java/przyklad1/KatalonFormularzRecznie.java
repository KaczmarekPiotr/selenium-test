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
        if ( firstName.isEnabled()) {
            firstName.clear();
            firstName.sendKeys("Zenek");
            System.out.println("Nazwa pola : " + firstName.getAttribute("name"));
        } else {
            Assert.fail();
        }

        WebElement lastName = driver.findElement(By.id("last-name"));
        if ( lastName.isEnabled()) {
            lastName.clear();
            lastName.sendKeys("Martyniuk");
            System.out.println("Nazwa pola : " + lastName.getAttribute("name"));
        } else {
            Assert.fail();
        }

        List<WebElement> gender = driver.findElements(By.name("gender"));
        if ( gender.isEmpty()) {
            gender.get(0).click();
        } else {
            gender.get(0).click();
        }

        WebElement date = driver.findElement(By.id("dob"));
        if ( date.isEnabled()) {
            date.clear();
            date.sendKeys("05/22/2010");
            System.out.println("Nazwa pola : " + date.getAttribute("name"));
        } else {
            Assert.fail();
        }

        WebElement address = driver.findElement(By.name("address"));
        if ( address.isEnabled()) {
            address.clear();
            address.sendKeys("Prosta 51");
            System.out.println("Nazwa pola : " + address.getAttribute("name"));
        } else {
            Assert.fail();
        }

        WebElement email = driver.findElement(By.id("email"));
        if ( email.isEnabled()) {
            email.clear();
            email.sendKeys("zenek.martyniuk@mailinator.com");
            System.out.println("Nazwa pola : " + email.getAttribute("name"));
        } else {
            Assert.fail();
        }

        WebElement password = driver.findElement(By.id("password"));
        if ( password.isEnabled()) {
            password.clear();
            password.sendKeys("Pass123");
            System.out.println("Nazwa pola : " + password.getAttribute("name"));
        } else {
            Assert.fail();
        }

        WebElement company = driver.findElement(By.id("company"));
        if ( company.isEnabled()) {
            company.clear();
            company.sendKeys("Coders Lab");
            System.out.println("Nazwa pola : " + company.getAttribute("name"));
        } else {
            Assert.fail();
        }

        WebElement comment = driver.findElement(By.id("comment"));
        if ( comment.isEnabled()) {
            comment.clear();
            comment.sendKeys("Oddawaj piniondze za las");
            System.out.println("Nazwa pola : " + comment.getAttribute("name"));
        } else {
            Assert.fail();
        }

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();


    }

    @After
    public void tearDown() throws Exception {
        // Zamknij przeglądarkę
       // driver.quit();
    }

}
