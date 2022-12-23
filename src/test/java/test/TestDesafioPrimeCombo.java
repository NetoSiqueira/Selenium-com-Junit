package test;

import base.DSL;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestDesafioPrimeCombo {
    private DSL dsl;
    private WebDriver driver;
    @Before
    public void inicializa() {
        WebDriverManager.chromedriver().setup();
        System.out.println("Comecamos aqui");
        driver = new ChromeDriver();
        driver.get(" https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml?jfwid=97b7c");
        dsl = new DSL(driver);

    }

    @Test
    public void selecionarComboPrime(){
        dsl.selecionaComboPrime("j_idt343","Option2");
        Assert.assertEquals("Option2", dsl.obterValorPorTexto(By.xpath("//*[@id ='j_idt343:option_label']")));
    }


}
