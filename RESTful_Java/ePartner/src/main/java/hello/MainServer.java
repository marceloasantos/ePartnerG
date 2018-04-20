package hello;

import static spark.Spark.*;

import java.util.List;
import java.util.LinkedList;


public class MainServer {
	
	final static Modelo modelo = new Modelo();
	
    public static void main(String[] args) {

		// Get port config of heroku on environment variable
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 8081;
        }
        port(port);

		//Servir conteudo html, css e javascript
		staticFileLocation("/static");

		inicializarProfessor();
		inicializarAluno();

		Controller controller = new Controller(modelo);
		
		controller.buscarProfessor();
		controller.adicionarProfessor();
		controller.removerProfessor();
		controller.buscarAluno();
		controller.adicionarAluno();	
		controller.removerAluno();
		
    }
    
    public static void inicializarProfessor(){
    	List<String> disciplinas1 = new LinkedList<>();
    	List<String> disciplinas2 = new LinkedList<>();
    	List<String> disciplinas3 = new LinkedList<>();
    	
    	disciplinas1.add("Algoritmos");
    	disciplinas1.add("LP II");
    	disciplinas2.add("Eng. Software");
    	disciplinas2.add("Lab III");
    	disciplinas3.add("Estruturas de dados");
    	
    	modelo.cadastrarProfessor(new Professor("Giuliano", "giuliano.bertotti@fatec.com", "123qwe", 12345));
    	modelo.cadastrarProfessor(new Professor("Nadalete", "lucas.nadalete@fatec.com", "123qwe", 12346));
    	modelo.cadastrarProfessor(new Professor("Sakaue", "eduardo.sakaue@fatec.com", "123qwe", 12347));
    	
    	modelo.getProfessores().get(0).setDisciplinas(disciplinas1);
    	modelo.getProfessores().get(1).setDisciplinas(disciplinas2);
    	modelo.getProfessores().get(2).setDisciplinas(disciplinas3);
    }
    
    public static void inicializarAluno(){

    	
    	modelo.cadastrarAluno(new Aluno("Ana Claudia Lourenço de Amorim Cirineu", "ana.cirineu@fatec.sp.gov.br", "123@na", "201812345", "Tecnologia em Banco de Dados", "30/11/1990", 3));
    	modelo.cadastrarAluno(new Aluno("Vinícius Oliveira", "vinicius@fatec.sp.gov.br", "xxxxx", "222222", "Tecnologia em Banco de Dados", "12/12/1988" , 4));
    	modelo.cadastrarAluno(new Aluno("Marcelo Augusto oliveira", "marcelou@fatec.sp.gov.br", "z1z1z1", "3333333", "Logistica", "10/01/1987", 3));
	
    }
}
