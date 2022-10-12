package com.fatec.grupo3.model.entities;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class Login {

    private String login;
    private String password;

    public Login() {
    }

    public Login(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsernamePasswordAuthenticationToken convert() {
        return new UsernamePasswordAuthenticationToken(login, password);
    }
}
