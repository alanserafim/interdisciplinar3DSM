package com.fatec.grupo3.model.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class ProfileDTO {
    private String username;
    private String email;
    private String cpf;
    private String password;
    private String name;
    private String lastname;
    private String dtNascimento;
    private Integer ra;
    private String cursoMatriculado;
    private String anoIngresso;
    private String periodo;
    private List<MatriculaDTO> matriculas;
    private List<CursoDTO> cursos;

    public ProfileDTO(String username, String email, String cpf, String password, String name, String lastname,
			String dtNascimento, Integer ra, String cursoMatriculado, String anoIngresso, String periodo,
			List<MatriculaDTO> matriculas, List<CursoDTO> cursos) {
		super();
		this.username = username;
		this.email = email;
		this.cpf = cpf;
		this.password = password;
		this.name = name;
		this.lastname = lastname;
		this.dtNascimento = dtNascimento;
		this.ra = ra;
		this.cursoMatriculado = cursoMatriculado;
		this.anoIngresso = anoIngresso;
		this.periodo = periodo;
		this.matriculas = matriculas;
		this.cursos = cursos;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}



	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}



	public Integer getRa() {
		return ra;
	}



	public void setRa(Integer ra) {
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



	public List<MatriculaDTO> getMatriculas() {
		return matriculas;
	}



	public void setMatriculas(List<MatriculaDTO> matriculas) {
		this.matriculas = matriculas;
	}



	public List<CursoDTO> getCursos() {
		return cursos;
	}



	public void setCursos(List<CursoDTO> cursos) {
		this.cursos = cursos;
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
