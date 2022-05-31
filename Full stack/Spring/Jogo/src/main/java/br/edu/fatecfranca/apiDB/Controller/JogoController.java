package br.edu.fatecfranca.apiDB.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecfranca.apiDB.model.Jogo;
import br.edu.fatecfranca.apiDB.model.repositories.JogoRepository;

@RestController
public class JogoController {

	// vamos criar um objeto que usufrui da injeção de
	// dependência, pois objeto usa métodos sem instanciá-lo
	@Autowired
	JogoRepository injecao;
	
	
	// lista os pokemons cadastrados no banco de dados
	@GetMapping("/jogo")
	@CrossOrigin(origins="*")
	public List<Jogo> get(){
		return injecao.findAll();
	}
	
	@PostMapping("/jogo")
	@CrossOrigin(origins="*")
	public Jogo add(@RequestBody Jogo jogo) {
		Jogo novo = injecao.save(jogo);
		return novo;
		
	}
	
	@DeleteMapping("/jogo/{id}")
	@CrossOrigin(origins="*")
	public String remove(@PathVariable Long id) {
		try {
			injecao.deleteById(id);
			return "Remoção realizada com sucesso";
		}
		catch(Exception e) {
			return "Nada para remover";
		}
	}
	
	@PutMapping("/jogo")
	@CrossOrigin(origins="*")
	public Jogo put(@RequestBody Jogo jogo) {
		Jogo atual = injecao.save(jogo); // como o pokemon tem id, o save atualiza
		return atual;
	}
	
}
