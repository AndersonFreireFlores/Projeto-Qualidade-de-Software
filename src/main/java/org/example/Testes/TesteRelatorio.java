package org.example.Testes;

import org.example.DSL.DriverFactory;
import org.example.DSL.Dsl;
import org.example.PageObjects.LoginPage;
import org.example.PageObjects.RelatorioPage;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;
import org.openqa.selenium.By;


public class TesteRelatorio {

    private Dsl dsl;
    private static LoginPage loginPage = new LoginPage();
    private static RelatorioPage relatorioPage = new RelatorioPage();

    private String email = "anderson.flores@aluno.feliz.ifrs.edu.br";
    private String senha = "ABC123";

    @Before
    public void inicializar() {
        DriverFactory.getDriver().get("http://35.209.123.161/front");
        dsl = new Dsl();

        loginPage.setEmail(email);
        loginPage.setSenha(senha);
        loginPage.logar();
        relatorioPage.clicarRelatorio();
    }
    @After
    public void finalizar(){
        DriverFactory.killDriver();
    }


    @Test
    public void testGerarRelatorioInvalido(){

        relatorioPage.setDataInicial("2025-07-07");

        relatorioPage.setCategoria("CategoriaPlaceholder");
        relatorioPage.clicarGerarRelatorio();

        Assert.assertEquals("Aviso\n" +
                "Necessário definir inicio e fim.", dsl.obterTexto(
                By.xpath("/html/body/app-root/app-container/main/div/app-relatorio/p-toast/div/p-toastitem")));
    }

}
