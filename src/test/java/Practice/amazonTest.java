package Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Arrays;

public class amazonTest extends TestBase{

    @Test
    public void amazonTest(){
        driver.get("https://www.amazon.com");
        bekle(2);
        WebElement aramaButonu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaButonu.click();
        aramaButonu.sendKeys("macbook"+ Keys.ENTER);

        String aramaSonucu=driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]")).getText();
        System.out.println(aramaSonucu);

        String[] aramasonucuArr=aramaSonucu.split(" ");
        System.out.println(Arrays.toString(aramasonucuArr));

        int aramaSonucuInt=Integer.parseInt(aramasonucuArr[2]);

        Assert.assertTrue("Arama sonucu 100'den az",aramaSonucuInt>1000);
    }


}
