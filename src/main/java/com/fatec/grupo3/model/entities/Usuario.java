package com.fatec.grupo3.model.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Entity
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String dtNascimento;
    
    @Column(nullable = true)
    private Long ra;
    
    @Column(nullable = true)
    private String cursoMatriculado;
    
    @Column(nullable = true)
    private String anoIngresso;
    
    
    @Column(nullable = false)
    private String periodo;
    
    @Column(nullable = false)
    private String lastname;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "roles_id")
    private List<String> roles;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<Matricula> matriculas;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<Curso> cursos;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = Arrays.asList(new SimpleGrantedAuthority(roles.stream().toString()));

        return authorityList;
    }

    public Usuario() {
    }

    public Usuario(Long userId, String username, String email, String cpf, String password, String name,
			String dtNascimento, Long ra, String cursoMatriculado, String anoIngresso, String periodo,
			String lastname, List<String> roles, List<Matricula> matriculas, List<Curso> cursos) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.cpf = cpf;
		this.password = password;
		this.name = name;
		this.dtNascimento = dtNascimento;
		this.ra = ra;
		this.cursoMatriculado = cursoMatriculado;
		this.anoIngresso = anoIngresso;
		this.periodo = periodo;
		this.lastname = lastname;
		this.roles = roles;
		this.matriculas = matriculas;
		this.cursos = cursos;
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

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
