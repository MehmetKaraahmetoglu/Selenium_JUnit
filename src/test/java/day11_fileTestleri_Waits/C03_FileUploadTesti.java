package day11_fileTestleri_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_FileUploadTesti extends TestBase {
    @Test
    public void fileUploadTesti(){
        //1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //2.chooseFile butonuna basalim


        //text.txt dosyayi secelim.
        /*
        insan olarak dosya secimi icin
        chooseFile butonuna bastiktan sonra
        acilan windows dosya penceresinden
        istedigimiz dosyayi secip yükleriz

        Selenium'da otomasyon ile bu islemi yapmak icin
        chooseFile butonu locate edilip,
        bu webelement'e sendKeys(yüklenecekDosyaninDosyaYolu); yapilir
         */

        WebElement uploadButtonElementi = driver.findElement(By.id("file-upload"));
        String dinamikDosyaYolu=System.getProperty("user.dir")+
                "/src/test/java/day11_fileTestleri_Waits/text.txt";

        uploadButtonElementi.sendKeys(dinamikDosyaYolu);
        bekle(5);

        //4.Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        bekle(3);


        //5.“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUploadedElementi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedElementi.isDisplayed());

    }
}
