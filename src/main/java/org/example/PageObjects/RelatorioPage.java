package org.example.PageObjects;

import org.example.DSL.Dsl;

public class RelatorioPage {

    public String pathGerarRelatorio = "/html/body/app-root/app-container/main/div/app-relatorio/form/div[2]/div[3]/div/button";

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

    public void setCategoria(String categoria) {
        dsl.selecionarComScroll("categoriaId",categoria);
    }

    public void clicarExercito(){
        dsl.clicarCheck("exercito");
    }
}
