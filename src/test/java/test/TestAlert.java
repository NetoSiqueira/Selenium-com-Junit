package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static core.DriverFactory.getDriver;

public class TestAlert {

    private WebDriver driver ;

    @Test
    public void TesteAlertSimples() {
       
        getDriver().get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");

        getDriver().findElement(By.id("alert")).click();

        //Mudar o foco do navegador para o Alert
      Alert alert = getDriver().switchTo().alert();
      String texto = alert.getText();
      Assert.assertEquals("Alert Simples", texto);
      alert.accept();
      getDriver().findElement(By.id("elementosForm:nome")).sendKeys(texto);
      getDriver().quit();
    }

    @Test
    public void TesteAlertConfirm() {
       
        getDriver().get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");

        // teste confirmado
        getDriver().findElement(By.id("confirm")).click();
        Alert alert = getDriver().switchTo().alert();
        Assert.assertEquals("Confirm Simples", alert.getText());
        alert.accept();
        Assert.assertEquals("Confirmado", alert.getText());
        alert.accept();

        //teste cancelado
        getDriver().findElement(By.id("confirm")).click();
        alert = getDriver().switchTo().alert();
        Assert.assertEquals("Confirm Simples", alert.getText());
        alert.dismiss();
        Assert.assertEquals("Negado", alert.getText());
        alert.dismiss();
    }
    @Test
    public void TesteAlertPronmpt() {
       
        getDriver().get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");

        getDriver().findElement(By.id("prompt")).click();
        Alert alert = getDriver().switchTo().alert();

        Assert.assertEquals("Digite um numero", alert.getText());
        alert.sendKeys("12");
        alert.accept();
        String numero = alert.getText();
        Assert.assertEquals(numero,alert.getText());
        alert.accept();
        Assert.assertEquals(":D", alert.getText());
        alert.accept();

    }
}
