package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MedicoTest {

    @Test
    void deveNotificarUmMedico() {
        List<Paciente> pacientes = new ArrayList<>();
        pacientes.add(new Paciente("Emanuelly Mariane da Paz", "516.315.621-77", "Apresentou febre, náuseas, falta de ar e irritação na garganta."));
        pacientes.add(new Paciente("Pedro Manuel da Mota", "477.154.587-16", "Apresenta dor na região torácica e dores peito."));
        pacientes.add(new Paciente("Caio Raimundo Moura", "926.944.926-22", "Apresenta quadro de infecção de urina grave."));

        Setor setor = new Setor("Pronto Socorro 24h", "SE001", pacientes);

        Medico medico = new Medico("Leonardo Belga Ottoni Porto", "30646-MG");
        medico.iniciarExpediente(setor);

        setor.notificarMedicos();

        String resultadoEsperado = "Olá Leonardo Belga Ottoni Porto," +
                "Dados atualizados do Setor{" +
                "nome='Pronto Socorro 24h', " +
                "codigo='SE001', " +
                "pacientes=[" +
                "Paciente{nome='Emanuelly Mariane da Paz', cpf='516.315.621-77', prontuario='Apresentou febre, náuseas, falta de ar e irritação na garganta.'}, " +
                "Paciente{nome='Pedro Manuel da Mota', cpf='477.154.587-16', prontuario='Apresenta dor na região torácica e dores peito.'}, " +
                "Paciente{nome='Caio Raimundo Moura', cpf='926.944.926-22', prontuario='Apresenta quadro de infecção de urina grave.'}" +
                "]}";
        assertEquals(resultadoEsperado, medico.getUltimaNotificacao());
    }

    @Test
    void deveNotificarDoisMedicos() {
        List<Paciente> pacientes = new ArrayList<>();
        pacientes.add(new Paciente("Emanuelly Mariane da Paz", "516.315.621-77", "Apresentou febre, náuseas, falta de ar e irritação na garganta."));
        pacientes.add(new Paciente("Pedro Manuel da Mota", "477.154.587-16", "Apresenta dor na região torácica e dores peito."));
        pacientes.add(new Paciente("Caio Raimundo Moura", "926.944.926-22", "Apresenta quadro de infecção de urina grave."));

        Setor setor = new Setor("Pronto Socorro 24h", "SE001", pacientes);

        Medico medico1 = new Medico("Leonardo Belga Ottoni Porto", "30646-MG");
        Medico medico2 = new Medico("Paulo Roberto Rodrigues Bicalho", "30230-MG");
        medico1.iniciarExpediente(setor);
        medico2.iniciarExpediente(setor);

        setor.notificarMedicos();

        String resultadoEsperado1 = "Olá Leonardo Belga Ottoni Porto," +
                "Dados atualizados do Setor{" +
                "nome='Pronto Socorro 24h', " +
                "codigo='SE001', " +
                "pacientes=[" +
                "Paciente{nome='Emanuelly Mariane da Paz', cpf='516.315.621-77', prontuario='Apresentou febre, náuseas, falta de ar e irritação na garganta.'}, " +
                "Paciente{nome='Pedro Manuel da Mota', cpf='477.154.587-16', prontuario='Apresenta dor na região torácica e dores peito.'}, " +
                "Paciente{nome='Caio Raimundo Moura', cpf='926.944.926-22', prontuario='Apresenta quadro de infecção de urina grave.'}" +
                "]}";
        String resultadoEsperado2 = "Olá Paulo Roberto Rodrigues Bicalho," +
                "Dados atualizados do Setor{" +
                "nome='Pronto Socorro 24h', " +
                "codigo='SE001', " +
                "pacientes=[" +
                "Paciente{nome='Emanuelly Mariane da Paz', cpf='516.315.621-77', prontuario='Apresentou febre, náuseas, falta de ar e irritação na garganta.'}, " +
                "Paciente{nome='Pedro Manuel da Mota', cpf='477.154.587-16', prontuario='Apresenta dor na região torácica e dores peito.'}, " +
                "Paciente{nome='Caio Raimundo Moura', cpf='926.944.926-22', prontuario='Apresenta quadro de infecção de urina grave.'}" +
                "]}";

        assertEquals(resultadoEsperado1, medico1.getUltimaNotificacao());
        assertEquals(resultadoEsperado2, medico2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarMedico() {
        List<Paciente> pacientes = new ArrayList<>();
        pacientes.add(new Paciente("Emanuelly Mariane da Paz", "516.315.621-77", "Apresentou febre, náuseas, falta de ar e irritação na garganta."));
        pacientes.add(new Paciente("Pedro Manuel da Mota", "477.154.587-16", "Apresenta dor na região torácica e dores peito."));
        pacientes.add(new Paciente("Caio Raimundo Moura", "926.944.926-22", "Apresenta quadro de infecção de urina grave."));

        Setor setor = new Setor("Pronto Socorro 24h", "SE001", pacientes);
        Medico medico = new Medico("Leonardo Belga Ottoni Porto", "30646-MG");

        setor.notificarMedicos();
        assertNull(medico.getUltimaNotificacao());
    }

    @Test
    void notificarMedicoSetorProntoSocorro() {
        List<Paciente> pacientes1 = new ArrayList<>();
        pacientes1.add(new Paciente("Emanuelly Mariane da Paz", "516.315.621-77", "Apresentou febre, náuseas, falta de ar e irritação na garganta."));
        pacientes1.add(new Paciente("Pedro Manuel da Mota", "477.154.587-16", "Apresenta dor na região torácica e dores peito."));
        pacientes1.add(new Paciente("Caio Raimundo Moura", "926.944.926-22", "Apresenta quadro de infecção de urina grave."));

        List<Paciente> pacientes2 = new ArrayList<>();
        pacientes2.add(new Paciente("Renata Francisca Santos", "098.465.180-21", "O paciente apresenta dificuldade para respirar devido aos problemas cardiorrespiratórios."));
        pacientes2.add(new Paciente("Gabriela Antonella Carvalho", "322.835.837-21", "Paciente com quadro avançado de diabetes."));

        Setor setor1 = new Setor("Pronto Socorro 24h", "SE001", pacientes1);
        Setor setor2 = new Setor("Internação", "SE002", pacientes2);

        Medico medico1 = new Medico("Abilio de Castro Almeida", "53489-MG");
        Medico medico2 = new Medico("Adrianna Buzatti Viana", "71689-MG");
        medico1.iniciarExpediente(setor1);
        medico2.iniciarExpediente(setor2);

        setor1.notificarMedicos();

        String resultadoEsperado1 = "Olá Abilio de Castro Almeida," +
                "Dados atualizados do Setor{" +
                "nome='Pronto Socorro 24h', " +
                "codigo='SE001', " +
                "pacientes=[" +
                "Paciente{nome='Emanuelly Mariane da Paz', cpf='516.315.621-77', prontuario='Apresentou febre, náuseas, falta de ar e irritação na garganta.'}, " +
                "Paciente{nome='Pedro Manuel da Mota', cpf='477.154.587-16', prontuario='Apresenta dor na região torácica e dores peito.'}, " +
                "Paciente{nome='Caio Raimundo Moura', cpf='926.944.926-22', prontuario='Apresenta quadro de infecção de urina grave.'}" +
                "]}";

        assertEquals(resultadoEsperado1, medico1.getUltimaNotificacao());
        assertNull(medico2.getUltimaNotificacao());
    }
}