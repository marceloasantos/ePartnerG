package hello;

import static spark.Spark.get;

import java.util.List;

import com.google.gson.Gson;

public class Controller {

	private Modelo modelo;

	public Controller(Modelo modelo) {
		this.modelo = modelo;
	}

	public void buscarProfessor() {
		get("/professor/:matricula", (req, res) -> {

			// int matricula = Integer.parseInt(req.params(":matricula"));
			String termo = req.params(":matricula");
			List<Professor> professoresEncontrados = modelo.buscarProfessorSS(termo);
			return new Gson().toJson(professoresEncontrados);
		});
	}

	public void adicionarProfessor() {
		get("/professor/:c_matricula/:c_nome_completo/:c_email/:c_senha", (req, res) -> {
			Integer c_matricula = Integer.parseInt(req.params(":c_matricula"));
			String c_nome_completo = req.params(":c_nome_completo");
			String c_email = req.params(":c_email");
			String c_senha = req.params(":c_senha");
			modelo.cadastrarProfessor(new Professor(c_nome_completo, c_email, c_senha, c_matricula));
			return null;
		});
	}

	public void removerProfessor() {
		get("/professor/:e_email/:e_matricula", (req, res) -> {
			Integer e_matricula = Integer.parseInt(req.params(":e_matricula"));
			modelo.removerProfessor(e_matricula);
			return null;
		});
	}
	
		public void buscarAluno() {
		get("/aluno/:ra", (req, res) -> {
		
			//int ra = Integer.parseInt(req.params(":ra"));
			String termo = req.params(":ra");
			List<Aluno> alunosEncontrados = modelo.buscarAluno(termo);
			return new Gson().toJson(alunosEncontrados);			
		});
	}
	
	public void removerAluno() {
		get("/aluno/remover/:ra", (req, res) -> {
		
			String termo = req.params(":ra");
			modelo.removerAluno(termo);
			return "removido";			
		});
	}
	
	public void adicionarAluno() {
		get("/aluno/:c_ra/:c_nome_completo/:c_email/:c_senha/:c_curso/:c_data_nasc/:c_semestre/", (req, res) -> {
			
			
			String c_ra = (req.params(":c_ra"));
			String c_nome_completo = req.params(":c_nome_completo");
			String c_email = req.params(":c_email");
			String c_senha = req.params(":c_senha");
			String c_curso = req.params(":c_curso");
			String c_data_nasc = req.params(":c_data_nasc");
			int c_semestre = Integer.parseInt(req.params(":c_semestre"));
			
			modelo.cadastrarAluno(new Aluno(c_nome_completo,c_email, c_senha, c_ra, c_curso, c_data_nasc, c_semestre));
			return null;
			
		}); 
	}
}
