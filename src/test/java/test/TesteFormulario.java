package test;

import core.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static core.DriverFactory.getDriver;

public class TesteFormulario extends BasePage {


    @Test
    public void testeFormulario(){
       
//        getDriver().manage().window().setSize(new Dimension(1200,765));
        getDriver().get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");
        getDriver().findElement(By.id("elementosForm:nome")).sendKeys("Siqueira");
        Assert.assertEquals("Siqueira", getDriver().findElement(By.id("elementosForm:nome")).getAttribute("value"));
        getDriver().quit();

    }


    @Test
    public void TesteAreas(){
       
        getDriver().get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");
        getDriver().findElement(By.id("elementosForm:sugestoes")).sendKeys("teste");
        Assert.assertEquals("teste",getDriver().findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
        getDriver().quit();
    }

    @Test
    public void TesteRadioButton(){
       
        getDriver().get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");
        getDriver().findElement(By.id("elementosForm:sexo:0")).click();
        Assert.assertTrue(getDriver().findElement(By.id("elementosForm:sexo:0")).isSelected());
        getDriver().quit();
    }

    @Test
    public void TesteCheckbox(){
       
        getDriver().get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");
        getDriver().findElement(By.id("elementosForm:comidaFavorita:1")).click();
        Assert.assertTrue(getDriver().findElement(By.id("elementosForm:comidaFavorita:1")).isSelected());
        getDriver().quit();
    }

    @Test
    public void TesteCombo(){

            getDriver().get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");
            WebElement element = getDriver().findElement(By.id("elementosForm:escolaridade"));
            Select combo = new Select(element);
//            combo.selectByIndex(2);
//            combo.selectByValue("superior");
            combo.selectByVisibleText("Mestrado");
            Assert.assertEquals( "Mestrado", combo.getFirstSelectedOption().getText());
    }
    @Test
    public void TesteVerificarValoresCombo() {
       
        getDriver().get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");
        WebElement element = getDriver().findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);

        //getOptions cria uma lista;
       List<WebElement> options =  combo.getOptions();
       Assert.assertEquals(8, options.size());

       boolean achado = false;

        for (WebElement option: options) {
            if (option.getText().equals("Mestrado")){
                achado = true;
                break;
            }
        }
        Assert.assertTrue(achado);
    }

    @Test
    public void TesteVerificarValoresComboMultiplo() {
       
        getDriver().get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");
        WebElement element = getDriver().findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);

        combo.selectByVisibleText("Natacao");
        combo.selectByVisibleText("Corrida");
        combo.selectByVisibleText("O que eh esporte?");

        //Lista de element selecionados
        List<WebElement> listCombo =   combo.getAllSelectedOptions();
        Assert.assertEquals(3, listCombo.size());


        combo.deselectByVisibleText("Corrida");
        listCombo =   combo.getAllSelectedOptions();
        Assert.assertEquals(2, listCombo.size());
        getDriver().quit();
    }

    @Test
    public void TesteClicarBotoes() {
       
        getDriver().get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");

        WebElement botao = getDriver().findElement(By.id("buttonSimple"));
        botao.click();
        Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
        getDriver().quit();
    }

    @Test
    public void TesteComLinks() {
       
        getDriver().get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");

        getDriver().findElement(By.linkText("Voltar")).click();

        Assert.assertEquals("Voltou!", getDriver().findElement(By.id("resultado")).getText());
        getDriver().quit();
    }

    @Test
    public void TesteTextoNaPagina() {
       
        getDriver().get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");

//        //VERIFICAR SE O TEXTO QUE TIVER NO BODY ELE EXISTE
//        Assert.assertTrue(getDriver().findElement(By.tagName("body"))
//                .getText().contains("Campo de Treinamento"));
        Assert.assertEquals("Campo de Treinamento", getDriver().findElement(By.tagName("h3")).getText());
        Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
                getDriver().findElement(By.className("facilAchar")).getText());

    }



}
