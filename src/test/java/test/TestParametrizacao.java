package test;


import core.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.TestPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static core.DriverFactory.getDriver;

@RunWith(Parameterized.class)
public class TestParametrizacao  {
       private TestPage cadastropage;
    @Parameterized.Parameter(value = 0)
    public String nome ;
    @Parameterized.Parameter(value = 1)
    public String sobrenome;
    @Parameterized.Parameter(value = 2)
    public String sexo ;
    @Parameterized.Parameter(value = 3)
    public List<String> comida ;
    @Parameterized.Parameter(value = 4)
    public List<String> esportes;
    @Parameterized.Parameter(value = 5)
    public String msg ;



    @Before
    public void inicializa(){
        getDriver().get("file:///" + System.getProperty("user.dir") + "/target/componentes.html");
        cadastropage = new TestPage();

    }



    @Parameterized.Parameters
    public static Collection<Object[]> getCollection(){
        return Arrays.asList(new Object[][]{
                {"", "", "",Arrays.asList(), Arrays.asList(), "Nome eh obrigatorio"},
                {"Neto", "", "", Arrays.asList(), Arrays.asList(), "Sobrenome eh obrigatorio"},
                {"Neto", "Siqueira", "", Arrays.asList(), Arrays.asList(), "Sexo eh obrigatorio"},
                {"Neto", "Siqueira", "M", Arrays.asList("Carne", "Vegetariano"), Arrays.asList(), "Tem certeza que voce eh vegetariano?"},
                {"Neto", "Siqueira", "M", Arrays.asList("Carne"), Arrays.asList("Karate", "O que eh esporte?"), "Voce faz esporte ou nao?"},
        });
    }


    @Test
    public void ValidarRegrasUsandoParametrizacao(){
       cadastropage.setNome(nome);
       cadastropage.setSobrenome(sobrenome);
       cadastropage.setSexo(sexo);
       cadastropage.setComidaFavoritaParametrizado(comida);
       cadastropage.setDoisEsportes(esportes);
       cadastropage.Cadastrar();
       System.out.println(msg);
        Assert.assertEquals(msg, cadastropage.obterMsg());
        Alert alert = getDriver().switchTo().alert();
        alert.accept();

}




}
