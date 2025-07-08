package org.example.PageObjects;

import org.example.DSL.Dsl;

public class EstoquePage {

    public String pathBotaoCriarEstoque = "/html/body/app-root/app-container/main/div/app-movimentacao/form/div/div[5]/div/button[3]";
    public String pathBotaoFiltrar = "/html/body/app-root/app-container/main/div/app-movimentacao/form/div/div[5]/div/button[2]";
    public String pathBotaoSalvar = "/html/body/app-root/app-container/main/div/app-movimentacao/div[1]/div/div/form/div[2]/button[2]";
    public String pathBotaoEstoque = "/html/body/app-root/app-header/header/div/div/ul[1]/li[7]/a/i";
    public String pathBotaoExcluir = "/html/body/app-root/app-container/main/div/app-movimentacao/div[2]/table/tbody/tr/td[8]/i";
    public String pathBotaoConfirmarExcluir = "/html/body/app-root/app-container/main/div/app-movimentacao/app-confirm-modal/div/div/div/div[3]/button[2]";


    public Dsl dsl = new Dsl();

    public void clicarEstoque(){
        dsl.clicarBotao(pathBotaoEstoque);
    }

    public void clicarCriarEstoque() {
        dsl.clicarBotao(pathBotaoCriarEstoque);
    }

    public void clicarExcluir(){
        dsl.clicarBotao(pathBotaoExcluir);
    }

    public void clicarBotaoConfirmarExcluir(){
        dsl.clicarBotao(pathBotaoConfirmarExcluir);
    }

    public void clicarFiltrar(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dsl.clicarBotao(pathBotaoFiltrar);
    }

    public void clicarSalvar(){
        dsl.clicarBotao(pathBotaoSalvar);
    }

    public void setData(String data){

        dsl.escrever("cadastroData", data);
    }

    public void setItem(String nome){
        dsl.selecionarComScroll("cadastro_elemento",nome);
    }

    public void setTipo(String tipo){
        dsl.selecionarComScroll("cadastroTipo", tipo);
    }

    public void setSubItem(String item){
        dsl.selecionarComScroll("cadastro_elementoItem",item);
    }

    public void setQtde(double qtde){
        dsl.escrever("cadastroQuantidade", String.valueOf(qtde));
    }

    public void setObs(String obs){
        dsl.escrever("observacoes", obs);
    }

    public void setItemFiltro(String item){
        dsl.selecionarComScroll("filtro_elemento", item);
    }

    public void setDataInicial(String data){
        dsl.escrever("dataInicial", data);
    }
    public void setDataFinal(String data){
        dsl.escrever("dataFinal", data);
    }

}
