package day10_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C01_sagClick extends TestBase {
    @Test
    public void test01(){
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapin
        WebElement ciziAlanElementi = driver.findElement(By.id("hot-spot"));

        Actions actions = new Actions(driver); //ilk adim actiondan obje olusturmak
        actions.contextClick(ciziAlanElementi).perform(); //sag tikladik


        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedAlertYazi = "You selected a context menu";
        String actualAlertYasisi = driver.switchTo().alert().getText();

        Assert.assertEquals(expectedAlertYazi,actualAlertYasisi);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        String ilkSayfaWhd = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        bekle(2);
        String ikinciSayfaWhd = "";
        Set<String> whdSeti = driver.getWindowHandles();
        for (String each : whdSeti
        ) {
            if (!each.equals(ilkSayfaWhd)){
                ikinciSayfaWhd = each;
            }
        }
        //7- Acilan sayfada h1 taginda “Make sure your code lands” yazdigini test edelim
        driver.switchTo().window(ikinciSayfaWhd);
        String expectedYazi = "Make sure your code lands";
        String actualYazi = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(expectedYazi,actualYazi);
    }
}














