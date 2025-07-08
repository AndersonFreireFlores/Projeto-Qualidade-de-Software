package org.example.Testes;

import org.example.PageObjects.CategoriaPage;
import org.example.DSL.DriverFactory;
import org.example.DSL.Dsl;
import org.example.PageObjects.ItensPage;
import org.example.PageObjects.LoginPage;
import org.example.PageObjects.UnidadeMedidaPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
                {"ASD"+(int) (Math.random() * 10001), true},
                {"ASD"+(int) (Math.random() * 10001), true}
               });
    }

    @Test
    public void test1_criarCategoria(){
        categoriaPage.clicarNovo();
        categoriaPage.setCategoria(nomeCategoria);
        categoriaPage.clicarSalvar();

        categoriaPage.setPesquisaCategoria(nomeCategoria);
        categoriaPage.clicarFiltrar();

        Assert.assertEquals(nomeCategoria, dsl.obterTexto(
                By.xpath("/html/body/app-root/app-container/main/div/app-categoria/div[2]/table/tbody/tr/td[2]")));

    }

    @Test
    public void test2_criarCategoriaInvalida(){

        categoriaPage.clicarNovo();
        categoriaPage.setCategoria(nomeCategoria);
        categoriaPage.clicarSalvar();

        Assert.assertEquals("Já existe uma Categoria com o mesmo nome!", dsl.obterTexto(
                By.xpath("/html/body/app-root/app-container/main/div/app-categoria/p-toast/div/p-toastitem/div/div/div/div[2]")));
    }

    @Test
    public void test3_editarCategoria(){

        categoriaPage.setPesquisaCategoria(nomeCategoria);
        categoriaPage.clicarFiltrar();

        categoriaPage.clicarEditar();
        categoriaPage.setCategoria(nomeCategoria + "edited");
        categoriaPage.clicarSalvar();

        categoriaPage.setPesquisaCategoria(nomeCategoria + "edited");
        categoriaPage.clicarFiltrar();

            Assert.assertEquals(nomeCategoria + "edited", dsl.obterTexto(
                    By.xpath("/html/body/app-root/app-container/main/div/app-categoria/div[2]/table/tbody/tr/td[2]")
            ));

    }

    @Test
    public void test4_inativarCategoria(){

        categoriaPage.setPesquisaCategoria(nomeCategoria + "edited");
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
