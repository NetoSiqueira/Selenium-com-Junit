package page;

import base.DSL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public void setSexoMasculino(){
        dsl.clicarRadio(By.id("elementosForm:sexo:0"));
    }

    public void setComidaFavorita(){
        dsl.clicarRadio(By.id("elementosForm:comidaFavorita:1") );
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



}
