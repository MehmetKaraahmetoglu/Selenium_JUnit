package day07_assertions_checkBox;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C06_DropdownMenu extends TestBase {

    @Test
    public void test01(){

        driver.get("https://www.amazon.com");

        //1.Adim : dropdown webelementini locate et
        WebElement dropDownElementi = driver.findElement(By.xpath("//select[@title='Search in']"));

        //2.Adim: Locate ettigimiz webelementi parametre olarak yazip select objesi olustur
        Select select =new Select(dropDownElementi);

        //3.Adim select objesi ile istenen islemi yap
        select.selectByValue("search-alias=automotive-intl-ship");
        bekle(2);
        //HTML kodlari icinde ki her optionin valuesu ile ulasilabilir

        select.selectByIndex(7);
        bekle(2);
        //HTML kodlarinda drop box icinde ki menu isimlerinin indexi

        select.selectByVisibleText("Books");
        bekle(2);
        //HTML kodlari icindeki optionnlarin gorunen texti ile secilir

    }


}
