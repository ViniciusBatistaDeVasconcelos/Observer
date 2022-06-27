package model;

public class Paciente {
    private String nome;
    private String cpf;
    private String prontuario;

    public Paciente(String nome, String cpf, String prontuario) {
        this.nome = nome;
        this.cpf = cpf;
        this.prontuario = prontuario;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", prontuario='" + prontuario + '\'' +
                '}';
    }
}
