package hello;

import java.time.LocalDate;
import java.time.LocalTime;

public class Aviso {
    private String descricao;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private LocalTime horarioInicial;
    private LocalTime horarioFinal;
    private String materia;

    public Aviso(String descricao, LocalDate dataInicial, LocalDate dataFinal, LocalTime horarioInicial, LocalTime horarioFinal, String materia) {
        this.descricao = descricao;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.horarioInicial = horarioInicial;
        this.horarioFinal = horarioFinal;
        this.materia = materia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public LocalTime getHorarioInicial() {
        return horarioInicial;
    }

    public void setHorarioInicial(LocalTime horarioInicial) {
        this.horarioInicial = horarioInicial;
    }

    public LocalTime getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(LocalTime horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    public String getMateria() { return materia; }

    public void setMateria(String materia) { this.materia = materia; }
}
