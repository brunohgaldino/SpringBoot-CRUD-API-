package com.example.postgresdemo.model;

import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "pessoas")

/*Classe com os atributos de Pessoa */
public class Pessoa  {
    
    @Id  
    private Long CPF;   
 
    
    @NotBlank
    @Size(min = 3, max = 100)
    private String nome;     
    

    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private java.sql.Date Data_Nasc;
    
    
    @Column(columnDefinition = "text")
    private String Rua;
    
    @Column(columnDefinition = "text")
    private String Bairro;

    public String getnome() {
        return nome;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    public Long getCPF() {
        return CPF;
    }

    public void setCPF(Long CPF) {
        this.CPF = CPF;
    }

    

    public String getRua() {
        return Rua;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }
    

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }
    
    public java.sql.Date getData_Nasc() {
        return Data_Nasc;
    }

    public void setData_Nasc(java.sql.Date Data_Nasc) {
        this.Data_Nasc = Data_Nasc;
    }
}
