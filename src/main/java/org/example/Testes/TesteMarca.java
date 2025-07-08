package org.example.Testes;

import org.example.DSL.DriverFactory;
import org.example.DSL.Dsl;
import org.example.PageObjects.LoginPage;
import org.example.PageObjects.MarcaPage;
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
public class TesteMarca {

    private Dsl dsl;
    private static LoginPage loginPage = new LoginPage();
    private static MarcaPage marcaPage = new MarcaPage();

    private String email = "anderson.flores@aluno.feliz.ifrs.edu.br";
    private String senha = "ABC123";

    @Before
    public void inicializar() {
        DriverFactory.getDriver().get("http://35.209.123.161/front");
        dsl = new Dsl();

        loginPage.setEmail(email);
        loginPage.setSenha(senha);
        loginPage.logar();
        marcaPage.clicarMarca();
    }

    @After
    public void finalizar(){
        DriverFactory.killDriver();
    }

    @Parameter
    public String nomeMarca;
    @Parameter(value = 1)
    public boolean valor;

    @Parameters
    public static Collection<Object[]> getCollection() {
        return Arrays.asList(new Object[][]{
                {"RTY"+(int) (Math.random() * 10001), true},
                {"RTY"+(int) (Math.random() * 10001), true}
        });
    }

    @Test
    public void test1CriarMarca(){
        marcaPage.clicarNovo();
        marcaPage.setMarca(nomeMarca);
        marcaPage.clicarConfirmar();

        marcaPage.setPesquisaMarca(nomeMarca);
        marcaPage.clicarFiltrar();

        Assert.assertEquals(nomeMarca, dsl.obterTexto(
                By.xpath("/html/body/app-root/app-container/main/div/app-marca/div[2]/table/tbody/tr/td[2]")));
    }
    @Test
    public void test2CriarMarcaInvalida(){

        marcaPage.clicarNovo();
        marcaPage.setMarca(nomeMarca);
        marcaPage.clicarConfirmar();

        Assert.assertEquals("Já existe uma Marca com o mesmo nome!", dsl.obterTexto(
                By.xpath("/html/body/app-root/app-container/main/div/app-marca/p-toast/div/p-toastitem/div/div/div/div[2]")));
    }
    @Test
    public void test3EditarMarca(){
        marcaPage.setPesquisaMarca(nomeMarca);
        marcaPage.clicarFiltrar();

        marcaPage.clicarEditar();
        marcaPage.setMarca(nomeMarca + "edited");
        marcaPage.clicarConfirmar();

        marcaPage.setPesquisaMarca(nomeMarca + "edited");
        marcaPage.clicarFiltrar();

        Assert.assertEquals(nomeMarca + "edited", dsl.obterTexto(
                By.xpath("/html/body/app-root/app-container/main/div/app-marca/div[2]/table/tbody/tr/td[2]")
        ));
    }

    @Test
    public void test4InativarMarca(){
        marcaPage.setPesquisaMarca(nomeMarca + "edited");
        marcaPage.clicarFiltrar();

        marcaPage.clicarInativar();
        marcaPage.clicarConfirmarInativar();

        marcaPage.escolherRadio("filtro_status",false);
        marcaPage.clicarFiltrar();

        Assert.assertEquals(nomeMarca + "edited", dsl.obterTexto(
                By.xpath("/html/body/app-root/app-container/main/div/app-marca/div[2]/table/tbody/tr/td[2]")
        ));
    }
}