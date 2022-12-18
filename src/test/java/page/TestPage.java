package page;

import base.DSL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class TestPage {
    private DSL dsl;

    public TestPage(WebDriver driver) {
        dsl = new DSL(driver);
    }


    public void setNome(String nome){
        dsl.escreve("elementosForm:nome", nome);
    }

    public void setSobrenome(String sobrenome){
        dsl.escreve("elementosForm:sobrenome", sobrenome);
    }

    public void setSexo(String sexo){
        if (sexo.equals("M"))
            dsl.clicarRadio(By.id("elementosForm:sexo:0"));
        if (sexo.equals("F"))
            dsl.clicarRadio(By.id("elementosForm:sexo:1"));
    }

    public void setComidaFavorita(String comida){
        if (comida.equals("Carne")) dsl.clicarRadio(By.id("elementosForm:comidaFavorita:0") );
        if (comida.equals("Frango")) dsl.clicarRadio(By.id("elementosForm:comidaFavorita:1") );
        if (comida.equals("Pizza")) dsl.clicarRadio(By.id("elementosForm:comidaFavorita:2") );
        if (comida.equals("Vegetariano")) dsl.clicarRadio(By.id("elementosForm:comidaFavorita:3") );
    }
    public void setComidaFavoritaParametrizado(List<String> comidas){
        for (String comida:comidas) {
            if (comida.equals("Carne")) dsl.clicarRadio(By.id("elementosForm:comidaFavorita:0") );
            if (comida.equals("Frango")) dsl.clicarRadio(By.id("elementosForm:comidaFavorita:1") );
            if (comida.equals("Pizza")) dsl.clicarRadio(By.id("elementosForm:comidaFavorita:2") );
            if (comida.equals("Vegetariano")) dsl.clicarRadio(By.id("elementosForm:comidaFavorita:3") );
        }

    }

    public void setEscolaridade(String nivel){
        dsl.selecionarCombo("elementosForm:escolaridade", nivel);
    }

    public void setEsporte(String esporte){
        dsl.selecionarCombo("elementosForm:esportes", esporte);
    }

    public void Cadastrar(){
        dsl.clicar("elementosForm:cadastrar");
    }

    public String obterResultadoCadastro(){
        return dsl.obterValorPorTexto(By.id("resultado"));
    }

    public String obterResultadoNome(){
        return dsl.obterValorPorTexto(By.id("descNome"));
    }

    public void setDoisEsportes(List<String> esporte){
        for (String valor:esporte) {
            dsl.selecionarCombo("elementosForm:esportes", valor);
        }
    }

    public String obterMsg(){
       return dsl.alertaObterTextoEAceitar();
    }

}
