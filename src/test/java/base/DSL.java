package base;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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
    public void clicar(By locator){
        driver.findElement(locator).click();
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

    public void clicarRadio(By locator){
        driver.findElement(locator).click();
    }

    public String alertaObterTextoEAceitar(){
        Alert alert = driver.switchTo().alert();
        String valor = alert.getText();
        return valor;
    }

    public void clicarBotaoTabela(String colunaBusca, String valorLinha, String colunaBotao){
        //procurar coluna do registro
            WebElement tabela = driver.findElement(By.xpath("//table[@id='elementosForm:tableUsuarios']"));
            int idColuna = obterIndiceColuna(colunaBusca,tabela);

        //encontrar a linha do registro
       int idLinha = obterIndiceLinha(valorLinha, tabela, idColuna);

        //procurar coluna botao
        int idColunaBotao = obterIndiceColuna(colunaBotao,tabela);

        //clicar no botao da celula

        WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
        celula.findElement(By.xpath(".//input")).click();
    }

    public  int obterIndiceLinha(String valorLinha, WebElement tabela, int idColuna) {
        List<WebElement> linhas =  tabela.findElements(By.xpath("./tbody/tr/td["+ idColuna +"]"));
        int idlinha = -1;
        for (int i = 0; i < linhas.size(); i++){
            if(linhas.get(i).getText().equals(valorLinha)){
                idlinha = i+1;
                break;
            }
        }
        return idlinha;
    }

    public int obterIndiceColuna(String coluna, WebElement tabela){

        List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
        int idColuna = -1;
        for (int i = 0; i < colunas.size(); i++){
            if(colunas.get(i).getText().equals(coluna)){
                idColuna = i+1;
                break;
            }
        }
        return idColuna;
    }

    public void selecionaComboPrime(String radical, String valor){
        driver.findElement(By.xpath("//*[@id = '"+radical+":option']/../..//span")).click();
        driver.findElement(By.xpath("//*[@id = '"+radical+":option_panel']//li[.='"+valor+"']")).click();

    }


}
