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

import static core.DriverFactory.getDriver;

public class TestUsandoPage {
   

    private TestPage cadastropage;

    @Before
    public void inicializa(){

        getDriver().get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");
       cadastropage = new TestPage();

    }

    @After
    public void fechar(){
        getDriver().quit();
    }

    @Test
    public void TesteAlertPronmpt() {

        //Cadastro
        cadastropage.setNome("Siqueira");
        cadastropage.setSobrenome("Neto");
        cadastropage.setSexo("M");
        cadastropage.setComidaFavorita("Frango");
        cadastropage.setEscolaridade("Superior");
        cadastropage.setEsporte("Natacao");
        cadastropage.Cadastrar();
        //Teste verificar que inicia com Cadastrado
         Assert.assertEquals("Cadastrado!",cadastropage.obterResultadoCadastro());


        //Teste verficar que terminar com Siqueira
        Assert.assertEquals("Siqueira",cadastropage.obterResultadoNome());
    }

}
