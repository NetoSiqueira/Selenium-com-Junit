package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static core.DriverFactory.getDriver;

public class TesteCadastro {



    @Test
    public void TesteAlertPronmpt() {
       
        getDriver().get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");

        //Cadastro
        getDriver().findElement(By.id("elementosForm:nome")).sendKeys("Siqueira");
        getDriver().findElement(By.id("elementosForm:sobrenome")).sendKeys("Neto");
        getDriver().findElement(By.id("elementosForm:sexo:0")).click();
        getDriver().findElement(By.id("elementosForm:comidaFavorita:1")).click();
        WebElement element =  getDriver().findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
        combo.selectByVisibleText("Superior");
        element = getDriver().findElement(By.id("elementosForm:esportes"));
        combo = new Select(element);
        combo.selectByVisibleText("Natacao");
        getDriver().findElement(By.id("elementosForm:cadastrar")).click();

        //Teste verificar que inicia com Cadastrado
        Assert.assertTrue(getDriver().findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));


        //Teste verficar que terminar com Siqueira
        Assert.assertTrue(getDriver().findElement(By.id("descNome")).getText().endsWith("Siqueira"));

    }
}
