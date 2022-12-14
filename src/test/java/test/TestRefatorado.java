package test;

import core.BasePage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;


import static core.DriverFactory.getDriver;

public class TestRefatorado extends BasePage {



    @Test
    public void TestAreaRefatorado(){
        dsl.escreve("elementosForm:sugestoes", "teste");
        Assertions.assertEquals("teste", dsl.obterValor("elementosForm:sugestoes"));

        dsl.clicar("elementosForm:comidaFavorita:2");
        Assertions.assertTrue(dsl.verificarBotaoClicado("elementosForm:comidaFavorita:2"));

        dsl.selecionarCombo("elementosForm:escolaridade", "2o grau completo");
        Assertions.assertEquals("2o grau completo", dsl.obterValorCombo("elementosForm:escolaridade"));

        dsl.clicarLink("Voltar");
        Assertions.assertEquals("Voltou!", dsl.obterValorPorTexto(By.id("resultado")));

    }

    @Before
    public void inicializa(){
        getDriver().get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");
    }


    @Test
    public void ClicarNobotaoTabela(){
        dsl.clicarBotaoTabela("Nome","Maria","Botao");
        Alert alert  = getDriver().switchTo().alert();

        String texto =  alert.getText();
        Assert.assertEquals("Maria", texto);
    }

}
