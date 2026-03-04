package br.edu.ifpe;

public class Prontuario {

    private String prescricao;
    private String medicamentos;
    private String antecedentesClinicos;
    private String antecedentesFamiliares;
    private String sintomas;
    private String diagnostico;
    private String dataAtendimento;

    public String getAntecedentesClinicos() {
        return antecedentesClinicos;
    }

    public void setAntecedentesClinicos(String antecedentesClinicos) {
        this.antecedentesClinicos = antecedentesClinicos;
    }

    public String getAntecedentesFamiliares() {
        return antecedentesFamiliares;
    }

    public void setAntecedentesFamiliares(String antecedentesFamiliares) {
        this.antecedentesFamiliares = antecedentesFamiliares;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(String dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }
}