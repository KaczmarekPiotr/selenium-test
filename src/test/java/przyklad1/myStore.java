package przyklad1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.*;
import java.util.Random;

public class myStore {

    private WebDriver tescik;
    private String[] products = {"mug", "t-shirt", "sweater", "notebook", "poster", "graphics", "Cushion"}; //stworzenie tablicy z produktami
    Random random = new Random(); //tworzenie nowego obietku klasy random
    private int randomInteger = random.nextInt(7); //tworzenie zmiennej randomInteger ktora bedzie przyjmowac losowe wartosci

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        tescik = new ChromeDriver(); // otwarcie przegladarki google.com
        tescik.manage().window().maximize(); //zmaksymalizowanie okna
        tescik.get("https://prod-kurs.coderslab.pl"); //otworzenie strony sklepu internetowego
    }

    @Test
    public void testBingSearch() {
        WebElement element = tescik.findElement(By.name("s")); //znalezienie pola tekstowego wyszukiwania
        element.clear(); //wyczyszczenie pola tekstowego
        element.sendKeys(products[randomInteger]); //wpisanie jednego randomowego produktu z tablicy products
        element.submit(); //klikniecie szukaj
    }

    @After
    public void zakonczenie() {
        tescik.quit(); //zamkniecie przegladarki
    }

}


