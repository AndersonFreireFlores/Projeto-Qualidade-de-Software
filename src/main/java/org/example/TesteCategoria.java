package org.example;

import org.example.DSL.DriverFactory;
import org.example.DSL.Dsl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TesteCategoria {

    private Dsl dsl;
    private static LoginPage loginPage = new LoginPage();
    private static CategoriaPage categoriaPage = new CategoriaPage();

    private String email = "anderson.flores@aluno.feliz.ifrs.edu.br";
    private String senha = "ABC123";

    @Before
    public void inicializar() {
        DriverFactory.getDriver().get("http://35.209.123.161/front");
        dsl = new Dsl();

        loginPage.setEmail(email);
        loginPage.setSenha(senha);
        loginPage.logar();
        categoriaPage.clicarCategoria();
    }

    @After
    public void finalizar(){
        DriverFactory.killDriver();
    }

    @Parameter
    public String nomeCategoria;
    @Parameter(value = 1)
    public boolean valor;

    @Parameters
    public static Collection<Object[]> getCollection() {
        return Arrays.asList(new Object[][]{
                {"ASD123", true},
                {"ASD456", true}
               });
    }

    @Test
    public void criarCategoria(){
        categoriaPage.clicarNovo();
        categoriaPage.setCategoria(nomeCategoria);
        categoriaPage.clicarSalvar();

        categoriaPage.setPesquisaCategoria(nomeCategoria);
        categoriaPage.clicarFiltrar();

        Assert.assertEquals(nomeCategoria, dsl.obterTexto(
                By.xpath("/html/body/app-root/app-container/main/div/app-categoria/div[2]/table/tbody/tr/td[2]")));

    }

    @Test
    public void editarCategoria(){
            categoriaPage.setPesquisaCategoria(nomeCategoria);
            categoriaPage.clicarFiltrar();

            categoriaPage.clicarEditar();
            categoriaPage.setCategoria(nomeCategoria.concat("edited"));
            categoriaPage.clicarSalvar();

            Assert.assertEquals(nomeCategoria + "edited", dsl.obterTexto(
                    By.xpath("/html/body/app-root/app-container/main/div/app-categoria/div[2]/table/tbody/tr/td[2]")
            ));

    }

    @Test
    public void inativarCategoria(){

        categoriaPage.setPesquisaCategoria(nomeCategoria);
        categoriaPage.clicarFiltrar();

        categoriaPage.clicarInativar();
        categoriaPage.clicarConfirmarInativar();

        categoriaPage.escolherRadio("filtro_status",false);
        categoriaPage.clicarFiltrar();

        Assert.assertEquals(nomeCategoria + "edited", dsl.obterTexto(
                By.xpath("/html/body/app-root/app-container/main/div/app-categoria/div[2]/table/tbody/tr/td[2]")
        ));

    }


}
