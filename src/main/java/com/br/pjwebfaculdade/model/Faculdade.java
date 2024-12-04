package com.br.pjwebfaculdade.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "faculdade")
public class Faculdade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "faculdade", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<TelefoneFaculdade> telefones;

    @ManyToMany
    private List<Curso> cursos;

    public Faculdade() {
        super();
    }

    public Faculdade(Long id, String nome, String email) {
        super();
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefones(List<TelefoneFaculdade> telefones) {
        if(telefones != null) {
            for (TelefoneFaculdade telefone : telefones){
                telefone.setFaculdade(this);
            }
        }
        this.telefones = telefones;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
