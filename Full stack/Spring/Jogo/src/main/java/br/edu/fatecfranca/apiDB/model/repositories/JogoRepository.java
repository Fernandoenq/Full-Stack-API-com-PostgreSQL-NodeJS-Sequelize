package br.edu.fatecfranca.apiDB.model.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.fatecfranca.apiDB.model.Jogo;

// a classe interface vai herdar todos os métodos de CRUD do JpaRepository
// os métodos CRUD são de inserção, remoção, atualização e consulta
// os métodos funcionarão especificamente para a classe Pokemon
public interface JogoRepository extends JpaRepository<Jogo, Long>{
	// implicitamente, temos todos os métodos de banco de dados
	// com a classe Pokemon
}