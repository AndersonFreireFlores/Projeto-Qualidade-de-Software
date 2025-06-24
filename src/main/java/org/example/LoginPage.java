package org.example;

import org.example.DSL.Dsl;

public class LoginPage {

    private String msgSenhaIncorreta = "Usuário ou senha inválidos.";
    private String pathMsgCampoVazio = "/html/body/app-root/app-container/div/app-login/p-toast/div/p-toastitem/div/div/div/div[2]";
    private String pathMensagemSenhaIncorreta = "/html/body/app-root/app-container/div/app-login/div/div/div[2]/div/div";
    private String pathBotaoLogin = "/html/body/app-root/app-container/div/app-login/div/div/div[2]/div/form/button";
    private Dsl dsl = new Dsl();

    public void setEmail(String email) {
        dsl.escrever("email", email);
    }

    public void setSenha(String senha) {
        dsl.escrever("senha", senha);
    }

    public String getEmail() {
        return dsl.obterValorCampo("email");
    }

    public String getSenha() {
        return dsl.obterValorCampo("senha");
    }

    public String getPathMensagemSenhaIncorreta() {
        return pathMensagemSenhaIncorreta;
    }

    public String getPathBotaoLogin() {
        return pathBotaoLogin;
    }

    public String getMsgSenhaIncorreta() {
        return msgSenhaIncorreta;
    }

    public String getPathMsgCampoVazio(){
        return pathMsgCampoVazio;
    }

    public void logar() {
        dsl.clicarBotao(pathBotaoLogin);
    }
}
