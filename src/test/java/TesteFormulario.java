import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TesteFormulario {
  private   WebDriver driver ;

    @Test
    public void testeFormulario(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        driver.manage().window().setSize(new Dimension(1200,765));
        driver.get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Siqueira");
        Assert.assertEquals("Siqueira", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
        driver.quit();

    }


    @Test
    public void TesteAreas(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste");
        Assert.assertEquals("teste",driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
        driver.quit();
    }

    @Test
    public void TesteRadioButton(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
        driver.quit();
    }

    @Test
    public void TesteCheckbox(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");
        driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
        Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:1")).isSelected());
        driver.quit();
    }

    @Test
    public void TesteCombo(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");
            WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
            Select combo = new Select(element);
//            combo.selectByIndex(2);
//            combo.selectByValue("superior");
            combo.selectByVisibleText("Mestrado");
            Assert.assertEquals( "Mestrado", combo.getFirstSelectedOption().getText());
    }
    @Test
    public void TesteVerificarValoresCombo() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
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
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");
        WebElement element = driver.findElement(By.id("elementosForm:esportes"));
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
        driver.quit();
    }

    @Test
    public void TesteClicarBotoes() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");

        WebElement botao = driver.findElement(By.id("buttonSimple"));
        botao.click();
        Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
        driver.quit();
    }

    @Test
    public void TesteComLinks() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");

        driver.findElement(By.linkText("Voltar")).click();

        Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
        driver.quit();
    }

    @Test
    public void TesteTextoNaPagina() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");

//        //VERIFICAR SE O TEXTO QUE TIVER NO BODY ELE EXISTE
//        Assert.assertTrue(driver.findElement(By.tagName("body"))
//                .getText().contains("Campo de Treinamento"));
        Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
        Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
                driver.findElement(By.className("facilAchar")).getText());

    }



}
