package org.example.Testes;


import org.example.DSL.DriverFactory;
import org.example.DSL.Dsl;
import org.example.LocalPage;
import org.example.LoginPage;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteLocal {

    private Dsl dsl;
    private static LoginPage loginPage = new LoginPage();
    private static LocalPage localPage = new LocalPage();

    private String email = "anderson.flores@aluno.feliz.ifrs.edu.br";
    private String senha = "ABC123";

    @Before
    public void inicializar() {
        DriverFactory.getDriver().get("http://35.209.123.161/front");
        dsl = new Dsl();

        loginPage.setEmail(email);
        loginPage.setSenha(senha);
        loginPage.logar();
        localPage.clicarLocal();
    }

    @After
    public void finalizar(){
        DriverFactory.killDriver();
    }

    @Parameterized.Parameter
    public String nomeLocal;
    @Parameterized.Parameter(value = 1)
    public boolean valor;

    @Parameterized.Parameters
    public static Collection<Object[]> getCollection() {
        return Arrays.asList(new Object[][]{
                {"QWE"+(int) (Math.random() * 10001), true},
                {"QWE"+(int) (Math.random() * 10001), true}
        });
    }

    @Test
    public void test1CriarCategoria(){

        localPage.clicarNovo();
        localPage.setLocal(nomeLocal);
        localPage.clicarConfirmar();

        localPage.setPesquisaLocal(nomeLocal);
        localPage.clicarFiltrar();

        Assert.assertEquals(nomeLocal, dsl.obterTexto(
                By.xpath("/html/body/app-root/app-container/main/div/app-local/div[2]/table/tbody/tr/td[2]")));

    }

    @Test
    public void test2EditarCategoria(){

        localPage.setPesquisaLocal(nomeLocal);
        localPage.clicarFiltrar();

        localPage.clicarEditar();
        localPage.setLocal(nomeLocal + "edited");
        localPage.clicarConfirmar();

        localPage.setPesquisaLocal(nomeLocal + "edited");
        localPage.clicarFiltrar();

        Assert.assertEquals(nomeLocal + "edited", dsl.obterTexto(
                By.xpath("/html/body/app-root/app-container/main/div/app-local/div[2]/table/tbody/tr/td[2]")
        ));

    }

    @Test
    public void test3InativarCategoria(){

        localPage.setPesquisaLocal(nomeLocal + "edited");
        localPage.clicarFiltrar();

        localPage.clicarInativar();
        localPage.clicarConfirmarInativar();

        localPage.escolherRadio("filtro_status",false);
        localPage.clicarFiltrar();

        Assert.assertEquals(nomeLocal + "edited", dsl.obterTexto(
                By.xpath("/html/body/app-root/app-container/main/div/app-local/div[2]/table/tbody/tr/td[2]")
        ));
    }
}
