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

public class TestSincronismo {
    private DSL dsl;
    private WebDriver driver;
    @Before
    public void inicializa(){
        WebDriverManager.chromedriver().setup();
        System.out.println("Comecamos aqui");
        driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");
        dsl = new DSL(driver);
    }

    @After
    public void fechar(){
        driver.quit();
    }

    @Test
    public void deveUtilizarEsperaFixa() throws InterruptedException {
        dsl.clicar("buttonDelay");
        Thread.sleep(5000);
        dsl.escreve("novoCampo", "Deu certo");
    }

    @Test
    public void deveUtilizarEsperaImplicita() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        dsl.clicar("buttonDelay");
        dsl.escreve("novoCampo", "Deu certo");
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    @Test
    public void deveUtilizarEsperaExplicita() throws InterruptedException {
        dsl.clicar("buttonDelay");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
        dsl.escreve("novoCampo", "Deu certo");

    }
}
