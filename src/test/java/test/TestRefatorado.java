package test;

import base.DSL;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRefatorado {

    private DSL dsl;
    private  WebDriver driver;

    @Before
    public void inicializa(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");
        dsl = new DSL(driver);
    }

    @After
    public void fechar(){
        driver.quit();
    }


    @Test
    public void TestAreaRefatorado(){
        dsl.escreve("elementosForm:sugestoes", "teste");
        Assertions.assertEquals("teste", dsl.obterValor("elementosForm:sugestoes"));

        dsl.clicar("elementosForm:comidaFavorita:2");
        Assertions.assertTrue(dsl.verificarBotaoClicado("elementosForm:comidaFavorita:2"));

        dsl.selecionarCombo("elementosForm:escolaridade", "2o grau completo");
        Assertions.assertEquals("2o grau completo", dsl.obterValorCombo("elementosForm:escolaridade"));

        dsl.clicarLink("Voltar");
        Assertions.assertEquals("Voltou!", dsl.obterValorPorTexto(By.id("Voltar")));

    }






}
