package org.example.PageObjects;

import org.example.DSL.Dsl;

public class ItensPage {

    public String pathItens = "/html/body/app-root/app-header/header/div/div/ul[1]/li[2]/a/i";
    public String pathBotaoCriarItem = "/html/body/app-root/app-container/main/div/app-lista-elemento/form/div/div[4]/div/a";
    public String pathBotaoFiltrar = "/html/body/app-root/app-container/main/div/app-lista-elemento/form/div/div[4]/div/button[2]";
    public String pathBotaoSalvar = "/html/body/app-root/app-container/main/div/app-cadastro-elemento/form/div[2]/button";
    public String pathBotaoEditar = "/html/body/app-root/app-container/main/div/app-lista-elemento/div/table/tbody/tr/td[4]/i";
    public String pathBotaoInativar = "/html/body/app-root/app-container/main/div/app-lista-elemento/div/table/tbody/tr/td[5]/i";
    public String pathBotaoConfirmarInativar = "/html/body/app-root/app-container/main/div/app-lista-elemento/app-confirm-modal/div/div/div/div[3]/button[2]";

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
        dsl.clicarCheck("monitoradoPF");
    }

    public void clicarExercito() {
        dsl.clicarCheck("monitoradoExercito");
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
        dsl.escrever("codigo", codigo);
    }

    public void setNome(String nome) {
        dsl.escrever("nome", nome);
    }

    //descobrir se aceita string
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
