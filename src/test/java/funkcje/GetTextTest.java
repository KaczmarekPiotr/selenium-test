package funkcje;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver(); // otwarcie przegladarki google.com
        driver.manage().window().maximize(); //zmaksymalizowanie okna
    }

    @Test
    public void TestGetTextFunction() {
        driver.get("https://pl.wikipedia.org/");
        WebElement element = driver.findElement(By.id("main-page-column1"));
        System.out.println(element.getText());

    }

    @Test
    public void TestGetTextAttribute() {
        driver.get("https://pl.wikipedia.org/");
        String atrybut = driver.findElement(By.id("main-page-content")).getAttribute("class");
        System.out.println(atrybut);
    }


    @After
    public void tearDown() throws Exception {
         //Zamknij przeglądarkę
         driver.quit();
    }


}
