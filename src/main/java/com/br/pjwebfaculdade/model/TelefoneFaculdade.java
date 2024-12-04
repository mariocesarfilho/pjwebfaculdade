package com.br.pjwebfaculdade.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class TelefoneFaculdade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private String numero;

    @Basic
    private Boolean whatsapp;

    @ManyToOne
    @JsonBackReference
    private Faculdade faculdade;

    public TelefoneFaculdade() {
        super();
    }

    public TelefoneFaculdade(Long id) {
        this.id = id;
    }

    public TelefoneFaculdade(String numero) {
        this.numero = numero;
    }

    public TelefoneFaculdade(Long id, String numero, Faculdade faculdade) {
        this.id = id;
        this.numero = numero;
        this.faculdade = faculdade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Boolean getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(Boolean whatsapp) {
        this.whatsapp = whatsapp;
    }

    public Faculdade getFaculdade() {
        return faculdade;
    }

    public void setFaculdade(Faculdade faculdade) {
        this.faculdade = faculdade;
    }
}
