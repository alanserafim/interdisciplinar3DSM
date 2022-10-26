package com.fatec.grupo3.model.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class ListaDTO {

    private Long id;

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
    private Integer ra;

    @NotNull
    @ApiModelProperty(value = "Curso que o Aluno está Matriculado")
    private String cursoMatriculado;

    @NotNull
    @ApiModelProperty(value = "Ano que o Aluno ingressou no curso Matriculado")
    private String anoIngresso;

    @NotNull
    @ApiModelProperty(value = "Periodo que o Aluno realiza o curso que está matriculado")
    private String periodo;
}
