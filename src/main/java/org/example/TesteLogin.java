package org.example;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.example.DSL.Dsl;
import org.example.DSL.DriverFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class TesteLogin {

    private Dsl dsl;
    private static LoginPage page = new LoginPage();

    @Parameter
    public String email;
    @Parameter(value = 1)
    public String senha;
    @Parameter(value = 2)
    public String localResposta;
    @Parameter(value = 3)
    public String resposta;

    @Before
    public void inicializar() {
        DriverFactory.getDriver().get("http://35.209.123.161/front");
        dsl = new Dsl();
    }

    @After
    public void finalizar(){
        DriverFactory.killDriver();
    }


    @Parameters
    public static Collection<Object[]> getCollection() {
        return Arrays.asList(new Object[][]{
                {"anderson.flores@aluno.feliz.ifrs.edu.br", "senha_incorreta", page.getPathMensagemSenhaIncorreta(), page.getMsgSenhaIncorreta()},
                {"anderson.flores@aluno.feliz.ifrs.edu.br", "123abc", page.getPathMensagemSenhaIncorreta(), page.getMsgSenhaIncorreta()}
        });
    }

    @Test
    public void testeSenhaIncorreta() throws IOException {
        page.setEmail(email);
        page.setSenha(senha);
        page.logar();
        Assert.assertEquals(resposta, dsl.obterTexto(By.xpath(localResposta)));
    }

    @Test
    public void testeCampoVazio() throws IOException {
        page.setEmail(email);
        page.logar();
        Assert.assertEquals("Um ou mais campos obrigatórios não preenchidos.",
                dsl.obterTexto(By.xpath(page.getPathMsgCampoVazio())));
    }

    @Test
    public void testeLoginFuncionando() throws IOException{
        page.setEmail(email);
        page.setSenha("ABC123");
        page.logar();

        dsl.wait(By.xpath("/html/body/app-root/app-header/header/div/a/img"));

        Assert.assertEquals("http://35.209.123.161/front/", dsl.obterUrl());
    }
}
