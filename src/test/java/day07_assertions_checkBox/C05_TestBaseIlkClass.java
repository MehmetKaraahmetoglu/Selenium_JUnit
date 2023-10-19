package day07_assertions_checkBox;

import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_TestBaseIlkClass extends TestBase {


    //utilities package icinde olusturdugumuz classlari buraya parent olarak atadik ve oradaki variable i proteced yaptik
    //boylece drivea direk ulasabiliyoruz.
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        bekle(3);

    }
}
