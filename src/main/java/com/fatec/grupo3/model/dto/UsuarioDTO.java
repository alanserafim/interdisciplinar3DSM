package com.fatec.grupo3.model.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class UsuarioDTO {

    @NotNull
    @ApiModelProperty(value = "Username")
    private String username;

    @Email(message = "Insira um email valido")
    @Pattern(regexp=".+@.+\\..+", message="Insira um email valido")
    @NotNull
    @ApiModelProperty(value = "Email")
    private String email;

    @CPF
    @NotNull
    @ApiModelProperty(value = "CPF")
    private String cpf;

    @Size(min = 8, message = "A senha deve ter no minimo 8 caracteres.")
    @NotNull
    @ApiModelProperty(value = "Senha")
    private String password;

    @NotNull
    @ApiModelProperty(value = "Nome")
    private String name;

    @NotNull
    @ApiModelProperty(value = "Sobrenome")
    private String lastname;

    @ApiModelProperty(value = "Papeis ou funções: ALUNOS ou INSTRUTORES")
    private List<String> roles;
    
    
    @NotNull
    @ApiModelProperty(value = "Data de Nascimento")
    private String dtNascimento;
    
    @NotNull
    @ApiModelProperty(value = "Ra do Aluno")
    private Long ra;

    @NotNull
    @ApiModelProperty(value = "Curso que o Aluno está Matriculado")
    private String cursoMatriculado;
    
    @NotNull
    @ApiModelProperty(value = "Ano que o Aluno ingressou no curso Matriculado")
    private String anoIngresso;
    
    @NotNull
    @ApiModelProperty(value = "Periodo que o Aluno realiza o curso que está matriculado")
    private String periodo;



    public UsuarioDTO(@NotNull String username,
                      @Email(message = "Insira um email valido") @Pattern(regexp = ".+@.+\\..+", message = "Insira um email valido") @NotNull String email,
                      @CPF @NotNull String cpf,
                      @Size(min = 8, message = "A senha deve ter no minimo 8 caracteres.") @NotNull String password,
                      @NotNull String name, @NotNull String lastname, List<String> roles, @NotNull String dtNascimento,
                      @NotNull Long ra, @NotNull String cursoMatriculado, @NotNull String anoIngresso,
                      @NotNull String periodo) {
		super();
		this.username = username;
		this.email = email;
		this.cpf = cpf;
		this.password = password;
		this.name = name;
		this.lastname = lastname;
		this.roles = roles;
		this.dtNascimento = dtNascimento;
		this.ra = ra;
		this.cursoMatriculado = cursoMatriculado;
		this.anoIngresso = anoIngresso;
		this.periodo = periodo;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}



	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}



	public Long getRa() {
		return ra;
	}



	public void setRa(Long ra) {
		this.ra = ra;
	}



	public String getCursoMatriculado() {
		return cursoMatriculado;
	}



	public void setCursoMatriculado(String cursoMatriculado) {
		this.cursoMatriculado = cursoMatriculado;
	}



	public String getAnoIngresso() {
		return anoIngresso;
	}



	public void setAnoIngresso(String anoIngresso) {
		this.anoIngresso = anoIngresso;
	}



	public String getPeriodo() {
		return periodo;
	}



	public void setPeriodo(String periodo) {
		this.periodo = periodo;
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

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
