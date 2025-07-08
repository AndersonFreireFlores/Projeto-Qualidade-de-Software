package org.example.Testes;

import org.example.DSL.DriverFactory;
import org.example.DSL.Dsl;
import org.example.PageObjects.EstoquePage;
import org.example.PageObjects.LoginPage;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteEstoque {

    private Dsl dsl;
    private static LoginPage loginPage = new LoginPage();
    private static EstoquePage estoquePage = new EstoquePage();

    private String email = "anderson.flores@aluno.feliz.ifrs.edu.br";
    private String senha = "ABC123";

    @Before
    public void inicializar() {
        DriverFactory.getDriver().get("http://35.209.123.161/front");
        dsl = new Dsl();

        loginPage.setEmail(email);
        loginPage.setSenha(senha);
        loginPage.logar();
        estoquePage.clicarEstoque();
    }

    @After
    public void finalizar(){
        DriverFactory.killDriver();
    }

    @Parameterized.Parameter
    public String data;
    @Parameterized.Parameter(value = 1)
    public double qtde;

    @Parameterized.Parameters
    public static Collection<Object[]> getCollection(){
        return Arrays.asList(new Object[][]{
                {"2025-07-09T12:00", 1.5},
                {"2025-08-10T12:00", 9.9}
        });
    }

    @Test
    public void test1_criarEstoque(){

        estoquePage.clicarCriarEstoque();
        estoquePage.setData(data);
        estoquePage.setTipo("Entrada");
        estoquePage.setItem("Item1");
        estoquePage.setSubItem("SubItem1");
        estoquePage.setQtde(qtde);
        estoquePage.setObs("É importante observar que essa observação é extremamente observativa sobre sua observabilidade...");
        estoquePage.clicarSalvar();


        estoquePage.setDataInicial("5070-02-02");
        estoquePage.setDataFinal("5070-02-02");
        estoquePage.clicarFiltrar();

        Assert.assertEquals("AndersonFlores", dsl.obterTexto(
                By.xpath("/html/body/app-root/app-container/main/div/app-movimentacao/div[2]/table/tbody/tr/td[3]"
                )));
    }

    @Test
    public void test3_excluirEstoque(){

        estoquePage.setDataInicial("5070-02-02");
        estoquePage.setDataFinal("5070-02-02");
        estoquePage.clicarFiltrar();
        estoquePage.clicarExcluir();
        estoquePage.clicarBotaoConfirmarExcluir();


        Assert.assertEquals("Movimentação excluída com sucesso!", dsl.obterTexto(
                By.xpath("/html/body/app-root/app-container/main/div/app-movimentacao/p-toast/div/p-toastitem/div/div/div/div[2]")));
    }


}
