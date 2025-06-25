package org.example;

import org.example.DSL.Dsl;

public class UnidadeMedidaPage {

    public String pathUnidadeMedida = "/html/body/app-root/app-header/header/div/div/ul[1]/li[3]/a/span";
    public String pathBotaoCriarUnidadeMedida = "/html/body/app-root/app-container/main/div/app-unidade-medida/form/div/div[3]/div/button[3]";
    public String pathBotaoSalvar = "/html/body/app-root/app-container/main/div/app-unidade-medida/div[1]/div/div/form/div[2]/button[2]";
    public String pathBotaoEditar = "/html/body/app-root/app-container/main/div/app-unidade-medida/div[2]/table/tbody/tr[1]/td[3]/i";
    public String pathBotaoInativar = "/html/body/app-root/app-container/main/div/app-unidade-medida/div[2]/table/tbody/tr[1]/td[4]/i";
    public String pathBotaoFiltrar = "/html/body/app-root/app-container/main/div/app-unidade-medida/form/div/div[3]/div/button[2]/i";
    public String pathConfirmarInativar = "/html/body/app-root/app-container/main/div/app-unidade-medida/app-confirm-modal/div/div/div/div[3]/button[2]";


    public Dsl dsl = new Dsl();

    public void setUnidadeMedida(String nomeUnidadeMedida){
        dsl.escrever("nome", nomeUnidadeMedida);
    }

    public String getUnidadeMedida(){
        return dsl.obterTexto("nome");
    }

    public void setPesquisaUnidadeMedida(String nomeUnidadeMedida){
        dsl.escrever("filtro_nome", nomeUnidadeMedida);
    }

    public String getPesquisaUnidadeMedida(){
        return dsl.obterTexto("filtro_nome");
    }

    public void clicarNovo (){
        dsl.clicarBotao(pathBotaoCriarUnidadeMedida);
    }

    public void clicarConfirmar (){
        dsl.clicarBotao(pathBotaoConfirmar);
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

    public void clicarUnidadeMedida (){
        dsl.clicarBotao(pathUnidadeMedida);
    }

    public void clicarConfirmarInativar (){
        dsl.clicarBotao(pathConfirmarInativar);
    }

    public void escolherRadio(boolean valor){
        if (valor){
            dsl.selecionarCombo("status","A");
        }
        else{
            dsl.selecionarCombo("status","I");
        }
    }




}
