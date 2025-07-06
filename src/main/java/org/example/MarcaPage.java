package org.example;

import org.example.DSL.Dsl;

public class MarcaPage {

    public String pathMarca = "/html/body/app-root/app-header/header/div/div/ul[1]/li[5]/a/i";
    public String pathBotaoCriarMarca = "/html/body/app-root/app-container/main/div/app-marca/form/div/div[3]/div/button[3]";
    public String pathBotaoSalvar = "/html/body/app-root/app-container/main/div/app-marca/div[1]/div/div/form/div[2]/button[2]";
    public String pathBotaoEditar = "/html/body/app-root/app-container/main/div/app-marca/div[2]/table/tbody/tr[1]/td[3]/i";
    public String pathBotaoInativar = "/html/body/app-root/app-container/main/div/app-marca/div[2]/table/tbody/tr[1]/td[4]/i";
    public String pathBotaoFiltrar = "/html/body/app-root/app-container/main/div/app-marca/form/div/div[3]/div/button[2]/i";
    public String pathConfirmarInativar = "/html/body/app-root/app-container/main/div/app-marca/app-confirm-modal/div/div/div/div[3]/button[2]";


    public Dsl dsl = new Dsl();

    public void setMarca(String nomeMarca){
        dsl.escrever("nome", nomeMarca);
    }

    public String getMarca(){
        return dsl.obterTexto("nome");
    }

    public void setPesquisaMarca(String nomeMarca){
        dsl.escrever("filtro_nome", nomeMarca);
    }

    public String getPesquisaMarca(){
        return dsl.obterTexto("filtro_nome");
    }

    public void clicarNovo (){
        dsl.clicarBotao(pathBotaoCriarMarca);
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

    public void clicarMarca (){
        dsl.clicarBotao(pathMarca);
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
