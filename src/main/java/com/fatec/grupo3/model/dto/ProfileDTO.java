package com.fatec.grupo3.model.dto;

public class ProfileDTO {
    private String username;
    private String email;
    private String cpf;
    private String password;
    private String name;
    private String lastname;

    public ProfileDTO(String username, String email, String cpf, String password, String name, String lastname) {
        this.username = username;
        this.email = email;
        this.cpf = cpf;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
