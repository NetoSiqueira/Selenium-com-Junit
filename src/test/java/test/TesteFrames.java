package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import static core.DriverFactory.getDriver;

public class TesteFrames {

   
    @Test
    public void TesteClicarBotoes() {

        getDriver().get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");

        getDriver().switchTo().frame("frame1");
        getDriver().findElement(By.id("frameButton")).click();
        Alert frame =  getDriver().switchTo().alert();
        String textoFrame = frame.getText();

        Assert.assertEquals("Frame OK!", textoFrame);
        frame.accept();

        getDriver().switchTo().defaultContent();
        getDriver().findElement(By.id("elementosForm:nome")).sendKeys(textoFrame);
    }
}
