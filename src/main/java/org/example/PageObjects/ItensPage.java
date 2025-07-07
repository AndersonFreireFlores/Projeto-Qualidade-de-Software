package org.example.PageObjects;

import org.example.DSL.Dsl;
import org.openqa.selenium.By;

public class ItensPage {

    public String pathItens = "/html/body/app-root/app-header/header/div/div/ul[1]/li[2]/a/i";
    public String pathBotaoCriarItem = "/html/body/app-root/app-container/main/div/app-lista-elemento/form/div/div[4]/div/a";
    public String pathBotaoFiltrar = "/html/body/app-root/app-container/main/div/app-lista-elemento/form/div/div[4]/div/button[2]";
    public String pathBotaoSalvar = "/html/body/app-root/app-container/main/div/app-cadastro-elemento/form/div[2]/button";
    public String pathBotaoEditar = "/html/body/app-root/app-container/main/div/app-lista-elemento/div/table/tbody/tr/td[4]/i";
    public String pathBotaoInativar = "/html/body/app-root/app-container/main/div/app-lista-elemento/div/table/tbody/tr/td[5]/i";
    public String pathBotaoConfirmarInativar = "/html/body/app-root/app-container/main/div/app-lista-elemento/app-confirm-modal/div/div/div/div[3]/button[2]";
    public String pathBotaoSubItens = "/html/body/app-root/app-container/main/div/app-cadastro-elemento/form/nav/div/button[2]";
    public String pathBotaoVoltar = "/html/body/app-root/app-container/main/div/app-cadastro-elemento/form/div[2]/a";

    public Dsl dsl = new Dsl();

    public void clicarItens() {
        dsl.clicarBotao(pathItens);
    }

    public void clicarNovo() {
        dsl.clicarBotao(pathBotaoCriarItem);
    }

    public void clicarSalvar() {
        dsl.clicarBotao(pathBotaoSalvar);
    }

    public void clicarVoltar(){
        dsl.clicarBotao(pathBotaoVoltar);
    }

    public void clicarFiltrar() {
        dsl.clicarBotao(pathBotaoFiltrar);
    }

    public void clicarEditar() {
        dsl.clicarBotao(pathBotaoEditar);
    }

    public void clicarInativar() {
        dsl.clicarBotao(pathBotaoInativar);
    }

    public void clicarConfirmarInativar() {
        dsl.clicarBotao(pathBotaoConfirmarInativar);
    }

    public void clicarPF () {
        dsl.clicarCheck("/html/body/app-root/app-container/main/div/app-cadastro-elemento/form/div[1]/div[1]/div/div/div[7]/div/div[2]/input");
    }

    public void clicarExercito() {
        dsl.clicarCheck("exercito");
    }

    public void clicarSubItens(){
        dsl.clicarBotao(pathBotaoSubItens);
    }

    public void escolherCategoria(String nomeCategoria){
        dsl.selecionarCategoriaComScroll("categoriaId", nomeCategoria);
    }

    public void escolherUnidadeDeMedida(String nomeUnidade){
        dsl.selecionarCategoriaComScroll("unidadeMedidaId", nomeUnidade);
    }

    public void setFiltroCodigo(String codigo) {
        dsl.escrever("filtro_codigo", codigo);
    }

    public void setFiltroNome(String nome) {
        dsl.escrever("filtro_nome", nome);
    }

    public void setCodigo(String codigo) {
        dsl.escrever(By.xpath("/html/body/app-root/app-container/main/div/app-cadastro-elemento/form/div[1]/div[1]/div/div/div[2]/input"), codigo);
    }

    public void setNome(String nome) {
        dsl.escrever(By.xpath("/html/body/app-root/app-container/main/div/app-cadastro-elemento/form/div[1]/div[1]/div/div/div[3]/input"), nome);
    }

    public void setValorMinimo(double valorMinimo) {
        dsl.escrever("quantidadeMinima", String.valueOf(valorMinimo));
    }

    public void setObservacoes(String observacoes){
        dsl.escrever("observacoes", observacoes);
    }

    public void escolherRadio(String id, boolean valor) {
        if (valor) {
            dsl.selecionarCombo(id, "\uD83D\uDFE2 Ativo");
        } else {
            dsl.selecionarCombo(id, "\uD83D\uDD34 Inativo");
        }

    }
}
