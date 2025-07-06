package org.example;

import org.example.DSL.Dsl;

public class LocalPage {

    public String pathLocal = "/html/body/app-root/app-header/header/div/div/ul[1]/li[4]/a";
    public String pathBotaoCriarLocal = "/html/body/app-root/app-container/main/div/app-local/form/div/div[3]/div/button[3]";
    public String pathBotaoSalvar = "/html/body/app-root/app-container/main/div/app-local/div[1]/div/div/form/div[2]/button[2]";
    public String pathBotaoEditar = "/html/body/app-root/app-container/main/div/app-local/div[2]/table/tbody/tr[1]/td[3]/i";
    public String pathBotaoInativar = "/html/body/app-root/app-container/main/div/app-local/div[2]/table/tbody/tr[1]/td[4]/i";
    public String pathBotaoFiltrar = "/html/body/app-root/app-container/main/div/app-local/form/div/div[3]/div/button[2]/i";
    public String pathConfirmarInativar = "/html/body/app-root/app-container/main/div/app-local/app-confirm-modal/div/div/div/div[3]/button[2]";


    public Dsl dsl = new Dsl();

    public void setLocal(String nomeLocal){
        dsl.escrever("nome", nomeLocal);
    }

    public String getLocal(){
        return dsl.obterTexto("nome");
    }

    public void setPesquisaLocal(String nomeLocal){
        dsl.escrever("filtro_nome", nomeLocal);
    }

    public String getPesquisaLocal(){
        return dsl.obterTexto("filtro_nome");
    }

    public void clicarNovo (){
        dsl.clicarBotao(pathBotaoCriarLocal);
    }

    public void clicarConfirmar (){
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

    public void clicarLocal (){
        dsl.clicarBotao(pathLocal);
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
