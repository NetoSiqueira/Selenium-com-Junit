package test;

import base.DSL;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestComJavascript {

    private WebDriver driver;



    @Before
    public void inicializa(){
        WebDriverManager.chromedriver().setup();
        System.out.println("Comecamos aqui");
        driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");
    }

//    @After
//    public void fechar(){
//        driver.quit();
//    }

    @Test
    public void testJavascript(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("alert('Testando js via selenium')");
        js.executeScript("document.getElementById('elementosForm:nome').value =  'Deu certo por js'");
        WebElement element = driver.findElement(By.id("elementosForm:nome"));
    }


}
