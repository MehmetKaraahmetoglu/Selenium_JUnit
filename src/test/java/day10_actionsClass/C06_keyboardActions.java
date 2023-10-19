package day10_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_keyboardActions extends TestBase {
    @Test
    public void test01(){
        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        bekle(2);

        //3- video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN);


        //4- videoyu izlemek icin Play tusuna basin
        //Once iframe'e gecis yapalim
        WebElement iframe= driver.findElement(By.xpath("//*[@*='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);

        WebElement playTusu=driver.findElement(By.xpath("//button[@aria-label='Oynat']"));
        playTusu.click();
        bekle(5);

        //5- videoyu calistirdiginizi test edin
        WebElement youtubeLogosu= driver.findElement(By.xpath("//*[@title=‘Watch on YouTube’]"));
        Assert.assertTrue(youtubeLogosu.isDisplayed());
        bekle(2);
    }
}
