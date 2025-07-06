package org.example.Testes;

import org.example.DSL.DriverFactory;
import org.example.DSL.Dsl;
import org.example.LoginPage;
import org.example.UnidadeMedidaPage;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteUnidadeMedida {

    private Dsl dsl;
    private static LoginPage loginPage = new LoginPage();
    private static UnidadeMedidaPage unidadeMedidaPage = new UnidadeMedidaPage();

    private String email = "anderson.flores@aluno.feliz.ifrs.edu.br";
    private String senha = "ABC123";

    @Before
    public void inicializar() {
        DriverFactory.getDriver().get("http://35.209.123.161/front");
        dsl = new Dsl();

        loginPage.setEmail(email);
        loginPage.setSenha(senha);
        loginPage.logar();
        unidadeMedidaPage.clicarUnidadeMedida();
    }

    @After
    public void finalizar(){
        DriverFactory.killDriver();
    }

    @Parameter
    public String nomeUnidadeMedida;
    @Parameter(value = 1)
    public boolean valor;

    @Parameters
    public static Collection<Object[]> getCollection() {
        return Arrays.asList(new Object[][]{
                {"ZXC"+(int) (Math.random() * 10001), true},
                {"ZXC"+(int) (Math.random() * 10001), true}
        });
    }

    @Test
    public void test1CriarUnidadeMedida(){
        unidadeMedidaPage.clicarNovo();
        unidadeMedidaPage.setUnidadeMedida(nomeUnidadeMedida);
        unidadeMedidaPage.clicarConfirmar();

        unidadeMedidaPage.setPesquisaUnidadeMedida(nomeUnidadeMedida);
        unidadeMedidaPage.clicarFiltrar();

        Assert.assertEquals(nomeUnidadeMedida, dsl.obterTexto(
                By.xpath("/html/body/app-root/app-container/main/div/app-unidade-medida/div[2]/table/tbody/tr/td[2]")));
    }

    @Test
    public void test2EditarUnidadeMedida(){
        unidadeMedidaPage.setPesquisaUnidadeMedida(nomeUnidadeMedida);
        unidadeMedidaPage.clicarFiltrar();

        unidadeMedidaPage.clicarEditar();
        unidadeMedidaPage.setUnidadeMedida(nomeUnidadeMedida + "edited");
        unidadeMedidaPage.clicarConfirmar();

        unidadeMedidaPage.setPesquisaUnidadeMedida(nomeUnidadeMedida + "edited");
        unidadeMedidaPage.clicarFiltrar();

        Assert.assertEquals(nomeUnidadeMedida + "edited", dsl.obterTexto(
                By.xpath("/html/body/app-root/app-container/main/div/app-unidade-medida/div[2]/table/tbody/tr/td[2]")
        ));
    }

    @Test
    public void test3InativarUnidadeMedida(){
        unidadeMedidaPage.setPesquisaUnidadeMedida(nomeUnidadeMedida);
        unidadeMedidaPage.clicarFiltrar();

        unidadeMedidaPage.clicarInativar();
        unidadeMedidaPage.clicarConfirmarInativar();

        unidadeMedidaPage.escolherRadio("filtro_status",false);
        unidadeMedidaPage.clicarFiltrar();

        Assert.assertEquals(nomeUnidadeMedida + "edited", dsl.obterTexto(
                By.xpath("/html/body/app-root/app-container/main/div/app-unidade-medida/div[2]/table/tbody/tr/td[2]")
        ));
    }
}