package org.example.PageObjects;

import org.example.DSL.Dsl;

public class CategoriaPage {

    public String pathCategoria = "/html/body/app-root/app-header/header/div/div/ul[1]/li[6]/a";
    public String pathBotaoCriarCategoria = "/html/body/app-root/app-container/main/div/app-categoria/form/div/div[3]/div/button[3]";
    public String pathBotaoSalvar = "/html/body/app-root/app-container/main/div/app-categoria/div[1]/div/div/form/div[2]/button[2]";
    public String pathBotaoEditar = "/html/body/app-root/app-container/main/div/app-categoria/div[2]/table/tbody/tr[1]/td[3]/i";
    public String pathBotaoInativar = "/html/body/app-root/app-container/main/div/app-categoria/div[2]/table/tbody/tr[1]/td[4]/i";
    public String pathBotaoFiltrar = "/html/body/app-root/app-container/main/div/app-categoria/form/div/div[3]/div/button[2]/i";
    public String pathConfirmarInativar = "/html/body/app-root/app-container/main/div/app-categoria/app-confirm-modal/div/div/div/div[3]/button[2]";

    public Dsl dsl = new Dsl();

    public void setCategoria(String nomeCategoria){
        dsl.escrever("nome", nomeCategoria);
    }

    public String getCategoria(){
        return dsl.obterTexto("nome");
    }

    public void setPesquisaCategoria(String nomeCategoria){
        dsl.escrever("filtro_nome", nomeCategoria);
    }

    public String getPesquisaCategoria(){
        return dsl.obterTexto("filtro_nome");
    }

    public void clicarNovo (){
        dsl.clicarBotao(pathBotaoCriarCategoria);
    }

    public void clicarSalvar (){
        dsl.clicarBotao(pathBotaoSalvar);
    }

    public void clicarEditar (){
        dsl.clicarBotao(pathBotaoEditar);
    }

    public void clicarInativar (){
        dsl.clicarBotao(pathBotaoInativar);
    }

    public void clicarFiltrar (){
        dsl.clicarBotao(pathBotaoFiltrar);
    }

    public void clicarCategoria (){
        dsl.clicarBotao(pathCategoria);
    }

    public void clicarConfirmarInativar (){
        dsl.clicarBotao(pathConfirmarInativar);
    }

    public void escolherRadio(String id,boolean valor){
        if (valor){
            dsl.selecionarCombo(id,"\uD83D\uDFE2 Ativo");
        }
        else{
            dsl.selecionarCombo(id,"\uD83D\uDD34 Inativo");
        }
    }

}
