package br.edu.fatecfranca.apiDB.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // entidade de banco de dados
@Table(name="Jogo") // uma tabela
public class Jogo {
	
	// definiremos a chave primária auto-incremento
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="categoria")
	private String categoria;
	
	@Column(name="preco")
	private float preco;
	
	@Column(name="nota")
	private float nota;
	
	@Column(name="requisitos")
	private String requisitos;
	
	@Column(name="SO")
	private String SO;
	
	
	public Jogo() {
		
	}
	
	
	
	public Jogo(Long id, String nome, String categoria, float preco, float nota, String requisitos, String SO) {
		super();
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.preco = preco;
		this.nota = nota;
		this.requisitos = requisitos;
		this.SO = SO;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public float getNota() {
		return nota;
	}
	public void setNota(float nota) {
		this.nota = nota;
	}
	public String getRequisitos() {
		return requisitos;
	}
	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}
	public String getSO() {
		return SO;
	}
	public void setSO(String SO) {
		this.SO = SO;
	}
	@Override
	public String toString() {
		return "Jogo [id=" + id + ", nome=" + nome + ", categoria=" + categoria + ", preco=" + preco + ", nota=" + nota
				+ ", requisitos=" + requisitos + ", SO=" + SO + "]";
	}
	

	
}