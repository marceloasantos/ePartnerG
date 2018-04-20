package hello;

import java.util.LinkedList;
import java.util.List;

public class Modelo {
    private List<Professor> professores = new LinkedList<Professor>();
    private List<Aluno> alunos = new LinkedList<Aluno>();
    private List<Curso> cursos = new LinkedList<Curso>();
    private List<Aviso> avisos = new LinkedList<Aviso>();
    private List<Funcionario> funcionarios = new LinkedList<Funcionario>();
    
    public List<Professor> buscarProfessorSS(String termo) {
    	List<Professor> professoresEncontrados = new LinkedList<>();
    	for (Professor professor : professores) {
    		if (professor.toString().contains(termo)) {
    			professoresEncontrados.add(professor);
    		}
    	}
    	return professoresEncontrados;
    }
    
    public List<Aluno> buscarAluno(String termo) {
    	List<Aluno> alunosEncontrados = new LinkedList<>();
    	for (Aluno aluno : alunos) {
    		if (aluno.toString().toLowerCase().contains(termo)) {
    			alunosEncontrados.add(aluno);
    		}
    	}
    	return alunosEncontrados;
    }
    
    public void removerAluno(String ra) {
    	for (int i = 0; i < alunos.size(); i++) {
    	    if (alunos.get(i).getRa().equals(ra)) {
    	      alunos.remove(i);
    		}
    	}
    }

    @Override
	public String toString() {
		return "Modelo [professores=" + professores + ", alunos=" + alunos + ", cursos=" + cursos + ", avisos=" + avisos
				+ ", funcionarios=" + funcionarios + "]";
	}

	public int buscarFaltas(int ra, String codDisciplina) {
        int faltas = 0;
        for (Aluno aluno : alunos) {
            if (aluno.getRa().equals(ra)) {
                faltas = aluno.visualizarFaltas(codDisciplina);
            }
        }
        return faltas;
    }

    public double buscarNotas(int ra, String codDisciplina) {
        double notas = 0;
        for (Aluno aluno : alunos) {
            if (aluno.getRa().equals(ra)) {
                notas = aluno.visualizarNotas(codDisciplina);
            }
        }
        return notas;
    }

    public Aviso visualizarAviso(String codDisciplina) {
        for (Aviso aviso: avisos) {
            if (aviso.getMateria().equals(codDisciplina)) { return aviso; }
        }
        return null;
    }

    public Aluno isAlunoAvaiable(String email, String ra) {
        for (Aluno aluno : alunos) {
            if (aluno.getRa().equals(ra) ||  aluno.getEmail().equals(email)) {
            	removerAluno(ra);
            	return null;
            }
        }
        return null;
    }

    public boolean isProfessorAvaiable(String email, int matricula) {
        for (Professor professor : professores) {
            if (professor.getMatricula() == matricula && professor.getEmail().equals(email)) return false;
        }
        return true;
    }

    public boolean isFuncionarioAvaiable(String email, int matricula) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getMatricula() == matricula && funcionario.getEmail().equals(email)) return false;
        }
        return true;
    }

    public boolean isCursoAvaiable(String nome) {
        for (Curso curso : cursos) {
            if (curso.getNome().equals(nome)) return false;
        }
        return true;
    }

    public void cadastrarAluno(Aluno aluno1) {
        if (isAlunoAvaiable(aluno1.getEmail(), aluno1.getRa()) == null) {
        	alunos.add(aluno1);
        }
    }

    public void cadastrarProfessor(Professor professor) {
        if (isProfessorAvaiable(professor.getEmail(), professor.getMatricula())) professores.add(professor);
    }

    public void cadastrarCurso(Curso curso) {
        if (isCursoAvaiable(curso.getNome())) cursos.add(curso);
    }

    public void cadastrarAviso(Aviso aviso) {
        avisos.add(aviso);
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        if (isFuncionarioAvaiable(funcionario.getEmail(), funcionario.getMatricula())) funcionarios.add(funcionario);
    }
    
    public void removerProfessor(Integer matricula) {
    	for (int i = 0; i < professores.size(); i++) {
    		if (professores.get(i).getMatricula() == matricula) professores.remove(i);
    	}
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Curso> getCurso() {
        return cursos;
    }

    public void setCurso(List<Curso> curso) {
        this.cursos = curso;
    }

    public List<Aviso> getAvisos() {
        return avisos;
    }

    public void setAvisos(List<Aviso> avisos) {
        this.avisos = avisos;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
