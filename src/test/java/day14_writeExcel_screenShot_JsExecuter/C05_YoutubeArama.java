package day14_writeExcel_screenShot_JsExecuter;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_YoutubeArama extends TestBase {
    @Test
    public void youtubeAramaTesti(){
        //youtube anasayfaya gidin
        driver.get("https://www.youtube.com");

        //cookies kabul edin
        driver.findElement(By.xpath("(//div[@class='yt-spec-touch-feedback-shape__fill'])[12]")).click();

        //mek_aquascaping icin arama yapin
        bekle(3);
        WebElement aramaKutusu=
                driver.findElement(By.xpath("//input[@id='search']"));
        aramaKutusu.click();
        bekle(1);
        aramaKutusu.sendKeys("mek_aquascaping"+ Keys.ENTER);

        //bulunan videolardan ilkinin isminde kutu isminin gectigini test edin
        String expectedVideoAdi="kutu";
        WebElement actualVideoAdiYolu=
                driver.findElement(By.xpath("(//h3[@class='title-and-badge style-scope ytd-video-renderer'])[1]"));
        String actualVideoAdi=actualVideoAdiYolu.getText();
        Assert.assertTrue(actualVideoAdi.contains(expectedVideoAdi));

        //ilk video isminin fotografini cekin
        ReusableMethods.webElementFotografCek(actualVideoAdiYolu,"mek_aquascaping");
    }
}
