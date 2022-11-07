package com.fatec.grupo3.model.dto;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginDTO {

    @ApiModelProperty(value = "Email ou username")
    private String login;

    @ApiModelProperty(value = "Senha")
    private String password;

    public LoginDTO() {
    }

    public LoginDTO(String login, String password) {
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
