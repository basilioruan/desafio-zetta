package br.com.projetozetta.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Usuario  extends Pessoa{

    @ManyToOne
    private Cargo cargo;

    @ManyToMany
    private List<Perfil> perfis;

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(List<Perfil> perfis) {
        this.perfis = perfis;
    }
}
