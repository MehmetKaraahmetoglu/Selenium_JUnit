package day14_writeExcel_screenShot_JsExecuter;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_GetScreenshotTumSayfa extends TestBase {
    @Test
    public void tumSayfaScreenshot() throws IOException {
        //Amazon ana sayfaya gidin
        driver.get("https://www.amazon.com");

        //Nutella icin arama yapin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //Sonuclarin Nutella icerdigini test edin
        WebElement sonucYaziElementi=
                driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedIcerik="Nutella";
        String actualSonucYazisi=sonucYaziElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));


        //Rapor icin sayfanin fotografini cekin
        bekle(5);

        //1.adim TakeScreenshot objesi olusturalim
        TakesScreenshot tss=(TakesScreenshot) driver; //casting yaparak kabul ettiriyoruz

        //2.adim, fotografi kaydedecegimiz dosyayi olusturalim, dosya yolunu yazalim
        File tumSayfaScreenshot=new File("target/screenShots/tumSayfaScreenshot.png"); //dosya yolu jpeg, png vs olabilir

        //3.adim, bir gecici dosya olusturup bunatss objesi ile cektigimiz fotografi kaydedelim
        File geciciResim=tss.getScreenshotAs(OutputType.FILE);

        //4.adim, gecici resmi asil dosyaya kopyalayalim
        FileUtils.copyFile(geciciResim,tumSayfaScreenshot);
    }
}
