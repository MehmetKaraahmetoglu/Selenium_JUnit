package day13_excelOtomasyonu;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C01_ReadExcel {
    @Test
    public void readExcelTestleri() throws IOException {
        String dosyaYolu= "src/test/java/day13_excelOtomasyonu/ulkeler.xlsx";

        FileInputStream fis =new FileInputStream(dosyaYolu); //kirmizi cizdi, ya okuyamazsam...okursun diyerek kabul ettirdik
        Workbook workbook= WorkbookFactory.create(fis); //yine kirmizi cizdi kabul ettik ve sorun cozuldu
        // olusturdugumuz workbook, online olarak excel dosyasina erismez
        // 16.satirda fileInputStream kullanarak Excel'De ki bilgileri aldik
        // 17. satirda fis'in aldigi bilgileri kullanarak kodlarimizin icinde
        // fiziki excel dosyasinin bir kopyasini olusturduk.

        Sheet sheet= workbook.getSheet("Sayfa1");
        Row row =sheet.getRow(3); //index
        Cell cell=row.getCell(3); //index
        //3. satirin 3.ü sütunu
        //index oldugu icin 0 dan baslar
        System.out.println(cell);

        // - 1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(sheet.getRow(0).getCell(1)); //Başkent (İngilizce)

        // - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String istenenData=sheet.getRow(0).getCell(1).toString();
        System.out.println(istenenData); //Başkent (İngilizce)

        // - 2.satir 4.cell’in afganistan’in baskenti Kabil oldugunu test edelim
        String expectedData ="Kabil";
        String actualData=sheet.getRow(1).getCell(3).toString();

        Assert.assertEquals(expectedData,actualData);

        // - Satir sayisini bulalim
        System.out.println(sheet.getLastRowNum()+1); //190 son satirin indexini verir, satir sayisi icin +1

        // - Fiziki olarak kullanilan satir sayisini bulun
        System.out.println(sheet.getPhysicalNumberOfRows()); //direk fiziki olarak kullanilan satir sayisini yazdirir,
        // 191

        // - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        String isim;
        String baskent;
        Map<String,String> ulkelerMap=new TreeMap<>();
        for (int i = 1; i <=sheet.getLastRowNum() ; i++) {
            isim=sheet.getRow(i).getCell(0).toString();
            baskent=sheet.getRow(i).getCell(1).toString();
            ulkelerMap.put(isim,baskent);
        }

        //Ulkeler excel'inde Canada isimli bir ulke oldugunu test edin
        Assert.assertTrue(ulkelerMap.containsKey("Canada"));

        //Ulkeler excelinde Cuba'nin baskentinin Havana oldugunu test edin
        String expectedBaskent="Havana";
        String actualBaskent =ulkelerMap.get("Cuba");

        Assert.assertEquals(expectedBaskent,actualBaskent);


    }
}
