package test;

import base.DSL;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static core.DriverFactory.getDriver;

public class TestPrime {
    private DSL dsl;

    @Before
    public void inicializa(){

        getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml?jfwid=7e7c5");
        dsl = new DSL();


    }

    @Test
    public void interagircomRadioPrime(){
        dsl.clicar(By.xpath("//*[@id='j_idt344:console:0']/../..//span"));
        Assert.assertTrue(dsl.verificarBotaoClicado("j_idt344:console:0"));
        dsl.clicar(By.xpath("//label[.='Option2']/..//span"));
        Assert.assertTrue(dsl.verificarBotaoClicado("j_idt344:console:1"));
    }


}
