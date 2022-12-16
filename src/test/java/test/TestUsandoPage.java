package test;

import base.DSL;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import page.TestPage;

import java.util.PrimitiveIterator;

public class TestUsandoPage {
    private WebDriver driver;


    private TestPage cadastropage;

    @Before
    public void inicializa(){
        WebDriverManager.chromedriver().setup();
        System.out.println("Comecamos aqui");
        driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");
       cadastropage = new TestPage(driver);

    }

    @After
    public void fechar(){
        driver.quit();
    }

    @Test
    public void TesteAlertPronmpt() {

        //Cadastro
        cadastropage.setNome("Siqueira");
        cadastropage.setSobrenome("Neto");
        cadastropage.setSexoMasculino();
        cadastropage.setComidaFavorita();
        cadastropage.setEscolaridade("Superior");
        cadastropage.setEsporte("Natacao");
        cadastropage.Cadastrar();
        //Teste verificar que inicia com Cadastrado
        Assert.assertTrue(cadastropage.obterResultadoCadastro().startsWith("Cadastrado!"));


        //Teste verficar que terminar com Siqueira
        Assert.assertTrue(cadastropage.obterResultadoNome().endsWith("Siqueira"));
    }

}
