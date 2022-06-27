package model;

import java.util.List;
import java.util.Observable;

public class Setor extends Observable {
    String nome;
    String codigo;
    List<Paciente> pacientes;

    public Setor(String nome, String codigo, List<Paciente> pacientes) {
        this.nome = nome;
        this.codigo = codigo;
        this.pacientes = pacientes;
    }

    public void notificarMedicos() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Setor{" +
                "nome='" + nome + '\'' +
                ", codigo='" + codigo + '\'' +
                ", pacientes=" + pacientes +
                '}';
    }
}
