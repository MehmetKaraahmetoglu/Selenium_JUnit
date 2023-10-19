package day11_fileTestleri_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_fileDownload extends TestBase {
    @Test
    public void indirmeTesi(){
        //    C:\Users\mek_m\OneDrive\Masaüstü\Selenium/logo.jpg

        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        bekle(2);

        //3. logo.jpg dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='logo.jpg']")).click();
        bekle(3);

        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu= "C:\\Users\\mek_m\\Downloads\\logo.jpg";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
