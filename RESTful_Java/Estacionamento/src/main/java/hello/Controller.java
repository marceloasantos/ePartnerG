package hello;

import static spark.Spark.get;

import java.util.List;

import com.google.gson.Gson;

public class Controller {
	
	private Model model;
	
	
	public Controller(Model model){
		this.model = model;
	}
	
	public void buscarCarro(){
		get("/carro/:modelo/:marca/:cor", (req, res) -> {
		
			Especificacao espec = new Especificacao(req.params(":modelo"), req.params(":marca"), req.params(":cor"));	
			List<Carro> carrosEncontrados = model.buscarEspecificacao(espec);	
			return new Gson().toJson(carrosEncontrados);			
		});
	}
		
	public void buscarPlaca(){
		get("/carro/:placa", (req, res) -> {
		
			Carro car = new Carro(req.params(":placa"), null);	
			List<Carro> carrosEncontrados = model.buscarPlaca(car);	
			return new Gson().toJson(carrosEncontrados);
		});
	}
}
