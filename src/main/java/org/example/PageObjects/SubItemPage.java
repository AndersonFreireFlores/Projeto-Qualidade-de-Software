package org.example.PageObjects;

import org.example.DSL.Dsl;
import org.openqa.selenium.By;

public class SubItemPage {

    public String pathFiltroNome = "/html/body/app-root/app-container/main/div/app-cadastro-elemento/form/div[1]/div[2]/div/form/div/div[3]/input";
    public String pathFiltroCodigo = "/html/body/app-root/app-container/main/div/app-cadastro-elemento/form/div[1]/div[2]/div/form/div/div[2]/input";
    public String pathBotaoSubItens = "/html/body/app-root/app-container/main/div/app-cadastro-elemento/form/nav/div/button[2]";
    public String pathCodigoCadastro = "/html/body/app-root/app-container/main/div/app-cadastro-elemento/div/div/div/form/div[1]/div[1]/div[2]/input";
    public String pathNomeCadastro = "/html/body/app-root/app-container/main/div/app-cadastro-elemento/div/div/div/form/div[1]/div[1]/div[3]/input";
    public String pathBotaoSalvar = "/html/body/app-root/app-container/main/div/app-cadastro-elemento/div/div/div/form/div[2]/button[2]";
    public String pathBotaoFiltrar = "/html/body/app-root/app-container/main/div/app-cadastro-elemento/form/div[1]/div[2]/div/form/div/div[4]/div/button[2]";
    public String pathBotaoSalvarSubItems = "/html/body/app-root/app-container/main/div/app-cadastro-elemento/form/div[2]/button";
    public String pathBotaoItem = "/html/body/app-root/app-container/main/div/app-cadastro-elemento/form/nav/div/button[1]";
    public String pathBotaoNovo = "/html/body/app-root/app-container/main/div/app-cadastro-elemento/form/div[1]/div[2]/div/form/div/div[4]/div/button[3]";


    public Dsl dsl = new Dsl();

    public void clicarSubItens(){
        dsl.clicarBotao(pathBotaoSubItens);
    }

    //esse salva um sub item
    public void clicarSalvar(){
        dsl.clicarBotao(pathBotaoSalvar);
    }

    //esse salva todos os sub items de um item
    public void clicarSalvarSubItems(){
        dsl.clicarBotao(pathBotaoSalvarSubItems);
    }

    public void clicarFiltrar(){
        dsl.clicarBotao(pathBotaoFiltrar);
    }

    public void clicarNovoSubItem(){
        dsl.clicarBotao(pathBotaoNovo);
    }

    public void clicarVoltarItemMenu(){
        dsl.clicarBotao(pathBotaoItem);
    }

    public void setCodigoFiltro(String codigo){
        dsl.escrever(By.xpath(pathFiltroCodigo), codigo);
    }

    public void setNomeFiltro(String nome){
        dsl.escrever(By.xpath(pathFiltroNome),nome);
    }

    public void setNomeCadastro(String nome){
        dsl.escrever(By.xpath(pathNomeCadastro),nome);
    }

    public void setCodigoCadastro (String codigo){
        dsl.escrever(By.xpath(pathCodigoCadastro),codigo);
    }

    public void setLocal(String local){
        dsl.selecionarComScroll("localId",local);
    }

    public void setMarca(String marca){
        dsl.selecionarComScroll("marcaId",marca);
    }

    public void setQuantidade(double valor){
        dsl.escrever("quantidade", String.valueOf(valor));
    }

    public void setValidade(String validade){
        dsl.escrever("validade",validade);
    }

    public void escolherRadio(String id, boolean valor) {
        if (valor) {
            dsl.selecionarCombo(id, "\uD83D\uDFE2 Aberto");
        } else {
            dsl.selecionarCombo(id, "\uD83D\uDD34 Fechado");
        }

    }

}
