package test;

import base.DSL;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;

public class TestSincronismo {
    private DSL dsl;

    @Before
    public void inicializa(){
        getDriver().get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");
        dsl = new DSL();
    }

    @After
    public void fechar(){
        killDriver();
    }

    @Test
    public void deveUtilizarEsperaFixa() throws InterruptedException {
        dsl.clicar("buttonDelay");
        Thread.sleep(5000);
        dsl.escreve("novoCampo", "Deu certo");
    }

    @Test
    public void deveUtilizarEsperaImplicita() throws InterruptedException {
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        dsl.clicar("buttonDelay");
        dsl.escreve("novoCampo", "Deu certo");
        getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    @Test
    public void deveUtilizarEsperaExplicita() throws InterruptedException {
        dsl.clicar("buttonDelay");
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
        dsl.escreve("novoCampo", "Deu certo");

    }
}
