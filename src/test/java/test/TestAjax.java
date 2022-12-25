package test;

import base.DSL;
import core.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;

public class TestAjax {
    private DSL dsl;

    @Before
    public void inicializa(){
      getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml?jfwid=29e88");
        dsl = new DSL();
    }

    @After
    public void fechar(){
        killDriver();
    }

    @Test
    public void testAjax(){
        dsl.escreve("j_idt343:name", "test");
        dsl.clicar(By.id("j_idt343:j_idt347"));
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.textToBe(By.id("j_idt343:display"), "test"));
        Assert.assertEquals("test", dsl.obterValorPorTexto(By.id("j_idt343:display")));
    }
}
