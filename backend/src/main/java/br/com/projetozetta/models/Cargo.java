package br.com.projetozetta.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@Table(uniqueConstraints={@UniqueConstraint(columnNames="nome")})
public class Cargo implements Serializable {

    //Geração do ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    //Atributos de Cargo
    private int idCargo;

    @Column(nullable = false, unique = true)
    private String nome;

    //Métodos de Cargo
    public int getId(){
        return idCargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
