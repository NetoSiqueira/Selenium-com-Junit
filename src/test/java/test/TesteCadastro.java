package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCadastro {

    private WebDriver driver;

    @Test
    public void TesteAlertPronmpt() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");

        //Cadastro
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Siqueira");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Neto");
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
        WebElement element =  driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
        combo.selectByVisibleText("Superior");
        element = driver.findElement(By.id("elementosForm:esportes"));
        combo = new Select(element);
        combo.selectByVisibleText("Natacao");
        driver.findElement(By.id("elementosForm:cadastrar")).click();

        //Teste verificar que inicia com Cadastrado
        Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));


        //Teste verficar que terminar com Siqueira
        Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Siqueira"));

    }
}
