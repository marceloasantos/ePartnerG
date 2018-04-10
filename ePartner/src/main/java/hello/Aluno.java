package hello;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Aluno {
    private String nome;
    private String email;
    private String senha;
    private Integer ra;
    private String curso;
    private List<MateriaAluno> materias = new LinkedList<MateriaAluno>();
    private LocalDate dataNasc;
    private int semestre;

    public Aluno(String nome, String email, String senha, Integer ra, String curso, LocalDate dataNasc, int semestre) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.ra = ra;
        this.curso = curso;
        this.dataNasc = dataNasc;
        this.semestre = semestre;
    }

    public int visualizarFaltas(String codDisciplina) {
        for (MateriaAluno materia:materias) {
            if (materia.getCodigoDisciplina().equals(codDisciplina)) return materia.getFalta();
        }
        return -1;
    }

    public double visualizarNotas(String codDisciplina) {
        for (MateriaAluno materia:materias) {
            if (materia.getCodigoDisciplina().equals(codDisciplina)) return materia.getNota();
        }
        return -1;
    }

    public void cadastrarMateriaAluno(MateriaAluno materia) { materias.add(materia); }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getRa() {
        return ra;
    }

    public void setRa(Integer ra) {
        this.ra = ra;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public List<MateriaAluno> getMaterias() {
        return materias;
    }

    public void setMaterias(List<MateriaAluno> materias) {
        this.materias = materias;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
}
