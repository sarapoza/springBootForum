package br.com.alura.forum.controller.form;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
//import javax.validation.constraints.NotEmpty;

//essa classe funciona como um DTO para dados que serão ENVIADOS para a API
public class TopicoForm {

	@NotNull @NotEmpty @Length(min = 10)
	private String titulo;
	@NotNull @NotEmpty @Length(min = 30)
	private String mensagem;
	@NotNull @NotEmpty @Length(min = 10)
	private String nomeCurso;

	public TopicoForm() {
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public Topico converter(CursoRepository cursoRepository) {
		Curso curso = cursoRepository.findByNome(nomeCurso);
		return new Topico(titulo, mensagem, curso);
	}

}
