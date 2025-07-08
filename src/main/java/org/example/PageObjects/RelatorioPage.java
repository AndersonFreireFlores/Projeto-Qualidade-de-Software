package org.example.PageObjects;

import org.example.DSL.Dsl;
import org.openqa.selenium.By;

public class RelatorioPage {

    public String pathGerarRelatorio = "/html/body/app-root/app-container/main/div/app-relatorio/form/div[2]/div[3]/div/button";
    public String pathRelatorio = "/html/body/app-root/app-header/header/div/div/ul[1]/li[8]/a/i";

    public Dsl dsl = new Dsl();

    public void setDataInicial(String dataInicial){
            dsl.escrever("dataInicial",dataInicial);
    }

    public void setDataFinal(String dataFinal){
        dsl.escrever("dataFinal", dataFinal);
    }

    public void clicarPF(){
        dsl.clicarCheck("monitoradoPF");
    }

    public void clicarRelatorio(){
        dsl.clicarBotao(pathRelatorio);
    }

    public void clicarGerarRelatorio(){
        dsl.clicarBotao(pathGerarRelatorio);
    }

    public void setCategoria(String categoria) {
        dsl.selecionarComScroll("categoriaId",categoria);
    }

    public void clicarExercito(){
        dsl.clicarCheck("exercito");
    }
}
