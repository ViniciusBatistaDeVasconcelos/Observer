package model;

import java.util.Observable;
import java.util.Observer;

public class Medico implements Observer {
    private String nome;
    private String crm;
    private String ultimaNotificacao;

    public Medico(String nome, String crm) {
        this.nome = nome;
        this.crm = crm;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void iniciarExpediente(Setor setor) {
        setor.addObserver(this);
    }

    @Override
    public void update(Observable setor, Object arg1) {
        this.ultimaNotificacao = "Olá " + this.nome + "," +
                "Dados atualizados do " + setor.toString();
    }
}
