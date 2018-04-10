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
}
