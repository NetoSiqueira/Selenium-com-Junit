package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
    private WebDriver driver;

    public DSL(WebDriver driver) {
        this.driver = driver;
    }

    public void escreve(String locator, String texto){
        driver.findElement(By.id(locator)).sendKeys(texto);
    }


    public String obterValor(String locator){
     return  driver.findElement(By.id(locator)).getAttribute("value");
    }

    public void clicar(String locator){
        driver.findElement(By.id(locator)).click();
    }

    public boolean verificarBotaoClicado(String locator){
        return driver.findElement(By.id(locator)).isSelected();
    }


    public void selecionarCombo(String locator, String escolaridade){
        WebElement element = driver.findElement(By.id(locator));
        Select combo = new Select(element);

        combo.selectByVisibleText(escolaridade);
    }

    public String obterValorCombo(String locator){
        WebElement element = driver.findElement(By.id(locator));
        Select combo = new Select(element);

        return combo.getFirstSelectedOption().getText();
    }

    public void clicarLink(String locator){
        driver.findElement(By.linkText(locator)).click();
    }

    public String obterValorPorTexto(By locator){
        return driver.findElement(locator).getText();
    }
}
