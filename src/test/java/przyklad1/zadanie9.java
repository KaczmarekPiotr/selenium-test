package przyklad1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.*;

public class zadanie9 {

    private WebDriver tescik;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        tescik = new ChromeDriver(); // otwarcie przegladarki google.com
        tescik.manage().window().maximize(); //zmaksymalizowanie okna
        tescik.get("http://www.bing.com"); //otworzenie strony www.bing.com
    }

    @Test
    public void testBingSearch() {
        WebElement element = tescik.findElement(By.name("q")); //znalezienie pola tekstowego wyszukiwania
        element.clear(); //wyczyszczenie pola tekstowego
        element.sendKeys("Mistrzostwa Swiata w pilce noznej 2018"); //wpisanie danej frazy do pola tekstowego
        element.submit(); //klikniecie szukaj
    }

    @After
    public void zakonczenie() {
        tescik.quit(); //zamkniecie przegladarki
    }

}
