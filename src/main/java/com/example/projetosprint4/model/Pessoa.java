package com.example.projetosprint4.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.ArrayList;

@Entity
public class Pessoa {

    @Id
    private Long id;

    private BigDecimal cpf;

    private BigDecimal salario;

    private String sexo;

    @OneToMany
    private ArrayList<Endereco> endereco;
}
