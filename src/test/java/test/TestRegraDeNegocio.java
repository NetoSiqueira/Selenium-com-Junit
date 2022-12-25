package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static core.DriverFactory.getDriver;

public class TestRegraDeNegocio {

       @Test
    public void TesteNomeObrigatorio() {
       
        getDriver().get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");

        getDriver().findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = getDriver().switchTo().alert();
        Assert.assertEquals("Nome eh obrigatorio", alert.getText());
        getDriver().quit();

    }

    @Test
    public void TesteSobrenomeObrigatorio() {
       
        getDriver().get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");

        getDriver().findElement(By.id("elementosForm:nome")).sendKeys("Neto");

        getDriver().findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = getDriver().switchTo().alert();
        Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
        getDriver().quit();

    }

    @Test
    public void TesteSexoObrigatorio() {
       
        getDriver().get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");

        getDriver().findElement(By.id("elementosForm:nome")).sendKeys("Neto");
        getDriver().findElement(By.id("elementosForm:sobrenome")).sendKeys("Siqueira");
        getDriver().findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = getDriver().switchTo().alert();
        Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
        getDriver().quit();
    }

    @Test
    public void TesteComidaObrigatorio() {
       
        getDriver().get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");

        getDriver().findElement(By.id("elementosForm:nome")).sendKeys("Neto");
        getDriver().findElement(By.id("elementosForm:sobrenome")).sendKeys("Siqueira");
        getDriver().findElement(By.id("elementosForm:sexo:0")).click();
        getDriver().findElement(By.id("elementosForm:comidaFavorita:0")).click();
        getDriver().findElement(By.id("elementosForm:comidaFavorita:3")).click();
        getDriver().findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = getDriver().switchTo().alert();
        Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
        getDriver().quit();
    }

    @Test
    public void TesteEsporteObrigatorio() {
       
        getDriver().get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");

        getDriver().findElement(By.id("elementosForm:nome")).sendKeys("Neto");
        getDriver().findElement(By.id("elementosForm:sobrenome")).sendKeys("Siqueira");
        getDriver().findElement(By.id("elementosForm:sexo:0")).click();
        getDriver().findElement(By.id("elementosForm:comidaFavorita:0")).click();
        Select combo = new Select(getDriver().findElement(By.id("elementosForm:esportes")));
        combo.selectByVisibleText("Karate");
        combo.selectByVisibleText("O que eh esporte?");
        getDriver().findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = getDriver().switchTo().alert();
        Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());
        getDriver().quit();
    }
}
