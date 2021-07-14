package com.example.projetosprint4.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Endereco {

    @Id
    private Long id;
    private String pais;
    private String estado;
    private String cidade;
    private String cep;
    private String rua;




}
