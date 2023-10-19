package TeamArbeit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01 extends TestBase {
    @Test

    public void nutellaTest() {

        //2- https://www.google.com/ adresine gidin
        //3- cookies uyarisini kabul ederek kapatin
        //4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        //5- Arama cubuguna “Nutella” yazip aratin
        //6- Bulunan sonuc sayisini yazdirin
        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        //8- Sayfayi kapatin


        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        ReusableMethods.bekle(4);

        //3- cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("(//div[@class ='QS5gu sy4vM'])[2]")).click();
        //driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click(); copyXpath'li cozum

        //4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        String expectedTittle = "Google";
        String actuallTitle = driver.getTitle();
        if (actuallTitle.contains(expectedTittle)) {
            System.out.println("Tittle test is PASSED");
        } else {
            System.out.println("Tittle test is FAILED");
        }

        //5- Arama cubuguna “Nutella” yazip arati
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@jsname='yZiJbe']")); //Xpathli cozum
        //WebElement searchBox = driver.findElement(By.id("APjFqb")); //id'li cozum
        searchBox.click();
        searchBox.sendKeys("Nutella" + Keys.ENTER);
        //6- Bulunan sonuc sayisini yazdirin
        WebElement result = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println("Sonuc: " + result.getText());
        //Sonuc: Yaklaşık 153.000.000 sonuç bulundu (0,30 saniye)

        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String sonuc = result.getText();
        //Yaklaşık 153.000.000 sonuç bulundu (0,30 saniye)
        String[] sonucArr = sonuc.split(" ");
        String sonucSayisi = sonucArr[1];
        sonucSayisi = sonucSayisi.replace(".", "");
        System.out.println(sonucSayisi); //15300000
        int sonucSayisiInt = Integer.parseInt(sonucSayisi);
        int expectedNumber = 10000000;

        Assert.assertTrue(sonucSayisiInt > expectedNumber);

        // if (sonucNumaraInt > expectedNumber) {
        //     System.out.println("10 milyon testi PASSED");
        // } else {
        //     System.out.println("10 milyon testi FAILED");

        //8- Sayfayi kapatin
        // ReusableMethods.bekle(2);
        bekle(2);
        //extends ettigimiz TestBase icinde kapattigi icin ekstra kod yazmadim
    }

}






