package day06_notations_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C04_Assertions {
    static WebDriver driver;


    // Amazon anasayfaya gidin
    // 3 farkli test method'u olusturarak asagidaki gorevleri yapin
    // 1- Title'in Amazon icerdigini test edin
    // 2- Arama kutusuna "Nutella" yazip aratin ve sonucun Nutella icerdigini test edin
    // 3- Arama kutusuna "Java" yazip aratin ve sonucun "Java" icerdigini test edin

    /*
    ====== A C I K L A M A =======
    JUnit test method'lari icinde yapilan testlerin
    FAILED veyaPASSED oldugunu bize raporlar

    Ancak bu raporlama
    kodlar sorunsuz calisip bittiyse PASSED
    exception ile karsilasirsa FAILED olarak gerceklesir.

    Ayrica JUnit test method'lari icinde yapilan testleri degil
    method'lari raporlar

    JUnit bu is icin Assertion class'i olusturmustur

    Bir test methodunun icinde birden fazla assertion varsa
    bu assertion'lardan bir tanesi FAILED olursa
    kodun calismasi o satirda durur
    geriye kalan assertion'lar kontrol edilmemis olur

    Eger bir class calistiginda tum assertion'larin gözden gecirilmesini istiyorsak
    her assertion icin ayri test methodu olusturabiliriz.

    test methodlarinin ismi de
    yaptigi is ile uyumlu olursa
    konsolda neyin calisip neyin calismadigini kolayca görebiliriz

     */


    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://wwww.amazon.com");
    }

    @AfterClass
    public static void teardown() {
        driver.close();
    }

    @Test
    public void tittleTest() {
        // 1- Title'in Amazon icerdigini test edin
        String expextedTittleIcerik = "Amazon";
        String actuallTittle = driver.getTitle();

        Assert.assertTrue("Tittle Amazon icermiyor",actuallTittle.contains(expextedTittleIcerik));
        System.out.println("Bu satir test passed olursa calisir, failed olursa calismaz");
        //test passed oldugunda message kismi gösterilmez


    }

    @Test
    public void nutellaTest() {
        // 2- Arama kutusuna "Nutella" yazip aratin ve sonucun Nutella icerdigini test edin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.clear();
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        ReusableMethods.bekle(2);

        WebElement sonucYaziElementi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));

        String expectedSonucIcerik = "Kutella";
        String actualSonucYazisi = sonucYaziElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedSonucIcerik));

    }

    @Test
    public void javaTest() {
        // 3- Arama kutusuna "Java" yazip aratin ve sonucun "Java" icerdigini test edin

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.clear();
        aramaKutusu.sendKeys("Java" + Keys.ENTER);
        ReusableMethods.bekle(2);

        WebElement sonucYaziElementi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));

        String expectedSonucIcerik = "Hava";
        String actualSonucYazisi = sonucYaziElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedSonucIcerik));

    }
}
