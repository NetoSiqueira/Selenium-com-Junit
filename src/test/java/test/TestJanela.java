package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static core.DriverFactory.getDriver;

public class TestJanela {

   
    @Test
    public void TesteClicarPopUp() {
       
        getDriver().get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");

        getDriver().findElement(By.id("buttonPopUpEasy")).click();
        getDriver().switchTo().window("Popup");
        getDriver().findElement(By.tagName("textarea")).sendKeys("Deu certo");
        getDriver().close();
        getDriver().switchTo().window("");
        getDriver().findElement(By.tagName("textarea")).sendKeys("E agora");
     }
    @Test
    public void TesteClicarPopUpSemTitulo() {
       
        getDriver().get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");

        getDriver().findElement(By.id("buttonPopUpHard")).click();
        //Identificar o titulo/Id da janela A Primeira pega da principal a segunda das seguintes
//       System.out.println(getDriver().getWindowHandle());
//       System.out.println("oi");
//       System.out.println(getDriver().getWindowHandles());

        getDriver().switchTo().window((String) getDriver().getWindowHandles().toArray()[1]);
        getDriver().findElement(By.tagName("textarea")).sendKeys("deu bom");
        getDriver().switchTo().window((String) getDriver().getWindowHandles().toArray()[0]);
        getDriver().findElement(By.tagName("textarea")).sendKeys("otimo");
        getDriver().quit();
    }
}
