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

		Controller controller = new Controller(modelo);
		
		controller.buscarProfessor();
		controller.adicionarProfessor();
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
}
