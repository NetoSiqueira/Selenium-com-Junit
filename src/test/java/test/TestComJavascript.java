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

import static core.DriverFactory.getDriver;

public class TestComJavascript {

   


    @Before
    public void inicializa(){
       
        getDriver().get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");
    }

//    @After
//    public void fechar(){
//        getDriver().quit();
//    }

    @Test
    public void testJavascript(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
//        js.executeScript("alert('Testando js via selenium')");
        js.executeScript("document.getElementById('elementosForm:nome').value =  'Deu certo por js'");
        WebElement element = getDriver().findElement(By.id("elementosForm:nome"));
    }


}
