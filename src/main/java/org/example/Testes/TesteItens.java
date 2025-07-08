package org.example.Testes;

import org.example.DSL.DriverFactory;
import org.example.DSL.Dsl;
import org.example.PageObjects.ItensPage;
import org.example.PageObjects.LoginPage;
import org.example.PageObjects.SubItemPage;
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
public class TesteItens {

    private Dsl dsl;
    private static ItensPage itensPage = new ItensPage();
    private static LoginPage loginPage = new LoginPage();
    private static SubItemPage subItemPage = new SubItemPage();

    private String email = "anderson.flores@aluno.feliz.ifrs.edu.br";
    private String senha = "ABC123";

    @Before
    public void inicializar() {
        DriverFactory.getDriver().get("http://35.209.123.161/front");
        dsl = new Dsl();

        loginPage.setEmail(email);
        loginPage.setSenha(senha);
        loginPage.logar();
        itensPage.clicarItens();
    }

    @After
    public void finalizar(){
        DriverFactory.killDriver();
    }

    @Parameter
    public String nomeItem;
    @Parameter(value = 1)
    public String codigo;
    @Parameter(value = 2)
    public double valorMinimo;
    @Parameter(value = 3)
    public String nomeSubItem;
    @Parameter(value = 4)
    public String codigoSubItem;

    @Parameters
    public static Collection<Object[]> getCollection(){
        return Arrays.asList(new Object[][]{
                {"QWERTY"+(int) (Math.random() * 100001),"ASDFGH"+(int) (Math.random() * 100001), 1.0,
                        "ZXC"+(int) (Math.random() * 100001),"ASD"+(int) (Math.random() * 100001)},
                {"QWERTY"+(int) (Math.random() * 100001),"ASDFGH"+(int) (Math.random() * 100001), 5.5,
                        "ZXC"+(int) (Math.random() * 100001),"ASD"+(int) (Math.random() * 100001)}
        });
    }

    @Test
    public void test1_criarItem(){

        itensPage.clicarNovo();
        itensPage.setCodigo(codigo);
        itensPage.setNome(nomeItem);
        itensPage.escolherCategoria("CategoriaPlaceholder");
        itensPage.escolherUnidadeDeMedida("grama");
        itensPage.setObservacoes("É importante observar que essa observação é extremamente observativa sobre sua observabilidade...");
        itensPage.setValorMinimo(valorMinimo);
        itensPage.clicarSalvar();

        itensPage.clicarVoltar();
        itensPage.setFiltroNome(nomeItem);
        itensPage.setFiltroCodigo(codigo);
        itensPage.clicarFiltrar();

        Assert.assertEquals(nomeItem,dsl.obterTexto(
                By.xpath("/html/body/app-root/app-container/main/div/app-lista-elemento/div/table/tbody/tr/td[3]")
        ));

    }

    @Test
    public void test2_editarItem(){

        itensPage.setFiltroNome(nomeItem);
        itensPage.setFiltroCodigo(codigo);
        itensPage.clicarFiltrar();

        itensPage.clicarEditar();
        itensPage.setNome(nomeItem + "edited");
        itensPage.clicarSalvar();

        itensPage.clicarVoltar();
        itensPage.setFiltroNome(nomeItem + "edited");
        itensPage.setFiltroCodigo(codigo);
        itensPage.clicarFiltrar();

        Assert.assertEquals(nomeItem + "edited",dsl.obterTexto(
                By.xpath("/html/body/app-root/app-container/main/div/app-lista-elemento/div/table/tbody/tr/td[3]")
        ));
    }

    @Test
    public void test3_adicionarSubItem(){

        itensPage.setFiltroNome(nomeItem + "edited");
        itensPage.setFiltroCodigo(codigo);
        itensPage.clicarFiltrar();

        itensPage.clicarEditar();
        subItemPage.clicarSubItens();
        subItemPage.clicarNovoSubItem();

        subItemPage.setNomeCadastro(nomeSubItem);
        subItemPage.setCodigoCadastro(codigoSubItem);
        subItemPage.setLocal("teste");
        subItemPage.setMarca("teste");
        subItemPage.setQuantidade(1);
        subItemPage.setValidade("2025-07-30");
        subItemPage.clicarSalvar();

        subItemPage.clicarSalvarSubItems();

        subItemPage.clicarFiltrar();

        Assert.assertEquals(nomeSubItem, dsl.obterTexto(
                By.xpath("/html/body/app-root/app-container/main/div/app-cadastro-elemento/form/div[1]/div[2]/div/table/tbody/tr/td[3]")
        ));

    }

    @Test
    public void test4_inativarItem(){

        itensPage.setFiltroNome(nomeItem + "edited");
        itensPage.setFiltroCodigo(codigo);
        itensPage.clicarFiltrar();

        itensPage.clicarInativar();
        itensPage.clicarConfirmarInativar();

        Assert.assertEquals("Elemento inativado com sucesso!",dsl.obterTexto(
                By.xpath("/html/body/app-root/app-container/main/div/app-lista-elemento/p-toast/div/p-toastitem/div/div/div/div[2]")
        ));

    }

}
